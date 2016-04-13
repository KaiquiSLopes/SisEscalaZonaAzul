package br.com.guardaourinhos.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.AlocacaoDAO;
import br.com.guardaourinhos.dao.GuardinhaAlocacaoDAO;
import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.domain.Alocacao;
import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.domain.GuardinhaAlocacao;

/**
 * Classe que representa testes em Guardinha Alocação
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 16/09/2014 21:00:01
 * @version 1.0
 */
public class GuardinhaAlocacaoDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
		AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
		
		Guardinha guardinha = guardinhaDAO.buscarPorCodigo( 5L );
		Alocacao alocacao = alocacaoDAO.buscarPorCodigo( 1L );
		
		GuardinhaAlocacao guardinhaAlocacao = new GuardinhaAlocacao();
		guardinhaAlocacao.setGuardinha( guardinha );
		guardinhaAlocacao.setAlocacao( alocacao );
		
		GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
		guardinhaAlocacaoDAO.salvar( guardinhaAlocacao );
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
		
		GuardinhaAlocacao guardinhaAlocacao = guardinhaAlocacaoDAO.buscarPorCodigo( 1L );
		
		System.out.println(guardinhaAlocacao);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
		
		List< GuardinhaAlocacao > guardinhaAlocacoes = guardinhaAlocacaoDAO.listar();
		
		System.out.println(guardinhaAlocacoes);
	}
	
	@Test
	@Ignore
	public void excluir(){
		GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
		
		GuardinhaAlocacao guardinhaAlocacao = guardinhaAlocacaoDAO.buscarPorCodigo( 1L );
		
		guardinhaAlocacaoDAO.excluir( guardinhaAlocacao );
	}
	
	@Test
	@Ignore
	public void editar(){
		GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
		GuardinhaAlocacao guardinhaAlocacao = guardinhaAlocacaoDAO.buscarPorCodigo( 1L );
		
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
		AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
		
		Guardinha guardinha = guardinhaDAO.buscarPorCodigo( 1L );
		Alocacao alocacao = alocacaoDAO.buscarPorCodigo( 1L );
		
		guardinhaAlocacao.setGuardinha( guardinha );
		guardinhaAlocacao.setAlocacao( alocacao );
		
		guardinhaAlocacaoDAO.editar( guardinhaAlocacao );
		
	}

}
