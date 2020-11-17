package grupo12.utils;

import grupo12.entity.Protector;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProtectorTableModel extends AbstractTableModel {
    List<Protector> listaProtector = new ArrayList<>();

    protected String[] nombreColumnas = new String[] {"ID", "CUIT", "Razon Social", "Fecha Inicio", "Actividad Principal", "Direccion", "Telefono", "Email", "Estado", "Tipo de Empresa", "Saldo de Acciones", "Tipo de Socio"};
    protected Class[] claseColumna = new Class[] { Integer.class, String.class, String.class, Date.class, String.class,String.class,String.class,String.class,String.class,String.class,Integer.class, String.class};

    public String getColumnName(int col){return nombreColumnas[col];}

    public Class getColumnClass(int col) {return claseColumna[col];}



    @Override
    public int getRowCount() {
        return listaProtector.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return listaProtector.get(rowIndex).getId();
            case 1:
                return listaProtector.get(rowIndex).getCuit();
            case 2:
                return listaProtector.get(rowIndex).getRazonSocial();
            case 3:
                return listaProtector.get(rowIndex).getFechaInicio();
            case 4:
                return listaProtector.get(rowIndex).getActividadPrincipal();
            case 5:
                return listaProtector.get(rowIndex).getDireccion();
            case 6:
                return listaProtector.get(rowIndex).getTelefono();
            case 7:
                return listaProtector.get(rowIndex).getEmail();
            case 8:
                return listaProtector.get(rowIndex).getEstadoSocio().name();
            case 9:
                return listaProtector.get(rowIndex).getTipoEmpresa().name();
            case 10:
                return listaProtector.get(rowIndex).getSaldoAcciones();
            case 11:
                return listaProtector.get(rowIndex).getTipoSocio().name();
            default:
                return null;
        }
    }

    public int addLista(List<Protector> lista){
        this.listaProtector = lista;
        fireTableDataChanged();
        return lista.size() -1;
    }
}
