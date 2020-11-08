package grupo12.services;

import java.util.List;

import grupo12.entity.Accionista;

public interface SocioService {

	Float getSaldoDeudor(Integer id);

	List<Accionista> getAccionistas(Integer id);

}
