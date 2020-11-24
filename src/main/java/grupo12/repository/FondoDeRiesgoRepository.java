package grupo12.repository;

import grupo12.data_access.JsonDB;
import grupo12.data_access.SqLiteDB;
import grupo12.entity.AporteFondoDeRiesgo;
import grupo12.entity.CertificadoDeGarantia;
import grupo12.entity.FondoDeRiesgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FondoDeRiesgoRepository {

    public FondoDeRiesgoRepository(){
    }

    public boolean save(FondoDeRiesgo nuevo){
        return false;
    }

    public List<FondoDeRiesgo> getAll(){
        return null;
    }

    public FondoDeRiesgo getById(Integer id) {
       return null;

    }

    public FondoDeRiesgo getFondoDeRiesgo() {
        return SqLiteDB.ObtenerFondoDeRiesgo();
    }

    public boolean insertAporteFondoDeRiesgo(AporteFondoDeRiesgo aporteFondoDeRiesgo) {
        return SqLiteDB.InsertarAporteFondoDeRiesgo(aporteFondoDeRiesgo);
    }
}
