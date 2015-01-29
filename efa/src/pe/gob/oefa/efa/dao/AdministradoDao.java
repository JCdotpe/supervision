package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.Administrado;

public interface AdministradoDao {
		/*
		 * CREATE and UPDATE
		 */
		public void saveAdministrado(Administrado administrado); // create and update
		
		/*
		 * READ
		 */
		public List<Administrado> listAdministrados();
//		public List listAdministrados_by(String fechaini, String fechafin, String nombrefa, String nombresup, String nivel, String informe, String codact, String estado, String estadomatriz, String estadoejec );
		public Administrado getAdministrado(BigDecimal id);
//		public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id);
		/*
		 * DELETE
*/
		public void deleteAdministrado(BigDecimal id);
}
