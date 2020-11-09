package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.Operacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperacionRepository {
    private JsonDB db;

    public OperacionRepository(){
        db = new JsonDB("database\\OperacionTable.db", Operacion[].class);
    }

    public boolean save(Operacion nuevo){
        List<Operacion> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Operacion> getAll(){
        Operacion[] array = (Operacion[]) db.selectAll();
        return new ArrayList<Operacion>(Arrays.asList(array));
    }
}
