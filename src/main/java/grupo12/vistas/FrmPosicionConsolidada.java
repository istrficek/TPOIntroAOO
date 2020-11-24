package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.dto.PosicionConsolidada;
import grupo12.entity.Socio;
import grupo12.utils.OperacionesTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class FrmPosicionConsolidada extends JDialog {


    private JPanel pnlPrincipal;
    private JComboBox cmbSocios;
    private JButton obtenerButton;
    private JTable tblOperacionesMonetizadasNoVencidas;
    private JTable tblOperacionesConCertificadoEmitido;
    private JLabel lblRiesgoVivo;
    private JLabel lblTotalUtilizado;
    private JButton salirButton;
    private FrmPosicionConsolidada self;
    private SocioController socioController = new SocioController();
    private Socio socioSeleccionado;
    private OperacionesTableModel operacionesMonetizadasNoVencidasModel = new OperacionesTableModel();
    private OperacionesTableModel operacionesConCertificadoEmitidoModel = new OperacionesTableModel();

    public FrmPosicionConsolidada(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(900,700);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Socio> socioList = socioController.obtenerSocios();

        model.addElement("---Seleccionar---");

        for (Socio s: socioList) {
            model.addElement(s);
        }
        cmbSocios.setModel(model);

        asociarEventos();
    }

    private void asociarEventos() {
        cmbSocios.addItemListener(e -> {
            if(cmbSocios.getSelectedIndex() != 0)
            {
                socioSeleccionado = (Socio) cmbSocios.getSelectedItem();
            } else{
                socioSeleccionado = null;
            }
        });
        obtenerButton.addActionListener(e -> {
            if(validarCampos()){
                PosicionConsolidada posicionConsolidada = socioController.obtenerPosicionConsolidada(socioSeleccionado.getId());
                tblOperacionesConCertificadoEmitido.setModel(operacionesConCertificadoEmitidoModel);
                tblOperacionesMonetizadasNoVencidas.setModel(operacionesMonetizadasNoVencidasModel);

                operacionesConCertificadoEmitidoModel.addLista(posicionConsolidada.getOperacionesConCertificadoEmitido());
                operacionesMonetizadasNoVencidasModel.addLista(posicionConsolidada.getOperacionesMonetizadasNoVencidas());

                lblRiesgoVivo.setText(posicionConsolidada.getRiesgoVivo().toString());
                lblTotalUtilizado.setText(posicionConsolidada.getTotalUtilizado().toString());
            } else{
                JOptionPane.showMessageDialog(this,"Debe seleccionar el Socio!.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });
        salirButton.addActionListener(e -> {
            this.setVisible(false);
        });
    }

    private boolean validarCampos(){
        return socioSeleccionado != null;
    }
}
