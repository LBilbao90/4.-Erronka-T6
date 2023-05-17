package Testak;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modelo.Jokoak;

public class TestJokoak {

    private Jokoak jokoak;

    @Before
    public void setUp() throws Exception {
        ArrayList<Jokoak> jokuak = new ArrayList<Jokoak>();
        jokoak = new Jokoak(1, "Kasino Berri", "Kasino Kalea 1", 123456789, jokuak);
        jokoak.setId_jokoak(1);
        jokoak.setJokoIzena("Slotak");
        jokoak.setMaxApostu(50.0);
    }

    @Test
    public void testGetId_jokoak() {
        assertEquals(1, jokoak.getId_jokoak());
    }

    @Test
    public void testGetJokoIzena() {
        assertEquals("Slotak", jokoak.getJokoIzena());
    }

    @Test
    public void testGetMaxApostu() {
        assertEquals(50.0, jokoak.getMaxApostu(), 0);
    }

    @Test
    public void testSetId_jokoak() {
        jokoak.setId_jokoak(2);
        assertEquals(2, jokoak.getId_jokoak());
    }

    @Test
    public void testSetJokoIzena() {
        jokoak.setJokoIzena("Ruleta");
        assertEquals("Ruleta", jokoak.getJokoIzena());
    }

    @Test
    public void testSetMaxApostu() {
        jokoak.setMaxApostu(100.0);
        assertEquals(100.0, jokoak.getMaxApostu(), 0);
    }

    @Test
    public void testEquals() {
        Jokoak jokoak2 = new Jokoak(1, "Kasino Berri", "Kasino Kalea 1", 123456789, new ArrayList<Jokoak>());
        jokoak2.setId_jokoak(1);
        jokoak2.setJokoIzena("Slotak");
        jokoak2.setMaxApostu(50.0);
        assertEquals(jokoak, jokoak2);
    }
    
    @Test
    public void testHashCode() {
        Jokoak jokoak1 = new Jokoak(1, "Kasino Berri", "Kasino Kalea 1", 123456789, new ArrayList<Jokoak>());
        jokoak1.setId_jokoak(1);
        jokoak1.setJokoIzena("Slotak");
        jokoak1.setMaxApostu(50.0);

        Jokoak jokoak2 = new Jokoak(1, "Kasino Berri", "Kasino Kalea 1", 123456789, new ArrayList<Jokoak>());
        jokoak2.setId_jokoak(1);
        jokoak2.setJokoIzena("Slotak");
        jokoak2.setMaxApostu(50.0);

        assertEquals(jokoak1.hashCode(), jokoak2.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Jokoak [id_jokoak=1, jokoIzena=Slotak, maxApostu=50.0, id_kasinoa=1]";
        assertEquals(expected, jokoak.toString());
    }

}