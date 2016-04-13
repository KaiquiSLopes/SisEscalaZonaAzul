package br.com.guardaourinhos.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.EscalaDAO;
import br.com.guardaourinhos.dao.HorarioDAO;
import br.com.guardaourinhos.dao.SetorDAO;
import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Escala;
import br.com.guardaourinhos.domain.Horario;
import br.com.guardaourinhos.domain.Setor;
import br.com.guardaourinhos.domain.Supervisor;

/**
 * Classe que representa testes em escala
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 15/09/2014 21:21:58
 * @version 1.0
 */
public class EscalaDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		SetorDAO setorDAO = new SetorDAO();
		HorarioDAO horarioDAO = new HorarioDAO();
		SupervisorDAO supervisorDAO = new SupervisorDAO();
//		GuardinhaDAO guardinhaDAO = GuardinhaDAO();
		
//		Guardinha guardinha = guardinhaDAO.buscarPorCodigo(1L);
		Setor setor = setorDAO.buscarPorCodigo( 1L );
		Horario horario = horarioDAO.buscarPorCodigo( 1L );
		Supervisor supervisor = supervisorDAO.buscarPorCodigo( 1L );
		
		Escala escala = new Escala();
//		escala.setGuardinha( guardinha );
		escala.setHorario( horario );
		escala.setSetor( setor );
		escala.setSupervisor( supervisor );
		
		EscalaDAO escalaDAO = new EscalaDAO();
		escalaDAO.salvar( escala );
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		EscalaDAO escalaDAO = new EscalaDAO();
		
		Escala escala = escalaDAO.buscarPorCodigo( 1L );
		
		System.out.println(escala);
	}
	
	@Test
	@Ignore
	public void listar(){
		EscalaDAO escalaDAO = new EscalaDAO();
		
		List< Escala > escalas = escalaDAO.listar();
		
		System.out.println(escalas);
	}
	
	@Test
	@Ignore
	public void excluir(){
		EscalaDAO escalaDAO = new EscalaDAO();
		
		Escala escala = escalaDAO.buscarPorCodigo( 1L );
		
		escalaDAO.excluir( escala );
	}
	
	@Test
	public void editar(){
		EscalaDAO escalaDAO = new EscalaDAO();
		Escala escala = escalaDAO.buscarPorCodigo( 2L );
		
//		********** CHAVES ESTRANGEIRAS **********	    // 
		SetorDAO setorDAO = new SetorDAO();
		HorarioDAO horarioDAO = new HorarioDAO();
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		
//		**********   BUSCANDO OS DADOS JA EXISTENTES   **********      //
		Setor setor = setorDAO.buscarPorCodigo( 1L );
		Horario horario = horarioDAO.buscarPorCodigo( 1L );
		Supervisor supervisor = supervisorDAO.buscarPorCodigo( 1L );
		
//		**********   TROCANDO OS DADOS   **********     //
//		escala.setGuardinha( guardinha );
		escala.setHorario( horario );
		escala.setSetor( setor );
		escala.setSupervisor( supervisor );
		
		escalaDAO.editar( escala );
		
	}

}
