package grupo12.vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal  extends JFrame {

    private JPanel pnlPrincipal;
    private JButton sociosButton;
    private JButton operacionesButton;
    private JButton accionistasButton;
    private JButton documentacionButton;
    private FrmPrincipal self;
    public FrmPrincipal(String titulo){
        super(titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.self = this;
        this.asociarEventos();



    }
    private void asociarEventos(){
        sociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmSociosPrincipal frame = new FrmSociosPrincipal(self, "Gestion de Socios");
                frame.setVisible(true);
            }
        });
        accionistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAccionistas frame = new FrmAccionistas(self, "Accionistas");
                frame.setVisible(true);

            }
        });
        operacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperaciones frame = new FrmOperaciones(self, "Operaciones");
                frame.setVisible(true);

            }
        });
        documentacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDocumentacion frame = new FrmDocumentacion(self, "Documentacion");
                frame.setVisible(true);


            }
        });
    }
}
