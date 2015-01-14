package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.PadronDao;
import pe.gob.oefa.efa.model.Padron;

@Repository
public class PadronDaoImpl implements PadronDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void savePadron(Padron padron) {
		getSession().merge(padron);

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
