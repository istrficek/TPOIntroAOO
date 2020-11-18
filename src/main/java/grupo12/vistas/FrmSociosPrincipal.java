package grupo12.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSociosPrincipal extends JDialog {

    private JPanel pnlPrincipal;
    private JButton listadoDeSociosButton;
    private JButton agregarDocumentacionButton;
    private JButton nuevoSocioButton;
    private JButton eliminarSocioButton;
    private FrmSociosPrincipal self;

    public FrmSociosPrincipal(Window owner, String titulo){
        super(owner, titulo);
        setContentPane(pnlPrincipal);

        this.setSize(500,500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.self = this;
        this.asociarEventos();

    }

    public void asociarEventos(){
        listadoDeSociosButton.addActionListener(e -> {
            FrmSocios frame = new FrmSocios(self, "Listado de socios");
            frame.setVisible(true);
        });

        nuevoSocioButton.addActionListener(e -> {
            FrmNuevoSocio frame = new FrmNuevoSocio(self, "Nuevo Socio");
            frame.setVisible(true);
        });

        agregarDocumentacionButton.addActionListener(e -> {
            FrmAgregarDocumentacion frame = new FrmAgregarDocumentacion(self, "Agregar Documentación");
            frame.setVisible(true);
        });
    }

}
