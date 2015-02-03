package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaxxer.hikari.HikariDataSource;

import pe.gob.oefa.efa.dao.SupervisorDao;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.SupervisorService;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.ConnectionManagerVPN;
import pe.gob.oefa.efa.utils.LabelValue;

import pe.gob.oefa.efa.utils.ConstantAuditoria;


@Service
public class SupervisorServiceImpl implements SupervisorService {
	
	@Autowired
	private SupervisorDao supervisorDao;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void saveSupervisor(Supervisor supervisor, HttpSession session) {
		supervisorDao.saveSupervisor(supervisor);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				supervisor.getId() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervicion_Efa_Supervisor, supervisor.getId() != null ? supervisor.getId().toString() : "");
	}

	@Transactional(readOnly = true)
	public List<Supervisor> listSupervisores() {
		return supervisorDao.listSupervisores();
	}

	@Transactional(readOnly = true)
	public Supervisor getSupervisor(BigDecimal id) {
		return supervisorDao.getSupervisor(id);
	}
	@Transactional(readOnly = true)
	public List<SupervisorFile> listFiles_by_ID(BigDecimal id) {
		return supervisorDao.listFiles_by_ID(id);
	}	
	@Transactional(readOnly = true)
	public List<SupervisorEmergencia> listEmergencias_by_ID(BigDecimal id) {
		return supervisorDao.listEmergencias_by_ID(id);
	}		
	@Transactional
	public void deleteSupervisor(BigDecimal id, HttpSession session) {
		supervisorDao.deleteSupervisor(id);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Supervisor, id.toString());
	}
	
	@Transactional
	public Map<String, String> getDni(String dni){
		
		CallableStatement callableStatement = null;
		Connection connection = null;
		Map<String, String> selectItems =   new HashMap<String, String>();
		try {
			
//		connection = ConnectionManagerVPN.getConnection();	.
		connection = ConnectionManager.getConnection();	
		String getDBUSERByUserIdSql = "{CALL PADRONES.SP_GET_DATOS_X_DNI(?,?,?,?,?,?,?,?,?)}";
//		String getDBUSERByUserIdSql = "{CALL SP_GET_DATOS_X_DNI(?,?,?,?,?,?,?,?,?)}";
		callableStatement = connection.prepareCall(getDBUSERByUserIdSql);

		callableStatement.setString(1, dni);
		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);

		// execute store procedure
		callableStatement.executeUpdate();
	    
		
	    selectItems.put("APEPAT",callableStatement.getString(2));
	    selectItems.put("APEMAT",callableStatement.getString(3));
	    selectItems.put("NOMBRE",callableStatement.getString(4));
	    selectItems.put("CODSEX",callableStatement.getString(5));
	    selectItems.put("CODDEP",callableStatement.getString(6));
	    selectItems.put("CODPRO",callableStatement.getString(7));
	    selectItems.put("CODDIS",callableStatement.getString(8));
	    selectItems.put("RESULTADO",callableStatement.getString(9));
	

		} catch (SQLException e) { e.printStackTrace(); }		
		finally {
			try{
				if (callableStatement != null) {
					callableStatement.close();
				}
		
				if (connection != null) {
					connection.close();
				}
			}catch (SQLException e) { e.printStackTrace(); }

		}		
		
	    return selectItems;	

	}
}
