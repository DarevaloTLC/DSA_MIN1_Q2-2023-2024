package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.models.Vuelo;

public class Dron {
    private String idDron;
    private String nameDron;
    private String fabricante;
    private String modelDron;
    private double horasVuelo;
    private int operativo;

    private List<Vuelo> vueloList;

    public List<Vuelo> getVueloList() {
        return vueloList;
    }





    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    public int getOperativo() {
        return operativo;
    }

    public void setOperativo(int operativo) {
        this.operativo = operativo;
    }

    public Dron(String idDron, String nameDron, String fabricante, String modelDron) {
        this.idDron = idDron;
        this.nameDron = nameDron;
        this.fabricante = fabricante;
        this.modelDron = modelDron;
        this.horasVuelo = 0;
        this.operativo = 1;
        this.vueloList = new ArrayList<Vuelo>();
    }
    public Dron() {

    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public String getNameDron() {
        return nameDron;
    }

    public void setNameDron(String nameDron) {
        this.nameDron = nameDron;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelDron() {
        return modelDron;
    }

    public void setModelDron(String modelDron) {
        this.modelDron = modelDron;
    }
    public void addVuelo(Vuelo vuelo) {
        this.vueloList.add(vuelo);
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
