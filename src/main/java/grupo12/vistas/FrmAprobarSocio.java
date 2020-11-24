package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.entity.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class FrmAprobarSocio extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cmbSocios;
    private JButton hacerSocioPlenoButton;
    private JButton salirButton;
    private FrmAprobarSocio self;
    private SocioController socioController = new SocioController();
    private Socio socioSeleccionado;

    public FrmAprobarSocio(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,300);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Socio> socioList = socioController.obtenerSociosPostulantes();

        model.addElement("---Seleccionar---");

        for (Socio s: socioList) {
            model.addElement(s);
        }
        cmbSocios.setModel(model);

        asociarEventos();
    }

    private void asociarEventos() {
        hacerSocioPlenoButton.addActionListener(e -> {
            if(socioController.hacerSocioPleno(socioSeleccionado)){
                JOptionPane.showMessageDialog(this,"Socio Actualizado!.");
            }
            else {
                JOptionPane.showMessageDialog(this,"Error actualizando socio.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        salirButton.addActionListener(e -> {
            this.setVisible(false);
        });
        cmbSocios.addItemListener(e -> {
            socioSeleccionado = null;
            if(cmbSocios.getSelectedIndex() != 0)
                socioSeleccionado = (Socio) cmbSocios.getSelectedItem();
        });
    }
}
