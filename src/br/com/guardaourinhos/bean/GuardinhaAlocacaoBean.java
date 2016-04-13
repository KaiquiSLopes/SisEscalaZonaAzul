package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.AlocacaoDAO;
import br.com.guardaourinhos.dao.GuardinhaAlocacaoDAO;
import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.domain.Alocacao;
import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.domain.GuardinhaAlocacao;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa os metodos principais de um GuardinhaAlocacao
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:57:53
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class GuardinhaAlocacaoBean{
	private GuardinhaAlocacao guardinhaAlocacaoCadastro;
	private List< GuardinhaAlocacao > listaGuardinhaAlocacoes;
	private List< GuardinhaAlocacao > listaGuardinhaAlocacoesFiltrados;
	private String acao;
	private Long codigo;
	
	private List< Alocacao > listaAlocacoes;
	private List< Guardinha > listaGuardinhas;
	
//	*************** METODOS GET AND SET ***************
	public GuardinhaAlocacao getGuardinhaAlocacaoCadastro() {
		return guardinhaAlocacaoCadastro;
	}

	public void setGuardinhaAlocacaoCadastro( GuardinhaAlocacao guardinhaAlocacaoCadastro ) {
		this.guardinhaAlocacaoCadastro = guardinhaAlocacaoCadastro;
	}

	public List< GuardinhaAlocacao > getListaGuardinhaAlocacoes() {
		return listaGuardinhaAlocacoes;
	}

	public void setListaGuardinhaAlocacoes( List< GuardinhaAlocacao > listaGuardinhaAlocacoes ) {
		this.listaGuardinhaAlocacoes = listaGuardinhaAlocacoes;
	}

	public List< GuardinhaAlocacao > getListaGuardinhaAlocacoesFiltrados() {
		return listaGuardinhaAlocacoesFiltrados;
	}

	public void setListaGuardinhaAlocacoesFiltrados( List< GuardinhaAlocacao > listaGuardinhaAlocacoesFiltrados ) {
		this.listaGuardinhaAlocacoesFiltrados = listaGuardinhaAlocacoesFiltrados;
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
	
	public List< Alocacao > getListaAlocacoes() {
	    return listaAlocacoes;
    }
	
	public void setListaAlocacoes( List< Alocacao > listaAlocacoes ) {
	    this.listaAlocacoes = listaAlocacoes;
    }
	
	public List< Guardinha > getListaGuardinhas() {
	    return listaGuardinhas;
    } 
	
	public void setListaGuardinhas( List< Guardinha > listaGuardinhas ) {
	    this.listaGuardinhas = listaGuardinhas;
    }
	
//	*************** FIM DOS METODOS GET AND SET ***************
	
	
	
	public void novo(){
		guardinhaAlocacaoCadastro = new GuardinhaAlocacao();
	}
	
	public void salvar(){
		try{
			GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
			guardinhaAlocacaoDAO.salvar(guardinhaAlocacaoCadastro);
			
			guardinhaAlocacaoCadastro = new GuardinhaAlocacao();
			
			FacesUtil.adicionarMensagensInformativa( "GuardinhaAlocacao Salvo com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adicionar um GuardinhaAlocacao: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
			listaGuardinhaAlocacoes = guardinhaAlocacaoDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar um GuardinhaAlocacao: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
				guardinhaAlocacaoCadastro = guardinhaAlocacaoDAO.buscarPorCodigo( codigo );
			}else{
				guardinhaAlocacaoCadastro = new GuardinhaAlocacao();
			}
				GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
				AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
				
				listaGuardinhas = guardinhaDAO.listar();
				listaAlocacoes = alocacaoDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados do GuardinhaAlocacao: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
			guardinhaAlocacaoDAO.excluir(guardinhaAlocacaoCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "GuardinhaAlocacao removido com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover o GuardinhaAlocacao: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			GuardinhaAlocacaoDAO guardinhaAlocacaoDAO = new GuardinhaAlocacaoDAO();
			guardinhaAlocacaoDAO.editar(guardinhaAlocacaoCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "GuardinhaAlocacao editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar o GuardinhaAlocacao: " + e.getMessage());
		}
	}
}
