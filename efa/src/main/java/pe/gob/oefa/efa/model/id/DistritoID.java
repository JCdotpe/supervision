package pe.gob.oefa.efa.model.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hgonzales on 04/12/2014.
 */
@Embeddable
public class DistritoID implements Serializable {

    @Column(name = "C_CCDI")
    private String codigo;
    @Column(name = "C_CCDD")
    private String ccdd;
    @Column(name = "C_CCPP")
    private String ccpp;

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

    public String getCcpp() {
        return ccpp;
    }

    public void setCcpp(String ccpp) {
        this.ccpp = ccpp;
    }
}
