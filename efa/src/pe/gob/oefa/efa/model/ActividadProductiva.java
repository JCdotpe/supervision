package pe.gob.oefa.efa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hgonzales on 04/12/2014.
 */
@Entity
@Table(name = "TACTIVAD_PRODUCTIVA")
public class ActividadProductiva implements Serializable {

    @Id
    @Column(name = "C_ACTIVIDAD")
    private String codigo;
    @Column(name = "NOM_ACTIVIDAD")
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
