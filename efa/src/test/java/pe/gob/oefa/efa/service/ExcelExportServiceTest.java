package pe.gob.oefa.efa.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import pe.gob.oefa.efa.config.AbstractTestConfiguration;
import pe.gob.oefa.efa.model.ReporteActividad;
import pe.gob.oefa.efa.procedure.Department;
import pe.gob.oefa.efa.procedure.Employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by hgonzales on 08/12/2014.
 */
public class ExcelExportServiceTest extends AbstractTestConfiguration {

    @Autowired
    private ExcelExportService exportService;

    @Test
    public void testTransformXLS() {
        Assert.isTrue(true);
        String template = "C:/hgonzales/sources/training/efa/data/efareport.xls";
        String reporte = "C:/hgonzales/sources/training/efa/data/basicreporte1.xls";
        /*Map<String, List<Department>> data = new HashMap<String, List<Department>>();
        Department d = new Department("departament01");
        d.setChief(new Employee("chieft01", 10,10d, 10d));
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("chieft02", 20,20d, 20d));
        list.add(new Employee("chieft03", 30,30d, 30d));
        list.add(new Employee("chieft04", 40,40d, 40d));
        d.setStaff(list);
        List<Department> departaments = new ArrayList<Department>();
        departaments.add(d);
        data.put("departments", departaments);*/
        Map<String, List<ReporteActividad>> data = new HashMap<String, List<ReporteActividad>>();
        List<ReporteActividad> actividades = new ArrayList<ReporteActividad>();
        ReporteActividad a = new ReporteActividad();
        a.setDescripcion("descripcion1");
        a.setComponente("componente1");
        actividades.add(a);
        a = new ReporteActividad();
        a.setDescripcion("descripcion2");
        a.setComponente("componente2");
        actividades.add(a);
        a = new ReporteActividad();
        a.setDescripcion("descripcion3");
        a.setComponente("componente3");
        actividades.add(a);
        data.put("actividades", actividades);
        try {
            exportService.transformXLS(template, data, reporte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.notNull(exportService);
    }
}
