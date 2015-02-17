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
import pe.gob.oefa.efa.dao.AdministradoDao;
import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.Administrado;
//import pe.gob.oefa.efa.model.ActividadResponsable;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.NamedParameterStatement;


@Repository
public class AdministradoDaoImpl implements AdministradoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveAdministrado(Administrado administrado) {
		getSession().merge(administrado);

	}

	@SuppressWarnings("unchecked")
	public List<Administrado> listAdministrados() {
		return getSession().createQuery("from Administrado where flgactivo='1'").list();
//		return getSession().createCriteria(Actividad.class).list();
	}

	public Administrado getAdministrado(BigDecimal id) {
		return (Administrado) getSession().get(Administrado.class, id);
	}
	
	
	public void deleteAdministrado(BigDecimal id) {

		Administrado administrado = getAdministrado(id);

		if (null != administrado) {
			administrado.setFlgactivo("0");
			getSession().update(administrado);
			//getSession().delete(administrado);
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
