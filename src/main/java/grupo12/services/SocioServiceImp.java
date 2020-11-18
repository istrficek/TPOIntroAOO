package grupo12.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import grupo12.dto.PosicionConsolidada;
import grupo12.dto.PromedioTasaYTotal;
import grupo12.entity.*;
import grupo12.repository.SocioRepository;


public class SocioServiceImp implements SocioService {

	SocioRepository repository = new SocioRepository();

	public Float getSaldoDeudor(Integer idSocio) {
		Float saldoDeudor = 0F;
		List<Operacion> operaciones = repository.getOperaciones(idSocio);
		for (Operacion o: operaciones) {
			if(o.getTipoDeOperacion() == TipoDeOperacion.Tipo3){
				Tipo3 t3 = repository.getOperacionTipo3(o.getId());
				saldoDeudor += t3.getSaldoDeudor();
			}
		}
		return saldoDeudor;
	}

	public List<Accionista> getAccionistas(Integer idSocio) {
		return repository.getAccionistas(idSocio);
	}

	public List<Participe> getSociosParticipes() {
		return repository.getAllParticipe();
	}

	public List<Protector> getSociosProtectores() {
		return repository.getAllProtector();
	}

	public boolean saveAporte(int idSocio, Aporte a) {
		return false;
	}

	public boolean validarOperacion(Operacion operacion) {
		// Linea de credito vencida
		if(operacion.getSocio().lineaDeCreditoVencida())
			return false;

		// El socio debe facturas por mas del 10% del monto de la linea de credito
		if(operacion.getSocio().deudaMayorAlMaximo(getSaldoDeudor(operacion.getSocio().getId())))
			return  false;

		return true;
	}

	public boolean verificarSocio(Socio s) {
		List<Accionista> accionistas = getAccionistas(s.getId());
		List<Participe> participes = getSociosParticipes();

		for (Participe p:participes) {
			List<Accionista> accionistasDelSocio = getAccionistas(p.getId());
			if(Collections.disjoint(accionistas, accionistasDelSocio))
				return false;
		}
		return true;
	}

	public PromedioTasaYTotal obtenerValorPromedioTasaDescuentoYTotalOperado(TipoEmpresa tipoEmpresa, Date fechaInicio, Date fechaFin) {
		PromedioTasaYTotal resultado = new PromedioTasaYTotal();
		Float promedioTasaDescuento = 0F;
		Float promedioTotalOperado = 0F;

		List<Socio> socios = getSociosTipoEmpresa(tipoEmpresa);
		List<Operacion> operaciones = repository.getOperacionesDeSociosPorTipo(socios, TipoDeOperacion.Tipo1);

		for (Operacion o : operaciones) {
			promedioTasaDescuento += o.getTasaDeDescuento();
			promedioTotalOperado += o.getMonto();
		}

		if(operaciones.size() > 0){
			resultado.setPromedioTasaDecuento(promedioTasaDescuento/operaciones.size());
			resultado.setPromedioTotalOperado(promedioTotalOperado/operaciones.size());
		}

		return resultado;
	}

	public Float obtenerComisionPorTipoDeOperacion(TipoDeOperacion tipoDeOperacion, Socio socio) {
		List<Socio> socioList = new ArrayList<>();
		Float comisionPromedio = 0F;
		socioList.add(socio);
		List<Operacion> operaciones = repository.getOperacionesDeSociosPorTipo(socioList, tipoDeOperacion);

		for (Operacion o:operaciones) {
			comisionPromedio += o.getComisionAlSocio();
		}

		return comisionPromedio/operaciones.size();
	}

	public PosicionConsolidada obtenerPosicionConsolidada(Integer idSocio) {
		PosicionConsolidada posicionConsolidada = new PosicionConsolidada();
		Float riesgoVivo = 0F;
		Float totalUtilizado = 0F;
		List<Operacion> operacionesMonetizadas = repository.getOperacionesPorEstado(idSocio, EstadoOperacion.Monetizada);
		List<Operacion> operacionesCertificadoEmitido = repository.getOperacionesPorEstado(idSocio, EstadoOperacion.ConCertificadoEmitido);
		posicionConsolidada.setOperacionesMonetizadasNoVencidas(operacionesMonetizadas);

		for (Operacion o: operacionesMonetizadas) {
			switch (o.getTipoDeOperacion()){
				case Tipo1:
				case Tipo2:
					riesgoVivo += o.getMonto();
					break;
				case Tipo3:
					Tipo3 operacionTipo3 = repository.getOperacionTipo3(o.getId());
					riesgoVivo += operacionTipo3.getSaldoDeudor();
					break;
			}
		}

		for (Operacion o: operacionesCertificadoEmitido) {
			totalUtilizado += o.getMonto();
		}

		totalUtilizado += riesgoVivo;
		posicionConsolidada.setOperacionesConCertificadoEmitido(operacionesCertificadoEmitido);
		posicionConsolidada.setRiesgoVivo(riesgoVivo);
		posicionConsolidada.setTotalUtilizado(totalUtilizado);

		return posicionConsolidada;
	}

	public List<Socio> getSociosTipoEmpresa(TipoEmpresa tipoEmpresa) {
		return repository.getSocioTipoEmpresa(tipoEmpresa);
	}

	public List<Socio> getSocios() {
		return repository.getAll();
	}

	public Socio getSocio(Integer id) {
		return repository.getById(id);
	}

	public void save(Socio socio){
		repository.save(socio);
	}

	public boolean update(Socio socio){
		return repository.updateSocio(socio);
	}

	public Socio getParticipeById(Integer id) {
		return repository.getParticipeById(id);
	}

	public Protector getProtectorById(Integer id) {
		return repository.getProtectorById(id);
	}
}
