package grupo12.entity;

import java.util.Date;
import java.util.List;

public class LineaDeCredito {
	
	private Integer id;
	
	private Float monto;
	
	private Date vencimiento;
	
	private Boolean lineaAprobada;
	
	private List<TipoDeOperacion> tipoDeOperacionAprobada;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Boolean getLineaAprobada() {
		return lineaAprobada;
	}

	public void setLineaAprobada(Boolean lineaAprobada) {
		this.lineaAprobada = lineaAprobada;
	}

	public List<TipoDeOperacion> getTipoDeOperacionAprobada() {
		return tipoDeOperacionAprobada;
	}

	public void setTipoDeOperacionAprobada(List<TipoDeOperacion> tipoDeOperacionAprobada) {
		this.tipoDeOperacionAprobada = tipoDeOperacionAprobada;
	}

	public LineaDeCredito() {
		super();
	}
	
	
	
	

}
