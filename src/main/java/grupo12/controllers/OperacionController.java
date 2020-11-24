package grupo12.controllers;

import grupo12.entity.*;
import grupo12.request.OperacionRequest;
import grupo12.services.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Falta: Eliminar Operacion, ObtenerOperacion(Tipo)

public class OperacionController {
	
	private OperacionService operacionService = new OperacionServiceImp();

	private SocioService socioService = new SocioServiceImp();

	private CertificadoDeGarantiaService certificadoService = new CertificadoDeGarantiaServiceImp();

	// NuevaOperacion
	public boolean crearOperacion(OperacionRequest opr, Integer idSocio) {

		try {
			Date fecha = new Date();

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
				op1.setFechaVencimiento(fecha);
				op1.setMonto(opr.getMonto());
				op1.setNroCheques(opr.getNroCheques());
				op1.setTasaDeDescuento(opr.getTasaDeDescuento());
				op1.setTipoDeOperacion(opr.getTipoDeOperacion());
				op1.setIdSocio(idSocio);

				operacionService.savet1(op1);

				break;

			case 2:
				Tipo2 op2 = new Tipo2();
				op2.setId(opr.getId());
				op2.setComisionAlSocio(opr.getComisionAlSocio());
				op2.setEstadoComision(opr.getEstadoComision());
				op2.setEstadoOperacion(opr.getEstadoOperacion());
				op2.setFecha(fecha);
				op2.setFechaVencimiento(opr.getFechaVencimiento());
				op2.setMonto(opr.getMonto());
				op2.setTasaDeDescuento(opr.getTasaDeDescuento());
				op2.setTipoDeOperacion(opr.getTipoDeOperacion());
				op2.setIdSocio(idSocio);

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
				op3.setFecha(fecha);
				op3.setMonto(opr.getMonto());
				op3.setTasaDeDescuento(opr.getTasaDeDescuento());
				op3.setTipoDeOperacion(opr.getTipoDeOperacion());
				op3.setIdSocio(idSocio);

				op3.setBanco(opr.getBanco());
				op3.setFechaActualizacion(opr.getFechaActualizacion());
				List<Cuota> cuotas = new ArrayList<>();
				cuotas.add(new Cuota(){{
					setId(0);
					setValor(100);
					setPaga(false);
					setNumeroDeCuota(1);
					setFechaVencimiento(new Date());
				}});
				cuotas.add(new Cuota(){{
					setId(1);
					setValor(100);
					setPaga(false);
					setNumeroDeCuota(2);
					setFechaVencimiento(new Date());
				}});
				cuotas.add(new Cuota(){{
					setId(2);
					setValor(100);
					setPaga(false);
					setNumeroDeCuota(3);
					setFechaVencimiento(new Date());
				}});
				cuotas.add(new Cuota(){{
					setId(3);
					setValor(100);
					setPaga(false);
					setNumeroDeCuota(4);
					setFechaVencimiento(new Date());
				}});
				op3.setCuotas(cuotas);
				op3.setTasa(opr.getTasa());
				op3.setSistema(opr.getSistema());
				operacionService.savet3(op3);
				break;

			default:
				System.out.println("error");
				break;

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// EditarOpeacion
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
			op3.setMonto(opr.getMonto());
			op3.setTasaDeDescuento(opr.getTasaDeDescuento());
			op3.setTipoDeOperacion(opr.getTipoDeOperacion());
			
			op3.setBanco(opr.getBanco());
			op3.setFechaActualizacion(opr.getFechaActualizacion());
			op3.setCuotas(opr.getCuotas());
			op3.setTasa(opr.getTasa());
			op3.setSistema(opr.getSistema());
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

	//ObtenerOperaciones(Estado, FechaInicio, FechaFin)
	public List<OperacionRequest> obtenerOperaciones(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin){
		return operacionService.obtenerOperaciones(estadoOperacion, fechaInicio, fechaFin);
	}

	public Float CalcularComision(Integer id,Integer tipoOperacion, Date fecha){
		return operacionService.calcularComision(id, tipoOperacion, fecha);
	}

	public void generarCertificadoDeGarantia(Integer idOperacion, Integer tipo, Integer idCertificado){
		CertificadoDeGarantia certificado =certificadoService.getById(idCertificado);
		switch (tipo){
			case 1:
				Tipo1 t1=operacionService.getByIdT1(idOperacion);
				t1.setCerificadoDeGarantia(certificado);
				operacionService.savet1(t1);
			case 2:
				Tipo2 t2=operacionService.getByIdT2(idOperacion);
				t2.setCerificadoDeGarantia(certificado);
				operacionService.savet2(t2);
			case 3:
				Tipo3 t3=operacionService.getByIdT3(idOperacion);
				t3.setCerificadoDeGarantia(certificado);
				operacionService.savet3(t3);
		}
	}

	public boolean validarChequesDelMismoFirmante(Tipo1 operacion){
		return operacionService.validarChequesDelMismoFirmante(operacion);
	}

	public boolean validarOperacion(Operacion operacion){
		return operacionService.validarOperacion(operacion);
	}

	public List<Operacion> getOperacionesAvaladas(int idSocio, Date fechaInicio, Date fechaFin){
		return operacionService.getOperacionesAvaladas(idSocio, fechaInicio, fechaFin);
	}
	

	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
