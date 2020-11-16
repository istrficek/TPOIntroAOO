package grupo12.services;

import grupo12.data_access.SqLiteDB;
import grupo12.entity.Documentacion;

public class DocumentacionServiceImp implements DocumentacionService {

	public void save(Documentacion nuev) {
		SqLiteDB.InsertDocuemntacion(nuev);
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

}
