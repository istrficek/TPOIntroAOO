package grupo12.entity;

import java.util.Date;

public class Operacion {
	
	private Integer id;
	
	private EstadoOperacion estadoOperacion;
	
	private Float tasaDeDescuento;
	
	private Float comisionAlSocio;
	
	private EstadoComision estadoComision;
	
	private TipoDeOperacion tipoDeOperacion;
	
	private Float monto;
	
	private Date fecha;

	private Integer idSocio;

	//private FondoDeRiesgo fondoDeRiesgo;

	private CertificadoDeGarantia cerificadoDeGarantia;

	private LineaDeCredito lineaDeCredito;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoOperacion getEstadoOperacion() {
		return estadoOperacion;
	}

	public void setEstadoOperacion(EstadoOperacion estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}

	public Float getTasaDeDescuento() {
		return tasaDeDescuento;
	}

	public void setTasaDeDescuento(Float tasaDeDescuento) {
		this.tasaDeDescuento = tasaDeDescuento;
	}

	public Float getComisionAlSocio() {
		return comisionAlSocio;
	}

	public void setComisionAlSocio(Float comisionAlSocio) {
		this.comisionAlSocio = comisionAlSocio;
	}

	public EstadoComision getEstadoComision() {
		return estadoComision;
	}

	public void setEstadoComision(EstadoComision estadoComision) {
		this.estadoComision = estadoComision;
	}

	public TipoDeOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}

	public void setTipoDeOperacion(TipoDeOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}
	
	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CertificadoDeGarantia getCerificadoDeGarantia() {
		return cerificadoDeGarantia;
	}

	public void setCerificadoDeGarantia(CertificadoDeGarantia cerificadoDeGarantia) {
		this.cerificadoDeGarantia = cerificadoDeGarantia;
	}

	public LineaDeCredito getLineaDeCredito() {
		return lineaDeCredito;
	}

	public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
		this.lineaDeCredito = lineaDeCredito;
	}

	public Integer getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}

	public Operacion() {
		super();
	}
	

	
	

}
