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
        assertEquals("34567890V", erabiltzaileak.get(1).getNAN());
        assertEquals(2, erabiltzaileak.get(1).getId_maila());
        assertEquals("48830", erabiltzaileak.get(1).getPostaKodea());
        assertEquals("Euskadi", erabiltzaileak.get(1).getHerrialdea());
        assertEquals("Bizkaia", erabiltzaileak.get(1).getProbintzia());
        assertEquals("Sodupe", erabiltzaileak.get(1).getHerria());
        assertEquals("Siranaula", erabiltzaileak.get(1).getAbizena());
        assertEquals("Aingeru Daniel", erabiltzaileak.get(1).getIzena());
        assertEquals("Elorrieta00", erabiltzaileak.get(1).getPasahitza());
    }
   
    @Test
    public void testLangileak() {
        assertEquals(1, langileak.get(0).getId_langile());
        assertEquals(1, langileak.get(0).getId_kasino());
        assertEquals("Unax", langileak.get(0).getIzena());
        assertEquals("Zulaika", langileak.get(0).getAbizena());
        assertEquals("Euskadi", langileak.get(0).getHerrialdea());
        assertEquals("Gipuzkoa", langileak.get(0).getProbintzia());
        assertEquals("Elgoibar", langileak.get(0).getHerria());
        assertEquals("unax.zulaikafu@elorrieta-errekamari.com", langileak.get(0).getPostaElektronikoa());
        assertEquals("20870", langileak.get(0).getPostaKodea());
        assertEquals("606407364", langileak.get(0).getTlf_zenabkia());

    }
    
    @Test
    public void testMailak() {
        assertEquals(5, mailak.size());
        assertEquals("Blokeatuta", mailak.get(0).getMaila_izena());
        assertEquals(0, mailak.get(0).getApostu_max(), 0.0);
        assertEquals("Baja", mailak.get(1).getMaila_izena());
        assertEquals(0, mailak.get(1).getApostu_max(), 0.0);
        assertEquals("Brontze", mailak.get(2).getMaila_izena());
        assertEquals(1000.0, mailak.get(2).getApostu_max(), 0.0);
        assertEquals("Zilarra", mailak.get(3).getMaila_izena());
        assertEquals(5000.0, mailak.get(3).getApostu_max(), 0.0);
        assertEquals("Urrea", mailak.get(4).getMaila_izena());
        assertEquals(10000.0, mailak.get(4).getApostu_max(), 0.0);
    }
}