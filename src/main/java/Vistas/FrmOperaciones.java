package Vistas;

import javax.swing.*;
import java.awt.*;

public class FrmOperaciones extends JDialog{
    private JPanel pnlPrincipal;
    public FrmOperaciones(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }
}