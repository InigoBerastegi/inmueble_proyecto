package Controladores.ControladoresVista;

import Controladores.Controlador;
import Modelo.Inmueble;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

/*
  Controlador jefe de todos los controladores de ventanas.
 */
public class ControladorVista {
    private Controlador c; // Comunicación con su jefe
    private ControladorVP cvp; // Controlador de la ventana principal
    private ControladorVA cva; // Controlador de la ventana para las altas
    private ControladorVB cvb; // Controlador de la ventana para las bajas
    private List<Usuario> listaUsuarios;
    private Usuario u;
    /*
    private ControladorVM cvm; // Controlador de la ventana para las modificaciones
    private ControladorVC cvc; // Controlador de la ventana para las consultas.

     */
    public ControladorVista(Controlador c)
    {
        this.c = c;
        // Creación de los controladores de ventanas
        cvp = new ControladorVP(this);
        cva = new ControladorVA(this);
        cvb = new ControladorVB(this);
        listaUsuarios = new ArrayList<>();
        u=new Usuario();

        /*
        cvm = new ControladorVM(this);
        cvc = new ControladorVC(this);

         */

        // Manda al controlador de la ventana principal crear y mostrar esa ventana.
        cvp.crearMostrar();
    }
    public void mostrarBaja()
    {
        // Manda al controlador de la ventana de las bajas crear y mostrar esa ventana.
        cvb.crearMostrar();
    }
    public void terminar()
    {
        // Han hecho clic en el botón salir.
        //cp.terminar();
    }

    public void borrarPersona() throws Exception
    {
        c.borrarPersona();
    }

    public void crearPersonas() throws Exception
    {
        Usuario aitor = new Usuario("11111111A", "Aitor");
        listaUsuarios.add(aitor);

        Usuario ruth = new Usuario("22222222Q", "Ruth");
        listaUsuarios.add(ruth);

        Usuario aiala = new Usuario("33333333P", "Juan");
        listaUsuarios.add(aiala);

        Usuario ibai = new Usuario("444444441", "Mikel");
        listaUsuarios.add(ibai);
    }

    public Usuario buscarPersona(String dni) throws Exception
    {
        for(int x=0; x<listaUsuarios.size(); x++){
         if (dni.equalsIgnoreCase(listaUsuarios.get(x).getDni())){
             return listaUsuarios.get(x);
            }
        }
        return null;
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

    public void mostrarConsulta() throws Exception
    {
        // Manda al controlador de la ventana consultas crear y mostrar esa ventana.
        cvc.crearMostrar();
    }



    public void objetoPersonaParaInsertar(Usuario p) throws Exception
    {
        c.objetoPersonaParaInsertar(p);
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
