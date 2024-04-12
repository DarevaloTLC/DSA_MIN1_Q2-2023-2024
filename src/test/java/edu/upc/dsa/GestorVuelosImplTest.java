package edu.upc.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.upc.dsa.models.Vuelo;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GestorVuelosImplTest {
    private GestorVuelos gv;

    @Before
    public void setUp() throws Exception {
        gv = GestorVuelosImpl.getInstance();

    }
    @After
    public void tearDown() throws Exception {
        gv = null;

    }
    @Test
    public void addDronTest() throws Exception {
        gv.addDron("0003", "Dron1234", "Suzuki", "aak");

        assertEquals(3,gv.getDronListSize());
    }
    @Test
    public void addPilotoTest() throws Exception {
        gv.addPiloto("02","Perico", "De los Palotes");

        assertEquals(1,gv.getPilotoListSize());

    }
    @Test
    public void guardarDronAlmacenTest() throws Exception {
        Dron dron = gv.addDron("0004", "Dron65", "Fabricante1", "Modelo1");

        // Guardar el dron en el almacén
        gv.guardarDronAlmacen(dron);


        // Verificar que el dron se haya guardado correctamente en el almacén
        assertEquals(dron, gv.repararDronAlmacen());


    }
    @Test
    public void repararDronAlmacenTest() throws Exception {
        Dron dron = gv.addDron("0004", "Dron1", "Fabricante1", "Modelo1");
        gv.guardarDronAlmacen(dron);

        // Reparar el dron desde el almacén
        Dron dronReparado = gv.repararDronAlmacen();

        // Verificar que el dron reparado sea el mismo que el dron original
        assertEquals(dron, dronReparado);

        // Verificar que el dron ahora esté operativo
        assertEquals(1, dronReparado.getOperativo());

    }

}