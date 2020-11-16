package grupo12.services;

import java.util.Collections;
import java.util.List;

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

	public List<Socio> getSociosTipoEmpresa(TipoEmpresa tipoEmpresa) {
		return repository.getSocioTipoEmpresa(tipoEmpresa);
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

	public void save(Protector socio){
		repository.save(socio);
	}

	public Socio getParticipeById(Integer id) {
		return repository.getParticipeById(id);
	}

	public Protector getProtectorById(Integer id) {
		return repository.getProtectorById(id);
	}

}
