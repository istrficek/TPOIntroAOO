package Vistas;

import grupo12.controllers.SocioController;
import grupo12.entity.Participe;
import grupo12.entity.Socio;

import javax.swing.*;
import java.awt.*;
public class FrmSocios  extends JDialog {
    private JPanel panel1;
    private JPanel pnlPrincipal;
    private JTabbedPane tabbedPane1;
    private JButton button1;

    public FrmSocios(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }
}
