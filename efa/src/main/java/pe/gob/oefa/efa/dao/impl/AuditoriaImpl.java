package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.AuditoriaDao;
import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.Auditoria;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.utils.ConnectionManager;

@Repository
public class AuditoriaImpl implements AuditoriaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveAuditoria(Auditoria auditoria) {

		try {
			getSession().merge(auditoria);
		} catch (Exception e) {
			return;
		}	
	}
	
	
	public int getIdTipoAccionId(String codaccion) {

		BigDecimal result = null;
		Connection connection = null;
	    ResultSet rs = null;
	    PreparedStatement pstatement = null;
	    
		try 
		{
	    	connection = ConnectionManager.getConnection();
	    	String queryString = "SELECT * FROM TTIPO_ACCION WHERE CODIGO=?";
	    	pstatement = connection.prepareStatement(queryString);
	    	 pstatement.setString(1, codaccion);
	    	 rs = pstatement.executeQuery();
		    while (rs.next()) {
		    	result = new BigDecimal(rs.getString("ID_TIPO_ACCION"));
	        }	
		    
		    return result.intValue();
		    
		} catch (Exception e) {
			return 0;
		}

	}

	
	public int getIdTablaReferencia(String codtable) {

		BigDecimal result = null;
		Connection connection = null;
	    ResultSet rs = null;
	    PreparedStatement pstatement = null;
	    
		try 
		{
	    	connection = ConnectionManager.getConnection();
	    	String queryString = "SELECT * FROM TTABLA_REFERENCIA WHERE CODIGO=?";
	    	pstatement = connection.prepareStatement(queryString);
	    	 pstatement.setString(1, codtable);
	    	 rs = pstatement.executeQuery();
		    while (rs.next()) {
		    	result = new BigDecimal(rs.getString("ID_TABLA_REFERENCIA"));
	        }	
		    
		    return result.intValue();
		    
		} catch (Exception e) {
			return 0;
		}

		
	}
	
	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
