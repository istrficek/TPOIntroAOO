package grupo12.vistas;

import grupo12.controllers.OperacionController;
import grupo12.utils.OperacionesAvalTableModel;
import grupo12.utils.OperacionesTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class FrmListaOperacionesAval extends JDialog {
    private JPanel pnlPrincipal;
    private JTable tableOperaciones;
    private OperacionesAvalTableModel operacionesTableModel = new OperacionesAvalTableModel();
    private OperacionController operacionController = new OperacionController();
    public FrmListaOperacionesAval(int idSocio, Date fechaInicio, Date fechaFin ) {

        setContentPane(pnlPrincipal);

        this.setSize(800, 230);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        tableOperaciones.setModel(operacionesTableModel);

        operacionesTableModel.addLista(operacionController.getOperacionesAvaladas(idSocio, fechaInicio, fechaFin));
    }
}
