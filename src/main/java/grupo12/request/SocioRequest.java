package grupo12.request;

import java.util.Date;
import java.util.List;

import grupo12.entity.Accionista;
import grupo12.entity.EstadoSocio;
import grupo12.entity.TipoEmpresa;



public class SocioRequest {
	
	private boolean  isParticipe;
	
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
	
	private Integer saldoAccionesTipo;
	
	private List<Accionista> accionistas;

	public boolean isParticipe() {
		return isParticipe;
	}

	public void setParticipe(boolean isParticipe) {
		this.isParticipe = isParticipe;
	}

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

	public Integer getSaldoAccionesTipo() {
		return saldoAccionesTipo;
	}

	public void setSaldoAccionesTipo(Integer saldoAccionesTipo) {
		this.saldoAccionesTipo = saldoAccionesTipo;
	}

	public List<Accionista> getAccionistas() {
		return accionistas;
	}

	public void setAccionistas(List<Accionista> accionistas) {
		this.accionistas = accionistas;
	}
	
	
	
	
	
	
	

}
