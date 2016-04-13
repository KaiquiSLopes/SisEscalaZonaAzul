package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.EscalaDAO;
import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.dao.HorarioDAO;
import br.com.guardaourinhos.dao.SetorDAO;
import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Escala;
import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.domain.Horario;
import br.com.guardaourinhos.domain.Setor;
import br.com.guardaourinhos.domain.Supervisor;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa os principais metodos da Escala
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:55:43
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class EscalaBean{
	private Escala escalaCadastro;
	private List< Escala > listaEscalas;
	private List< Escala > listaEscalasFiltrados;
	private String acao;
	private Long codigo;
	
	private List< Guardinha > listaGuardinhas;
	private List< Setor > listaSetores;
	private List< Supervisor > listaSupervisores;
	private List< Horario > listaHorarios;
	
//	*************** METODOS GET AND SET ***************
	
	public Escala getEscalaCadastro() {
		return escalaCadastro;
	}



	public void setEscalaCadastro( Escala escalaCadastro ) {
		this.escalaCadastro = escalaCadastro;
	}



	public List< Escala > getListaEscalas() {
		return listaEscalas;
	}



	public void setListaEscalas( List< Escala > listaEscalas ) {
		this.listaEscalas = listaEscalas;
	}



	public List< Escala > getListaEscalasFiltrados() {
		return listaEscalasFiltrados;
	}



	public void setListaEscalasFiltrados( List< Escala > listaEscalasFiltrados ) {
		this.listaEscalasFiltrados = listaEscalasFiltrados;
	}



	public String getAcao() {
		return acao;
	}



	public void setAcao( String acao ) {
		this.acao = acao;
	}



	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo( Long codigo ) {
		this.codigo = codigo;
	}
	
	
	public List< Guardinha > getListaGuardinhas() {
		return listaGuardinhas;
	}



	public void setListaGuardinhas( List< Guardinha > listaGuardinhas ) {
		this.listaGuardinhas = listaGuardinhas;
	}



	public List< Setor > getListaSetores() {
		return listaSetores;
	}



	public void setListaSetores( List< Setor > listaSetores ) {
		this.listaSetores = listaSetores;
	}



	public List< Supervisor > getListaSupervisores() {
		return listaSupervisores;
	}



	public void setListaSupervisores( List< Supervisor > listaSupervisores ) {
		this.listaSupervisores = listaSupervisores;
	}



	public List< Horario > getListaHorarios() {
		return listaHorarios;
	}



	public void setListaHorarios( List< Horario > listaHorarios ) {
		this.listaHorarios = listaHorarios;
	}

//	*************** FIM DOS METODOS GET AND SET ***************


	public void novo(){
		escalaCadastro = new Escala();
	}

	public void salvar(){
		try{
			EscalaDAO escalaDAO = new EscalaDAO();
			escalaDAO.salvar(escalaCadastro);
			
			escalaCadastro = new Escala();
			
			FacesUtil.adicionarMensagensInformativa( "Escala Salvo com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adicionar uma Escala: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			EscalaDAO escalaDAO = new EscalaDAO();
			listaEscalas = escalaDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar uma escala: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				EscalaDAO escalaDAO = new EscalaDAO();
				escalaCadastro = escalaDAO.buscarPorCodigo( codigo );
			}else{
				escalaCadastro = new Escala();	
				}
			SetorDAO setorDAO = new SetorDAO();
			SupervisorDAO supervisorDAO = new SupervisorDAO();
			HorarioDAO horarioDAO = new HorarioDAO();
			GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
			
			listaSetores = setorDAO.listar();
			listaSupervisores = supervisorDAO.listar();
			listaHorarios = horarioDAO.listar();
			listaGuardinhas = guardinhaDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados da escala: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			EscalaDAO escalaDAO = new EscalaDAO();
			escalaDAO.excluir(escalaCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Escala removida com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover a escala: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			EscalaDAO escalaDAO = new EscalaDAO();
			escalaDAO.editar(escalaCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Escala editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar a escala: " + e.getMessage());
		}
	}
}
