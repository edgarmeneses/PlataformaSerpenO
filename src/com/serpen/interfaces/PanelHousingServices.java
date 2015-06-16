package com.serpen.interfaces;

import java.util.List;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.ServiceFund;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;
import com.serpen.persistence.control.ControlServiceFund;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

import org.apache.bcel.generic.RETURN;
import org.hibernate.Session;

@SuppressWarnings("serial")
public class PanelHousingServices extends Panel{

	private Label tittleFeatures;
	private Label features;
	private Label titleBenefict;
	private Label benefict;
	private Table services;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	private Panel pnlSearch;

	
	private ControlServiceFund controlServiceFund;
	
	public PanelHousingServices(){

		Session session= HibernateUtil.getSessionFactory().openSession();
		controlServiceFund = new ControlServiceFund(session);

		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setVisible(true);

		FormLayout layoutTable = new FormLayout();
		layoutTable.setVisible(true);
		
		HorizontalLayout layoutSearch = new HorizontalLayout();
		layoutSearch.setVisible(true);

		VerticalLayout layoutContent = new VerticalLayout();
		layoutContent.setVisible(true);

		Panel content = new Panel();
		content.setSizeFull();


		Panel table = new Panel();
		table.setSizeFull();
		
		pnlSearch = new Panel();
		pnlSearch.setSizeFull();
		pnlSearch.setWidth("1000");
		pnlSearch.setHeight("100");
		
		//table.setWidth("1000px");
		//table.setHeight("300px");


		tittleFeatures = new Label("Caracteristicas");		
//		tittleFeatures.setWidth("100px");
//		tittleFeatures.setHeight("50px");
//		tittleFeatures.setVisible(true);
		
		features = new Label(".....................");
		
		titleBenefict = new Label("Beneficios");
		
		benefict= new Label(".....................");


		lblSearch = new Label("Nombre");
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
		
		services = new Table();
		//	    table.setWidth("100%"); //Ocupa todo el ancho del navegador
		//	    table.setHeight("170px"); //Altura del Grid.

		// Definir  columnas 
		services.addContainerProperty("Tasa Interes", String.class, null);
		services.addContainerProperty("Descripcion", String.class, null);
		services.addContainerProperty("Contacto", String.class, null);
//		fillTable();
		//	    Añadir algunas otras filas utilizando addItem
		//		table.addItem(new Object[]{"123", "admin" , "Actico", new PanelControlList()}, 2);
		//		table.addItem(new Object[] { " " ," " , " ", new PanelControlList()},3);

		//Mostrar exactamente el momento contenían fila
		services.setPageLength(services.size());  
		services.setWidth("80%"); //Ocupa todo el ancho del navegador
		services.setHeight("170px"); //Altura del Grid.
		services.setFooterVisible(true);

		layoutContent.addComponent(tittleFeatures);
		layoutContent.addComponent(features);
		layoutContent.addComponent(titleBenefict);
		layoutContent.addComponent(benefict);
		
		layoutSearch.addComponent(lblSearch);
        layoutSearch.addComponent(txtSearch);
        layoutSearch.addComponent(btnSearch);
        this.pnlSearch.setContent(layoutSearch);        
		table.setContent(services);


		content.setContent(layoutContent);
		//table.setContent(layoutTable);

		layoutPrincipal.addComponent(content);
		layoutPrincipal.addComponent(pnlSearch);
		layoutPrincipal.addComponent(table);

		setContent(layoutPrincipal);
		//setSizeFull();
		//this.setCompositionRoot(layoutPrincipal);	
		//this.setSizeFull();	 

	}

	/**
	 * Para consuktar los usuarios que hay 
	 * @param user
	 * @return
	 */
	public Object[] fillRow(ServiceFund serviceFund){
		return new Object[]{String.valueOf(serviceFund.getInterest()), String.valueOf(serviceFund.getDescription()), String.valueOf(serviceFund.getInformation())};

	}

	/**
	 * Agrega los usuarios a la tabla 
	 * @return
	 */

	public void fill()throws ErrorConnection{
		List<ServiceFund> serviceFund =  controlServiceFund.listaEntity('V');
		try {
			serviceFund = controlServiceFund.listoServiceFund(txtSearch.getValue());
			for (int i = 0; i < serviceFund.size(); i++) {
				System.out.println("lista servicio fondo " + fillRow(serviceFund.get(i)));
				
			}
			services.removeAllItems();
			
			for (int i = 0; i < serviceFund.size(); i++) {
				services.addItem(fillRow(serviceFund.get(i)),i);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}

