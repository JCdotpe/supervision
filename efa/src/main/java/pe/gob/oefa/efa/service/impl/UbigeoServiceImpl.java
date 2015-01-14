package pe.gob.oefa.efa.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.UbigeoDao;
import pe.gob.oefa.efa.model.Departamento;
import pe.gob.oefa.efa.model.Distrito;
import pe.gob.oefa.efa.model.Provincia;
import pe.gob.oefa.efa.model.Ubigeo;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.ConnectionManagerVPN;
import pe.gob.oefa.efa.utils.LabelValue;

@Service
public class UbigeoServiceImpl implements UbigeoService {

	@Autowired
	private UbigeoDao ubigeoDao;

	@Transactional(readOnly = true)
	public List<LabelValue> listDep() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    try{
	    	connection = ConnectionManagerVPN.getConnection();
		    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_DEPARTAMENTO(?); END;");
		    stmt.registerOutParameter(1, OracleTypes.CURSOR); //REF CURSOR
		    stmt.execute();
		    rs = ((OracleCallableStatement)stmt).getCursor(1);
		    while (rs.next()) {
		    	selectItems.add(new LabelValue(rs.getString("NOM_DEPARTAMENTO"),rs.getString("ID_DEPARTAMENTO")));
	        }		  
		    
	    }catch (SQLException e) { e.printStackTrace(); }		
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

	@Transactional(readOnly=true) 
	public List<LabelValue> listProv(String depId) {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    try{
	    	connection = ConnectionManagerVPN.getConnection();
		    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_PROVINCIA(?,?); END;");
		    stmt.setString(1, depId); 
		    stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
		    stmt.execute();
		    rs = ((OracleCallableStatement)stmt).getCursor(2);
		    while (rs.next()) {
		    	selectItems.add(new LabelValue(rs.getString("NOM_PROVINCIA"),rs.getString("ID_PROVINCIA")));
	        }		  
		    
	    }catch (SQLException e) { e.printStackTrace(); }		
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

	@Transactional(readOnly=true) 
	public List<LabelValue> listDist(String depId, String provId) {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    try{
	    	connection = ConnectionManagerVPN.getConnection();
		    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_DISTRITO(?,?,?); END;");
		    stmt.setString(1, depId); 
		    stmt.setString(2, provId); 
		    stmt.registerOutParameter(3, OracleTypes.CURSOR); //REF CURSOR
		    stmt.execute();
		    rs = ((OracleCallableStatement)stmt).getCursor(3);
		    while (rs.next()) {
		    	selectItems.add(new LabelValue(rs.getString("NOM_DISTRITO"),rs.getString("ID_DISTRITO")));
	        }		  
		    
	    }catch (SQLException e) { e.printStackTrace(); }		
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

	public List<Departamento> obtenerDepartamentos() {
		return ubigeoDao.obtenerDepartamentos();
	}

	public List<Provincia> obtenerProvincias(String ccdd) {
		return ubigeoDao.obtenerProvincias(ccdd);
	}

	public List<Distrito> obtenerDistritos(String ccdd, String ccpp) {
		return ubigeoDao.obtenerDistritos(ccdd, ccpp);
	}
}
