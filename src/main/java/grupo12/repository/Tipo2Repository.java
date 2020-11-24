package grupo12.repository;

import grupo12.data_access.SqLiteDB;
import grupo12.entity.EstadoOperacion;
import grupo12.entity.Tipo2;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Tipo2Repository {

    public boolean save(Tipo2 nuevo){
        return SqLiteDB.InsertOperacionTipo2(nuevo);
    }

    public List<Tipo2> getAll(){
        return SqLiteDB.ObtenerOperacionesTipo2();
    }

    public Float getByMontoT2(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo2PorID(id).getMonto();
    }

    public Float obtenerComision(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo2PorID(id).getComisionAlSocio();
    }

    public Tipo2 getById(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo2PorID(id);
    }

    public void delete(Integer id) {
        System.out.println("El delete no esta implementado!");
    }

    public EstadoOperacion getEstado(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo2PorID(id).getEstadoOperacion();
    }

    public Float getTasaDeDescuento(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo1PorID(id).getTasaDeDescuento();
    }

    public List<Tipo2> getEstadoOperacionDates(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin) {
        List<Tipo2> tipo2List = SqLiteDB.ObtenerOperacionesTipo2();
        return tipo2List.stream().filter(tipo2 -> tipo2.getEstadoOperacion() == estadoOperacion && tipo2.getFecha().after(fechaInicio) && tipo2.getFecha().before(fechaFin)).collect(Collectors.toList());
    }


}
