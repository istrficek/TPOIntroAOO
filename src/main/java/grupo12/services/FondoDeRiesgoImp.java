package grupo12.services;

import grupo12.repository.FondoDeRiesgoRepository;

public class FondoDeRiesgoImp implements FondoDeRiesgo{

    FondoDeRiesgoRepository repo = new FondoDeRiesgoRepository();

    @Override
    public grupo12.entity.FondoDeRiesgo getById(Integer id) {
        return repo.getById(id);
    }
}
