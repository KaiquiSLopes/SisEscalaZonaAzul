package br.com.guardaourinhos.teste;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.domain.Guardinha;

/**
 * Classe que representa testes em Guardinha
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/09/2014 18:37:22
 * @version 1.0
 */
public class GuardinhaDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		Guardinha guardinha1 = new Guardinha();
		guardinha1.setCracha( 66435 );
		guardinha1.setDemissao( new Date() );
		guardinha1.setNascimento( new Date() );
		guardinha1.setAdmissao( new Date() );
		
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
		guardinhaDAO.salvar(guardinha1);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
		List<Guardinha> guardinhas = guardinhaDAO.listar();
		
		for(Guardinha guardinha : guardinhas){
			System.out.println(guardinha);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
		Guardinha guardinha1 = guardinhaDAO.buscarPorCodigo( 4L );
		
		System.out.println(guardinha1);
	}
	
	@Test
	@Ignore
	public void excluir(){
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();

		Guardinha guardinha = guardinhaDAO.buscarPorCodigo( 3L );

		guardinhaDAO.excluir( guardinha );
		
	}
	
	@Test
	@Ignore
	public void editar(){
		GuardinhaDAO guardinhaDAO = new GuardinhaDAO();

		Guardinha guardinha = new Guardinha();

		guardinha.setCodigo( 3L );
		guardinha.setCracha( 876 );
		guardinha.setAdmissao( new Date() );
		guardinha.setDemissao( new Date() );
		guardinha.setNascimento( new Date() );
		
		
		guardinhaDAO.editar( guardinha );
		
	}

}
