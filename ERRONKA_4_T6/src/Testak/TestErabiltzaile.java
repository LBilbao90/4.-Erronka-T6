package Testak;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Erabiltzaile;

public class TestErabiltzaile {
    
    @Test
    public void testKonstruktorea() {
        Erabiltzaile erab = new Erabiltzaile("12345678A", "Jon", "Garcia", "2000-01-01", "Espainia", "Gipuzkoa", "Donostia", "20018", "pasahitza", "943123456", 1, 100.0, 20.0);
        assertEquals("12345678A", erab.getNAN());
        assertEquals("Jon", erab.getIzena());
        assertEquals("Garcia", erab.getAbizena());
        assertEquals("2000-01-01", erab.getJaioteguna());
        assertEquals("Espainia", erab.getHerrialdea());
        assertEquals("Gipuzkoa", erab.getProbintzia());
        assertEquals("Donostia", erab.getHerria());
        assertEquals("20018", erab.getPostaKodea());
        assertEquals("pasahitza", erab.getPasahitza());
        assertEquals("943123456", erab.getTlf_zenabkia());
        assertEquals(1, erab.getId_maila());
        assertEquals(100.0, erab.getDiru_kopuru_historikoa());
        assertEquals(20.0, erab.getDiru_kopuru_momentukoa());
    }
   
    @Test
    public void testSetterGetters() {
        Erabiltzaile erab = new Erabiltzaile();
        erab.setNAN("12345678A");
        erab.setIzena("Jon");
        erab.setAbizena("Garcia");
        erab.setJaioteguna("2000-01-01");
        erab.setHerrialdea("Espainia");
        erab.setProbintzia("Gipuzkoa");
        erab.setHerria("Donostia");
        erab.setPostaKodea("20018");
        erab.setPasahitza("pasahitza");
        erab.setTlf_zenabkia("943123456");
        erab.setId_maila(1);
        erab.setDiru_kopuru_historikoa(100.0);
        erab.setDiru_kopuru_momentukoa(20.0);
        
        assertEquals("12345678A", erab.getNAN());
        assertEquals("Jon", erab.getIzena());
        assertEquals("Garcia", erab.getAbizena());
        assertEquals("2000-01-01", erab.getJaioteguna());
        assertEquals("Espainia", erab.getHerrialdea());
        assertEquals("Gipuzkoa", erab.getProbintzia());
        assertEquals("Donostia", erab.getHerria());
        assertEquals("20018", erab.getPostaKodea());
        assertEquals("pasahitza", erab.getPasahitza());
        assertEquals("943123456", erab.getTlf_zenabkia());
        assertEquals(1, erab.getId_maila());
        assertEquals(100.0, erab.getDiru_kopuru_historikoa());
        assertEquals(20.0, erab.getDiru_kopuru_momentukoa());
    }

        @Test
        public void testHashCode() {
            Erabiltzaile e1 = new Erabiltzaile("12345678A", "Juan", "García", "01/01/2000", "España", "Madrid", "Madrid", "28001", "password", "123456789", 1, 100.0, 50.0);
            Erabiltzaile e2 = new Erabiltzaile("12345678A", "Juan", "García", "01/01/2000", "España", "Madrid", "Madrid", "28001", "password", "123456789", 1, 100.0, 50.0);
            assertEquals(e1.hashCode(), e2.hashCode());
        }

        @Test
        public void testEquals() {
            Erabiltzaile e1 = new Erabiltzaile("12345678A", "Juan", "García", "01/01/2000", "España", "Madrid", "Madrid", "28001", "password", "123456789", 1, 100.0, 50.0);
            Erabiltzaile e2 = new Erabiltzaile("12345678A", "Juan", "García", "01/01/2000", "España", "Madrid", "Madrid", "28001", "password", "123456789", 1, 100.0, 50.0);
            Erabiltzaile e3 = new Erabiltzaile("87654321B", "Pedro", "López", "02/02/2000", "España", "Barcelona", "Barcelona", "08001", "password2", "987654321", 1, 200.0, 70.0);
            assertTrue(e1.equals(e2));
            assertFalse(e1.equals(e3));
        }

        @Test
        public void testToString() {
            Erabiltzaile e1 = new Erabiltzaile("12345678A", "Juan", "García", "01/01/2000", "España", "Madrid", "Madrid", "28001", "password", "123456789", 1, 100.0, 50.0);
            String expected = "Erabiltzaile [NAN=12345678A, izena=Juan, abizena=García, jaioteguna=01/01/2000, herrialdea=España, probintzia=Madrid, herria=Madrid, postaKodea=28001, pasahitza=password, tlf_zenabkia=123456789, diru_kopuru_historikoa=100.0, diru_kopuru_momentukoa=50.0]";
            assertEquals(expected, e1.toString());
        }
}
