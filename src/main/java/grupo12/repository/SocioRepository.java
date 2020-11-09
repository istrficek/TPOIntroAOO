package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Socio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocioRepository {
    private JsonDB db;

    public SocioRepository(){
        db = new JsonDB("database\\SocioTable.db", Socio[].class);
    }

    public boolean save(Socio nuevo){
        List<Socio> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Socio> getAll(){
        Socio[] array = (Socio[]) db.selectAll();
        return new ArrayList<Socio>(Arrays.asList(array));
    }
}
