package grupo12.vistas;

import grupo12.controllers.AccionistaController;
import grupo12.utils.AccionistasTableModel;

import javax.swing.*;
import java.awt.*;

public class FrmAccionistas extends JDialog {

    private JPanel pnlPrincipal;
    private JTable tableAccionistas;


    private AccionistaController accionistaController = new AccionistaController();

    private AccionistasTableModel accionistasTableModel = new AccionistasTableModel();

    public FrmAccionistas(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tableAccionistas.setModel(accionistasTableModel);

        accionistasTableModel.addLista(accionistaController.getAllAccionista());
    }

}
