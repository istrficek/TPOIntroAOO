package grupo12.services;

import grupo12.entity.*;
import grupo12.repository.*;
import grupo12.request.OperacionRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OperacionServiceImp implements OperacionService {

	Tipo1Repository repot1 = new Tipo1Repository();
	Tipo2Repository repot2 = new Tipo2Repository();
	Tipo3Repository repot3 = new Tipo3Repository();
	SocioRepository socioRepository = new SocioRepository();
	FondoDeRiesgoRepository fondoDeRiesgoRepository = new FondoDeRiesgoRepository();

	@Override
	public Float getTasaDeDescuento(Integer id, Integer tipo) {
		switch (tipo) {
			case 1:
				return repot1.getTasaDeDescuento(id);
			case 2:
				return repot2.getTasaDeDescuento(id);
			case 3:
				return repot3.getTasaDeDescuento(id);
			default:
				return null;
		}
	}

	public OperacionRequest getById(Integer id, Integer tipo) {
		OperacionRequest request = new OperacionRequest();

		switch (tipo){
			case 1:
				Tipo1 t1 =repot1.getById(id);
				EntyToModelT1(t1, request);
				return request;
			case 2:
				Tipo2 t2 =repot2.getById(id);
				EntyToModelT2(t2, request);
				return request;
			case 3:
				Tipo3 t3 =repot3.getById(id);
				EntyToModelT3(t3, request);
				return request;
			default:
				return null;
		}
	}


	@Override
	public void savet1(Tipo1 op1) {
		repot1.save(op1);
	}

	@Override
	public void savet2(Tipo2 op2) {
		repot2.save(op2);

	}

	@Override
	public void savet3(Tipo3 op3) {
		repot3.save(op3);

	}

	@Override
	public Float getMontoT1ById(Integer id) {
		return repot1.getMontoT1(id);
	}

	@Override
	public Float getMontoT2ById(Integer id) {
		return repot2.getByMontoT2(id);
	}

	@Override
	public Float getMontoT3ById(Integer id) {
		return repot3.getByMontoT3(id);
	}

	@Override
	public Float obtenerComision(Integer id, Integer tipoOperacion) {
		switch (tipoOperacion){
			case 1:
				return repot1.obtenerComision(id);
			case 2:
				return repot2.obtenerComision(id);
			case 3:
				return repot3.obtenerComision(id);

			default:
				return null;
		}
	}

	@Override
	public List<OperacionRequest> getAllOperaciones() {
		List<OperacionRequest> operaciones = new ArrayList<OperacionRequest>();
		List<Tipo1> t1 = repot1.getAll();
		List<Tipo2> t2 = repot2.getAll();
		List<Tipo3> t3 = repot3.getAll();

		if (t1.isEmpty() == false) {
			for (Tipo1 t : t1) {
				OperacionRequest opr = new OperacionRequest();
				EntyToModelT1(t, opr);
				operaciones.add(opr);
			}
		}

		if (t2.isEmpty() == false) {
			for (Tipo2 t : t2) {
				OperacionRequest opr = new OperacionRequest();
				EntyToModelT2(t, opr);
				operaciones.add(opr);
			}
		}

		if (t3.isEmpty() == false) {
			for (Tipo3 t : t3) {
				OperacionRequest opr = new OperacionRequest();
				EntyToModelT3(t, opr);
				operaciones.add(opr);
			}
		}

		return operaciones;
	}

	@Override
	public Tipo1 getByIdT1(Integer id) {
		return repot1.getById(id);
	}

	@Override
	public Tipo2 getByIdT2(Integer id) {
		return repot2.getById(id);
	}

	@Override
	public Tipo3 getByIdT3(Integer id) {
		return repot3.getById(id);
	}

	@Override
	public void deleteById(Integer id, Integer tipo) {
		switch (tipo){
			case 1:
				repot1.delete(id);
			case 2:
				repot2.delete(id);
			case 3:
				repot3.delete(id);

		}
	}

	@Override
	public EstadoOperacion getEstado(Integer id, Integer tipo) {
		switch (tipo) {
			case 1:
				return repot1.getEstado(id);
			case 2:
				return repot2.getEstado(id);
			case 3:
				return repot3.getEstado(id);
			default:
				return null;
		}
	}

	@Override
	public List<OperacionRequest> obtenerOperaciones(EstadoOperacion estadoOperacion, Date fechaInicio, Date fechaFin) {
		List<OperacionRequest> operaciones = new ArrayList<OperacionRequest>();
		List<Tipo1> t1 = repot1.getEstadoOperacionDates(estadoOperacion, fechaInicio, fechaFin);
		List<Tipo2> t2 = repot2.getEstadoOperacionDates(estadoOperacion, fechaInicio, fechaFin);
		List<Tipo3> t3 = repot3.getEstadoOperacionDates(estadoOperacion, fechaInicio, fechaFin);

		if (t1.isEmpty() == false) {
			for (Tipo1 t : t1) {
				OperacionRequest opr = new OperacionRequest();
				EntyToModelT1(t, opr);
				operaciones.add(opr);
			}
		}

		if (t2.isEmpty() == false) {
			for (Tipo2 t : t2) {
				OperacionRequest opr = new OperacionRequest();
				EntyToModelT2(t, opr);
				operaciones.add(opr);
			}
		}

		if (t3.isEmpty() == false) {
			for (Tipo3 t : t3) {
				OperacionRequest opr = new OperacionRequest();
				EntyToModelT3(t, opr);
				operaciones.add(opr);
			}
		}
		return operaciones;
	}

	@Override
	public Float calcularComision(Integer id,Integer tipoOperacion, Date fecha) {
		Float monto;
		Float res = null;
		switch(tipoOperacion){
			case 1:
				monto = repot1.getMontoT1(id);
				if(monto != 0){
					res = (monto*3) / 100;
				}
			case 2:
				monto = repot2.getByMontoT2(id);
				if(monto != 0){
					res = (monto*3) / 100;
				}
			case 3:
				monto = repot3.getByMontoT3(id);;
				if(monto != 0){
					res = (monto*4) / 100;
				}
		}
		return res;
	}

	public boolean validarChequesDelMismoFirmante(Tipo1 operacion) {
		FondoDeRiesgo fondoDeRiesgo = fondoDeRiesgoRepository.getFondoDeRiesgo();
		List<Tipo1> tipo1List = repot1.getAll().stream().filter(tipo1 -> tipo1.getCuitFirmante().equals(operacion.getCuitFirmante())).collect(Collectors.toList());
		Float montoCheques = 0F;

		for (Tipo1 t1: tipo1List) {
			montoCheques += t1.getMonto();
		}

		return (montoCheques + operacion.getMonto()) < (fondoDeRiesgo.obtenerMonto() * 0.05);
	}

	public List<Operacion> getOperacionesAvaladas(int idSocio, Date fechaInicio, Date fechaFin) {
		return socioRepository.getOperaciones(idSocio)
				.stream()
				.filter(operacion ->
						operacion.getEstadoOperacion() == EstadoOperacion.ConCertificadoEmitido
								&& operacion.getFecha().after(fechaInicio)
								&& operacion.getFecha().before(fechaFin))
				.collect(Collectors.toList());
	}

	public boolean validarOperacion(OperacionRequest operacion) {
		boolean debeFacturas = false;
		FondoDeRiesgo fondoDeRiesgo = fondoDeRiesgoRepository.getFondoDeRiesgo();
		List<Operacion> opreacionesDeSocio = socioRepository.getOperaciones(operacion.getIdSocio());
		Float montoDelSocio = 0F;

		for (Operacion o: opreacionesDeSocio) {
			montoDelSocio += o.getMonto();
		}

		return montoDelSocio + operacion.getMonto() < (fondoDeRiesgo.obtenerMonto() * 0.05);
	}

	@Override
	public Float getByfechaT1(Date fecha) {
		List<Tipo1> t1lista = repot1.getByFecha(fecha);
		Float resultado= Float.valueOf(0);
		for (Tipo1 t : t1lista) {
			resultado = resultado + t.getComisionAlSocio();
		}

		return resultado;
	}

	private void EntyToModelT1(Tipo1 tipo1, OperacionRequest request) {
		//transforma un Tipo1 en un request
		request.setId(tipo1.getId());
		request.setEstadoComision(tipo1.getEstadoComision());
		request.setEstadoOperacion(tipo1.getEstadoOperacion());
		request.setTasaDeDescuento(tipo1.getTasaDeDescuento());
		request.setComisionAlSocio(tipo1.getComisionAlSocio());
		request.setTipoDeOperacion(tipo1.getTipoDeOperacion());
		request.setMonto(tipo1.getMonto());
		request.setFecha(tipo1.getFecha());
		request.setCerificadoDeGarantia(tipo1.getCerificadoDeGarantia());
		//request.setLineaDeCredito(tipo1.getLineaDeCredito());

		request.setBancoCheques(tipo1.getBancoCheques());
		request.setNroCheques(tipo1.getNroCheques());
		request.setFechaVencimiento(tipo1.getFechaVencimiento());
		request.setCuitFirmante(tipo1.getCuitFirmante());
		request.setTipoDeOperacion(TipoDeOperacion.Tipo1);

	}

	private void EntyToModelT2(Tipo2 tipo2, OperacionRequest request) {
		//transforma un Tipo2 en un request
		request.setId(tipo2.getId());
		request.setEstadoComision(tipo2.getEstadoComision());
		request.setTasaDeDescuento(tipo2.getTasaDeDescuento());
		request.setComisionAlSocio(tipo2.getComisionAlSocio());
		request.setTipoDeOperacion(tipo2.getTipoDeOperacion());
		request.setEstadoOperacion(tipo2.getEstadoOperacion());
		request.setMonto(tipo2.getMonto());
		request.setFecha(tipo2.getFecha());
		request.setCerificadoDeGarantia(tipo2.getCerificadoDeGarantia());
		//request.setLineaDeCredito(tipo2.getLineaDeCredito());

		request.setEmpresaCuentaCorriente(tipo2.getEmpresaCuentaCorriente());
		request.setFechaVencimiento(tipo2.getFechaVencimiento());
		request.setTipoDeOperacion(TipoDeOperacion.Tipo2);



	}

	private void EntyToModelT3(Tipo3 tipo3, OperacionRequest request) {
		//transforma un Tipo3 en un request
		request.setId(tipo3.getId());
		request.setEstadoComision(tipo3.getEstadoComision());
		request.setTasaDeDescuento(tipo3.getTasaDeDescuento());
		request.setComisionAlSocio(tipo3.getComisionAlSocio());
		request.setTipoDeOperacion(tipo3.getTipoDeOperacion());
		request.setEstadoOperacion(tipo3.getEstadoOperacion());
		request.setMonto(tipo3.getMonto());
		request.setFecha(tipo3.getFecha());
		request.setCerificadoDeGarantia(tipo3.getCerificadoDeGarantia());
		//request.setLineaDeCredito(tipo3.getLineaDeCredito());

		request.setBanco(tipo3.getBanco());
		request.setFechaActualizacion(tipo3.getFechaActualizacion());
		request.setCantidadDeCuotas(tipo3.getCantidadDeCuotas());
		request.setTasa(tipo3.getTasa());
		request.setSistema(tipo3.getSistema());
		request.setCantidadDeCuotas(tipo3.getCantidadDeCuotas());
		request.setTipoDeOperacion(TipoDeOperacion.Tipo3);
	}



}

