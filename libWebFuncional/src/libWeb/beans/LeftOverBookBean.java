package libWeb.beans;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;

import libWeb.DAO.implementation.AuditDAOImpl;
import libWeb.DAO.implementation.LeftOverBookDAOimpl;
import libWeb.DAO.implementation.UserDAOimpl;
import libWeb.DAO.interfaces.AuditDAO;
import libWeb.DAO.interfaces.LeftOverBookDAO;
import libWeb.DAO.interfaces.UserDAO;
import libWeb.entities.Audit;
import libWeb.entities.Leftoverbook;
import libWeb.entities.User;

/**
 * Clase que representa el Bean de libro sobrante (LeftOverBookBean)
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
@ManagedBean
@SessionScoped
public class LeftOverBookBean
{

	/**
	 * Logger del bean (log4j)
	 */
	private final static Logger logger = Logger.getLogger(LeftOverBookBean.class);

	/**
	 * Libro sobrante
	 */
	private Leftoverbook libroSobrante;

	/**
	 * Datamodel con la lista de libros sobrantes
	 */
	private DataModel<Leftoverbook> listaSobrantes;

	/**
	 * Dirección del usuario que posee el libro
	 */
	private String direccion;

	/**
	 * UserBean del sistema
	 */
	@ManagedProperty("#{userBean}")
	private UserBean userBean;

	/**
	 * Correo del usuario
	 */
	private String emailUser;

	/**
	 * Libro
	 */
	private String libro;

	/**
	 * Usuario
	 */
	private User user;

	/**
	 * Constructor del bean
	 */
	public LeftOverBookBean()
	{
		libroSobrante = new Leftoverbook();
	}

	/**
	 * Retorna el UserBean
	 * @return UserBean bean de usuario
	 */
	public UserBean getUserBean()
	{
		return userBean;
	}

	/**
	 * Cambia el userBean<br>
	 * <b> post:</b> Se cambió el userBean<br>
	 * @param user UserBean remplazo
	 */
	public void setUserBean(UserBean user)
	{
		userBean = user;
	}

	/**
	 * Retorna el email del usuario representativo del bean
	 * @return Cadena de texto con el email del usuario
	 */
	public String getEmailUser()
	{
		return emailUser;
	}

	/**
	 * Cambia el email del usuario representativo del bean<br>
	 * <b> post:</b> Se cambió el userBean<br>
	 * @param user UserBean remplazo
	 */
	public void setEmailUser(String pCorreo)
	{
		emailUser = pCorreo;
	}

	/**
	 * Retorna cadena de texto con el libro
	 * @return cadena de texto con el libro
	 */
	public String getLibro()
	{
		return libro;
	}

	/**
	 * Inicializa el libro sobrante para adicionarlo<br>
	 * <b> post:</b> Se inicializó el libro sobrante con la fecha actual,
	 *  el nombre del usuario y el id del usuario
	 */
	public void prepararAdicionarLibroSobrante() 
	{
		libroSobrante = new Leftoverbook();

		libroSobrante.setDate(new Date());
		libroSobrante.setUserName(userBean.getUsuario().getUserName());
		libroSobrante.setUserId(userBean.getUsuario().getId());
	}

	/**
	 * Prepara un libro sobrante para modificar<br>
	 * <b> pre:</b> listaSobrantes != null<br>
	 * <b> post:</b> Se inicializó el libroSobrante como el libro 
	 *  en la lista a modificar<br>
	 * @return Cadena de texto "editarLibro"
	 */
	public String prepararModificarLibroSobrante() 
	{
		libroSobrante = (Leftoverbook) (listaSobrantes.getRowData());
		return "editarLibro";
	}

	/**
	 * Elimina el libro sobrante elegido<br>
	 * <b> pre:</b> listaSobrantes != null <br>
	 * <b> post:</b> Se eliminó el libro y se actualizó en la base de datos.
	 *  se registró una auditoría de registro<br>
	 */
	public void eliminarLibroSobrante() 
	{
		Leftoverbook LibroSobranteTemp = (Leftoverbook)(listaSobrantes.getRowData());
		LeftOverBookDAO dao = new LeftOverBookDAOimpl();
		dao.remove(LibroSobranteTemp);

		AuditDAO daoAudit = new AuditDAOImpl();
		Audit audit = new Audit();
		audit.setCreateDate(new Date());
		audit.setTableName("leftOverBook");
		audit.setUserId(userBean.getUsuario().getId());
		audit.setTableId(audit.getTableId());
		audit.setIp(userBean.darDireccionIp());
		audit.setNameUser(userBean.getUsuario().getUserName());
		audit.setOperation("EliminoLibro");

		daoAudit.save(audit);

		try 
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("./misLibros.xhtml");
		} 
		catch (IOException e) 
		{
			logger.error(e.getMessage());
		}
	}

	/**
	 * Adiciona un libro sobrante al sistema<br>
	 * <b> post:</b> Se agregó un leftoverbook a la base de datos y 
	 *  se registró una auditoría de registro<br>
	 * @return Cadena de texto "misLibros"
	 */
	public String adicionarLibroSobrante() 
	{
		LeftOverBookDAO dao = new LeftOverBookDAOimpl();
		dao.save(libroSobrante);

		AuditDAO daoAudit = new AuditDAOImpl();
		Audit audit = new Audit();
		audit.setCreateDate(new Date());
		audit.setTableName("leftOverBook");
		audit.setUserId(userBean.getUsuario().getId());
		audit.setTableId(audit.getTableId());
		audit.setIp(userBean.darDireccionIp());
		audit.setNameUser(userBean.getUsuario().getUserName());
		audit.setOperation("AgregoLibro");

		daoAudit.save(audit);

		libroSobrante = null;

		return "misLibros";
	}

	/**
	 * Modifica el libro sobrante<br>
	 * <b> post:</b> Se modificó el libro y se actualizó en la base de datos, 
	 *  también se agregó una auditoría en la base de datos
	 * @return 
	 */
	public String modificarLibroSobrante() 
	{
		LeftOverBookDAO dao = new LeftOverBookDAOimpl();
		libroSobrante.setDate(new Date());
		dao.update(libroSobrante);

		AuditDAO daoAudit = new AuditDAOImpl();
		Audit audit = new Audit();
		audit.setCreateDate(new Date());
		audit.setTableName("leftOverBook");
		audit.setUserId(userBean.getUsuario().getId());
		audit.setTableId(audit.getTableId());
		audit.setIp(userBean.darDireccionIp());
		audit.setNameUser(userBean.getUsuario().getUserName());
		audit.setOperation("ModificoLibro");

		daoAudit.save(audit);

		libroSobrante = null;
		return "misLibros";
	}

	/**
	 * Retorna el libro sobranmte
	 * @return Leftoverbook libro sobrante
	 */
	public Leftoverbook getLibroSobrante() 
	{
		return libroSobrante;
	}

	/**
	 * Cambia el libro sobrante<br>
	 * <b> post:</b> Se cambió el libro sobrante<br>
	 * @param pLibroSobrante Leftoverbook remplazo 
	 */
	public void setLibroSobrante(Leftoverbook pLibroSobrante) 
	{
		libroSobrante = pLibroSobrante;
	}

	/**
	 * Lista los libros sobrantes en un datamodel
	 * @return DataModel<Leftoverbook> datamodel con los libros sobrantes
	 */
	public DataModel<Leftoverbook> getListarLibroSobrantes() 
	{
		List<Leftoverbook> lista = new LeftOverBookDAOimpl().list();
		listaSobrantes = new ListDataModel<>(lista);
		return listaSobrantes;
	}

	/**
	 * Obtiene un datamodel con los libros sobrantes del usuario
	 *  actual en el sistema
	 * @return DataModel<Leftoverbook> datamodel con los libros sobrantes 
	 * del usuario actual en el sistema
	 */
	public DataModel<Leftoverbook> getLibrosUser() 
	{
		LeftOverBookDAO leftOver = new LeftOverBookDAOimpl();
		listaSobrantes = new ListDataModel<>(leftOver.getLibrosUsuatio(userBean.getUsuario().getId()));
		return listaSobrantes;
	}

	/**
	 * Método que envía un correo
	 */
	public void enviarCorreo()
	{
		try
		{
			int idUsuario = listaSobrantes.getRowData().getUserId();
			libro = listaSobrantes.getRowData().getName();
			UserDAO daoUser = new UserDAOimpl();
			User user = daoUser.getUsuarioPorId(idUsuario);
			userBean.setEmailUser(user.getEmailAddress());
			emailUser = user.getEmailAddress();
		}
		catch (Exception e) 
		{
			logger.error(e.getMessage());
		}
	}

	/**
	 * Retorna el usuario referencia en el leftoverbookbean
	 * @return User  usuario referencia en el leftoverbookbean
	 */
	public User getUser()
	{
		return user;
	}


	/**
	 * Cambia el usuario referencia en el leftoverbookbean
	 * @param usuario Usuario referencia en el leftoverbookbean
	 */
	public void setUser(User usuario)
	{
		user = usuario;
	}

	/**
	 * Retorna la dirección
	 * @return Cadena de texto con la dirección
	 */
	public String getDireccion() 
	{
		return direccion;
	}

	/**
	 * Cambia la dirección
	 * @param direccion Direccion remplazo
	 */
	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}

	/**
	 * Elimina un libro seleccionado en la lista<br>
	 * <b> pre:</b> listaSobrantes != null<br> 
	 * <b> post:</b> Se eliminó el libro, se actualizó la base de datos y
	 *  se agregó una auditoría.
	 * @return Cadena de texto vacía
	 */
	public String eliminarLibro()
	{
		Leftoverbook book = listaSobrantes.getRowData();

		LeftOverBookDAO daoBook = new LeftOverBookDAOimpl();
		daoBook.remove(book);

		AuditDAO daoAudit = new AuditDAOImpl();
		Audit audit = new Audit();
		audit.setCreateDate(new Date());
		audit.setTableName("leftOverBook");
		audit.setUserId(userBean.getUsuario().getId());
		audit.setTableId(audit.getTableId());
		audit.setIp(userBean.darDireccionIp());
		audit.setNameUser(userBean.getUsuario().getUserName());
		audit.setOperation("eliminoLibro");
		daoAudit.save(audit);

		return "";
	}

	/**
	 * Retorna la dirección ip del usuario actual en el sistema
	 * @return Cadena de texto con la dirección ip del usuario actual en el sistema
	 */
	public String darDireccionIp()
	{
		String rta = "";
		try 
		{
			InetAddress direccion = InetAddress.getLocalHost();
			rta = direccion.getHostAddress();
		} 
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}

		return rta;
	}
}
