package com.serpen.interfaces;
import com.google.gwt.thirdparty.javascript.rhino.head.ast.FunctionNode.Form;
import com.serpen.logic.entity.User;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class Affiliate extends CustomComponent implements View{

	private Image imgPensions;
	private Label lblPensions;
	private Image imgBank;
	private Label lblBank;
	private Image imgHealth;
	private Label lblHealth;
	private Panel pnlPrincipal;
	private Navigator navigator;
	private PanelFooter panelFooter;
	public static String NAMEAFILIATE = "";
	private User user;
	
	public Affiliate(Navigator navigator,User user){
		
		this.navigator= navigator;
		
		panelFooter = new PanelFooter();
        
		this.user=user;
		System.out.println("Afiliado"+user);
		FormLayout layoutprincipal = new FormLayout();
		layoutprincipal.setSizeFull();
		layoutprincipal.setVisible(true);
		layoutprincipal.setStyleName("v-SIDEBAR");
		
		FormLayout layoutPanel= new FormLayout();
		layoutPanel.setSizeFull();
		layoutPanel.setVisible(true);
	
		FormLayout layoutInvi = new FormLayout();
		layoutInvi.setSizeFull();
		layoutInvi.setVisible(true);
		
		HorizontalLayout horizontal = new HorizontalLayout();
		
		VerticalLayout verticalPension = new VerticalLayout();
		
		VerticalLayout verticalBank = new VerticalLayout();
		
		VerticalLayout verticalHealth = new VerticalLayout();
		
		pnlPrincipal = new Panel();
		pnlPrincipal.setSizeFull();
		pnlPrincipal.setWidth("500px");
		pnlPrincipal.setHeight("450px");
		
		
		this.imgPensions = new Image("Fondo Pension");
		ThemeResource resource1 = new ThemeResource("../Imagen/pension.png");
		imgPensions = new Image(null, resource1);
		this.imgPensions.setWidth("100px");
		this.imgPensions.setHeight("100px");
		this.imgPensions.setVisible(true);
		
        this.imgPensions.addClickListener(new ClickListener() {
			
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub		
				navigator.addView(Simulator.NAMESIMULATOR,  new Simulator(navigator,user));
				navigator.navigateTo(Simulator.NAMESIMULATOR);
//				navegator();			
			}
		});
		
		this.lblPensions = new Label("Fondo Pension");
		this.lblPensions.setVisible(true);
		
		this.imgBank = new Image("Entidad Banco");
		ThemeResource resource2 = new ThemeResource("../Imagen/Banco.png");
		
		imgBank = new Image(null, resource2);
		this.imgBank.setWidth("100px");
		this.imgBank.setHeight("100px");
		this.imgBank.setVisible(true);
		 this.imgBank.addClickListener(new ClickListener(){
			 public void click(ClickEvent event) {
					// TODO Auto-generated method stub				
				    //navegacion para los bancos
				 
				 navigator.addView(EntityBank.NAMEENTITYBANK,  new EntityBank(navigator,user));
				 navigator.navigateTo(EntityBank.NAMEENTITYBANK);
				}
		 });
		this.lblBank = new Label("Entidad Banco");
		this.lblBank.setVisible(true);
		
		this.imgHealth = new Image("Entidad Salud");
		ThemeResource resource3 = new ThemeResource("../Imagen/salud.png");
		imgHealth = new Image(null, resource3);
		this.imgHealth.setWidth("100px");
		this.imgHealth.setHeight("100px");
		this.imgHealth.setVisible(true);
		 this.imgHealth.addClickListener(new ClickListener(){
			 public void click(ClickEvent event) {
					// TODO Auto-generated method stub				
				    navigator.addView(EntityHealth.NAMESENTITYHEALTH,  new EntityHealth(navigator,user));
					navigator.navigateTo(EntityHealth.NAMESENTITYHEALTH);
				}
		 });
		
		this.lblHealth = new Label("Entidad Salud");
		this.lblHealth.setVisible(true);
		

		layoutprincipal.addComponent(pnlPrincipal);
		layoutprincipal.addComponent(panelFooter);
		
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

		this.pnlPrincipal.setContent(layoutInvi);
        this.pnlPrincipal.setContent(layoutPanel);
        
       
		this.setCompositionRoot(layoutprincipal);
		
		this.setSizeFull();		
	}
	
	private void navegator(){
		navigator.addView(Simulator.NAMESIMULATOR,  new Simulator(navigator,user));
		navigator.navigateTo(Simulator.NAMESIMULATOR);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
