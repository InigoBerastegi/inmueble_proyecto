package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    private JPanel pPrincipal;
    private JButton bAlta;
    private JButton bBaja;
    private JButton bModificar;
    private JButton bConsulta;
    private JButton bSalir;
    private JPanel pTitulo;

    public VentanaPrincipal() {
        setContentPane(pPrincipal);
        setSize(500,500);
        setLocationRelativeTo(null);
    }

    // Listener de los cinco botones.
    public void addBAltaAl(ActionListener al)
    {
        bAlta.addActionListener(al);
    }
    public void addBBajaAl(ActionListener al)
    {
        bBaja.addActionListener(al);
    }
    public void addBModificarAl(ActionListener al)
    {
        bModificar.addActionListener(al);
    }
    public void addBConsultaAl(ActionListener al)
    {
        bConsulta.addActionListener(al);
    }
    public void addBSalirAl(ActionListener al)
    {
        bSalir.addActionListener(al);
    }

    // Varios
    public void mostrarMensaje(String m)
    {
        JOptionPane.showMessageDialog(null,m);
    }
}
