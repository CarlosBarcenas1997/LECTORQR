/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package.QR;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Barcenas
 */
public class ConexionDB {
    
    Connection conexionDB = null;
    
    public Connection conexion(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
         conexionDB = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rrhh","root","");
         
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error de conexion de la base de datos");
        }catch(ClassNotFoundException ex){
        
        }
            return conexionDB;
    }
    
  
}

 

