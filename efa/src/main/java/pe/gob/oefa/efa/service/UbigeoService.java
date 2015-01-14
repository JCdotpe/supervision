package pe.gob.oefa.efa.service;

import java.util.List;

import pe.gob.oefa.efa.model.Departamento;
import pe.gob.oefa.efa.model.Distrito;
import pe.gob.oefa.efa.model.Provincia;
import pe.gob.oefa.efa.model.Ubigeo;
import pe.gob.oefa.efa.utils.LabelValue;



public interface UbigeoService {

	/*
	 * READ
	 */
	public List<LabelValue> listDep();
	public List<LabelValue> listProv(String depId);
	public List<LabelValue> listDist(String depId, String provId);

	List<Departamento> obtenerDepartamentos();

	List<Provincia> obtenerProvincias(String ccdd);

	List<Distrito> obtenerDistritos(String ccdd, String ccpp);
}
