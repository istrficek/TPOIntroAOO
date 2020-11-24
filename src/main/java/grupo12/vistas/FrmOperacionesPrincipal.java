package grupo12.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmOperacionesPrincipal extends JDialog{
    private JButton listadoDeOperacionesButton;
    private JButton consultasButton;
    private JButton nuevaOperacionButton;
    private JButton eliminarOperacionButton;
    private JPanel pnlPrincipal;
    private FrmOperacionesPrincipal self;

    public FrmOperacionesPrincipal(Window owner, String titulo) {
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;

        asociarEventos();


    }

    private void asociarEventos() {
        listadoDeOperacionesButton.addActionListener(e -> {
            FrmOperaciones frmOperaciones = new FrmOperaciones(self, "Listado de Operaciones");
            frmOperaciones.setVisible(true);
        });
        nuevaOperacionButton.addActionListener(e -> {
            FrmNuevaOperacion frmNuevaOperacion = new FrmNuevaOperacion(self, "Nueva Operacion");
            frmNuevaOperacion.setVisible(true);
        });
        consultasButton.addActionListener(e -> {
            FrmConsultasOperacion frmConsultas = new FrmConsultasOperacion(self, "Consultas");
            frmConsultas.setVisible(true);

        });
    }
}
