package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Supervisor;
import br.com.guardaourinhos.util.FacesUtil;


/**
 * Classe que representa
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 07:01:44
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class SupervisorBean{
	private Supervisor supervisorCadastro;
	private List< Supervisor > listaSupervisores;
	private List< Supervisor > listaSupervisoresFiltrados;
	private String acao;
	private Long codigo;
	

	public Supervisor getSupervisorCadastro() {
		if(supervisorCadastro == null){
			supervisorCadastro = new Supervisor();
		}
		return supervisorCadastro;
	}

	public void setSupervisorCadastro( Supervisor supervisorCadastro ) {
		this.supervisorCadastro = supervisorCadastro;
	}
	
	public List< Supervisor > getListaSupervisores() {
		return listaSupervisores;
	}

	public void setListaSupervisores( List< Supervisor > listaSupervisores ) {
		this.listaSupervisores = listaSupervisores;
	}

	public List< Supervisor > getListaSupervisoresFiltrados() {
		return listaSupervisoresFiltrados;
	}

	public void setListaSupervisoresFiltrados( List< Supervisor > listaSupervisoresFiltrados ) {
		this.listaSupervisoresFiltrados = listaSupervisoresFiltrados;
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
		supervisorCadastro = new Supervisor();
	}

	public void salvar(){
		try{
			SupervisorDAO supervisorDAO = new SupervisorDAO();
			supervisorCadastro.setSenhaUsuario(DigestUtils.md5Hex(supervisorCadastro.getSenhaUsuario()));
			supervisorDAO.salvar(supervisorCadastro);
			
			supervisorCadastro = new Supervisor();
			
			FacesUtil.adicionarMensagensInformativa( "Supervisor Salvo com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adocionar um supervisor: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			SupervisorDAO supervisorDAO = new SupervisorDAO();
			listaSupervisores = supervisorDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar um supervisor: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				SupervisorDAO supervisorDAO = new SupervisorDAO();
				
				supervisorCadastro = supervisorDAO.buscarPorCodigo( codigo );
			}
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados do supervisor: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			SupervisorDAO supervisorDAO = new SupervisorDAO();
			supervisorDAO.excluir(supervisorCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Supervisor removido com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover o supervisor: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			SupervisorDAO supervisorDAO = new SupervisorDAO();
			supervisorCadastro.setSenhaUsuario(DigestUtils.md5Hex(supervisorCadastro.getSenhaUsuario()));
			supervisorDAO.editar(supervisorCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Supervisor editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar o supervisor: " + e.getMessage());
		}
	}
}
