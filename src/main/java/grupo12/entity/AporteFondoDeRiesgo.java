package grupo12.entity;

import java.util.Date;

public class AporteFondoDeRiesgo {
    private int id;
    private Float monto;
    private Date fechaAporte;
    private boolean aporteVigente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFechaAporte() {
        return fechaAporte;
    }

    public void setFechaAporte(Date fechaAporte) {
        this.fechaAporte = fechaAporte;
    }

    public boolean isAporteVigente() {
        return aporteVigente;
    }

    public void setAporteVigente(boolean aporteVigente) {
        this.aporteVigente = aporteVigente;
    }
}
