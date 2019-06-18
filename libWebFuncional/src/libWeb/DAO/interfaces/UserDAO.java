package libWeb.DAO.interfaces;

import java.util.List;

import libWeb.entities.User;

/**
 * Interface que representa el Data Access Object (DAO) de los usuarios
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
public interface UserDAO 
{
	/**
	 * Guarda un usuario en la base de datos<br>
	 * <b> post:</b> Se guardó el usuario en la base de datos<br>
	 * @param usuario User a guardar
	 */
	public void save(User usuario);

	/**
	 * Obtiene un usuario en referencia al id por parámetro
	 * @param int id del usuario a buscar
	 * @return User usuario encontrado con las características del buscado
	 */
	public User getUsuario(int id);

	/**
	 * Elimina un usuario de la base de datos en referencia al pasado 
	 *  por parametro<br>
	 * <b> post:</b> Se eliminó el usuario de la base de datos<br>
	 * @param User usuario referencia a eliminar
	 */
	public void remove(User usuario);

	/**
	 * Modifica un usuario de la base de datos en referencia al pasado 
	 *  por parametro<br>
	 * <b> post:</b> Se modificó el usuario de la base de datos<br>
	 * @param User usuario referencia a actualizar
	 */
	public void update(User usuario);

	/**
	 * Obtiene un usuario con respecto a su username y contraseña
	 * @param userName Cadena de texto con el username del usuario
	 * @param password Cadena de texto con la contraseña del usuario 
	 * @return User suario encontrado con las características del buscado
	 */
	public User getUsuarioLogin(String userName, String password);

	/**
	 * Obtiene un usuario con respecto a su correo
	 * @param correo Cadena de texto con el correo del usuario
	 * @return User usuario encontrado con las características del buscado
	 */
	public User getUsuarioCorreo(String correo);

	/**
	 * Obtiene un usuario con respecto a su username
	 * @param userName Cadena de texto con el username del usuario
	 * @return User suario encontrado con las características del buscado
	 */
	public User getUsuarioPorNombre(String userName);

	/**
	 * Lista los usuarios de la base de datos<br>
	 * @return  List<User> con la lista de los usuarios
	 */
	public List<User> list();

	/**
	 * Retorna la última actividad del usuario
	 * @return entero con el id del usuario
	 */
	public int darUltimaConsulta();

	/**
	 * Obtiene un usuario en referencia al id por parámetro
	 * @param int id del usuario a buscar
	 * @return User usuario encontrado con las características del buscado
	 */
	public User getUsuarioPorId(int id);
}
