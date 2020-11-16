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

	private FondoDeRiesgo fondoDeRiesgo;

	private CertificadoDeGarantia cerificadoDeGarantia;

	private Participe socio;

	public Participe getSocio() {
		return socio;
	}

	public void setSocio(Participe socio) {
		this.socio = socio;
	}

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

	public FondoDeRiesgo getFondoDeRiesgo() {
		return fondoDeRiesgo;
	}

	public void setFondoDeRiesgo(FondoDeRiesgo fondoDeRiesgo) {
		this.fondoDeRiesgo = fondoDeRiesgo;
	}

	public CertificadoDeGarantia getCerificadoDeGarantia() {
		return cerificadoDeGarantia;
	}

	public void setCerificadoDeGarantia(CertificadoDeGarantia cerificadoDeGarantia) {
		this.cerificadoDeGarantia = cerificadoDeGarantia;
	}

	public Operacion() {
		super();
	}
}
