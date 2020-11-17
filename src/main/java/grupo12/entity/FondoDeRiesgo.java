package grupo12.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FondoDeRiesgo {

    private List<AporteFondoDeRiesgo> aportes;

    public void setAportes(List<AporteFondoDeRiesgo> aportes) {
        this.aportes = aportes;
    }

    public List<AporteFondoDeRiesgo> getAportes() {
        return aportes;
    }

    public Float obtenerMonto() {
        Float montoTotal = 0F;

        for (AporteFondoDeRiesgo a : aportes.stream().filter(ap -> ap.isAporteVigente()).collect(Collectors.toList())) {
            montoTotal += a.getMonto();
        }
        return montoTotal;

    }
}
