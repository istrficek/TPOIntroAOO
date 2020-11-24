package grupo12.vistas;

import grupo12.controllers.OperacionController;
import grupo12.entity.*;
import grupo12.request.OperacionRequest;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class FrmComisionesCalculadas extends JDialog {
    private FrmComisionesCalculadas self;
    private JPanel Principal;
    private JComboBox cmbOperaciones;
    private JPanel panelTipo1;
    private JButton enviarButton;
    private JComboBox cmbTipoOperacion;
    private JTextField vencimientoTxt;
    private OperacionController operacionController = new OperacionController();

    public FrmComisionesCalculadas(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(Principal);

        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;


        asociarEventos();
        
    }

    private void asociarEventos(){

        enviarButton.addActionListener(e -> {
            Float result= null;
            try {
                result = operacionController.comisionesChequesCalculadas(

                    new SimpleDateFormat("dd/MM/yyyy").parse(vencimientoTxt.getText())
                );
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            if(result != null){
                JOptionPane.showMessageDialog(this,"La comision del dia es: "+ result);
                this.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(this, "Error al realizar consulta.", "Error", JOptionPane.ERROR_MESSAGE);
            }



        });
    }



}
