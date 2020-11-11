package grupo12;



import grupo12.controllers.AccionistaController;
import grupo12.entity.Accionista;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
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
		*/
		/*****************************************************/

		Accionista testAccionista = new Accionista();
		testAccionista.setPorcentajedeParticipacion(30);
		testAccionista.setRazonSocial("El Accionista S.A.");

		AccionistaController ac = new AccionistaController();

		ac.crearAccionista(testAccionista);
		ac.crearAccionista(testAccionista);
		ac.crearAccionista(testAccionista);
		ac.crearAccionista(testAccionista);

		ac.eliminarAccionista(0);

		Accionista testAccionistaEdit = new Accionista();
		testAccionistaEdit.setPorcentajedeParticipacion(26);
		testAccionistaEdit.setRazonSocial("Accionista Editado S.A.");

		ac.editarAccionista(1, testAccionistaEdit);

		for (Accionista a: ac.getAllAccionista()) {
			System.out.println(a.getId());
			System.out.println(a.getRazonSocial());
			System.out.println(a.getPorcentajedeParticipacion());
			System.out.println("*****************************************");
		}



	}

}
