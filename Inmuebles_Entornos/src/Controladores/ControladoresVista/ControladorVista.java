package Controladores.ControladoresVista;

import Controladores.Controlador;
import Modelo.Inmueble;
import Modelo.Usuario;

import java.util.List;

/*
  Controlador jefe de todos los controladores de ventanas.
 */
public class ControladorVista {
    private Controlador c; // Comunicación con su jefe
    private ControladorVP cvp; // Controlador de la ventana principal
    private ControladorVA cva; // Controlador de la ventana para las altas
    /*
    private ControladorVM cvm; // Controlador de la ventana para las modificaciones
    private ControladorVB cvb; // Controlador de la ventana para las bajas
    private ControladorVC cvc; // Controlador de la ventana para las consultas.

     */
    public ControladorVista(Controlador c)
    {
        this.c = c;
        // Creación de los controladores de ventanas
        cvp = new ControladorVP(this);
        cva = new ControladorVA(this);
        /*
        cvm = new ControladorVM(this);
        cvb = new ControladorVB(this);
        cvc = new ControladorVC(this);

         */

        // Manda al controlador de la ventana principal crear y mostrar esa ventana.
        cvp.crearMostrar();
    }
/*
    public void mostrarAlta()
    {
        // Manda al controlador de la ventana alta crear y mostrar esa ventana.
        cva.crearMostrar();
    }

    public void mostrarModificacion()
    {
        // Manda al controlador de la ventana de modificaciones crear y mostrar esa ventana.
        cvm.crearMostrar();
    }

    public void mostrarBaja()
    {
        // Manda al controlador de la ventana de las bajas crear y mostrar esa ventana.
        cvb.crearMostrar();
    }

    public void mostrarConsulta() throws Exception
    {
        // Manda al controlador de la ventana consultas crear y mostrar esa ventana.
        cvc.crearMostrar();
    }

    public void terminar()
    {
        // Han hecho clic en el botón salir.
        //cp.terminar();
    }

    public void objetoPersonaParaInsertar(Usuario p) throws Exception
    {
        c.objetoPersonaParaInsertar(p);
    }

    public Usuario buscarPersona(String dni) throws Exception
    {
        return c.buscarPersona(dni);
    }
    public void borrarPersona() throws Exception
    {
        c.borrarPersona();
    }

    public void nuevoNombre(String nombre) throws Exception
    {
        c.nuevoNombre(nombre);
    }
    public List<PersonasEntity> llenarCombo() throws Exception{
       return c.llenarCombo();
    }

 */
}
