package com.serpen.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.Credit;
import com.serpen.logic.entity.PensionFund;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlCatalog;
import com.serpen.persistence.control.ControlCredit;
import com.serpen.persistence.control.ControlGeneral;
import com.serpen.persistence.control.ControlUser;
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
	private Label lblId;
	private Label lblUserId;
	private Label lblSalary;
	private Label lblDiscountCredit;
	private Label lblDiscountHealth;
	private TextField  txtSalary;
	private TextField  txtDiscountCredit;
	private TextField  txtDiscountHealth;
	private Button  btnReturn;
	private Navigator navigator;
	public static String NAMEBOARD="BoardReport";
	public  User user;
	Session session;
	List<Credit> listaCredit;
	public PanelBoardReport(Navigator navigator,User user) {

		this.user=user;
		this.navigator=navigator;
		session = HibernateUtil.getSessionFactory().openSession();
		// TODO Auto-generated constructor stub
		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setSizeFull();
		layoutPanel.setVisible(true);

		HorizontalLayout horizontalLayout1 = new HorizontalLayout();
		HorizontalLayout horizontalLayout2 = new HorizontalLayout();
		HorizontalLayout horizontalLayoutId = new HorizontalLayout();
		HorizontalLayout horizontalLayout3 = new HorizontalLayout();
		HorizontalLayout horizontalLayout4 = new HorizontalLayout();
		HorizontalLayout horizontalLayout5 = new HorizontalLayout();
		HorizontalLayout horizontalLayout6 = new HorizontalLayout();


		lblReport = new Label("Informe Pensión");
		lblReport.setVisible(true);
		lblReport.setWidth("100px");
		lblReport.setHeight("50px");

		lblUser = new Label("Usuario");
		lblUser.setVisible(true);
		lblUser.setWidth("100px");
		lblUser.setHeight("50px");

		lblId = new Label("Identificacion: ");
		lblId.setVisible(true);
		lblId.setWidth("100px");
		lblId.setHeight("50px");


		lblUserName = new Label(user.getName()+"  "+ user.getLastName());
		lblUserName.setVisible(true);
		lblUserName.setWidth("100px");
		lblUserName.setHeight("50px");

		lblUserId = new Label( "    "+ String.valueOf(user.getNickname()));
		lblUserId.setVisible(true);
		lblUserId.setWidth("100px");
		lblUserId.setHeight("50px");


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
		txtSalary.setValue(String.valueOf(user.getSalary()));
		txtSalary.setWidth("150px");
		txtSalary.setHeight("50px");
		//txtSalary.setEnabled(false);

        
		txtDiscountCredit = new TextField();
		txtDiscountCredit.setValue(String.valueOf(discountCredits()));
		txtDiscountCredit.setWidth("150px");
		txtDiscountCredit.setHeight("50px");
		//txtDiscountCredit.setEnabled(false);


		txtDiscountHealth = new TextField();
		txtDiscountHealth.setValue(String.valueOf(discountHealth()));
		txtDiscountHealth.setWidth("150px");
		txtDiscountHealth.setHeight("50px");
		//txtDiscountHealth.setEnabled(false);


		btnReturn= new  Button("Guardar");
		btnReturn.setWidth("150px");
		btnReturn.setHeight("50px");
		btnReturn.setVisible(true);	
		btnReturn.addClickListener(new Button.ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub		
				reporte();
			}
		});

		horizontalLayout1.addComponent(lblReport);

		horizontalLayout2.addComponent(lblUser);
		horizontalLayout2.addComponent(lblUserName);

		horizontalLayoutId.addComponent(lblId);
		horizontalLayoutId.addComponent(lblUserId);

		horizontalLayout3.addComponent(lblSalary);
		horizontalLayout3.addComponent(txtSalary);

		horizontalLayout4.addComponent(lblDiscountCredit);
		horizontalLayout4.addComponent(txtDiscountCredit);

		horizontalLayout5.addComponent(lblDiscountHealth);
		horizontalLayout5.addComponent(txtDiscountHealth);
		horizontalLayout6.addComponent(btnReturn);


		layoutPanel.addComponent(horizontalLayout1);
		layoutPanel.addComponent(horizontalLayout2);
		layoutPanel.addComponent(horizontalLayoutId);
		layoutPanel.addComponent(horizontalLayout3);
		layoutPanel.addComponent(horizontalLayout4);
		layoutPanel.addComponent(horizontalLayout5);
		layoutPanel.addComponent(horizontalLayout6);		
		setContent(layoutPanel);	
		
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub	
	}	
	public double  discountCredits(){
		
		ControlCredit  controlCredit = new ControlCredit(session);   
		double credits=0;
		double discountCredits=0;

		try {
		    listaCredit=controlCredit.listUser(user.getNickname());
			for (int i = 0; i < listaCredit.size(); i++) {
				credits= credits+listaCredit.get(i).getAmount();
			}
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//discountCredits = user.getSalary()-credits;
		return credits;
	}

	public double discountHealth(){
		double health = user.getHealthEntity().getCatalog().getDiscount();
		return health;
	}
	public void reporte(){
		Document document = new Document();
		File f = new File("D:/sample2.pdf");
		try {
			PdfWriter.getInstance(document, new FileOutputStream(f));
			document.open();
			System.out.println("Opening the document..");
	        Image image = Image.getInstance("D:/Proyecto_VadW/PlataformaSerpenO/WebContent/VAADIN/themes/Imagen/logo.jpg");
			 
	        document.add(image);
			document.add(new Paragraph("INFORMACION DEL SALARIO PENSIONADO"));
			document.add(new Paragraph("Usuario: " + user.getName()+ user.getLastName()));
			document.add(new Paragraph("Empresa en la que trabaja"+user.getBusiness()));
			document.add(new Paragraph("Salario Actual"+ user.getSalary()));
			document.add(new Paragraph("Cantidad de creditos"+listaCredit.size()));
			document.add(new Paragraph("Descuento Creditos"+discountCredits()));
			document.add(new Paragraph("Descuento Salud"+discountHealth()));
			
			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
