package edu.upc.dsa.models;

import java.util.ArrayList;

public class restPiloto {
    private String idPiloto;
    private String firstName;
    private String lastName;
    private double horasVuelo;
    public restPiloto(String idPiloto, String firstName, String lastName, double horasVuelo) {
        this.idPiloto = idPiloto;
        this.firstName = firstName;
        this.lastName = lastName;
        this.horasVuelo = horasVuelo;

    }
    public restPiloto(){

    }

    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
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

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }
}
