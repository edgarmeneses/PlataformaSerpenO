package com.serpen.interfaces;


import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.ServiceFund;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;
import com.serpen.persistence.control.ControlServiceFund;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

import org.hibernate.Session;


public class PanelServiceEducation extends Panel{
	
	private Label lblUser;
	private Label lblPhone;
	private Label lblAddress;
	private Label lbltitle;
	private Label txtUser;
	private Label txtPhone;
	private Label txtAddress;
	private Button btnReturn;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	private Panel pnlSearch;
	private Table table;
	private Panel pnlMenu;
	
	private Panel pnlTable;
	private Panel pnlTitle;
	
	private ControlServiceFund controlServiceFund;

	
	public PanelServiceEducation() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		controlServiceFund = new ControlServiceFund(session);
		
		FormLayout layoutPrin = new FormLayout();
		layoutPrin.setVisible(true);
		
		FormLayout layoutTable = new FormLayout();
		layoutTable.setVisible(true);
		
		FormLayout layoutPanelInfo = new FormLayout();
		layoutPanelInfo.setVisible(true);
		
		HorizontalLayout layoutTitle = new HorizontalLayout();
		layoutTitle.setVisible(true);
		
		HorizontalLayout layoutSearch = new HorizontalLayout();
		layoutSearch.setVisible(true);
		
		HorizontalLayout layoutUser = new HorizontalLayout();
		layoutUser.setVisible(true);
		
		HorizontalLayout layoutPhone = new HorizontalLayout();
		layoutPhone.setVisible(true);
		
		HorizontalLayout layoutAddress= new HorizontalLayout();
		layoutAddress.setVisible(true);
		
		
		pnlTitle =new Panel();
		pnlTitle.setSizeFull();
		pnlTitle.setWidth("1000");
		pnlTitle.setHeight("80");
		
		pnlMenu = new Panel();
		pnlMenu.setSizeFull();
		pnlMenu.setWidth("1000");
		pnlMenu.setHeight("250");
		
		pnlSearch = new Panel();
		pnlSearch.setSizeFull();
		pnlSearch.setWidth("1000");
		pnlSearch.setHeight("100");
		
		pnlTable = new Panel();
     	pnlTable.setSizeFull();
		pnlTable.setWidth("1000px");
		pnlTable.setHeight("400px");
		pnlTable.setVisible(true);

		lbltitle = new Label("Convenio Educativo");		
		lbltitle.setWidth("200px");
		lbltitle.setHeight("50px");
		lbltitle.setVisible(true);
		
		lblUser = new Label("Usuario:");		
		lblUser.setWidth("100px");
		lblUser.setHeight("50px");
		lblUser.setVisible(true);

		txtUser = new Label("Jose Torres");
		txtUser.setWidth("150px");
		txtUser.setHeight("50px");
		
		lblPhone = new Label("Telefono:");		
		lblPhone.setWidth("100px");
		lblPhone.setHeight("50px");
		lblPhone.setVisible(true);

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
	
		
		btnReturn= new  Button("Regresar");
		btnReturn.setWidth("150px");
		btnReturn.setHeight("50px");
		btnReturn.setVisible(true);
	
		lblSearch = new Label("Carrera");
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

	    table.addContainerProperty("Carrera", String.class, null);
	    table.addContainerProperty("Codigo Carrera", String.class, null);
	    table.addContainerProperty("Descuento", String.class, null);
	    table.addContainerProperty("Informacion", String.class, null);

//	    table.addItem(new Object[]{" ", " " , " ", " "}, 2);
//	    table.addItem(new Object[] { " " ," " , " ", " "},3);

	    table.setPageLength(table.size());  
	    table.setWidth("80%"); //Ocupa todo el ancho del navegador
	    table.setHeight("170px"); //Altura del Grid.
	    table.setFooterVisible(true);
		
	    layoutTitle.addComponent(lbltitle);
		layoutTable.addComponent(table);
		layoutTable.addComponent(btnReturn);
		
		layoutPanelInfo.addComponent(layoutUser);
		layoutPanelInfo.addComponent(layoutPhone);
		layoutPanelInfo.addComponent(layoutAddress);
		
	    layoutUser.addComponent(lblUser);
		layoutUser.addComponent(txtUser);
	    layoutPhone.addComponent(lblPhone);
		layoutPhone.addComponent(txtPhone);
	    layoutAddress.addComponent(lblAddress);
		layoutAddress.addComponent(txtAddress);
		
        layoutSearch.addComponent(lblSearch);
        layoutSearch.addComponent(txtSearch);
        layoutSearch.addComponent(btnSearch);
        
		
		this.pnlTitle.setContent(layoutTitle);
		this.pnlSearch.setContent(layoutSearch);
		this.pnlTable.setContent(layoutTable);
		this.pnlMenu.setContent(layoutPanelInfo);
	
		
		layoutPrin.addComponent(pnlTitle);
		layoutPrin.addComponent(pnlSearch);
		layoutPrin.addComponent(pnlTable);
		layoutPrin.addComponent(pnlMenu);
		
		setContent(layoutPrin);
	
	}
	
	
	public Object[] fillRow(ServiceFund serviceFund){
		return new Object[]{String.valueOf(serviceFund.getName()) , String.valueOf(serviceFund.getId()) , String.valueOf(serviceFund.getDiscount()), String.valueOf(serviceFund.getInformation())};
		
	}
	
	public void fill() throws ErrorConnection{
		List<ServiceFund> serviceFund =  controlServiceFund.listaEntity('E');
		try {
			serviceFund = controlServiceFund.listoServiceFund(txtSearch.getValue());
			for (int i = 0; i < serviceFund.size(); i++) {
				System.out.println("lista servicio fondo " + fillRow(serviceFund.get(i)));
				
			}
			table.removeAllItems();
			
			for (int i = 0; i < serviceFund.size(); i++) {
				table.addItem(fillRow(serviceFund.get(i)),i);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
