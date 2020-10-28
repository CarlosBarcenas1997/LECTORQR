package Package.QR;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public Menu() {
        initComponents();
        initWebcam();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result_field.setBorder(null);
        jPanel1.add(result_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 470, 20));

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, 470, 10));

        jLabel1.setForeground(new java.awt.Color(105, 105, 105));
        jLabel1.setText("Resultado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, -1, -1));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 680));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 740));

        jButton1.setText("Administrador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 760, -1, -1));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        BaseDConsultas nF = new BaseDConsultas(); 
        
        nF.setVisible(true);
    

       // jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));
  // jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);
    
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField result_field;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));
  // jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                result_field.setText(result.getText());
                            
        
               enviarDato(result_field.getText());
               
           //    verificarSalida(result_field.getText());
               result_field.setText("");
            }
        } while (true);
        
        //result_field sirve para obtener    
       
        
    }
    
    private void verificarSalida(String valor){
        ConexionDB cc = new ConexionDB();
        Connection cn = cc.conexion();  
        
        String sql="";
        if(valor.equals("")){
            JOptionPane.showMessageDialog(null, "Se ha registrado tu salida");
              try{
                  //obtener hora
                  DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                  Date date = new Date();
                  
                  String hora="";
                 hora =  dateFormat.format(date);
                 

                 
                  
            PreparedStatement pst = cn.prepareStatement("INSERT INTO RRHH.Nominas_Asistencias(Hora_Salida) VALUES (?)");
            pst.setString(1, hora);

                        
            int a= pst.executeUpdate();
            if(a>0){
                JOptionPane.showMessageDialog(null,"Registro de Salida exitoso");

            }
            else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
            }
        }catch(Exception e){
            
        }
        }
        else{
          JOptionPane.showMessageDialog(null, "El codigo ingresado no existe en la base de datos");
            
        }
        
         String []datos = new String [7];
        
        try{
            Statement st=(Statement) cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
             
            }
 
        }catch(SQLException ex){
           // Logger.getLogger(datos.class.getName()).log(Level.SEVERE,null,ex);
        }
       
    }
    
    
    private void enviarDato(String valor){
        
        
        ConexionDB cc = new ConexionDB();
        Connection cn = cc.conexion();

        String sql="";
        if(valor.equals("")){
            sql="SELECT * FROM RRHH.Db_Usuarios";
            
        }
        else{
            sql="SELECT * FROM RRHH.Db_Usuarios WHERE (Usuario_id='"+valor+"' OR Usuario_Nombre1='"+valor+"' OR Usuario_Nombre2='"+valor+"'"
                    + "OR Usuario_Apellido1='"+valor+"' OR Usuario_Apellido2='"+valor+"' OR Puesto_Id='"+valor+"' OR JornadaLaboral_Id='"+valor+"')";
          

            int time = 0;
            int duration = 1000;
            
            if (time<duration){
            JOptionPane.showMessageDialog(null,"El codigo existe en la base de datos");
            }
            
                                   //obtener hora
                  DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                  Date date = new Date();
                  
                  String hora="";
                 hora =  dateFormat.format(date);
                 
                 //obtener fecha
                 Calendar fecha = new GregorianCalendar();
                 
                 int ano = fecha.get(Calendar.YEAR);
                 int mes = fecha.get(Calendar.MONTH);
                 int dia = fecha.get(Calendar.DAY_OF_MONTH);
                 String fechahoy = "";
                 fechahoy = ano + "-" + (mes+1) + "-" + dia;    
                 
                 
                 try{
                      ConexionDB cca = new ConexionDB();
        Connection cna = cca.conexion();
            PreparedStatement pst = cna.prepareStatement("INSERT INTO RRHH.nominas_asistencias(Usuario_Id,Fecha_Ingreso,Hora_ingreso) VALUES (?,?,?)");
            pst.setString(1,valor);
            pst.setString(2,fechahoy);
            pst.setString(3,hora);
       
                        
            int a= pst.executeUpdate();
            if(a>0){
                JOptionPane.showMessageDialog(null,"Registro de asistencia exitoso");
              //  mostrardatos("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
            }
        }catch(Exception e){
        
    }                          
                        
        }
        String []datos = new String [4];
        
        try{
            Statement st=(Statement) cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
      //          modelo.addRow(datos);
            }
       //     jTable1.setModel(modelo);
        }catch(SQLException ex){
           // Logger.getLogger(datos.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        
//         
//       ConexionDB cc = new ConexionDB();
//        Connection cn = cc.conexion();  
//        
//        String sql="";
//        
//        if(valor.equals("")){
//               sql="SELECT * FROM RRHH.Db_Usuarios";
//
//              try{
//                  //select from where agregar para buscar
//                  
//                  
//                   sql="SELECT * FROM RRHH.Db_Usuarios";
//                  JOptionPane.showMessageDialog(null, "Se ha registrado tu asistencia");
//                  //obtener hora
//                  DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//                  Date date = new Date();
//                  
//                  String hora="";
//                 hora =  dateFormat.format(date);
//                 
//                 //obtener fecha
//                 Calendar fecha = new GregorianCalendar();
//                 
//                 int ano = fecha.get(Calendar.YEAR);
//                 int mes = fecha.get(Calendar.MONTH);
//                 int dia = fecha.get(Calendar.DAY_OF_MONTH);
//                 String fechahoy = "";
//                 fechahoy = ano + "-" + (mes+1) + "-" + dia;
//                 
//                  
//            PreparedStatement pst = cn.prepareStatement("INSERT INTO RRHH.Nominas_Asistencias(Usuario_Id,Fecha_Ingreso,Hora_Ingreso, "
//                    + "Hora_Salida) VALUES (?,?,?)");
//            pst.setString(1, valor);
//            pst.setString(2, hora);
//            pst.setString(3, fechahoy);
//                        
//            int a= pst.executeUpdate();
//            if(a>0){
//                JOptionPane.showMessageDialog(null,"Registro de asistencia exitoso");
//
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "Error al agregar");
//            }
//        }catch(Exception e){
//            
//        }
//        }
//        else{
//              sql="SELECT * FROM RRHH.Db_Usuarios WHERE (Usuario_Id'"+valor+"')";
//          JOptionPane.showMessageDialog(null, "El codigo ingresado no existe en la base de datos");
//            
//        }
//        
//         String []datos = new String [7];
//        
//        try{
//            Statement st=(Statement) cn.createStatement();
//            ResultSet rs=st.executeQuery(sql);
//            while(rs.next()){
//                datos[0] = rs.getString(1);
//             
//            }
// 
//        }catch(SQLException ex){
//           // Logger.getLogger(datos.class.getName()).log(Level.SEVERE,null,ex);
//        }
//        
//        
    }
    

    

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
