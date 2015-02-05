package pe.gob.oefa.efa.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.DATE;
import pe.gob.oefa.efa.dao.ReporteDAO;
import pe.gob.oefa.efa.form.ReporteForm;
import pe.gob.oefa.efa.model.ComponenteMatriz;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.ReporteActividad;
import pe.gob.oefa.efa.utils.ConnectionManager;


@Repository
public class ReporteDAOImpl implements ReporteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<ReporteActividad> obtenerReporte(ReporteForm form) {
		List<ReporteActividad> oListarReporteActividades = new ArrayList<ReporteActividad>();
			
		CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    Date fecha = new Date();
	    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
	    try{
	    	connection = ConnectionManager.getConnection();
		    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_ACTIVIDADES(?,?,?,?,?,?,?,?,?,?,?,?,?); END;");
		    stmt.registerOutParameter(1, OracleTypes.CURSOR); //REF CURSOR
		    stmt.setString(2, form.getNivelGobierno().equals("")?" ":form.getNivelGobierno());
		    stmt.setString(3, form.getEfa().equals("")?"0":form.getEfa());
		    stmt.setString(4, form.getTipoSupervision().equals("")?" ":form.getTipoSupervision());
		    stmt.setString(5, form.getActividad().equals("")?" ":form.getActividad());
		    stmt.setString(6, form.getSupervisor().equals("")?"0":form.getSupervisor());
		    stmt.setString(7, form.getDepartamento().equals("")?" ":form.getDepartamento());
		    stmt.setString(8, form.getProvincia().equals("") || form.getProvincia().equals("-1")?" ":form.getProvincia());
		    stmt.setString(9, form.getDistrito().equals("") || form.getDistrito().equals("-1")?" ":form.getDistrito());
		    stmt.setString(10,form.getInicioSupervision().equals("")? "01/01/1980":form.getInicioSupervision());
		    stmt.setString(11,form.getFinSupervision().equals("")? dt1.format(fecha):form.getFinSupervision());
		    stmt.setString(12,form.getEstadoActividad().equals("")? " ":form.getEstadoActividad());
		    stmt.setString(13,form.getComponente().equals("")?"0":form.getComponente());
		    stmt.execute();
		    rs = ((OracleCallableStatement)stmt).getCursor(1);
		    ReporteActividad oReporteActividad = null;
		    while (rs.next()) {
		      oReporteActividad = new ReporteActividad();
           	  oReporteActividad.setNumero(rs.getString("NROACTIVIDAD"));
           	  oReporteActividad.setFechaInicio(rs.getString("FECHAINI"));
           	  oReporteActividad.setFechaFin(rs.getString("FECHAFIN"));
           	  oReporteActividad.setEstado(rs.getString("ESTADO"));
           	  oReporteActividad.setDescripcion(rs.getString("DESCRIPCION"));
           	  oReporteActividad.setNivelGobierno(rs.getString("NIVELGOBIERNO"));
           	  oReporteActividad.setEfa(rs.getString("NOMBRE"));
           	  oReporteActividad.setTipoSupervision(rs.getString("TIPO"));
           	  oReporteActividad.setSupervisor(rs.getString("SUPERVRESPONS"));
           	  oReporteActividad.setSupervisores(rs.getString("EQUIPORESPONS"));
           	  oReporteActividad.setAnalitica(rs.getString("ANALITICA"));
           	  oReporteActividad.setDepartamento(rs.getString("DEPARTAMENTO"));
           	  oReporteActividad.setProvincia(rs.getString("PROVINCIA"));
           	  oReporteActividad.setDistrito(rs.getString("DISTRITO"));
           	  oReporteActividad.setComponente(rs.getString("COMPONENTE"));
           	  oReporteActividad.setSubComponente(rs.getString("SUBCOMPONENTE"));
           	  oReporteActividad.setIndicador(rs.getString("INDICADOR"));
           	  oReporteActividad.setObservacion(rs.getString("OBSERVACIONES"));
           	  oReporteActividad.setSupervisionEspecial(rs.getString("REQUIERE_SUPERVISION"));
           	  oReporteActividad.setHallazgosCriticos(rs.getString("HALLAZGOS_CRITICOS"));
           	  oReporteActividad.setDocumento(rs.getString("TIPO_NUMERODOCUMENTO"));            	  
           	  oListarReporteActividades.add(oReporteActividad);
	        }		  
		    
	    }catch (SQLException e) { e.printStackTrace(); }		
		finally {
			try{
				if (callableStatement != null) {
					callableStatement.close();
				}
		
				if (connection != null) {
					connection.close();
				}
			}catch (SQLException e) { e.printStackTrace(); }

		}	
		
		return oListarReporteActividades;
	}
	
	

	

	public List<ComponenteMatriz> listarComponenteMatriz() {		
		List<ComponenteMatriz> oListarSubComponenteMatriz = new ArrayList<ComponenteMatriz>();
		CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
		
	    try{
	    	connection = ConnectionManager.getConnection();
		    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_COMP_SUBCOMP(?); END;");
		    stmt.registerOutParameter(1, OracleTypes.CURSOR); 		    
		 
		    stmt.execute();
		    rs = ((OracleCallableStatement)stmt).getCursor(1);
		    ComponenteMatriz oComponenteMatriz = null;
		    while (rs.next()) {
		    	oComponenteMatriz = new ComponenteMatriz();
		    	oComponenteMatriz.setIdcomponente(rs.getInt("IDCOMPONENTE"));
		    	oComponenteMatriz.setDescripcioncomponente(rs.getString("COMP_SUBCOMP"));
		    	oListarSubComponenteMatriz.add(oComponenteMatriz);
	        }		  
		    
	    }catch (SQLException e) { e.printStackTrace(); }		
		finally {
			try{
				if (callableStatement != null) {
					callableStatement.close();
				}
		
				if (connection != null) {
					connection.close();
				}
			}catch (SQLException e) { e.printStackTrace(); }

		}
	    
	    return oListarSubComponenteMatriz;
	}
	
	private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }
	
	
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	
	

}
