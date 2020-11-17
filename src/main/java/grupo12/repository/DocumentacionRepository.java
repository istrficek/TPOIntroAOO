package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.data_access.SqLiteDB;
import grupo12.entity.Accionista;
import grupo12.entity.Documentacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocumentacionRepository {
    private JsonDB db;

    public DocumentacionRepository(){
        db = new JsonDB("database\\DocumentacionTable.db", Documentacion[].class);
    }

    public boolean save(Documentacion nuevo){
        List<Documentacion> list = getAll();
        list.add(nuevo);
        return db.insert(list);
    }

    public List<Documentacion> getAll(){
        return SqLiteDB.ObtenerDocumentacion();
    }
}
