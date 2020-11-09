package main.java.grupo12.entity;

import java.util.Date;
import java.util.List;

public class Tipo3 extends Operacion{
	
	private String banco;
	
	private Date fechaActualizacion;
	
	private Integer cantidadDeCuotas;
	
	private Integer tasa;
	
	private Sistema sistema;

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
	
	public List<Tipo3>ObtenerOperacion() {
		return null;
	}
	
	
	///////////////consultar///////////////////////////////////
	public void ObtenerCuotasImpagas() {
		
	}
	
	
	
	
	
	

}
