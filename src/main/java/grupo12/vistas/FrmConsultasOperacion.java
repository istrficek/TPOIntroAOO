package grupo12.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmConsultasOperacion extends JDialog {
    private FrmConsultasOperacion self;
    private JButton comisionesCalculadasButton;
    private JButton validarChequesDelMismoButton;
    private JButton operacionesAvaladasButton;
    private JButton validarOperacionButton;
    private JPanel Principal;
    private JButton calcularValorPromedioButton;
    private JButton comisionPorTipoDeButton;

    public FrmConsultasOperacion(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(Principal);

        this.setSize(700, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;

        asociarEventos();

    }

    private void asociarEventos() {
        comisionesCalculadasButton.addActionListener(e -> {
            FrmComisionesCalculadas frmComisionesCalculadas = new FrmComisionesCalculadas(self, "Comisiones Calculadas");
            frmComisionesCalculadas.setVisible(true);
        });
        operacionesAvaladasButton.addActionListener(e -> {
            FrmNuevaOperacion frmNuevaOperacion = new FrmNuevaOperacion(self, "Operaciones Avaladas");
            frmNuevaOperacion.setVisible(true);
        });
        validarChequesDelMismoButton.addActionListener(e -> {
            FrmConsultasOperacion frmConsultas = new FrmConsultasOperacion(self, "Validar Cheques Del Mismo Firmante");
            frmConsultas.setVisible(true);

        });
        validarOperacionButton.addActionListener(e -> {
            FrmConsultasOperacion frmConsultas = new FrmConsultasOperacion(self, "Validar Operacion");
            frmConsultas.setVisible(true);

        });
        calcularValorPromedioButton.addActionListener(e -> {
            FrmValorPromedio frmValorPromedio = new FrmValorPromedio(self, "Calcular Valor Promedio");
            frmValorPromedio.setVisible(true);

        });
        comisionPorTipoDeButton.addActionListener(e -> {
            FrmComisionPorTipoOperacion frmComisionPorTipoOperacion = new FrmComisionPorTipoOperacion(self, "Comision por Tipo de Operacion");
            frmComisionPorTipoOperacion.setVisible(true);

        });
    }

}
