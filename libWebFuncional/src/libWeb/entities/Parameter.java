package libWeb.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase presistente de la tabla parameter de la base de datos
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
@Entity
@Table(name = "parameter")
public class Parameter implements Serializable
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
	 * 	Tipo de parámetro
	 */
	private String parameterType;

	/**
	 * Codigo del parámetro
	 */
	private String parameterCode;

	/**
	 * Descripción del parámetro
	 */
	private String descriptionParameter;

	/**
	 * Valor del texto
	 */
	private String textValue;

	/**
	 * Número de la variable
	 */
	private int numberValue;

	/**
	 * Constructor de la entidad
	 */
	public Parameter() {}

	/**
	 * Id de la tabla 
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
	 * Cambia el id de la tabla 
	 * @param id a cambiar en la tabla
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Tipo de parámetro hecho
	 * @return tipo de parámetro
	 */
	@Column(name = "parameterType")
	public String getParameterType()
	{
		return parameterType;
	}

	/**
	 * Cambia el tipo de parámetro de la tabla
	 * @param parameterType tipo de parametro a cambiar en la base de datos 
	 */
	public void setParameterType(String parameterType)
	{
		this.parameterType = parameterType;
	}

	/**
	 * Código del parámetro de la tabla
	 * @return código del parámetro 
	 */
	@Column(name = "parameterCode")
	public String getParameterCode()
	{
		return parameterCode;
	}

	/**
	 * Cambia el código del parámetro en la base de datos 
	 * @param parameterCode parámetro a cambiar 
	 */
	public void setParameterCode(String parameterCode)
	{
		this.parameterCode = parameterCode;
	}

	/**
	 * Retorna la Descripción del parámetro 
	 * @return descripción del parámetro
	 */
	@Column(name = "descriptionParameter")
	public String getDescriptionParameter()
	{
		return descriptionParameter;
	}

	/**
	 * Cambia la descripción del parámetro 
	 * @param descriptionParameter descripción a cambiar en la base de datos 
	 */
	public void setDescriptionParameter(String descriptionParameter)
	{
		this.descriptionParameter = descriptionParameter;
	}

	/**
	 * Valor de texto del parámetro
	 * @return valor del texto
	 */
	@Column(name = "textValue")
	public String getTextValue()
	{
		return textValue;
	}

	/**
	 * Cambia el valor del texto 
	 * @param textValue valor a cambiar en la base de datos 
	 */
	public void setTextValue(String textValue) 
	{
		this.textValue = textValue;
	}

	/**
	 * Valor del parámetro 
	 * @return valor del parámetro
	 */
	@Column(name = "numberValue")
	public int getNumberValue()
	{
		return numberValue;
	}

	/**
	 * Cambia el valor del parémetro 
	 * @param numberValue valor a cambiar en la base de datos 
	 */
	public void setNumberValue(int numberValue)
	{
		this.numberValue = numberValue;
	}
}