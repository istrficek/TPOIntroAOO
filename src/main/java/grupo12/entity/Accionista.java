package grupo12.entity;

public class Accionista {
	
	private Integer id;
	
	private String razonSocial;

	private String Cuit;
	
	private Integer porcentajedeParticipacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCuit() {
		return Cuit;
	}

	public void setCuit(String cuit) {
		Cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Integer getPorcentajedeParticipacion() {
		return porcentajedeParticipacion;
	}

	public void setPorcentajedeParticipacion(Integer porcentajedeParticipacion) {
		this.porcentajedeParticipacion = porcentajedeParticipacion;
	}

	public Accionista() {
		super();
	}

	@Override
	public String toString() {
		return "Accionista{" +
				"id=" + id +
				", razonSocial='" + razonSocial + '\'' +
				", Cuit='" + Cuit + '\'' +
				", porcentajedeParticipacion=" + porcentajedeParticipacion +
				'}';
	}
}
