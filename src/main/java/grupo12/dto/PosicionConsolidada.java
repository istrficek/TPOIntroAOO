package grupo12.dto;

import grupo12.entity.Operacion;
import grupo12.request.OperacionRequest;

import java.util.ArrayList;
import java.util.List;

public class PosicionConsolidada {
    private List<Operacion> operacionesMonetizadasNoVencidas;
    private Float riesgoVivo;
    private Float totalUtilizado;
    private List<Operacion> operacionesConCertificadoEmitido;

    public List<OperacionRequest> getOperacionesMonetizadasNoVencidas() {
        List<OperacionRequest> operacionRequestList = new ArrayList<>();
        for (Operacion o: operacionesMonetizadasNoVencidas) {
            OperacionRequest or = new OperacionRequest(){{
                setId(o.getId());
                setEstadoOperacion(o.getEstadoOperacion());
                setTasaDeDescuento(o.getTasaDeDescuento());
                setComisionAlSocio(o.getComisionAlSocio());
                setEstadoComision(o.getEstadoComision());
                setTipoDeOperacion(o.getTipoDeOperacion());
                setMonto(o.getMonto());
                setFecha(o.getFecha());
            }};
        }
        return operacionRequestList;
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

    public List<OperacionRequest> getOperacionesConCertificadoEmitido() {
        List<OperacionRequest> operacionRequestList = new ArrayList<>();
        for (Operacion o: operacionesConCertificadoEmitido) {
            OperacionRequest or = new OperacionRequest(){{
                setId(o.getId());
                setEstadoOperacion(o.getEstadoOperacion());
                setTasaDeDescuento(o.getTasaDeDescuento());
                setComisionAlSocio(o.getComisionAlSocio());
                setEstadoComision(o.getEstadoComision());
                setTipoDeOperacion(o.getTipoDeOperacion());
                setMonto(o.getMonto());
                setFecha(o.getFecha());
            }};
        }
        return operacionRequestList;
    }

    public void setOperacionesConCertificadoEmitido(List<Operacion> operacionesConCertificadoEmitido) {
        this.operacionesConCertificadoEmitido = operacionesConCertificadoEmitido;
    }
}
