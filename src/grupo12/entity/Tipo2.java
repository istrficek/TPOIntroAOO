package grupo12.entity;

import java.util.Date;
import java.util.List;

public class Tipo2 extends Operacion{
	
	private String empresaCuentaCorriente;
	
	private Date fechaVencimiento;

	public String getEmpresaCuentaCorriente() {
		return empresaCuentaCorriente;
	}

	public void setEmpresaCuentaCorriente(String empresaCuentaCorriente) {
		this.empresaCuentaCorriente = empresaCuentaCorriente;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Tipo2() {
	}
	
	public List<Tipo2> ObtenerOperaciones(){
		
		return null;
	}
	
	public Float ObtenerImporteUtilizado() {
		return null;
		
	}
	
	
	

}
