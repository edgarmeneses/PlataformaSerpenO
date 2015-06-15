package com.serpen.interfaces;

import java.util.ArrayList;
import java.util.Iterator;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PanelHousingEntity extends Panel{
	
	ArrayList<Image> entitys;
	
	private String [] DEFAULT_ENTITY = {"monteza.gif","impulsa.jpg"};
	
	public PanelHousingEntity() {
		// TODO Auto-generated constructor stub
		entitys = new ArrayList<Image>();
		fillEntitys();
		
		FormLayout layout = new FormLayout();
		
		addEntitys(layout);
		setContent(layout);
		//setSizeFull();
	}
	
	private void fillEntitys(){
		entitys.removeAll(entitys);
		
		for (String string : DEFAULT_ENTITY) {
			Image image = new Image(string);
			ThemeResource resource = new ThemeResource(getPath(string));
			image = new Image(null, resource);
			image.setWidth("50px");
			image.setHeight("50px");
			image.setVisible(true);
			entitys.add(image);
		}
	}
	/**
	 * metodo que permite retornar la ruta donde se encuentra la imagen
	 * @param nombre
	 * @param extencion
	 * @return
	 */
	private String getPath(String nombre,String extencion){
		return "../Vivienda/"
				+ nombre
				+ "."
				+ extencion;
	}
	
	private String getPath(String nombre){
		return "../Vivienda/"
				+ nombre;
	}
	/**
	 * metodo que permite agregar todas las imagenes de las entidades de finca raiz
	 * @param layout
	 */
	private void addEntitys(FormLayout layout){
		layout.removeAllComponents();
		for (Image entidad : entitys) {
			layout.addComponent(entidad);
		}
	}

}
