package grupo12.data_access;

import grupo12.entity.*;
import javafx.scene.control.Tab;
import sun.reflect.generics.scope.Scope;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqLiteDB {

    // METODOS DE LA BD
    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:database/tpo.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void GenerarDB() throws IOException {
        // SQL statement for creating a new table
        BufferedReader lector = new BufferedReader(new FileReader("database/CrearBD.sql"));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = lector.readLine()) != null) {
            sb.append(line);
        }

        lector.close();
        List<String> listsql = new ArrayList<>();

        listsql.add("CREATE TABLE IF NOT EXISTS SocioAccionista (\n" +
                "ID integer PRIMARY KEY,\n" +
                "IdSocio integer NULL,\n" +
                "IdAccionista integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS Aporte (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Valor real NULL,\n" +
                "FechaAporte integer NULL \n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS CertificadoDeGarantia (\n" +
                "ID integer PRIMARY KEY,\n" +
                "numero integer NULL,\n" +
                "Descripcion text NULL \n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS CuentaCorriente (\n" +
                "ID integer PRIMARY KEY,\n" +
                "EmpresaCuentaCorriente text NULL,\n" +
                "ImprteTotal integer NULL, \n" +
                "FechaVencimiento integer NULL \n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS Documentacion (\n" +
                "ID integer PRIMARY KEY,\n" +
                "TipoDocumento text NULL,\n" +
                "EstadoDoc text NULL,\n" +
                "IsObligatorio integer NULL \n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS LineaDeCredito (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Monto integer NULL,\n" +
                "Vencimiento integer NULL,\n" +
                "LineaAprobada integer NULL,\n" +
                "TipoDeOperacion text NULL\t\n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS Prestamo (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Banco text NULL,\n" +
                "Importe real NULL,\n" +
                "FechaDeAcreditacion integer NULL,\n" +
                "CantidadCuotas integer NULL,\n" +
                "Tasa integer NULL,\n" +
                "Sistema text NULL\n" +
                ");");
        listsql.add("CREATE TABLE Socio (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Cuit text NULL,\n" +
                "RazonSocial text NULL,\n" +
                "FechaInicio integer NULL,\n" +
                "ActividadPrincipal text NULL,\n" +
                "Direccion text NULL,\n" +
                "Telefono text NULL,\n" +
                "Email text NULL,\n" +
                "EstadoSocio text NULL,\n" +
                "TipoEmpresa text NULL,\n" +
                "SaldoAcciones integer NULL,\n" +
                "TipoSocio text NULL\n" +
                ");");
        listsql.add("CREATE TABLE Operacion (\n" +
                "ID integer PRIMARY KEY,\n" +
                "EstadoOperacion text NULL,\n" +
                "TasaDeDescuento real NULL,\n" +
                "ComisionAlSocio real NULL,\n" +
                "EstadoComision text NULL,\n" +
                "TipoDeOperacion text NULL,\n" +
                "Monto real NULL,\n" +
                "Fecha integer NULL,\n" +
                "idCerificadoDeGarantia integer NULL,\n" +
                "idLineaDeCredito integer NULL,\n" +
                "idSocio integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE FondoDeRiesgo (\n" +
                "\tMonto real NULL\n" +
                ")");
        listsql.add("CREATE TABLE IF NOT EXISTS Tipo1 (\n" +
                "ID integer PRIMARY KEY,\n" +
                "NroCheques integer NULL,\n" +
                "FechaVencimiento integer NULL,\n" +
                "CuitFirmante text NULL\n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS Tipo2 (\n" +
                "ID integer PRIMARY KEY,\n" +
                "EmpresaCuentaCorriente text NULL,\n" +
                "FechaVencimiento integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS Tipo3 (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Banco text NULL,\n" +
                "FechaActualizacion integer NULL,\n" +
                "CantidadDeCuotas integer NULL,\n" +
                "tasa integer NULL,\n" +
                "Sistema text NULL\n" +
                ");");
        listsql.add("CREATE TABLE IF NOT EXISTS Accionista (\n" +
                "ID integer PRIMARY KEY,\n" +
                "RazonSocial text NULL,\n" +
                "PorcentajeDeParticipacion integer NULL\n" +
                ");");

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // create a new table
            for (String sql: listsql) {
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int ObtenerUltimoIndex(String tabla){
        String sql = "SELECT MAX(ID) as ID from " + tabla;
        int index = 0;

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                index = rs.getInt("ID");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return index;
    }

    // METODOS DE ACCIONISTA
    public static boolean InsertAccionista(Accionista nuevo) {
        String sql = "INSERT INTO Accionista (ID,RazonSocial,PorcentajeDeParticipacion) VALUES (?,?,?)";

        int index = ObtenerUltimoIndex("Accionista");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, index + 1);
            pstmt.setString(2, nuevo.getRazonSocial());
            pstmt.setInt(3, nuevo.getPorcentajedeParticipacion());
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static List<Accionista> ObtenerAccionistas(){
        String sql = "SELECT * from Accionista" ;
        List<Accionista> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Accionista a = new Accionista();
                a.setId(rs.getInt("ID"));
                a.setPorcentajedeParticipacion(rs.getInt("PorcentajeDeParticipacion"));
                a.setRazonSocial(rs.getString("RazonSocial"));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static Accionista ObtenerAccionistaPorID(int id){
        String sql = String.format("SELECT * FROM Accionista WHERE ID = " + id);
        Accionista resultado = new Accionista();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                resultado.setId(rs.getInt("ID"));
                resultado.setPorcentajedeParticipacion(rs.getInt("PorcentajeDeParticipacion"));
                resultado.setRazonSocial(rs.getString("RazonSocial"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static boolean BorrarAccionista(int id){
        String sql = String.format("DELETE FROM Accionista WHERE id = ?");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean ActualizarAccionista(Accionista a){
        String sql = String.format("UPDATE Accionista SET RazonSocial = ?, PorcentajeDeParticipacion = ? WHERE ID = ?");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a.getRazonSocial());
            pstmt.setInt(2, a.getPorcentajedeParticipacion());
            pstmt.setInt(3, a.getId());
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // METODOS DE SOCIO

    public static boolean InsertSocio(Socio nuevo) {
        String sql = "INSERT INTO Accionista (ID, Cuit, RazonSocial, FechaInicio, ActividadPrincipal, Direccion, Telefono, Email, EstadoSocio, TipoEmpresa, SaldoAcciones, TipoSocio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        int index = ObtenerUltimoIndex("Socio");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, index + 1);                      //ID
            pstmt.setString(2, nuevo.getCuit());                //CUIT
            pstmt.setString(3, nuevo.getRazonSocial());                //RazonSocial
            pstmt.setLong(4, nuevo.getFechaInicio().getTime());     //FechaInicio
            pstmt.setString(5, nuevo.getActividadPrincipal());      //ActividadPrincipal
            pstmt.setString(6, nuevo.getDireccion());               //Direccion
            pstmt.setString(7, nuevo.getTelefono());                //Telefono
            pstmt.setString(8, nuevo.getEmail());                   //Email
            pstmt.setString(9, nuevo.getEstadoSocio().name());             //EstadoSocio
            pstmt.setString(10, nuevo.getTipoEmpresa().name());             //TipoEmpresa
            pstmt.setInt(11, nuevo.getSaldoAcciones());             //SaldoAcciones
            pstmt.setString(12, nuevo.getTipoSocio().name());             //SalddAcciones

            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static List<Socio> ObtenerSocios(){
        String sql = "SELECT * from Socio" ;
        List<Socio> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Socio a = new Socio();
                a.setId(rs.getInt("ID"));
                a.setCuit(rs.getString("Cuit"));
                a.setRazonSocial(rs.getString("RazonSocial"));
                a.setFechaInicio(new Date(rs.getLong("FechaInicio")));
                a.setActividadPrincipal(rs.getString("ActividadPrincipal"));
                a.setDireccion(rs.getString("Direccion"));
                a.setTelefono(rs.getString("Telefono"));
                a.setEmail(rs.getString("Email"));
                a.setEstadoSocio(EstadoSocio.valueOf(rs.getString("EstadoSocio")));
                a.setTipoEmpresa(TipoEmpresa.valueOf(rs.getString("TipoEmpresa")));
                a.setSaldoAcciones(rs.getInt("SaldoAcciones"));
                a.setTipoSocio(TipoSocio.valueOf(rs.getString("TipoSocio")));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static List<Participe> ObtenerSociosParticipes(){
        String sql = "SELECT * from Socio WHERE TipoSocio = 'Participe'" ;
        List<Participe> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Participe a = new Participe();
                a.setId(rs.getInt("ID"));
                a.setCuit(rs.getString("Cuit"));
                a.setRazonSocial(rs.getString("RazonSocial"));
                a.setFechaInicio(new Date(rs.getLong("FechaInicio")));
                a.setActividadPrincipal(rs.getString("ActividadPrincipal"));
                a.setDireccion(rs.getString("Direccion"));
                a.setTelefono(rs.getString("Telefono"));
                a.setEmail(rs.getString("Email"));
                a.setEstadoSocio(EstadoSocio.valueOf(rs.getString("EstadoSocio")));
                a.setTipoEmpresa(TipoEmpresa.valueOf(rs.getString("TipoEmpresa")));
                a.setSaldoAcciones(rs.getInt("SaldoAcciones"));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static List<Protector> ObtenerSociosProtectores(){
        String sql = "SELECT * from Socio WHERE TipoSocio = 'Protector'" ;
        List<Protector> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Protector a = new Protector();
                a.setId(rs.getInt("ID"));
                a.setCuit(rs.getString("Cuit"));
                a.setRazonSocial(rs.getString("RazonSocial"));
                a.setFechaInicio(new Date(rs.getLong("FechaInicio")));
                a.setActividadPrincipal(rs.getString("ActividadPrincipal"));
                a.setDireccion(rs.getString("Direccion"));
                a.setTelefono(rs.getString("Telefono"));
                a.setEmail(rs.getString("Email"));
                a.setEstadoSocio(EstadoSocio.valueOf(rs.getString("EstadoSocio")));
                a.setTipoEmpresa(TipoEmpresa.valueOf(rs.getString("TipoEmpresa")));
                a.setSaldoAcciones(rs.getInt("SaldoAcciones"));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static Socio ObtenerSocioPorID(int id){
        String sql = String.format("SELECT * FROM Socio WHERE ID = " + id);
        Socio resultado = new Socio();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            if(rs.next()){
                resultado.setId(rs.getInt("ID"));
                resultado.setCuit(rs.getString("Cuit"));
                resultado.setRazonSocial(rs.getString("RazonSocial"));
                resultado.setFechaInicio(new Date(rs.getLong("FechaInicio")));
                resultado.setActividadPrincipal(rs.getString("ActividadPrincipal"));
                resultado.setDireccion(rs.getString("Direccion"));
                resultado.setTelefono(rs.getString("Telefono"));
                resultado.setEmail(rs.getString("Email"));
                resultado.setEstadoSocio(EstadoSocio.valueOf(rs.getString("EstadoSocio")));
                resultado.setTipoEmpresa(TipoEmpresa.valueOf(rs.getString("TipoEmpresa")));
                resultado.setSaldoAcciones(rs.getInt("SaldoAcciones"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static boolean BorrarSocio(int id){
        String sql = String.format("DELETE FROM Socio WHERE id = ?");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean ActualizarSocio(Socio s){
        String sql = "UPDATE Socio SET (Cuit, RazonSocial, FechaInicio, ActividadPrincipal, Direccion, Telefono, Email, EstadoSocio, TipoEmpresa, SaldoAcciones, TipoSocio) VALUES (?,?,?,?,?,?,?,?,?,?,?) WHERE ID = ? ";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getCuit());                //CUIT
            pstmt.setString(2, s.getRazonSocial());                //RazonSocial
            pstmt.setLong(3, s.getFechaInicio().getTime());     //FechaInicio
            pstmt.setString(4, s.getActividadPrincipal());      //ActividadPrincipal
            pstmt.setString(5, s.getDireccion());               //Direccion
            pstmt.setString(6, s.getTelefono());                //Telefono
            pstmt.setString(7, s.getEmail());                   //Email
            pstmt.setString(8, s.getEstadoSocio().name());             //EstadoSocio
            pstmt.setString(9, s.getTipoEmpresa().name());             //TipoEmpresa
            pstmt.setInt(10, s.getSaldoAcciones());             //SaldoAcciones
            pstmt.setString(11, s.getTipoSocio().name());             //SalddAcciones
            pstmt.setInt(12, s.getId());                      //ID
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static List<Accionista> ObtenerAccionistas(int idSocio){
        String sql = "SELECT * from Accionista WHERE ID IN(SELECT IdAccionista FROM SocioAccionista WHERE IdSocio = " + idSocio + ")";
        List<Accionista> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Accionista a = new Accionista();
                a.setId(rs.getInt("ID"));
                a.setPorcentajedeParticipacion(rs.getInt("PorcentajeDeParticipacion"));
                a.setRazonSocial(rs.getString("RazonSocial"));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static List<Socio> ObtenerSocioTipoEmpresa(TipoEmpresa tipoEmpresa){
        String sql = "SELECT * from Socio WHERE TipoEmpresa = '" + tipoEmpresa.name() +  "'" ;
        List<Socio> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Socio a = new Socio();
                a.setId(rs.getInt("ID"));
                a.setCuit(rs.getString("Cuit"));
                a.setRazonSocial(rs.getString("RazonSocial"));
                a.setFechaInicio(new Date(rs.getLong("FechaInicio")));
                a.setActividadPrincipal(rs.getString("ActividadPrincipal"));
                a.setDireccion(rs.getString("Direccion"));
                a.setTelefono(rs.getString("Telefono"));
                a.setEmail(rs.getString("Email"));
                a.setEstadoSocio(EstadoSocio.valueOf(rs.getString("EstadoSocio")));
                a.setTipoEmpresa(TipoEmpresa.valueOf(rs.getString("TipoEmpresa")));
                a.setSaldoAcciones(rs.getInt("SaldoAcciones"));
                a.setTipoSocio(TipoSocio.valueOf(rs.getString("TipoSocio")));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
}


