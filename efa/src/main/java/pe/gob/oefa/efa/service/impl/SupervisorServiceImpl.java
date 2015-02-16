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



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaxxer.hikari.HikariDataSource;

import pe.gob.oefa.efa.dao.SupervisorDao;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.service.SupervisorService;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.LabelValue;

@Service
public class SupervisorServiceImpl implements SupervisorService {
	
	@Autowired
	private SupervisorDao supervisorDao;
	
	@Transactional
	public void saveSupervisor(Supervisor supervisor) {
		supervisorDao.saveSupervisor(supervisor);
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
	public void deleteSupervisor(BigDecimal id) {
		supervisorDao.deleteSupervisor(id);
	}
	
	@Transactional
	public Map<String, String> getDni(String dni){
		
		CallableStatement callableStatement = null;
		Connection connection = null;
		Map<String, String> selectItems =   new HashMap<String, String>();
		try {
			
		connection = ConnectionManager.getConnection();	
		String getDBUSERByUserIdSql = "{CALL PADRONES.SP_GET_DATOS_X_DNI(?,?,?,?,?,?,?,?,?,?)}";
//		String getDBUSERByUserIdSql = "{CALL SP_GET_DATOS_X_DNI(?,?,?,?,?,?,?,?,?,?)}";
		callableStatement = connection.prepareCall(getDBUSERByUserIdSql);

		callableStatement.setString(1, dni);
		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);		

		// execute store procedure
		callableStatement.executeUpdate();
	    
		
	    selectItems.put("APEPAT",callableStatement.getString(2));
	    selectItems.put("APEMAT",callableStatement.getString(3));
	    selectItems.put("NOMBRE",callableStatement.getString(4));
	    selectItems.put("FECNAC",callableStatement.getString(5));
	    
	    selectItems.put("CODSEX",callableStatement.getString(6));	    
	    selectItems.put("CODDEP",callableStatement.getString(7));
	    selectItems.put("CODPRO",callableStatement.getString(8));
	    selectItems.put("CODDIS",callableStatement.getString(9));
	    selectItems.put("RESULTADO",callableStatement.getString(10));
	

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
