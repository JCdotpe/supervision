package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import pe.gob.oefa.efa.dao.UnidadMineraDao;
import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.UnidadMinera;

@Repository
public class UnidadMineraDaoImpl implements UnidadMineraDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUnidadMinera(UnidadMinera unidadMinera) {
		getSession().merge(unidadMinera);
	}

	@SuppressWarnings("unchecked")
	public List<UnidadMinera> listUnidadMineras() {
		
		return getSession().createQuery("from UnidadMinera where flgactivo='1'").list();
		
		//return getSession().createCriteria(UnidadMinera.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<UnidadMinera> listUnidadMineras_by_ID(BigDecimal id) {

		return getSession().createQuery("from UnidadMinera where IDUNIDADMINERA=:parameter1").setParameter("parameter1", id).list();
	}	
	
	public UnidadMinera getUnidadMinera(BigDecimal id) {
		return (UnidadMinera) getSession().get(UnidadMinera.class, id);
	}
	
	
	public void deleteUnidadMinera(BigDecimal id) {

		/*String sql = "delete from UnidadMinera where IDUNIDADMINERA=:parameter1";
		Query query = getSession().createQuery(sql).setParameter("parameter1", id);
		query.executeUpdate();*/
		
		UnidadMinera unidadMinera = getUnidadMinera(id);

		if (null != unidadMinera) {
			//getSession().delete(actividad);
			unidadMinera.setFlgactivo("0");
			getSession().update(unidadMinera);
		}
		
	}

	public void deleteUnidadMineras_by_AdmID(BigDecimal id) {
		//getSession().createQuery("delete from Responsable where IDEFA=:parameter1").setParameter("parameter1", id);
//		String sql = "delete from TUNIDADMINERA where IDADMINISTRADOS=:parameter1";
//		Query query = getSession().createQuery(sql).setParameter("parameter1", id);
//		query.executeUpdate();
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
