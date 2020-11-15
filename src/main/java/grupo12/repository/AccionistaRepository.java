package grupo12.repository;

import grupo12.data_access.SqLiteDB;
import grupo12.entity.Accionista;

import java.util.*;

public class AccionistaRepository {

    public boolean save(Accionista nuevo) {
        return SqLiteDB.InsertAccionista(nuevo);
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
