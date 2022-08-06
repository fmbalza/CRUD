/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
        
public class CPostgresql {
    
    
    Connection conectar = null;
    String usuario = "postgres";
    String contraseña = "supervampire03";
    String db = "data3";
    String ip = "localhost";
    String puerto = "5432";
    
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+db;
    
    
    public Connection establecerConexion(){
        
        try{
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+ e.toString());
        }
            return conectar;
    }
}
