package pe.gob.oefa.efa.service;

import pe.gob.oefa.efa.procedure.Department;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by hgonzales on 08/12/2014.
 */
public interface ExcelExportService {

    <T> void transformXLS(String templateFileName, Map<String, List<T>> data, String destFileName)  throws Exception;
    <T> void transformXLS(InputStream template, Map<String, List<T>> data, OutputStream out)  throws Exception;
}
