package grupo12.vistas;

import grupo12.controllers.OperacionController;
import grupo12.entity.Socio;
import grupo12.request.OperacionRequest;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.List;


public class FrmComisionesCalculadas extends JDialog {
    private FrmComisionesCalculadas self;
    private JPanel Principal;
    private JComboBox cmbOperaciones;
    private JPanel panelTipo1;
    private JButton enviarButton;
    private JComboBox cmbTipoOperacion;
    private JFormattedTextField vencimientoTxt;
    private OperacionController operacionController = new OperacionController();

    public FrmComisionesCalculadas(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(Principal);

        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;

        try {
            MaskFormatter maskFormatter = new MaskFormatter("##/##/##");
            vencimientoTxt = new JFormattedTextField(maskFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
            e.printStackTrace();
        }


        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<OperacionRequest> opList = operacionController.obtenerTodasLasOperaciones();

        model.addElement("---Seleccionar---");

        for (OperacionRequest s: opList) {
            model.addElement(s);
        }
        cmbOperaciones.setModel(model);

        
    }



    /*
     public FrmNuevaOperacion(Window owner, String titulo){


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
            if(validarCampos()){
                switch (cmbTipoOperacion.getSelectedItem().toString()){
                    case "Tipo1":
                        operacionController.crearOperacion(new OperacionRequest(){{
                            setEstadoOperacion(EstadoOperacion.Ingresado);
                            setTipoDeOperacion(TipoDeOperacion.Tipo1);
                            setTasaDeDescuento(new Float(txtTasaDeDescuento.getText()));
                            setComisionAlSocio(new Float(txtComisionAlSocio.getText()));
                            setMonto(new Float(txtMonto.getText()));
                            setFecha(new Date());
                            setTipoOpe(1);
                            setBanco(txtBanco.getText());
                            setNroCheques(new Long(txtNumeroCheque.getText()));
                            setFechaVencimiento(new Date(txtFechaVencimientoT1.getText()));
                            setCuitFirmante(txtCUIT.getText());
                        }}, socioSeleccionado.getId());
                        break;
                    case "Tipo2":
                        operacionController.crearOperacion(new OperacionRequest(){{
                            setEstadoOperacion(EstadoOperacion.Ingresado);
                            setTipoDeOperacion(TipoDeOperacion.Tipo2);
                            setTasaDeDescuento(new Float(txtTasaDeDescuento.getText()));
                            setComisionAlSocio(new Float(txtComisionAlSocio.getText()));
                            setMonto(new Float(txtMonto.getText()));
                            setFecha(new Date());
                            setTipoOpe(2);
                            setEmpresaCuentaCorriente(txtEmpresaCuentaCorriente.getText());
                            setFechaVencimiento(new Date(txtFechaVencimientoT2.getText()));
                        }}, socioSeleccionado.getId());
                        break;
                    case "Tipo3":
                        operacionController.crearOperacion(new OperacionRequest(){{
                            setEstadoOperacion(EstadoOperacion.Ingresado);
                            setTipoDeOperacion(TipoDeOperacion.Tipo3);
                            setTasaDeDescuento(new Float(txtTasaDeDescuento.getText()));
                            setComisionAlSocio(new Float(txtComisionAlSocio.getText()));
                            setMonto(new Float(txtMonto.getText()));
                            setFecha(new Date());
                            setTipoOpe(3);
                            //TODO Terminar los set de TIPO 3

                        }}, socioSeleccionado.getId());
                        break;
                    default:
                        break;
                }
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
                        && txtFechaVencimientoT1.isEditValid()
                        && !txtCUIT.getText().equals("")
                        && cmbSocios.getSelectedIndex() != 0;
            case "Tipo2":
                return !txtTasaDeDescuento.getText().equals("")
                        && !txtComisionAlSocio.getText().equals("")
                        && !txtMonto.getText().equals("")
                        && !txtEmpresaCuentaCorriente.getText().equals("")
                        && txtFechaVencimientoT2.isEditValid()
                        && cmbSocios.getSelectedIndex() != 0;
            case "Tipo3":
                return !txtTasaDeDescuento.getText().equals("")
                        && !txtComisionAlSocio.getText().equals("")
                        && !txtMonto.getText().equals("")
                        && !txtBancoT3.getText().equals("")
                        && txtFechaActualizacion.isEditValid()
                        && !txtTasa.getText().equals("")
                        && cmbSistema.getSelectedIndex() != 0
                        && cmbSocios.getSelectedIndex() != 0;
            default:
                return false;
        }
    }
}
     */
}
