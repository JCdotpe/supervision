package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.PadronDao;
import pe.gob.oefa.efa.model.Padron;
import pe.gob.oefa.efa.service.PadronService;

@Service
public class PadronServiceImpl implements PadronService {

	@Autowired
	private PadronDao padronDao;
	
	@Transactional
	public void savePadron(Padron padron) {
		padronDao.savePadron(padron);
	}


}
