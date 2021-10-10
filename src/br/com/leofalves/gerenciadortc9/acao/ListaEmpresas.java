package br.com.leofalves.gerenciadortc9.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leofalves.gerenciadortc9.model.BancoDados;
import br.com.leofalves.gerenciadortc9.model.Organization;

public class ListaEmpresas implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoDados bd = new BancoDados();
		List<Organization> lista = bd.getOrganizations();
		
		request.setAttribute("organizations", lista);
		//RequestDispatcher rd = request.getRequestDispatcher("/listOrg.jsp");
		//rd.forward(request, response);
	
		return "forward:/listOrg.jsp";
	}

}
