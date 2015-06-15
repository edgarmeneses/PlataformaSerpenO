package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Agreement;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.PensionFund;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlPensionFund {

	Session session;

	public ControlPensionFund(Session session){
		this.session=session;
	}

	public void insert(String nit,String name, double porcent)throws ErrorConnection{

		try{

			PensionFund pFund= new PensionFund();
			pFund.setNit(nit);
			pFund.setName(name);
			pFund.setPorcent(porcent);

			session.save(pFund);
			session.beginTransaction().commit();

		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar el fondo " + "Causa: "+e.getCause());
		}

	}

	public List<PensionFund> list() throws ErrorConnection{

		try{
			List<PensionFund> listFund=session.createQuery(					
					"from fondo " +
							"in class com.serpen.logic.entity.PensionFund "
							+ "order by nit").list();
			for (int i=0; i<listFund.size();i++){
				PensionFund pFund = listFund.get(i);

			}

			if (!listFund.isEmpty()){

				return listFund;

			}else{
				throw new ErrorConnection("No se cuenta con ningun dato de la entidad fondo");

			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo realizar la conexion "
					+ " Causa: " + e.getCause());

		}

	}
	
	public PensionFund consult(String nit)throws ErrorConnection{
		
		PensionFund pensionFund = (PensionFund) session.load(PensionFund.class,nit);
		
		if(pensionFund != null){
			return pensionFund;
		}
		else{
			throw new ErrorConnection("no se encnto ningun rol");
		}

	}
	
	public void remove(String nit) throws ErrorConnection{
		
//***************+Flata+*******************************
		
		try{
			PensionFund pFund = consult(nit);
			System.out.println(pFund);
			
			session.delete(pFund);
			
		}catch(Exception e){
			throw new ErrorConnection("no se pudo eliminar el fondo "
					+ "Causa: "+ e.getCause());

		}

	}
	public void update (String nit , String name, double porcent) throws ErrorConnection{
		
		try{
			PensionFund pFund = consult(nit);

			pFund.setName(name); 
			pFund.setPorcent(porcent);

			session.update(pFund);

			session.beginTransaction().commit();
			
		}catch(Exception e){
			throw new ErrorConnection("no se pudo editar el suario "
					+ "Causa: "+ e.getCause());
		}
	}

}
