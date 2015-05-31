package com.serpen.interfaces;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class PanelDescriptionPensions extends Panel {

	private Label lbltitle;
	private Label lblcontent;
	private Label lblphone;
	private Label lblAddress;
	private Label txtPhone;
	private Label txtAddress;
	private Panel pnlTitle;
	private Panel pnlContent;
 	private Panel pnlinformation;

	public PanelDescriptionPensions() {

		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setVisible(true);
		
		FormLayout layoutinf = new FormLayout();
		layoutinf.setVisible(true);
		
		HorizontalLayout layouttitle = new HorizontalLayout();
		layouttitle.setVisible(true);
		
		HorizontalLayout layoutcontent = new HorizontalLayout();
		layoutcontent.setVisible(true);
		
		HorizontalLayout layoutphone = new HorizontalLayout();
		layoutphone.setVisible(true);
		
		HorizontalLayout layoutaddres = new HorizontalLayout();
		layoutaddres.setVisible(true);

		pnlTitle = new Panel();
		pnlTitle.setSizeFull();
		pnlTitle.setWidth("1000");
		pnlTitle.setHeight("80");
		
		pnlContent = new Panel();
		pnlContent.setSizeFull();
		pnlContent.setWidth("1000px");
		pnlContent.setHeight("400px");
		
		pnlinformation = new Panel();
		pnlinformation.setSizeFull();
		pnlinformation.setWidth("1000");
		pnlinformation.setHeight("250");
		
		lbltitle = new Label("Fondo de pensiones Colpensiones");		
		lbltitle.setWidth("200px");
		lbltitle.setHeight("50px");
		lbltitle.setVisible(true);
		
		lblcontent = new Label("COLPENSIONES, es una Empresa Industrial y "
				+ "comercial del estado organizada como entidad financiera"
				+ "de caracter especial, vinculada al ministerio de trabajo");		
		lblcontent.setWidth("200px");
		lblcontent.setHeight("150px");
		lblcontent.setVisible(true);
		
		lblphone = new Label("Telefono:");		
		lblphone.setWidth("100px");
		lblphone.setHeight("50px");
		lblphone.setVisible(true);

		txtPhone = new Label("313467798");
		txtPhone.setWidth("150px");
		txtPhone.setHeight("50px");
		
		lblAddress = new Label("Direccion:");		
		lblAddress.setWidth("100px");
		lblAddress.setHeight("50px");
		lblAddress.setVisible(true);

		txtAddress = new Label("cr13a N 34");
		txtAddress.setWidth("150px");
		txtAddress.setHeight("50px");
		
		layouttitle.addComponent(lbltitle);
		layoutcontent.addComponent(lblcontent);
		
		
		layoutphone.addComponent(lblphone);
		layoutphone.addComponent(txtPhone);
		
		layoutaddres.addComponent(lblAddress);
		layoutaddres.addComponent(txtAddress);
		
		layoutinf.addComponent(layoutphone);
		layoutinf.addComponent(layoutaddres);
				
		this.pnlTitle.setContent(layouttitle);
		this.pnlContent.setContent(layoutcontent);
		this.pnlinformation.setContent(layoutinf);
		
		layoutPrincipal.addComponent(pnlTitle);
		layoutPrincipal.addComponent(pnlContent);
		layoutPrincipal.addComponent(pnlinformation);
		
		setContent(layoutPrincipal);
		
	}

}
