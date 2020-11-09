package grupo12.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	
	

}
