package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.data_access.SqLiteDB;
import grupo12.entity.EstadoOperacion;
import grupo12.entity.Tipo2;
import grupo12.entity.Tipo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Tipo3Repository {

    public boolean save(Tipo3 nuevo){
        return SqLiteDB.InsertOperacionTipo3(nuevo);
    }

    public List<Tipo3> getAll(){
        return SqLiteDB.ObtenerOperacionesTipo3();
    }

    public Float getByMontoT3(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo3PorID(id).getMonto();
    }

    public Float obtenerComision(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo3PorID(id).getComisionAlSocio();
    }

    public Tipo3 getById(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo3PorID(id);
    }

    public void delete(Integer id) {
        System.out.println("El delete no esta implementado!");
    }

    public EstadoOperacion getEstado(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo3PorID(id).getEstadoOperacion();
    }

    public Float getTasaDeDescuento(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo3PorID(id).getTasaDeDescuento();
    }


    public List<Tipo3> getEstadoOperacionDates(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin) {
        List<Tipo3> tipo3List = SqLiteDB.ObtenerOperacionesTipo3();
        return tipo3List.stream().filter(tipo3 -> tipo3.getEstadoOperacion() == estadoOperacion && tipo3.getFecha().after(fechaInicio) && tipo3.getFecha().before(fechaFin)).collect(Collectors.toList());
    }
}
