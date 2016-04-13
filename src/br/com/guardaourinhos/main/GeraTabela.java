package br.com.guardaourinhos.main;

import br.com.guardaourinhos.util.HibernateUtil;



public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}

}
