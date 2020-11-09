package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.LineaDeCredito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineaDeCreditoRepository {
    private JsonDB db;

    public LineaDeCreditoRepository(){
        db = new JsonDB("database\\LineaCreditoTable.db", LineaDeCredito[].class);
    }

    public boolean save(LineaDeCredito nuevo){
        List<LineaDeCredito> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<LineaDeCredito> getAll(){
        LineaDeCredito[] array = (LineaDeCredito[]) db.selectAll();
        if(array == null)
            return new ArrayList<LineaDeCredito>();
        return new ArrayList<LineaDeCredito>(Arrays.asList(array));
    }
}
