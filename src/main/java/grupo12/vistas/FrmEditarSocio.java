package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.entity.EstadoSocio;
import grupo12.entity.Socio;
import grupo12.entity.TipoEmpresa;
import grupo12.request.SocioRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class FrmEditarSocio extends JDialog {
    private JTextField txtCuit;
    private JTextField txtRazonSocial;
    private JTextField txtActividadPrincipal;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtMail;
    private JComboBox cmbTipoEmpresa;
    private JComboBox cmbTipoSocio;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel pnlPrincipal;
    private FrmEditarSocio self;
    private Socio socio;
    private SocioController socioController = new SocioController();

    public FrmEditarSocio(Window owner, String titulo, int idSocio){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Pequenia");
        model.addElement("Mediana");
        model.addElement("Grande");
        cmbTipoEmpresa.setModel(model);

        model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Participe");
        model.addElement("Protector");
        cmbTipoSocio.setModel(model);

        socio = socioController.obtenerSocio(idSocio);

        asociarEventos();

        llenarCampos();

    }

    private void llenarCampos() {
        txtActividadPrincipal.setText(socio.getActividadPrincipal());
        txtCuit.setText(socio.getCuit());
        txtDireccion.setText(socio.getDireccion());
        txtMail.setText(socio.getEmail());
        txtRazonSocial.setText(socio.getRazonSocial());
        txtTelefono.setText(socio.getTelefono());
        cmbTipoEmpresa.setSelectedItem(socio.getTipoEmpresa().name());
        cmbTipoSocio.setSelectedItem(socio.getTipoSocio().name());
    }

    public void  asociarEventos(){
        guardarButton.addActionListener(e -> {
            if(validarCampos()) {
                boolean result = socioController.editarSocio(socio.getId(), new SocioRequest() {{
                    setTipoEmpresa(TipoEmpresa.valueOf(cmbTipoEmpresa.getSelectedItem().toString()));
                    setTelefono(txtTelefono.getText().trim());
                    setRazonSocial(txtRazonSocial.getText().trim());
                    setParticipe(cmbTipoSocio.getSelectedItem().equals("Participe"));
                    setFechaInicio(new Date());
                    setEstadoSocio(EstadoSocio.postulante);
                    setEmail(txtMail.getText().trim());
                    setDireccion(txtDireccion.getText().trim());
                    setCuit(txtCuit.getText().trim());
                    setActividadPrincipal(txtActividadPrincipal.getText().trim());
                    setSaldoAccionesTipo(0);
                    setAccionistas(new ArrayList<>());
                }});
                if(result){
                    JOptionPane.showMessageDialog(this,"Socio Editado!.");
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Error editando socio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,"Completar TODOS los campos!.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        cancelarButton.addActionListener(e -> {
            this.setVisible(false);
        });
    }

    public boolean validarCampos(){
        return !txtActividadPrincipal.getText().trim().equals("")
                && !txtCuit.getText().trim().equals("")
                && !txtDireccion.getText().trim().equals("")
                && !txtMail.getText().trim().equals("")
                && !txtRazonSocial.getText().trim().equals("")
                && !txtTelefono.getText().trim().equals("")
                && cmbTipoEmpresa.getSelectedIndex() != 0
                && cmbTipoSocio.getSelectedIndex() != 0;
    }
}
