package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.entity.Participe;
import grupo12.entity.Protector;
import grupo12.utils.ParticipeTableModel;
import grupo12.utils.ProtectorTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrmSocios  extends JDialog {
    private JPanel panel1;
    private JPanel pnlPrincipal;
    private JTabbedPane tabbedPane1;
    private JTable tableProtectores;
    private JTable tableParticipes;
    private SocioController socioController = new SocioController();

    private ProtectorTableModel protectorTableModel = new ProtectorTableModel();
    private ParticipeTableModel participeTableModel = new ParticipeTableModel();

    public FrmSocios(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(1000,1000);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tableProtectores.setModel(protectorTableModel);
        tableParticipes.setModel(participeTableModel);

        protectorTableModel.addLista(socioController.obtenerSociosProtectores());
        participeTableModel.addLista(socioController.obtenerSociosParticipes());


    }
}
