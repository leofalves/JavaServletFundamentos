package br.com.leofalves.gerenciadortc9.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leofalves.gerenciadortc9.model.BancoDados;
import br.com.leofalves.gerenciadortc9.model.Organization;

public class ShowOrg {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer OrgId = Integer.valueOf(request.getParameter("id"));
		
		BancoDados bd = new BancoDados();
		Organization org = bd.findOrgById(OrgId);
		
		request.setAttribute("org", org);
		//RequestDispatcher rd = request.getRequestDispatcher("/formEditOrg.jsp");
		//rd.forward(request, response);
		return "forward:/formEditOrg.jsp";

	}
}
