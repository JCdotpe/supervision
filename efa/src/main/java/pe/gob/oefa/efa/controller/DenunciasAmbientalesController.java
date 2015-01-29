package pe.gob.oefa.efa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.gob.oefa.efa.model.Denuncia;
import pe.gob.oefa.efa.form.DenunciaForm;
import pe.gob.oefa.efa.model.*;
import pe.gob.oefa.efa.service.DenunciasAmbientalesService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.utils.LabelValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hgonzales on 03/12/2014.
 */
@Controller
@SessionAttributes({"denunciaForm"})
public class DenunciasAmbientalesController {

    @Autowired
    private DenunciasAmbientalesService denunciasService;
    @Autowired
    private UbigeoService ubigeoService;

    @RequestMapping(value = "/sinada", method = RequestMethod.POST)
    public String obtenerResultado(@ModelAttribute("denunciaForm") DenunciaForm form, ModelMap model) {
        List<Denuncia> denuncias = denunciasService.obtenerDenuncias(form);
        model.addAttribute("denuncias", denuncias);
        return "denuncias/listDenuncias";
    }

    @RequestMapping(value = "/sinada", method = RequestMethod.GET)
    public String loadSinada(ModelMap model) {
        model.addAttribute("denunciaForm", new DenunciaForm());
        return "denuncias/listDenuncias";
    }

    @ModelAttribute("actividadProductivaList")
    public List<ActividadProductiva> colocarActividadProductivaEnContexto() {
        return denunciasService.obtenerActividadProductiva();
    }

    @ModelAttribute("estadoDenunciaList")
    public List<EstadoDenuncia> colocarEstadoDenunciaEnContexto() {
        return denunciasService.obtenerEstadoDenuncia();
    }

    @ModelAttribute("oficinaList")
    public List<Oficina> colocarOficinasEnContexto() {
        return denunciasService.obtenerOficinas();
    }

    @ModelAttribute("documentoList")
    public List<LabelValue> colocarDocumentosEnContexto() {
        List<LabelValue> lista = new ArrayList<LabelValue>();
        lista.add(new LabelValue("SI", "1"));
        lista.add(new LabelValue("NO", "2"));
        return lista;
    }

    @ModelAttribute("departamentoList")
    public List<Departamento> colocarDepartamentosEnContexto() {
        return ubigeoService.obtenerDepartamentos();
    }

    @ModelAttribute("provinciaList")
    public List<Provincia> colocarProvinciasEnContexto(@ModelAttribute("denunciaForm") DenunciaForm form) {
        if (form.getDepartamento() == null) {
            return Collections.emptyList();
        }
        return ubigeoService.obtenerProvincias(form.getDepartamento());
    }

    @ModelAttribute("distritoList")
    public List<Distrito> colocarDistritosEnContexto(@ModelAttribute("denunciaForm") DenunciaForm form) {
        if (form.getProvincia() == null) {
            return Collections.emptyList();
        }
        return ubigeoService.obtenerDistritos(form.getDepartamento(), form.getProvincia());
    }
}
