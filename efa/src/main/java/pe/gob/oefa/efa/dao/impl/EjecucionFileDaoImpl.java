package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.EjecucionFileDao;
import pe.gob.oefa.efa.model.EjecucionFile;
import pe.gob.oefa.efa.utils.ConnectionManager;

@Repository
public class EjecucionFileDaoImpl implements EjecucionFileDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveEjecucionFile(EjecucionFile ejecucionFile) {
		getSession().merge(ejecucionFile);

	}

	@SuppressWarnings("unchecked")
	public List<EjecucionFile> listEjecucionFile() {

		return getSession().createCriteria(EjecucionFile.class).list();
	}

	public EjecucionFile getEjecucionFile(BigDecimal id) {
		return (EjecucionFile) getSession().get(EjecucionFile.class, id);
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}
	
	public void deleteEjecucionFile(BigDecimal id) {
//		EjecucionFile ejecucionFile = getEjecucionFile(id);
//
//		if (null != ejecucionFile) {
//			getSession().delete(ejecucionFile);
//		}
		 try
		    {
		      Connection conn = ConnectionManager.getConnection();
		      String query = "delete from tejecucion_file where IDEJECFILE=?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setBigDecimal(1, id);
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
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
