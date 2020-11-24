package grupo12.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import grupo12.data_access.JsonDB;
import grupo12.data_access.SqLiteDB;
import grupo12.entity.EstadoOperacion;
import grupo12.entity.Tipo1;


public class Tipo1Repository {

	public Tipo1Repository(){
	}

	public boolean save(Tipo1 nuevo){
		return SqLiteDB.InsertOperacionTipo1(nuevo);
	}
	
	public List<Tipo1> getAll(){
		return SqLiteDB.ObtenerOperacionesTipo1();
	}

	public Float getMontoT1(Integer id) {
		return SqLiteDB.ObtenerOperacionTipo1PorID(id).getMonto();
	}

	public Float obtenerComision(Integer id) {
		return SqLiteDB.ObtenerOperacionTipo1PorID(id).getComisionAlSocio();
	}

	public Tipo1 getById(Integer id) {
		return SqLiteDB.ObtenerOperacionTipo1PorID(id);
	}

	public void delete(Integer id) {
		System.out.println("El delete no esta implementado!");
	}

    public EstadoOperacion getEstado(Integer id) {
		return SqLiteDB.ObtenerOperacionTipo1PorID(id).getEstadoOperacion();
    }

	public Float getTasaDeDescuento(Integer id) {
		return SqLiteDB.ObtenerOperacionTipo1PorID(id).getTasaDeDescuento();
	}

	public List<Tipo1> getEstadoOperacionDates(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin) {
		List<Tipo1> tipo1List = SqLiteDB.ObtenerOperacionesTipo1();
		return tipo1List.stream().filter(tipo1 -> tipo1.getEstadoOperacion() == estadoOperacion && tipo1.getFecha().after(fechaInicio) && tipo1.getFecha().before(fechaFin)).collect(Collectors.toList());
	}

    public List<Tipo1> getByFecha(Date fecha) {
		List<Tipo1> t1= SqLiteDB.ObtenerOperacionesTipo1();
		List<Tipo1> resultado = new ArrayList<Tipo1>();
		for (Tipo1 t: t1) {
			DateFormat readFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = readFormat.format(t.getFecha());
			String date2= readFormat.format(fecha);
			if(date.equals(date2)){
				resultado.add(t);
			}

		}
		return resultado;
    }
}
