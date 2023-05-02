package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Kontrolatzailea.datuBaseKarga;
import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.Maila;

public class TestDatuBaseKarga2 {

    private ArrayList<Erabiltzaile> erabiltzaileak;
    private ArrayList<Admin> langileak;
    private ArrayList<Maila> mailak;

    @Before
    public void setUp() {
        // Initialize the ArrayLists before running each test
        erabiltzaileak = new ArrayList<>();
        langileak = new ArrayList<>();
        mailak = new ArrayList<>();
    }

    @Test
    public void testKarga() {
        // Call the karga() method
        datuBaseKarga.karga();

        // Check that the ArrayLists have been populated with data
        assertNotNull("erabiltzaileak is null", erabiltzaileak);
        assertNotNull("langileak is null", langileak);
        assertNotNull("mailak is null", mailak);

        // Check that the ArrayLists contain the expected number of objects
        assertEquals("erabiltzaileak size is incorrect", erabiltzaileak.size(), 2);
        assertEquals("langileak size is incorrect", langileak.size(), 1);
        assertEquals("mailak size is incorrect", mailak.size(), 3);

        // Check that the objects in the ArrayLists have been initialized correctly
        // For example, check that the first Maila object has the expected values
        Maila maila1 = mailak.get(0);
        assertEquals("maila1 id_maila is incorrect", maila1.getId_maila(), 1);
        assertEquals("maila1 maila_izena is incorrect", maila1.getMaila_izena(), "A");
        assertEquals("maila1 apostu_max is incorrect", maila1.getApostu_max(), 1000.0, 0.001);

        // Check that the objects in the ArrayLists are of the expected type
        // For example, check that the first Erabiltzaile object is actually an instance of the Erabiltzaile class
        assertTrue("erabiltzaileak does not contain Erabiltzaile objects", erabiltzaileak.get(0) instanceof Erabiltzaile);
        assertTrue("langileak does not contain Admin objects", langileak.get(0) instanceof Admin);
        assertTrue("mailak does not contain Maila objects", mailak.get(0) instanceof Maila);
    }
}
