package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccionistaRepository {
    private JsonDB db;

    public AccionistaRepository(){
        db = new JsonDB("database\\AccionistaTable.db", Accionista[].class);
    }

    public boolean save(Accionista nuevo){
        List<Accionista> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Accionista> getAll(){
        Accionista[] array = (Accionista[]) db.selectAll();
        return new ArrayList<Accionista>(Arrays.asList(array));
    }
}
