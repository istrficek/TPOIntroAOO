package main.java.grupo12.entity;

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

	public Operacion() {
		super();
	}
	
	
	
	public void ObtenerTasaDeDescuento() {
		
	}
	
	public Float ObtenerMonto(Integer id) {
		
		//servicio que busca la operacion con el id como parametro
		//se hace un get monto de la operacion encontrada
		return null;
	}
	
	public Float ObtenerRiesgoVivo(Integer id) {
		
		//servicio que busca la operacion con el id como parametro
		//se hace un get monto de la operacion encontrada
		return null;
	}

	public Operacion(Integer id, EstadoOperacion estadoOperacion, Float tasaDeDescuento, Float comisionAlSocio,
			EstadoComision estadoComision, TipoDeOperacion tipoDeOperacion, Float monto, Date fecha) {
		super();
		this.id = id;
		this.estadoOperacion = estadoOperacion;
		this.tasaDeDescuento = tasaDeDescuento;
		this.comisionAlSocio = comisionAlSocio;
		this.estadoComision = estadoComision;
		this.tipoDeOperacion = tipoDeOperacion;
		this.monto = monto;
		this.fecha = fecha;
	}
	
	
	

}
