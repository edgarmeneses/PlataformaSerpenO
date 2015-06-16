/**
 * 
 */
package com.serpen.interfaces;

import java.util.LinkedList;
import java.util.List;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.PensionFund;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.data.Property;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
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
import com.vaadin.ui.Button.ClickListener;


/**
 * @author Edgar Meneses
 *
 */
public class PanelPensionFoundInformation extends Panel implements View{

	private Label lblTitulo;
	private TextField txtEmpresa;
	private TextField txtSalary;
	private Image lblImagen;
	private ComboBox fondo;
	private TextField txtAfiliado;
	private Button btnNew;
	private Button btnCancel;
	private Panel panel;
	//private NumberField numberField;
	private Navigator navigator;
	private ControlGeneral control;
	private final String TITTLE1="Crear Usuario - Informacion Fondo de Pensiones";
	private final String TITTLE2="Editar Usuario - Informacion Fondo de Pensiones";

	/**
	 * Constructor que se pide por parametro 
	 * @param navigator
	 * @param control
	 * Instancia los componentes que se van a pintar en la clase Create User
	 */
	public PanelPensionFoundInformation (Navigator navigator, ControlGeneral control,String action) {

		this.navigator = navigator;
		this.control=control;

		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.beforeClientResponse(true);
		layoutPrincipal.setVisible(true);


		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setVisible(true);

		HorizontalLayout layoutHorizontal = new HorizontalLayout();

		VerticalLayout layoutDatos = new VerticalLayout();

		VerticalLayout layoutAfiliacion = new VerticalLayout();
		if(action.equals(HomePageCreateUser.NAMEHOMECREATEUSER)){
			lblTitulo = new Label(TITTLE1);
		}else{
			lblTitulo = new Label(TITTLE2);

		}

		txtEmpresa = new TextField("Empresa");

		txtSalary = new TextField("Salario");

		txtAfiliado= new TextField("Tipo Afiliacion");

		VerticalLayout layoutRol = new VerticalLayout();

		ThemeResource resource = new ThemeResource("../Imagen/infFondo.png");
		lblImagen = new Image(null, resource);
		this.lblImagen.setVisible(true);
		this.lblImagen.setWidth("300px");
		this.lblImagen.setHeight("200px");



		try {
			fondo = new ComboBox("Fondo",listFondo());
			fondo.setInputPrompt("Seleccionar Rol:");
			fondo.setInvalidAllowed(false);
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		HorizontalLayout layoutbutton = new HorizontalLayout();

		btnNew = new Button("Guardar");		
		btnNew.addClickListener(new ClickListener() {		
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub


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

		layoutDatos.addComponent(txtEmpresa);
		layoutDatos.addComponent(txtSalary);
		layoutDatos.addComponent(txtAfiliado);
		layoutDatos.addComponent(fondo);

		layoutRol.addComponent(lblImagen);
		//layoutRol.addComponent(fondo);
		//layoutRol.addComponent(txtAfiliado);

		layoutbutton.addComponent(btnNew);
		layoutbutton.addComponent(btnCancel);




		layoutHorizontal.addComponent(layoutDatos);
		layoutHorizontal.addComponent(layoutRol);

		layoutPanel.addComponent(layoutHorizontal);
		layoutPanel.addComponent(layoutbutton);

		layoutPrincipal.addComponent(titulo);
		layoutPrincipal.addComponent(panel);
		this.panel.setContent(layoutPanel);


		setContent(layoutPrincipal);

	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}


	public void change(){
		lblTitulo.setCaption("Editar Usuario - Informacion Fondo de Pensiones");
		btnNew.setCaption("Cambiar");
		btnNew.setVisible(false);
		txtAfiliado.setEnabled(false);
		txtEmpresa.setEnabled(false);
		txtSalary.setEnabled(false);
		fondo.setEnabled(false);
	}
	
	public void addUser(User user){
		txtAfiliado.setValue(user.getAffiliate()+"");
		txtEmpresa.setValue(user.getBusiness());
		txtSalary.setValue(user.getSalary()+"");
		fondo.setValue(user.getPensionFund().getName());
	}
	
	private List<String> listFondo() throws ErrorConnection{
		List<PensionFund> funds = control.getPensionFund().list();
		
		List<String> list = new LinkedList<String>();
		
		for (PensionFund fund: funds) {
			System.out.println(fund.getName());
			list.add(fund.getName());
		}
		return list;
	}
	


}
