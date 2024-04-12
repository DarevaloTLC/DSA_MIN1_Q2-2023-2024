package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.Vuelo;

import java.util.List;

public interface GestorVuelos {
    public List<Dron> dronesByHoras();
    public List<Piloto> pilotosByHoras();
    public void guardarDronAlmacen(Dron dron);
    public Dron repararDronAlmacen();
    public int añadirReservaPlanVuelo(String idDron, double fecha, double tiempoEstimado, String posicion, String destino, String idPiloto);
    public List<Vuelo> vuelosByPiloto(String idPiloto);
    public List<Vuelo> vuelosByDron(String idDron);

    public Dron addDron(String idDron, String nameDron, String fabricante, String model);
    public Piloto addPiloto(String idPiloto, String namePiloto, String lastnamePiloto);
}
