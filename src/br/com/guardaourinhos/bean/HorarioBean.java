package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.HorarioDAO;
import br.com.guardaourinhos.domain.Horario;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:45:51
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class HorarioBean{
	private Horario horarioCadastro;
	private List< Horario > listaHorarios;
	private List< Horario > listaHorariosFiltrados;
	private String acao;
	private Long codigo;
	
	
	public Horario getHorarioCadastro() {
		if(horarioCadastro == null){
			horarioCadastro = new Horario();
		}
		return horarioCadastro;
	}

	public void setHorarioCadastro( Horario horarioCadastro ) {
		this.horarioCadastro = horarioCadastro;
	}
	
	public List< Horario > getListaHorarios() {
		return listaHorarios;
	}

	public void setListaHorarios( List< Horario > listaHorarios ) {
		this.listaHorarios = listaHorarios;
	}

	public List< Horario > getListaHorariosFiltrados() {
		return listaHorariosFiltrados;
	}

	public void setListaHorariosFiltrados( List< Horario > listaHorariosFiltrados ) {
		this.listaHorariosFiltrados = listaHorariosFiltrados;
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

	public void novo(){
		horarioCadastro = new Horario();
	}

	public void salvar(){
		try{
			HorarioDAO horarioDAO = new HorarioDAO();
			horarioDAO.salvar(horarioCadastro);
			
			horarioCadastro = new Horario();
			
			FacesUtil.adicionarMensagensInformativa( "Horario Salvo com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adicionar um horario: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			HorarioDAO horarioDAO = new HorarioDAO();
			listaHorarios = horarioDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar um horario: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				HorarioDAO horarioDAO = new HorarioDAO();
				
				horarioCadastro = horarioDAO.buscarPorCodigo( codigo );
			}
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados do horario: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			HorarioDAO horarioDAO = new HorarioDAO();
			horarioDAO.excluir(horarioCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Horario removido com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover o horario: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			HorarioDAO horarioDAO = new HorarioDAO();
			horarioDAO.editar(horarioCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Horario editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar o horario: " + e.getMessage());
		}
	}
}
