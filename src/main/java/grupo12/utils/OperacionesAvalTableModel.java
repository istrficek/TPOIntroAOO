package grupo12.utils;

import grupo12.entity.Operacion;
import grupo12.request.OperacionRequest;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperacionesAvalTableModel extends AbstractTableModel {


    List<OperacionRequest> listaOperaciones = new ArrayList<>();

    protected String[] nombreColumnas = new String[] {"ID", "EstadoOperacion",  "Tasa De Descuento", "Estado Comision", "Tipo De Operacion", "Monto", "Fecha",  "CerificadoDeGarantia"};
    protected Class[] claseColumna = new Class[] { Integer.class, String.class, Float.class, String.class,String.class,Float.class, Date.class,String.class};

    public String getColumnName(int col){return nombreColumnas[col];}

    public Class getColumnClass(int col) {return claseColumna[col];}



    @Override
    public int getRowCount() {
        return listaOperaciones.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return listaOperaciones.get(rowIndex).getId();
            case 1:
                return listaOperaciones.get(rowIndex).getEstadoOperacion().name();
            case 2:
                return listaOperaciones.get(rowIndex).getTasaDeDescuento();
            case 3:
                return listaOperaciones.get(rowIndex).getEstadoComision().name();
            case 4:
                return listaOperaciones.get(rowIndex).getTipoDeOperacion().name();
            case 5:
                return listaOperaciones.get(rowIndex).getMonto();
            case 6:
                return listaOperaciones.get(rowIndex).getFecha();
            case 7:
                return listaOperaciones.get(rowIndex).getCerificadoDeGarantia() == null ? "" : listaOperaciones.get(rowIndex).getCerificadoDeGarantia().getDescripcion();
            default:
                return null;
        }
    }

    public int addLista(List<OperacionRequest> lista){
        this.listaOperaciones = lista;
        fireTableDataChanged();
        return lista.size() -1;
    }
}