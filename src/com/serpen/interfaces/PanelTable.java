package com.serpen.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Catalog;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlCatalog;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class PanelTable extends Panel{
	
	private Table table;
	private Panel panelTable;
	private Navigator navigator;
	private Label lblService; 
	private TextField txtService;
	private Button btnSearch;
	private Panel pnlSearch; 
	private Panel pnlTitle;
	private Label lblTitle;
	private ControlCatalog controlCatalog;
	
	public PanelTable(Navigator navigator){
		 
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		this.navigator = navigator;
        controlCatalog = new ControlCatalog(session, transaction);
			
		FormLayout layoutGeneral  = new FormLayout();
		layoutGeneral.setVisible(true);
		
		FormLayout formTable = new FormLayout();
		formTable.setVisible(true);
		
		FormLayout formSearch = new FormLayout();
		formSearch.setVisible(true);
		
		FormLayout formTitle = new FormLayout();
		formTitle.setVisible(true);
		
		HorizontalLayout horizontalLayoutSearch = new HorizontalLayout();
		horizontalLayoutSearch.setVisible(true);
		
		HorizontalLayout horizontalLayoutTitle = new HorizontalLayout();
		horizontalLayoutSearch.setVisible(true);
		pnlTitle =new Panel();
		pnlTitle.setSizeFull();
		pnlTitle.setWidth("1000");
		pnlTitle.setHeight("80");
		
		pnlSearch = new Panel();
		pnlSearch.setSizeFull();
		pnlSearch.setWidth("1000");
		pnlSearch.setHeight("100");
//		pnlSearch.setVisible(true);
				
		panelTable = new Panel();
		panelTable.setWidth("1000px");
		panelTable.setHeight("400px");
		panelTable.setSizeFull();
		panelTable.setVisible(true);
		
		lblTitle = new Label("Lista de servicios");		
		lblTitle.setWidth("200px");
		lblTitle.setHeight("50px");
		lblTitle.setVisible(true);
		
		lblService = new Label("Servicio");
		lblService.setWidth("100px");
		lblService.setHeight("50px");
		lblService.setVisible(true);
		
		txtService = new TextField();
		txtService.setWidth("150px");
		txtService.setHeight("50px");
		
       
		btnSearch= new  Button("Buscar");
		btnSearch.setWidth("150px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);
		
		btnSearch.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub	
			 fill();
				
			}
		});
			
		 table = new Table();
			
	        table.setPageLength(table.size());
			table.setWidth("80%"); 
			table.setHeight("180px");
			table.setFooterVisible(true);
			
			table.addContainerProperty("Servicio", String.class, null);
			table.addContainerProperty("Descripcion", String.class, null);
			table.addContainerProperty("Informacion", String.class, null);
			table.addContainerProperty("Direccion", String.class, null);
			table.addContainerProperty("Telefono", String.class, null);
			//fill();
		
		formTable.addComponent(table);
		
		horizontalLayoutSearch.addComponent(lblService);
		horizontalLayoutSearch.addComponent(txtService);
		horizontalLayoutSearch.addComponent(btnSearch);
		
		horizontalLayoutTitle.addComponent(lblTitle);
		
		formSearch.addComponent(horizontalLayoutSearch);
		formTitle.addComponent(horizontalLayoutTitle);
		
		this.panelTable.setContent(formTable);
		this.pnlSearch.setContent(formSearch);
		this.pnlTitle.setContent(formTitle);
		
		layoutGeneral.addComponent(pnlTitle);
		layoutGeneral.addComponent(pnlSearch);
		layoutGeneral.addComponent(panelTable);
			
		setContent(layoutGeneral);
	}
	
	public Object[] fillRow(Catalog catalog){
		
		return new Object[]{catalog.getService().getName(),catalog.getService().getDescription(),catalog.getCarecenter().getName(),catalog.getCarecenter().getAddress(),catalog.getCarecenter().getPhone()};
		
	}
	public void fill(){
		try {
			 List<Catalog> catalogo= controlCatalog.list(txtService.getValue());
			   
			 for (int i = 0; i < catalogo.size(); i++) {
				  System.out.println("lista Ejemplo: "+fillRow(catalogo.get(i)));
			}
			 table.removeAllItems();	   
			   for (int i = 0; i < catalogo.size(); i++) {
				  
				    table.addItem(fillRow(catalogo.get(i)),i);		
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
