package br.com.guardaourinhos.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.AlocacaoDAO;
import br.com.guardaourinhos.dao.PontoReferenciaDAO;
import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Alocacao;
import br.com.guardaourinhos.domain.PontoReferencia;
import br.com.guardaourinhos.domain.Supervisor;

/**
 * Classe que representa testes em alocacao
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 16/09/2014 15:43:57
 * @version 1.0
 */
public class AlocacaoDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
		
		Supervisor supervisor = supervisorDAO.buscarPorCodigo( 1L );
		PontoReferencia pontoReferencia = pontoReferenciaDAO.buscarPorCodigo( 1L );
		
		Alocacao alocacao = new Alocacao();
		alocacao.setEndereco( "Cardoso Ribeiro, 324" );
		alocacao.setSupervisor( supervisor );
		alocacao.setPontoReferencia( pontoReferencia );
		
		AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
		alocacaoDAO.salvar( alocacao );
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
		
		Alocacao alocacao = alocacaoDAO.buscarPorCodigo( 1L );
		
		System.out.println(alocacao);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
		
		List< Alocacao > alocacoes = alocacaoDAO.listar();
		
		System.out.println(alocacoes);
	}
	
	@Test
	@Ignore
	public void excluir(){
		AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
		
		Alocacao alocacao = alocacaoDAO.buscarPorCodigo( 1L );
		
		alocacaoDAO.excluir( alocacao );
	}
	
	@Test
	@Ignore
	public void editar(){
		AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
		Alocacao alocacao = alocacaoDAO.buscarPorCodigo( 1L );
		
		SupervisorDAO supervisorDAO = new SupervisorDAO();	
		PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
		
		Supervisor supervisor = supervisorDAO.buscarPorCodigo( 1L );
		PontoReferencia pontoReferencia = pontoReferenciaDAO.buscarPorCodigo( 1L );
		
		alocacao.setEndereco( "Marques dos Reis" );
		alocacao.setSupervisor( supervisor );
		alocacao.setPontoReferencia( pontoReferencia );
		
		alocacaoDAO.editar( alocacao );
		
	}

}
