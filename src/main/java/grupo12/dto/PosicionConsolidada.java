package grupo12.dto;

import grupo12.entity.Operacion;

import java.util.List;

public class PosicionConsolidada {
    private List<Operacion> operacionesMonetizadasNoVencidas;
    private Float riesgoVivo;
    private Float totalUtilizado;
    private List<Operacion> operacionesConCertificadoEmitido;

    public List<Operacion> getOperacionesMonetizadasNoVencidas() {
        return operacionesMonetizadasNoVencidas;
    }

    public void setOperacionesMonetizadasNoVencidas(List<Operacion> operacionesMonetizadasNoVencidas) {
        this.operacionesMonetizadasNoVencidas = operacionesMonetizadasNoVencidas;
    }

    public Float getRiesgoVivo() {
        return riesgoVivo;
    }

    public void setRiesgoVivo(Float riesgoVivo) {
        this.riesgoVivo = riesgoVivo;
    }

    public Float getTotalUtilizado() {
        return totalUtilizado;
    }

    public void setTotalUtilizado(Float totalUtilizado) {
        this.totalUtilizado = totalUtilizado;
    }

    public List<Operacion> getOperacionesConCertificadoEmitido() {
        return operacionesConCertificadoEmitido;
    }

    public void setOperacionesConCertificadoEmitido(List<Operacion> operacionesConCertificadoEmitido) {
        this.operacionesConCertificadoEmitido = operacionesConCertificadoEmitido;
    }
}
