package grupo12.entity;

import java.util.ArrayList;
import java.util.List;

public class HistorialSocio {
    private List<Operacion> operaciones = new ArrayList<>();

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void addOperacion(Operacion o) {
        operaciones.add(o);
    }

    //TODO Obtener el salgo deudor!
    public float getSaldoDeudor() {
        return 0;
    }
}
