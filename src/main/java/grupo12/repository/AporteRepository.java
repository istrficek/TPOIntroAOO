package grupo12.repository;

import grupo12.data_access.SqLiteDB;
import grupo12.entity.Aporte;
import java.util.List;

public class AporteRepository {

    public boolean save(Aporte nuevo){
        return SqLiteDB.InsertAporte(nuevo);
    }

    public List<Aporte> getAll(){
        return SqLiteDB.ObtenerAportes();
    }

    public boolean update(Aporte a){
        return  SqLiteDB.ActualizarAporte(a);
    }


    public boolean deleteById(int id) {
        return SqLiteDB.BorrarAporte(id);
    }
}
