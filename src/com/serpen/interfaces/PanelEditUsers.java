package com.serpen.interfaces;

import java.util.List;

import org.eclipse.jetty.util.security.Password;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickListener;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de Panel editar User
 *extiende de Panel
 */
public class PanelEditUsers  extends Panel{

	/**
	 * Artributos de la clase Editar usuario
	 */
	private Label lbLabelPrincipal;
	private Image imgPasword;
	private Label lblNewPassword;
	private PasswordField txtNewPassword;
	private Image imgSecurity;
	private Label lblNewSecurityAns;
	private TextField txtNewSecurityAns;
	private Panel panelEdit;
	private Navigator navigator;
	private Button btnAccept;
	private Button btnCancel;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	private Label lblUser;
	private TextField txtUser;
	private Image imgUser;
	private Image imgRol;
	private Label lblRol;
	private TextField txtRol;
	private ControlGeneral control;
	private User user;

	/**
	 * Constructor de la clase Editar Usuario que por parametro pide
	 * @param navigator
	 * @param control
	 */
	public PanelEditUsers(Navigator navigator, ControlGeneral control){
		init(navigator, control);
	}
	/**
	 * Constructor de la clase Editar Usuario que por parametro pide
	 * @param navigator
	 * @param control
	 */
	public PanelEditUsers(Navigator navigator, ControlGeneral control, User user){
		init(navigator, control, user);
	}
	
	/**
	 * Metodoo que se encarga de  instanciar y configurar  Usuarios
	 * @param navigator
	 * @param control
	 */
	private void init(Navigator navigator, ControlGeneral control){
		this.navigator=navigator;
		this.control=control;

		FormLayout formLayoutPrin= new FormLayout();
		formLayoutPrin.setSizeFull();
		formLayoutPrin.beforeClientResponse(false);
		formLayoutPrin.setVisible(true);

		panelEdit = new  Panel();
		panelEdit.setWidth("480px");
		panelEdit.setHeight("500px");

		FormLayout formLayoutEdit = new FormLayout();
		formLayoutEdit.setVisible(true);

		HorizontalLayout layoutSearch= new HorizontalLayout();
		layoutSearch.setVisible(true);

		HorizontalLayout layoutUser = new HorizontalLayout();

		HorizontalLayout layoutRol = new HorizontalLayout();

		HorizontalLayout layautPassword= new HorizontalLayout();


		HorizontalLayout layoutSecurity = new HorizontalLayout();
		HorizontalLayout layoutBtn = new HorizontalLayout();
		layoutBtn.setVisible(true);

		lbLabelPrincipal = new Label("Editar Usuario");
		lbLabelPrincipal.setWidth("150px");
		lbLabelPrincipal.setHeight("50px");
		lbLabelPrincipal.setVisible(true);

		this.imgUser = new Image("Usuario");
		ThemeResource resource2 = new ThemeResource("../Imagen/user.png");
		imgUser = new Image(null, resource2);
		this.imgUser.setVisible(true);

		lblUser = new Label("Usuario");
		lblUser.setWidth("150px");
		lblUser.setHeight("50px");
		lblUser.setEnabled(false);

		txtUser = new TextField();
		txtUser.setWidth("150px");
		txtUser.setHeight("50px");
		txtUser.setVisible(true);

		this.imgRol = new Image("Rol");
		ThemeResource resource3 = new ThemeResource("../Imagen/rol2.jpg");
		imgRol = new Image(null, resource3);
		this.imgRol.setVisible(true);
		this.imgRol.setWidth("50px");
		this.imgRol.setHeight("50px");

		lblRol = new Label("Rol");
		lblRol.setWidth("150px");
		lblRol.setHeight("50px");
		lblRol.setVisible(true);

		txtRol = new TextField();
		txtRol.setWidth("150px");
		txtRol.setHeight("50px");
		txtRol.setVisible(true);


		this.imgPasword = new Image("Constraseņa");
		ThemeResource resource = new ThemeResource("../Imagen/constrase_a_converted.png");
		imgPasword =new Image (null, resource);
		this.imgPasword.setVisible(true);

		lblNewPassword = new Label("Contraseņa");
		lblNewPassword.setWidth("150px");
		lblNewPassword.setHeight("50px");
		lblNewPassword.setVisible(true);

		txtNewPassword = new PasswordField();
		txtNewPassword.setWidth("150px");
		txtNewPassword.setHeight("50px");
		txtNewPassword.setVisible(true);


		this.imgSecurity = new Image("Constraseņa");
		ThemeResource resource1 = new ThemeResource("../Imagen/profesor.jpg");
		imgSecurity =new Image (null, resource1);
		this.imgSecurity.setVisible(true);

		lblNewSecurityAns = new Label("Respuesta  Seguridad");
		lblNewSecurityAns.setWidth("150px");
		lblNewSecurityAns.setHeight("50px");
		lblNewSecurityAns.setVisible(true);

		txtNewSecurityAns = new TextField();
		txtNewSecurityAns.setWidth("150px");
		txtNewSecurityAns.setHeight("50px");
		txtNewSecurityAns.setVisible(true);

		btnAccept = new Button("Aceptar");
		btnAccept.setWidth("100px");
		btnAccept.setHeight("50px");
		btnAccept.setVisible(true);
		btnAccept.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

//				try {
//					control.getUser().upDate(Integer.valueOf(txtUser.getValue()), txtNewPassword.getValue(), txtNewSecurityAns.getValue());
//				} catch (NumberFormatException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ErrorConnection e) {
//					// TODO Auto-generated catch block
//					System.out.println("no sirve");
//					e.printStackTrace();
//				}
			}
		});

		btnCancel = new Button("Cancelar");
		btnCancel.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);

			}
		});
		btnCancel.setWidth("100px");
		btnCancel.setHeight("50px");


		btnSearch= new Button("Buscar");
		btnSearch.setWidth("100px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);
		btnSearch.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					//User user = control.getUser().consult(Integer.valueOf(txtSearch.getValue()));

					txtUser.setValue(String.valueOf(user.getNickname()));
					txtUser.setEnabled(false);
					txtRol.setValue(user.getRol().getName());
					txtRol.setEnabled(false);
					txtNewPassword.setValue(user.getPassword());
					txtNewSecurityAns.setValue(user.getAnswer());

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			}
		});

		lblSearch  = new Label("Usuario");
		lblSearch.setWidth("150px");
		lblSearch.setHeight("50px");
		lblSearch.setVisible(true);

		txtSearch= new TextField();
		txtSearch.setWidth("150px");
		txtSearch.setHeight("50px");
		txtSearch.setVisible(true);

		formLayoutEdit.addComponent(lbLabelPrincipal);
		formLayoutEdit.addComponent(layoutSearch);
		formLayoutEdit.addComponent(layoutUser);
		formLayoutEdit.addComponent(layoutRol);
		formLayoutEdit.addComponent(layautPassword);
		formLayoutEdit.addComponent(layoutSecurity);
		formLayoutEdit.addComponent(layoutBtn);


		layoutSearch.addComponent(lblSearch);
		layoutSearch.addComponent(txtSearch);
		layoutSearch.addComponent(btnSearch);
		layautPassword.addComponent(imgPasword);
		layautPassword.addComponent(lblNewPassword);
		layautPassword.addComponent(txtNewPassword);

		layoutUser.addComponent(imgUser);
		layoutUser.addComponent(lblUser);
		layoutUser.addComponent(txtUser);

		layoutRol.addComponent(imgRol);
		layoutRol.addComponent(lblRol);
		layoutRol.addComponent(txtRol);

		layoutSecurity.addComponent(imgSecurity);
		layoutSecurity.addComponent(lblNewSecurityAns);
		layoutSecurity.addComponent(txtNewSecurityAns);
		layoutBtn.addComponent(btnAccept);
		layoutBtn.addComponent(btnCancel);

		panelEdit.setContent(formLayoutEdit);
		formLayoutPrin.addComponent(panelEdit);
		setContent(formLayoutPrin);
	}
	
	
	
	private void init(Navigator navigator, ControlGeneral control, User user){

		this.navigator=navigator;
		this.control=control;
		this.user=user;

		FormLayout formLayoutPrin= new FormLayout();
		formLayoutPrin.setSizeFull();
		formLayoutPrin.beforeClientResponse(false);
		formLayoutPrin.setVisible(true);

		panelEdit = new  Panel();
		panelEdit.setWidth("480px");
		panelEdit.setHeight("500px");

		FormLayout formLayoutEdit = new FormLayout();
		formLayoutEdit.setVisible(true);

		HorizontalLayout layoutSearch= new HorizontalLayout();
		layoutSearch.setVisible(true);

		HorizontalLayout layoutUser = new HorizontalLayout();

		HorizontalLayout layoutRol = new HorizontalLayout();

		HorizontalLayout layautPassword= new HorizontalLayout();


		HorizontalLayout layoutSecurity = new HorizontalLayout();
		HorizontalLayout layoutBtn = new HorizontalLayout();
		layoutBtn.setVisible(true);

		lbLabelPrincipal = new Label("Editar Usuario");
		lbLabelPrincipal.setWidth("150px");
		lbLabelPrincipal.setHeight("50px");
		lbLabelPrincipal.setVisible(true);

		this.imgUser = new Image("Usuario");
		ThemeResource resource2 = new ThemeResource("../Imagen/user.png");
		imgUser = new Image(null, resource2);
		this.imgUser.setVisible(true);

		lblUser = new Label("Usuario");
		lblUser.setWidth("150px");
		lblUser.setHeight("50px");
		lblUser.setEnabled(false);

		txtUser = new TextField();
		txtUser.setWidth("150px");
		txtUser.setHeight("50px");
		txtUser.setVisible(true);
		txtUser.setValue(user.getNickname()+"");

		this.imgRol = new Image("Rol");
		ThemeResource resource3 = new ThemeResource("../Imagen/rol2.jpg");
		imgRol = new Image(null, resource3);
		this.imgRol.setVisible(true);
		this.imgRol.setWidth("50px");
		this.imgRol.setHeight("50px");

		lblRol = new Label("Rol");
		lblRol.setWidth("150px");
		lblRol.setHeight("50px");
		lblRol.setVisible(true);

		txtRol = new TextField();
		txtRol.setWidth("150px");
		txtRol.setHeight("50px");
		txtRol.setVisible(true);
		txtRol.setValue(user.getRol().getName());


		this.imgPasword = new Image("Constraseņa");
		ThemeResource resource = new ThemeResource("../Imagen/constrase_a_converted.png");
		imgPasword =new Image (null, resource);
		this.imgPasword.setVisible(true);

		lblNewPassword = new Label("Contraseņa");
		lblNewPassword.setWidth("150px");
		lblNewPassword.setHeight("50px");
		lblNewPassword.setVisible(true);

		txtNewPassword = new PasswordField();
		txtNewPassword.setWidth("150px");
		txtNewPassword.setHeight("50px");
		txtNewPassword.setVisible(true);
		txtNewPassword.setValue(user.getPassword());


		this.imgSecurity = new Image("Constraseņa");
		ThemeResource resource1 = new ThemeResource("../Imagen/profesor.jpg");
		imgSecurity =new Image (null, resource1);
		this.imgSecurity.setVisible(true);

		lblNewSecurityAns = new Label("Respuesta  Seguridad");
		lblNewSecurityAns.setWidth("150px");
		lblNewSecurityAns.setHeight("50px");
		lblNewSecurityAns.setVisible(true);

		txtNewSecurityAns = new TextField();
		txtNewSecurityAns.setWidth("150px");
		txtNewSecurityAns.setHeight("50px");
		txtNewSecurityAns.setVisible(true);
		txtNewSecurityAns.setValue(user.getAnswer());

		btnAccept = new Button("Aceptar");
		btnAccept.setWidth("100px");
		btnAccept.setHeight("50px");
		btnAccept.setVisible(true);
		btnAccept.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				try {
					//control.getUser().upDate(Integer.valueOf(txtUser.getValue()), txtNewPassword.getValue(), txtNewSecurityAns.getValue());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnCancel = new Button("Cancelar");
		btnCancel.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);

			}
		});
		btnCancel.setWidth("100px");
		btnCancel.setHeight("50px");


		formLayoutEdit.addComponent(lbLabelPrincipal);
		formLayoutEdit.addComponent(layoutUser);
		formLayoutEdit.addComponent(layoutRol);
		formLayoutEdit.addComponent(layautPassword);
		formLayoutEdit.addComponent(layoutSecurity);
		formLayoutEdit.addComponent(layoutBtn);


		layautPassword.addComponent(imgPasword);
		layautPassword.addComponent(lblNewPassword);
		layautPassword.addComponent(txtNewPassword);

		layoutUser.addComponent(imgUser);
		layoutUser.addComponent(lblUser);
		layoutUser.addComponent(txtUser);

		layoutRol.addComponent(imgRol);
		layoutRol.addComponent(lblRol);
		layoutRol.addComponent(txtRol);

		layoutSecurity.addComponent(imgSecurity);
		layoutSecurity.addComponent(lblNewSecurityAns);
		layoutSecurity.addComponent(txtNewSecurityAns);
		layoutBtn.addComponent(btnAccept);
		layoutBtn.addComponent(btnCancel);

		panelEdit.setContent(formLayoutEdit);
		formLayoutPrin.addComponent(panelEdit);
		setContent(formLayoutPrin);
	}




}
