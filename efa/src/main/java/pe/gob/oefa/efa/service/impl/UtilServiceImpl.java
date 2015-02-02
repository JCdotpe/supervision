package pe.gob.oefa.efa.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.ConnectionManagerVPN;
import pe.gob.oefa.efa.utils.LabelValue;

@Service
public class UtilServiceImpl implements UtilService {

	@Transactional(readOnly=true) 
	public List<LabelValue> listTipos_contacto() {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		selectItems.add(new LabelValue("Responsable del PLANEFA","1"));
		selectItems.add(new LabelValue("Otro","2"));
		return selectItems;
	}

	@Transactional(readOnly=true) 
	public List<LabelValue> listSector_contacto() {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		selectItems.add(new LabelValue("MINERÍA","1"));
		selectItems.add(new LabelValue("ELECTRICIDAD","2"));
		selectItems.add(new LabelValue("HIDROCARBUROS","3"));
		selectItems.add(new LabelValue("PESQUERÍA","4"));
		selectItems.add(new LabelValue("INDUSTRIA","5"));
		return selectItems;
	}	
	
	
	@Transactional(readOnly=true) 
	public List<LabelValue> listNiveles_efa() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Local","1"));
	    selectItems.add(new LabelValue("Regional","2"));
	    selectItems.add(new LabelValue("Nacional","3"));
	    return selectItems;
	}
	@Transactional(readOnly=true) 
	public List<LabelValue> listEstadoCivil() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Soltero","1"));
	    selectItems.add(new LabelValue("Casado","2"));
	    selectItems.add(new LabelValue("Viudo","3"));
	    selectItems.add(new LabelValue("Divorciado","4"));
	    return selectItems;
	}
	@Transactional(readOnly=true) 
	public List<LabelValue> listMcontrato() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("CAS","1"));
	    selectItems.add(new LabelValue("Tercero","2"));
	    return selectItems;
	}
	@Transactional(readOnly=true) 
	public List<LabelValue> listBanco() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Si","1"));
	    selectItems.add(new LabelValue("No","2"));
	    return selectItems;
	}	
	@Transactional(readOnly=true) 
	public List<LabelValue> listCargos() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Administrador","1"));
	    selectItems.add(new LabelValue("Supervisor","2"));
	    selectItems.add(new LabelValue("Otro","3"));
	    return selectItems;
	}	
	@Transactional(readOnly=true) 
	public List<LabelValue> listSexo() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("MASCULINO","1"));
	    selectItems.add(new LabelValue("FEMENINO","2"));
	    return selectItems;
	}		
	
	@Transactional(readOnly=true) 
	public List<LabelValue> listTipoActividad() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Regular","1"));
	    selectItems.add(new LabelValue("Especial","2"));
	    return selectItems;
	}		
	
    public String createNewFileName(String fileName) {
        // Create a timestamp string, to add before the file extension
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timestampString = formatter.format(now);
 
        // Find the last '.', just before the file type extension, and insert
        // the timestamp before it
        int lastIndex = fileName.lastIndexOf(".");
        return fileName.substring(0, lastIndex) + "_" + timestampString + "."
                + fileName.substring(lastIndex + 1, fileName.length());
    }

	public List<LabelValue> listSupfiles() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("DNI","1"));
	    selectItems.add(new LabelValue("CONTRATO","2"));
	    selectItems.add(new LabelValue("FOTO","3"));
	    return selectItems;
	}

	public List<LabelValue> listEstadoActividad() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Programada","1"));
	    selectItems.add(new LabelValue("Ejecutada","2"));
	    selectItems.add(new LabelValue("Terminada","3"));
	    return selectItems;
	}

	public List<LabelValue> listEstadoMatriz() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Si","1"));
	    selectItems.add(new LabelValue("No","2"));
	    return selectItems;
	}

	public List<LabelValue> listEstadoEjecucion() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("En revisión","1"));
	    selectItems.add(new LabelValue("Observado","2"));
	    selectItems.add(new LabelValue("Cerrado","3"));
	    return selectItems;
	}	
	public List<LabelValue> listTipos_Persona() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Natural","1"));
	    selectItems.add(new LabelValue("Jurídica","2"));
	    return selectItems;
	}
	public List<LabelValue> listTipos_Documento() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("DNI","1"));
	    selectItems.add(new LabelValue("CARNET EXTRANJERIA","2"));
	    return selectItems;
	}

	public List<LabelValue> listZonaGeografica() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("17","17"));
	    selectItems.add(new LabelValue("18","18"));
	    selectItems.add(new LabelValue("19","19"));
	    return selectItems;
	}
	
	@Transactional(readOnly = true)
	public List<LabelValue> listUMSector() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    try{
	    	connection = ConnectionManager.getConnection();
	    	Statement stmt = connection.createStatement();

            rs = stmt.executeQuery("SELECT * FROM TUMSECTOR");
		    while (rs.next()) {
		    	selectItems.add(new LabelValue(rs.getString("DES"),rs.getString("IDUMSECTOR")));
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
	public List<LabelValue> listUMAct(String secId) {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    Connection connection = null;
	    ResultSet rs = null;
	    PreparedStatement pstatement = null;
	    try{
	    	connection = ConnectionManager.getConnection();
	    	String queryString = "SELECT * FROM TUMACTIVIDAD WHERE IDUMSECTOR=?";
	    	pstatement = connection.prepareStatement(queryString);
	    	 pstatement.setString(1, secId);
	    	 rs = pstatement.executeQuery();
		    while (rs.next()) {
		    	selectItems.add(new LabelValue(rs.getString("DES"),rs.getString("IDUMACTIVIDAD")));
	        }	
		    
	    }catch (SQLException e) { e.printStackTrace(); }		
		finally {
			try{
				if (pstatement != null) {
					pstatement.close();
				}
		
				if (connection != null) {
					connection.close();
				}
			}catch (SQLException e) { e.printStackTrace(); }

		}		    
	    
		return selectItems;		
	}

	@Transactional(readOnly=true) 
	public List<LabelValue> listUMCat(String secId, String actId) {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    Connection connection = null;
	    ResultSet rs = null;
	    PreparedStatement pstatement = null;
	    try{
	    	connection = ConnectionManager.getConnection();
	    	String queryString = "SELECT * FROM TUMCATEGORIA WHERE IDUMSECTOR=? and IDUMACTIVIDAD=?";
	    	pstatement = connection.prepareStatement(queryString);
	    	 pstatement.setString(1, secId);
	    	 pstatement.setString(2, actId);
	    	 rs = pstatement.executeQuery();
		    while (rs.next()) {
		    	selectItems.add(new LabelValue(rs.getString("DES"),rs.getString("IDUMCATEGORIA")));
	        }	  	  
		    
	    }catch (SQLException e) { e.printStackTrace(); }		
		finally {
			try{
				if (pstatement != null) {
					pstatement.close();
				}
		
				if (connection != null) {
					connection.close();
				}
			}catch (SQLException e) { e.printStackTrace(); }

		}		    

		return selectItems;			
	}

	public List<LabelValue> listTipos_DerechoM() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Concesión Minera","1"));
	    selectItems.add(new LabelValue("U.E.A.","2"));
	    selectItems.add(new LabelValue("Otro derecho minero","3"));
	    selectItems.add(new LabelValue("Fuera de un derecho minero","4"));
	    return selectItems;
	}	
	
	public List<LabelValue> listUM_estado() {
	    List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    selectItems.add(new LabelValue("Activo","1"));
	    selectItems.add(new LabelValue("Inactivo","0"));
	    return selectItems;
	}
	@Transactional(readOnly = true)
	public List<LabelValue> listUM_cuenca() {
		
		    List<LabelValue> selectItems = new ArrayList<LabelValue>();
		    
		    CallableStatement callableStatement = null;
		    Connection connection = null;
		    ResultSet rs = null;
		    try{
		    	connection = ConnectionManagerVPN.getConnection();
			    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_CUENCA(?); END;");
			    stmt.registerOutParameter(1, OracleTypes.CURSOR); //REF CURSOR
			    stmt.execute();
			    rs = ((OracleCallableStatement)stmt).getCursor(1);
			    while (rs.next()) {
			    	selectItems.add(new LabelValue(rs.getString("TXCUENCA"),rs.getString("IDCUENCA")));
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

	public List<LabelValue> listTipos_ejecfile() {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		selectItems.add(new LabelValue("Informe de Supervisión","1"));
		selectItems.add(new LabelValue("Acta de Supervisión","2"));
		selectItems.add(new LabelValue("Matriz de Supervisión","3"));
		selectItems.add(new LabelValue("Informe-Denuncia","4"));
		return selectItems;
	}
	
}
