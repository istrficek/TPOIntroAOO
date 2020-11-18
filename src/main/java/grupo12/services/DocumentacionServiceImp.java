package grupo12.services;

import grupo12.data_access.SqLiteDB;
import grupo12.entity.Documentacion;
import grupo12.repository.DocumentacionRepository;

import java.util.List;

public class DocumentacionServiceImp implements DocumentacionService {
	DocumentacionRepository documentacionRepository = new DocumentacionRepository();

	public void save(int idSocio, Documentacion nuev) {
		SqLiteDB.InsertDocuemntacion(idSocio, nuev);
	}

	public Documentacion getById(Integer id) {
		return SqLiteDB.ObtenerDocumentacion(id);
	}

	public Documentacion edit(Documentacion viej) {
		SqLiteDB.ActualizarDocumentacion(viej);
		return viej;
	}

	public boolean deleteById(Integer id) {
		return SqLiteDB.BorrarDocumentacion(id);
	}

	public List<Documentacion> getAllDocumentacion() {
		return documentacionRepository.getAll();
	}

}
