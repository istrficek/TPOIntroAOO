package grupo12.services;

import java.util.List;

import grupo12.entity.*;
import grupo12.repository.SocioRepository;


public class SocioServiceImp implements SocioService {

	SocioRepository repository = new SocioRepository();

	public Float getSaldoDeudor(Integer id) {
		return 120.3F;
	}

	public List<Accionista> getAccionistas(Integer id) {
		return repository.getAccionistas(id);
	}

	public List<Participe> getSociosParticipes() {
		return repository.getAllParticipe();
	}

	public List<Protector> getSociosProtectores() {
		return repository.getAllProtector();
	}

	public List<Socio> getSociosTipoEmpresa(TipoEmpresa tipoEmpresa) {
		return repository.getSocioTipoEmpresa(tipoEmpresa);
	}

	public Socio getSocio(Integer id) {
		return repository.getById(id);
	}

	public void save(Participe socio){
		repository.save(socio);
	}

	public boolean update(Socio socio){
		return repository.updateSocio(socio);
	}

	public void save(Protector socio){
		repository.save(socio);
	}

	public Participe getParticipeById(Integer id) {
		return repository.getParticipeById(id);
	}

	public Protector getProtectorById(Integer id) {
		return repository.getProtectorById(id);
	}

}
