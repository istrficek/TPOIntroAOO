package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.entity.Socio;
import grupo12.entity.TipoDeOperacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class FrmComisionPorTipoOperacion extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cmbSocios;
    private JComboBox cmbTipoOperacion;
    private JButton calcularButton;
    private JButton salirButton;
    private JLabel lblComision;
    private FrmComisionPorTipoOperacion self;
    private SocioController socioController = new SocioController();
    private Socio socioSeleccionado;

    public FrmComisionPorTipoOperacion(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,250);
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

        model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Tipo1");
        model.addElement("Tipo2");
        model.addElement("Tipo3");

        cmbTipoOperacion.setModel(model);

        asociarEventos();

    }

    private void asociarEventos() {
        calcularButton.addActionListener(e -> {
            if(validarCampos()){
                Float comision = socioController.obtenerComisionPorTipoDeOperacion(TipoDeOperacion.valueOf((String)cmbTipoOperacion.getSelectedItem()), socioSeleccionado);
                lblComision.setText(comision.toString());
            }

        });
        cmbSocios.addItemListener(e -> {
            if(cmbSocios.getSelectedIndex() == 0)
                socioSeleccionado = null;
            else
                socioSeleccionado = (Socio)cmbSocios.getSelectedItem();
        });
        salirButton.addActionListener(e -> {
            this.setVisible(false);
        });
    }

    private boolean validarCampos(){
        return socioSeleccionado != null
                && cmbTipoOperacion.getSelectedIndex() != 0;
    }


}
