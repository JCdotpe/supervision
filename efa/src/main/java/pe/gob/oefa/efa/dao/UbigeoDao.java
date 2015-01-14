package pe.gob.oefa.efa.dao;

import java.util.List;

import pe.gob.oefa.efa.model.Departamento;
import pe.gob.oefa.efa.model.Distrito;
import pe.gob.oefa.efa.model.Provincia;
import pe.gob.oefa.efa.model.Ubigeo;


public interface UbigeoDao {

	public List<Ubigeo> listDep();
	public List<Ubigeo> listProv(Long depId);
	public List<Ubigeo> listDist(Long depId, Long provId);

	List<Departamento> obtenerDepartamentos();

	List<Provincia> obtenerProvincias(String ccdd);

	List<Distrito> obtenerDistritos(String ccdd, String ccpp);
}
