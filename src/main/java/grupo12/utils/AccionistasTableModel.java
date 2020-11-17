package grupo12.utils;

import grupo12.entity.Accionista;
import grupo12.request.OperacionRequest;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccionistasTableModel extends AbstractTableModel {


    List<Accionista> listaAccionistas = new ArrayList<>();

    protected String[] nombreColumnas = new String[] {"ID", "RazonSocial",  "Porcentaje de Participacion"};
    protected Class[] claseColumna = new Class[] { Integer.class, String.class, Float.class};

    public String getColumnName(int col){return nombreColumnas[col];}

    public Class getColumnClass(int col) {return claseColumna[col];}



    @Override
    public int getRowCount() {
        return listaAccionistas.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return listaAccionistas.get(rowIndex).getId();
            case 1:
                return listaAccionistas.get(rowIndex).getRazonSocial();
            case 2:
                return listaAccionistas.get(rowIndex).getPorcentajedeParticipacion();
            default:
                return null;
        }
    }

    public int addLista(List<Accionista> lista){
        this.listaAccionistas = lista;
        fireTableDataChanged();
        return lista.size() -1;
    }
}