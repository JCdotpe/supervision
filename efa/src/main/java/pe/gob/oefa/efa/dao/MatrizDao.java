package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.ArchivoFunciones;
import pe.gob.oefa.efa.model.ComponenteMatriz;
import pe.gob.oefa.efa.model.FuncionesComponente;
import pe.gob.oefa.efa.model.IndicadoresFuncion;
import pe.gob.oefa.efa.model.Matriz;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.model.MatrizActividadFuncion;
import pe.gob.oefa.efa.model.MatrizActividadIndicador;

public interface MatrizDao {

	public List<MatrizActividad> listByActividad(BigDecimal codActividad);

	public Matriz getMatriz(int idmatriz);
	
	public MatrizActividad getMatrizAct(int idmatrizact);

	public List<ComponenteMatriz> getComponente(int idmatriz);

	public List<FuncionesComponente> getFunciones(int idcomponente);

	public List<IndicadoresFuncion> getIndicadores(int idfuncion);

	public List<MatrizActividad> getMatrizActividad(int codActividad, int codMatriz);

	public void addMatrizActividadFuncion(MatrizActividadFuncion maf);

	public List<MatrizActividadFuncion> getListMatrizFuncion(
			int idmatrizactividad, int idfuncion);

	public void addArchiveFuncion(ArchivoFunciones af);

	public List<ArchivoFunciones> listArchives(int idmatrizactividadfunciones);

	public void addMatrizactividadindicador(MatrizActividadIndicador mai);

	public void saveMatrizActividadFuncion(MatrizActividadFuncion ma);

	public List<MatrizActividadFuncion> getListMatrizFuncionByIdMa(
			BigDecimal idmatrizactividad, String estado);

	public List<MatrizActividad> getbyMatrizActividad(int codActividad,
			int codMatriz);

	public void updateMatrizActividad(MatrizActividad ma);

	public List<MatrizActividadIndicador> getIndicadoresActividad(
			int idmatrizactividadfunciones);

	public void deleteArchive(int idArchive);


	
}
