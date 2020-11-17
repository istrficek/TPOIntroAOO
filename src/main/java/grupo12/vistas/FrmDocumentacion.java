package grupo12.vistas;

import grupo12.controllers.DocumentacionController;
import grupo12.controllers.OperacionController;
import grupo12.utils.DocumentacionTableModel;
import grupo12.utils.OperacionesTableModel;

import javax.swing.*;
import java.awt.*;

public class FrmDocumentacion extends JDialog{
    private JPanel pnlPrincipal;
    private JTable tableDocumentacion;

    private DocumentacionController documentacionController = new DocumentacionController();
    private DocumentacionTableModel documentacionTableModel = new DocumentacionTableModel();
    public FrmDocumentacion(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tableDocumentacion.setModel(documentacionTableModel);

        

    }
}
