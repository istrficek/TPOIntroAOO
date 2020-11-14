package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.Participe;
import grupo12.entity.Protector;
import grupo12.entity.Socio;

import java.util.*;
import java.util.stream.Collectors;

public class SocioRepository {
    private JsonDB participeDb;
    private JsonDB protectorDb;

    public SocioRepository(){
        participeDb = new JsonDB("database\\SocioParticipeTable.db", Participe[].class);
        protectorDb = new JsonDB("database\\SocioProtectorTable.db", Protector[].class);
    }

    public boolean save(Protector nuevo){
        return save(nuevo, false);
    }

    public boolean save(Protector nuevo, boolean respetarId) {
        List<Protector> list = getAllProtector();
        Collections.sort(list, Comparator.comparingInt(Protector::getId).reversed());
        if(!respetarId)
            nuevo.setId(list.size() > 0 ? list.get(0).getId() + 1 : 0);
        list.add(nuevo);
        return protectorDb.insert(list);
    }

    public boolean save(Participe nuevo){
        return save(nuevo, false);
    }

    public boolean save(Participe nuevo, boolean respetarId) {
        List<Participe> list = getAllParticipe();
        Collections.sort(list, Comparator.comparingInt(Participe::getId).reversed());
        if(!respetarId)
            nuevo.setId(list.size() > 0 ? list.get(0).getId() + 1 : 0);
        list.add(nuevo);
        return participeDb.insert(list);
    }

    public List<Socio> getAll(){
        Protector[] arrayProtector = (Protector[]) protectorDb.selectAll();
        Participe[] arrayParticipe = (Participe[]) participeDb.selectAll();

        List<Socio> arraySocio = new ArrayList<>();

        arraySocio.addAll(Arrays.asList(arrayProtector));
        arraySocio.addAll(Arrays.asList(arrayParticipe));

        return arraySocio;
    }

    public List<Participe> getAllParticipe(){
        Participe[] array = (Participe[]) participeDb.selectAll();
        if(array == null)
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(array));
    }

    public List<Protector> getAllProtector(){
        Protector[] array = (Protector[]) protectorDb.selectAll();
        if(array == null)
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(array));
    }

    public Socio getById(int id) {
        List<Socio> list = getAll();
        list.stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());

        if(list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    /*
    public void deleteById(int id) {
        Protector[] array = (Protector[]) db.selectAll();
        List<Protector> list = new ArrayList<>(Arrays.asList(array));

        List<Protector> toDelete = list.stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());

        if(toDelete.size() > 0) {
            list.remove(toDelete.get(0));
            db.insert(list);
        }
    }

     */


}
