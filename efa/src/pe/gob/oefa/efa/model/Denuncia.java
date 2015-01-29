package pe.gob.oefa.efa.model;

/**
 * Created by hgonzales on 05/12/2014.
 */
public class Denuncia {

    private String idDenuncia;
    private String codigoSinada;
    private String descHecho;
    private String fechaDenuncia;
    private String fechaRegistro;
    private String fechaModificacion;
    private String denunciante;
    private String denunciado;
    private String razonSocialDenunciante;
    private String razonSocialDenunciado;
    private String estado;
    private String nombreEstado;
    private String verDenunciante;

    public String getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(String idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getCodigoSinada() {
        return codigoSinada;
    }

    public void setCodigoSinada(String codigoSinada) {
        this.codigoSinada = codigoSinada;
    }

    public String getDescHecho() {
        return descHecho;
    }

    public void setDescHecho(String descHecho) {
        this.descHecho = descHecho;
    }

    public String getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(String fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
    }

    public String getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(String denunciado) {
        this.denunciado = denunciado;
    }

    public String getRazonSocialDenunciante() {
        return razonSocialDenunciante;
    }

    public void setRazonSocialDenunciante(String razonSocialDenunciante) {
        this.razonSocialDenunciante = razonSocialDenunciante;
    }

    public String getRazonSocialDenunciado() {
        return razonSocialDenunciado;
    }

    public void setRazonSocialDenunciado(String razonSocialDenunciado) {
        this.razonSocialDenunciado = razonSocialDenunciado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getVerDenunciante() {
        return verDenunciante;
    }

    public void setVerDenunciante(String verDenunciante) {
        this.verDenunciante = verDenunciante;
    }
}
