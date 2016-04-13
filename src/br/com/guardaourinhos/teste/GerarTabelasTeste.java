package br.com.guardaourinhos.teste;

import org.junit.Test;

import br.com.guardaourinhos.util.HibernateUtil;

public class GerarTabelasTeste {
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
