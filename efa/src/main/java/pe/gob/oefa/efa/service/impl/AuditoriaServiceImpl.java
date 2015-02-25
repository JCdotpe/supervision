
package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.AuditoriaDao;
import pe.gob.oefa.efa.model.Auditoria;
import pe.gob.oefa.efa.service.AuditoriaService;

@Service
public class AuditoriaServiceImpl implements AuditoriaService{

	
    @Autowired
    private AuditoriaDao auditoriaDao;
 
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy"); 
	SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss"); 
	Date currentDate = new Date();

	@Transactional
	public void saveAuditoria(String username, String codaccion, String codtable, String idreferencia) 
	{	
		try 
		{
			int idtipoaccion = auditoriaDao.getIdTipoAccionId(codaccion);
			int idtablareferencia = auditoriaDao.getIdTablaReferencia(codtable);
			
			Auditoria obj = new Auditoria();
			obj.setIdTablaReferencia(new BigDecimal(idtablareferencia));
			obj.setIdTipoAccion(new BigDecimal(idtipoaccion));	
			obj.setIdReferencia(idreferencia);	
			obj.setFecha(new Date());
			obj.setUserName(username);	
			obj.setHostName(InetAddress.getLocalHost().getHostName().toString());
			obj.setIp(InetAddress.getLocalHost().getHostAddress());
			obj.setHora(formatTime.format(new Date()));
			//MIGUEL
			auditoriaDao.saveAuditoria(obj);
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		}	
	}
}
