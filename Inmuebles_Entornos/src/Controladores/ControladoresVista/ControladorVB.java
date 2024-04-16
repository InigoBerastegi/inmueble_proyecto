package Controladores.ControladoresVista;

import Modelo.Usuario;
import Vista.VentanaBaja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Controlador de la ventana que permite dar de baja personas.
public class ControladorVB {
    private VentanaBaja vb;
    private ControladorVista cv;
    private Usuario p;
    private boolean dniCorrecto;

    public ControladorVB(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar()
    {
        // Crea, muestra y manda escuchar los listener de la ventana de las bajas.
        vb = new VentanaBaja();

        vb.addBAceptarAl(new BAceptarAl());
        vb.addBSalirAl(new BSalirAl());
        vb.addTfDniFl(new TfDniFl());
        vb.addTfDniAl(new TfDniAl());

        p=new Usuario();
        vb.setVisible(true);

    }

    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Borrar.
            try {
                if (dniCorrecto)
                    cv.borrarPersona();
                vb.limpiar();
            }
            catch (Exception ex)
            {
                vb.mostrarMensaje(ex.getMessage());
            }
        }

    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Eliminar la ventana y seguir en la principal
            vb.dispose();
        }
    }

    public class TfDniFl implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {

        }

        @Override
        public void focusLost(FocusEvent e) {
            // Validar y buscar la persona con ese dni para mostrar sus datos.
            // Validar el dni, buscar la persona y borrarla
            try
            {
                // Validación del dni
                String dni = vb.getTfDni().getText();
                if (dni.isEmpty())
                    throw new Exception("El dni es un campo obligatorio");
                Pattern pattern = Pattern.compile("^[0-9]{8}[a-zA-Z]$");
                Matcher matcher = pattern.matcher(dni);
                if (!matcher.matches())
                    throw new Exception("El dni no tiene el formato adecuado");

                // Dni correcto
                // Buscar la persona y mostrar el nombre
                p = cv.buscarPersona(dni);
                vb.getTaDatos().setText(p.getNombre());
                dniCorrecto = true;
            }
            catch(Exception ex)
            {
                dniCorrecto = false;
                vb.mostrarMensaje(ex.getMessage());
                vb.getTfDni().requestFocus();
            }
        }
    }

    public class TfDniAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // CODIGO REPETIDO
            // Validar y buscar la persona con ese dni para mostrar sus datos.
            // Validar el dni, buscar la persona y borrarla
            try
            {
                p=new Usuario();
                    // Validación del dni
                    String dni = vb.getTfDni().getText();
                    if (dni.isEmpty())
                        throw new Exception("El dni es un campo obligatorio");
                    Pattern pattern = Pattern.compile("^[0-9]{8}[a-zA-Z]$");
                    Matcher matcher = pattern.matcher(dni);
                    if (!matcher.matches())
                        throw new Exception("El dni no tiene el formato adecuado");

                    // Dni correcto
                    // Buscar la persona y mostrar el nombre
                    Usuario p = cv.buscarPersona(dni);
                    vb.getTaDatos().setText(p.getNombre());
                    dniCorrecto = true;
            }
            catch(Exception ex)
            {
                dniCorrecto = false;
                vb.mostrarMensaje(ex.getMessage());
                vb.getTfDni().requestFocus();
            }
        }
    }
}
