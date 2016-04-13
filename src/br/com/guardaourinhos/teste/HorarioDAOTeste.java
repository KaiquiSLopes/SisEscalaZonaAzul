package br.com.guardaourinhos.teste;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guardaourinhos.dao.HorarioDAO;
import br.com.guardaourinhos.domain.Horario;

/**
 * Classe que representa testes em horario
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 12/09/2014 13:43:31
 * @version 1.0
 */
public class HorarioDAOTeste{
	@Test
	@Ignore
	public void salvar(){
		Horario horario1 = new Horario();
		horario1.setDiaSemana( new Date() );
//		horario1.setHorarioInicio( new Time(11:88:88) );
//		horario1.setHorarioSaida( new Date() );

		HorarioDAO horarioDAO = new HorarioDAO();
		horarioDAO.salvar(horario1);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		HorarioDAO horarioDAO = new HorarioDAO();
		List<Horario> horarios = horarioDAO.listar();
		
		for(Horario horario : horarios){
			System.out.println(horario);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		HorarioDAO horarioDAO = new HorarioDAO();
		Horario horario1 = horarioDAO.buscarPorCodigo( 1L );
		
		System.out.println(horario1);
	}
	
	@Test
	@Ignore
	public void excluir(){
		HorarioDAO horarioDAO = new HorarioDAO();

		Horario horario = horarioDAO.buscarPorCodigo( 2L );

		horarioDAO.excluir( horario );
		
	}
	
	@Test
	@Ignore
	public void editar(){
		HorarioDAO horarioDAO = new HorarioDAO();

		Horario horario1 = new Horario();

		horario1.setCodigo( 1L );
//		horario1.setDiaSemana( "Quarta" );
//		horario1.setHorarioInicio( new Date() );
//		horario1.setHorarioSaida( new Date() );
//		
		
		horarioDAO.editar( horario1 );
		
	}

}
