package br.com.guardaourinhos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.guardaourinhos.dao.HorarioDAO;
import br.com.guardaourinhos.domain.Horario;

/**
 * Classe que representa o conversor para caixa de seleção 
 * de chave estrangeiras Horario
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/11/2014 15:08:08
 * @version 1.0
 */

@FacesConverter("horarioConverter")
public class HorarioConverter implements Converter{

	@Override
    public Object getAsObject( FacesContext facesContext, UIComponent component, String valor ) {
	    try{
	    	Long codigo = Long.parseLong( valor );
	    	
	    	HorarioDAO horarioDAO = new HorarioDAO();
	    	Horario horario = horarioDAO.buscarPorCodigo( codigo );
	    	
	    	return horario;
	    }catch(RuntimeException e){
	    	return null;
	    }
    }

	@Override
    public String getAsString( FacesContext facesContext, UIComponent component, Object object ) {
		try{
			Horario horario =(Horario) object;
			Long codigo = horario.getCodigo();
			return codigo.toString();
		}catch(RuntimeException e){
			return null;
		}
    }
}
