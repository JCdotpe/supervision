package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.utils.LabelValue;


public interface UtilService {

	/*
	 * READ
	 */
	public List<LabelValue> listTipos_contacto();
	public List<LabelValue> listNiveles_efa();
	public List<LabelValue> listEstadoCivil();
	public List<LabelValue> listMcontrato();
	public List<LabelValue> listBanco();
	public List<LabelValue> listCargos();
	public List<LabelValue> listSexo();
	public List<LabelValue> listTipoActividad();
	public List<LabelValue> listSector_contacto();
	public List<LabelValue> listSupfiles();
	public List<LabelValue> listEstadoActividad();
	public List<LabelValue> listEstadoMatriz();
	public List<LabelValue> listEstadoEjecucion();
	public List<LabelValue> listTipos_Persona();
	public List<LabelValue> listTipos_Documento();
	public List<LabelValue> listZonaGeografica();
    public String createNewFileName(String fileName);
    public List<LabelValue> listUMSector();
    public List<LabelValue> listUMAct(String secId);
    public List<LabelValue> listUMCat(String secId, String actId);    
    public List<LabelValue> listTipos_DerechoM();
    public List<LabelValue> listUM_estado();
    public List<LabelValue> listUM_cuenca();
    public List<LabelValue> listTipos_ejecfile();
}
