package com.serpen.persistence.control;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.interfaces.EntityPensions;
import com.serpen.logic.entity.FinancialEntity;
import com.serpen.persistence.conf.HibernateUtil;
import com.sun.org.apache.regexp.internal.recompile;

import java.util.List;

/**
 * Clase contro que me permite insertar, consultar y listar los datos
 * de la entidad financiera 
 * @author Diana Gonzalez, Edgar Menese, Eliana Ayala, Daniela Blnaco
 *
 */
public class ControlFinacialEntity {

	/**
	 * Session de la base de datos 
	 */
	Session session;

	/**
	 * Constructor de la clase 
	 * @param session
	 */

	public ControlFinacialEntity(Session session) {

		this.session = session;

	}

	/**
	 * Metodo insert para ingresar datos a la base de datos 
	 * @param nit
	 * @param name
	 * @param address
	 * @param numberPhone
	 * @throws ErrorConnection
	 */

	public void insert (String nit, String name, String address, String  numberPhone)throws ErrorConnection{

		try{
			FinancialEntity financialEntity = new FinancialEntity();
			financialEntity.setNit(nit);
			financialEntity.setName(name);
			financialEntity.setAddress(address);
			financialEntity.setNumberPhone(numberPhone);

			session.save(financialEntity);
			session.beginTransaction().commit();

		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar la entidad_financiera " + "Causa: "+e.getCause());
		}


	}
	/**
	 * Metodoq ue permite listar los datos que se encuentran en la base de datos 
	 * @return
	 * @throws ErrorConnection
	 */
	public List<FinancialEntity> list() throws ErrorConnection{

		try{

			List<FinancialEntity> listfinancial = session.createQuery(
					"from entidad_financiera "+
					"in class com.serpen.logic.entity.FinancialEntity").list();
			for (int i = 0; i < listfinancial.size(); i++) {
				FinancialEntity pFinancial = listfinancial.get(i);

			}
			if (!listfinancial.isEmpty()){

				return listfinancial;
			}else{

				throw new ErrorConnection("No se cuenta con ningun dato de la entidad");
			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo realizar la conexion "
					+ " Causa: " + e.getCause());

		}


	}
	/**
	 * Metodo que me permite buscar un dato en la base de datos 
	 * segun su nit 
	 * @param nit
	 * @return
	 * @throws ErrorConnection
	 */
	public FinancialEntity consult(String nit) throws ErrorConnection{

		FinancialEntity fEntity=(FinancialEntity) session.load(FinancialEntity.class, nit);

		if(fEntity != null){
			return fEntity;
		}
		else{
			throw new ErrorConnection("no se enconto ninguna entidad financiera");

		}

	}
}
