package Package.QR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Data provider for excel
 *
 * @author Barcenas
 */
public final class FakeDataProvider {

    public static ConexionDB cl = new ConexionDB();
    public static Connection cn = cl.conexion();
    public static PreparedStatement ps;

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        //TITULOS DE LAS COLUMNAS
        tableHeader.add("Id_Asistencia");
        tableHeader.add("Id_Usuario");
        tableHeader.add("Fecha_Ingreso");
        tableHeader.add("Hora_Salida");
        tableHeader.add("Hora_Salida");
  

        return tableHeader;
    }

    /**
     * Return values for the table
     *
     * @param numberOfRows Number of rows we want to receive
     *
     * @return Values
     */
    public static List<List<String>> getTableContent(int numberOfRows) {
        try {
            if (numberOfRows <= 0) {
                throw new IllegalArgumentException("The number of rows must be a positive integer");
            }

            List<List<String>> tableContent = new ArrayList<List<String>>();

            String SQL = "SELECT * FROM RRHH.Nominas_Asistencias";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            int i = 0;
            List<String> row = null;
            while (rs.next()) {
                tableContent.add(row = new ArrayList<String>());

                row.add(rs.getString("Asistencia_Id"));
                row.add(rs.getString("Usuario_Id"));
                row.add(rs.getString("Fecha_Ingreso"));
                row.add(rs.getString("Hora_Ingreso"));
                row.add(rs.getString("Hora_Salida"));

                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            Logger.getLogger(FakeDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
