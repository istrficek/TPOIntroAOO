package main.java.grupo12.services;

import main.java.grupo12.entity.Accionista;

public interface AccionistaService {

	void save(Accionista nuev);

	Accionista getById(Integer id);

	Accionista edit(Accionista nuev);

	void deleteById(Integer id);

}
