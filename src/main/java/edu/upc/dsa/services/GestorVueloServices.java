package edu.upc.dsa.services;

import edu.upc.dsa.GestorVuelosImpl;
import edu.upc.dsa.GestorVuelos;
import edu.upc.dsa.models.*;


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
        this.gv =GestorVuelosImpl.getInstance();
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
    @ApiOperation(value = "get Drones by Horas", notes = "ayiyi")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull", response = restDron.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/DronesByHoras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVuelosByPiloto() {
        List<Dron> dronList = this.gv.dronesByHoras();
        List<restDron> restDronList = new ArrayList<>();
        if(dronList.isEmpty()){
            return Response.status(404).build();
        }
        for(Dron d : dronList){
            restDron rd = new restDron(d.getIdDron(), d.getNameDron(), d.getFabricante(), d.getModelDron(), d.getHorasVuelo(), d.getOperativo());
            restDronList.add(rd);
        }
        GenericEntity<List<restDron>> entity = new GenericEntity<List<restDron>>(restDronList) {};
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "get Pilotos By Horas", notes = "ayiyi")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull", response = restPiloto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/PilotosByHoras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPilotosByHoras() {
        List<Piloto> pilotoList = this.gv.pilotosByHoras();
        List<restPiloto> restPilotoList = new ArrayList<>();
        if(pilotoList.isEmpty()){
            return Response.status(404).build();
        }
        for(Piloto p : pilotoList){
            restPiloto rp = new restPiloto(p.getIdPiloto(), p.getFirstName(), p.getLastName(), p.getHorasVuelo());
            restPilotoList.add(rp);
        }
        GenericEntity<List<restPiloto>> entity = new GenericEntity<List<restPiloto>>(restPilotoList) {};
        return Response.status(201).entity(entity).build();

    }
    @POST
    @ApiOperation(value = "add new Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull", response = restDron.class),
    })
    @Path("/NewDron")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDron(restDron rd){
        if(rd==null) return Response.status(500).entity(rd).build();

        this.gv.addDron(rd.getIdDron(),rd.getNameDron(), rd.getFabricante(), rd.getModelDron());
        return Response.status(201).entity(rd).build();
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
        restDron rd = new restDron(dron.getIdDron(), dron.getNameDron(), dron.getFabricante(), dron.getModelDron(), dron.getHorasVuelo(), dron.getOperativo());
        if(rd==null) return Response.status(500).entity(rd).build();
        return Response.status(201).entity(rd).build();
    }







}
