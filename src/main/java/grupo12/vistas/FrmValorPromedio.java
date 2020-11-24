package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.dto.PromedioTasaYTotal;
import grupo12.entity.TipoEmpresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrmValorPromedio extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cmbTipoEmpresa;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    private JLabel lblTasaDescuento;
    private JLabel lblTotalOperado;
    private JButton salirButton;
    private JButton calcularButton;
    private FrmValorPromedio self;
    private SocioController socioController = new SocioController();

    public FrmValorPromedio(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;
        this.asociarEventos();

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Pequenia");
        model.addElement("Mediana");
        model.addElement("Grande");

        cmbTipoEmpresa.setModel(model);

    }

    private void asociarEventos(){
        calcularButton.addActionListener(e -> {
            if(validarCampos()){
                PromedioTasaYTotal promedioTasaYTotal = new PromedioTasaYTotal();
                try {
                    promedioTasaYTotal = socioController.obtenerValorPromedioTasaDescuentoYTotalOperado(TipoEmpresa.valueOf((String)cmbTipoEmpresa.getSelectedItem()), new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaInicio.getText()), new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaFin.getText()) );
                    lblTasaDescuento.setText(promedioTasaYTotal.getPromedioTasaDecuento().toString());
                    lblTotalOperado.setText(promedioTasaYTotal.getPromedioTotalOperado().toString());

                } catch (Exception parseException) {
                    parseException.printStackTrace();
                }
            }

        });
        salirButton.addActionListener(e -> {
            this.setVisible(false);
        });
    }

    private boolean validarCampos(){
        boolean sinCamposVacios = cmbTipoEmpresa.getSelectedIndex() != 0
                && !txtFechaFin.getText().equals("")
                && !txtFechaInicio.getText().equals("");

        try {
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaInicio.getText());
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaFin.getText());
        } catch (ParseException e) {
            return false;
        }
        return sinCamposVacios;
    }
}
