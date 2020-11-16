package grupo12;



import grupo12.controllers.AccionistaController;
import grupo12.data_access.SqLiteDB;
import grupo12.entity.Accionista;

import java.io.IOException;


public class Main {

	public static void main(String[] args) {

/*
		try {
			SqLiteDB.GenerarDB();
		} catch (IOException e) {
			e.printStackTrace();
		}

 */



		Accionista testAccionista = new Accionista();
		testAccionista.setPorcentajedeParticipacion(30);
		testAccionista.setRazonSocial("El Accionista S.A.");

		AccionistaController ac = new AccionistaController();

		ac.crearAccionista(testAccionista, 1);
		ac.crearAccionista(testAccionista, 2);
		ac.crearAccionista(testAccionista, 3);
		ac.crearAccionista(testAccionista, 4);

		ac.eliminarAccionista(2);

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
