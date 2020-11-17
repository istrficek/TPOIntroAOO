package grupo12.services;

import grupo12.entity.Documentacion;

import java.util.List;

public interface DocumentacionService {

	void save(Documentacion nuev);

	Documentacion getById(Integer id);

	Documentacion edit(Documentacion viej);

	boolean deleteById(Integer id);

	List<Documentacion> getAllDocumentacion();
}
