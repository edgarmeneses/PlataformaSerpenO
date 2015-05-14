package com.serpen.interfaces;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class Affiliate extends CustomComponent{

	private Image imgPensions;
	private Label lblPensions;
	private Image imgBank;
	private Label lblBank;
	private Image imgHealth;
	private Label lblHealth;
	private Panel pnlPrincipal;
	
	public Affiliate(){
		
		FormLayout layoutprincipal = new FormLayout();
		layoutprincipal.setSizeFull();
		layoutprincipal.setVisible(true);
		
		FormLayout layoutPanel= new FormLayout();
		layoutPanel.setSizeFull();
		layoutPanel.setVisible(true);
		
		HorizontalLayout horizontal = new HorizontalLayout();
		
		VerticalLayout verticalPension = new VerticalLayout();
		
		VerticalLayout verticalBank = new VerticalLayout();
		
		VerticalLayout verticalHealth = new VerticalLayout();
		
		pnlPrincipal = new Panel();
		pnlPrincipal.setSizeFull();
		pnlPrincipal.setWidth("500px");
		pnlPrincipal.setHeight("500px");
		
		this.imgPensions = new Image("Fondo Pension");
		ThemeResource resource1 = new ThemeResource("../Imagen/pension.png");
		imgPensions = new Image(null, resource1);
		this.imgPensions.setWidth("100px");
		this.imgPensions.setHeight("100px");
		this.imgPensions.setVisible(true);
		
		this.lblPensions = new Label("Fondo Pension");
		this.lblPensions.setVisible(true);
		
		this.imgBank = new Image("Entidad Banco");
		ThemeResource resource2 = new ThemeResource("../Imagen/banco.png");
		imgBank = new Image(null, resource2);
		this.imgBank.setWidth("100px");
		this.imgBank.setHeight("100px");
		this.imgBank.setVisible(true);
		
		this.lblBank = new Label("Entidad Banco");
		this.lblBank.setVisible(true);
		
		this.imgHealth = new Image("Entidad Salud");
		ThemeResource resource3 = new ThemeResource("../Imagen/salud.png");
		imgHealth = new Image(null, resource3);
		this.imgHealth.setWidth("100px");
		this.imgHealth.setHeight("100px");
		this.imgHealth.setVisible(true);
		
		this.lblHealth = new Label("Entidad Salud");
		this.lblHealth.setVisible(true);

		layoutprincipal.addComponent(pnlPrincipal);
		
		layoutPanel.addComponent(verticalPension);
		layoutPanel.addComponent(horizontal);


		verticalPension.addComponent(imgPensions);
		verticalPension.addComponent(lblPensions);
		
		verticalBank.addComponent(imgBank);
		verticalBank.addComponent(lblBank);
		
		verticalHealth.addComponent(imgHealth);
		verticalHealth.addComponent(lblHealth);
		
		horizontal.addComponent(verticalBank);
		horizontal.addComponent(verticalHealth);

        this.pnlPrincipal.setContent(layoutPanel);
       
		this.setCompositionRoot(layoutprincipal);
		this.setCompositionRoot(layoutPanel);
		
		this.setSizeFull();		
	}
}
