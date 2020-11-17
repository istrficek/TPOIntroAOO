package grupo12.repository;

import grupo12.data_access.SqLiteDB;
import grupo12.entity.*;

import java.util.*;

public class SocioRepository {

    public SocioRepository(){
    }

    public boolean save(Socio nuevo){
        return SqLiteDB.InsertSocio(nuevo);
    }

    public List<Socio> getAll(){
        return SqLiteDB.ObtenerSocios();
    }

    public List<Participe> getAllParticipe(){
        return SqLiteDB.ObtenerSociosParticipes();
    }

    public List<Protector> getAllProtector(){
        return SqLiteDB.ObtenerSociosProtectores();
    }

    public Participe getParticipeById(int id){
        List<Participe> listaParticipe = SqLiteDB.ObtenerSociosParticipes();
        return listaParticipe.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public Protector getProtectorById(int id){
        List<Protector> listaProtector = SqLiteDB.ObtenerSociosProtectores();
        return listaProtector.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public Socio getById(int id) {
        return SqLiteDB.ObtenerSocioPorID(id);
    }

    public void deleteById(int id) {
        SqLiteDB.BorrarSocio(id);
    }

    public List<Accionista> getAccionistas(int idSocio){
        return SqLiteDB.ObtenerAccionistas(idSocio);
    }

    public List<Socio> getSocioTipoEmpresa(TipoEmpresa te){
        return SqLiteDB.ObtenerSocioTipoEmpresa(te);
    }

    public boolean updateSocio(Socio s){
        return SqLiteDB.ActualizarSocio(s);
    }

    public List<Operacion> getOperaciones(Integer idSocio) {
        return SqLiteDB.ObtenerOperacionesDeSocio(idSocio);
    }

    public List<Operacion> getOperacionesPorEstado(Integer idSocio, EstadoOperacion estadoOperacion){
        return SqLiteDB.ObtenerOperacionesDeSocioPorEstado(idSocio, estadoOperacion);
    }

    public Tipo3 getOperacionTipo3(Integer id) {
        return SqLiteDB.ObtenerOperacionTipo3(id);
    }

    public List<Operacion> getOperacionesDeSociosPorTipo(List<Socio> socios, TipoDeOperacion tipoDeOperacion) {
        return SqLiteDB.getOperacionesDeSociosPorTipo(socios, tipoDeOperacion);
    }
}
