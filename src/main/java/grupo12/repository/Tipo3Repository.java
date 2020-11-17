package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.entity.EstadoOperacion;
import grupo12.entity.Tipo2;
import grupo12.entity.Tipo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Tipo3Repository {
    private JsonDB db;

    public Tipo3Repository(){
        db = new JsonDB("database\\Tipo3Table.db", Tipo3[].class);
    }

    public boolean save(Tipo3 nuevo){
        List<Tipo3> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Tipo3> getAll(){
        Tipo3[] array = (Tipo3[]) db.selectAll();
        if(array == null)
            return new ArrayList<Tipo3>();
        return new ArrayList<Tipo3>(Arrays.asList(array));
    }

    public Float getByMontoT3(Integer id) {

        Tipo3[] array = (Tipo3[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo3> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0).getMonto();
        else
            return null;
    }

    public Float obtenerComision(Integer id) {

        Tipo3[] array = (Tipo3[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo3> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0).getComisionAlSocio();
        else
            return null;
    }

    public Tipo3 getById(Integer id) {
        Tipo3[] array = (Tipo3[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo3> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public void delete(Integer id) {
        Tipo3[] array = (Tipo3[]) db.selectAll();
        List<Tipo3> list = new ArrayList<>(Arrays.asList(array));

        List<Tipo3> toDelete = list.stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());

        if(toDelete.size() > 0) {
            list.remove(toDelete.get(0));
            db.insert(list);
        }
    }

    public EstadoOperacion getEstado(Integer id) {

        Tipo3[] array = (Tipo3[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo3> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0).getEstadoOperacion();
        else
            return null;
    }

    public Float getTasaDeDescuento(Integer id) {
        Tipo3[] array = (Tipo3[]) db.selectAll();
        if(array == null)
            return null;
        List<Tipo3> list = new ArrayList<>(Arrays.asList(array)).stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if(list.size() > 0)
            return list.get(0).getTasaDeDescuento();
        else
            return null;
    }


    public List<Tipo3> getEstadoOperacionDates(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin) {
        Tipo3[] array = (Tipo3[]) db.selectAll();
        List<Tipo3> array2 = new ArrayList<Tipo3>();
        for(Tipo3 t : array){
            if (t.getEstadoOperacion() == estadoOperacion && t.getFecha().after(fechaInicio) && t.getFecha().before(fechaFin)){
                array2.add(t);

            }
        }
        if(array2 == null)
            return new ArrayList<Tipo3>();
        return array2;
    }
}
