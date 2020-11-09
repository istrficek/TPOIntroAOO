package grupo12.entity;

import java.util.Date;

public class LineaDeCredito {
	
	private Integer id;
	
	private Float monto;
	
	private Date vencimiento;
	
	private Boolean lineaAprobada;
	
	private TipoDeOperacion tipoDeOperacion;

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

	public TipoDeOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}

	public void setTipoDeOperacion(TipoDeOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}

	public LineaDeCredito() {
		super();
	}
	
	
	
	

}
