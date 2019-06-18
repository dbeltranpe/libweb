package libWeb.DAO.interfaces;
import java.util.List;
import libWeb.entities.Audit;
/**
 * Interface que representa el Data Access Object (DAO) de las auditorías
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
public interface AuditDAO
{
	/**
	 * Guarda una auditoría en la base de datos<br>
	 * <b> post:</b> Se guardó la auditoria en la base de datos<br>
	 * @param auditoria Audit a guardar
	 */
	public void save(Audit auditoria);

	/**
	 * Lista todas las auditorias de la base de datos
	 * @return List<Audit> con la lista de auditorias
	 */
	public List<Audit> list();

	/**
	 * Lista las auditorias de un usuario por su id
	 * @param userId int con el id del usuario a consultar
	 * @return List<Audit> lista de auditorias por el usuario
	 */
	public List<Audit> listUser(int userId);
}
