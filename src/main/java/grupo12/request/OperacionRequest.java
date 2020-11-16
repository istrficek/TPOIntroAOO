package grupo12.request;

import java.util.Date;
import java.util.List;

import grupo12.entity.*;


public class OperacionRequest {

    //var para identidicar tipo de operacion
	private Integer tipoOpe;
	
	
	//Objeto Operacion
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

	private LineaDeCredito lineaDeCredito;
	
	//Tipo 1
	private String bancoCheques;
	
	private Long nroCheques;
	
	private Date fechaVencimiento;
	
	private String cuitFirmante;
	
	//Tipo 2
	
	private String empresaCuentaCorriente;
	
	//private Date fechaVencimiento;
	
	//Tipo 3

	private List<Cuota> cuotas;
	
	private String banco;
	
	private Date fechaActualizacion;
	
	private Integer cantidadDeCuotas;
	
	private Integer tasa;
	
	private Sistema sistema;

	public EstadoOperacion getEstadoOperacion() {
		return estadoOperacion;
	}

	public List<Cuota> getCuotas() {return cuotas;}

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

	public String getBancoCheques() {
		return bancoCheques;
	}

	public void setBancoCheques(String bancoCheques) {
		this.bancoCheques = bancoCheques;
	}

	public Long getNroCheques() {
		return nroCheques;
	}

	public void setNroCheques(Long nroCheques) {
		this.nroCheques = nroCheques;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCuitFirmante() {
		return cuitFirmante;
	}

	public void setCuitFirmante(String cuitFirmante) {
		this.cuitFirmante = cuitFirmante;
	}

	public String getEmpresaCuentaCorriente() {
		return empresaCuentaCorriente;
	}

	public void setEmpresaCuentaCorriente(String empresaCuentaCorriente) {
		this.empresaCuentaCorriente = empresaCuentaCorriente;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Integer getCantidadDeCuotas() {
		return cantidadDeCuotas;
	}

	public void setCantidadDeCuotas(Integer cantidadDeCuotas) {
		this.cantidadDeCuotas = cantidadDeCuotas;
	}

	public Integer getTasa() {
		return tasa;
	}

	public void setTasa(Integer tasa) {
		this.tasa = tasa;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Integer getTipoOpe() {
		return tipoOpe;
	}

	public void setTipoOpe(Integer tipoOpe) {
		this.tipoOpe = tipoOpe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LineaDeCredito getLineaDeCredito() {
		return lineaDeCredito;
	}

	public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
		this.lineaDeCredito = lineaDeCredito;
	}
}
