package grupo12.controllers;

import java.util.List;

import grupo12.entity.Accionista;
import grupo12.services.SocioService;

public class SocioController {
	
	private SocioService socioService;
	
	public Float obtenerSaldoDeudor(Integer id) {
	
	
		return socioService.getSaldoDeudor(id);
	}
	
	public List<Accionista> obtenerAccionistas(Integer id) {
		
		return socioService.getAccionistas(id);
		
	}
	
	
		
		
		
	

}
