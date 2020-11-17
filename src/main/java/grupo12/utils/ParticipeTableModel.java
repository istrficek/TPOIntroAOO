package grupo12.utils;

import grupo12.entity.Participe;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParticipeTableModel extends AbstractTableModel {
    List<Participe> listaParticipe = new ArrayList<>();

    protected String[] nombreColumnas = new String[] {"ID", "CUIT", "Razon Social", "Fecha Inicio", "Actividad Principal", "Direccion", "Telefono", "Email", "Estado", "Tipo de Empresa", "Saldo de Acciones", "Tipo de Socio"};
    protected Class[] claseColumna = new Class[] { Integer.class, String.class, String.class, Date.class, String.class,String.class,String.class,String.class,String.class,String.class,Integer.class, String.class};

    public String getColumnName(int col){return nombreColumnas[col];}

    public Class getColumnClass(int col) {return claseColumna[col];}



    @Override
    public int getRowCount() {
        return listaParticipe.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return listaParticipe.get(rowIndex).getId();
            case 1:
                return listaParticipe.get(rowIndex).getCuit();
            case 2:
                return listaParticipe.get(rowIndex).getRazonSocial();
            case 3:
                return listaParticipe.get(rowIndex).getFechaInicio();
            case 4:
                return listaParticipe.get(rowIndex).getActividadPrincipal();
            case 5:
                return listaParticipe.get(rowIndex).getDireccion();
            case 6:
                return listaParticipe.get(rowIndex).getTelefono();
            case 7:
                return listaParticipe.get(rowIndex).getEmail();
            case 8:
                return listaParticipe.get(rowIndex).getEstadoSocio().name();
            case 9:
                return listaParticipe.get(rowIndex).getTipoEmpresa().name();
            case 10:
                return listaParticipe.get(rowIndex).getSaldoAcciones();
            case 11:
                return listaParticipe.get(rowIndex).getTipoSocio().name();
            default:
                return null;
        }
    }

    public int addLista(List<Participe> lista){
        this.listaParticipe = lista;
        fireTableDataChanged();
        return lista.size() -1;
    }
}
