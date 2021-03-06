package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PanelFoundConf  extends Panel implements View{

	private Image reportPensions;
	private Label lblReportPensions;
	private Image imgSimulator;
	private Label lblsimulator;
	private Navigator navigator;
    private User user;
	public PanelFoundConf(Navigator navigator,User user) {
		// TODO Auto-generated constructor stub

		this.navigator=navigator;
		this.user=user;
		FormLayout layoutPanelPension = new FormLayout();
		//layoutPanelPension.setSizeFull();
		layoutPanelPension.setVisible(true);

		this.reportPensions = new Image("Reporte");
		ThemeResource resource1 = new ThemeResource("../Imagen/reporte.png");
		reportPensions = new Image(null, resource1);
		this.reportPensions.setWidth("100px");
		this.reportPensions.setHeight("100px");
		this.reportPensions.setVisible(true);
        this.reportPensions .addClickListener(new ClickListener() {
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				BoardReport boardReport = new BoardReport(navigator,user);
				UI.getCurrent().addWindow(boardReport);
				
			}
		});

		this.lblReportPensions = new Label("Informe Pension");
		this.setVisible(true);
	
		this.imgSimulator = new Image("simulador");
		ThemeResource resource2 = new ThemeResource("../Imagen/simulador.jpg");
		imgSimulator = new Image(null, resource2);
		this.imgSimulator.setWidth("100px");
		this.imgSimulator.setHeight("100px");
		this.imgSimulator.setVisible(true);

		this.imgSimulator.addClickListener(new ClickListener() {
			

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				WindowsSimulator windowsSimulator = new WindowsSimulator(navigator);
				UI.getCurrent().addWindow(windowsSimulator);

			}
		});
		this.lblsimulator = new Label("Simulador");
		this.setVisible(true);

		VerticalLayout verticalReportPensions = new VerticalLayout();

		VerticalLayout verticalSimulator = new VerticalLayout();

		layoutPanelPension.addComponent(verticalReportPensions);
	    layoutPanelPension.addComponent(verticalSimulator);
	    
		verticalReportPensions.addComponent(reportPensions);
		verticalReportPensions.addComponent(lblReportPensions);

		verticalSimulator.addComponent(imgSimulator);
		verticalSimulator.addComponent(lblsimulator);
		
		setContent(layoutPanelPension);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}


}
