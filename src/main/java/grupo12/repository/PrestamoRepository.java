package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Prestamo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrestamoRepository {
    private JsonDB db;

    public PrestamoRepository(){
        db = new JsonDB("database\\PrestamoTable.db", Prestamo[].class);
    }

    public boolean save(Prestamo nuevo){
        List<Prestamo> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Prestamo> getAll(){
        Prestamo[] array = (Prestamo[]) db.selectAll();
        return new ArrayList<Prestamo>(Arrays.asList(array));
    }
}
