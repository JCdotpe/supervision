package pe.gob.oefa.efa.service.impl;

import org.springframework.stereotype.Service;
import pe.gob.oefa.efa.form.ReporteForm;
import pe.gob.oefa.efa.model.ReporteActividad;
import pe.gob.oefa.efa.service.ReporteService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgonzales on 09/12/2014.
 */
@Service
public class ReporteServiceImpl implements ReporteService {

    public List<ReporteActividad> obtenerReporte(ReporteForm form) {
        List<ReporteActividad> lista = new ArrayList<ReporteActividad>();
        ReporteActividad actividad;
        for(int i = 0; i < 5; i++) {
            actividad = new ReporteActividad();
            actividad.setDepartamento("departamento"+i);
            actividad.setProvincia("provincia"+i);
            actividad.setDistrito("distrito"+i);
            lista.add(actividad);
        }
        return lista;
    }
}
