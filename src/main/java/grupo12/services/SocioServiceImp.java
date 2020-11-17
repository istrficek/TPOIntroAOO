package grupo12.services;

import java.util.List;

import grupo12.entity.*;
import grupo12.repository.SocioRepository;


public class SocioServiceImp implements SocioService {

	SocioRepository repository = new SocioRepository();

	public Float getSaldoDeudor(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Accionista> getAccionistas(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Participe> getSociosParticipes() {
		return repository.getAllParticipe();
	}

	public List<Protector> getSociosProtectores() {
		return repository.getAllProtector();
	}

	public List<Socio> getSociosTipoEmpresa(TipoEmpresa tipoEmpresa) {
		// TODO Auto-generated method stub
		return null;
	}

	public Socio getSocio(Integer id) {
		return repository.getById(id);
	}

	public void save(Participe socio){
		repository.save(socio);
	}

	public void save(Protector socio){
		repository.save(socio);
	}

	public Participe getParticipeById(Integer id) {
		Socio s = repository.getById(id);
		if(s.getTipoSocio() == TipoSocio.Participe)
			return new Participe(s);
		return null;
	}

	public Protector getProtectorById(Integer id) {
		Socio s = repository.getById(id);
		if(s.getTipoSocio() == TipoSocio.Protector)
			return new Protector(s);
		return null;
	}

	@Override
	public Socio getSocioByTipoEmpresa(TipoEmpresa tipoEmpresa) {
		return repository.getByTipoEmpresa(tipoEmpresa);
	}

}
