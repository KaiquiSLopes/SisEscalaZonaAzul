package br.com.guardaourinhos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.guardaourinhos.dao.PontoReferenciaDAO;
import br.com.guardaourinhos.domain.PontoReferencia;

/**
 * Classe que representa o conversor da caixa de seleção do Ponto de Referencia que tem
 * Sua chave estrangeira de Setor.
 *
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 11/11/2014 13:17:17
 * @version 1.0
 */

@FacesConverter("pontoReferenciaConverter")
public class PontoReferenciaConverter implements Converter{

	@Override
    public Object getAsObject( FacesContext facesContext, UIComponent component, String valor ) {
	    try{
	    	Long codigo = Long.parseLong( valor );
	    	
	    	PontoReferenciaDAO pontoReferenciaDAO = new PontoReferenciaDAO();
	    	PontoReferencia pontoReferencia = pontoReferenciaDAO.buscarPorCodigo( codigo );
	    	
	    	return pontoReferencia;
	    }catch(RuntimeException e){
	    	return null;
	    }
    }

	@Override
    public String getAsString( FacesContext facesContext, UIComponent component, Object object ) {
		try{
			PontoReferencia pontoReferencia =(PontoReferencia) object;
			Long codigo = pontoReferencia.getCodigo();
			return codigo.toString();
		}catch(RuntimeException e){
			return null;
		}
    }

}
