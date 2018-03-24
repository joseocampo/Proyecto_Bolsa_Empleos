
package Modelo;

public class PuestoCaracteristica {

    public PuestoCaracteristica() {
    }

    public PuestoCaracteristica(String idPuesto, int nivel, String idCaracteristica) {
        this.idPuesto = idPuesto;
        this.nivel = nivel;
        this.idCaracteristica = idCaracteristica;
    }

    public String getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(String idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(String idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    private String idPuesto;
    private int nivel;
    private String idCaracteristica;
}
