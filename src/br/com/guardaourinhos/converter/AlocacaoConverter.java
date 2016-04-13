package br.com.guardaourinhos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.guardaourinhos.dao.AlocacaoDAO;
import br.com.guardaourinhos.domain.Alocacao;

/**
 * Classe que representa um conversor para a caixa de seleção
 * de chave estrangeira do tipo Alocacao
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/11/2014 15:15:56
 * @version 1.0
 */

@FacesConverter("alocacaoConverter")
public class AlocacaoConverter implements Converter{

	@Override
    public Object getAsObject( FacesContext facesContext, UIComponent component, String valor ) {
	    try{
	    	Long codigo = Long.parseLong( valor );
	    	
	    	AlocacaoDAO alocacaoDAO = new AlocacaoDAO();
	    	Alocacao alocacao = alocacaoDAO.buscarPorCodigo( codigo );
	    	
	    	return alocacao;
	    }catch(RuntimeException e){
	    	return null;
	    }
    }

	@Override
    public String getAsString( FacesContext facesContext, UIComponent component, Object object ) {
		try{
			Alocacao alocacao =(Alocacao) object;
			Long codigo = alocacao.getCodigo();
			return codigo.toString();
		}catch(RuntimeException e){
			return null;
		}
    }
}
