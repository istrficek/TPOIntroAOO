package grupo12.vistas;

import grupo12.controllers.OperacionController;
import grupo12.utils.OperacionesTableModel;

import javax.swing.*;
import java.awt.*;

public class FrmOperaciones extends JDialog{
    private JPanel pnlPrincipal;
    private JTable tableOperaciones;
    private OperacionController operacionController = new OperacionController();

    private OperacionesTableModel operacionesTableModel = new OperacionesTableModel();


    public FrmOperaciones(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        tableOperaciones.setModel(operacionesTableModel);

        operacionesTableModel.addLista(operacionController.obtenerTodasLasOperaciones());
    }
}
