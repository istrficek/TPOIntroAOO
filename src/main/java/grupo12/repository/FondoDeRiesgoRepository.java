package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.CertificadoDeGarantia;
import grupo12.entity.FondoDeRiesgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FondoDeRiesgoRepository {

    private JsonDB db;

    public FondoDeRiesgoRepository(){
        db = new JsonDB("database\\FondoDeRiesgoTable.db", CertificadoDeGarantia[].class);
    }

    public boolean save(FondoDeRiesgo nuevo){
        List<FondoDeRiesgo> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<FondoDeRiesgo> getAll(){
        FondoDeRiesgo[] array = (FondoDeRiesgo[]) db.selectAll();
        if(array == null)
            return new ArrayList<FondoDeRiesgo>();
        return new ArrayList<FondoDeRiesgo>(Arrays.asList(array));
    }

    public FondoDeRiesgo getById(Integer id) {
        FondoDeRiesgo[] array = (FondoDeRiesgo[]) db.selectAll();
        if(array == null)
            return null;
        List<FondoDeRiesgo> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0);
        else
            return null;

    }


}
