package edu.upc.dsa.models;

import edu.upc.dsa.models.Vuelo;

import java.util.ArrayList;
import java.util.List;

public class Piloto {
    private String idPiloto;
    private String firstName;
    private String lastName;
    private double horasVuelo;
    private List<Vuelo> vueloList;



    public Piloto(String idPiloto, String firstName, String lastName) {
        this.idPiloto = idPiloto;
        this.firstName = firstName;
        this.lastName = lastName;
        this.horasVuelo = 0;
        this.vueloList = new ArrayList<>();
    }
    public Piloto() {

    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }

    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addVuelo(Vuelo vuelo) {
        vueloList.add(vuelo);
    }
    public int planAsignado(double fecha, double horas){
        int encontrado = 0;
        for(Vuelo vuelo : vueloList){
            if((vuelo.getFecha() == fecha) && (vuelo.getTiempoEstimado() == horas)){
                encontrado = 1;
            }
        }
        return encontrado;
    }

}
