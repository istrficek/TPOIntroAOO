package grupo12.vistas;

import javax.swing.*;
import java.awt.*;

public class FrmConsultasOperacion extends JDialog {
    private FrmConsultasOperacion self;
    private JButton generarCertificadoGarantiaButton;
    private JButton validarChequesDelMismoButton;
    private JButton calcularComisionButton;
    private JButton validarOperacionButton;
    private JPanel Principal;

    public FrmConsultasOperacion(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(Principal);

        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;
    }
}
