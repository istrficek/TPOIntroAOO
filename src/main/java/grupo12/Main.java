package grupo12;


import grupo12.entity.EstadoComision;
import grupo12.entity.Tipo1;
import grupo12.entity.TipoDeOperacion;
import grupo12.repository.Tipo1Repository;

import java.util.Date;
import java.util.List;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tipo1 testObject;
		testObject = new Tipo1();
		testObject.setBancoCheques("Galicia");
		testObject.setCuitFirmante("CUIT Firmante");
		testObject.setFechaVencimiento(new Date("09/11/2020"));
		testObject.setFecha(new Date("10/11/2020"));
		testObject.setNroCheques((long) 12);
		testObject.setComisionAlSocio((float) 123.50);
		testObject.setEstadoComision(EstadoComision.Calculada);
		testObject.setId(100);
		testObject.setMonto((float) 872.90);
		testObject.setTipoDeOperacion(TipoDeOperacion.Tipo1);

		Tipo1Repository repo = new Tipo1Repository();
		repo.save(testObject);

		List<Tipo1> lista = repo.getAll();

		System.out.println(lista.toString());
	}

}
