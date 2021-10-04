package br.com.leofalves.gerenciadortc9.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.leofalves.gerenciadortc9.model.BancoDados;
import br.com.leofalves.gerenciadortc9.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BancoDados bd = new BancoDados();
		Usuario user = bd.existeUsuario(login, senha);
		
		if (user != null) {
			System.out.println("Usuário logado: " +  login);
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", user);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
	}

}
