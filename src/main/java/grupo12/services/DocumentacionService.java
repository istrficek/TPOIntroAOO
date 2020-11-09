package main.java.grupo12.services;

import main.java.grupo12.entity.Documentacion;

public interface DocumentacionService {

	void save(Documentacion nuev);

	Documentacion getById(Integer id);

	Documentacion edit(Documentacion viej);

	Documentacion deleteById(Integer id);

}
