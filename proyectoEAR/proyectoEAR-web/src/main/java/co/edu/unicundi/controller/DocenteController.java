/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;



import co.edu.unicundi.basedatos.Conexion;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author daiyd
 */
@Stateless
@Path("/docentes")
public class DocenteController {
    
    @Path("/retornarString")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarString() {
        System.out.println("entro mas o menso"); 
        Conexion conexion = new Conexion();
        conexion.realizaConexion();
        String nombre = "entro";
        return Response.status(Response.Status.OK).entity(nombre).build();
    }
    
}
