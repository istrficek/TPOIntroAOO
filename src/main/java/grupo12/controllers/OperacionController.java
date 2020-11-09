package main.java.grupo12.controllers;

import main.java.grupo12.entity.Tipo1;
import main.java.grupo12.entity.Tipo2;
import main.java.grupo12.entity.Tipo3;
import main.java.grupo12.request.OperacionRequest;
import main.java.grupo12.services.OperacionService;

public class OperacionController {
	
	private OperacionService operacionService;
	
	
	private void crearOperacion(OperacionRequest opr) {
		
		
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
			op3.setFechaActualizacion(opr.getFechaActualziacion());
			op3.setCantidadDeCuotas(opr.getCantidadDeCuotas());
			op3.setTasa(opr.getTasa());
			op3.setSistema(opr.getSistema());
			break;
		
		default:
			System.out.println("error");
			break;
			
		}
		
	}
	
	
	private void editOperacion(OperacionRequest opr){
		
		
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
			op3.setFechaActualizacion(opr.getFechaActualziacion());
			op3.setCantidadDeCuotas(opr.getCantidadDeCuotas());
			op3.setTasa(opr.getTasa());
			op3.setSistema(opr.getSistema());
			break;
		
		default:
			System.out.println("Error");
			break;
		
	}
	}
	
	private Tipo1 getOperacionT1(Integer id) {
		
		return operacionService.getByIdT1(id);
	}
	
	private Tipo2 getOperacionT2(Integer id) {
		
		
		return operacionService.getByIdT2(id);
	}

	private Tipo3 getOperacionT3(Integer id) {
	
	
		return operacionService.getByIdT3(id);
	}
	
	 private void EliminarOperacionT1(Integer id) {
		 operacionService.deleteT1ById(id);
		 
	 }
	 
	 private void EliminarOperacionT2(Integer id) {
		 operacionService.deleteT2ById(id);
	 }

	 private void EliminarOperacionT3(Integer id) {
		 operacionService.deleteT3ById(id);
	 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public void NuevaOperacionT1(Tipo1 t1) {
		
		Tipo1 op = new Tipo1();
		
		op.setId(t1.getId());
		op.setBancoCheques(t1.getBancoCheques());
		op.setComisionAlSocio(t1.getComisionAlSocio());
		op.setCuitFirmante(t1.getCuitFirmante());
		op.setEstadoComision(t1.getEstadoComision());
		op.setEstadoOperacion(t1.getEstadoOperacion());
		op.setFecha(t1.getFecha());
		op.setFechaVencimiento(t1.getFechaVencimiento());
		op.setMonto(t1.getMonto());
		op.setNroCheques(t1.getNroCheques());
		op.setTasaDeDescuento(t1.getTasaDeDescuento());
		op.setTipoDeOperacion(t1.getTipoDeOperacion());
		
	}
	
	
	
	public void NuevaOperacionT2(Tipo2 t2) {
		
		Tipo2 op = new Tipo2();
		
		op.setId(t2.getId());
		op.setComisionAlSocio(t2.getComisionAlSocio());
		op.setEstadoComision(t2.getEstadoComision());
		op.setEstadoOperacion(t2.getEstadoOperacion());
		op.setFecha(t2.getFecha());
		op.setFechaVencimiento(t2.getFechaVencimiento());
		op.setMonto(t2.getMonto());
		op.setTasaDeDescuento(t2.getTasaDeDescuento());
		op.setTipoDeOperacion(t2.getTipoDeOperacion());
		
		op.setEmpresaCuentaCorriente(t2.getEmpresaCuentaCorriente());
		op.setFechaVencimiento(op.getFechaVencimiento());
		
	}
	
	public void NuevaOperacionT3(Tipo3 t3) {
		
		Tipo3 op = new Tipo3();
		
		op.setId(t3.getId());
		op.setComisionAlSocio(t3.getComisionAlSocio());
		op.setEstadoComision(t3.getEstadoComision());
		op.setEstadoOperacion(t3.getEstadoOperacion());
		op.setFecha(t3.getFecha());
		op.setMonto(t3.getMonto());
		op.setTasaDeDescuento(t3.getTasaDeDescuento());
		op.setTipoDeOperacion(t3.getTipoDeOperacion());
		
		op.setBanco(t3.getBanco());
		op.setFechaActualizacion(t3.getFechaActualizacion());
		op.setCantidadDeCuotas(t3.getCantidadDeCuotas());
		op.setTasa(t3.getTasa());
		op.setSistema(t3.getSistema());
		
	}
	*/


}
