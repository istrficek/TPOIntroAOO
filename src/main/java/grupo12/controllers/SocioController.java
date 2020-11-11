package grupo12.controllers;

import java.util.List;

import grupo12.entity.Accionista;
import grupo12.entity.Participe;
import grupo12.entity.Protector;
import grupo12.entity.Socio;
import grupo12.entity.TipoEmpresa;
import grupo12.request.SocioRequest;
import grupo12.services.SocioService;

public class SocioController {
	
	private SocioService socioService;
	
	public Float obtenerSaldoDeudor(Integer id) {
	
	
		return socioService.getSaldoDeudor(id);
	}
	
	public List<Accionista> obtenerAccionistas(Integer id) {
		
		return socioService.getAccionistas(id);
		
	}
	
	public List<Participe> obtenerSociosParticipes() {
		return socioService.getSociosParticipes();
	}

	public List<Protector> obtenerSociosProtectores() {
		return socioService.getSociosProtectores();
	}
	
	public List<Socio>obtenerSocios(TipoEmpresa tipoEmpresa){

		return socioService.getSociosTipoEmpresa(tipoEmpresa);
	}
	
	public Socio obtenerSocio(Integer id) {
		return socioService.getSocio(id);
	}
	
	public void crearSocio(SocioRequest socioRequest) {

		Socio nuevo = new Socio();
		nuevo.setAccionistas(socioRequest.getAccionistas());
		nuevo.setActividadPrincipal(socioRequest.getActividadPrincipal());
		nuevo.setCuit(socioRequest.getCuit());
		nuevo.setDireccion(socioRequest.getDireccion());
		nuevo.setEmail(socioRequest.getEmail());
		nuevo.setEstadoSocio(socioRequest.getEstadoSocio());
		nuevo.setFechaInicio(socioRequest.getFechaInicio());
		nuevo.setId(socioRequest.getId());
		nuevo.setRazonSocial(socioRequest.getRazonSocial());
		nuevo.setSaldoAcciones(socioRequest.getSaldoAccionesTipo());
		nuevo.setTelefono(socioRequest.getTelefono());
		nuevo.setTipoEmpresa(nuevo.getTipoEmpresa());

		if(socioRequest.isParticipe()) {
			Participe socio = new Participe(nuevo);
			socioService.save(socio);
		}
		else {
			Protector socio = new Protector(nuevo);
			socioService.save(socio);
		}
	}
	public void editarSocio(Integer id, SocioRequest socioRequest){
		
		if(socioRequest.isParticipe()) {
			Participe socio = socioService.getParticipeById(id);
			socio.setAccionistas(socioRequest.getAccionistas());
			socio.setActividadPrincipal(socioRequest.getActividadPrincipal());
			socio.setCuit(socioRequest.getCuit());
			socio.setDireccion(socioRequest.getDireccion());
			socio.setEmail(socioRequest.getEmail());
			socio.setEstadoSocio(socioRequest.getEstadoSocio());
			socio.setFechaInicio(socioRequest.getFechaInicio());
			socio.setId(socioRequest.getId());
			socio.setRazonSocial(socioRequest.getRazonSocial());
			socio.setSaldoAcciones(socioRequest.getSaldoAccionesTipo());
			socio.setTelefono(socioRequest.getTelefono());
			socio.setTipoEmpresa(socio.getTipoEmpresa());
			socioService.save(socio);
		}
		else {
			Protector socio = socioService.getProtectorById(id);
			socio.setAccionistas(socioRequest.getAccionistas());
			socio.setActividadPrincipal(socioRequest.getActividadPrincipal());
			socio.setCuit(socioRequest.getCuit());
			socio.setDireccion(socioRequest.getDireccion());
			socio.setEmail(socioRequest.getEmail());
			socio.setEstadoSocio(socioRequest.getEstadoSocio());
			socio.setFechaInicio(socioRequest.getFechaInicio());
			socio.setId(socioRequest.getId());
			socio.setRazonSocial(socioRequest.getRazonSocial());
			socio.setSaldoAcciones(socioRequest.getSaldoAccionesTipo());
			socio.setTelefono(socioRequest.getTelefono());
			socio.setTipoEmpresa(socio.getTipoEmpresa());
			socioService.save(socio);
			
		}
		
	}
	
	
		
		
		
	

}
