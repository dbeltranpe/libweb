package libWeb.DAO.interfaces;
import java.util.List;
import libWeb.entities.Parameter;

/**
 * Interface que representa el Data Access Object (DAO) del parámetro
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
public interface ParameterDAO 
{
	/**
	 * Guarda un parámetro en la base de datos<br>
	 * <b> post:</b> Se guardó el parámetro en la base de datos<br>
	 * @param parameter Parameter a guardar
	 */
	public void save(Parameter parameter);

	/**
	 * Obtiene un parámetro en referencia al pasado por parámetro
	 * @param parameter Parameter referencia a buscar
	 * @return Parameter encontrado con las características del buscado
	 */
	public Parameter getParameter(Parameter parameter);

	/**
	 * Elimina un parámetro de la base de datos en referencia al pasado 
	 *  por parametro<br>
	 * <b> post:</b> Se eliminó el Parameter de la base de datos<br>
	 * @param parameter Parameter referencia a eliminar
	 */
	public void remove(Parameter parameter);

	/**
	 * Modifica un parámetro de la base de datos en referencia al pasado 
	 *  por parametro<br>
	 * <b> post:</b> Se modificó el Parameter de la base de datos<br>
	 * @param parameter Parameter referencia a actualizar
	 */
	public void update(Parameter parameter);

	/**
	 * Lista los parámetros de la base de datos<br>
	 * @return  List<Parameter> con la lista de los parámetros
	 */
	public List<Parameter> list();
}
