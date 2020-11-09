package grupo12.services;

import grupo12.entity.Accionista;

public interface AccionistaService {

	void save(Accionista nuev);

	Accionista getById(Integer id);

	Accionista edit(Accionista nuev);

	void deleteById(Integer id);

}
