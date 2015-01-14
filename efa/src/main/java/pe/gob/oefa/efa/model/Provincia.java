package pe.gob.oefa.efa.model;

import pe.gob.oefa.efa.model.id.ProvinciaID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hgonzales on 04/12/2014.
 */
@Entity
@Table(name="TPROVINCIA")
public class Provincia implements Serializable {

    @EmbeddedId
    private ProvinciaID id;
    @Column(name = "X_NOMBREPV")
    private String nombre;

    public ProvinciaID getId() {
        return id;
    }

    public void setId(ProvinciaID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
