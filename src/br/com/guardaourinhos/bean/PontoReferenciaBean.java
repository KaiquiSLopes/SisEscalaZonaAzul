package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.PontoReferenciaDAO;
import br.com.guardaourinhos.dao.SetorDAO;
import br.com.guardaourinhos.domain.PontoReferencia;
import br.com.guardaourinhos.domain.Setor;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa os metodos principais de um Ponto de Referencia
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:53:49
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class PontoReferenciaBean{
	private PontoReferencia pontoReferenciaCadastro;
	private List< PontoReferencia > listaPontoReferencias;
	private List< PontoReferencia > listaPontoReferenciasFiltrados;
	private String acao;
	private Long codigo;
	
	private List< Setor > listaSetores;
	
//	*************** METODOS GET AND SET ***************
	public PontoReferencia getPontoReferenciaCadastro() {
		return pontoReferenciaCadastro;
	}



	public void setPontoReferenciaCadastro( PontoReferencia pontoReferenciaCadastro ) {
		this.pontoReferenciaCadastro = pontoReferenciaCadastro;
	}



	public List< PontoReferencia > getListaPontoReferencias() {
		return listaPontoReferencias;
	}



	public void setListaPontoReferencias( List< PontoReferencia > listaPontoReferencias ) {
		this.listaPontoReferencias = listaPontoReferencias;
	}



	public List< PontoReferencia > getListaPontoReferenciasFiltrados() {
		return listaPontoReferenciasFiltrados;
	}



	public void setListaPontoReferenciasFiltrados( List< PontoReferencia > listaPontoReferenciasFiltrados ) {
		this.listaPontoReferenciasFiltrados = listaPontoReferenciasFiltrados;
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
	
	public List< Setor > getListaSetores() {
	    return listaSetores;
    }
	
	public void setListaSetores( List< Setor > listaSetores ) {
	    this.listaSetores = listaSetores;
    }
	
//	*************** FIM DOS METODOS GET AND SET ***************
	
	public void novo(){
		pontoReferenciaCadastro = new PontoReferencia();
	}

	public void salvar(){
		try{
			PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
			pontoReferenciaDAO.salvar(pontoReferenciaCadastro);
			
			pontoReferenciaCadastro = new PontoReferencia();
			
			FacesUtil.adicionarMensagensInformativa( "Ponto de Referencia Salva com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adicionar uma Ponto de Referencia: " + e.getMessage());
		}	
		
	}
	
	
	
		public void carregarPesquisa(){
			try{
				PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
				listaPontoReferencias = pontoReferenciaDAO.listar();
				
			}catch(RuntimeException e){
				FacesUtil.adicionarMensagensErro( "Erro ao tentar listar um ponto de referencia: " + e.getMessage());
			}
		}
		
		public void carregarCadastro(){
			try{
				if(codigo != null){
					PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();				
					pontoReferenciaCadastro = pontoReferenciaDAO.buscarPorCodigo( codigo );
				}else{
					pontoReferenciaCadastro = new PontoReferencia();
				}
				
				SetorDAO setorDAO = new SetorDAO();
				listaSetores = setorDAO.listar();
				
			}catch(RuntimeException e){
				FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados do ponto de referencia: " + e.getMessage());
			}
		}
		
		public void excluir(){
			try{
				PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
				pontoReferenciaDAO.excluir(pontoReferenciaCadastro);
				
				FacesUtil.adicionarMensagensInformativa( "Ponto de referencia removido com Sucesso" );
			}catch(RuntimeException e){
				FacesUtil.adicionarMensagensErro( "Erro ao tentar remover o ponto de referencia: " + e.getMessage());
			}
		}
		
		public void editar(){
			try{
				PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
				pontoReferenciaDAO.editar(pontoReferenciaCadastro);
				
				FacesUtil.adicionarMensagensInformativa( "Ponto de referencia editado com Sucesso" );
			}catch(RuntimeException e){
				FacesUtil.adicionarMensagensErro( "Erro ao tentar editar o ponto de referencia: " + e.getMessage());
			}
		}
	}