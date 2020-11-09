package main.java.grupo12.entity;

import java.util.Date;

public class Aporte {

	private Integer id;
	
	private Float valor;
	
	private Date fechaAporte;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getFechaAporte() {
		return fechaAporte;
	}

	public void setFechaAporte(Date fechaAporte) {
		this.fechaAporte = fechaAporte;
	}

	public Aporte() {
		super();
	}
	
	
	
	
}
