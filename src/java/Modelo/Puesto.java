package Modelo;

public class Puesto {

    public Puesto() {

    }

    public Puesto(int id, String nombrePuesto, float salarioOfrecido, int publicacion, int nombreEmpresa) {
        this.id = id;
        this.nombrePuesto = nombrePuesto;
        this.salarioOfrecido = salarioOfrecido;
        this.publicacion = publicacion;
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public float getSalarioOfrecido() {
        return salarioOfrecido;
    }

    public void setSalarioOfrecido(float salarioOfrecido) {
        this.salarioOfrecido = salarioOfrecido;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public int getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(int nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    private int id;
    private String nombrePuesto;
    private float salarioOfrecido;
    private int publicacion;
    private int nombreEmpresa;
}
