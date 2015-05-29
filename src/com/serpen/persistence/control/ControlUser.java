package com.serpen.persistence.control;
/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * @author Eliana Ayala
 * 		   Daniela Blanco
 * 		   Diana Gonzalez
 * 	       Edgar Meneces
 *Clase  que se  tiene los controles de Usuario
 */
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.HealthEntity;
import com.serpen.logic.entity.PensionFund;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
/**
 * Atributos de la clase Control  Usuario
 */
public class ControlUser {

/**
 * Atributos de la clase control
 */
	Session session;
	/**
	 * Constructor de la clase Control Conection
	 * @param session
	 * @param transaction
	 */
	public ControlUser(Session session) {
		// TODO Auto-generated constructor stub
		this.session=session;
	}
    
	/**
	 * Metodo que se encarga de insertar un Usuario en la base de datos
	 * @param nickname
	 * @param password
	 * @param answer
	 * @param role
	 * @param name
	 * @param lastName
	 * @param address
	 * @param numberPhone
	 * @param business
	 * @param salary
	 * @param affiliate
	 * @param pensionFund
	 * @throws ErrorConnection
	 */
	public void insert(int nickname,String password,String answer,
			Role role,String name,String lastName,
			String address,String numberPhone,String business,
			double salary,char affiliate,PensionFund pensionFund,HealthEntity healthEntity)throws ErrorConnection{

		//transaction = session.beginTransaction();	
		User user = new User();
		user.setNickname(nickname);
		user.setPassword(password);
		user.setAnswer(answer);
		user.setRol(role);
		user.setName(name);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setNumberPhone(numberPhone);
		user.setBusiness(business);
		user.setSalary(salary);
		user.setAffiliate(affiliate);
		user.setPensionFund(pensionFund);
		user.setState(user.STATE_TYPE_ACTIVE);
		user.setHealthEntity(healthEntity);
		session.save(user);	
		session.beginTransaction().commit();
	}
/**
 * metodo que se encarga de consultar un Usuario  por el id
 * @param id
 * @return
 * @throws ErrorConnection
 */
	public User consultId(int id)throws ErrorConnection{

		User user =  (User) session.load(User.class, id);
		return user;
	}

	/**
	 * Metodo que se encarga de consultar un usuario por el nombre
	 * @param name
	 * @return
	 * @throws ErrorConnection
	 */
	public User consultName(String name)throws ErrorConnection{
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("name", name));

		return (User) criteria.list().get(0);
	}
    /**
     * Metodo que se encarga de actualizar un usuario
     */
	public void update(int nickname,String password,String answer,
			String name,String lastName,
			String address,String numberPhone)throws ErrorConnection{
		//transaction = session.beginTransaction();
		User user = consultId(nickname);	
		user.setPassword(password);
		user.setAnswer(answer);
		user.setName(name);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setNumberPhone(numberPhone);
		session.update(user);
		session.beginTransaction().commit();
	}
	/**
	 * Metodo que se encarga de remover un Usuario
	 * @param nickname
	 * @throws ErrorConnection
	 */
	public void removeUser(int nickname)throws ErrorConnection{

		User user =consultId(nickname);
		session.delete(user);
		session.beginTransaction().commit();
	}
	/**
	 * Metodo que se encarga de listar los usuarios
	 * @param name
	 * @return lista de usuario
	 */
	public List<User> listUser(String name){

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("name", "%"+name+"%"));	
		return criteria.list();	
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ControlUser controlUser= new ControlUser(session);
				Role role = (Role) session.load(Role.class, 1);
				PensionFund pensionFund = (PensionFund) session.load(PensionFund.class,"12");
		        HealthEntity healthEntity = (HealthEntity)session.load(HealthEntity.class, "3eerr");
	
		try {
			System.out.println(controlUser.consultId(1));
			//controlUser.insert(1, "123ed", "Profe123ed", role,"Eliana", "Perez", "direccion", "312456476", "Algarra", 100.00, User.AFFILIATE_TYPE_CONTRIBUTOR, pensionFund,healthEntity);
			//controlUser.removeUser(1);
			System.out.println(controlUser.consultName("Eliana"));
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//controlUser.update(1,"Actualizacion", "Juan Jose", "Jesi", "Ramirez", "Calle", "312234354");
		
	}

}

