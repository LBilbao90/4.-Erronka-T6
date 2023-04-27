package Testak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Erabiltzaile;
import Modelo.Maila;

class TestErabiltzailea {
	String NAN = "48987755P";
	String izena = "Andoni";
	String abizena = "Fernandez";
	Date jaioteguna = null;
	String herrialdea = "Espainia";
	String autonomia_erkidegoa = "Andaluzia";
	String probintzia = "Granada";
	String herria = "Granada";
	String postaKodea = "18001";
	String posta_elektronikoa = "granada@gmail.com";
	String pasahitza = "12345";
	String tlf_zenbakia = "622767230";
	String erabiltzaile_izena = "mkm";
	double diru_kopuru_historikoa = 120;
	double diru_kopuru_momentukoa = 20;
	Maila maila; 
	Erabiltzaile erabiltzaile = new Erabiltzaile(NAN, izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa,
			probintzia, herria, postaKodea, posta_elektronikoa, pasahitza, tlf_zenbakia,
			erabiltzaile_izena, diru_kopuru_historikoa, diru_kopuru_momentukoa, maila);
	Erabiltzaile erabiltzaile1 = new Erabiltzaile (NAN, izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa,
			probintzia, herria, postaKodea, posta_elektronikoa, pasahitza, tlf_zenbakia,
			erabiltzaile_izena, diru_kopuru_historikoa, diru_kopuru_momentukoa, maila);
	@Test
	void testGettersSetters() {
		erabiltzaile.setNAN(NAN);
		erabiltzaile.setIzena(izena);
		erabiltzaile.setAbizena(abizena);
		erabiltzaile.setJaioteguna(jaioteguna);
		erabiltzaile.setHerrialdea(herrialdea);
		erabiltzaile.setAutonomia_erkidegoa(autonomia_erkidegoa);
		erabiltzaile.setHerria(herria);
		erabiltzaile.setPostaKodea(postaKodea);
		erabiltzaile.setPosta_elektronikoa(posta_elektronikoa);
		erabiltzaile.setPasahitza(pasahitza);
		erabiltzaile.setProbintzia(probintzia);
		erabiltzaile.setTlf_zenabkia(tlf_zenbakia);
		erabiltzaile.setErabiltzaile_izena(erabiltzaile_izena);
		erabiltzaile.setDiru_kopuru_historikoa(diru_kopuru_historikoa);
		erabiltzaile.setDiru_kopuru_momentukoa(diru_kopuru_momentukoa);
		erabiltzaile.setMaila(maila);
		assertEquals(erabiltzaile.getNAN(),NAN);
		assertEquals(erabiltzaile.getIzena(),izena);
		assertEquals(erabiltzaile.getAbizena(),abizena);
		assertEquals(erabiltzaile.getJaioteguna(),jaioteguna);
		assertEquals(erabiltzaile.getHerrialdea(),herrialdea);
		assertEquals(erabiltzaile.getAutonomia_erkidegoa(),autonomia_erkidegoa);
		assertEquals(erabiltzaile.getHerria(),herria);
		assertEquals(erabiltzaile.getPostaKodea(),postaKodea);
		assertEquals(erabiltzaile.getPosta_elektronikoa(),posta_elektronikoa);
		assertEquals(erabiltzaile.getPasahitza(),pasahitza);
		assertEquals(erabiltzaile.getTlf_zenabkia(),tlf_zenbakia);
		assertEquals(erabiltzaile.getErabiltzaile_izena(),erabiltzaile_izena);
		assertEquals(erabiltzaile.getDiru_kopuru_historikoa(),diru_kopuru_historikoa);
		assertEquals(erabiltzaile.getDiru_kopuru_momentukoa(),diru_kopuru_momentukoa);
		assertEquals(erabiltzaile.getProbintzia(),probintzia);
		assertEquals(erabiltzaile.getMaila(),maila);
		}
	@Test
	void testToString() {
		String expected="Erablitzaile [erabiltzaile_izena=" + erabiltzaile_izena + "\ndiru_kopuru_historikoa="
				+ diru_kopuru_historikoa + "\ndiru_kopuru_momentukoa=" + diru_kopuru_momentukoa + "\nNAN=" + NAN
				+ "\nizena=" + izena + "\nabizena=" + abizena + "\njaioteguna=" + jaioteguna + "\nherrialdea="
				+ herrialdea + "\nautonomia_erkidegoa=" + autonomia_erkidegoa + "\nprobintzia=" + probintzia
				+ "\nherria=" + herria + "\npostaKodea=" + postaKodea + "\nposta_elektronikoa=" + posta_elektronikoa
				+ "\npasahitza=" + pasahitza + "\ntlf_zenabkia=" + tlf_zenbakia + "]";
		assertEquals(expected,erabiltzaile.toString());
	}
	@Test
	void testHashcode() {
	      int hashCode = erabiltzaile.hashCode();
	      assertEquals(1416777188, hashCode);
	}
	@Test
    public void testEqualsTrue() {
        Erabiltzaile erabiltzaile = new Erabiltzaile(NAN, izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa,
			probintzia, herria, postaKodea, posta_elektronikoa, pasahitza, tlf_zenbakia,
			erabiltzaile_izena, diru_kopuru_historikoa, diru_kopuru_momentukoa, maila);
        Erabiltzaile erabiltzaile1 = new Erabiltzaile(NAN, izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa,
    			probintzia, herria, postaKodea, posta_elektronikoa, pasahitza, tlf_zenbakia,
    			erabiltzaile_izena, diru_kopuru_historikoa, diru_kopuru_momentukoa, maila);
        assertTrue(erabiltzaile.equals(erabiltzaile1));
    }
	@Test
    public void testEqualsFalse() {
		Erabiltzaile erabiltzaile = new Erabiltzaile(NAN, izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa,
				probintzia, herria, postaKodea, posta_elektronikoa, pasahitza, tlf_zenbakia,
				erabiltzaile_izena, diru_kopuru_historikoa, diru_kopuru_momentukoa, maila);
	    Erabiltzaile erabiltzaile1 = new Erabiltzaile("48987766V", izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa,
	    			probintzia, herria, postaKodea, posta_elektronikoa, pasahitza, tlf_zenbakia,
	    			erabiltzaile_izena, diru_kopuru_historikoa, diru_kopuru_momentukoa, maila);
	    assertFalse(erabiltzaile.equals(erabiltzaile1));
    }
	@Test
	void testErakutsi() {
		String expected = "Datuak:\n" +erabiltzaile_izena+"\ndiru kopuru historikoa:"+diru_kopuru_historikoa
				+"\ndiru kopuru momentukoa:"+diru_kopuru_momentukoa;
		assertEquals(expected, erabiltzaile.erakutsi());
	   }
}
