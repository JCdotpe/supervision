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
import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.MatrizActividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.NamedParameterStatement;


@Repository
public class ActividadDaoImpl implements ActividadDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveActividad(Actividad actividad) {
		getSession().merge(actividad);

	}

	@SuppressWarnings("unchecked")
	public List<Actividad> listActividades(String usuario,String perfil) { //modificado
		if(perfil.equals("Supervisor")){
			return getSession().createQuery("from Actividad where flgactivo='1' and usuario='"+usuario+"'").list();
		}else{
			return getSession().createQuery("from Actividad where flgactivo='1'").list();
		}
		
//		return getSession().createCriteria(Actividad.class).list();
	}

	public Actividad getActividad(BigDecimal id) {
		return (Actividad) getSession().get(Actividad.class, id);
	}
	
//	@SuppressWarnings("unchecked")
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id) {
//
//		return getSession().createQuery("from ActividadResponsable where IDACTIVIDAD=:parameter1").setParameter("parameter1", id).list();
//	}		

	
	public void deleteActividad(BigDecimal id) {

		Actividad actividad = getActividad(id);

		if (null != actividad) {
			//getSession().delete(actividad);
			actividad.setFlgactivo("0");
			getSession().update(actividad);
		}

	}

	public void deleteActResponsable(BigDecimal actid, BigDecimal resid) {
//		 getSession().createQuery("delete from actividad_responsable where IDACTIVIDAD=:parameter1 and IDRESPONSABLE=:parameter2").setParameter("parameter1", actid).setParameter("parameter2", resid).list();
		 try
		    {
		      Connection conn = ConnectionManager.getConnection();
		      String query = "delete from efa_actividad_responsable where IDACTIVIDAD=? and IDRESPONSABLE=?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setBigDecimal(1, actid);
		      preparedStmt.setBigDecimal(2, resid);
		      // execute the preparedstatement
		      preparedStmt.execute();
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }	

	}	
	public void deleteActSupervisor(BigDecimal actid, BigDecimal supid) {
		 try
		    {
		      Connection conn = ConnectionManager.getConnection();
		      String query = "delete from efa_actividad_supervisor where IDACTIVIDAD=? and IDSUPERVISOR=?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setBigDecimal(1, actid);
		      preparedStmt.setBigDecimal(2, supid);
		      // execute the preparedstatement
		      preparedStmt.execute();
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }	
		
	}	

	@SuppressWarnings("unchecked")
	public List listActividades_by(String fechaini,
			String fechafin, String nombrefa, String nombresup,
			String nivel, String informe, String codact, String estado, String estadomatriz, String estadoejec) {
		
		ArrayList list = new ArrayList();
		String[] queryx = new String[8];
		List<Integer> com = new ArrayList<Integer>();
		 try
		 {
		      Connection conn = ConnectionManager.getConnection();
		      String query = "Select a.IDACTIVIDAD, a.FECHAINI, a.FECHAFIN,a.CODACTIVIDAD, CASE WHEN a.HALLAZGO is null THEN 'NO' ELSE 'SI' END as hallazgo, CASE WHEN a.SUPERVISION is null THEN 'NO' ELSE 'SI' END as supervision, a.NIVEL,CASE WHEN a.ANALITICA is null THEN 'NO' ELSE 'SI' END as ANALITICA , a.ESTADO, e.NOMBRE as efanombre, (a.departamentodes  || ' - ' || a.provinciades || ' - ' || a.distritodes) as ubigeo, (s.appaterno  || ' ' || s.apmaterno || ', ' || s.nombre) as supnombre    from efa_actividad a left join efa_efa e on a.idefa = e.id left join efa_supervisor s on s.id = a.idsupres where ";
		    
		      if(fechaini != ""){
		    	  queryx[0] = " a.FECHAINI >= to_date(:fechaini,'DD/MM/YY') ";
		    	  com.add(0);
		      }
		      if(fechafin != ""){
		    	  queryx[1] = " a.FECHAFIN <= to_date(:fechafin,'DD/MM/YY') ";
		    	  com.add(1);
		      }
		      	      
		      if(nombrefa != ""){
		    	  queryx[2] = " lower(e.NOMBRE) LIKE :nombrefa ";
		    	  com.add(2);
		      }
		      if(nombresup != ""){
		    	  queryx[3] = " lower(CONCAT(CONCAT(s.NOMBRE,s.APPATERNO),s.APMATERNO)) LIKE :nombresup ";
		    	  com.add(3);
		      }		  
		      if(nivel.compareTo("0") != 0){
		    	  queryx[4] = " a.NIVEL = :nivel ";
		    	  com.add(4);
		      }		
		      if(codact != ""){
		    	  queryx[5] = " lower(a.CODACTIVIDAD) LIKE :codact ";
		    	  com.add(5);
		      }				      
		      if(estado.compareTo("0") != 0){
		    	  queryx[6] = " a.estado = :estado ";
		    	  com.add(6);
		      }	
		      if(estadomatriz.compareTo("0") != 0){
		    	  queryx[7] = " a.estadomatriz = :estadomatriz ";
		    	  com.add(7);
		      }	
		      if(estadoejec.compareTo("0") != 0){
		    	  queryx[8] = " a.estadoejec = :estadoejec ";
		    	  com.add(8);
		      }			      
		      int ox = 1;
		      for(int c: com){
		    	  if(ox != com.size())
		    		  query += queryx[c] + " and ";	
		    	  else
		    		  query += queryx[c];	
		    	  ox++;
		    	}		      
		      
//		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      
		      NamedParameterStatement p=new NamedParameterStatement(conn, query);
		            
		      if(fechaini != "")
		    	  p.setString("fechaini", fechaini);      
		      
		      if(fechafin != "")
		    	  p.setString("fechafin", fechafin);
		      
			  if(nombrefa!="")
				  p.setString("nombrefa", "%" + nombrefa.toLowerCase() + "%");
		      
		      if(nombresup!="")
		    	  p.setString("nombresup", "%" + nombresup.replaceAll("\\s","").toLowerCase() + "%");      
		      
		      if(nivel.compareTo("0") != 0)
		    	  p.setString("nivel", nivel);		      
		      
		      if(codact!="")
		    	  p.setString("codact", "%" + codact.toLowerCase() + "%");
		      
		      if(estado.compareTo("0") != 0)
		    	  p.setString("estado", estado);

		      if(estadomatriz.compareTo("0") != 0)
		    	  p.setString("estadomatriz", estadomatriz);
		      
		      if(estadoejec.compareTo("0") != 0)
		    	  p.setString("estadoejec", estadoejec);		      
		      
		      // execute the preparedstatement
		      ResultSet rs =p.executeQuery();
		      ResultSetMetaData md = rs.getMetaData();
		      int columns = md.getColumnCount();
		     
		      while (rs.next()){
		         HashMap row = new HashMap(columns);
		         for(int i=1; i<=columns; ++i){           
		          row.put(md.getColumnName(i),rs.getObject(i));
		         }
		          list.add(row);
		          System.out.println(row);
		      }
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }			
		
		 return list;      	
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


	public void saveActividadMatriz(MatrizActividad matrizactividad) {
		getSession().merge(matrizactividad);
	}


}
