package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.Aporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AporteRepository {
    private JsonDB db;

    public AporteRepository(){
        db = new JsonDB("database\\AporteTable.db", Aporte[].class);
    }

    public boolean save(Aporte nuevo){
        List<Aporte> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Aporte> getAll(){
        Aporte[] array = (Aporte[]) db.selectAll();
        return new ArrayList<Aporte>(Arrays.asList(array));
    }
}
