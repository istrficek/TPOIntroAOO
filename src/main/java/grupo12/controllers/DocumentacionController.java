package grupo12.controllers;

import grupo12.entity.Documentacion;
import grupo12.services.DocumentacionService;

public class DocumentacionController {
	
	DocumentacionService documentacionService;
	
	public void crearDocumentacion(Documentacion docu){
		Documentacion nuev = new Documentacion();
		nuev.setEstadoDoc(docu.getEstadoDoc());
		nuev.setIsObligatorio(docu.getIsObligatorio());
		nuev.setTipoDocumento(docu.getTipoDocumento());
		documentacionService.save(nuev);
	}
	
	public Documentacion editarDocumentacion(Integer id, Documentacion docu){
		
		Documentacion viej = documentacionService.getById(id);
		
		viej.setEstadoDoc(docu.getEstadoDoc());
		viej.setIsObligatorio(docu.getIsObligatorio());
		viej.setTipoDocumento(docu.getTipoDocumento());
		return documentacionService.edit(viej);
	}
	
	public Documentacion getDocumentacion(Integer id){
		return documentacionService.getById(id);
	}
	
	public boolean deleteDocumentacion(Integer id){
		return documentacionService.deleteById(id);
			
	}

}
