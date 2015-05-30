
package com.serpen.interfaces;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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
		
//		VerticalLayout layout = new VerticalLayout();
//		setContent(layout);
//		EntityEducation question = new EntityEducation();
//		layout.addComponent(question);
//		
//		EntityPensions pensions= new EntityPensions();
//		layout.addComponent(pensions);
		
//		HomePageFound pFound = new HomePageFound();
//		layout.addComponent(pFound);
		Navigator navigator = new Navigator(this, this);
		navigator.addView(Affiliate.NAMEAFILIATE, new Affiliate(navigator));
		
	}

}

