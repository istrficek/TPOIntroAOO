package grupo12.services;

import java.util.Date;
import java.util.List;

import grupo12.dto.PosicionConsolidada;
import grupo12.dto.PromedioTasaYTotal;
import grupo12.entity.*;


public interface SocioService {

	Float getSaldoDeudor(Integer id);

	List<Accionista> getAccionistas(Integer id);

	List<Participe> getSociosParticipes();

	List<Socio> getSociosTipoEmpresa(TipoEmpresa tipoEmpresa);

	Socio getSocio(Integer id);

	void save(Socio socio);

	void save(Protector socio);

	boolean update(Socio s);

	Socio getParticipeById(Integer id);

	Protector getProtectorById(Integer id);

    List<Protector> getSociosProtectores();

    boolean saveAporte(int idSocio, Aporte a);

    boolean validarOperacion(Operacion operacion);

	boolean verificarSocio(Socio s);

    PromedioTasaYTotal obtenerValorPromedioTasaDescuentoYTotalOperado(TipoEmpresa tipoEmpresa, Date fechaInicio, Date fechaFin);

    Float obtenerComisionPorTipoDeOperacion(TipoDeOperacion tipoDeOperacion, Socio socio);

	PosicionConsolidada obtenerPosicionConsolidada(Integer idSocio);
}