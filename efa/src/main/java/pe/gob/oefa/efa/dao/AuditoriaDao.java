package pe.gob.oefa.efa.dao;

import pe.gob.oefa.efa.model.Auditoria;

public interface AuditoriaDao {
	public void saveAuditoria(Auditoria auditoria); // create and update
	public int getIdTipoAccionId(String codaccion);
	public int getIdTablaReferencia(String codtable);
}
