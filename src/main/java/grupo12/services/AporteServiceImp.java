package grupo12.services;

import grupo12.entity.Aporte;
import grupo12.repository.AporteRepository;

import java.util.List;

public class AporteServiceImp implements AporteService {

    AporteRepository repository = new AporteRepository();

    public boolean save(Aporte aporte) {
        return repository.save(aporte);
    }

    public boolean update(Aporte a) {
        return repository.update(a);
    }

    public List<Aporte> getAportes() {
        return repository.getAll();
    }

    public boolean eliminarAporte(int id) {
        return repository.deleteById(id);
    }
}
