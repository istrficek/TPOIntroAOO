package grupo12.controllers;

import grupo12.entity.Accionista;
import grupo12.services.AccionistaService;

public class AccionistaController {
	
	AccionistaService accionistaService;
	
	public void crearAccionista(Accionista a) {
		
		Accionista nuev = new Accionista();
		nuev.setPorcentajedeParticipacion(a.getPorcentajedeParticipacion());
		nuev.setRazonSocial(a.getRazonSocial());
		accionistaService.save(nuev);
		
	}
	
	public Accionista editarAccionista(Integer id, Accionista a) {
		
		Accionista nuev = accionistaService.getById(id);
		nuev.setPorcentajedeParticipacion(a.getPorcentajedeParticipacion());
		nuev.setRazonSocial(a.getRazonSocial());
		accionistaService.save(nuev);
		return accionistaService.edit(nuev);
		
	}
	
	public Accionista getAccionista(Integer id) {
		return accionistaService.getById(id);
	}
	
	public void eliminarAccionista(Integer id) {
		
		accionistaService.deleteById(id);
		
	}

}
