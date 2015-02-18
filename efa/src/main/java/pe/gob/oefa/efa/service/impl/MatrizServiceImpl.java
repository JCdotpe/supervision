package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import org.apache.commons.beanutils.converters.BigDecimalConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.MatrizDao;
import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.ArchivoFunciones;
import pe.gob.oefa.efa.model.ComponenteMatriz;
import pe.gob.oefa.efa.model.FuncionesComponente;
import pe.gob.oefa.efa.model.IndicadoresFuncion;
import pe.gob.oefa.efa.model.Matriz;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.model.MatrizActividadComponente;
import pe.gob.oefa.efa.model.MatrizActividadFuncion;
import pe.gob.oefa.efa.model.MatrizActividadIndicador;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.MatrizService;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.ConstantAuditoria;
import pe.gob.oefa.efa.utils.LabelValue;

@Service
public class MatrizServiceImpl implements MatrizService{
	
	@Autowired
	private MatrizDao matrizdao;
	
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional(readOnly=true) 
	public List<LabelValue> listMatrices(int codNivel, BigDecimal idEfa) {
		
		
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    
	    CallableStatement callableStatement = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    try{
	    	connection = ConnectionManager.getConnection();
		    
		    CallableStatement stmt = connection.prepareCall("BEGIN SP_GET_MATRICES(?,?,?); END;");		    
		    
		    stmt.setInt(1, codNivel); 
		    
		    stmt.setBigDecimal(2, idEfa);
		    stmt.registerOutParameter(3, OracleTypes.CURSOR); //REF CURSOR		    
		    
		    stmt.execute();
		    rs = ((OracleCallableStatement)stmt).getCursor(3);
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
	public List<ComponenteMatriz> getComponente(int idmatriz, BigDecimal idactividad) {
		// TODO Auto-generated method stub
		return matrizdao.getComponente(idmatriz, idactividad);
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
	public void addMatrizActividadFuncion(MatrizActividadFuncion maf, HttpSession session) {
		// TODO Auto-generated method stub
		matrizdao.addMatrizActividadFuncion(maf);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				maf.getIdmatrizactividadfunciones() != 0 ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervision_TEjecucion, maf.getIdmatrizactividadfunciones() <= 0 ?  Integer.toString(maf.getIdmatrizactividadfunciones()) : "");
	}

	@Transactional
	public List<MatrizActividadFuncion> getListMatrizFuncion(
			int idmatrizactividad, int idfuncion) {
		// TODO Auto-generated method stub
		return matrizdao.getListMatrizFuncion(idmatrizactividad, idfuncion);
	}

	@Transactional
	public void addArchiveFuncion(ArchivoFunciones af, HttpSession session) {
		// TODO Auto-generated method stub
		matrizdao.addArchiveFuncion(af);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				af.getIdarchivofunciones() < 0 ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervision_Archivo_Funciones, af.getIdarchivofunciones() < 0 ?  Integer.toString(af.getIdarchivofunciones()) : "");
	}

	@Transactional
	public List<ArchivoFunciones> listArchives(int idmatrizactividadfunciones) {
		// TODO Auto-generated method stub
		return  matrizdao.listArchives(idmatrizactividadfunciones);
	}
	@Transactional
	public void addMatrizactividadindicador(MatrizActividadIndicador mai, HttpSession session) {
		// TODO Auto-generated method stub
		matrizdao.addMatrizactividadindicador(mai);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				mai.getIdmatrizactividadindicador() < 0 ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervision_Matriz_Actividad_Indicador, mai.getIdmatrizactividadindicador() < 0 ?  Integer.toString(mai.getIdmatrizactividadindicador()) : "");
	}

	@Transactional
	public void saveMatrizActividadFuncion(MatrizActividadFuncion ma, HttpSession session) {
		// TODO Auto-generated method stub
		matrizdao.saveMatrizActividadFuncion(ma);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ma.getIdmatrizactividadfunciones() < 0 ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervision_Matriz_Actividad_Funciones, ma.getIdmatrizactividadfunciones() < 0 ?  Integer.toString(ma.getIdmatrizactividadfunciones()) : "");
	}

	@Transactional
	public MatrizActividad getMatrizAct(int idmatrizact) {
		// TODO Auto-generated method stub
		return matrizdao.getMatrizAct(idmatrizact);
	}

	@Transactional
	public List<MatrizActividadFuncion> getListMatrizFuncionByIdMa( String idfuntions) {
		return matrizdao.getListMatrizFuncionByIdMa(idfuntions);
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
	public void updateMatrizActividad(MatrizActividad ma, HttpSession session) {
		// TODO Auto-generated method stub
		matrizdao.updateMatrizActividad(ma);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Modificar, ConstantAuditoria.Table_Supervicion_MatrizActividad, 
				ma.getIdmatrizactividad() != null ?  ma.getIdmatrizactividad().toString() : "");
	}
	
	@Transactional
	public List<MatrizActividadIndicador> getIndicadoresActividad(
			int idmatrizactividadfunciones) {
		// TODO Auto-generated method stub
		return matrizdao.getIndicadoresActividad(idmatrizactividadfunciones);
	}

	@Transactional
	public void deleteArchive(int idArchive, HttpSession session) {
		// TODO Auto-generated method stub
		matrizdao.deleteArchive(idArchive);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervision_Archivo_Funciones, Integer.toString(idArchive));
	}

	public void cleanMatrizactividadindicador(int idmatrizactividadfuncion,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	public void addMatrizActividadComponente(MatrizActividadComponente mac,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}


}
