package grupo12.entity;

import java.util.Date;

public class Documentacion {
	
	private Integer id;
	
	private TipoDocumento tipoDocumento;
	
	private EstadoDocumento estadoDoc;
	
	private Boolean isObligatorio;

	public Boolean getObligatorio() {
		return isObligatorio;
	}

	public void setObligatorio(Boolean obligatorio) {
		isObligatorio = obligatorio;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	private Date fechaRecepcion;

	private String usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public EstadoDocumento getEstadoDoc() {
		return estadoDoc;
	}

	public void setEstadoDoc(EstadoDocumento estadoDoc) {
		this.estadoDoc = estadoDoc;
	}

	public Boolean getIsObligatorio() {
		return isObligatorio;
	}

	public void setIsObligatorio(Boolean isObligatorio) {
		this.isObligatorio = isObligatorio;
	}

	public Documentacion() {
		super();
	}
	
	
	
	

}
