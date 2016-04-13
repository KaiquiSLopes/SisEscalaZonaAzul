package br.com.guardaourinhos.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Supervisor;

/**
 * Classe que representa testes de supervisor
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 10/09/2014 16:41:23
 * @version 1.0
 */

public class SupervisorDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		Supervisor supervisor1 = new Supervisor();
		supervisor1.setNome( "Chaves" );
		
		Supervisor supervisor2 = new Supervisor();
		supervisor2.setNome( "Seu Madruga" );
		
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		supervisorDAO.salvar(supervisor1);
		supervisorDAO.salvar(supervisor2);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		List<Supervisor> supervisores = supervisorDAO.listar();
		
		for(Supervisor supervisor : supervisores){
			System.out.println(supervisor);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		Supervisor supervisor1 = supervisorDAO.buscarPorCodigo( 2L );
		Supervisor supervisor2 = supervisorDAO.buscarPorCodigo( 4L );
		
		System.out.println(supervisor1);
		System.out.println(supervisor2);
	}
	
	@Test
	@Ignore
	public void excluir(){
		SupervisorDAO supervisorDAO = new SupervisorDAO();

		Supervisor supervisor = supervisorDAO.buscarPorCodigo( 2L );

		supervisorDAO.excluir( supervisor );
		
	}
	
	@Test
	@Ignore
	public void editar(){
		SupervisorDAO supervisorDAO = new SupervisorDAO();

		Supervisor supervisor = new Supervisor();

		supervisor.setCodigo( 5L );
		supervisor.setNome( "Kiko" );
		
		supervisorDAO.editar( supervisor );
		
	}
	
	@Test
	@Ignore
	public void logar(){
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		
		Supervisor supervisor = supervisorDAO.logar( "kaiquilopes", "123456" );
		
		System.out.println("Supervisor: " + supervisor);
		
	}

}
