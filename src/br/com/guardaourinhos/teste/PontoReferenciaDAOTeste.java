package br.com.guardaourinhos.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.PontoReferenciaDAO;
import br.com.guardaourinhos.domain.PontoReferencia;
/**
 * Classe que representa testes em ponto de referencia
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 12/09/2014 13:01:28
 * @version 1.0
 */
public class PontoReferenciaDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		PontoReferencia pontoReferencia1 = new PontoReferencia();
		pontoReferencia1.setDescricao( "Blumenau" );
		
		PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
		pontoReferenciaDAO.salvar(pontoReferencia1);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
		List<PontoReferencia> pontoReferencias = pontoReferenciaDAO.listar();
		
		for(PontoReferencia pontoReferencia : pontoReferencias){
			System.out.println(pontoReferencia);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
		PontoReferencia pontoReferencia1 = pontoReferenciaDAO.buscarPorCodigo( 2L );
		
		System.out.println(pontoReferencia1);
	}
	
	@Test
	@Ignore
	public void excluir(){
		PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();

		PontoReferencia pontoReferencia = pontoReferenciaDAO.buscarPorCodigo( 2L );

		pontoReferenciaDAO.excluir( pontoReferencia );
		
	}
	
	@Test
	@Ignore
	public void editar(){
		PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();

		PontoReferencia pontoReferencia = new PontoReferencia();

		pontoReferencia.setCodigo( 5L );
		pontoReferencia.setDescricao( "FarmaCris" );
		
		pontoReferenciaDAO.editar( pontoReferencia );
		
	}

}
