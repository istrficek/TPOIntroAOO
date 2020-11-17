package grupo12.entity;

import java.util.Date;
import java.util.List;

public class Tipo1 extends Operacion{
	
	private String bancoCheques;
	
	private Long nroCheques;
	
	private Date fechaVencimiento;
	
	private String cuitFirmante;

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

	public Tipo1() {
	}


	public Tipo1(String bancoCheques, Long nroCheques, Date fechaVencimiento, String cuitFirmante) {
		super();
		this.bancoCheques = bancoCheques;
		this.nroCheques = nroCheques;
		this.fechaVencimiento = fechaVencimiento;
		this.cuitFirmante = cuitFirmante;
	}
	
	
	
	
	
	
	
	
	
	

}
