package br.com.guardaourinhos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.guardaourinhos.dao.GuardinhaDAO;
import br.com.guardaourinhos.domain.Guardinha;

/**
 * Classe que representa o conversor da caixa de seleção relacionda
 * a um guardinha
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/11/2014 15:00:49
 * @version 1.0
 */

@FacesConverter("guardinhaConverter")
public class GuardinhaConverter implements Converter{

	@Override
    public Object getAsObject( FacesContext facesContext, UIComponent component, String valor ) {
	    try{
	    	Long codigo = Long.parseLong( valor );
	    	
	    	GuardinhaDAO guardinhaDAO = new GuardinhaDAO();
	    	Guardinha guardinha = guardinhaDAO.buscarPorCodigo( codigo );
	    	
	    	return guardinha;
	    }catch(RuntimeException e){
	    	return null;
	    }
    }

	@Override
    public String getAsString( FacesContext facesContext, UIComponent component, Object object ) {
		try{
			Guardinha guardinha =(Guardinha) object;
			Long codigo = guardinha.getCodigo();
			return codigo.toString();
		}catch(RuntimeException e){
			return null;
		}
    }

}
