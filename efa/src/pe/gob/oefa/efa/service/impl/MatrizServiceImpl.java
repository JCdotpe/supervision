package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
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

import pe.gob.oefa.efa.dao.MatrizDao;
import pe.gob.oefa.efa.model.ArchivoFunciones;
import pe.gob.oefa.efa.model.ComponenteMatriz;
import pe.gob.oefa.efa.model.FuncionesComponente;
import pe.gob.oefa.efa.model.IndicadoresFuncion;
import pe.gob.oefa.efa.model.Matriz;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.model.MatrizActividadFuncion;
import pe.gob.oefa.efa.model.MatrizActividadIndicador;
import pe.gob.oefa.efa.service.MatrizService;
import pe.gob.oefa.efa.utils.ConnectionManagerVPN;
import pe.gob.oefa.efa.utils.LabelValue;

@Service
public class MatrizServiceImpl implements MatrizService{
	
	@Autowired
	private MatrizDao matrizdao;
	
	@Transactional(readOnly=true) 
	public List<LabelValue> listMatrices(int codNivel) {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    try{
	    	connection = ConnectionManagerVPN.getConnection();
		    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_MATRICES(?,?); END;");
		    stmt.setInt(1, codNivel); 
		    stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
		    stmt.execute();
		    rs = ((OracleCallableStatement)stmt).getCursor(2);
		    while (rs.next()) {
		    	selectItems.add(new LabelValue(rs.getString("CODIGO"),rs.getString("NOMBRE")));
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
	
	@Transactional
	public List<MatrizActividad> listByActividad(BigDecimal codActividad) {
		// TODO Auto-generated method stub
		return matrizdao.listByActividad(codActividad);
	}
	
	@Transactional
	public Matriz getMatriz(int idmatriz) {
		// TODO Auto-generated method stub
		return matrizdao.getMatriz(idmatriz);
	}

	@Transactional
	public List<ComponenteMatriz> getComponente(int idmatriz) {
		// TODO Auto-generated method stub
		return matrizdao.getComponente(idmatriz);
	}

	@Transactional
	public List<FuncionesComponente> getFunciones(int idcomponente) {
		// TODO Auto-generated method stub
		return matrizdao.getFunciones(idcomponente);
	}
	
	@Transactional
	public List<IndicadoresFuncion> getIndicadores(int idfuncion) {
		// TODO Auto-generated method stub
		return matrizdao.getIndicadores(idfuncion);
	}
	
	@Transactional
	public List<MatrizActividad> getMatrizActividad(int codActividad, int codMatriz) {
		// TODO Auto-generated method stub
		return matrizdao.getMatrizActividad(codActividad, codMatriz);
	}

	@Transactional
	public void addMatrizActividadFuncion(MatrizActividadFuncion maf) {
		// TODO Auto-generated method stub
		matrizdao.addMatrizActividadFuncion(maf);
	}

	@Transactional
	public List<MatrizActividadFuncion> getListMatrizFuncion(
			int idmatrizactividad, int idfuncion) {
		// TODO Auto-generated method stub
		return matrizdao.getListMatrizFuncion(idmatrizactividad, idfuncion);
	}

	@Transactional
	public void addArchiveFuncion(ArchivoFunciones af) {
		// TODO Auto-generated method stub
		matrizdao.addArchiveFuncion(af);
	}

	@Transactional
	public List<ArchivoFunciones> listArchives(int idmatrizactividadfunciones) {
		// TODO Auto-generated method stub
		return  matrizdao.listArchives(idmatrizactividadfunciones);
	}
	@Transactional
	public void addMatrizactividadindicador(MatrizActividadIndicador mai) {
		// TODO Auto-generated method stub
		matrizdao.addMatrizactividadindicador(mai);
	}

	@Transactional
	public void saveMatrizActividadFuncion(MatrizActividadFuncion ma) {
		// TODO Auto-generated method stub
		matrizdao.saveMatrizActividadFuncion(ma);
	}

	@Transactional
	public MatrizActividad getMatrizAct(int idmatrizact) {
		// TODO Auto-generated method stub
		return matrizdao.getMatrizAct(idmatrizact);
	}

	@Transactional
	public List<MatrizActividadFuncion> getListMatrizFuncionByIdMa(
			BigDecimal idmatrizactividad, String estado) {
		// TODO Auto-generated method stub
		return matrizdao.getListMatrizFuncionByIdMa(idmatrizactividad, estado);
	}

	@Transactional
	public List<MatrizActividad> getbyMatrizActividad(int codActividad,
			int codMatriz) {
		// TODO Auto-generated method stub
		return matrizdao.getbyMatrizActividad(codActividad, codMatriz);
	}
	
	@Transactional
	public void updateMatrizActividad(MatrizActividad ma) {
		// TODO Auto-generated method stub
		matrizdao.updateMatrizActividad(ma);
	}
	
	@Transactional
	public List<MatrizActividadIndicador> getIndicadoresActividad(
			int idmatrizactividadfunciones) {
		// TODO Auto-generated method stub
		return matrizdao.getIndicadoresActividad(idmatrizactividadfunciones);
	}

	@Transactional
	public void deleteArchive(int idArchive) {
		// TODO Auto-generated method stub
		matrizdao.deleteArchive(idArchive);
	}


}