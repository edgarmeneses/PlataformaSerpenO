package com.serpen.interfaces;
import com.serpen.logic.entity.PensionFund;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class PanelSimulator extends Panel implements View{

    private Label lblSimulador;
    private Label lblSalary;
    private TextField txtSalary;
    private Button btnSimulator;
    private Label lblWorkedDays;
    private TextField txtWorkedDays;
    private Panel pnlsimulator;
    private PensionFund pensionFund;
   
    
    public PanelSimulator() {
    	
    	pensionFund = new PensionFund();
    	FormLayout layoutPrincipal = new FormLayout();
    	layoutPrincipal.setSizeFull();
    	layoutPrincipal.setVisible(true);
    	
    	
    	FormLayout layoutPanel = new FormLayout();
    	layoutPanel.setSizeFull();
    	layoutPanel.setVisible(true);
    	
//    	VerticalLayout layoutVertical = new VerticalLayout();
    	
    	HorizontalLayout layoutSimulator  = new HorizontalLayout();
    	
    	HorizontalLayout layoutIngre = new HorizontalLayout();
    	HorizontalLayout layoutDays =  new HorizontalLayout();
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
    	
    	lblWorkedDays = new Label("Ingrese  los dias trabajados");
    	lblWorkedDays.setVisible(true);
    	
    	txtWorkedDays = new TextField();
    	txtWorkedDays.setVisible(true);
    	
    	btnSimulator = new Button("Simular");
    	btnSimulator.setVisible(true);
    	btnSimulator.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				double Unemployment= pensionFund.UnemploymentCalculate(Integer.valueOf(txtWorkedDays.getValue()), Integer.valueOf(txtSalary.getValue()));
			   System.out.println(Unemployment);
			}
		});
    	
    	layoutPrincipal.addComponent(pnlsimulator);
        	
    	layoutSimulator.addComponent(lblSimulador);
    	
    	layoutIngre.addComponent(lblSalary);
    	layoutIngre.addComponent(txtSalary);
    	
    	layoutDays.addComponent(lblWorkedDays);
    	layoutDays.addComponent(txtWorkedDays);
    	
    	layoutbutton.addComponent(btnSimulator);
    	
    	layoutPanel.addComponent(layoutSimulator);
    	layoutPanel.addComponent(layoutIngre);
    	layoutPanel.addComponent(layoutDays);
    	layoutPanel.addComponent(layoutbutton);
    	
    	
    	this.pnlsimulator.setContent(layoutPanel);
    	this.setContent(layoutPrincipal);
    	this.setSizeFull();
    }

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
