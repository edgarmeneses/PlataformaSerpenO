package com.serpen.interfaces;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JComboBox;

import org.hibernate.ObjectNotFoundException;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.HealthEntity;
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
	private Label lblTitulo;
	private TextField txtname;
	private TextField txtLastName;
	private TextField txtAddres;
	private TextField txtPhone;
	private Image lblImagen;
	private ComboBox txtHealth;
	private Button btnNew;
	private Button btnCancel;
	private Panel panel;
	private Label label;
	private Navigator navigator;
	private ControlGeneral control;
	private User userChange;
	private final String TITTLE1="Crear Usuario - Informacion Personal";
	private final String TITTLE2="Editar Usuario - Informacion Personal";

	/**
	 * Constructor que se pide por parametro 
	 * @param navigator
	 * @param control
	 * Instancia los componentes que se van a pintar en la clase Create User
	 */
	public PanelPersonalInformation (Navigator navigator, ControlGeneral control,String action) {

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
		if(action.equals(HomePageCreateUser.NAMEHOMECREATEUSER)){
			lblTitulo = new Label(TITTLE1);
		}else{
			lblTitulo = new Label(TITTLE2);
		}
		txtname = new TextField("Nombre");
		txtLastName = new TextField("Apellido");
		//		txtLastName.setRequired(true);
		//		txtLastName.setValue("");
		//		txtLastName.setNullRepresentation("");
		txtAddres = new TextField("Direccion");
		txtPhone = new TextField("Telefono");

		txtHealth = new ComboBox("Entidad de Salud",listEntity());
		txtHealth.setInputPrompt("Seleccionar Entidad:");
		txtHealth.setInvalidAllowed(false);

		VerticalLayout layoutEnti = new VerticalLayout();

		ThemeResource resource = new ThemeResource("../Imagen/usuarioper.png");
		lblImagen = new Image(null, resource);
		this.lblImagen.setVisible(true);
		this.lblImagen.setWidth("300px");
		this.lblImagen.setHeight("300px");

		HorizontalLayout layoutbutton = new HorizontalLayout();

		btnNew = new Button("Guardar");		
		btnNew.addClickListener(new ClickListener() {		
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
					selectAction();
				
			}
		});	
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


		Panel titulo = new Panel();
		titulo.setSizeFull();
		titulo.setWidth("700px");
		titulo.setHeight("50px");

		titulo.setContent(lblTitulo);

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

		layoutPrincipal.addComponent(titulo);
		layoutPrincipal.addComponent(panel);

		this.panel.setContent(layoutPanel);


		setContent(layoutPrincipal);

	}

	public void change(){
		btnNew.setCaption("Cambiar");
		txtHealth.setEnabled(false);
	}

	public void addUser(User user){
		this.userChange=user;
		this.txtAddres.setValue(user.getAddress());
		this.txtHealth.setValue(user.getHealthEntity().getName());
		this.txtLastName.setValue(user.getLastName());
		this.txtname.setValue(user.getName());
		this.txtPhone.setValue(user.getNumberPhone());
	}

	private void selectAction() {
		switch (btnNew.getCaption().toString()) {
		case "Guardar":
			insert();
			break;
		case "Cambiar":
			update(this.userChange);
			break;
		default:
			break;
		}
	}

	private void insert(){

	}

	private void update(User user) {
		try {
			control.getUser().update(user.getNickname(), user.getPassword(), user.getAnswer(),
					txtname.getValue().toString(), txtLastName.getValue().toString(), txtAddres.getValue().toString(),
					txtPhone.getValue().toString());
			Notification.show("Cambio realizado exitosamente");
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			Notification.show("No se ha podido ralizar el cambio");
		}


	}
	
	private List<String> listEntity(){
		List<HealthEntity> healths = control.getlHealth().list();
		List<String> names= new LinkedList<String>();
		
		for (HealthEntity entity : healths) {
			names.add(entity.getName());
		}
		return names;
	}
}
