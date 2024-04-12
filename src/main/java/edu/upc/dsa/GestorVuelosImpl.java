package edu.upc.dsa;

import edu.upc.dsa.models.Vuelo;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.queue.EmptyQueueException;
import edu.upc.dsa.queue.FullQueueException;
import edu.upc.dsa.queue.QueueImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.log4j.Logger;

public class GestorVuelosImpl implements GestorVuelos {
    private static GestorVuelosImpl instance;
    protected List<Dron> dronList;
    protected List<Piloto> pilotoList;
    protected QueueImpl<Dron> almacen;
    final static Logger logger = Logger.getLogger(GestorVuelosImpl.class);

    private GestorVuelosImpl() {
        this.dronList = new ArrayList<>();
        this.pilotoList = new ArrayList<>();
        this.almacen = new QueueImpl<>(20);//Capacidad Maxima del almacen
    }
    public static GestorVuelosImpl getInstance() {
        if (instance == null) {
            instance = new GestorVuelosImpl();
        }
        return instance;
    }
    @Override
    public Dron addDron(String idDron, String nameDron, String fabricante, String model){
        logger.info("Adding dron " + idDron);
        Dron d = new Dron(idDron, nameDron, fabricante, model);
        dronList.add(d);
        return d;
    }

    @Override
    public Piloto addPiloto(String idPiloto, String namePiloto, String lastnamePiloto){
        logger.info("Adding piloto " + idPiloto);
        Piloto p = new Piloto(idPiloto, namePiloto, lastnamePiloto);
        pilotoList.add(p);
        return p;
    }
    @Override
    public List<Dron> dronesByHoras(){
        Comparator<Dron> horasComparator = Comparator.comparingDouble(Dron::getHorasVuelo);
        dronList.sort(horasComparator);
        logger.info("Ordered List by Hours" + dronList);
        return dronList;
    }
    @Override
    public List<Piloto> pilotosByHoras(){
        Comparator<Piloto> horasComparator = Comparator.comparingDouble(Piloto::getHorasVuelo);
        pilotoList.sort(horasComparator);
        logger.info("Ordered List by Horas" + pilotoList);
        return pilotoList;
    }
    @Override
    public void guardarDronAlmacen(Dron dron){
        logger.info("Guardando Dron Almacen");
        try{
            if(dron.getIdDron() != null){
                for(Dron d : dronList){
                    if(d.getIdDron().equals(dron.getIdDron())){
                        d.setOperativo(0);
                    }
                }
                almacen.push(dron);
                logger.info("Dron guardado en el Almacen");
            }
            else{
                logger.warn("Dron no puede ser nulo");
                throw new IllegalArgumentException("Dron no puede ser nulo");
            }

        }
        catch(FullQueueException fullQueueException){
            logger.warn("Full Queue, can't add order");
            fullQueueException.printStackTrace();
        }
    }
    @Override
    public Dron repararDronAlmacen(){
        logger.info("Reparando Dron Almacen");
        Dron dronReparado = new Dron();
        try{
            dronReparado = almacen.pop();
            for(Dron d : dronList){
                if(d.getIdDron().equals(dronReparado.getIdDron())){
                    d.setOperativo(1);
                }
            }
        }
        catch(FullQueueException fullQueueException){
            logger.warn("Full Queue, can't add order");
            fullQueueException.printStackTrace();
        }
        return dronReparado;
    }
    @Override
    public List<Vuelo> vuelosByPiloto(String idPiloto){
        logger.info("Vuelos de Piloto");
        Piloto piloto = new Piloto();
        for(Piloto p : pilotoList){
            if(p.getIdPiloto().equals(idPiloto)){
                piloto = p;
            }
        }
        if(piloto != null){
            logger.info("Vuelos de piloto: " + piloto.getVueloList());
            return piloto.getVueloList();
        }
        else{
            logger.warn("Piloto no encontrado");
            return null;
        }
    }
    @Override
    public List<Vuelo> vuelosByDron(String idDron){
        logger.info("Vuelos de Dron");
        Dron dron = new Dron();
        for(Dron d : dronList){
            if(d.getIdDron().equals(idDron)){
                dron = d;
            }
        }
        if(dron != null){
            logger.info("Vuelos de dron: " + dron.getVueloList());
            return dron.getVueloList();
        }
        else{
            logger.warn("Dron no encontrado");
            return null;
        }
    }

    @Override
    public int añadirReservaPlanVuelo(String idDron, double fecha, double tiempoEstimado, String posicion, String destino, String idPiloto){
        logger.info("Adding reserva plan");
        Vuelo vuelo = new Vuelo(idDron, fecha, tiempoEstimado, posicion, destino, idPiloto);
        Dron dron = new Dron();
        Piloto piloto = new Piloto();
        if(idDron != null && idPiloto != null){
            logger.info("Adding reserva plan for dron " + dron);
            logger.info("Adding reserva plan for piloto " + piloto);
            for(Dron d: dronList){
                if(d.getIdDron().equals(idDron)){
                    dron = d;
                }
            }
            for(Piloto p: pilotoList){
                if(p.getIdPiloto().equals(idPiloto)){
                    piloto = p;
                }
            }
            int planAsignadoDron = dron.planAsignado(fecha, tiempoEstimado);
            int planAsignadoPiloto = piloto.planAsignado(fecha, tiempoEstimado);
            int dronOperativo = dron.getOperativo();

            if(planAsignadoDron == 0 && planAsignadoPiloto == 0 && dronOperativo == 1){
                for(Dron d : dronList){
                    if(d.getIdDron().equals(idDron)){
                        d.addVuelo(vuelo);
                        logger.info("Reserva plan dron ADDED " + dron);
                    }
                }
                for(Piloto p : pilotoList){
                    if(p.getIdPiloto().equals(idPiloto)){
                        p.addVuelo(vuelo);
                        logger.info("Reserva plan piloto ADDED " + piloto);
                    }
                }
            }
            return 1;
        }
        else{
            logger.warn("Piloto o Dron no encontrado, error en la busqueda");
            return -1;

        }
    }
    public int getDronListSize(){
        return dronList.size();

    }
    public int getPilotoListSize(){
        return pilotoList.size();
    }
    public int getAlmacenSize(){
        return almacen.size();
    }






}
