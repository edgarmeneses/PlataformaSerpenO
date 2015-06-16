package com.serpen.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.serpen.logic.entity.User;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;

public class PanelCertificate extends Panel  implements View{

	private Label lblTitle;
	private Label Description; 
	private Label Description2; 
	private Label Description3; 
	private Label Description4;
	private Label Description5; 
	private Button btnSave;
	private Panel pnlPrincipal;
	private User user;


	public PanelCertificate(User user){

		this.user=user;
		FormLayout formGeneral = new  FormLayout();
		formGeneral.setVisible(true);

		FormLayout formPanel = new FormLayout();
		formPanel.setVisible(true);

		HorizontalLayout layoutTitle = new HorizontalLayout();
		layoutTitle.setVisible(true);

		HorizontalLayout layoutDescription = new HorizontalLayout();
		layoutDescription.setVisible(true);

		HorizontalLayout layoutDescription2 = new HorizontalLayout();
		layoutDescription2.setVisible(true);

		HorizontalLayout layoutDescription3 = new HorizontalLayout();
		layoutDescription3.setVisible(true);

		HorizontalLayout layoutDescription4 = new HorizontalLayout();
		layoutDescription4.setVisible(true);

		HorizontalLayout layoutDescription5 = new HorizontalLayout();
		layoutDescription5.setVisible(true);

		HorizontalLayout layoutButton = new HorizontalLayout();
		layoutButton.setVisible(true);

		pnlPrincipal = new Panel();
		pnlPrincipal.setWidth("500px");
		pnlPrincipal.setHeight("400px");
		this.pnlPrincipal.setVisible(true);

		lblTitle = new Label("CERTIFICADO DE AFILIACIÓN");
		this.lblTitle.setVisible(true);

		Description = new Label( " Plataforma SERPEN  se permite informar que el afiliado(a)");
		this.Description.setVisible(true);

		Description2 = new Label(user.getName()+"   "+user.getLastName()+" identificada con ");
		this.Description2.setVisible(true);

		Description3 = new Label("CC- "+"  "+user.getNickname()+", esta vinculada al sistema General de ");
		this.Description3.setVisible(true);

		Description4 = new Label("seguridad social en salud régimen contributivo por intermedio ");
		this.Description4.setVisible(true);

		Description5 = new Label(user.getHealthEntity().getName()+"; y su estado es ACTIVO.");
		this.Description5.setVisible(true);

		btnSave = new Button("Guardar");
		this.btnSave.setVisible(true);
		btnSave.addClickListener(new Button.ClickListener(){
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub		
				reporte();
			}
		});

		formGeneral.addComponent(pnlPrincipal);

		layoutTitle.addComponent(lblTitle);
		layoutDescription.addComponent(Description);
		layoutDescription2.addComponent(Description2);
		layoutDescription3.addComponent(Description3);
		layoutDescription4.addComponent(Description4);
		layoutDescription5.addComponent(Description5);
		layoutButton.addComponent(btnSave);

		formPanel.addComponent(layoutTitle);
		formPanel.addComponent(layoutDescription);
		formPanel.addComponent(layoutDescription2);
		formPanel.addComponent(layoutDescription3);
		formPanel.addComponent(layoutDescription4);
		formPanel.addComponent(layoutDescription5);
		formPanel.addComponent(layoutButton);

		this.pnlPrincipal.setContent(formPanel);
		this.setContent(formGeneral);
		this.setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub	
	}

	public void reporte(){
		Document document = new Document();
		Calendar cal1 = Calendar.getInstance();
		File file = new File("D:/Cer"+user.getName()+"_"+cal1.get(Calendar.MILLISECOND)+".pdf");
		try {
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			System.out.println("Opening the document..");
			Image image = Image.getInstance("Imagen/logo.jpg");
			image.setAlignment(image.ALIGN_CENTER );
			Image imageFirm = Image.getInstance("Imagen/firma.png");
			imageFirm.setAlignment(imageFirm.ALIGN_CENTER);
			
			Paragraph   paragraphDate = new Paragraph(String.valueOf(""+cal1.get(Calendar.DATE)+"-"+cal1.get(Calendar.MONTH)+"-"+cal1.get(Calendar.YEAR)),FontFactory.getFont("arial",18,Font.ITALIC));
            paragraphDate.setAlignment(paragraphDate.ALIGN_RIGHT);
 

            document.add(image);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(paragraphDate);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
        	document.add(new Paragraph(" "));
			document.add(new Paragraph("CERTIFICADO DE AFILIACION",FontFactory.getFont("arial",22,Font.ITALIC,BaseColor.BLUE)));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Plataforma SERPEN  se permite informar que el afiliado(a) "+ " "+user.getName()+" " , FontFactory.getFont("arial",16,Font.ITALIC)));
			document.add(new Paragraph(user.getLastName()+"  CC- "+"  "+user.getNickname()+",esta vinculado al sistema General de seguridad social" , FontFactory.getFont("arial",16,Font.ITALIC)));
			document.add(new Paragraph(" en salud régimen contributivo por intermedio de "+user.getHealthEntity().getName()+"; y su estado es ACTIVO.", FontFactory.getFont("arial",16,Font.ITALIC)));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(imageFirm);
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
