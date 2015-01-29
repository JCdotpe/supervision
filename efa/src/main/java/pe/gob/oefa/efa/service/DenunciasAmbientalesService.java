package pe.gob.oefa.efa.service;

import pe.gob.oefa.efa.model.Denuncia;
import pe.gob.oefa.efa.form.DenunciaForm;
import pe.gob.oefa.efa.model.*;

import java.util.List;

/**
 * Created by hgonzales on 04/12/2014.
 */
public interface DenunciasAmbientalesService {

    List<Denuncia> obtenerDenuncias(DenunciaForm form);

    List<Oficina> obtenerOficinas();

    List<ActividadProductiva> obtenerActividadProductiva();

    List<EstadoDenuncia> obtenerEstadoDenuncia();
}
