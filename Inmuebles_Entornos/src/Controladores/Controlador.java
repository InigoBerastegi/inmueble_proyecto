package Controladores;

import Controladores.ControladoresVista.ControladorVista;
import Modelo.Usuario;

import java.util.List;

public class Controlador {
    private ControladorVista cv; // Controlador jefe de la vista

    public Controlador() {
        cv = new ControladorVista(this);
    }

    /*public void terminar()
    {
        // Le dice al controlador de la base de datos que cierre la conexión.
        cm.cerrarConexion();
        System.exit(0);
    }*/

    public void objetoPersonaParaInsertar(Usuario p) throws Exception
    {
        //cm.objetoPersonaParaInsertar(p);
    }

    public void buscarPersona(String dni) throws Exception
    {
        //return cm.buscarPersona(dni);
    }
    public void borrarPersona() throws Exception
    {
        //cm.borrarPersona();
    }

    public void nuevoNombre(String nombre) throws Exception
    {
        //cm.nuevoNombre(nombre);
    }
    public void llenarCombo() throws Exception
    {
        //return cm.getDnis();
    }
}
