package Testak;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import Kontrolatzailea.balidazioak;
import Kontrolatzailea.datuBaseKarga;

public class TestBalidazioak {
	@Test
	public void testPasahitzaKonprobatu() {
		// Proba positiboen kasuak
		assertTrue(balidazioak.pasahitzaKonprobatu("Password1"));
		assertTrue(balidazioak.pasahitzaKonprobatu("Abcd1234"));
		assertTrue(balidazioak.pasahitzaKonprobatu("123456aA"));
	
		// Proba negatiboen kasuak
		assertFalse(balidazioak.pasahitzaKonprobatu("password"));
		assertFalse(balidazioak.pasahitzaKonprobatu("123456"));
		assertFalse(balidazioak.pasahitzaKonprobatu("ABCD1234"));
		assertFalse(balidazioak.pasahitzaKonprobatu(""));
		assertFalse(balidazioak.pasahitzaKonprobatu("pass word"));
	}
	
	 @Test
	public void testBaliokoNAN() {
		 assertTrue(balidazioak.nanBalidatu("12345678Z"));
	}
	
	@Test
	public void testBaliogabekoFormatoa() {
		assertFalse(balidazioak.nanBalidatu("1234X678Z"));
	}
	
	@Test
	public void testBaliogabekoLetra() {
		assertFalse(balidazioak.nanBalidatu("12345678A"));
	}
	
	@Test
	public void testBaliogabekoFormatoa2() {
		assertFalse(balidazioak.nanBalidatu("1234567Z"));
	}
	
	  @Test
	    public void testZbkDa() {
	    	assertTrue(balidazioak.zbkDa("12"));
	    	assertTrue(balidazioak.zbkDa("-12"));
	    	assertTrue(balidazioak.zbkDa("0"));
	    	assertFalse(balidazioak.zbkDa("A"));
	    	assertFalse(balidazioak.zbkDa("a"));
	    	assertFalse(balidazioak.zbkDa("@"));
	    	assertFalse(balidazioak.zbkDa(" "));
	    	assertFalse(balidazioak.zbkDa(""));
	    	assertFalse(balidazioak.zbkDa("12.34"));
	    	assertFalse(balidazioak.zbkDa("12a"));
	    	assertFalse(balidazioak.zbkDa(null));
	    }
	    
	    @Test
	    public void testJaiotzeData() {
	    	assertTrue(balidazioak.jaiotzeDataOndo("2023-05-04"));
	    	assertFalse(balidazioak.jaiotzeDataOndo("2023/13/04"));
	    	assertFalse(balidazioak.jaiotzeDataOndo("23-05-04"));
	    	assertFalse(balidazioak.jaiotzeDataOndo("2023\05\04"));
	    	assertFalse(balidazioak.jaiotzeDataOndo("2023-0a-04"));
	    	assertFalse(balidazioak.jaiotzeDataOndo("2023-05- 04"));
	    	assertFalse(balidazioak.jaiotzeDataOndo("04-05-2023"));
	    	assertFalse(balidazioak.jaiotzeDataOndo("04-05-23"));
	    	assertFalse(balidazioak.jaiotzeDataOndo(""));
	    }
	    
	    @Test
	    public void testLoginBalidazioaErabiltzaile() {
	        datuBaseKarga.karga();
	        Assert.assertEquals(0,balidazioak.loginBalidazioaErabiltzaile("12345678A", "elorrieta00".toCharArray()));
	        Assert.assertEquals(1,balidazioak.loginBalidazioaErabiltzaile("03418239W", "Elorrieta00".toCharArray()));
	        Assert.assertEquals(2,balidazioak.loginBalidazioaErabiltzaile("34567890V", "Elorrieta00".toCharArray()));
	    }

	
	    @Test
	    public void testTlfZuzena() {
	        assertTrue(balidazioak.tlfZenbakia("123456789"));
	    }

	    @Test
	    public void testTlfLuzeeraOkerra() {
	        assertFalse(balidazioak.tlfZenbakia("12345678"));
	    }

	    @Test
	    public void testTlfLetrekin() {
	        assertFalse(balidazioak.tlfZenbakia("12a456789"));
	    }
	    
	    @Test
	    public void testBaliozkoEremuak() {
	    	String NAN = "12345678Z";
	    	String Izena = "Proba";
	    	String Abizena = "Kontua";
	    	String Pasahitza = "Elorrieta00";
	    	String JaiotzeDataString = "2000-01-01";
	    	String Herrialdea = "Euskadi";
	    	String Probintzia = "Gipuzkoa";
	    	String Herria = "Elgoibar";
	    	String PostaKodea = "20870";
	    	String TelefonoZbk = "666999666";
	    	
	    	// Dena ondo
	    	assertTrue(balidazioak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk));
	    	// NAN hutsik
	    	assertFalse(balidazioak.baliozkoEremuak("", Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk));
	    	// Izena hutsik
	    	assertFalse(balidazioak.baliozkoEremuak(NAN, "", Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk));
	    	// Izena 4 karaktera baino gutxiago
	    	assertFalse(balidazioak.baliozkoEremuak(NAN, "Pr", Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk));
	    	// Pasahitzak ez du kondizio guztiak betetzen
	    	assertFalse(balidazioak.baliozkoEremuak(NAN, Izena, Abizena, "Elorrieta", JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk));
	    	// Telefono gaizki
	    	assertFalse(balidazioak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, "12345678"));
	    	// Posta kode luzeera gutxi
	    	assertFalse(balidazioak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, "1234", TelefonoZbk));
	    	// Posta kode gaizki, letra bat duelako.
	    	assertFalse(balidazioak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, "12A45", TelefonoZbk));
	    	// NAN gaizki
	    	assertFalse(balidazioak.baliozkoEremuak("12345678A", Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk));
	    }
	    
}