package libWeb.DAO.interfaces;

import java.util.List;

import libWeb.entities.Leftoverbook;

/**
 * Interface que representa el Data Access Object (DAO) de los libros sobrantes
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
public interface LeftOverBookDAO 
{
	/**
	 * Guarda un "libro sobrante" en la base de datos<br>
	 * <b> post:</b> Se guardó el leftoverbook en la base de datos<br>
	 * @param overBook Leftoverbook a guardar
	 */
	public void save(Leftoverbook overBook);

	/**
	 * Obtiene el "libro sobrante" en referencia al pasado por parámetro
	 * @param overBook Leftoverbook referencia a buscar
	 * @return Leftoverbook encontrado con las características del buscado
	 */
	public Leftoverbook getLeftOverBook(Leftoverbook overBook);

	/**
	 * Elimina el "libro sobrante" de la base de datos en referencia al pasado 
	 *  por parametro<br>
	 * <b> post:</b> Se eliminó el leftoverbook de la base de datos<br>
	 * @param overBook Leftoverbook referencia a eliminar
	 */
	public void remove(Leftoverbook overBook);
	
	/**
	 * Modifica un libro de la base de datos en referencia al pasado 
	 *  por parametro<br>
	 * <b> post:</b> Se modificó el leftoverbook de la base de datos<br>
	 * @param overBook Leftoverbook referencia a actualizar
	 */
	public void update(Leftoverbook overBook);
	
	/**
	 * Lista los "libros sobrantes" de un usuario específico<br>
	 * @param id int con el id del usuario al cual se le buscarán los libros
	 * @return  List<Leftoverbook> con la lista de los "libros sobrantes" del usuario
	 */
	public List<Leftoverbook> getLibrosUsuatio(int id);
}
