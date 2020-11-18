package grupo12.vistas;

import grupo12.controllers.DocumentacionController;
import grupo12.controllers.SocioController;
import grupo12.entity.Documentacion;
import grupo12.entity.EstadoDocumento;
import grupo12.entity.Socio;
import grupo12.entity.TipoDocumento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrmAgregarDocumentacion extends JDialog{
    private JPanel pnlPrincipal;
    private JComboBox cmbSocios;
    private JComboBox cmbTipoDocuemento;
    private JComboBox cmbEstadoDocumento;
    private JComboBox cmbEsObligatorio;
    private JButton guardarButton;
    private JButton cancelarButton;
    private SocioController socioController = new SocioController();
    private DocumentacionController documentacionController = new DocumentacionController();
    private FrmAgregarDocumentacion self;
    private Socio socioSeleccionado;

    public FrmAgregarDocumentacion(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(700,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;
        this.asociarEventos();

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Si");
        model.addElement("No");
        cmbEsObligatorio.setModel(model);

        model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Ingresado");
        model.addElement("Controlado");
        model.addElement("Rechazado");
        cmbEstadoDocumento.setModel(model);

        model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("tipo1");
        model.addElement("tipo2");
        model.addElement("tipo3");
        cmbTipoDocuemento.setModel(model);

        model = new DefaultComboBoxModel();
        List<Socio> socioList = socioController.obtenerSocios();

        model.addElement("---Seleccionar---");

        for (Socio s: socioList) {
            model.addElement(s);
        }
        cmbSocios.setModel(model);

    }

    private void asociarEventos() {
        guardarButton.addActionListener(e -> {
            if(validarCampos()){
                if(documentacionController.crearDocumentacion(socioSeleccionado.getId() ,new Documentacion(){{
                    setUsuario("Ivo");
                    setFechaRecepcion(new Date());
                    setTipoDocumento(TipoDocumento.valueOf(cmbTipoDocuemento.getSelectedItem().toString()));
                    setIsObligatorio(cmbEsObligatorio.getSelectedItem().toString() == "Si");
                    setEstadoDoc(EstadoDocumento.valueOf(cmbEstadoDocumento.getSelectedItem().toString()));
                }}))
                {
                    JOptionPane.showMessageDialog(this,"Nueva documentacion guardada!.");
                    this.setVisible(false);
                } else  {
                    JOptionPane.showMessageDialog(this, "Error guardando documentacion.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,"Completar TODOS los campos!.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        cancelarButton.addActionListener(e -> {
            this.setVisible(false);
        });

        cmbSocios.addItemListener(e -> {
            socioSeleccionado = (Socio)cmbSocios.getSelectedItem();
        });
    }

    private boolean validarCampos(){
        return cmbSocios.getSelectedIndex() != 0
                && cmbTipoDocuemento.getSelectedIndex() != 0
                && cmbEstadoDocumento.getSelectedIndex() != 0
                && cmbEsObligatorio.getSelectedIndex() != 0;
    }
}
