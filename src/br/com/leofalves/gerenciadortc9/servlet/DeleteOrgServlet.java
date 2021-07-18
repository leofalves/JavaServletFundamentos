package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteOrg")
public class DeleteOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer OrgId = Integer.valueOf(request.getParameter("id"));
		
		BancoDados bd = new BancoDados();
		bd.delete(OrgId);
		
		response.sendRedirect("listOrg");
	}
}
