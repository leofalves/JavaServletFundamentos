package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newOrg")
public class NewOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("Cadastrando Empresa");
		
		String orgName = request.getParameter("OrgName");
		String paramOpeningDate = request.getParameter("OpeningDate");
		Date openingDate = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			openingDate = sdf.parse(paramOpeningDate);
		} catch (ParseException e) {
			//e.printStackTrace();
			throw new ServletException(e);
		}


		Organization org = new Organization();
		org.setName(orgName);
		org.setOpeningDate(openingDate);
		BancoDados bd = new BancoDados();
		bd.add(org);

		response.sendRedirect("listOrg");
		
		//RequestDispatcher rd = request.getRequestDispatcher("/newOrgCreated.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("/listOrg");
		//request.setAttribute("orgName", org.getName());
		//rd.forward(request, response);
	}

}
