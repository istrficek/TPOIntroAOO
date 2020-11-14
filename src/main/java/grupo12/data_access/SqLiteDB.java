package grupo12.data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqLiteDB {

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
        listsql.add("CREATE TABLE IF NOT EXISTS HistorialSocio (\n" +
                "ID integer PRIMARY KEY,\n" +
                "IdSocio integer NULL,\n" +
                "IdOperacion integer NULL\n" +
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
        listsql.add("CREATE TABLE IF NOT EXISTS Socio (\n" +
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
                "SaldoAcciones integer NULL\n" +
                ");");
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

        listsql.clear();

        //listsql.add()

        /*
        sql = "INSERT INTO Accionistas(ID,RazonSocial,PorcentajeDeParticipacion ) VALUES(?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 2);
            pstmt.setString(2, "El Razon Social");
            pstmt.setInt(3, 45);
            pstmt.executeUpdate();
            System.out.println("Query ejecutada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         */
    }
}
