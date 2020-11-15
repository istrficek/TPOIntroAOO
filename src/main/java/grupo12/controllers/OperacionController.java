package grupo12.controllers;

import grupo12.entity.EstadoOperacion;
import grupo12.entity.Tipo1;
import grupo12.entity.Tipo2;
import grupo12.entity.Tipo3;
import grupo12.request.OperacionRequest;
import grupo12.services.OperacionService;
import grupo12.services.OperacionServiceImp;

import java.util.Date;
import java.util.List;

public class OperacionController {
	
	private OperacionService operacionService = new OperacionServiceImp();


	public void crearOperacion(OperacionRequest opr) {
		
		switch (opr.getTipoOpe()) {
		case 1 :
			Tipo1 op1 = new Tipo1();
			
			op1.setId(opr.getId());
			op1.setBancoCheques(opr.getBancoCheques());
			op1.setComisionAlSocio(opr.getComisionAlSocio());
			op1.setCuitFirmante(opr.getCuitFirmante());
			op1.setEstadoComision(opr.getEstadoComision());
			op1.setEstadoOperacion(opr.getEstadoOperacion());
			op1.setFecha(opr.getFecha());
			op1.setFechaVencimiento(opr.getFechaVencimiento());
			op1.setMonto(opr.getMonto());
			op1.setNroCheques(opr.getNroCheques());
			op1.setTasaDeDescuento(opr.getTasaDeDescuento());
			op1.setTipoDeOperacion(opr.getTipoDeOperacion());

			operacionService.savet1(op1);

			break;
		
		case 2:
			Tipo2 op2 = new Tipo2();
			op2.setId(opr.getId());
			op2.setComisionAlSocio(opr.getComisionAlSocio());
			op2.setEstadoComision(opr.getEstadoComision());
			op2.setEstadoOperacion(opr.getEstadoOperacion());
			op2.setFecha(opr.getFecha());
			op2.setFechaVencimiento(opr.getFechaVencimiento());
			op2.setMonto(opr.getMonto());
			op2.setTasaDeDescuento(opr.getTasaDeDescuento());
			op2.setTipoDeOperacion(opr.getTipoDeOperacion());
			
			op2.setEmpresaCuentaCorriente(opr.getEmpresaCuentaCorriente());
			op2.setFechaVencimiento(opr.getFechaVencimiento());

			operacionService.savet2(op2);
			
			break;
		
		case 3:
			Tipo3 op3 = new Tipo3();
			
			op3.setId(opr.getId());
			op3.setComisionAlSocio(opr.getComisionAlSocio());
			op3.setEstadoComision(opr.getEstadoComision());
			op3.setEstadoOperacion(opr.getEstadoOperacion());
			op3.setFecha(opr.getFecha());
			op3.setMonto(opr.getMonto());
			op3.setTasaDeDescuento(opr.getTasaDeDescuento());
			op3.setTipoDeOperacion(opr.getTipoDeOperacion());
			
			op3.setBanco(opr.getBanco());
			op3.setFechaActualizacion(opr.getFechaActualizacion());
			op3.setCantidadDeCuotas(opr.getCantidadDeCuotas());
			op3.setTasa(opr.getTasa());
			op3.setSistema(opr.getSistema());
			operacionService.savet3(op3);
			break;
		
		default:
			System.out.println("error");
			break;
			
		}
		
	}


	public void editOperacion(OperacionRequest opr){

		OperacionRequest nuevo = new OperacionRequest();
		switch (opr.getTipoOpe()) {
		case 1 :
			Tipo1 op1 = operacionService.getByIdT1(opr.getId());
			
			op1.setId(opr.getId());
			op1.setBancoCheques(opr.getBancoCheques());
			op1.setComisionAlSocio(opr.getComisionAlSocio());
			op1.setCuitFirmante(opr.getCuitFirmante());
			op1.setEstadoComision(opr.getEstadoComision());
			op1.setEstadoOperacion(opr.getEstadoOperacion());
			op1.setFecha(opr.getFecha());
			op1.setFechaVencimiento(opr.getFechaVencimiento());
			op1.setMonto(opr.getMonto());
			op1.setNroCheques(opr.getNroCheques());
			op1.setTasaDeDescuento(opr.getTasaDeDescuento());
			op1.setTipoDeOperacion(opr.getTipoDeOperacion());
			operacionService.savet1(op1);
			break;
		
		case 2:
			Tipo2 op2 = operacionService.getByIdT2(opr.getId());
			op2.setId(opr.getId());
			op2.setComisionAlSocio(opr.getComisionAlSocio());
			op2.setEstadoComision(opr.getEstadoComision());
			op2.setEstadoOperacion(opr.getEstadoOperacion());
			op2.setFecha(opr.getFecha());
			op2.setFechaVencimiento(opr.getFechaVencimiento());
			op2.setMonto(opr.getMonto());
			op2.setTasaDeDescuento(opr.getTasaDeDescuento());
			op2.setTipoDeOperacion(opr.getTipoDeOperacion());
			
			op2.setEmpresaCuentaCorriente(opr.getEmpresaCuentaCorriente());
			op2.setFechaVencimiento(opr.getFechaVencimiento());
			operacionService.savet2(op2);
			break;
		case 3:
			Tipo3 op3 = operacionService.getByIdT3(opr.getId());
			
			op3.setId(opr.getId());
			op3.setComisionAlSocio(opr.getComisionAlSocio());
			op3.setEstadoComision(opr.getEstadoComision());
			op3.setEstadoOperacion(opr.getEstadoOperacion());
			op3.setFecha(opr.getFecha());
			op3.setMonto(opr.getMonto());
			op3.setTasaDeDescuento(opr.getTasaDeDescuento());
			op3.setTipoDeOperacion(opr.getTipoDeOperacion());
			
			op3.setBanco(opr.getBanco());
			op3.setFechaActualizacion(opr.getFechaActualizacion());
			op3.setCantidadDeCuotas(opr.getCantidadDeCuotas());
			op3.setTasa(opr.getTasa());
			op3.setSistema(opr.getSistema());
			op3.setCantidadDeCuotas(opr.getCantidadDeCuotas());
			operacionService.savet3(op3);
			break;
		
		default:
			System.out.println("Error");
			break;
		
	}
	}

	public OperacionRequest getOperacionT1(Integer id, Integer tipo) {
		
		return operacionService.getById(id, tipo);
	}

	public void EliminarOperacion(Integer id, Integer tipo) {
		 operacionService.deleteById(id, tipo);
		 
	 }


	 public Float obtenerMontoT1(Integer id){

		return operacionService.getMontoT1ById(id);
	 }

	public Float obtenerMontoT2(Integer id){

		return operacionService.getMontoT2ById(id);
	}

	public Float obtenerMontoT3(Integer id){

		return operacionService.getMontoT3ById(id);
	}

	public Float obtenerComision(Integer id, Integer tipoOperacion){
		return operacionService.obtenerComision(id, tipoOperacion);
	}

	public List<OperacionRequest> obtenerTodasLasOperaciones(){
		return operacionService.getAllOperaciones();
	}


	public EstadoOperacion obtenerEstado(Integer id, Integer tipo){

		return operacionService.getEstado(id, tipo);
	}

	public Float getTasaDeDescuento(Integer id, Integer tipo){

		return operacionService.getTasaDeDescuento(id, tipo);
	}

	public List<OperacionRequest> obtenerOperaciones(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin){
		return operacionService.obtenerOperaciones(estadoOperacion, fechaInicio, fechaFin);
	}

	public Float CalcularComision(Integer id,Integer tipoOperacion, Date fecha){
		return operacionService.calcularComision(id, tipoOperacion, fecha);
	}

	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
