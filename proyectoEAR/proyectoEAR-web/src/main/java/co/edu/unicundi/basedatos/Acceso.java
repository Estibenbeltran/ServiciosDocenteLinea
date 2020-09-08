/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.basedatos;

import co.edu.unicundi.controller.pojo.DocentePojo;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daiyd
 */
public class Acceso {
    
    /**
     * Registrar docente en BD
     *
     * @param docente
     */
    public void registrar(DocentePojo docente) {
        Conexion conexion = new Conexion();
        conexion.realizarConexion();
        if (conexion != null) {
            try {
                String materias = new Gson().toJson(docente.getMaterias());
                String query = "INSERT INTO docente(cedula, materias, nombre, apellido) VALUES ('"
                        + docente.getNombre() + "','"
                        + docente.getApellido() + "','"
                        + materias + "','"
                        + docente.getCedula()+ "',');";
                PreparedStatement stmt = conexion.prepareStatement(query);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
