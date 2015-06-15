package com.serpen.persistence.control;
/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * @author Eliana Ayala
 * 		   Daniela Blanco
 * 		   Diana Gonzalez
 * 	       Edgar Meneces
 *Clase  que se  tiene los controles de coneccion 
 */
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Conection;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlConection {
	
	/**
	 * Atributos de la clase Control Conection
	 */
	private Session session;
	private Transaction transaction;
	/**
	 * Constructor de la clase Control Conection
	 * @param session
	 * @param transaction
	 */
	public ControlConection(Session session, Transaction transaction) {
		super();
		this.session = session;
		this.transaction = transaction;
	}
	/**
	 * Metodo insertar que se encarga de  pedir atributos de la conexion por 
	 * parametro y carga estos datos a la base de datos
	 * @param id
	 * @param url
	 * @param port
	 * @param name_Bd
	 * @param nit
	 * @throws ErrorConnection
	 */
	public void insert(int id, String url,  int port,String name_Bd,Entity nit) throws ErrorConnection{
		Conection conection =  new Conection();
		conection.setId(id);
		conection.setUrl(url);
		conection.setPort(port);
		conection.setNit(nit);
		conection.setName_Bd(name_Bd);
		session.save(conection);
		transaction.commit();
		session.close();
	}
	/**
	 * Metodo que consulta una coneccion en la base de datos
	 * y la retorna 
	 * @param id
	 * @return Conection
	 * @throws ErrorConnection
	 */
	public Conection consultId(int id)throws ErrorConnection{		
		Conection conection=(Conection) session.load(Conection.class, id);
		System.out.println(conection);
		return  conection;	
	}
	/**
	 * Metodo que  lista las conecciones que existen en la base de datos 
	 * y retorna una lista
	 * @param baseDatos
	 * @throws ErrorConnection
	 */
	public List<Conection> listUser(String baseDatos)throws ErrorConnection{

		Criteria criteria = session.createCriteria(Conection.class);
		criteria.add(Restrictions.like("name_Bd", "%"+baseDatos+"%"));	
		return criteria.list();	
	}
	/**
	 * Metodo que se encarga de eliminar una conexion 
	 * pidiendo por parametro el id 
	 * @param id
	 * @throws ErrorConnection
	 */
	public void remove(int id)throws ErrorConnection{
		Conection conection = (Conection) session.load(Conection.class, id);
		session.delete(conection);
		transaction.commit();
	}
	/**
	 * Metodo que se encarga de actualizar algunos datos de la conexion 
	 * @param id
	 * @param url
	 * @param port
	 * @param name_Bd
	 * @param nit
	 * @throws ErrorConnection
	 */
	public void update(int id,String url,  int port,String name_Bd,Entity nit)throws ErrorConnection{
		Conection conection = (Conection) session.load(Conection.class, id);
		conection.setUrl(url);
		conection.setPort(port);
		conection.setNit(nit);
		conection.setName_Bd(name_Bd);
		session.update(conection);
		transaction.commit();	
	}
	
	public static void main(String[] args) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		ControlConection controlConection = new ControlConection(session,transaction);
		
		try {
			Entity  entity = (Entity) session.load(Entity.class,1);
			//controlConection.insert(3,"com.mysql.jdbc.Driver",3306,"Uptc",entity);
			controlConection.consultId(1);
			//System.out.println(controlConection.listUser("U"));
			//controlConection.remove(4);	
			
			//controlConection.update(3,"cambio.com.mysql.jdbc.Driver",3306,"Juan de Castellanos",entity);
			session.close();
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
