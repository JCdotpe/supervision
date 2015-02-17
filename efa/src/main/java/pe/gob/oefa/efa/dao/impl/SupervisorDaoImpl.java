package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.SupervisorDao;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;

@Repository
public class SupervisorDaoImpl implements SupervisorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveSupervisor(Supervisor supervisor) {
		getSession().merge(supervisor);

	}

	@SuppressWarnings("unchecked")
	public List<Supervisor> listSupervisores() {

		//return getSession().createCriteria(Supervisor.class).list();
		return getSession().createQuery("from Supervisor where flgactivo='1'").list();
	}

	public Supervisor getSupervisor(BigDecimal id) {
		return (Supervisor) getSession().get(Supervisor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<SupervisorFile> listFiles_by_ID(BigDecimal id) {

		return getSession().createQuery("from SupervisorFile where IDSUPERVISOR=:parameter1").setParameter("parameter1", id).list();
	}		

	@SuppressWarnings("unchecked")
	public List<SupervisorEmergencia> listEmergencias_by_ID(BigDecimal id) {

		return getSession().createQuery("from SupervisorEmergencia where IDSUPERVISOR=:parameter1").setParameter("parameter1", id).list();
	}		
	
	public void deleteSupervisor(BigDecimal id) {

		Supervisor supervisor = getSupervisor(id);

		if (null != supervisor) {
			supervisor.setFlgactivo("0");
			getSession().update(supervisor);
			//getSession().delete(supervisor);
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
