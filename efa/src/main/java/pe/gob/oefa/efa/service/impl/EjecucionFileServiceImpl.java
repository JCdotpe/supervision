package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.EjecucionFileDao;
import pe.gob.oefa.efa.model.EjecucionFile;
import pe.gob.oefa.efa.service.EjecucionFileService;

@Service
public class EjecucionFileServiceImpl implements EjecucionFileService {
	
	@Autowired
	private EjecucionFileDao ejecucionFileDao;
	
	@Transactional
	public void saveEjecucionFile(EjecucionFile ejecucionFile) {
		ejecucionFileDao.saveEjecucionFile(ejecucionFile);;
	}

	@Transactional(readOnly = true)
	public List<EjecucionFile> listEjecucionFile() {
		return ejecucionFileDao.listEjecucionFile();
	}

	@Transactional(readOnly = true)
	public EjecucionFile getEjecucionFile(BigDecimal id) {
		return ejecucionFileDao.getEjecucionFile(id);
	}

	@Transactional
	public void deleteEjecucionFile(BigDecimal id) {
		ejecucionFileDao.deleteEjecucionFile(id);;
	}

}
