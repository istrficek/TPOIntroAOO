package grupo12.entity;

import java.util.Date;

public class Participe extends Socio {

	@Override
	public void setSaldoAcciones(int saldoAcciones) {
		// Set Acciones Tipo B
		super.setSaldoAcciones(saldoAcciones);
	}

	@Override
	public Integer getSaldoAcciones() {
		// Get Acciones Tipo B
		return super.getSaldoAcciones();
	}

	public LineaDeCredito lineaDeCredito;

	public LineaDeCredito getLineaDeCredito() {
		return lineaDeCredito;
	}

	public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
		this.lineaDeCredito = lineaDeCredito;
	}

	public boolean lineaDeCreditoVencida(){
		return lineaDeCredito.getVencimiento().compareTo(new Date()) < 0;
	}

	public boolean deudaMayorAlMaximo(Float deuda){
		return lineaDeCredito.getMonto() * 0.10 < deuda;
	}

	public Participe(Socio s){
		super(TipoSocio.Participe, s);
	}

	public Participe(){};

}
