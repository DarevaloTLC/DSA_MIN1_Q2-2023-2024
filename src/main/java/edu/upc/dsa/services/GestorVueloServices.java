package edu.upc.dsa.services;

import edu.upc.dsa.GestorVuelosImpl;
import edu.upc.dsa.GestorVuelos;
import edu.upc.dsa.models.Vuelo;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.Dron;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;



@Api(value = "/vuelos", description = "Endpoint to Vuelos service")
@Path("/vuelos")


public class GestorVueloServices {
    private GestorVuelos gv;
    private Dron dron;

    public GestorVueloServices() {
        this.gv =GestorVuelosImpl.getInstance(); //CUANDO USAMOS SINGLETONE NUNCAA!!!! PUEDE SER NULL POR DEFINICION
        if((gv.getPilotoListSize() == 0) && (gv.getDronListSize() == 0)){
            gv.addPiloto("0001","Didac", "Arévalo");
            this.dron = gv.addDron("01","Dron01", "Toyota", "axs");
            gv.addPiloto("0002","Perico", "De los Palotes");
            gv.addDron("02","Dron02", "Suzuki", "xas");
            gv.añadirReservaPlanVuelo("01", 1224, 2, "200/100", "100/200","0001");
            gv.guardarDronAlmacen(this.dron);
        }
    }

    @GET
    @ApiOperation(value = "get vuelos By Piloto", notes = "ayiyi")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull", response = Vuelo.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/ByPiloto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVuelosByPiloto(@PathParam("id") String idPiloto) {
        List<Vuelo> vueloList = this.gv.vuelosByPiloto(idPiloto);
        if(vueloList.isEmpty()){
            return Response.status(404).build();
        }
        GenericEntity<List<Vuelo>> entity = new GenericEntity<List<Vuelo>>(vueloList) {};
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "get vuelos By Dron", notes = "ayiyi")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull", response = Vuelo.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/ByDron/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVuelosByDron(@PathParam("id") String idDron) {
        List<Vuelo> vueloList = this.gv.vuelosByDron(idDron);
        if(vueloList.isEmpty()){
            return Response.status(404).build();
        }
        GenericEntity<List<Vuelo>> entity = new GenericEntity<List<Vuelo>>(vueloList) {};
        return Response.status(201).entity(entity).build();

    }
    @POST
    @ApiOperation(value = "add new Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull", response = Dron.class),
    })
    @Path("/NewDron")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDron(Dron dron){
        if(dron==null) return Response.status(500).entity(dron).build();
        this.gv.addDron(dron.getIdDron(),dron.getNameDron(), dron.getFabricante(), dron.getModelDron());
        return Response.status(201).entity(dron).build();
    }
    @PUT
    @ApiOperation(value = "reparar dron almacen", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull"),
            @ApiResponse(code = 404, message = "Empty List")
    })
    @Path("/RepararDron")
    public Response repararDron(){
        Dron dron = gv.repararDronAlmacen();
        if(dron==null) return Response.status(500).entity(dron).build();
        return Response.status(201).entity(dron).build();
    }







}
