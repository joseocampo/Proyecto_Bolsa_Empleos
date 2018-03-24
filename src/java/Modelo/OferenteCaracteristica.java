
package Modelo;

public class OferenteCaracteristica {

    public OferenteCaracteristica() {
    }

    public OferenteCaracteristica(String idOferente, int nivel, int idCaracteristica) {
        this.idOferente = idOferente;
        this.nivel = nivel;
        this.idCaracteristica = idCaracteristica;
    }

    public String getIdOferente() {
        return idOferente;
    }

    public void setIdOferente(String idOferente) {
        this.idOferente = idOferente;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }
    
    private String idOferente;
    private int nivel;
    private int idCaracteristica;
}
