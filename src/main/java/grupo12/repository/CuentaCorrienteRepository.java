package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.CuentaCorriente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CuentaCorrienteRepository {
    private JsonDB db;

    public CuentaCorrienteRepository(){
        db = new JsonDB("database\\CuentaCorrienteTable.db", CuentaCorriente[].class);
    }

    public boolean save(CuentaCorriente nuevo){
        List<CuentaCorriente> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<CuentaCorriente> getAll(){
        CuentaCorriente[] array = (CuentaCorriente[]) db.selectAll();
        return new ArrayList<CuentaCorriente>(Arrays.asList(array));
    }
}
