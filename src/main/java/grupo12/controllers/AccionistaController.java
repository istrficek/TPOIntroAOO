package grupo12.controllers;

import grupo12.entity.Accionista;
import grupo12.services.AccionistaService;
import grupo12.services.AccionistaServiceImp;

import java.util.List;

public class AccionistaController {
	
	AccionistaService accionistaService = new AccionistaServiceImp();
	
	public void crearAccionista(Accionista a, Integer idSocio) {
		
		Accionista nuev = new Accionista();
		nuev.setPorcentajedeParticipacion(a.getPorcentajedeParticipacion());
		nuev.setRazonSocial(a.getRazonSocial());
		nuev.setCuit(a.getCuit());
		accionistaService.save(nuev, idSocio);
	}
	
	public Accionista editarAccionista(Integer id, Accionista a) {
		
		Accionista nuev = accionistaService.getById(id);
		nuev.setPorcentajedeParticipacion(a.getPorcentajedeParticipacion());
		nuev.setRazonSocial(a.getRazonSocial());
		nuev.setCuit(a.getCuit());
		accionistaService.edit(nuev);
		return nuev;
	}
	
	public Accionista getAccionista(Integer id) {

		return accionistaService.getById(id);
	}
	
	public void eliminarAccionista(Integer id) {
		
		accionistaService.deleteById(id);
		
	}

	public List<Accionista> getAllAccionista(){
		return accionistaService.getAll();
	}

}
