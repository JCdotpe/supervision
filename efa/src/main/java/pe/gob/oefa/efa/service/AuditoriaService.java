package pe.gob.oefa.efa.service;

import pe.gob.oefa.efa.model.Auditoria;

public interface AuditoriaService {
	public void saveAuditoria(String username,String codaccion, String codtable, String idreferencia);
}
