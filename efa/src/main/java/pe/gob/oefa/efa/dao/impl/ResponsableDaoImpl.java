package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.ResponsableDao;
import pe.gob.oefa.efa.model.Responsable;

@Repository
public class ResponsableDaoImpl implements ResponsableDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveResponsable(Responsable responsable) {
		getSession().merge(responsable);
	}

	@SuppressWarnings("unchecked")
	public List<Responsable> listResponsables() {

		return getSession().createCriteria(Responsable.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Responsable> listResponsables_by_ID(BigDecimal id) {

		return getSession().createQuery("from Responsable where IDEFA=:parameter1").setParameter("parameter1", id).list();
	}	
	
	public Responsable getResponsable(BigDecimal id) {
		return (Responsable) getSession().get(Responsable.class, id);
	}
	
	
	public void deleteResponsable(BigDecimal id) {

		Responsable responsable = getResponsable(id);
		if (null != responsable) {
			getSession().delete(responsable);
		}
	}

	public void deleteResponsables_by_EFAID(BigDecimal id) {
		//getSession().createQuery("delete from Responsable where IDEFA=:parameter1").setParameter("parameter1", id);
		String sql = "delete from Responsable where IDEFA=:parameter1";
		Query query = getSession().createQuery(sql).setParameter("parameter1", id);
		query.executeUpdate();
	}	
	
	public void setResponsable(BigDecimal id) {
		// TODO Auto-generated method stub
		String sql = "update Responsable set TIPO='2' where IDEFA=:parameter1";
		Query query = getSession().createQuery(sql).setParameter("parameter1", id);
		query.executeUpdate();		
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
