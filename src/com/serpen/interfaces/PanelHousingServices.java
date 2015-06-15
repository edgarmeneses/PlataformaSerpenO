package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
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

@SuppressWarnings("serial")
public class PanelHousingServices extends Panel{

	private Label tittleFeatures;
	private Label features;
	private Label titleBenefict;
	private Label benefict;
	private Table services;

	public PanelHousingServices(){

		

		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setVisible(true);

		FormLayout layoutTable = new FormLayout();
		layoutTable.setVisible(true);

		VerticalLayout layoutContent = new VerticalLayout();
		layoutContent.setVisible(true);

		Panel content = new Panel();
		content.setSizeFull();


		Panel table = new Panel();
		table.setSizeFull();
		//table.setWidth("1000px");
		//table.setHeight("300px");


		tittleFeatures = new Label("Caracteristicas");		
//		tittleFeatures.setWidth("100px");
//		tittleFeatures.setHeight("50px");
//		tittleFeatures.setVisible(true);
		
		features = new Label(".....................");
		
		titleBenefict = new Label("Beneficios");
		
		benefict= new Label(".....................");


		services = new Table();
		//	    table.setWidth("100%"); //Ocupa todo el ancho del navegador
		//	    table.setHeight("170px"); //Altura del Grid.

		// Definir  columnas 
		services.addContainerProperty("Tasa Iteres", String.class, "0%");
		services.addContainerProperty("Descriocion", String.class, "sin descripcion");
		services.addContainerProperty("Contacto", String.class, "@contacto");
		fillTable();
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
		
		table.setContent(services);


		content.setContent(layoutContent);
		//table.setContent(layoutTable);

		layoutPrincipal.addComponent(content);
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
	public Object[] fillRow(User user){
		return new Object[]{};

	}

	/**
	 * Agrega los usuarios a la tabla 
	 * @return
	 */

	public void fillTable(){
		services.addItem();
		services.addItem();
	}


}

