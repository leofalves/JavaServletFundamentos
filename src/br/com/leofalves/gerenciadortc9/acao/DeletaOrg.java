package br.com.leofalves.gerenciadortc9.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leofalves.gerenciadortc9.model.BancoDados;

public class DeletaOrg implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer OrgId = Integer.valueOf(request.getParameter("id"));
		
		BancoDados bd = new BancoDados();
		bd.delete(OrgId);
		
		//response.sendRedirect("entrada?acao=ListOrg");
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
