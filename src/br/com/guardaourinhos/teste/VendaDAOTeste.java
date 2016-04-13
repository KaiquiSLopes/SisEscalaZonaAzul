package br.com.guardaourinhos.teste;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.dao.VendaDAO;
import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.domain.Venda;

/**
 * Classe que representa testes de venda 
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 03/10/2014 21:43:27
 * @version 1.0
 */
public class VendaDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
		
		Guardinha guardinha = guardinhaDAO.buscarPorCodigo( 1L );
		
		Venda venda1 = new Venda();
		venda1.setQuantidadeTalao( 100 );
		venda1.setGuardinha( guardinha );
		venda1.setHorario( new Date() );
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar( venda1 );
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		VendaDAO vendaDAO = new VendaDAO();
		
		Venda venda = vendaDAO.buscarPorCodigo( 1L );
		
		System.out.println(venda);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		VendaDAO vendaDAO = new VendaDAO();
		
		List< Venda > vendas = vendaDAO.listar();
		
		System.out.println(vendas);
	}
	
	@Test
	@Ignore
	public void excluir(){
		VendaDAO vendaDAO = new VendaDAO();
		
		Venda venda = vendaDAO.buscarPorCodigo( 1L );
		
		vendaDAO.excluir( venda );
	}
	
	@Test
	@Ignore
	public void editar(){
GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
		
		Guardinha guardinha = guardinhaDAO.buscarPorCodigo( 1L );
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda1 = vendaDAO.buscarPorCodigo( 1L );
		venda1.setQuantidadeTalao( 19 );
		venda1.setGuardinha( guardinha );
		venda1.setHorario( new Date() );
		
		
		
		vendaDAO.editar( venda1 );
		
	}
	

}
