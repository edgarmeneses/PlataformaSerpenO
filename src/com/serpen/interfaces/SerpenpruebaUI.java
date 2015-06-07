
package com.serpen.interfaces;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;

import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

//

@Theme("Login")
public class SerpenpruebaUI extends UI{

	public Button button;
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SerpenpruebaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		ControlGeneral controlGeneral = new ControlGeneral(sesion);
		Navigator navigator = new Navigator(this, this);
		//navigator.addView(Affiliate.NAMEAFILIATE, new Affiliate(navigator));
     	navigator.addView(Login.NAMElOGUEO, new Login(navigator,controlGeneral));	
//		navigator.addView(Question.NAMEQUESTION, new Question(navigator, controlGeneral));
	}
}