package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.AlocacaoDAO;
import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.dao.PontoReferenciaDAO;
import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Alocacao;
import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.domain.PontoReferencia;
import br.com.guardaourinhos.domain.Supervisor;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa os principais metodos de uma alocação
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:56:44
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class AlocacaoBean{
	private Alocacao alocacaoCadastro;
	private List< Alocacao > listaAlocacoes;
	private List< Alocacao > listaAlocacoesFiltrados;
	private String acao;
	private Long codigo; 
	
	private List< Supervisor > listaSupervisores;
	private List< PontoReferencia > listaPontoReferencias;
	private List< Guardinha > listaGuardinhas;
	


	public void novo(){
		alocacaoCadastro = new Alocacao();
	}

	public void salvar(){
		try{
			AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
			alocacaoDAO.salvar(alocacaoCadastro);
			
			alocacaoCadastro = new Alocacao();
			
			FacesUtil.adicionarMensagensInformativa( "Alocação Salva com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adicionar uma Alocação: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
			listaAlocacoes = alocacaoDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar uma alocação: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
				alocacaoCadastro = alocacaoDAO.buscarPorCodigo( codigo );
			}else{
				alocacaoCadastro = new Alocacao();
			}
				SupervisorDAO supervisorDAO = new SupervisorDAO();
				PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
				GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
				
				listaSupervisores = supervisorDAO.listar();
				listaPontoReferencias = pontoReferenciaDAO.listar();
				listaGuardinhas = guardinhaDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados da alocação: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
			alocacaoDAO.excluir(alocacaoCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Alocação removido com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover a alocação: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
			alocacaoDAO.editar(alocacaoCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Alocação editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar a alocação: " + e.getMessage());
		}
	}
	
	
//	*************** METODOS GET AND SET ***************
	public Alocacao getAlocacaoCadastro() {
		return alocacaoCadastro;
	}
	
	public void setAlocacaoCadastro( Alocacao alocacaoCadastro ) {
		this.alocacaoCadastro = alocacaoCadastro;
	}
	
	public List< Alocacao > getListaAlocacoes() {
		return listaAlocacoes;
	}
	
	public void setListaAlocacoes( List< Alocacao > listaAlocacoes ) {
		this.listaAlocacoes = listaAlocacoes;
	}
	
	public List< Alocacao > getListaAlocacoesFiltrados() {
		return listaAlocacoesFiltrados;
	}
	
	public void setListaAlocacoesFiltrados( List< Alocacao > listaAlocacoesFiltrados ) {
		this.listaAlocacoesFiltrados = listaAlocacoesFiltrados;
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
	
	public List< Supervisor > getListaSupervisores() {
		return listaSupervisores;
	}
	
	public void setListaSupervisores( List< Supervisor > listaSupervisores ) {
		this.listaSupervisores = listaSupervisores;
	}
	
	public List< PontoReferencia > getListaPontoReferencias() {
		return listaPontoReferencias;
	}
	
	public void setListaPontoReferencias( List< PontoReferencia > listaPontoReferencias ) {
		this.listaPontoReferencias = listaPontoReferencias;
	}
	
	public List< Guardinha > getListaGuardinhas() {
		return listaGuardinhas;
	}
	
	public void setListaGuardinhas( List< Guardinha > listaGuardinhas ) {
		this.listaGuardinhas = listaGuardinhas;
	}
//	*************** FIM DOS METODOS GET AND SET ***************
}
