package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leofalves.gerenciadortc9.acao.Acao;

@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		//Cast de um objeto mais generico (ServletRequest) para um mais específico (HttpServletRequest). Para ter o método getSession()
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		
		String paramAction = request.getParameter("acao");
		String retAcao = null;
		String nomeDaClasse = "br.com.leofalves.gerenciadortc9.acao." + paramAction;
		
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
