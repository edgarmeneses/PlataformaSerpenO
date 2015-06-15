package com.serpen.interfaces;

import com.serpen.logic.entity.Account;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;

public class PanelButtonTransaction extends Panel{
	
	private Button btnTransaccion;
	private Navigator navigator;
	private PanelTableBank panelTableBank;
	private Account account;
	
	public PanelButtonTransaction(Navigator navigator , PanelTableBank tableBank , Account account){
		
		this.navigator = navigator;
		this.panelTableBank = tableBank;
		this.account = account;
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		
	 	btnTransaccion = new Button("Transaccion");
		btnTransaccion.setWidth("150px");
		btnTransaccion.setHeight("50px");
		btnTransaccion.setVisible(true);
		
		btnTransaccion.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					WindowBank windowBank = new WindowBank(navigator);
					UI.getCurrent().addWindow(windowBank);
					
					System.out.println(panelTableBank);
					
					getNumberAccount(account);
				}
			});
		horizontalLayout.addComponent(btnTransaccion);
		
		setContent(horizontalLayout);
		setSizeFull();
		
	}
	

	 public String getNumberAccount(Account account){	
	    	return String.valueOf(account.getNumber());
			
		}
}
