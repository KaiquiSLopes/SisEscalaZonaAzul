package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.SetorDAO;
import br.com.guardaourinhos.domain.Setor;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:47:39
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class SetorBean{
	private Setor setorCadastro;
	private List< Setor > listaSetores;
	private List< Setor > listaSetoresFiltrados;
	private String acao;
	private Long codigo;
	
	
	public Setor getSetorCadastro() {
		if(setorCadastro == null){
			setorCadastro = new Setor();
		}
		return setorCadastro;
	}

	public void setSetorCadastro( Setor setorCadastro ) {
		this.setorCadastro = setorCadastro;
	}
	
	public List< Setor > getListaSetores() {
		return listaSetores;
	}

	public void setListaSetores( List< Setor > listaSetores ) {
		this.listaSetores = listaSetores;
	}

	public List< Setor > getListaSetoresFiltrados() {
		return listaSetoresFiltrados;
	}

	public void setListaSetoresFiltrados( List< Setor > listaSetoresFiltrados ) {
		this.listaSetoresFiltrados = listaSetoresFiltrados;
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
		setorCadastro = new Setor();
	}

	public void salvar(){
		try{
			SetorDAO setorDAO = new SetorDAO();
			setorDAO.salvar(setorCadastro);
			
			setorCadastro = new Setor();
			
			FacesUtil.adicionarMensagensInformativa( "Setor Salvo com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adocionar um setor: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			SetorDAO setorDAO = new SetorDAO();
			listaSetores = setorDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar um setor: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				SetorDAO setorDAO = new SetorDAO();
				
				setorCadastro = setorDAO.buscarPorCodigo( codigo );
			}
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados do setor: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			SetorDAO setorDAO = new SetorDAO();
			setorDAO.excluir(setorCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Setor removido com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover o setor: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			SetorDAO setorDAO = new SetorDAO();
			setorDAO.editar(setorCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Setor editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar o setor: " + e.getMessage());
		}
	}
}
