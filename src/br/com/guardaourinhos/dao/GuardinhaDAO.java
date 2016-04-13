package br.com.guardaourinhos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.util.HibernateUtil;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/09/2014 18:22:00
 * @version 1.0
 */
public class GuardinhaDAO{
	public void salvar(Guardinha guardinha){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.save(guardinha);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			if (transacao != null){
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Guardinha> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Guardinha> guardinhas = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Guardinha.listar");
			guardinhas = consulta.list();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return guardinhas;
	}
	
	public Guardinha buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Guardinha guardinha = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Guardinha.buscarPorCodigo");
			consulta.setLong( "codigo", codigo );
			
			guardinha = (Guardinha) consulta.uniqueResult();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return guardinha;
	}
	
	public void excluir(Guardinha guardinha){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.delete(guardinha);
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
	
	public void editar(Guardinha guardinha){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(guardinha);
			
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
