package grupo12.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import grupo12.data_access.JsonDB;
import grupo12.entity.Accionista;
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
}
