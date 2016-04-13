package br.com.guardaourinhos.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com>
 * @since 28/10/2014 00:27:58
 * @version 1.0
 */
public class ContextListener implements ServletContextListener{

	@Override
    public void contextDestroyed( ServletContextEvent arg0 ) {
		HibernateUtil.getSessionFactory().close();
	    
    }

	@Override
    public void contextInitialized( ServletContextEvent arg0 ) {
	    HibernateUtil.getSessionFactory().openSession();
	    
    }

}
