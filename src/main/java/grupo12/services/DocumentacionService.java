package grupo12.services;

import grupo12.entity.Documentacion;

public interface DocumentacionService {

	void save(Documentacion nuev);

	Documentacion getById(Integer id);

	Documentacion edit(Documentacion viej);

	Documentacion deleteById(Integer id);

}
