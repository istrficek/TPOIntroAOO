package grupo12.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class FrmConsultasOperacion extends JDialog {
    private FrmConsultasOperacion self;
    private JButton comisionesCalculadasButton;
    private JButton validarChequesDelMismoButton;
    private JButton operacionesAvaladasButton;
    private JButton generarCertificadoGarantiaButton;
    private JButton operacionesAvaladasMonetizadasButton;
    private JButton calcularComisionButton;
    private JButton validarOperacionButton;
    private JPanel Principal;
    private JButton calcularValorPromedioButton;
    private JButton comisionPorTipoDeButton;
    private JButton posicionConsolidadaButton;

    public FrmConsultasOperacion(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(Principal);

        this.setSize(700, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;
        operacionesAvaladasMonetizadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperacionesAvaladas frame = null;
                try {
                    frame = new FrmOperacionesAvaladas(self, "Operaciones Avaladas");
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                frame.setVisible(true);
            }
        });

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
        posicionConsolidadaButton.addActionListener(e -> {
            FrmPosicionConsolidada frmPosicionConsolidada = new FrmPosicionConsolidada(self, "Posicion Consolidada");
            frmPosicionConsolidada.setVisible(true);
        });
    }

}
