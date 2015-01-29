package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.SupervisorFileDao;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.SupervisorFile;

@Repository
public class SupervisorFileDaoImpl implements SupervisorFileDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveSupervisorFile(SupervisorFile supervisorFile) {
		getSession().merge(supervisorFile);

	}

	@SuppressWarnings("unchecked")
	public List<SupervisorFile> listSupervisorFile() {

		return getSession().createCriteria(SupervisorFile.class).list();
	}

	public SupervisorFile getSupervisorFile(BigDecimal id) {
		return (SupervisorFile) getSession().get(SupervisorFile.class, id);
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}
	
	public void deleteSupervisorFile(BigDecimal id) {
		SupervisorFile supervisorFile = getSupervisorFile(id);

		if (null != supervisorFile) {
			getSession().delete(supervisorFile);
		}
		
	}
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
