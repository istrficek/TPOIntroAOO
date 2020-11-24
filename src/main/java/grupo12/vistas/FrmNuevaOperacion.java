package grupo12.vistas;

import grupo12.controllers.OperacionController;
import grupo12.controllers.SocioController;
import grupo12.entity.*;
import grupo12.request.OperacionRequest;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FrmNuevaOperacion extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cmbTipoOperacion;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField txtTasaDeDescuento;
    private JTextField txtComisionAlSocio;
    private JTextField txtMonto;
    private JPanel panelTipo1;
    private JPanel panelTipo2;
    private JPanel panelTipo3;
    private JTextField txtBanco;
    private JTextField txtNumeroCheque;
    private JTextField txtFechaVencimientoT1;
    private JTextField txtCUIT;
    private JTextField txtEmpresaCuentaCorriente;
    private JTextField txtFechaVencimientoT2;
    private JTextField txtBancoT3;
    private JTextField txtFechaActualizacion;
    private JTextField txtTasa;
    private FrmNuevaOperacion self;
    private JComboBox cmbSistema;
    private JComboBox cmbSocios;
    private SocioController socioController = new SocioController();
    private OperacionController operacionController = new OperacionController();
    private Socio socioSeleccionado;


    public FrmNuevaOperacion(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Tipo1");
        model.addElement("Tipo2");
        model.addElement("Tipo3");

        cmbTipoOperacion.setModel(model);

        model = new DefaultComboBoxModel();
        model.addElement("---Seleccionar---");
        model.addElement("Frances");
        model.addElement("Aleman");
        model.addElement("Americano");

        cmbSistema.setModel(model);

        model = new DefaultComboBoxModel();
        List<Socio> socioList = socioController.obtenerSocios();

        model.addElement("---Seleccionar---");

        for (Socio s: socioList) {
            model.addElement(s);
        }
        cmbSocios.setModel(model);

        panelTipo1.setVisible(false);
        panelTipo2.setVisible(false);
        panelTipo3.setVisible(false);

        asociarEventos();
    }

    private void asociarEventos(){
        cmbTipoOperacion.addItemListener(e -> {
            switch (cmbTipoOperacion.getSelectedItem().toString()){
                case "Tipo1":
                    panelTipo1.setVisible(true);
                    panelTipo2.setVisible(false);
                    panelTipo3.setVisible(false);
                    break;
                case "Tipo2":
                    panelTipo1.setVisible(false);
                    panelTipo2.setVisible(true);
                    panelTipo3.setVisible(false);
                    break;
                case "Tipo3":
                    panelTipo1.setVisible(false);
                    panelTipo2.setVisible(false);
                    panelTipo3.setVisible(true);
                    break;
                default:
                    panelTipo1.setVisible(false);
                    panelTipo2.setVisible(false);
                    panelTipo3.setVisible(false);
                    break;
            }

        });
        guardarButton.addActionListener(e -> {
            boolean result;
            if(validarCampos()){
                switch (cmbTipoOperacion.getSelectedItem().toString()){
                    case "Tipo1":
                       result = operacionController.crearOperacion(new OperacionRequest(){{
                            setEstadoOperacion(EstadoOperacion.Ingresado);
                            setTipoDeOperacion(TipoDeOperacion.Tipo1);
                            setTasaDeDescuento(new Float(txtTasaDeDescuento.getText()));
                            setComisionAlSocio(new Float(txtComisionAlSocio.getText()));
                            setEstadoComision(EstadoComision.Calculada);
                            setMonto(new Float(txtMonto.getText()));
                            setFecha(new Date());
                            setTipoOpe(1);
                            setBanco(txtBanco.getText());
                            setNroCheques(new Long(txtNumeroCheque.getText()));
                            try {
                                setFechaVencimiento(new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaVencimientoT1.getText()));
                            } catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                            setCuitFirmante(txtCUIT.getText());
                        }}, socioSeleccionado.getId());
                        break;
                    case "Tipo2":
                        result = operacionController.crearOperacion(new OperacionRequest(){{
                            setEstadoOperacion(EstadoOperacion.Ingresado);
                            setTipoDeOperacion(TipoDeOperacion.Tipo2);
                            setTasaDeDescuento(new Float(txtTasaDeDescuento.getText()));
                            setComisionAlSocio(new Float(txtComisionAlSocio.getText()));
                            setEstadoComision(EstadoComision.Calculada);
                            setMonto(new Float(txtMonto.getText()));
                            setFecha(new Date());
                            setTipoOpe(2);
                            setEmpresaCuentaCorriente(txtEmpresaCuentaCorriente.getText());
                            try {
                                setFechaVencimiento(new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaVencimientoT2.getText()));
                            } catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                        }}, socioSeleccionado.getId());
                        break;
                    case "Tipo3":
                        result = operacionController.crearOperacion(new OperacionRequest(){{
                            setEstadoOperacion(EstadoOperacion.Ingresado);
                            setTipoDeOperacion(TipoDeOperacion.Tipo3);
                            setTasaDeDescuento(new Float(txtTasaDeDescuento.getText()));
                            setComisionAlSocio(new Float(txtComisionAlSocio.getText()));
                            setEstadoComision(EstadoComision.Calculada);
                            setMonto(new Float(txtMonto.getText()));
                            setFecha(new Date());
                            setTipoOpe(3);
                            setBanco(txtBancoT3.getText());
                            try {
                                setFechaActualizacion(new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaActualizacion.getText()));
                            } catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                            setTasa(new Integer(txtTasa.getText()));
                            setCantidadDeCuotas(12);
                            setSistema(Sistema.valueOf((String)cmbSistema.getSelectedItem()));

                        }}, socioSeleccionado.getId());
                        break;
                    default:
                        result = false;
                        break;
                }
                if(result){
                    JOptionPane.showMessageDialog(this,"Nueva Operacion guardada!.");
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Error guardando operacion.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Completar TODOS los campos!.", "Error", JOptionPane.ERROR_MESSAGE);
            }


        });
        cmbSocios.addItemListener(e -> {
            socioSeleccionado = (Socio)cmbSocios.getSelectedItem();
        });
    }

    private boolean validarCampos(){
        switch (cmbTipoOperacion.getSelectedItem().toString()){
            case "Tipo1":
                return !txtTasaDeDescuento.getText().equals("")
                        && !txtComisionAlSocio.getText().equals("")
                        && !txtMonto.getText().equals("")
                        && !txtBanco.getText().equals("")
                        && !txtNumeroCheque.getText().equals("")
                        && !txtFechaVencimientoT1.getText().equals("")
                        && !txtCUIT.getText().equals("")
                        && cmbSocios.getSelectedIndex() != 0;
            case "Tipo2":
                return !txtTasaDeDescuento.getText().equals("")
                        && !txtComisionAlSocio.getText().equals("")
                        && !txtMonto.getText().equals("")
                        && !txtEmpresaCuentaCorriente.getText().equals("")
                        && !txtFechaVencimientoT2.getText().equals("")
                        && cmbSocios.getSelectedIndex() != 0;
            case "Tipo3":
                return !txtTasaDeDescuento.getText().equals("")
                        && !txtComisionAlSocio.getText().equals("")
                        && !txtMonto.getText().equals("")
                        && !txtBancoT3.getText().equals("")
                        && !txtFechaActualizacion.getText().equals("")
                        && !txtTasa.getText().equals("")
                        && cmbSistema.getSelectedIndex() != 0
                        && cmbSocios.getSelectedIndex() != 0;
            default:
                return false;
        }
    }
}
