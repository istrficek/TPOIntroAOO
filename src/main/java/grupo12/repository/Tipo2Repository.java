package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.Tipo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tipo2Repository {
    private JsonDB db;

    public Tipo2Repository(){
        db = new JsonDB("database\\Tipo2Table.db", Tipo2[].class);
    }

    public boolean save(Tipo2 nuevo){
        List<Tipo2> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Tipo2> getAll(){
        Tipo2[] array = (Tipo2[]) db.selectAll();
        return new ArrayList<Tipo2>(Arrays.asList(array));
    }
}
