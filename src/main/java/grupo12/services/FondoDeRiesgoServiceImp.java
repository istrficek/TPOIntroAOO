package grupo12.services;

import grupo12.entity.FondoDeRiesgo;
import grupo12.repository.FondoDeRiesgoRepository;

public class FondoDeRiesgoServiceImp implements FondoDeRiesgoService {

    FondoDeRiesgoRepository repository = new FondoDeRiesgoRepository();

    @Override
    public FondoDeRiesgo getFondoDeRiesgo() {
        return repository.getFondoDeRiesgo();
    }
}
