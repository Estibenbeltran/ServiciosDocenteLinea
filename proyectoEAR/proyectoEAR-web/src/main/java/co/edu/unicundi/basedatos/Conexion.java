/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author daiyd
 */
public class Conexion {
    
    public void realizaConexion(){
            Connection conn = null;
            String urlDatabase =  "jdbc:postgresql://http://127.0.0.1:56779/browser/bd_docentes"; 
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDatabase,  "postgres", "1234");
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            }
            System.out.println("La conexión se realizo sin problemas! =) ");
}
    
}
