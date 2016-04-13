package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:50:54
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class GuardinhaBean{
	private Guardinha guardinhaCadastro;
	private List< Guardinha > listaGuardinhas;
	private List< Guardinha > listaGuardinhasFiltrados;
	private String acao;
	private Long codigo;
	
	
	
	public String getAcao() {
		return acao;
	}

	public void setAcao( String acao ) {
		this.acao = acao;
	}

	public Guardinha getGuardinhaCadastro() {
		if(guardinhaCadastro == null){
			guardinhaCadastro = new Guardinha();
		}
		return guardinhaCadastro;
	}

	public void setGuardinhaCadastro( Guardinha guardinhaCadastro ) {
		this.guardinhaCadastro = guardinhaCadastro;
	}

	
	
	public List< Guardinha > getListaGuardinhas() {
		return listaGuardinhas;
	}

	public void setListaGuardinhas( List< Guardinha > listaGuardinhas ) {
		this.listaGuardinhas = listaGuardinhas;
	}

	public List< Guardinha > getListaGuardinhasFiltrados() {
		return listaGuardinhasFiltrados;
	}

	public void setListaGuardinhasFiltrados( List< Guardinha > listaGuardinhasFiltrados ) {
		this.listaGuardinhasFiltrados = listaGuardinhasFiltrados;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo( Long codigo ) {
		this.codigo = codigo;
	}

	
	public void novo(){
		guardinhaCadastro = new Guardinha();
	}

	public void salvar(){
		try{
			GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
			guardinhaDAO.salvar(guardinhaCadastro);
			
			guardinhaCadastro = new Guardinha();
			
			FacesUtil.adicionarMensagensInformativa( "Guardinha Salvo com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adicionar um guardinha: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
			listaGuardinhas = guardinhaDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar um guardinha: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
				
				guardinhaCadastro = guardinhaDAO.buscarPorCodigo( codigo );
			}
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados do guardinha: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
			guardinhaDAO.excluir(guardinhaCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Guardinha removido com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover o guardinha: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
			guardinhaDAO.editar(guardinhaCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Guardinha editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar o guardinha: " + e.getMessage());
		}
	}
}