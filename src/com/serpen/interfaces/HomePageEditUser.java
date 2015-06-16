package com.serpen.interfaces;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Agreement;
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
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;


public class HomePageEditUser extends Panel implements TabSheet.SelectedTabChangeListener, View{

	private TabSheet tabsheet = new TabSheet();
	private User user;
	private PanelCreateUser createUser;
	private PanelPersonalInformation persdonalInformation;
	private PanelPensionFoundInformation foundInformation;
	private Panel panelSearch;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	public Navigator navigator;
	public ControlGeneral control;
	public static String NAMEHOMEEDITUSEER="TablaEditarUsuario";
	private PanelGeneralAdministrator panelGeneral;


	public HomePageEditUser(User user, Navigator navigator, ControlGeneral control) {
		
		this.user=user;
		
		createUser= new PanelCreateUser(navigator, control,NAMEHOMEEDITUSEER);
		persdonalInformation= new PanelPersonalInformation(navigator, control,NAMEHOMEEDITUSEER);
		foundInformation = new PanelPensionFoundInformation(navigator,control,NAMEHOMEEDITUSEER);
		
		validateField();
		
		panelGeneral = new PanelGeneralAdministrator(navigator, user,control);
		panelGeneral.getImgEdit().setEnabled(false);
		panelGeneral.setHeight("680px");
		
		panelSearch = new Panel();
		panelSearch.setSizeFull();
		panelSearch.setWidth("700px");
		panelSearch.setHeight("60px");
		
		lblSearch=new Label("Usuario");
		lblSearch.setWidth("550px");
		txtSearch =new TextField();
		btnSearch=new Button("Buscar");
		btnSearch.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					int nickname = Integer.valueOf(txtSearch.getValue().toString());
					User userChange= control.getUser().consultId(nickname);
					System.out.println("llll"+userChange);
					createUser.addUser(userChange);
					persdonalInformation.addUser(userChange);
					foundInformation.addUser(userChange );
					
				} catch (ErrorConnection e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		HorizontalLayout layoutSearch = new HorizontalLayout();
		layoutSearch.addComponent(lblSearch);
		layoutSearch.addComponent(txtSearch);
		layoutSearch.addComponent(btnSearch);
		
		panelSearch.setContent(layoutSearch);

		tabsheet.addTab(createUser, "Informacion de la Cuenta", null);
		tabsheet.getTab(createUser).setVisible(true);

		tabsheet.addTab(persdonalInformation, "Informacion Pesonal", null);
		tabsheet.getTab(persdonalInformation).setVisible(true);
		
		tabsheet.addTab(foundInformation, "Informacion Fondo de Pensiones");
		tabsheet.getTab(foundInformation).setVisible(true);

		HorizontalLayout layout = new HorizontalLayout();
		
		VerticalLayout verticalLayout = new VerticalLayout();
		
		layout.addComponent(tabsheet);
		layout.addComponent(panelGeneral);
		
		verticalLayout.addComponent(layoutSearch);
		verticalLayout.addComponent(layout);
	
		setContent(verticalLayout);
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {

		final TabSheet source = (TabSheet) event.getSource();

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void validateField(){
		createUser.change();
		persdonalInformation.change();
		foundInformation.change();
	}


}

