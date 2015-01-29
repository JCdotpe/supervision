package pe.gob.oefa.efa.model;

import java.io.Serializable;

/**
 * Created by hgonzales on 04/12/2014.
 */
public class EstadoDenuncia implements Serializable {

    private String codigo;
    private String nombre;

    public EstadoDenuncia() {
    }

    public EstadoDenuncia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

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
