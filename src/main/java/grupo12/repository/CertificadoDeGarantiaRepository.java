package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.CertificadoDeGarantia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CertificadoDeGarantiaRepository {
    private JsonDB db;

    public CertificadoDeGarantiaRepository(){
        db = new JsonDB("database\\CertificadoGarantiaTable.db", CertificadoDeGarantia[].class);
    }

    public boolean save(CertificadoDeGarantia nuevo){
        List<CertificadoDeGarantia> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<CertificadoDeGarantia> getAll(){
        CertificadoDeGarantia[] array = (CertificadoDeGarantia[]) db.selectAll();
        if(array == null)
            return new ArrayList<CertificadoDeGarantia>();
        return new ArrayList<CertificadoDeGarantia>(Arrays.asList(array));
    }

    public CertificadoDeGarantia getById(Integer id) {
        CertificadoDeGarantia[] array = (CertificadoDeGarantia[]) db.selectAll();
        if(array == null)
            return null;
        List<CertificadoDeGarantia> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0);
        else
            return null;

    }
}
