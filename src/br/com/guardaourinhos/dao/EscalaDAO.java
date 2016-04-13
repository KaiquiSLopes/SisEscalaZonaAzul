package br.com.guardaourinhos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.guardaourinhos.domain.Escala;
import br.com.guardaourinhos.util.HibernateUtil;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 15/09/2014 21:21:27
 * @version 1.0
 */
public class EscalaDAO{
	public void salvar(Escala escala){
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	
	try{
		transacao = sessao.beginTransaction();			
		sessao.save(escala);
		transacao.commit();
	}catch (RuntimeException e){
		if (transacao != null){
			transacao.rollback();
		}
		throw e;
	} finally {
		sessao.close();
	}
}

@SuppressWarnings("unchecked")
public List<Escala> listar(){
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	List<Escala> escalas = null;
	
	try{
		Query consulta = sessao.getNamedQuery("Escala.listar");
		escalas = consulta.list();
	}catch (RuntimeException e){
		throw e;
	} finally {
		sessao.close();
	}
	return escalas;
}

public Escala buscarPorCodigo(Long codigo){
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Escala escala = null;
	
	try{
		Query consulta = sessao.getNamedQuery("Escala.buscarPorCodigo");
		consulta.setLong( "codigo", codigo );
		
		escala = (Escala) consulta.uniqueResult();
	}catch (RuntimeException e){
		throw e;
	} finally {
		sessao.close();
	}
	return escala;
}

public void excluir(Escala escala){
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	
	try{
		transacao = sessao.beginTransaction();			
		sessao.delete(escala);
		transacao.commit();
	}catch (RuntimeException e){
		if (transacao != null){
			transacao.rollback();
		}
		throw e;
	} finally {
		sessao.close();
	}
}

public void editar(Escala escala){
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	
	try{
		transacao = sessao.beginTransaction();
		sessao.update(escala);
		
		transacao.commit();
	}catch (RuntimeException e){
		if (transacao != null){
			transacao.rollback();
		}
		throw e;
	} finally {
		sessao.close();
	}
}
}
