package br.com.guardaourinhos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.guardaourinhos.domain.Alocacao;
import br.com.guardaourinhos.util.HibernateUtil;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 16/09/2014 15:33:32
 * @version 1.0
 */
public class AlocacaoDAO{
	public void salvar(Alocacao alocacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.save(alocacao);
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
	public List<Alocacao> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Alocacao> alocacoes = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Alocacao.listar");
			alocacoes = consulta.list();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return alocacoes;
	}

	public Alocacao buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Alocacao alocacao = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Alocacao.buscarPorCodigo");
			consulta.setLong( "codigo", codigo );
			
			alocacao = (Alocacao) consulta.uniqueResult();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return alocacao;
	}

	public void excluir(Alocacao alocacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.delete(alocacao);
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

	public void editar(Alocacao alocacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(alocacao);
			
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
