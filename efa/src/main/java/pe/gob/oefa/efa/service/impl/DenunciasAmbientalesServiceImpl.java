package pe.gob.oefa.efa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.oefa.efa.dao.DenunciaAmbientalesDAO;
import pe.gob.oefa.efa.model.Denuncia;
import pe.gob.oefa.efa.form.DenunciaForm;
import pe.gob.oefa.efa.model.*;
import pe.gob.oefa.efa.service.DenunciasAmbientalesService;

import java.util.List;

/**
 * Created by hgonzales on 04/12/2014.
 */
@Service
public class DenunciasAmbientalesServiceImpl implements DenunciasAmbientalesService {

    @Autowired
    private DenunciaAmbientalesDAO denunciasDAO;

    public List<Denuncia> obtenerDenuncias(DenunciaForm form) {
        return denunciasDAO.obtenerDenuncias(form);
    }

    public List<Oficina> obtenerOficinas() {
        return denunciasDAO.obtenerOficinas();
    }

    public List<ActividadProductiva> obtenerActividadProductiva() {
        return denunciasDAO.obtenerActividadProductiva();
    }

    public List<EstadoDenuncia> obtenerEstadoDenuncia() {
        return denunciasDAO.obtenerEstadoDenuncia();
    }
}
