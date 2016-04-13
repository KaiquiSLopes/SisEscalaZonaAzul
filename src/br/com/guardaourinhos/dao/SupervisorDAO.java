/**
 * 
 */
package br.com.guardaourinhos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.guardaourinhos.domain.Supervisor;
import br.com.guardaourinhos.util.HibernateUtil;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 10/09/2014 16:24:13
 * @version 1.0
 */
public class SupervisorDAO{
	public void salvar(Supervisor supervisor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.save(supervisor);
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
	public List<Supervisor> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Supervisor> supervisores = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Supervisor.listar");
			supervisores = consulta.list();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return supervisores;
	}
	
	public Supervisor buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Supervisor supervisor = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Supervisor.buscarPorCodigo");
			consulta.setLong( "codigo", codigo );
			
			supervisor = (Supervisor) consulta.uniqueResult();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return supervisor;
	}
	
	public void excluir(Supervisor supervisor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();			
			sessao.delete(supervisor);
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
	
	public void editar(Supervisor supervisor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(supervisor);
			
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
	
	public Supervisor logar(String nomeUsuario, String senhaUsuario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Supervisor supervisor = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Supervisor.logar");
			consulta.setString( "nomeUsuario", nomeUsuario );
			consulta.setString( "senhaUsuario", senhaUsuario );
			
			supervisor = (Supervisor) consulta.uniqueResult();
		}catch (RuntimeException e){
			throw e;
		} finally {
			sessao.close();
		}
		return supervisor;
	}
	
}
