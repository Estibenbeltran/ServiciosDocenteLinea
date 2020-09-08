/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller.pojo;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author daiyd
 */
public class DocentePojo {

    int id;

    /**
     * cedula del docente
     */
    @NotNull(message = "Campo cedula requerido")
    @Pattern(regexp = "^([0-9])*$")
    @Size(min = 5, max = 10, message = "formato de cedula incorrecto")
    String cedula;
    /**
     * Nombre del docente
     */
    @NotNull(message = "Campo nombre requerido")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    @Size(min = 2, max = 30, message = "Formato de nombre incorrecto")
    String nombre;

    /**
     * Apellido del docente
     */
    @NotNull(message = "Campo apellido requerido")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    @Size(min = 2, max = 30, message = "Formato de apellido incorrecto")
    String apellido;

    /**
     * Lista de materias del docente
     */
    List<String> materias;
    
    public DocentePojo(){
        
    }

    public DocentePojo(int id, String cedula, String nombre, String apellido,  List<String> materias) {
        
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = materias;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

}
