package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class MembershipCertificate extends Window {
	
	private PanelCertificate certificate;
	private Navigator navigator;
	private User user;
	
	

	public MembershipCertificate(Navigator navigator,User user){
		
		this.user=user;
		this.navigator = navigator;
		setWidth("700px");
		setHeight("500px");
		
		VerticalLayout layout = new VerticalLayout();
		this.certificate = new PanelCertificate(user);
//		this.certificate.setVisible(true);
		layout.addComponent(certificate);
		layout.setMargin(true);
		setContent(layout);
		
	}
}
