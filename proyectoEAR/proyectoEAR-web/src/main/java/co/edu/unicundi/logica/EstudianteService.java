/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.logica;

import co.edu.unicundi.controller.pojo.Estudiante;

/**
 *
 * @author ASUS-PC
 */
public class EstudianteService {
    
    public Estudiante retornarEstudiantePorCedula(int cedula) throws Exception {
        if(cedula <= 999999) {
            throw new Exception("Cédula no valida");            
        } else {
            Estudiante estudiante = new Estudiante("Johans", "González", cedula, null, null);
            return estudiante;
        }
    }
    
    public void insertarEstudiante(Estudiante estudiante)  {
       //
    }
}
