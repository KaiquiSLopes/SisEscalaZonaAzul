package br.com.guardaourinhos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.guardaourinhos.dao.SupervisorDAO;
import br.com.guardaourinhos.domain.Supervisor;

/**
 * Classe que representa o conversor para a caixa de seleção para chaves estrangeiras
 * de Supervisor
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/11/2014 15:04:50
 * @version 1.0
 */

@FacesConverter("supervisorConverter")
public class SupervisorConverter implements Converter{

	@Override
    public Object getAsObject( FacesContext facesContext, UIComponent component, String valor ) {
	    try{
	    	Long codigo = Long.parseLong( valor );
	    	
	    	SupervisorDAO supervisorDAO = new SupervisorDAO();
	    	Supervisor supervisor = supervisorDAO.buscarPorCodigo( codigo );
	    	
	    	return supervisor;
	    }catch(RuntimeException e){
	    	return null;
	    }
    }

	@Override
    public String getAsString( FacesContext facesContext, UIComponent component, Object object ) {
		try{
			Supervisor supervisor =(Supervisor) object;
			Long codigo = supervisor.getCodigo();
			return codigo.toString();
		}catch(RuntimeException e){
			return null;
		}
    }
}
