package br.com.guardaourinhos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.dao.VendaDAO;
import br.com.guardaourinhos.domain.Guardinha;
import br.com.guardaourinhos.domain.Venda;
import br.com.guardaourinhos.util.FacesUtil;

/**
 * Classe que representa os metodos principais de uma venda
 *
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 15:58:56
 * @version 1.0
 */

@ManagedBean
@ViewScoped
public class VendasBean{
	private Venda vendaCadastro;
	private List< Venda > listaVendas;
	private List< Venda > listaVendasFiltrados;
	private String acao;
	private Long codigo;
	
	private List< Guardinha > listaGuardinhas;
	
//	*************** METODOS GET AND SET ***************
	
	public Venda getVendaCadastro() {
		return vendaCadastro;
	}



	public void setVendaCadastro( Venda vendaCadastro ) {
		this.vendaCadastro = vendaCadastro;
	}



	public List< Venda > getListaVendas() {
		return listaVendas;
	}



	public void setListaVendas( List< Venda > listaVendas ) {
		this.listaVendas = listaVendas;
	}



	public List< Venda > getListaVendasFiltrados() {
		return listaVendasFiltrados;
	}



	public void setListaVendasFiltrados( List< Venda > listaVendasFiltrados ) {
		this.listaVendasFiltrados = listaVendasFiltrados;
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
	
//	*************** FIM DOS METODOS GET AND SET ***************


	public void novo(){
		vendaCadastro = new Venda();
	}
	
	public void salvar(){
		try{
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(vendaCadastro);
			
			vendaCadastro = new Venda();
			
			FacesUtil.adicionarMensagensInformativa( "Venda Salva com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar adicionar uma venda: " + e.getMessage());
		}
	}
	
	
	
	public void carregarPesquisa(){
		try{
			VendaDAO vendaDAO = new VendaDAO();
			listaVendas = vendaDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar listar uma venda: " + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				VendaDAO vendaDAO = new VendaDAO();
				vendaCadastro = vendaDAO.buscarPorCodigo( codigo );
			}else{
				vendaCadastro = new Venda();
			}
			
			GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
			listaGuardinhas = guardinhaDAO.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar obter os dados da venda: " + e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.excluir(vendaCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Venda removido com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar remover a venda: " + e.getMessage());
		}
	}
	
	public void editar(){
		try{
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.editar(vendaCadastro);
			
			FacesUtil.adicionarMensagensInformativa( "Venda editado com Sucesso" );
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar editar a venda: " + e.getMessage());
		}
	}
}
