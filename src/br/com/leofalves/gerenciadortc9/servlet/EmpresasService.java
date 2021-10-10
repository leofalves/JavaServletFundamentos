package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.leofalves.gerenciadortc9.model.BancoDados;
import br.com.leofalves.gerenciadortc9.model.Organization;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDados bd = new BancoDados();
		List<Organization> lista = bd.getOrganizations();
		
		String valor = request.getHeader("Accept");
		System.out.println(valor);
		
		if(valor.contains("xml")) {
			
			// ** Retornando XML
			XStream xstream = new XStream();
			xstream.alias("empresa", Organization.class);
			String xml = xstream.toXML(lista);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
			
		} else if(valor.endsWith("json")) {
			
			// ** Retornando Json
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			response.setContentType("application/json");
			response.getWriter().print(json);			
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message': 'no-content'}");
		}
	}
}
