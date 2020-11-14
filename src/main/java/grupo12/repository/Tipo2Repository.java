package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
import grupo12.entity.Tipo1;
import grupo12.entity.Tipo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tipo2Repository {
    private JsonDB db;

    public Tipo2Repository(){
        db = new JsonDB("database\\Tipo2Table.db", Tipo2[].class);
    }

    public boolean save(Tipo2 nuevo){
        List<Tipo2> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Tipo2> getAll(){
        Tipo2[] array = (Tipo2[]) db.selectAll();
        if(array == null)
            return new ArrayList<Tipo2>();
        return new ArrayList<Tipo2>(Arrays.asList(array));
    }

    public Float getByMontoT2(Integer id) {

        Tipo2[] array = (Tipo2[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo2> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0).getMonto();
        else
            return null;
    }

    public Float obtenerComision(Integer id) {
        Tipo2[] array = (Tipo2[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo2> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0).getComisionAlSocio();
        else
            return null;
    }

    public Tipo2 getById(Integer id) {
        Tipo2[] array = (Tipo2[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo2> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
