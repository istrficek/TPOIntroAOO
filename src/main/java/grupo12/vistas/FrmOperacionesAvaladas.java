package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.entity.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FrmOperacionesAvaladas extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cmbSocios;
    private JFormattedTextField fechaDesde;
    private JButton buscarOperacionesButton;
    private JFormattedTextField fechaHasta;
    private SocioController socioController = new SocioController();
    public FrmOperacionesAvaladas(Window owner, String titulo) throws ParseException {
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(600, 150);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        model = new DefaultComboBoxModel();
        List<Socio> socioList = socioController.obtenerSocios();




        model.addElement("---Seleccionar---");

        for (Socio s: socioList) {
            model.addElement(s);
        }
        cmbSocios.setModel(model);
        buscarOperacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date fechaD = null;
                try {
                    fechaD = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDesde.getText());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                Date fechaH = null;
                try {
                    fechaH = new SimpleDateFormat("dd/MM/yyyy").parse(fechaHasta.getText());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                Socio socio = (Socio) cmbSocios.getSelectedItem();
                FrmListaOperacionesAval frame = new FrmListaOperacionesAval(socio.getId(),fechaD, fechaH);
                frame.setVisible(true);
            }
        });
    }
}