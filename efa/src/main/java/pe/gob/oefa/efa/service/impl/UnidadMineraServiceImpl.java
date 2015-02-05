package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import pe.gob.oefa.efa.dao.UnidadMineraDao;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.UnidadMinera;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.UnidadMineraService;

@Service
public class UnidadMineraServiceImpl implements UnidadMineraService {

	@Autowired
	private UnidadMineraDao unidadMineraDao;

	
	@Transactional
	public void saveUnidadMinera(UnidadMinera unidadMinera) {	
		unidadMineraDao.saveUnidadMinera(unidadMinera);
	}	
	
	@Transactional(readOnly = true)
	public List<UnidadMinera> listUnidadMineras() {
		return unidadMineraDao.listUnidadMineras();
	}

	@Transactional(readOnly = true)
	public List<UnidadMinera> listUnidadMineras_by_ID(BigDecimal id) {
		return unidadMineraDao.listUnidadMineras_by_ID(id);
	}	
	
	@Transactional(readOnly = true)
	public UnidadMinera getUnidadMinera(BigDecimal id) {
		return unidadMineraDao.getUnidadMinera(id);
	}

	@Transactional
	public void deleteUnidadMinera(BigDecimal id) {
		unidadMineraDao.deleteUnidadMinera(id);;

	}

	public void deleteUnidadMineras_by_AdmID(BigDecimal id) {
		unidadMineraDao.deleteUnidadMineras_by_AdmID(id);
		
	}
	


}
