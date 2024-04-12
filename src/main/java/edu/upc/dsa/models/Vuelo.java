package edu.upc.dsa.models;

public class Vuelo {
    private String idDron;
    private double fecha;
    private double tiempoEstimado;
    private String posicion;
    private String destino;
    private String idPiloto;

    public Vuelo(String idDron, double fecha, double tiempoEstimado, String posicion, String destino, String idPiloto) {
        this.idDron = idDron;
        this.fecha = fecha;
        this.tiempoEstimado = tiempoEstimado;
        this.posicion = posicion;
        this.destino = destino;
        this.idPiloto = idPiloto;
    }

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public double getFecha() {
        return fecha;
    }

    public void setFecha(double fecha) {
        this.fecha = fecha;
    }

    public double getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(double tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }
}
