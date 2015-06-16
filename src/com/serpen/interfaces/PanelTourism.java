package com.serpen.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.ServiceFund;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlServiceFund;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class PanelTourism extends Panel {
	
	private Panel pnlImage;
	private Image imagen;
	private Panel pnlTable;
	private Table table;
	private Panel pnlDescription;
	private Label lblName;
	private Label lblAdress;
	private Label lblTelephon;
	
	private Panel pnlSearch;
	private Label lblSearch;
	private TextField txtSearch; 
	private Button btnSearch;
	
	private ControlServiceFund controlServiceFund;
	private ServiceFund fund;
	
	public PanelTourism(){
		
		Session session= HibernateUtil.getSessionFactory().openSession();
		controlServiceFund = new ControlServiceFund(session);
		fund = new ServiceFund();
		
		FormLayout layoutGeneral = new FormLayout();
		layoutGeneral.setVisible(true);
		
		FormLayout formImage = new FormLayout();
		formImage.setVisible(true);
		
		FormLayout formTable = new FormLayout();
		formTable.setVisible(true);
		
		HorizontalLayout layoutSearch = new HorizontalLayout();
		layoutSearch.setVisible(true);
		
		FormLayout formDescription = new FormLayout();
		formDescription.setVisible(true);
		
		VerticalLayout horizontalLayout = new VerticalLayout();
		
		pnlImage = new Panel("Image");
		pnlImage.setSizeFull();
		pnlImage.setWidth("1000px");
		pnlImage.setHeight("600px");
		
		pnlTable = new Panel("Table");
		pnlTable.setSizeFull();
		pnlTable.setWidth("1000px");
		pnlTable.setHeight("400px");
		
		pnlSearch = new Panel();
		pnlSearch.setSizeFull();
		pnlSearch.setWidth("1000");
		pnlSearch.setHeight("100");
		
		imagen = new Image();
		ThemeResource resource = new ThemeResource("../Imagen/mexico.jpg");
		this.imagen = new Image(null,resource);
		this.imagen.setWidth("300px");
		this.imagen.setHeight("200px");
		this.setVisible(true);
		//300  y 200
		
		lblSearch = new Label("Plan");
		lblSearch.setVisible(true);
		
		txtSearch = new TextField();
		txtSearch.setWidth("150px");
		txtSearch.setHeight("50px");
		txtSearch.setRequired(true);
		txtSearch.setValue("");
		txtSearch.setNullRepresentation("");
		txtSearch.setVisible(true);
		
		btnSearch = new Button("Buscar");
		btnSearch.setWidth("150px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);
		
		btnSearch.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub	
			   
					try {
						fill();
					} catch (ErrorConnection e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}	
		});
		
		table = new Table();
		
		table.setPageLength(table.size());
		table.setWidth("80%"); 
		table.setHeight("180px");
		table.setFooterVisible(true);
			
		table.addContainerProperty("Plan", String.class, null);
		table.addContainerProperty("Costo", String.class, null);
		table.addContainerProperty("Duracion", String.class, null);
		table.addContainerProperty("Caracteristica", String.class, null);
		
//		table.addItem(new Object[] { " " ," " , " ", " "},2);
//		table.addItem(new Object[] { " " ," " , " ", " "},3);
		
		lblName = new Label("Centro vacacional canapro");
		lblName.setVisible(true);
		
		lblAdress = new Label("Ubicado en calle 2 N 15-34");
		lblAdress.setVisible(true);
		
		lblTelephon = new Label("Tel : 7440904");
		lblTelephon.setVisible(true);
		
		
		formImage.addComponent(imagen);
		formTable.addComponent(table);
	    layoutSearch.addComponent(lblSearch);
	    layoutSearch.addComponent(txtSearch);
	    layoutSearch.addComponent(btnSearch);
	        
		horizontalLayout.addComponent(lblName);
		horizontalLayout.addComponent(lblAdress);
		horizontalLayout.addComponent(lblTelephon);
		
		formDescription.addComponent(horizontalLayout);
		this.pnlSearch.setContent(layoutSearch);
		
		layoutGeneral.addComponent(formImage);
		layoutGeneral.addComponent(pnlSearch);
		layoutGeneral.addComponent(formTable);
		layoutGeneral.addComponent(formDescription);
		
		
		setContent(layoutGeneral);
				
		
	}
	
	public Object[] fillRow(ServiceFund serviceFund){
		return new Object[]{String.valueOf(serviceFund.getName()) , String.valueOf(serviceFund.getValue()), String.valueOf(serviceFund.getDuration()), String.valueOf(serviceFund.getInformation())};
		
	}
	
	public void fill() throws ErrorConnection{
//		if (controlServiceFund.listaEntity('T') = fund.getEntity().getEntityType('E')) {
			
//		}
		List<ServiceFund> serviceFund ;
		try {
			
			serviceFund = controlServiceFund.listoServiceFund(txtSearch.getValue());
			
			for (int i = 0; i < serviceFund.size(); i++) {
				System.out.println("service fund" + serviceFund);
				System.out.println("lista turismo fondo " + fillRow(serviceFund.get(i)));
			}
			
			table.removeAllItems();
			for (int i = 0; i < serviceFund.size(); i++) {
				  	if (serviceFund.get(i).getEntity().getEntityType() == 'T') {
                		table.addItem(fillRow(serviceFund.get(i)),i);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
