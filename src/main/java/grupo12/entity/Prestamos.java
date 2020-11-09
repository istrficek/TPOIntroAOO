package main.java.grupo12.entity;

import java.util.Date;

public class Prestamos {
	
	private String banco;
	
	private Float importe;
	
	private Date fechaDeAcreditacion;
	
	private Integer cantidadCuotas;
	
	private Integer tasa;
	
	private Sistema sistema;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Date getFechaDeAcreditacion() {
		return fechaDeAcreditacion;
	}

	public void setFechaDeAcreditacion(Date fechaDeAcreditacion) {
		this.fechaDeAcreditacion = fechaDeAcreditacion;
	}

	public Integer getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(Integer cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
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

	public Prestamos() {
		super();
	}
	
	

}
