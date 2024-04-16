package Controladores.ControladoresVista;

import Vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controlador de la ventana que permite seleccionar la operación a realizar.
public class ControladorVP {
    private VentanaPrincipal vp;

    /*
    Dispone de la referencia del controlador principal para que
    sepa la operación a realizar y pueda mandarsela al controlador
    correspondiente.
     */
    private ControladorVista cv;
    public ControladorVP(ControladorVista cv)
    {
        this.cv = cv;
    }

    public void crearMostrar()
    {
        // Crea, muestra y pone a escuchar la ventana principal.
        vp = new VentanaPrincipal();

        vp.addBAltaAl(new BAltaAl());

        /*vp.addBBajaAl(new BBajaAl());*/
        /*vp.addBConsultaAl(new BConsultaAl());*/
        vp.addBModificarAl(new BModificarAl());
        /*vp.addBSalirAl(new BSalirAl());*/
        

        vp.setVisible(true);
    }

    public class BAltaAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Le dice al controlador de vista que la operación elegida es alta
           // cv.mostrarAlta();
        }
    }
    /*
    public class BBajaAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Le dice al controlador de vista que la operación elegida es baja
            cv.mostrarBaja();
        }
    }

    public class BConsultaAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try
            {
                // El try es por el llenado de la combo
                // Le dice al controlador de vista que la operación elegida es consulta
                cv.mostrarConsulta();
            }
            catch(Exception ex)
            {
                vp.mostrarMensaje(ex.getMessage());
            }
        }
    }
*/
    public class BModificarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Le dice al controlador de vista que la operación elegida es modificación
            cv.mostrarModificacion();
        }
    }
/*
    public class BSalirAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Acaba la ejecución el proyecto.
            // Hay que cerrar la conexión con la base de datos.
            vp.dispose();
            cv.terminar();
        }
    }

     */
}
