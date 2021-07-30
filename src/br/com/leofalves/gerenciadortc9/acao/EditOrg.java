package br.com.leofalves.gerenciadortc9.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leofalves.gerenciadortc9.model.BancoDados;
import br.com.leofalves.gerenciadortc9.model.Organization;

public class EditOrg implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer OrgId = Integer.valueOf(request.getParameter("id"));
		String orgName = request.getParameter("OrgName");
		String paramOpeningDate = request.getParameter("OpeningDate");
		Date openingDate = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			openingDate = sdf.parse(paramOpeningDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		BancoDados bd = new BancoDados();
		Organization org = bd.findOrgById(OrgId);
		org.setName(orgName);
		org.setOpeningDate(openingDate);
		
		//response.sendRedirect("entrada?acao=ListOrg");
		return "redirect:entrada?acao=ListaEmpresas";

	}

}
