package grupo12.controllers;

import grupo12.entity.Documentacion;
import grupo12.services.DocumentacionService;
import grupo12.services.DocumentacionServiceImp;

import java.util.List;

public class DocumentacionController {
	
	DocumentacionService documentacionService = new DocumentacionServiceImp();
	
	public boolean crearDocumentacion(int idSocio ,Documentacion docu){
		try {
			Documentacion nuev = new Documentacion();
			nuev.setEstadoDoc(docu.getEstadoDoc());
			nuev.setIsObligatorio(docu.getIsObligatorio());
			nuev.setUsuario(docu.getUsuario());
			nuev.setFechaRecepcion(docu.getFechaRecepcion());
			nuev.setTipoDocumento(docu.getTipoDocumento());
			documentacionService.save(idSocio, nuev);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Documentacion editarDocumentacion(Integer id, Documentacion docu){
		
		Documentacion viej = documentacionService.getById(id);
		
		viej.setEstadoDoc(docu.getEstadoDoc());
		viej.setIsObligatorio(docu.getIsObligatorio());
		viej.setTipoDocumento(docu.getTipoDocumento());
		return documentacionService.edit(viej);
	}

	public List<Documentacion> getAllDocumentacion(){
		return documentacionService.getAllDocumentacion();
	}
	
	public Documentacion getDocumentacion(Integer id){
		return documentacionService.getById(id);
	}
	
	public boolean deleteDocumentacion(Integer id){
		return documentacionService.deleteById(id);
			
	}

}
