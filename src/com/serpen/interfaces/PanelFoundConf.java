package com.serpen.interfaces;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PanelFoundConf  extends Panel{

	private Image reportPensions;
	private Label lblReportPensions;
	private Image imgSimulator;
	private Label lblsimulator;

	public PanelFoundConf() {
		// TODO Auto-generated constructor stub

		FormLayout layoutPanelPension = new FormLayout();
		//layoutPanelPension.setSizeFull();
		layoutPanelPension.setVisible(true);

		this.reportPensions = new Image("Reporte");
		ThemeResource resource1 = new ThemeResource("../Imagen/reporte.png");
		reportPensions = new Image(null, resource1);
		this.reportPensions.setWidth("100px");
		this.reportPensions.setHeight("100px");
		this.reportPensions.setVisible(true);

		this.lblReportPensions = new Label("Informe Pension");
		this.setVisible(true);

		this.imgSimulator = new Image("simulador");
		ThemeResource resource2 = new ThemeResource("../Imagen/simulador.jpg");
		imgSimulator = new Image(null, resource2);
		this.imgSimulator.setWidth("100px");
		this.imgSimulator.setHeight("100px");
		this.imgSimulator.setVisible(true);

		this.imgSimulator.addClickListener(new ClickListener() {
			WindowsSimulator windowsSimulator = new WindowsSimulator();

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub

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

}
