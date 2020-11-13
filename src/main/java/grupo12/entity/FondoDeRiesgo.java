package grupo12.entity;

import grupo12.services.FondoDeRiesgoImp;

public class FondoDeRiesgo {

    private Integer id;

    private Float monto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FondoDeRiesgo obtenerMonto(Integer id) {


        FondoDeRiesgoImp fdrservice = new FondoDeRiesgoImp();

        return fdrservice.getById(id);

    }
}
