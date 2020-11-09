package grupo12.entity;

import java.util.Date;

public class Socio {
	
	private Integer id;
	
	private String cuit;
	
	private String razonSocial;
	
	private Date fechaInicio;
	
	private String actividadPrincipal;
	
	private String direccion;
	
	private String telefono;
	
	private String email;
	
	private EstadoSocio estadoSocio;
	
	private TipoEmpresa tipoEmpresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getActividadPrincipal() {
		return actividadPrincipal;
	}

	public void setActividadPrincipal(String actividadPrincipal) {
		this.actividadPrincipal = actividadPrincipal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoSocio getEstadoSocio() {
		return estadoSocio;
	}

	public void setEstadoSocio(EstadoSocio estadoSocio) {
		this.estadoSocio = estadoSocio;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public Socio() {
	}
	
	
	
	
	
	

}