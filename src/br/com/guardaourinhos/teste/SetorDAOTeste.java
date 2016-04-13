package br.com.guardaourinhos.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.SetorDAO;
import br.com.guardaourinhos.domain.Setor;

/**
 * Classe que representa testes de setor
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 12/09/2014 14:23:33
 * @version 1.0
 */
public class SetorDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		Setor setor1 = new Setor();
		setor1.setNome( "Setorando" );
		
		SetorDAO setorDAO = new SetorDAO();
		setorDAO.salvar(setor1);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		SetorDAO setorDAO = new SetorDAO();
		List<Setor> setores = setorDAO.listar();
		
		for(Setor setor : setores){
			System.out.println(setor);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		SetorDAO setorDAO = new SetorDAO();
		Setor setor1 = setorDAO.buscarPorCodigo( 2L );
		
		System.out.println(setor1);
	}
	
	@Test
	@Ignore
	public void excluir(){
		SetorDAO setorDAO = new SetorDAO();

		Setor setor = setorDAO.buscarPorCodigo( 2L );

		setorDAO.excluir( setor );
		
	}
	
	@Test
	@Ignore
	public void editar(){
		SetorDAO setorDAO = new SetorDAO();

		Setor setor = new Setor();

		setor.setCodigo( 5L );
		setor.setNome( "Uaihs" );

		
		setorDAO.editar( setor );
		
	}

}
