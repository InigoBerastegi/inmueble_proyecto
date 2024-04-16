package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaAlta extends JFrame{
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JPanel pDatos;
    private JPanel pBotones;
    private JButton bAceptar;
    private JButton bSalir;

    // Constructor
    public VentanaAlta() {
        super("Alta de personas");
        setContentPane(pPrincipal);
        setSize(300,300);
        setLocationRelativeTo(null);
    }

    // Setters y getters de las cajas de texto.
    public JTextField getTfDni() {
        return tfDni;
    }

    public void setTfDni(JTextField tfDni) {
        this.tfDni = tfDni;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    // Listener de los dos botones.
    public void addBAceptarAl(ActionListener al)
    {
        bAceptar.addActionListener(al);
    }

    public void addBSalirAl(ActionListener al)
    {
        bSalir.addActionListener(al);
    }

    // Varios
    public void mostrarMensaje(String m)
    {
        JOptionPane.showMessageDialog(null, m);
    }

    public void limpiar()
    {
        tfDni.setText("");
        tfNombre.setText("");
        tfDni.requestFocus();
    }
}
