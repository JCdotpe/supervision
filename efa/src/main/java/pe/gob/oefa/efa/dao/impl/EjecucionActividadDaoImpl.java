package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;









import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.ActividadDao;
import pe.gob.oefa.efa.dao.EjecucionActividadDao;
import pe.gob.oefa.efa.model.EjecucionActividad;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.LabelValue;


@Repository
public class EjecucionActividadDaoImpl implements EjecucionActividadDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ActividadDao actividadDao;
	public void saveEjecucionActividad(EjecucionActividad ejecucionActividad) {
		getSession().merge(ejecucionActividad);

	}

	public EjecucionActividad getEjecucionActividad(BigDecimal id) {
		return (EjecucionActividad) getSession().get(EjecucionActividad.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public EjecucionActividad getEjecucionActividad_BY(BigDecimal id) {
	    Connection connection = null;
	    ResultSet rs = null;
	    PreparedStatement pstatement = null;		
	    EjecucionActividad ejec = new EjecucionActividad();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    try{
	    	connection = ConnectionManager.getConnection();
	    	String queryString = "SELECT * FROM TEJECUCION WHERE IDACTIVIDAD=?";
	    	pstatement = connection.prepareStatement(queryString);
	    	 pstatement.setString(1, id.toString());
	    	 rs = pstatement.executeQuery();
		    while (rs.next()) {
		    	ejec.setIdejecucion(new BigDecimal(rs.getString("IDEJECUCION")));
		    	ejec.setFecha(formatter.parse(rs.getString("FECHA")));
		    	ejec.setFechaejec(formatter.parse(rs.getString("FECHAEJEC")));
		    	ejec.setEstado(rs.getString("ESTADO"));
		    	ejec.setSupespecial(rs.getString("SUPESPECIAL"));
		    	ejec.setHallazgos(rs.getString("HALLAZGOS"));
		    	ejec.setObservacion(rs.getString("OBSERVACION"));
		    	BigDecimal asd = new BigDecimal(rs.getString("IDACTIVIDAD"));
		    	ejec.setActividad(actividadDao.getActividad(asd));
	        }	  	  
		    
	    }catch (Exception e) { e.printStackTrace(); }		
		finally {
			try{
				if (pstatement != null) {
					pstatement.close();
				}
		
				if (connection != null) {
					connection.close();
				}
			}catch (SQLException e) { e.printStackTrace(); }

		}	
		 return ejec;
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
