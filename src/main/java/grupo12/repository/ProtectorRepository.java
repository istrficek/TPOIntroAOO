package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Protector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProtectorRepository {
    private JsonDB db;

    public ProtectorRepository(){
        db = new JsonDB("database\\ProtectorTable.db", Protector[].class);
    }

    public boolean save(Protector nuevo){
        List<Protector> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Protector> getAll(){
        Protector[] array = (Protector[]) db.selectAll();
        return new ArrayList<Protector>(Arrays.asList(array));
    }
}
