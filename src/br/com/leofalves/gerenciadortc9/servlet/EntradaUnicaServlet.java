package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leofalves.gerenciadortc9.acao.DeletaOrg;
import br.com.leofalves.gerenciadortc9.acao.EditOrg;
import br.com.leofalves.gerenciadortc9.acao.ListaEmpresas;
import br.com.leofalves.gerenciadortc9.acao.NewOrg;
import br.com.leofalves.gerenciadortc9.acao.NewOrgForm;
import br.com.leofalves.gerenciadortc9.acao.ShowOrg;

@WebServlet("/entrada")
public class EntradaUnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAction = request.getParameter("acao");
		String retAcao = null;
		
		if (paramAction.equals("ListaEmpresas")) {
			System.out.println("Listando as organizacoes a partir da entrada única...");
			ListaEmpresas acao = new ListaEmpresas();
			retAcao = acao.executa(request, response);
			
		} else if (paramAction.equals("DeletaOrg")) {
			System.out.println("Deletando organização a partir da entrada única...");
			DeletaOrg acao = new DeletaOrg();
			retAcao = acao.executa(request, response);
			
		} else if (paramAction.equals("EditOrg")) {
			System.out.println("Editando organização a partir da entrada única...");
			EditOrg acao = new EditOrg();
			retAcao = acao.executa(request, response);
			
		} else if (paramAction.equals("ShowOrg")) {
			System.out.println("Exibindo organização a partir da entrada única...");
			ShowOrg acao = new ShowOrg();
			retAcao = acao.executa(request, response);
		
		} else if (paramAction.equals("NewOrg")) {
			System.out.println("Incluindo organização a partir da entrada única...");
			NewOrg acao = new NewOrg();
			retAcao = acao.executa(request, response);
			
		} else if (paramAction.equals("NewOrgForm")) {
			System.out.println("Chamando o Form JSP para incluir uma organização a partir da entrada única...");
			NewOrgForm acao = new NewOrgForm();
			retAcao = acao.executa(request, response);
		
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
