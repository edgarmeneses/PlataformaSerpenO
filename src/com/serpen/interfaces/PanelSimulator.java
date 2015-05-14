package com.serpen.interfaces;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelSimulator extends Panel{

    private Label lblSimulador;
    private Label lblSalary;
    private TextField txtSalary;
    private Button btnSimulator;
    private Panel pnlsimulator;
    
    public PanelSimulator() {
    	
    	FormLayout layoutPrincipal = new FormLayout();
    	layoutPrincipal.setSizeFull();
    	layoutPrincipal.setVisible(true);
    	
    	FormLayout layoutPanel = new FormLayout();
    	layoutPanel.setSizeFull();
    	layoutPanel.setVisible(true);
    	
//    	VerticalLayout layoutVertical = new VerticalLayout();
    	
    	HorizontalLayout layoutSimulator  = new HorizontalLayout();
    	
    	HorizontalLayout layoutIngre = new HorizontalLayout();
    	
    	HorizontalLayout layoutbutton = new HorizontalLayout();
    	
    	pnlsimulator = new Panel();
    	pnlsimulator.setWidth("400px");
    	pnlsimulator.setHeight("300px");
    	
    	lblSimulador = new Label("SIMULADOR DE CESANTIAS");
    	lblSimulador.setVisible(true);
    	
    	lblSalary = new Label("Ingrese Sueldo");
    	lblSalary.setVisible(true);
    	
    	txtSalary = new TextField();
    	txtSalary.setVisible(true);
    	
    	btnSimulator = new Button("Simular");
    	btnSimulator.setVisible(true);
    	
    	layoutPrincipal.addComponent(pnlsimulator);
        	
    	layoutSimulator.addComponent(lblSimulador);
    	
    	layoutIngre.addComponent(lblSalary);
    	layoutIngre.addComponent(txtSalary);
    	
    	layoutbutton.addComponent(btnSimulator);
    	
    	layoutPanel.addComponent(layoutSimulator);
    	layoutPanel.addComponent(layoutIngre);
    	layoutPanel.addComponent(layoutbutton);
    	
    	
    	this.pnlsimulator.setContent(layoutPanel);
    	this.setContent(layoutPrincipal);
//    	this.setCompositionRoot(layoutPrincipal);
    	this.setSizeFull();
    }
}
