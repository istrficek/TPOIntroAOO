package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.Cheque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChequeRepository {
    private JsonDB db;

    public ChequeRepository(){
        db = new JsonDB("database\\ChequeTable.db", Cheque[].class);
    }

    public boolean save(Cheque nuevo){
        List<Cheque> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Cheque> getAll(){
        Cheque[] array = (Cheque[]) db.selectAll();
        return new ArrayList<Cheque>(Arrays.asList(array));
    }
}
