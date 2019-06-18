 package libWeb.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import libWeb.DAO.implementation.AuditDAOImpl;
import libWeb.DAO.interfaces.AuditDAO;
import libWeb.entities.Audit;
import libWeb.util.Correo;

/**
 * Clase que representa al CorreoUserBean
 * @author Daniel Beltrán Penagos
 * @author Santiago Correa Vera 
 * <br><br>
 * <center> <b> Universidad El Bosque<br>
 * Ingeniería de Sistemas - Programación 2<br>
 * Profesor Wilson Rojas Reales <br>
 * Proyecto libWeb</b> </center>
 */
@ManagedBean
public class CorreoBeanUser 
{

	/**
	 * Asunto del Correo 
	 */
	private String subject;

	@ManagedProperty("#{leftOverBookBean}")
	/**
	 * Conexión con el leftoverbookbean
	 */
	private LeftOverBookBean leftOverBookBean;

	/**
	 * Logger para los errores 
	 */
	private final static Logger logger = Logger.getLogger(CorreoBeanUser.class);

	/**
	 * Constructor del Bean
	 */
	public CorreoBeanUser()
	{
	}

	/**
	 * Obtiene la información del bean
	 * @return el bean leftOverBook
	 */
	public LeftOverBookBean getLeftOverBookBean()
	{
		return leftOverBookBean;
	}

	/**
	 * Cambia la información del Bean
	 * @param bean a cambiar
	 */
	public void setLeftOverBookBean(LeftOverBookBean bean)
	{
		leftOverBookBean = bean;
	}

	/**
	 * Obtiene el asuto del correo escrito por el usuario
	 * @return
	 */
	public String getSubject()
	{
		return subject;
	}

	/**
	 * Cambia el asunto del correo 
	 * @param sub asunto a cambiar 
	 */
	public void setSubject(String sub)
	{
		subject = sub;
	}

	/**
	 * Método que envía un correo entre usuarios, con sus respectivos correos electrónicos 
	 * <b> post: </b> se envió el correo al usuario seleccionado  
	 */
	public void enviarCorreo()
	{
		try
		{
			AuditDAO daoAudit = new AuditDAOImpl();

			Audit audit = new Audit();
			audit.setCreateDate(new Date());
			audit.setTableName("user");
			audit.setUserId(leftOverBookBean.getUserBean().getUsuario().getId());
			audit.setTableId(leftOverBookBean.getUserBean().getUsuario().getId());
			audit.setOperation("EnvCorreo");
			audit.setNameUser(leftOverBookBean.getUserBean().getUsuario().getUserName());
			audit.setIp(leftOverBookBean.darDireccionIp());
			daoAudit.save(audit);

			String cuerpo ="enviado por:" + leftOverBookBean.getUserBean().getUsuario().getUserName() + " " + " estoy interesado en este libro: " + leftOverBookBean.getLibro() +"\n Email de contacto: " + leftOverBookBean.getUserBean().getUsuario().getEmailAddress();
			Correo.enviarCorreo(leftOverBookBean.getEmailUser(), subject, cuerpo);

			FacesContext.getCurrentInstance().getExternalContext().redirect("./librosMundiales.xhtml");
		}
		catch (Exception e) 
		{
			logger.error("No se encontró la página ");
		}
	}
}
