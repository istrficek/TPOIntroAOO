package grupo12;

import grupo12.controllers.AccionistaController;
import grupo12.controllers.DocumentacionController;
import grupo12.controllers.OperacionController;
import grupo12.controllers.SocioController;
import grupo12.data_access.GeneradorBD;
import grupo12.entity.*;
import grupo12.request.SocioRequest;
import grupo12.vistas.FrmPrincipal;
import grupo12.entity.Accionista;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Main {
	private static final SocioController socioController = new SocioController();
	private static final AccionistaController accionistaController = new AccionistaController();
	private static final DocumentacionController documentacionController = new DocumentacionController();
	private static final OperacionController operacionController = new OperacionController();

	public static void main(String[] args) {
		GeneradorBD.GenerarBaseConDatos();
		/*
		//<editor-fold desc="TEST SOCIO CONTROLLER">
		List<Accionista> accionistas = socioController.obtenerAccionistas(1);

		if(accionistas.size() == 2){
			System.out.println("Los accionistas estan OK");
		}
		else{
			System.out.println("Accionistas estan mal!!");
		}
		for (Accionista a: accionistas) {
			System.out.println(a.toString());
		}

		List<Participe> sociosParticipes = socioController.obtenerSociosParticipes();

		if(sociosParticipes.size() == 3){
			System.out.println("Los participes estan OK");
		}
		else{
			System.out.println("participes estan mal!!");
		}
		for (Participe p: sociosParticipes) {
			System.out.println(p.toString());
		}

		List<Protector> sociosProtectores = socioController.obtenerSociosProtectores();

		if(sociosProtectores.size() == 3){
			System.out.println("Los protectores estan OK");
		}
		else{
			System.out.println("protectores estan mal!!");
		}
		for (Protector p: sociosProtectores) {
			System.out.println(p.toString());
		}

		List<Socio> sociosTipoEmpresa = socioController.obtenerSocios(TipoEmpresa.Mediana);
		if(sociosTipoEmpresa.size() == 2){
			System.out.println("Los socios de empresa mediana estan OK");
		}
		else{
			System.out.println("Los socios de empresa mediana estan mal!!");
		}
		for (Socio s: sociosTipoEmpresa) {
			System.out.println(s.toString());
		}

		Socio socioPorId = socioController.obtenerSocio(4);

		if(socioPorId.getId() == 4){
			System.out.println("Socio esta OK!");
		} else {
			System.out.println("Socio esta mal!!");
		}

		System.out.println(socioPorId.toString());

		Socio finalSocioPorId = socioPorId;
		socioController.editarSocio(4, new SocioRequest(){{
			setActividadPrincipal("Actividad Principal Editada");
			setCuit(finalSocioPorId.getCuit());
			setDireccion("Calle falsa editada 321");
			setEmail("SocioEditado@socio.com");
			setEstadoSocio(EstadoSocio.pleno);
			setFechaInicio(new Date());
			setParticipe(false);
			setRazonSocial("El Socio Protector Editado S.A");
			setSaldoAccionesTipo(1223);
			setTelefono("1548756525");
			setTipoEmpresa(TipoEmpresa.Mediana);
		}});

		socioPorId = socioController.obtenerSocio(4);

		if(socioPorId.getActividadPrincipal().contains("Editada")){
			System.out.println("La edicion del socio 4 fue OK!");
		} else {
			System.out.println("La edicion del socio esta mal!");
		}

		System.out.println(socioPorId.toString());


		//</editor-fold>
		*/
		FrmPrincipal frame = new FrmPrincipal("Gestion de Socios");
	}

}
