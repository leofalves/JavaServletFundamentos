package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listOrg")
public class ListOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDados bd = new BancoDados();
		List<Organization> lista = bd.getOrganizations();
		
		request.setAttribute("organizations", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/listOrg.jsp");
		rd.forward(request, response);

	}

	
}