package com.serpen.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.serpen.logic.entity.PensionFund;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class PanelBoardReport extends Panel implements View{
	
	private Label lblReport;
	private Label lblUser;
	private Label lblUserName;
	private Label lblSalary;
	private Label lblDiscountCredit;
	private Label lblDiscountHealth;
	private TextField  txtSalary;
	private TextField  txtDiscountCredit;
	private TextField  txtDiscountHealth;
	private Button  btnReturn;
	private Navigator navigator;
	public static String NAMEBOARD="BoardReport";

	
	public PanelBoardReport(Navigator navigator) {
		
		
		this.navigator=navigator;
		// TODO Auto-generated constructor stub
		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setSizeFull();
		layoutPanel.setVisible(true);
		
		HorizontalLayout horizontalLayout1 = new HorizontalLayout();
		HorizontalLayout horizontalLayout2 = new HorizontalLayout();
		HorizontalLayout horizontalLayout3 = new HorizontalLayout();
		HorizontalLayout horizontalLayout4 = new HorizontalLayout();
		HorizontalLayout horizontalLayout5 = new HorizontalLayout();
		HorizontalLayout horizontalLayout6 = new HorizontalLayout();

		
		lblReport = new Label("Informe Pensi�n");
		lblReport.setVisible(true);
		lblReport.setWidth("100px");
		lblReport.setHeight("50px");
		
		lblUser = new Label("Usuario");
		lblUser.setVisible(true);
		lblUser.setWidth("100px");
		lblUser.setHeight("50px");
		
		
		lblUserName = new Label("Nombre del usuario");
		lblUserName.setVisible(true);
		lblUserName.setWidth("100px");
		lblUserName.setHeight("50px");
		
		
		lblSalary = new Label("Salario Actual");
		lblSalary.setVisible(true);
		lblSalary.setWidth("100px");
		lblSalary.setHeight("50px");
		
		lblDiscountCredit = new Label("Descuento por Creditos");
		lblDiscountCredit.setVisible(true);
		lblDiscountCredit.setWidth("100px");
		lblDiscountCredit.setHeight("50px");
		
		lblDiscountHealth = new Label("Descuento por Salud");
		lblDiscountHealth.setVisible(true);
		lblDiscountHealth.setWidth("100px");
		lblDiscountHealth.setHeight("50px");
		
		txtSalary = new TextField();
		txtSalary.setWidth("150px");
		txtSalary.setHeight("50px");
		txtSalary.setRequired(true);
		
		txtDiscountCredit = new TextField();
		txtDiscountCredit.setWidth("150px");
		txtDiscountCredit.setHeight("50px");
		txtDiscountCredit.setRequired(true);
		
		txtDiscountHealth = new TextField();
		txtDiscountHealth.setWidth("150px");
		txtDiscountHealth.setHeight("50px");
		txtDiscountHealth.setRequired(true);
		
		btnReturn= new  Button("Regresar");
		btnReturn.setWidth("150px");
		btnReturn.setHeight("50px");
		btnReturn.setVisible(true);	
		btnReturn.addClickListener(new Button.ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub		
				navigator.navigateTo(Simulator.NAMESIMULATOR);
			}

		});
		
		horizontalLayout1.addComponent(lblReport);
		
		horizontalLayout2.addComponent(lblUser);
		horizontalLayout2.addComponent(lblUserName);
		
		horizontalLayout3.addComponent(lblSalary);
		horizontalLayout3.addComponent(txtSalary);
		
		horizontalLayout4.addComponent(lblDiscountCredit);
		horizontalLayout4.addComponent(txtDiscountCredit);
		
		horizontalLayout5.addComponent(lblDiscountHealth);
		horizontalLayout5.addComponent(txtDiscountHealth);
		horizontalLayout6.addComponent(btnReturn);
		
		layoutPanel.addComponent(horizontalLayout1);
		layoutPanel.addComponent(horizontalLayout2);
		layoutPanel.addComponent(horizontalLayout3);
		layoutPanel.addComponent(horizontalLayout4);
		layoutPanel.addComponent(horizontalLayout5);
		layoutPanel.addComponent(horizontalLayout6);
		PensionFund pensionFund = new PensionFund();
		reporte();
		setContent(layoutPanel);		
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	public void reporte(){
		Document document = new Document();
		File f = new File("D:/sample1.pdf");
		try {
			PdfWriter.getInstance(document, new FileOutputStream(f));
			document.open();

			System.out.println("opening the document..");
			 document.add(new Paragraph("Hello Pdf"));
		     document.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
