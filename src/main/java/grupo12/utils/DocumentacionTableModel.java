package grupo12.utils;

import grupo12.entity.Documentacion;
import grupo12.request.OperacionRequest;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentacionTableModel extends AbstractTableModel {


    List<Documentacion> listaDocumentacion = new ArrayList<>();

    protected String[] nombreColumnas = new String[] {"ID", "Estado Documento",  "Es Obligatorio", "Tipo de Documento"};
    protected Class[] claseColumna = new Class[] { Integer.class, String.class, boolean.class, String.class};

    public String getColumnName(int col){return nombreColumnas[col];}

    public Class getColumnClass(int col) {return claseColumna[col];}



    @Override
    public int getRowCount() {
        return listaDocumentacion.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return listaDocumentacion.get(rowIndex).getId();
            case 1:
                return listaDocumentacion.get(rowIndex).getEstadoDoc().name();
            case 2:
                return listaDocumentacion.get(rowIndex).getIsObligatorio();
            case 3:
                return listaDocumentacion.get(rowIndex).getTipoDocumento().name();
            default:
                return null;
        }
    }

    public int addLista(List<Documentacion> lista){
        this.listaDocumentacion = lista;
        fireTableDataChanged();
        return lista.size() -1;
    }
}