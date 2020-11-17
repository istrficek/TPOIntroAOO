package grupo12.entity;

import java.util.Date;

public class Cheque {
	
	private String bancoCheque;
	
	private Long nroChque;

	private Float monto;
	
	private Date fechaDeVencimiento;
	
	private String cuitFirmante;

	public String getBancoCheque() {
		return bancoCheque;
	}

	public void setBancoCheque(String bancoCheque) {
		this.bancoCheque = bancoCheque;
	}

	public Long getNroChque() {
		return nroChque;
	}

	public void setNroChque(Long nroChque) {
		this.nroChque = nroChque;
	}

	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public String getCuitFirmante() {
		return cuitFirmante;
	}

	public void setCuitFirmante(String cuitFirmante) {
		this.cuitFirmante = cuitFirmante;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Cheque() {
		super();
	}
	
	

}
