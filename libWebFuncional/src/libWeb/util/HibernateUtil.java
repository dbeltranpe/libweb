package libWeb.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Clase que permite la conexión con la base de datos
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
public class HibernateUtil 
{

	/**
	 * Sesión para la conexión con la base de datos 
	 */
	private static SessionFactory sessionFactory;

	/**
	 * Realiza la configuración para la conexión con la base de datos 
	 */
	static 
	{
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	/**
	 * Retorna la sesión creada y configurada 
	 * @return la sesión 
	 */
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}