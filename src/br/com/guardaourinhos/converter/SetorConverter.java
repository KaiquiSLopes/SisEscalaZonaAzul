package br.com.guardaourinhos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.guardaourinhos.dao.SetorDAO;
import br.com.guardaourinhos.domain.Setor;

/**
 * Classe que representa o conversor da caixa de seleção do Setor
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/11/2014 14:46:37
 * @version 1.0
 */

@FacesConverter("setorConverter")
public class SetorConverter implements Converter{

	@Override
    public Object getAsObject( FacesContext facesContext, UIComponent component, String valor ) {
	    try{
	    	Long codigo = Long.parseLong( valor );
	    	
	    	SetorDAO setorDAO = new SetorDAO();
	    	Setor setor = setorDAO.buscarPorCodigo( codigo );
	    	
	    	return setor;
	    }catch(RuntimeException e){
	    	return null;
	    }
    }

	@Override
    public String getAsString( FacesContext facesContext, UIComponent component, Object object ) {
		try{
			Setor setor =(Setor) object;
			Long codigo = setor.getCodigo();
			return codigo.toString();
		}catch(RuntimeException e){
			return null;
		}
    }
}
