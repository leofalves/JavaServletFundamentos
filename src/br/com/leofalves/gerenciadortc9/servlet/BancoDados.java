package br.com.leofalves.gerenciadortc9.servlet;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {
private static List<Organization> lista = new ArrayList<>();
	
	static {
		Organization org1 = new Organization(1, "Um clique Informática");
		Organization org2 = new Organization(2, "Dois clique Informática");
		
		BancoDados.lista.add(org1);
		BancoDados.lista.add(org2);
	}
	
	public void add(Organization org) {
		BancoDados.lista.add(org);
	}
	
	public List<Organization> getOrganizations(){
		return BancoDados.lista;
	}
}
