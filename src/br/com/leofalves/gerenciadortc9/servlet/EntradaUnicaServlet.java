package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.leofalves.gerenciadortc9.acao.Acao;

@WebServlet("/entrada")
public class EntradaUnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAction = request.getParameter("acao");
		String retAcao = null;
		String nomeDaClasse = "br.com.leofalves.gerenciadortc9.acao." + paramAction;
		
		
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
		
		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		
		try {
			// Design Pattern: Command (Classes com métodos únicos que executam uma ação ou comando)
			Class classe = Class.forName(nomeDaClasse); // Carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance(); // faz o Cast para a Interface Acao
			retAcao = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} 
		
		String[] tipoEEndereco = retAcao.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view" + tipoEEndereco[1]);
			rd.forward(request, response);			
		} else {
			response.sendRedirect(tipoEEndereco[1]);			
		}
	}

}
