public class Usuario {
        private String Dni;
        private String Nombre;

    public Usuario(String dni, String nombre) {
        Dni = dni;
        Nombre = nombre;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
