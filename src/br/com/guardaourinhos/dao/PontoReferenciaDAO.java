package br.com.guardaourinhos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.guardaourinhos.domain.PontoReferencia;
import br.com.guardaourinhos.util.HibernateUtil;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/09/2014 22:10:23
 * @version 1.0
 */
public class PontoReferenciaDAO{
	public void salvar( PontoReferencia pontoReferencia){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.save(pontoReferencia);
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
	public List<PontoReferencia> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<PontoReferencia> pontoReferencias = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PontoReferencia.listar");
			pontoReferencias = consulta.list();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return pontoReferencias;
	}
	
	public PontoReferencia buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		PontoReferencia pontoReferencia = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PontoReferencia.buscarPorCodigo");
			consulta.setLong( "codigo", codigo );
			
			pontoReferencia = (PontoReferencia) consulta.uniqueResult();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return pontoReferencia;
	}
	
	public void excluir(PontoReferencia pontoReferencia){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.delete(pontoReferencia);
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
	
	public void editar(PontoReferencia pontoReferencia){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(pontoReferencia);
			
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