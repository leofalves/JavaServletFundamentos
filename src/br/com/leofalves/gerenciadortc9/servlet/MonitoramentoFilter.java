package br.com.leofalves.gerenciadortc9.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		// Checando o tempo de execução
		long antes = System.currentTimeMillis();
		
		String paramAction = request.getParameter("acao");
		
		// Executa a acao
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();		
		System.out.println("Tempo decorrido (acao=" + paramAction +"): " + (depois - antes));

		
	}

}
