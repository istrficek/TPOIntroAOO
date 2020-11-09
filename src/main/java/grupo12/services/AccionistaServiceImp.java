package grupo12.services;

import grupo12.entity.Accionista;
import grupo12.repository.AccionistaRepository;

import java.util.List;

public class AccionistaServiceImp implements AccionistaService{

	private AccionistaRepository repository = new AccionistaRepository();

	public void save(Accionista nuev) {
		repository.save(nuev);
	}

	public Accionista getById(Integer id) {
		return repository.getById(id);
	}

	public Accionista edit(Accionista nuev) {
		return repository.edit(nuev);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public List<Accionista> getAll(){
		return repository.getAll();
	}

}
