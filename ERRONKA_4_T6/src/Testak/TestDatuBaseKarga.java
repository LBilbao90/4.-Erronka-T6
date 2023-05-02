package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import Kontrolatzailea.datuBaseKarga;
import Modelo.Erabiltzaile;
import Modelo.Admin;
import Modelo.Maila;

public class TestDatuBaseKarga {
	
	  public void testKarga() {
	        datuBaseKarga.karga();
	        ArrayList<Erabiltzaile> erabiltzaileak = Erabiltzaile.getInstance().getErabiltzaileak();
	        ArrayList<Admin> langileak = Admin.getInstance().getAdmins();
	        ArrayList<Maila> mailak = Maila.getInstance().getMailak();
	        
	        assertNotNull(erabiltzaileak);
	        assertNotNull(langileak);
	        assertNotNull(mailak);
	        
	        //Mailak konprobatu
	        assertEquals(mailak.get(0).getId_maila(), 1);
	        assertEquals(mailak.get(0).getMaila_izena(), "Maila 1");
	        assertEquals(mailak.get(0).getApostu_max(), 1000.0, 0.0);
	        assertEquals(mailak.get(1).getId_maila(), 2);
	        assertEquals(mailak.get(1).getMaila_izena(), "Maila 2");
	        assertEquals(mailak.get(1).getApostu_max(), 5000.0, 0.0);
	        
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
