/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud1;


import java.sql.Connection;
import java.sql.DriverManager;

import java.lang.*;

import javax.swing.JOptionPane;
        
public class CPostgresql {
    
    
    Connection conectar = null;
    String user = "postgres";
    String pass = "supervampire03";

    
    
    String cadena = "jdbc:postgresql://localhost:5432/data3";
    
    public Connection establecerConexion(){
        
        try{
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, user, pass);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+ e.toString());
        }
            return conectar;
    }
}
