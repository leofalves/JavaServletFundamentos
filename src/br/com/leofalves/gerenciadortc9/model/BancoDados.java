package br.com.leofalves.gerenciadortc9.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDados {
	private static List<Organization> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Organization org1 = new Organization();
		org1.setId(BancoDados.chaveSequencial++);
		org1.setName("Um clique informatica");
		
		Organization org2 = new Organization();
		org2.setId(BancoDados.chaveSequencial++);
		org2.setName("Dois cliques informática");
		
		BancoDados.lista.add(org1);
		BancoDados.lista.add(org2);
	}
	
	public void add(Organization org) {
		org.setId(BancoDados.chaveSequencial++);
		BancoDados.lista.add(org);
	}
	
	public List<Organization> getOrganizations(){
		return BancoDados.lista;
	}

	public void delete(Integer orgId) {
		
		Iterator<Organization> it = lista.iterator();
		
		while(it.hasNext()) {
			Organization org = it.next();
			if (org.getId() == orgId) {
				it.remove();
			}
		}
		
		//## o for não funciona para loop e deletar da lista ao mesmo tempo, estoura a excpetion java.util.ConcurrentModificationException
		//for (Organization organization : lista) {
		//	if(organization.getId() == orgId) {
		//		lista.remove(organization);
		//	}
		//}
	}

	public Organization findOrgById(Integer orgId) {
		for (Organization organization : lista) {
			if(organization.getId() == orgId) {
				return organization;
			}
		}
		return null;
	}
}
