package pe.gob.oefa.efa.model;

import pe.gob.oefa.efa.model.id.DistritoID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hgonzales on 04/12/2014.
 */
@Entity
@Table(name = "TDISTRITO")
public class Distrito implements Serializable {

    @EmbeddedId
    private DistritoID id;
    @Column(name = "X_NOMBREDI")
    private String nombre;

    public DistritoID getId() {
        return id;
    }

    public void setId(DistritoID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
