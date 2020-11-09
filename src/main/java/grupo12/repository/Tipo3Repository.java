package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Tipo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tipo3Repository {
    private JsonDB db;

    public Tipo3Repository(){
        db = new JsonDB("database\\Tipo3Table.db", Tipo3[].class);
    }

    public boolean save(Tipo3 nuevo){
        List<Tipo3> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Tipo3> getAll(){
        Tipo3[] array = (Tipo3[]) db.selectAll();
        return new ArrayList<Tipo3>(Arrays.asList(array));
    }
}
