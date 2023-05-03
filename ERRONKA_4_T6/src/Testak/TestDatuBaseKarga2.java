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
    public void testKargaMaila() {
        datuBaseKarga.karga();
        
        assertNotNull(mailak);
       
        //Mailak konprobatu
        assertEquals(mailak.get(0).getId_maila(), 1);
        assertEquals(mailak.get(0).getMaila_izena(), "Brontze");
        assertEquals(mailak.get(2).getApostu_max(), 100.0);
        assertEquals(mailak.get(1).getId_maila(), 2);
        assertEquals(mailak.get(1).getMaila_izena(), "Zilarra");
        assertEquals(mailak.get(2).getApostu_max(), 500.0);
        assertEquals(mailak.get(2).getId_maila(), 3);
        assertEquals(mailak.get(2).getMaila_izena(), "Urrea");
        assertEquals(mailak.get(2).getApostu_max(), 1000.0);
        
    }
    @Test
    public void testKargaErabiltzailea() {
         datuBaseKarga.karga();
            
         assertNotNull(erabiltzaileak);
        //Erabiltzaileak konprobatu
        assertEquals(erabiltzaileak.get(0).getNAN(), "12345678A");
        assertEquals(erabiltzaileak.get(0).getId_maila(), 1);
        assertEquals(erabiltzaileak.get(0).getDiru_kopuru_historikoa(), 10000.0, 0.0);
        assertEquals(erabiltzaileak.get(0).getDiru_kopuru_momentukoa(), 500.0, 0.0);
        assertEquals(erabiltzaileak.get(0).getTlf_zenabkia(), "666777888");
        assertEquals(erabiltzaileak.get(0).getPostaKodea(), "48001");
        assertEquals(erabiltzaileak.get(0).getHerrialdea(), "Espainia");
        assertEquals(erabiltzaileak.get(0).getProbintzia(), "Gipuzkoa");
        assertEquals(erabiltzaileak.get(0).getHerria(), "Donostia");
        assertEquals(erabiltzaileak.get(0).getJaioteguna(), "2000-01-01");
        assertEquals(erabiltzaileak.get(0).getAbizena(), "Pérez");
        assertEquals(erabiltzaileak.get(0).getIzena(), "Juan");
        assertEquals(erabiltzaileak.get(0).getPasahitza(), "1234");     
        
    }
    @Test
    public void testKargaLangilea() {
         datuBaseKarga.karga();
            
         assertNotNull(langileak);
        //Langileak konprobatu
        assertEquals(langileak.get(0).getId_langile(), 1);
        assertEquals(langileak.get(0).getId_kasino(), 1);
        assertEquals(langileak.get(0).getNAN(), "98765432B");
        assertEquals(langileak.get(0).getIzena(), "Ana");
        assertEquals(langileak.get(0).getAbizena(), "García");
        assertEquals(langileak.get(0).getPasahitza(), "admin");
        assertEquals(langileak.get(1).getId_langile(), 2);
        assertEquals(langileak.get(1).getId_kasino(), 1);
        assertEquals(langileak.get(1).getNAN(), "12345678B");
        assertEquals(langileak.get(1).getIzena(), "Pablo");
        assertEquals(langileak.get(1).getAbizena(), "López");
        assertEquals(langileak.get(1).getPasahitza(), "admin");
    }
}