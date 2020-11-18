package grupo12.vistas;

import grupo12.controllers.SocioController;
import grupo12.entity.Accionista;
import grupo12.entity.EstadoSocio;
import grupo12.entity.TipoEmpresa;
import grupo12.request.SocioRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrmNuevoSocio extends JDialog {
    private JPanel pnlPrincipal;
    private JButton guardarButton;
    private JTextField txtCuit;
    private JTextField txtRazonSocial;
    private JTextField txtActividadPrincipal;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtMail;
    private JComboBox cmbTipoEmpresa;
    private JComboBox cmbTipoSocio;
    private JButton cancelarButton;
    private FrmNuevoSocio self;
    private SocioController socioController = new SocioController();

    public FrmNuevoSocio(Window owner, String titulo){
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

        asociarEventos();
    }

    public void asociarEventos(){
        guardarButton.addActionListener(e -> {
            if(validarCampos()){
                boolean result = socioController.crearSocio(new SocioRequest(){{
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
                    JOptionPane.showMessageDialog(this,"Nuevo socio guardado!.");
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Error guardando socio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
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
