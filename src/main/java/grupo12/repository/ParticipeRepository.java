package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Socio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipeRepository {
    private JsonDB db;

    public ParticipeRepository(){
        db = new JsonDB("database\\ParticipeTable.db", Socio[].class);
    }

    public boolean save(Socio nuevo){
        List<Socio> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Socio> getAll(){
        Socio[] array = (Socio[]) db.selectAll();
        if(array == null)
            return new ArrayList<Socio>();
        return new ArrayList<Socio>(Arrays.asList(array));
    }
}
