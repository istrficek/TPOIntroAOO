package grupo12.services;

import grupo12.entity.AporteFondoDeRiesgo;
import grupo12.entity.FondoDeRiesgo;

public interface FondoDeRiesgoService {

    FondoDeRiesgo getFondoDeRiesgo();

    boolean insertAporteFondoDeRiesgo(AporteFondoDeRiesgo aporteFondoDeRiesgo);

}
