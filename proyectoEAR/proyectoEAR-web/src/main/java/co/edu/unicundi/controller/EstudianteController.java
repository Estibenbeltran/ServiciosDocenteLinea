/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.controller.pojo.Estudiante;
import co.edu.unicundi.logica.EstudianteService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ASUS-PC
 */
@Stateless
@Path("/estudiantes")
public class EstudianteController {
    
    @Path("/retornarString")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarString() {
        String nombre = "Johans González";
        return Response.status(Response.Status.OK).entity(nombre).build();
    }
    
    @Path("/retornarEstudiante")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarEstudiante() {
        Estudiante estudiante = new Estudiante("Johans", "González", 25, null, null);
        return Response.status(Response.Status.OK).entity(estudiante).build();
    }    
    
    @Path("/retornarEstudianteCedula/{cedula}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarEstudiantePorCedula(@PathParam("cedula") int cedula) {
        try {
            EstudianteService service = new EstudianteService();
            Estudiante estudiante = service.retornarEstudiantePorCedula(cedula);
            return Response.status(Response.Status.OK).entity(estudiante).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Cédula invalida").build();
        }
    }    
    
    @Path("/insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarEstudiante(@Valid Estudiante estudiante) {
        EstudianteService service = new EstudianteService();       
        service.insertarEstudiante(estudiante);
        return Response.status(Response.Status.OK).build();
    }
    
    @Path("/insertar2")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarEstudiante(List<Estudiante> estudiante) {
        System.out.println("Información estudiante");
        for (Estudiante est : estudiante) {
            System.out.println(est.getNombre() + " " + est.getApellido() + " " + est.getEdad());  
            for(String mat: est.getListaMateria()) {
                System.out.print(mat);    
            }
             System.out.println();
            for(double vec: est.getVector()) {
                System.out.print(vec);    
            }
            System.out.println("----------------------------------------------------");
        }        
        return Response.status(Response.Status.OK).build();
    }    
        
    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(Estudiante est) {
            System.out.println(est.getNombre() + " " + est.getApellido() + " " + est.getEdad());  
            if(est.getListaMateria() != null) {
                for(String mat: est.getListaMateria()) {
                    System.out.print(mat);    
                }
            }   
             System.out.println();
            for(double vec: est.getVector()) {
                System.out.print(vec);    
            }
            System.out.println("----------------------------------------------------"); 
            return Response.status(Response.Status.OK).build();
    }
    
    @Path("eliminar/{idEstudiante}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("idEstudiante") int estudiante) {
        //Lógica de base de datos
         return Response.status(Response.Status.OK).build();
    }
    
}

