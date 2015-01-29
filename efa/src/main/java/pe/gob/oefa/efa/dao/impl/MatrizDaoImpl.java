package pe.gob.oefa.efa.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.oefa.efa.dao.MatrizDao;
import pe.gob.oefa.efa.model.ArchivoFunciones;
import pe.gob.oefa.efa.model.ComponenteMatriz;
import pe.gob.oefa.efa.model.FuncionesComponente;
import pe.gob.oefa.efa.model.IndicadoresFuncion;
import pe.gob.oefa.efa.model.Matriz;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.model.MatrizActividadFuncion;
import pe.gob.oefa.efa.model.MatrizActividadIndicador;

@Repository
public class MatrizDaoImpl implements MatrizDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<MatrizActividad> listByActividad(BigDecimal codActividad) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from MatrizActividad where IDACTIVIDAD=:parameter1 and ESTADOMATRIZACTIVIDAD = '1' or IDACTIVIDAD=:parameter1 and ESTADOMATRIZACTIVIDAD = '2'")
				.setParameter("parameter1", codActividad).list();
		
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

	public Matriz getMatriz(int idmatriz) {
		// TODO Auto-generated method stub
		return (Matriz) getSession().get(Matriz.class, idmatriz);
	}

	public MatrizActividad getMatrizAct(int idmatrizact) {
		// TODO Auto-generated method stub
		BigDecimal id = new BigDecimal(idmatrizact);
		return (MatrizActividad) getSession().get(MatrizActividad.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ComponenteMatriz> getComponente(int idmatriz) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from ComponenteMatriz where IDMATRIZ=:parameter1")
				.setParameter("parameter1", idmatriz).list();
	}

	@SuppressWarnings("unchecked")
	public List<FuncionesComponente> getFunciones(int idcomponente) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from FuncionesComponente where IDCOMPONENTE=:parameter1")
				.setParameter("parameter1", idcomponente).list();
	}

	@SuppressWarnings("unchecked")
	public List<IndicadoresFuncion> getIndicadores(int idfuncion) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from IndicadoresFuncion where IDFUNCION=:parameter1")
				.setParameter("parameter1", idfuncion).list();
	}

	@SuppressWarnings("unchecked")
	public List<MatrizActividad> getMatrizActividad(int codActividad, int codMatriz) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from MatrizActividad where IDACTIVIDAD=:parameter1 and IDMATRIZ =:parameter2")
				.setParameter("parameter1", codActividad).setParameter("parameter2", codMatriz).list();
	}

	public void addMatrizActividadFuncion(MatrizActividadFuncion maf) {
		getSession().merge(maf);
	}

	@SuppressWarnings("unchecked")
	public List<MatrizActividadFuncion> getListMatrizFuncion(
			int idmatrizactividad, int idfuncion) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from MatrizActividadFuncion where IDMATRIZACTIVIDAD=:parameter1 and IDFUNCION =:parameter2")
				.setParameter("parameter1", idmatrizactividad).setParameter("parameter2", idfuncion).list();
	}

	public void addArchiveFuncion(ArchivoFunciones af) {
		// TODO Auto-generated method stub
		getSession().merge(af);
	}

	@SuppressWarnings("unchecked")
	public List<ArchivoFunciones> listArchives(int idmatrizactividadfunciones) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from ArchivoFunciones where IDMATRIZACTIVIDADFUNCIONES=:parameter1")
				.setParameter("parameter1", idmatrizactividadfunciones).list();
	}

	public void addMatrizactividadindicador(MatrizActividadIndicador mai) {
		// TODO Auto-generated method stub
		getSession().merge(mai);
	}

	public void saveMatrizActividadFuncion(MatrizActividadFuncion ma) {
		// TODO Auto-generated method stub
		getSession().update(ma);
	}

	@SuppressWarnings("unchecked")
	public List<MatrizActividadFuncion> getListMatrizFuncionByIdMa(
			BigDecimal idmatrizactividad, String estado) {
		// TODO Auto-generated method stub
		if (estado == "-1") {
			return getSession().createQuery("from MatrizActividadFuncion where IDMATRIZACTIVIDAD=:parameter1")
					.setParameter("parameter1", idmatrizactividad).list();
		}
		else{
			return getSession().createQuery("from MatrizActividadFuncion where IDMATRIZACTIVIDAD=:parameter1 and ESTADOMATRIZACTIVIDADFUNCIONES=:parameter2 ")
					.setParameter("parameter1", idmatrizactividad).setParameter("parameter2", estado).list();
		}
	}

	@SuppressWarnings("unchecked")
	public List<MatrizActividad> getbyMatrizActividad(int codActividad,
			int codMatriz) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from MatrizActividad where IDACTIVIDAD=:parameter1 and IDMATRIZ = :parameter2")
				.setParameter("parameter1", codActividad).setParameter("parameter2", codMatriz).list();
	}

	public void updateMatrizActividad(MatrizActividad ma) {
		// TODO Auto-generated method stub
		getSession().update(ma);
		
	}

	@SuppressWarnings("unchecked")
	public List<MatrizActividadIndicador> getIndicadoresActividad(
			int idmatrizactividadfunciones) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from MatrizActividadIndicador where IDMATRIZACTIVIDADFUNCIONES=:parameter1")
				.setParameter("parameter1", idmatrizactividadfunciones).list();
	}

	public ArchivoFunciones getArchive(int idArchive){
		return (ArchivoFunciones) getSession().get(ArchivoFunciones.class, idArchive);
	}
	
	public void deleteArchive(int idArchive) {
		// TODO Auto-generated method stub
		ArchivoFunciones archive = getArchive(idArchive);
		if (archive != null) {
			getSession().delete(archive);
		}
	}


}
