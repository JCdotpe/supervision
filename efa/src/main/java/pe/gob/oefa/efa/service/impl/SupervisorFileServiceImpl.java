package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.SupervisorFileDao;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.service.SupervisorFileService;

@Service
public class SupervisorFileServiceImpl implements SupervisorFileService {

	@Autowired
	private SupervisorFileDao supervisorFileDao;
	
	@Transactional
	public void saveSupervisorFile(SupervisorFile supervisorFile) {
		supervisorFileDao.saveSupervisorFile(supervisorFile);
	}

	@Transactional(readOnly = true)
	public List<SupervisorFile> listSupervisorFile() {
		return supervisorFileDao.listSupervisorFile();
	}

	@Transactional(readOnly = true)
	public SupervisorFile getSupervisorFile(BigDecimal id) {
		return supervisorFileDao.getSupervisorFile(id);
	}


	@Transactional
	public void deleteSupervisorFile(BigDecimal id) {
		supervisorFileDao.deleteSupervisorFile(id);
	}

}
