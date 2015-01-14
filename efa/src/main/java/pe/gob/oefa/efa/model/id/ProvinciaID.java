package pe.gob.oefa.efa.model.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hgonzales on 04/12/2014.
 */
@Embeddable
public class ProvinciaID implements Serializable {

    @Column(name = "C_CCPP")
    private String codigo;
    @Column(name = "C_CCDD")
    private String ccdd;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCcdd() {
        return ccdd;
    }

    public void setCcdd(String ccdd) {
        this.ccdd = ccdd;
    }
}
