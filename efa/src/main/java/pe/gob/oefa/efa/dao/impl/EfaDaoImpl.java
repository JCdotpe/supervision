package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;




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

	public void saveEfa(Efa efa) {
		
		try {
			/*Auditoria auditoria = new Auditoria();
			auditoria.setidAuditoria(new BigDecimal(1));
			auditoria.setDescripcion("dd");
			
			BigDecimal asd = auditoria.getidAuditoria();
			String asds = auditoria.getdescripcion();
			
			getSession().merge(auditoria)*/
			getSession().merge(efa);
			
			
			 /*getSession().createQuery("INSERT INTO AUDITORIA VALUES (parameter1,parameter2)").list();
					.setParameter("parameter1", 3)
					.setParameter("parameter2", "DEMO 3");*/
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@SuppressWarnings("unchecked")
	public List<Efa> listEfas() {

		//return getSession().createCriteria(Efa.class).list();
		return getSession().createQuery("from Efa where flgactivo='1'").list();
	}

	public Efa getEfa(BigDecimal id) {
		return (Efa) getSession().get(Efa.class, id);
	}
	
	
	public void deleteEfa(BigDecimal id) {

		Efa efa = getEfa(id);

		if (null != efa) {
			efa.setFlgactivo("0");
			getSession().update(efa);
			//getSession().delete(efa);
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
