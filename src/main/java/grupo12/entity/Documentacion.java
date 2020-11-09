package main.java.grupo12.entity;

public class Documentacion {
	
	private Integer id;
	
	private TipoDocumento tipoDocumento;
	
	private EstadoDocumento estadoDoc;
	
	private Boolean isObligatorio;

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
