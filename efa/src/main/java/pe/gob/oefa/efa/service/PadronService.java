package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.Padron;


public interface PadronService {

	/*
	 * CREATE and UPDATE 
	 */
	public void savePadron(Padron padron, HttpSession session);



}
