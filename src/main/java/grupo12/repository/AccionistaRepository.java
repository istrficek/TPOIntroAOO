package grupo12.repository;

import grupo12.data_access.SqLiteDB;
import grupo12.entity.Accionista;

import java.util.*;

public class AccionistaRepository {

    public boolean save(Accionista nuevo, Integer idSocio) {
        return SqLiteDB.InsertAccionista(nuevo, idSocio);
    }

    public List<Accionista> getAll(){
        return SqLiteDB.ObtenerAccionistas();
    }

    public Accionista getById(int id) {
        return SqLiteDB.ObtenerAccionistaPorID(id);
    }

    public void deleteById(int id) {
        SqLiteDB.BorrarAccionista(id);
    }

    public Accionista edit(Accionista a) {
        SqLiteDB.ActualizarAccionista(a);
        return  a;
    }
}
