package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.SupervisorEmergenciaDao;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.service.SupervisorEmergenciaService;

@Service
public class SupervisorEmergenciaServiceImpl implements SupervisorEmergenciaService {

	@Autowired
	private SupervisorEmergenciaDao supervisorEmergenciaDao;
	
	@Transactional
	public void saveSupervisorEmergencia(SupervisorEmergencia supervisorEmergencia) {
		supervisorEmergenciaDao.saveSupervisorEmergencia(supervisorEmergencia);
	}

	@Transactional(readOnly = true)
	public List<SupervisorEmergencia> listSupervisorEmergencia() {
		return supervisorEmergenciaDao.listSupervisorEmergencia();
	}

	@Transactional(readOnly = true)
	public SupervisorEmergencia getSupervisorEmergencia(BigDecimal id) {
		return supervisorEmergenciaDao.getSupervisorEmergencia(id);
	}


	@Transactional
	public void deleteSupervisorEmergencia(BigDecimal id) {
		supervisorEmergenciaDao.deleteSupervisorEmergencia(id);
	}

}
