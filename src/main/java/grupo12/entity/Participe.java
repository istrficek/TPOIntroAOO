package grupo12.entity;

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

	public Participe(Socio s){
		super(TipoSocio.Participe, s);
	}

}
