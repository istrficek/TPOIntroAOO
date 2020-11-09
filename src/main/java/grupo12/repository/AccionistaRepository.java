package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;

import java.util.*;
import java.util.stream.Collectors;

public class AccionistaRepository {
    private JsonDB db;

    public AccionistaRepository(){
        db = new JsonDB("database\\AccionistaTable.db", Accionista[].class);
    }

    public boolean save(Accionista nuevo){
        return save(nuevo, false);
    }

    public boolean save(Accionista nuevo, boolean respetarId) {
        List<Accionista> list = getAll();
        Collections.sort(list, Comparator.comparingInt(Accionista::getId).reversed());
        if(!respetarId)
            nuevo.setId(list.size() > 0 ? list.get(0).getId() + 1 : 0);
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Accionista> getAll(){
        Accionista[] array = (Accionista[]) db.selectAll();
        if(array == null)
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(array));
    }

    public Accionista getById(int id) {
        Accionista[] array = (Accionista[]) db.selectAll();
        if(array == null)
            return null;
        List<Accionista> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public void deleteById(int id) {
        Accionista[] array = (Accionista[]) db.selectAll();
        List<Accionista> list = new ArrayList<>(Arrays.asList(array));

        List<Accionista> toDelete = list.stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());

        if(toDelete.size() > 0) {
            list.remove(toDelete.get(0));
            db.insert(list);
        }
    }

    public Accionista edit(Accionista a) {
        deleteById(a.getId());
        save(a, true);
        return  a;
    }
}
