package br.com.guardaourinhos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.guardaourinhos.domain.GuardinhaAlocacao;
import br.com.guardaourinhos.util.HibernateUtil;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 16/09/2014 20:49:15
 * @version 1.0
 */
public class GuardinhaAlocacaoDAO{
	public void salvar(GuardinhaAlocacao guardinhaAlocacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.save(guardinhaAlocacao);
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
	public List<GuardinhaAlocacao> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<GuardinhaAlocacao> guardinhaAlocacoes = null;
		
		try{
			Query consulta = sessao.getNamedQuery("GuardinhaAlocacao.listar");
			guardinhaAlocacoes = consulta.list();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return guardinhaAlocacoes;
	}

	public GuardinhaAlocacao buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		GuardinhaAlocacao guardinhaAlocacao = null;
		
		try{
			Query consulta = sessao.getNamedQuery("GuardinhaAlocacao.buscarPorCodigo");
			consulta.setLong( "codigo", codigo );
			
			guardinhaAlocacao = (GuardinhaAlocacao) consulta.uniqueResult();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return guardinhaAlocacao;
	}

	public void excluir(GuardinhaAlocacao guardinhaAlocacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.delete(guardinhaAlocacao);
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

	public void editar(GuardinhaAlocacao guardinhaAlocacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(guardinhaAlocacao);
			
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
