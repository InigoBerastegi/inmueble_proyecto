package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class VentanaBaja extends JFrame{
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JTextField tfDni;
    private JTextArea taDatos;
    private JPanel pBotones;
    private JButton bAceptar;
    private JButton bSalir;

    public VentanaBaja() {
        super("Borrar personas");
        setContentPane(pPrincipal);
        setSize(300,300);
        setLocationRelativeTo(null);
    }

    // Setters y getters

    public JTextField getTfDni() {
        return tfDni;
    }

    public void setTfDni(JTextField tfDni) {
        this.tfDni = tfDni;
    }

    public JTextArea getTaDatos() {
        return taDatos;
    }

    public void setTaDatos(JTextArea taDatos) {
        this.taDatos = taDatos;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    // Listener
    public void addBAceptarAl (ActionListener al)
    {
        bAceptar.addActionListener(al);
    }

    public void addBSalirAl (ActionListener al)
    {
        bSalir.addActionListener(al);
    }

    public void addTfDniAl (ActionListener al)
    {
        tfDni.addActionListener(al);
    }

    public void addTfDniFl(FocusListener fl){
        tfDni.addFocusListener(fl);
    }

    public void mostrarMensaje(String m)
    {
        JOptionPane.showMessageDialog(null, m);
    }

    public void limpiar()
    {
        tfDni.setText("");
        taDatos.setText("");
        tfDni.requestFocus();
    }

}
