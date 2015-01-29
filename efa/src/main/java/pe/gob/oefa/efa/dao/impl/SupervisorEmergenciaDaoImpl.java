package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.SupervisorEmergenciaDao;
import pe.gob.oefa.efa.model.SupervisorEmergencia;

@Repository
public class SupervisorEmergenciaDaoImpl implements SupervisorEmergenciaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveSupervisorEmergencia(SupervisorEmergencia supervisorEmergencia) {
		getSession().merge(supervisorEmergencia);

	}

	@SuppressWarnings("unchecked")
	public List<SupervisorEmergencia> listSupervisorEmergencia() {

		return getSession().createCriteria(SupervisorEmergencia.class).list();
	}

	public SupervisorEmergencia getSupervisorEmergencia(BigDecimal id) {
		return (SupervisorEmergencia) getSession().get(SupervisorEmergencia.class, id);
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}
	
	public void deleteSupervisorEmergencia(BigDecimal id) {
		SupervisorEmergencia supervisorEmergencia = getSupervisorEmergencia(id);

		if (null != supervisorEmergencia) {
			getSession().delete(supervisorEmergencia);
		}
		
	}
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
