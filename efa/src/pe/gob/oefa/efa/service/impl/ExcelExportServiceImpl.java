package pe.gob.oefa.efa.service.impl;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import pe.gob.oefa.efa.procedure.Department;
import pe.gob.oefa.efa.service.ExcelExportService;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by hgonzales on 08/12/2014.
 */
@Service
public class ExcelExportServiceImpl implements ExcelExportService {

    private XLSTransformer transformer;

    @PostConstruct
    public void initClass() {
        transformer = new XLSTransformer();
    }

    public synchronized <T> void transformXLS(String templateFileName, Map<String, List<T>> data, String destFileName) throws Exception {
        transformer.transformXLS(templateFileName, data, destFileName);
    }

    public <T> void transformXLS(InputStream template, Map<String, List<T>> data, OutputStream out) throws Exception {
        Workbook workbook = transformer.transformXLS(template, data);
        workbook.write(out);
    }
}
