package grupo12.data_access;

import grupo12.controllers.AccionistaController;
import grupo12.controllers.DocumentacionController;
import grupo12.controllers.OperacionController;
import grupo12.controllers.SocioController;
import grupo12.entity.*;
import grupo12.repository.FondoDeRiesgoRepository;
import grupo12.request.OperacionRequest;
import grupo12.request.SocioRequest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GeneradorBD {
    private static SocioController socioController = new SocioController();
    private static AccionistaController accionistaController = new AccionistaController();
    private static DocumentacionController documentacionController = new DocumentacionController();
    private static OperacionController operacionController = new OperacionController();

    public static void GenerarBaseLimpia(){
        try {
            File f = new File("database/tpo.db");
            if(f.exists())
                f.delete();
            SqLiteDB.GenerarDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GenerarBaseConDatos(){
        GenerarBaseLimpia();
        // Socios Participes
        socioController.crearSocio(new SocioRequest(){{
            setActividadPrincipal("Actividad Principal");
            setCuit(GenerarCUIT());
            setDireccion("Calle falsa 123");
            setEmail("Socio@socio.com");
            setEstadoSocio(EstadoSocio.pleno);
            setFechaInicio(new Date());
            setParticipe(true);
            setRazonSocial("El Socio Participe 1 S.A");
            setSaldoAccionesTipo(1223);
            setTelefono("1548756525");
            setTipoEmpresa(TipoEmpresa.Mediana);

        }});
        socioController.crearSocio(new SocioRequest(){{
            setActividadPrincipal("Actividad Principal");
            setCuit(GenerarCUIT());
            setDireccion("Calle falsa 123");
            setEmail("Socio@socio.com");
            setEstadoSocio(EstadoSocio.pleno);
            setFechaInicio(new Date());
            setParticipe(true);
            setRazonSocial("El Socio Participe 2 S.A");
            setSaldoAccionesTipo(1223);
            setTelefono("1548756525");
            setTipoEmpresa(TipoEmpresa.Pequenia);

        }});
        socioController.crearSocio(new SocioRequest(){{
            setActividadPrincipal("Actividad Principal");
            setCuit(GenerarCUIT());
            setDireccion("Calle falsa 123");
            setEmail("Socio@socio.com");
            setEstadoSocio(EstadoSocio.pleno);
            setFechaInicio(new Date());
            setParticipe(true);
            setRazonSocial("El Socio Participe 3 S.A");
            setSaldoAccionesTipo(1223);
            setTelefono("1548756525");
            setTipoEmpresa(TipoEmpresa.Grande);

        }});
        // Socios Protectores
        socioController.crearSocio(new SocioRequest(){{
            setActividadPrincipal("Actividad Principal");
            setCuit(GenerarCUIT());
            setDireccion("Calle falsa 321");
            setEmail("Socio@socio.com");
            setEstadoSocio(EstadoSocio.pleno);
            setFechaInicio(new Date());
            setParticipe(false);
            setRazonSocial("El Socio Protector S.A");
            setSaldoAccionesTipo(1223);
            setTelefono("1548756525");
            setTipoEmpresa(TipoEmpresa.Mediana);

        }});
        socioController.crearSocio(new SocioRequest(){{
            setActividadPrincipal("Actividad Principal");
            setCuit(GenerarCUIT());
            setDireccion("Calle falsa 321");
            setEmail("Socio@socio.com");
            setEstadoSocio(EstadoSocio.postulante);
            setFechaInicio(new Date());
            setParticipe(false);
            setRazonSocial("El Socio Protector S.A");
            setSaldoAccionesTipo(1223);
            setTelefono("1548756525");
            setTipoEmpresa(TipoEmpresa.Grande);

        }});
        socioController.crearSocio(new SocioRequest(){{
            setActividadPrincipal("Actividad Principal");
            setCuit(GenerarCUIT());
            setDireccion("Calle falsa 321");
            setEmail("Socio@socio.com");
            setEstadoSocio(EstadoSocio.pleno);
            setFechaInicio(new Date());
            setParticipe(false);
            setRazonSocial("El Socio Protector S.A");
            setSaldoAccionesTipo(1223);
            setTelefono("1548756525");
            setTipoEmpresa(TipoEmpresa.Pequenia);

        }});
        // Aportes Fondo de riesgo
        socioController.insertarAporteFDR(new AporteFondoDeRiesgo(){{
            setMonto(12345F);
            setAporteVigente(true);
            setFechaAporte(new Date());
            setIdSocio(5);
        }});
        // Accionistas
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Socio Participe 1 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(23);
        }}, 5);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 1 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(11);
        }}, 1);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 2 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(2);
        }}, 1);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 3 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(34);
        }}, 2);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 4 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(6);
        }}, 3);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 5 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(66);
        }}, 4);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 6 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(1);
        }}, 6);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 7 S.A");
            setCuit(GenerarCUIT());
            setPorcentajedeParticipacion(42);
        }}, 6);
        // Operaciones


        //Documentacion
        documentacionController.crearDocumentacion(1, new Documentacion(){{
            setEstadoDoc(EstadoDocumento.Controlado);
            setFechaRecepcion(new Date());
            setIsObligatorio(true);
            setTipoDocumento(TipoDocumento.tipo1);
            setUsuario("Coby");
        }});
        documentacionController.crearDocumentacion(2, new Documentacion(){{
            setEstadoDoc(EstadoDocumento.Rechazado);
            setFechaRecepcion(new Date());
            setIsObligatorio(true);
            setTipoDocumento(TipoDocumento.tipo1);
            setUsuario("marcos");
        }});
        documentacionController.crearDocumentacion(3, new Documentacion(){{
            setEstadoDoc(EstadoDocumento.Ingresado);
            setFechaRecepcion(new Date());
            setIsObligatorio(true);
            setTipoDocumento(TipoDocumento.tipo2);
            setUsuario("Coby");
        }});
        documentacionController.crearDocumentacion(4, new Documentacion(){{
            setEstadoDoc(EstadoDocumento.Controlado);
            setFechaRecepcion(new Date());
            setIsObligatorio(true);
            setTipoDocumento(TipoDocumento.tipo3);
            setUsuario("Jose");
        }});

        // Operaciones
        operacionController.crearOperacion(new OperacionRequest(){{
            setEstadoOperacion(EstadoOperacion.Monetizada);
            setTasaDeDescuento((float) 3);
            setComisionAlSocio((float) 4);
            setEstadoComision(EstadoComision.Calculada);
            setTipoDeOperacion(TipoDeOperacion.Tipo1);
            setMonto((float) 3);
            setFecha(new Date());
            setCuitFirmante("adadasd");
            setIdSocio(2);
            setTipoOpe(1);
            setNroCheques((long) 2);
            
        }},2);

    }

    private static String GenerarCUIT(){
        Random rand = new Random();
        Integer CUIT = rand.nextInt(99999999 - 10000000) + 10000000;

        return "20-" + CUIT.toString() + "-0";
    }
}
