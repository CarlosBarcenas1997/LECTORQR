/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package.QR;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 *
 * @author Barcenas
 */
public class Importar {

    public static ConexionDB cl = new ConexionDB();
    public static Connection cn = cl.conexion();
    public static PreparedStatement ps;

    public static String importarTabla(String archivo) {

        int contador = 0;
        try {
            FileInputStream input = new FileInputStream(archivo);
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            HSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                row = sheet.getRow(i);
                String id = row.getCell(0).getStringCellValue();
                String nombre = row.getCell(1).getStringCellValue();
                String apellidos = row.getCell(2).getStringCellValue();
                String sexo = row.getCell(3).getStringCellValue();

                String sql = "INSERT INTO personas("
                        + "id,"
                        + "nombre,"
                        + "apellidos,"
                        + "sexo) "
                        + "VALUES("
                        + "'" + id + "',"
                        + "'" + nombre + "',"
                        + "'" + apellidos + "',"
                        + "'" + sexo + "'"
                        + ")";

                ps = cn.prepareStatement(sql);
                ps.executeUpdate();
                System.out.println("Import rows " + i);
            }
            input.close();
            return "hecho";
        } catch (SQLException | IOException | IllegalStateException ex) {
            return "error";
        }
    }
}
