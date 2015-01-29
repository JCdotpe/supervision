package pe.gob.oefa.efa.config;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pe.gob.oefa.efa.dao.DenunciaAmbientalesDAO;
import pe.gob.oefa.efa.form.DenunciaForm;
import pe.gob.oefa.efa.model.Denuncia;

import java.util.List;

/**
 * Created by hgonzales on 07/12/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(defaultRollback = true)
public abstract class AbstractTestConfiguration extends AbstractTransactionalJUnit4SpringContextTests {

    /*@Autowired
    private DenunciaAmbientalesDAO dao;

    @Test
    public void test() {
        Assert.assertTrue(true);
        List<Denuncia> lista = dao.obtenerDenuncias(new DenunciaForm());
        Assert.assertNotNull(lista);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(lista.size());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }*/
}
