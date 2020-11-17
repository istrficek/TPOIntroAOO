package grupo12.data_access;

import grupo12.controllers.AccionistaController;
import grupo12.controllers.DocumentacionController;
import grupo12.controllers.OperacionController;
import grupo12.controllers.SocioController;
import grupo12.entity.Accionista;
import grupo12.entity.EstadoSocio;
import grupo12.entity.TipoEmpresa;
import grupo12.request.SocioRequest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
        // Accionistas
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Socio Participe 1 S.A");
            setPorcentajedeParticipacion(23);
        }}, 5);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 1 S.A");
            setPorcentajedeParticipacion(11);
        }}, 1);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 2 S.A");
            setPorcentajedeParticipacion(2);
        }}, 1);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 3 S.A");
            setPorcentajedeParticipacion(34);
        }}, 2);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 4 S.A");
            setPorcentajedeParticipacion(6);
        }}, 3);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 5 S.A");
            setPorcentajedeParticipacion(66);
        }}, 4);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 6 S.A");
            setPorcentajedeParticipacion(1);
        }}, 6);
        accionistaController.crearAccionista(new Accionista(){{
            setRazonSocial("El Accionista 7 S.A");
            setPorcentajedeParticipacion(42);
        }}, 6);
    }

    private static String GenerarCUIT(){
        Random rand = new Random();
        Integer CUIT = rand.nextInt(99999999 - 10000000) + 10000000;

        return "20-" + CUIT.toString() + "-0";
    }
}
