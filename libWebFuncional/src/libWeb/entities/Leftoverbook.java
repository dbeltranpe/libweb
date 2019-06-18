package libWeb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * Clase presistente del la tabla leftoverbook de la base de datos
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
@Entity
@Table(name="leftoverbooks")
public class Leftoverbook implements Serializable 
{
	/**
	 * Serial de la versión
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id de la tabla 
	 */
	private int id;

	/**
	 * Autor del libro
	 */
	private String author;

	/**
	 * Fecha en el que se agrego el libro
	 */
	private Date date;

	/**
	 * Edición del libro
	 */
	private int edition;

	/**
	 * Editorial del libro
	 */
	private String editorial;

	/**
	 * Nombre del libro
	 */
	private String name;

	/**
	 * Id del usuario que agrego el libro
	 */
	private int userId;

	/**
	 * Nombre del usuario que agrego el libro
	 */
	private String userName;

	/**
	 * Constructor del la entidad
	 */
	public Leftoverbook() 
	{
	}

	/**
	 * Obtiene el id del la tabla
	 * @return id de la tabla 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() 
	{
		return this.id;
	}

	/**
	 * Cambia el id del la tabla 
	 * <b> post: </b> se cambió el id en la base de datos 
	 * @param id a cambiar 
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * Nombre del autor del libro
	 * @return autor del libro 
	 */
	@Column(name = "author")
	public String getAuthor()
	{
		return this.author;
	}

	/**
	 * Cambia el nombre del autor
	 * @param author nombre del autor a cambiar
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Obtiene la fecha de cuando se agregó el libro 
	 * @return fecha de la agregación del libro
	 */
	@Column(name = "date")
	public Date getDate()
	{
		return this.date;
	}

	/**
	 * Cambia la fecha de la agregación del libro
	 * @param date fecha a cambiar 
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/**
	 * Edición del libro agregado 
	 * @return ediución del libro
	 */
	@Column(name = "edition")
	public int getEdition()
	{
		return this.edition;
	}

	/**
	 * Cambia la edición del libro
	 * @param edition edición a cambiar el libro
	 */
	public void setEdition(int edition)
	{
		this.edition = edition;
	}

	/**
	 * Cambia la editorial de del libro 
	 * @return editorial del libro
	 */
	@Column(name = "editorial")
	public String getEditorial() 
	{
		return this.editorial;
	}

	/**
	 * Cambia la editorial del libro 
	 * @param editorial editorial a cambiar
	 */
	public void setEditorial(String editorial)
	{
		this.editorial = editorial;
	}

	/**
	 * Retorna el nombre del libro
	 * @return String con el nombre del libro
	 */
	@Column(name = "name")
	public String getName()
	{
		return this.name;
	}

	/**
	 * Cambia el nombre del libro
	 * @param name nombre del libro a cambiar 
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Id del usuario que agrego el libro
	 * @return id del usuario
	 */
	@Column(name = "userId")
	public int getUserId()
	{
		return this.userId;
	}

	/**
	 * Cambia el id del usuario
	 * @param userId id a cambiar 
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * Nombre del usuario que agrego un libro 
	 * @return nombre dek usuario
	 */
	@Column(name = "userName")
	public String getUserName() 
	{
		return userName;
	}

	/**
	 * Cambia el nombre del usuario que agrego el libro
	 * @param userName nombre del usuario a cambiar
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}