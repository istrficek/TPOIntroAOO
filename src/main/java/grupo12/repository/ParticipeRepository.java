package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.Participe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipeRepository {
    private JsonDB db;

    public ParticipeRepository(){
        db = new JsonDB("database\\ParticipeTable.db", Participe[].class);
    }

    public boolean save(Participe nuevo){
        List<Participe> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Participe> getAll(){
        Participe[] array = (Participe[]) db.selectAll();
        if(array == null)
            return new ArrayList<Participe>();
        return new ArrayList<Participe>(Arrays.asList(array));
    }
}
