package libWeb.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import libWeb.DAO.implementation.ParameterDAOimpl;
import libWeb.DAO.interfaces.ParameterDAO;
import libWeb.entities.Parameter;

/**
 * Clase que representa al parameterBean
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
public class ParameterBean
{
	/**
	 * Parametro para adicionar 
	 */
	private Parameter parametro;

	/**
	 * Lista de los parámetros
	 */
	private DataModel<Parameter> listaParametros;

	/**
	 * Constructor del Bean
	 */
	public ParameterBean()
	{
		parametro = new Parameter();
	}

	/**
	 * Método que inicializa la el atributo parámetro para adicionar uno
	 * @return página para adicionar
	 */
	public String prepararAdicionarParametro() 
	{
		parametro = new Parameter();
		return "";
	}

	/**
	 * Método que prepara el atributo para la modificación
	 * @return página para la modificación 
	 */
	public String prepararModificarParametro() 
	{
		parametro = (Parameter) (listaParametros.getRowData());
		return "";
	}

	/**
	 * Método que prepara el atributo para la eliminación
	 * @return página para eliminar
	 */
	public String eliminarParametro()
	{
		Parameter ParametroTemp = (Parameter) (listaParametros.getRowData());
		ParameterDAO dao = new ParameterDAOimpl();
		dao.update(ParametroTemp);
		return "";
	}

	/**
	 * Método que adiciona un nuevo parámetro
	 * @return página inicial
	 */
	public String adicionarParametro() 
	{
		ParameterDAO dao = new ParameterDAOimpl();
		dao.save(parametro);
		return "";
	}

	/**
	 * Método que modifica el atributo de parámetro 
	 * @return página inicial
	 */
	public String modificarParametro() 
	{
		ParameterDAO dao = new ParameterDAOimpl();
		dao.update(parametro);
		return "";
	}

	/**
	 * Obtiene el parámetro 
	 * @return parámetro
	 */
	public Parameter getParametro() 
	{
		return parametro;
	}

	/**
	 * Cambia los valores de los parámetros
	 * @param pParametro parámetro a cambiar 
	 */
	public void setParametro(Parameter pParametro) 
	{
		parametro = pParametro;
	}

	/**
	 * Genera la lista de los parámetros creados 
	 * @return página para la visualización de los parámetros
	 */
	public DataModel<Parameter> getListarParametros() 
	{
		List<Parameter> lista = new ParameterDAOimpl().list();
		listaParametros = new ListDataModel<>(lista);
		return listaParametros;
	}

}
