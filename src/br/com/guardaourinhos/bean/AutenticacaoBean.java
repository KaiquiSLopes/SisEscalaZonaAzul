package br.com.guardaourinhos.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Supervisor;
import br.com.guardaourinhos.util.FacesUtil;


/**
 * Classe que representa uma autenticacao 
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 12/11/2014 01:29:52
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class AutenticacaoBean{
	private Supervisor supervisorLogado;
	

	public Supervisor getSupervisorLogado() {
		if(supervisorLogado == null){
			supervisorLogado = new Supervisor();
		}
	    return supervisorLogado;
    }
	
	public void setSupervisorLogado( Supervisor supervisorLogado ) {
	    this.supervisorLogado = supervisorLogado;
    }
// 

	public String logar(){
		try{
			SupervisorDAO supervisorDAO = new SupervisorDAO();
			supervisorLogado = supervisorDAO.logar(supervisorLogado.getNomeUsuario(), DigestUtils.md5Hex(supervisorLogado.getSenhaUsuario()));
			
			if( supervisorLogado == null ){
				FacesUtil.adicionarMensagensErro( "Usuario ou Senha Invalido!" );
				return null;
			}else{
				FacesUtil.adicionarMensagensInformativa( "Supervisor Autorizado!" );
				return "/pages/principal.xhtml?faces-redirect=true";
			}
		}catch(RuntimeException e){
			FacesUtil.adicionarMensagensErro( "Erro ao tentar entrar no sistema: " + e.getMessage());
		}
		return null;
		
	}
	
	public String sair(){
		supervisorLogado = null;
		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}
	
}
