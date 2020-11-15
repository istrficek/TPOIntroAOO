package grupo12.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import grupo12.data_access.JsonDB;
import grupo12.entity.EstadoOperacion;
import grupo12.entity.Tipo1;


public class Tipo1Repository {
	private JsonDB db;

	public Tipo1Repository(){
		db = new JsonDB("database\\Tipo1Table.db", Tipo1[].class);
	}

	public boolean save(Tipo1 nuevo){
		List<Tipo1> list = getAll();
		list.add(nuevo);
		return db.insert(list);
	}
	
	public List<Tipo1> getAll(){
		Tipo1[] array = (Tipo1[]) db.selectAll();
		if(array == null)
			return new ArrayList<Tipo1>();
		return new ArrayList<Tipo1>(Arrays.asList(array));
	}


	public Float getByMontoT1(Integer id) {

		Tipo1[] array = (Tipo1[]) db.selectAll();
		if(array == null)
			return null;
		List<Tipo1> list = new ArrayList<>(Arrays.asList(array)).stream()
				.filter(a -> a.getId() == id)
				.collect(Collectors.toList());
		if(list.size() > 0)
			return list.get(0).getMonto();
		else
			return null;
	}

	public Float obtenerComision(Integer id) {
		Tipo1[] array = (Tipo1[]) db.selectAll();
		if(array == null)
			return null;
		List<Tipo1> list = new ArrayList<>(Arrays.asList(array)).stream()
				.filter(a -> a.getId() == id)
				.collect(Collectors.toList());
		if(list.size() > 0)
			return list.get(0).getComisionAlSocio();
		else
			return null;
	}


	public Tipo1 getById(Integer id) {
		Tipo1[] array = (Tipo1[]) db.selectAll();
		if(array == null)
			return null;
		List<Tipo1> list = new ArrayList<>(Arrays.asList(array)).stream()
				.filter(a -> a.getId() == id)
				.collect(Collectors.toList());
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public void delete(Integer id) {
		Tipo1[] array = (Tipo1[]) db.selectAll();
		List<Tipo1> list = new ArrayList<>(Arrays.asList(array));

		List<Tipo1> toDelete = list.stream()
				.filter(a -> a.getId() == id)
				.collect(Collectors.toList());

		if(toDelete.size() > 0) {
			list.remove(toDelete.get(0));
			db.insert(list);
		}
	}

    public EstadoOperacion getEstado(Integer id) {

		Tipo1[] array = (Tipo1[]) db.selectAll();
		if(array == null)
			return null;
		List<Tipo1> list = new ArrayList<>(Arrays.asList(array)).stream()
				.filter(a -> a.getId() == id)
				.collect(Collectors.toList());
		if(list.size() > 0)
			return list.get(0).getEstadoOperacion();
		else
			return null;

    }

	public Float getTasaDeDescuento(Integer id) {
		Tipo1[] array = (Tipo1[]) db.selectAll();
		if(array == null)
			return null;
		List<Tipo1> list = new ArrayList<>(Arrays.asList(array)).stream()
				.filter(a -> a.getId() == id)
				.collect(Collectors.toList());
		if(list.size() > 0)
			return list.get(0).getTasaDeDescuento();
		else
			return null;
	}

	public List<Tipo1> getEstadoOperacionDates(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin) {
		Tipo1[] array = (Tipo1[]) db.selectAll();
		List<Tipo1> array2 = new ArrayList<Tipo1>();
		for(Tipo1 t : array){
			if (t.getEstadoOperacion() == estadoOperacion && t.getFecha().after(fechaInicio) && t.getFecha().before(fechaFin)){
				array2.add(t);

			}
		}
		if(array2 == null)
			return new ArrayList<Tipo1>();
		return array2;
	}
}
