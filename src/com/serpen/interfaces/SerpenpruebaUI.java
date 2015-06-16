
package com.serpen.interfaces;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;

import com.google.gwt.layout.client.Layout;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
//
import com.vaadin.ui.VerticalLayout;

@Theme("EntityBank")
public class SerpenpruebaUI extends UI{

	public Button button;
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SerpenpruebaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
//		VerticalLayout layout = new VerticalLayout();
//		setContent(layout);
//		
//		HomePageFound pFound = new HomePageFound(null);
//		layout.addComponent(pFound);
//		
	Session sesion = HibernateUtil.getSessionFactory().openSession();
	ControlGeneral controlGeneral = new ControlGeneral(sesion);
	
 Navigator navigator = new Navigator(this, this);
 
 	
   navigator.addView(Login.NAMElOGUEO, new Login(navigator,controlGeneral));
//  navigator.addView(Affiliate.NAMEAFILIATE, new Affiliate(navigator));	
  navigator.addView(Question.NAMEQUESTION, new Question(navigator, controlGeneral));
      //HorizontalLayout horizontalLayout = new HorizontalLayout();
     
	}
}