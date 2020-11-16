package grupo12.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tipo3 extends Operacion{
	
	private String banco;
	
	private Date fechaActualizacion;
	
	private Integer cantidadDeCuotas;
	
	private Integer tasa;
	
	private Sistema sistema;

	private List<Cuota> cuotas;

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

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
		this.cantidadDeCuotas = cuotas.size();
	}

	public List<Cuota> getCuotas() {return this.cuotas;}

	public List<Cuota> getCuotasVencidas(){
		List<Cuota> vencidas = new ArrayList<>();

		for (Cuota c: cuotas) {
			if(!c.isPaga()){
				if(c.getFechaVencimiento().compareTo(new Date()) < 0)
					vencidas.add(c);
			}
		}
		return vencidas;
	}

	public Float getSaldoDeudor(){
		Float saldoDeudor = 0F;
		for (Cuota c: getCuotasVencidas()) {
			saldoDeudor += c.getValor();
		}
		return saldoDeudor;
	}
	

}
