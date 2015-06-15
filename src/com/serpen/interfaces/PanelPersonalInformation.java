package com.serpen.interfaces;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.ObjectNotFoundException;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")

/**
 * asigna el tema a la clase que se desea modelar
 * @author 
 *
 */
@Theme("themeCreateUser")
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de Panel create User
 *extiende de Panel
 */
public class PanelPersonalInformation extends Panel{

	/**
	 * Atributos de la clase panel create user
	 */
	private Label lblCreateUser;
	private TextField txtname;
	private TextField txtLastName;
	private TextField txtAddres;
	private TextField txtPhone;
	private Image lblImagen;
	private TextField txtHealth;
	private Button btnNew;
	private Button btnCancel;
	private Panel panel;
	private Label label;
	private Navigator navigator;
	private ControlGeneral control;

	/**
	 * Constructor que se pide por parametro 
	 * @param navigator
	 * @param control
	 * Instancia los componentes que se van a pintar en la clase Create User
	 */
	 public PanelPersonalInformation (Navigator navigator, ControlGeneral control) {

		this.navigator = navigator;
		this.control=control;

		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.beforeClientResponse(false);
		layoutPrincipal.setVisible(true);


		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setVisible(true);

		HorizontalLayout layoutHorizontal = new HorizontalLayout();

		VerticalLayout layoutDatos = new VerticalLayout();

		txtname = new TextField("Nombre");
		txtLastName = new TextField("Apellido");
//		txtLastName.setRequired(true);
//		txtLastName.setValue("");
//		txtLastName.setNullRepresentation("");
		txtAddres = new TextField("Direccion");
		txtPhone = new TextField("Telefono");
		txtHealth = new TextField("Entidad Salud");

		VerticalLayout layoutEnti = new VerticalLayout();

		ThemeResource resource = new ThemeResource("../Imagen/usuarioper.png");
		lblImagen = new Image(null, resource);
		this.lblImagen.setVisible(true);
		this.lblImagen.setWidth("500px");
		this.lblImagen.setHeight("300px");

		HorizontalLayout layoutbutton = new HorizontalLayout();

		btnNew = new Button("Guardar");		
//		btnNew.addClickListener(new ClickListener() {		
//			@Override
//			public void buttonClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//
//				try {
//					int nickame=Integer.valueOf(txtNickname.getValue());
//					String password=txtPassword.getValue();
//					String answer=txtAnswer.getValue();
//					Role role = control.getRole().consultName(rol.getValue().toString());
//					//control.getUser().insert(nickame,password,answer,role);// cambiarla cuando se modifique la interfazS
//					Notification.show("El Usuario  ha sido insertado con exito!");
//				} catch (ErrorConnection e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}		
//			}
//		});	
		btnCancel = new Button("Cancelar");
		btnCancel.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				//navigator.addView(Administrator.NAME3, new );

				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);
			}
		});

		panel = new Panel();
		panel.setSizeFull();
		panel.setWidth("700px");
		panel.setHeight("500px");

		layoutDatos.addComponent(txtname);
		layoutDatos.addComponent(txtLastName);
		layoutDatos.addComponent(txtAddres);
		layoutDatos.addComponent(txtPhone);
		layoutDatos.addComponent(txtHealth);
		
		layoutEnti.addComponent(lblImagen);
				
		layoutbutton.addComponent(btnNew);
		layoutbutton.addComponent(btnCancel);

		layoutHorizontal.addComponent(layoutDatos);
		layoutHorizontal.addComponent(layoutEnti);

		layoutPanel.addComponent(layoutHorizontal);
		layoutPanel.addComponent(layoutbutton);

		layoutPrincipal.addComponent(panel);
		this.panel.setContent(layoutPanel);
		
		
		setContent(layoutPrincipal);

	}
	
//
//    /**
//     * metodo que se encarga de listar los roles 
//     * @return
//     * @throws ErrorConnection
//     */
//	public List<String> rolList() throws ErrorConnection{
//		List<Role> role;
//
//		List<String> nameRole = new LinkedList<String>(); 
//		role = control.getRole().list();
//		System.out.println("rol nuevo "+role);
//		for (int i = 0; i < role.size(); i++) {
//			nameRole.add(role.get(i).getName());
//
//		}
//		System.out.println(nameRole);
//		return nameRole;		
//	}	
}
