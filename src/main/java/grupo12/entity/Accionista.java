package main.java.grupo12.entity;

public class Accionista {
	
	private Integer id;
	
	private String razonSocial;
	
	private Integer porcentajedeParticipacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	

}
