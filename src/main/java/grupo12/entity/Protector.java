package grupo12.entity;

public class Protector extends Socio{

	@Override
	public void setSaldoAcciones(int saldoAcciones) {
		// Set Acciones Tipo A
		super.setSaldoAcciones(saldoAcciones);
	}

	@Override
	public Integer getSaldoAcciones() {
		// Get Acciones Tipo A
		return super.getSaldoAcciones();
	}

	public Protector(Socio s){
		super(TipoSocio.Protector, s);
	}

}
