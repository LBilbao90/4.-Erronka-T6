package Testak;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

import Kontrolatzailea.datuBaseKarga;
import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.Maila;

public class TestDatuBaseKarga {

    private static ArrayList<Erabiltzaile> erabiltzaileak;
    private static ArrayList<Admin> langileak;
    private static ArrayList<Maila> mailak;
    
    @BeforeClass
    public static void setUp() {
        datuBaseKarga.karga();
        erabiltzaileak = datuBaseKarga.getErabiltzaileak();
        langileak = datuBaseKarga.getLangileak();
        mailak = datuBaseKarga.getMailak();
    }
    
    @Test
    public void testErabiltzaileak() {
        assertEquals(1, erabiltzaileak.size());
        assertEquals("12345678A", erabiltzaileak.get(0).getNAN());
        assertEquals(2, erabiltzaileak.get(0).getId_maila());
//        assertEquals(1000.0, erabiltzaileak.get(0).getDiru_kopuru_historikoa());
//        assertEquals(505.0, erabiltzaileak.get(0).getDiru_kopuru_momentukoa());
        assertEquals("12345", erabiltzaileak.get(0).getPostaKodea());
        assertEquals("Gipuzkoa", erabiltzaileak.get(0).getHerrialdea());
        assertEquals("Gipuzkoa", erabiltzaileak.get(0).getProbintzia());
        assertEquals("Donostia", erabiltzaileak.get(0).getHerria());
        assertEquals("Garcia", erabiltzaileak.get(0).getAbizena());
        assertEquals("jgarcia", erabiltzaileak.get(0).getIzena());
        assertEquals("elorrieta00", erabiltzaileak.get(0).getPasahitza());
    }
    
    @Test
    public void testLangileak() {
        assertEquals(1, langileak.size());
        assertEquals(1, langileak.get(0).getId_langile());
        assertEquals(1, langileak.get(0).getId_kasino());
        assertEquals("Jon", langileak.get(0).getIzena());
        assertEquals("Doe", langileak.get(0).getAbizena());
        assertEquals("Spain", langileak.get(0).getHerrialdea());
        assertEquals("Barcelona", langileak.get(0).getProbintzia());
        assertEquals("Barcelona", langileak.get(0).getHerria());
    }
    
    @Test
    public void testMailak() {
        assertEquals(3, mailak.size());
        assertEquals("Brontze", mailak.get(0).getMaila_izena());
        assertEquals(100.0, mailak.get(0).getApostu_max(), 0.0);
        assertEquals("Zilarra", mailak.get(1).getMaila_izena());
        assertEquals(500.0, mailak.get(1).getApostu_max(), 0.0);
        assertEquals("Urrea", mailak.get(2).getMaila_izena());
        assertEquals(1000.0, mailak.get(2).getApostu_max(), 0.0);
    }
}
