package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;






import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.node.DecimalNode;

import pe.gob.oefa.efa.dao.EfaDao;
import pe.gob.oefa.efa.model.Auditoria;
import pe.gob.oefa.efa.model.Efa;

@Repository
public class EfaDaoImpl implements EfaDao {

	@Autowired
	private SessionFactory sessionFactory;

	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy"); 
	SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm"); 
	Date currentDate = new Date(0);
	
	public void saveEfa(Efa efa) {
		    getSession().merge(efa);
	}

	public int saveEfaPrueba(Efa efa) {
	    return (Integer)getSession().merge(efa);
	}
	
	@SuppressWarnings("unchecked")
	public List<Efa> listEfas() {
		return getSession().createCriteria(Efa.class).list();
	}

	public Efa getEfa(BigDecimal id) {
		return (Efa) getSession().get(Efa.class, id);
	}
	
	
	public void deleteEfa(BigDecimal id) {

		Efa efa = getEfa(id);

		if (null != efa) {
			getSession().delete(efa);
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Efa> listEfas_by_NIVEL(String coddep, String codprov, String coddist, String nivel) {
		return getSession().createQuery("from Efa where DEPARTAMENTO=:parameter1 and PROVINCIA=:parameter2 and DISTRITO=:parameter3 and NIVEL=:parameter4").setParameter("parameter1", coddep).setParameter("parameter2", codprov).setParameter("parameter3", coddist).setParameter("parameter4", nivel).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Efa> listEfas_by_NIVELDEP(String coddep, String nivel) {
		return getSession().createQuery("from Efa where DEPARTAMENTO=:parameter1 and NIVEL=:parameter2").setParameter("parameter1", coddep).setParameter("parameter2", nivel).list();
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
