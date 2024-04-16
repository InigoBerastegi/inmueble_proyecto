package Controladores.ControladoresVista;

import Vista.VentanaModificarUsuarios;
import modelo.Persona;
import vista.VentanaModificar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Controlador de la ventana que sirve para modificar los datos de una persona.
public class ControladorVM {
    private VentanaModificarUsuarios vm;
    private boolean dniCorrecto;
    private ControladorVista cv;
    public ControladorVM(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar()
    {
        // Crea, muestra y manda escuchar los listener de la ventana modificaciones.
        vm = new VentanaModificarUsuarios();

        vm.addBAceptarAl(new BAceptarAl());
        vm.addBSalirAl(new BSalirAl());
        vm.addTfDniAl(new TfDniAl());
        vm.addTfDniFl(new TfDniFl());

        vm.setVisible(true);
    }

    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Modificar el nombre de la persona.
            try
            {
                if (dniCorrecto)
                {
                    // Validar el nuevo nombre y modificarlo en la bd
                    String nombre = vm.getTfNombre().getText();
                    if (nombre.isEmpty())
                        throw new Exception("El nombre es un campo obligatorio");
                    Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}([ ][A-Z][a-z]{2,})*$");
                    Matcher matcher = pattern.matcher(nombre);
                    if (!matcher.matches())
                        throw new Exception("El nombre no tiene el formato adecuado");
                    // Mejor objeto.
                    cv.nuevoNombre(nombre);
                    vm.limpiar();
                }
            }
            catch(Exception ex)
            {
                vm.mostrarMensaje(ex.getMessage());
            }

        }
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Eliminar la ventana y seguir en la principal
            vm.dispose();
        }
    }

    public class TfDniAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Buscar la persona con ese dni y mostrar su nombre.
            try
            {
                // Validación del dni
                String dni = vm.getTfDni().getText();
                if (dni.isEmpty())
                    throw new Exception("El dni es un campo obligatorio");
                Pattern pattern = Pattern.compile("^[0-9]{8}[a-zA-Z]$");
                Matcher matcher = pattern.matcher(dni);
                if (!matcher.matches())
                    throw new Exception("El dni no tiene el formato adecuado");

                // Dni correcto
                // Buscar la persona y mostrar el nombre
                Persona p = cv.buscarPersona(dni);
                vm.getTfNombre().setText(p.getNombre());
                dniCorrecto = true;
            }
            catch(Exception ex)
            {
                dniCorrecto = false;
                vm.mostrarMensaje(ex.getMessage());
                vm.getTfDni().requestFocus();
            }
        }
    }

    public class TfDniFl implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {

        }

        @Override
        public void focusLost(FocusEvent e) {
            // CODIGO REPETIDO
            // Buscar la persona con ese dni y mostrar su nombre.
            try
            {
                // Validación del dni
                String dni = vm.getTfDni().getText();
                if (dni.isEmpty())
                    throw new Exception("El dni es un campo obligatorio");
                Pattern pattern = Pattern.compile("^[0-9]{8}[a-zA-Z]$");
                Matcher matcher = pattern.matcher(dni);
                if (!matcher.matches())
                    throw new Exception("El dni no tiene el formato adecuado");

                // Dni correcto
                // Buscar la persona y mostrar el nombre
                Persona p = cv.buscarPersona(dni);
                vm.getTfNombre().setText(p.getNombre());
                dniCorrecto = true;
            }
            catch(Exception ex)
            {
                dniCorrecto = false;
                vm.mostrarMensaje(ex.getMessage());
                vm.getTfDni().requestFocus();
            }
        }
    }
}
