package Controladores.ControladoresVista;

import Modelo.Usuario;
import Vista.VentanaAlta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Controlador de la ventana utilizada para las altas de personas.
public class ControladorVA {

    private VentanaAlta va;
    private ControladorVista cv;
    public ControladorVA(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar()
    {
        // Crea, muestra y manda escuchar los listener de la ventana
        va = new VentanaAlta();
        va.addBAceptarAl(new BAceptarAl());
        va.addBSalirAl(new BSalirAl());
        va.setVisible(true);


    }

    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Validar, crear el objeto persona y guardarlo en la bd
            try
            {
                // Validación del dni
                String dni = va.getTfDni().getText();
                if (dni.isEmpty())
                    throw new Exception("El dni es un campo obligatorio");
                Pattern pattern = Pattern.compile("^[0-9]{8}[a-zA-Z]$");
                Matcher matcher = pattern.matcher(dni);
                if (!matcher.matches())
                    throw new Exception("El dni no tiene el formato adecuado");
                // Validación del nombre
                String nombre = va.getTfNombre().getText();
                if (nombre.isEmpty())
                    throw new Exception("El nombre es un campo obligatorio");
                pattern = Pattern.compile("^[A-Z][a-z]{2,}([ ][A-Z][a-z]{2,})*$");
                matcher = pattern.matcher(nombre);
                if (!matcher.matches())
                    throw new Exception("El nombre no tiene el formato adecuado");
                // Mejora -- reutilización de código

                // Datos correctos
                // Creación del objeto
                Usuario p = new Usuario(dni,nombre);
                /*
                 En vez de guardar el objeto en un array, arrayList,map, etc...
                 Lo llevamos a base de datos.
                 */

                 //cv.objetoPersonaParaInsertar(p);
                 System.out.println("Persona insertada");
                 va.limpiar();


            }
            catch(Exception ex)
            {
                va.mostrarMensaje(ex.getMessage());
            }

        }
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Eliminar la ventana y seguir en la principal.
            va.dispose();
        }
    }
}
