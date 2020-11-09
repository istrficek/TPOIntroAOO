package grupo12.services;

import java.util.List;

import grupo12.entity.Accionista;
import grupo12.entity.Participe;
import grupo12.entity.Protector;
import grupo12.entity.Socio;
import grupo12.entity.TipoEmpresa;



public interface SocioService {

	Float getSaldoDeudor(Integer id);

	List<Accionista> getAccionistas(Integer id);

	List<Participe> getSociosParticipes();

	List<Socio> getSociosTipoEmpresa(TipoEmpresa tipoEmpresa);

	Socio getSocio(Integer id);

	void save(Participe socio);

	void save(Protector socio);

	Participe getParticipeById(Integer id);

	Protector getProtectorById(Integer id);

}
