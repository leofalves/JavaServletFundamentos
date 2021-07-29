package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leofalves.gerenciadortc9.model.BancoDados;
import br.com.leofalves.gerenciadortc9.model.Organization;


//@WebServlet("/mostraOrg")
public class MostraOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer OrgId = Integer.valueOf(request.getParameter("id"));
		
		BancoDados bd = new BancoDados();
		Organization org = bd.findOrgById(OrgId);
		
		request.setAttribute("org", org);
		RequestDispatcher rd = request.getRequestDispatcher("/formEditOrg.jsp");
		rd.forward(request, response);
	}

}
