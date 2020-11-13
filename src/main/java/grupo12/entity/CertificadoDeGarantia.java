package grupo12.entity;

import grupo12.services.CertificadoDeGarantiaService;
import grupo12.services.CertificadoDeGarantiaServiceImp;

public class CertificadoDeGarantia {
	
	private Integer id;
	
	private Integer numero;
	
	private String descripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CertificadoDeGarantia() {
		super();
	}

	public CertificadoDeGarantia ObtenerCertificadoGarantia(Integer id){

		CertificadoDeGarantiaServiceImp certificadoDeGarantiaService = new CertificadoDeGarantiaServiceImp();

		return certificadoDeGarantiaService.getById(id);

	}
	
	
	
	

}
