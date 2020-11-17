package grupo12.entity;

import java.util.Collections;
import java.util.Date;
import java.util.List;

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
	
	private List<Accionista> accionistas;

	private Integer saldoAcciones;

	private String tipoSocioString;

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
	
	public List<Accionista> getAccionistas() {
		return accionistas;
	}

	public void setAccionistas(List<Accionista> accionistas) {
		this.accionistas = accionistas;
	}

	public Integer getSaldoAcciones() { return  saldoAcciones; }

	public void setSaldoAcciones(int saldoAcciones) { this.saldoAcciones = saldoAcciones; }

	public TipoSocio getTipoSocio() {return TipoSocio.valueOf(tipoSocioString);}

	public void setTipoSocio(TipoSocio ts) {tipoSocioString = ts.name();}

	public Socio(TipoSocio tipoSocio, Socio s) {
		setTipoSocio(tipoSocio);
	}

	public Socio() {

	}

	public Socio(Socio p){
		this.accionistas = p.getAccionistas();
		this.actividadPrincipal = p.getActividadPrincipal();
		this.cuit = p.getCuit();
		this.direccion = p.getDireccion();
		this.email = p.getEmail();
		this.estadoSocio = p.getEstadoSocio();
		this.fechaInicio = p.getFechaInicio();
		this.id = p.getId();
		this.razonSocial = p.getRazonSocial();
		this.saldoAcciones = p.getSaldoAcciones();
		this.telefono = p.getTelefono();
		this.tipoEmpresa = p.getTipoEmpresa();
		this.setTipoSocio(TipoSocio.Participe);
	}

	public Socio(Protector p){
		this.accionistas = p.getAccionistas();
		this.actividadPrincipal = p.getActividadPrincipal();
		this.cuit = p.getCuit();
		this.direccion = p.getDireccion();
		this.email = p.getEmail();
		this.estadoSocio = p.getEstadoSocio();
		this.fechaInicio = p.getFechaInicio();
		this.id = p.getId();
		this.razonSocial = p.getRazonSocial();
		this.saldoAcciones = p.getSaldoAcciones();
		this.telefono = p.getTelefono();
		this.tipoEmpresa = p.getTipoEmpresa();
		this.setTipoSocio(TipoSocio.Protector);
	}

	@Override
	public String toString() {

		return "Socio{" +
				"id=" + id +
				", cuit='" + cuit + '\'' +
				", razonSocial='" + razonSocial + '\'' +
				", fechaInicio=" + fechaInicio +
				", actividadPrincipal='" + actividadPrincipal + '\'' +
				", direccion='" + direccion + '\'' +
				", telefono='" + telefono + '\'' +
				", email='" + email + '\'' +
				", estadoSocio=" + estadoSocio +
				", tipoEmpresa=" + tipoEmpresa +
				", accionistas=" + accionistas +
				", saldoAcciones=" + saldoAcciones +
				", tipoSocioString='" + tipoSocioString + '\'' +
				'}';
	}
}
