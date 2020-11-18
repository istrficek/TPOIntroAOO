package grupo12.controllers;

import java.util.Date;
import java.util.List;

import grupo12.dto.PosicionConsolidada;
import grupo12.dto.PromedioTasaYTotal;
import grupo12.entity.*;
import grupo12.request.SocioRequest;
import grupo12.services.*;

public class SocioController {
	
	private SocioService socioService = new SocioServiceImp();
	private AporteService aporteService = new AporteServiceImp();
	private FondoDeRiesgoService fondoDeRiesgoService = new FondoDeRiesgoServiceImp();

	public List<Accionista> obtenerAccionistas(Integer idSocio) {
		return socioService.getAccionistas(idSocio);
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
	
	public boolean crearSocio(SocioRequest socioRequest) {

		try {
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
			nuevo.setTipoEmpresa(socioRequest.getTipoEmpresa());
			if(socioRequest.isParticipe())
				nuevo.setTipoSocio(TipoSocio.Participe);
			else
				nuevo.setTipoSocio(TipoSocio.Protector);
			socioService.save(nuevo);
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean editarSocio(Integer id, SocioRequest socioRequest){

		try {
			Socio socio = socioService.getSocio(id);
			socio.setAccionistas(socioRequest.getAccionistas());
			socio.setActividadPrincipal(socioRequest.getActividadPrincipal());
			socio.setCuit(socioRequest.getCuit());
			socio.setDireccion(socioRequest.getDireccion());
			socio.setEmail(socioRequest.getEmail());
			socio.setEstadoSocio(socioRequest.getEstadoSocio());
			socio.setFechaInicio(socioRequest.getFechaInicio());
			socio.setRazonSocial(socioRequest.getRazonSocial());
			socio.setSaldoAcciones(socioRequest.getSaldoAccionesTipo());
			socio.setTelefono(socioRequest.getTelefono());
			socio.setTipoEmpresa(socio.getTipoEmpresa());
			if(socioRequest.isParticipe()){
				socio.setTipoSocio(TipoSocio.Participe);
			} else {
				socio.setTipoSocio(TipoSocio.Protector);
			}
			socioService.update(socio);
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Float obtenerSaldoDeudor(Integer id) {
		return socioService.getSaldoDeudor(id);
	}

	public boolean agregarAporte(Aporte a){
		return aporteService.save(a);
	}

	public boolean editarAporte(Aporte a){
		return aporteService.update(a);
	}

	public List<Aporte> obtenerAportes(){
		return aporteService.getAportes();
	}

	public boolean eliminarAporte(int id){
		return aporteService.eliminarAporte(id);
	}

	public boolean validarOperacion(Operacion operacion){
		return socioService.validarOperacion(operacion);
	}

	public boolean verificarSocio(Socio s){
		return socioService.verificarSocio(s);
	}

	public FondoDeRiesgo getFondoDeRiesgo(){
		return fondoDeRiesgoService.getFondoDeRiesgo();
	}

	public PromedioTasaYTotal obtenerValorPromedioTasaDescuentoYTotalOperado(TipoEmpresa tipoEmpresa, Date fechaInicio, Date fechaFin){
		return socioService.obtenerValorPromedioTasaDescuentoYTotalOperado(tipoEmpresa, fechaInicio, fechaFin);
	}

	public Float obtenerComisionPorTipoDeOperacion(TipoDeOperacion tipoDeOperacion, Socio socio){
		return socioService.obtenerComisionPorTipoDeOperacion(tipoDeOperacion, socio);
	}

	public PosicionConsolidada obtenerPosicionConsolidada(Integer idSocio){
		return socioService.obtenerPosicionConsolidada(idSocio);
	}
}
