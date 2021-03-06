package br.com.guardaourinhos.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 24/10/2014 07:06:43
 * @version 1.0
 */
public class FacesUtil{
	public static void adicionarMensagensInformativa(String mensagem){
		FacesMessage facesMessage = new FacesMessage( FacesMessage.SEVERITY_INFO, mensagem, mensagem );
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage( null, facesMessage );
	}
	
public static void adicionarMensagensErro(String mensagem){
	FacesMessage facesMessage = new FacesMessage( FacesMessage.SEVERITY_ERROR, mensagem, mensagem );
	
	FacesContext facesContext = FacesContext.getCurrentInstance();
	facesContext.addMessage( null, facesMessage );
	}

	public static String getParam(String nome){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		ExternalContext externalContext = facesContext.getExternalContext();
		
		Map< String, String > parametros = externalContext.getRequestParameterMap();
		
		String valor = parametros.get( nome );
		
		return valor;
	}




}
