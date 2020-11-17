package grupo12.data_access;

import grupo12.entity.*;

import java.io.BufferedReader;
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

        listsql.add("CREATE TABLE SocioAccionista (\n" +
                "ID integer PRIMARY KEY,\n" +
                "IdSocio integer NULL,\n" +
                "IdAccionista integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE Aporte (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Valor real NULL,\n" +
                "FechaAporte integer NULL,\n" +
                "IdSocio integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE CertificadoDeGarantia (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Numero integer NULL,\n" +
                "Descripcion text NULL,\n" +
                "IdOperacion integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE CuentaCorriente (\n" +
                "ID integer PRIMARY KEY,\n" +
                "EmpresaCuentaCorriente text NULL,\n" +
                "ImprteTotal integer NULL, \n" +
                "FechaVencimiento integer NULL \n" +
                ");");
        listsql.add("CREATE TABLE Cheque (\n" +
                "ID integer PRIMARY KEY,\n" +
                "NroChque integer NULL,\n" +
                "fechaDeVencimiento integer NULL, \n" +
                "cuitFirmante text NULL \n" +
                ");");
        listsql.add("CREATE TABLE Documentacion (\n" +
                "ID integer PRIMARY KEY,\n" +
                "TipoDocumento text NULL,\n" +
                "EstadoDoc text NULL,\n" +
                "IsObligatorio integer NULL \n" +
                ");");
        listsql.add("CREATE TABLE LineaDeCredito (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Monto integer NULL,\n" +
                "Vencimiento integer NULL,\n" +
                "LineaAprobada integer NULL,\n" +
                "TipoDeOperacion text NULL,\n" +
                "IdSocio integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE Prestamo (\n" +
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
                "IdCerificadoDeGarantia integer NULL,\n" +
                "IdSocio integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE FondoDeRiesgo (\n" +
                "\tMonto real NULL\n" +
                ")");
        listsql.add("CREATE TABLE Tipo1 (\n" +
                "tID integer PRIMARY KEY,\n" +
                "NroCheques integer NULL,\n" +
                "FechaVencimiento integer NULL,\n" +
                "CuitFirmante text NULL,\n" +
                "IdOperacion integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE Tipo2 (\n" +
                "ID integer PRIMARY KEY,\n" +
                "EmpresaCuentaCorriente text NULL,\n" +
                "FechaVencimiento integer NULL,\n" +
                "IdOperacion integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE Tipo3 (\n" +
                "ID integer PRIMARY KEY,\n" +
                "Banco text NULL,\n" +
                "FechaActualizacion integer NULL,\n" +
                "CantidadDeCuotas integer NULL,\n" +
                "tasa integer NULL,\n" +
                "Sistema text NULL,\n" +
                "IdOperacion integer NULL\n" +
                ");");
        listsql.add("CREATE TABLE Cuota (\n" +
                "ID integer PRIMARY KEY,\n" +
                "NumeroDeCuota integer NULL,\n" +
                "Valor real NULL,\n" +
                "Vencimiento integer NULL,\n" +
                "IdTipo3 integer NULL,\n" +
                "Paga integer NULL\n" +
                ")");
        listsql.add("CREATE TABLE AporteFondoDeRiesgo (\n" +
                "Monto real NULL,\n" +
                "IdSocio integer NULL,\n" +
                "FechaAporte integer NULL,\n" +
                "AporteVigente integer NULL\n" +
                ")");
        listsql.add("CREATE TABLE Accionista (\n" +
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

    private static boolean EliminarPorId(int id, String sql) {
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

    // METODOS DE ACCIONISTA
    public static boolean InsertAccionista(Accionista nuevo, Integer idSocio) {
        String sql = "INSERT INTO Accionista (ID,RazonSocial,PorcentajeDeParticipacion) VALUES (?,?,?)";
        String sql2 = "INSERT INTO SocioAccionista (ID, IdSocio, IdAccionista) VALUES (?,?,?)";

        int index = ObtenerUltimoIndex("Accionista") + 1;
        nuevo.setId(index);

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setString(2, nuevo.getRazonSocial());
            pstmt.setInt(3, nuevo.getPorcentajedeParticipacion());
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        index = ObtenerUltimoIndex("SocioAccionista") + 1;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, idSocio);
            pstmt.setInt(3, nuevo.getId());
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

        return EliminarPorId(id, sql);
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
        String sql = "INSERT INTO Socio (ID, Cuit, RazonSocial, FechaInicio, ActividadPrincipal, Direccion, Telefono, Email, EstadoSocio, TipoEmpresa, SaldoAcciones, TipoSocio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

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
                resultado.setTipoSocio(TipoSocio.valueOf(rs.getString("TipoSocio")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static boolean BorrarSocio(int id){
        String sql = String.format("DELETE FROM Socio WHERE id = ?");

        return EliminarPorId(id, sql);
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

    // METODOS DE DOCUMENTACION

    public static boolean InsertDocuemntacion(Documentacion documentacion){
        String sql = "INSERT INTO Documentacion(ID,TipoDocumento,EstadoDoc,IsObligatorio) VALUES(?,?,?,?)";

        int index = ObtenerUltimoIndex("Documentacion");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, index + 1);
            pstmt.setString(2, documentacion.getTipoDocumento().name());
            pstmt.setString(3, documentacion.getEstadoDoc().name());
            pstmt.setBoolean(4, documentacion.getIsObligatorio());
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static Documentacion ObtenerDocumentacion(int id){
        String sql = String.format("SELECT * FROM Documentacion WHERE ID = " + id);
        Documentacion resultado = new Documentacion();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            if(rs.next()){
                resultado.setId(rs.getInt("ID"));
                resultado.setEstadoDoc(EstadoDocumento.valueOf(rs.getString("EstadoDoc")));
                resultado.setIsObligatorio(rs.getBoolean("IsObligatorio"));
                resultado.setTipoDocumento(TipoDocumento.valueOf(rs.getString("TipoDocumento")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static boolean ActualizarDocumentacion(Documentacion documentacion){
        String sql = String.format("UPDATE Documentacion SET(TipoDocumento,EstadoDoc,IsObligatorio) VALUES(?,?,?) WHERE ID = ?");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, documentacion.getTipoDocumento().name());
            pstmt.setString(2, documentacion.getEstadoDoc().name());
            pstmt.setBoolean(3, documentacion.getIsObligatorio());
            pstmt.setInt(4, documentacion.getId());
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean BorrarDocumentacion(int id){
        String sql = String.format("DELETE FROM Documentacion WHERE id = ?");

        return EliminarPorId(id, sql);
    }

    // METODOS DE APORTE

    public static boolean InsertAporte(Aporte aporte) {
        String sql = "INSERT INTO Documentacion(ID,Valor,FechaAporte,IdSocio) VALUES(?,?,?,?)";

        int index = ObtenerUltimoIndex("Aporte");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, index + 1);
            pstmt.setFloat(2, aporte.getValor());
            pstmt.setLong(3, aporte.getFechaAporte().getTime());
            pstmt.setInt(4, aporte.getIdSocio());
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static List<Aporte> ObtenerAportes(){
        String sql = "SELECT * from Aporte" ;
        List<Aporte> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Aporte a = new Aporte();
                a.setId(rs.getInt("ID"));
                a.setFechaAporte(new Date(rs.getLong("FechaAporte")));
                a.setValor(rs.getFloat("Valor"));
                a.setIdSocio(rs.getInt("IdSocio"));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static Aporte ObtenerAporte(int id){
        String sql = "SELECT * from Aporte WHERE ID = " + id ;
        Aporte a = new Aporte();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            if(rs.next()){
                a.setId(rs.getInt("ID"));
                a.setFechaAporte(new Date(rs.getLong("FechaAporte")));
                a.setValor(rs.getFloat("Valor"));
                a.setIdSocio(rs.getInt("IdSocio"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public static boolean ActualizarAporte(Aporte aporte){
        String sql = "UPDATE Documentacion SET (Valor,FechaAporte,IdSocio) VALUES(?,?,?) WHERE ID = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(4, aporte.getId());
            pstmt.setFloat(1, aporte.getValor());
            pstmt.setLong(2, aporte.getFechaAporte().getTime());
            pstmt.setInt(3, aporte.getIdSocio());
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean BorrarAporte(int id){
        String sql = String.format("DELETE FROM Aporte WHERE id = ?");
        return EliminarPorId(id, sql);
    }

    // METODOS DE OPERACIONES

    public static List<Operacion> ObtenerOperacionesDeSocio(Integer id) {
        String sql = "SELECT * from Operacion WHERE IdSocio = " + id ;
        List<Operacion> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Operacion operacion = new Operacion();
                operacion.setId(rs.getInt("ID"));
                operacion.setEstadoOperacion(EstadoOperacion.valueOf(rs.getString("EstadoOperacion")));
                operacion.setTasaDeDescuento(rs.getFloat("TasaDeDescuento"));
                operacion.setComisionAlSocio(rs.getFloat("ComisionAlSocio"));
                operacion.setEstadoComision(EstadoComision.valueOf(rs.getString("EstadoComision")));
                operacion.setTipoDeOperacion(TipoDeOperacion.valueOf(rs.getString("TipoDeOperacion")));
                operacion.setMonto(rs.getFloat("Monto"));
                operacion.setFecha(new Date(rs.getLong("Fecha")));
                operacion.setCerificadoDeGarantia(ObtenerCertificadoDeGarantiaDeOperacion(rs.getInt("idCerificadoDeGarantia")));
                resultado.add(operacion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static CertificadoDeGarantia ObtenerCertificadoDeGarantiaDeOperacion(int idOperacion){
        String sql = String.format("SELECT * FROM CertificadoDeGarantia WHERE IdOperacion = " + idOperacion);
        CertificadoDeGarantia resultado = new CertificadoDeGarantia();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                resultado.setId(rs.getInt("ID"));
                resultado.setDescripcion(rs.getString("Descripcion"));
                resultado.setNumero(rs.getInt("Numero"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static Tipo3 ObtenerOperacionTipo3(Integer idOperacion) {
        String sql = String.format("SELECT * FROM Tipo3 WHERE IdOperacion = " + idOperacion);
        Tipo3 resultado = new Tipo3();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                resultado.setId(rs.getInt("ID"));
                resultado.setBanco(rs.getString("Banco"));
                resultado.setFechaActualizacion(new Date(rs.getLong("FechaActualizacion")));
                resultado.setCuotas(ObtenerCoutas(resultado.getId()));
                resultado.setTasa(rs.getInt("Tasa"));
                resultado.setSistema(Sistema.valueOf(rs.getString("Sistema")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static List<Cuota> ObtenerCoutas(int idOperacionTipo3){
        String sql = "SELECT * from Cuota WHERE IdTipo3 = " + idOperacionTipo3;
        List<Cuota> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Cuota a = new Cuota();
                a.setId(rs.getInt("ID"));
                a.setFechaVencimiento(new Date(rs.getLong("Vencimiento")));
                a.setNumeroDeCuota(rs.getInt("NumeroDeCuota"));
                a.setValor(rs.getFloat("Valor"));
                a.setPaga(rs.getBoolean("Paga"));
                resultado.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static List<Operacion> getOperacionesDeSociosPorTipo(List<Socio> socios, TipoDeOperacion tipoDeOperacion) {
        List<String> ids = new ArrayList<>();
        socios.forEach(socio -> ids.add(socio.getId().toString()));
        String idsString = String.join(",", ids);

        String sql = String.format("SELECT * FROM Operacion WHERE IdSocio IN (" + idsString + ") AND TipoDeOperacion = '" + tipoDeOperacion.name() + "'");
        List<Operacion> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Operacion operacion = new Operacion();
                operacion.setId(rs.getInt("ID"));
                operacion.setEstadoOperacion(EstadoOperacion.valueOf(rs.getString("EstadoOperacion")));
                operacion.setTasaDeDescuento(rs.getFloat("TasaDeDescuento"));
                operacion.setComisionAlSocio(rs.getFloat("ComisionAlSocio"));
                operacion.setEstadoComision(EstadoComision.valueOf(rs.getString("EstadoComision")));
                operacion.setTipoDeOperacion(TipoDeOperacion.valueOf(rs.getString("TipoDeOperacion")));
                operacion.setMonto(rs.getFloat("Monto"));
                operacion.setFecha(new Date(rs.getLong("Fecha")));
                operacion.setCerificadoDeGarantia(ObtenerCertificadoDeGarantiaDeOperacion(rs.getInt("idCerificadoDeGarantia")));
                resultado.add(operacion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static List<Operacion> ObtenerOperacionesDeSocioPorEstado(Integer idSocio, EstadoOperacion estadoOperacion) {

        String sql = String.format("SELECT * FROM Operacion WHERE IdSocio =" + idSocio + " AND EstadoOperacion = '" + estadoOperacion.name() + "'");
        List<Operacion> resultado = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Operacion operacion = new Operacion();
                operacion.setId(rs.getInt("ID"));
                operacion.setEstadoOperacion(EstadoOperacion.valueOf(rs.getString("EstadoOperacion")));
                operacion.setTasaDeDescuento(rs.getFloat("TasaDeDescuento"));
                operacion.setComisionAlSocio(rs.getFloat("ComisionAlSocio"));
                operacion.setEstadoComision(EstadoComision.valueOf(rs.getString("EstadoComision")));
                operacion.setTipoDeOperacion(TipoDeOperacion.valueOf(rs.getString("TipoDeOperacion")));
                operacion.setMonto(rs.getFloat("Monto"));
                operacion.setFecha(new Date(rs.getLong("Fecha")));
                operacion.setCerificadoDeGarantia(ObtenerCertificadoDeGarantiaDeOperacion(rs.getInt("idCerificadoDeGarantia")));
                resultado.add(operacion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    // METODOS DE FONDO DE RIESGO

    public static FondoDeRiesgo ObtenerFondoDeRiesgo(){
        String sql = "SELECT * from AporteFondoDeRiesgo" ;
        List<AporteFondoDeRiesgo> aportes = new ArrayList<>();
        FondoDeRiesgo fondoDeRiesgo = new FondoDeRiesgo();

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                AporteFondoDeRiesgo a = new AporteFondoDeRiesgo();
                a.setId(rs.getInt("ID"));
                a.setFechaAporte(new Date(rs.getLong("FechaAporte")));
                a.setAporteVigente(rs.getBoolean("AporteVigente"));
                a.setMonto(rs.getFloat("Monto"));
                aportes.add(a);
            }
            fondoDeRiesgo.setAportes(aportes);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fondoDeRiesgo;
    }
}


