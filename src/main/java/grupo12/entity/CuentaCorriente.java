package main.java.grupo12.entity;

import java.util.Date;

public class CuentaCorriente {
	
	private String empresaCuentaCorriente;
	
	private Float imprteTotal;
	
	private Date fechaVencimiento;

	public String getEmpresaCuentaCorriente() {
		return empresaCuentaCorriente;
	}

	public void setEmpresaCuentaCorriente(String empresaCuentaCorriente) {
		this.empresaCuentaCorriente = empresaCuentaCorriente;
	}

	public Float getImprteTotal() {
		return imprteTotal;
	}

	public void setImprteTotal(Float imprteTotal) {
		this.imprteTotal = imprteTotal;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public CuentaCorriente() {
		super();
	}
	
	

}
