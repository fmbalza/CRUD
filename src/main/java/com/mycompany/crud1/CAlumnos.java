/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud1;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author blood
 */
public class CAlumnos {
    
    int codigo;
    String nombreAlumno;
    String apellidosAlumno;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidosAlumno() {
        return apellidosAlumno;
    }

    public void setApellidosAlumno(String apellidosAlumno) {
        this.apellidosAlumno = apellidosAlumno;
    }
    
  
public void MostrarAlumnos (JTable paramTablaTotalAlumnos){
    
    CPostgresql objetoConexion = new CPostgresql();
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    String sql="";
    
    modelo.addColumn("cedula");
    modelo.addColumn("nombre");
    modelo.addColumn("apellido");
    
    paramTablaTotalAlumnos.setModel(modelo);
    
    
    sql ="select * from Alumnos;";
    
    
    String [] datos = new String[3];
    
    Statement st;
    
    
        try {
            
            st= objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                
                modelo.addRow(datos);
                
                
            }
            
            paramTablaTotalAlumnos.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
            
        }
        
        
    
    }
    
    public void insertarAlumno(JTextField  paramNombres, JTextField paramApellidos){
    
        setNombreAlumno(paramNombres.getText());
        setApellidosAlumno(paramApellidos.getText());
        
        CPostgresql objetoConexion = new CPostgresql();
        
        
        String consulta = "insert into alumnos (nombre,apellido) values (?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumno());
            cs.setString(2, getApellidosAlumno());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se insertó correctamente");
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
        
    }
    
    public void SeleccionarAlumno(JTable paramTablaAlumno, JTextField paramCodigo, JTextField paramNombres, JTextField paramApellidos){
    
        try {
            
            int fila =paramTablaAlumno.getSelectedRow();
            
            if (fila>=0) {
                
                paramCodigo.setText(paramTablaAlumno.getValueAt(fila, 0).toString());
                paramNombres.setText(paramTablaAlumno.getValueAt(fila, 1).toString());
                paramApellidos.setText(paramTablaAlumno.getValueAt(fila, 2).toString());
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error: "+ e.toString());
        }
    
    }
    
       public void ModificarAlumno(JTextField  paramCodigo,JTextField  paramNombres, JTextField paramApellidos){
    
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombreAlumno(paramNombres.getText());
        setApellidosAlumno(paramApellidos.getText());
        
        CPostgresql objetoConexion = new CPostgresql();
        
        
        String consulta = "UPDATE alumnos SET nombre= ?, apellido =? WHERE Alumnos.cedula=?;";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumno());
            cs.setString(2, getApellidosAlumno());
            cs.setInt(3, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se modificó correctamente");
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
        
    }
       
        public void EliminarAlumno(JTextField  paramCodigo){
    
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        
        CPostgresql objetoConexion = new CPostgresql();
        
        
        String consulta = "DELETE FROM alumnos WHERE alumnos.cedula=?";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se Eliminó correctamente");
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
        
    }
    
  
}


