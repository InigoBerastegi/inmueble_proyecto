package Modelo;

public class Inmueble {
    private String codigo;
    private String nombre;
    private String localidad;
    private String calle;
    private double numHab;

    public Inmueble(String codigo, String nombre, String localidad, String calle, double numHab) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.calle = calle;
        this.numHab = numHab;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public double getNumHab() {
        return numHab;
    }

    public void setNumHab(double numHab) {
        this.numHab = numHab;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", calle='" + calle + '\'' +
                ", numHab=" + numHab +
                '}';
    }
}
