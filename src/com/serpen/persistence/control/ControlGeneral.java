package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.persistence.conf.HibernateUtil;

public class ControlGeneral {
	
	private ControlRole controlRole;
	private ControlUser controlUser;
	private ControlHealthEntity controlHealthEntity;
	private ControlPensionFund controlPensionFund;
	private ControlHistoryRole controlHistoryRole;
	private ControlHistoryUser controlHistoryUser;
	
	
	
public ControlGeneral(Session sesion) {
		
		this.controlRole = new ControlRole(sesion);
		this.controlUser = new ControlUser(sesion);
		this.controlHealthEntity = new ControlHealthEntity(sesion);
		this.controlPensionFund = new ControlPensionFund(sesion);
//        this.controlHistoryRole = new ControlHistoryRole(sesion, transaction);
//        this.controlHistoryUser = new ControlHistoryUser(sesion, transaction);
	}
	
//	public ControlGeneral(){
//		Session sesion = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = sesion.beginTransaction();
//		
//
//		this.controlRole = new ControlRole(sesion,transaction);
//		this.controlUser = new ControlUser(sesion, transaction);
//		this.controlHistoryRole = new ControlHistoryRole(sesion, transaction);
//		this.controlHistoryUser = new ControlHistoryUser(sesion, transaction);
//	}



	public ControlRole getRole() {
		return controlRole;
	}



	public void setRole(ControlRole controlRole) {
		this.controlRole = controlRole;
	}



	public ControlUser getUser() {
		return controlUser;
	}



	public void setUser(ControlUser controlUser) {
		this.controlUser = controlUser;
	}



	public ControlHistoryRole getHistoryRole() {
		return controlHistoryRole;
	}



	public void setHistoryRole(ControlHistoryRole controlHistoryRole) {
		this.controlHistoryRole = controlHistoryRole;
	}



	public ControlHistoryUser getHistoryUser() {
		return controlHistoryUser;
	}



	public void setHistoryUser(ControlHistoryUser controlHistoryUser) {
		this.controlHistoryUser = controlHistoryUser;
	}

	public ControlHealthEntity getlHealth() {
		return controlHealthEntity;
	}

	public void setHealth(ControlHealthEntity controlHealthEntity) {
		this.controlHealthEntity = controlHealthEntity;
	}

	public ControlPensionFund getPensionFund() {
		return controlPensionFund;
	}

	public void setPensionFund(ControlPensionFund controlPensionFund) {
		this.controlPensionFund = controlPensionFund;
	}
	
	
	
}