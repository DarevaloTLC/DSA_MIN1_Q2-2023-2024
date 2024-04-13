package edu.upc.dsa.models;

public class restDron {
    String idDron;
    String nameDron;
    String fabricante;
    String modelDron;
    double horasVuelo;
    int operativo;
    public restDron(String idDron, String nameDron, String fabricante, String modelDron, double horasVuelo, int operativo) {
        this.idDron = idDron;
        this.nameDron = nameDron;
        this.fabricante = fabricante;
        this.modelDron = modelDron;
        this.horasVuelo = horasVuelo;
        this.operativo = operativo;
    }
    public restDron(){

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

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public int getOperativo() {
        return operativo;
    }

    public void setOperativo(int operativo) {
        this.operativo = operativo;
    }
}
