package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Kontrolatzailea.metodoak;

public class TestMetodoak {
	
	@Test
	public void testPasahitzaKonprobatu() {
	    // Proba positiboen kasuak
	    assertTrue(metodoak.pasahitzaKonprobatu("Password1"));
	    assertTrue(metodoak.pasahitzaKonprobatu("Abcd1234"));
	    assertTrue(metodoak.pasahitzaKonprobatu("123456aA"));
	    
	    // Proba negatiboen kasuak
	    assertFalse(metodoak.pasahitzaKonprobatu("password"));
	    assertFalse(metodoak.pasahitzaKonprobatu("123456"));
	    assertFalse(metodoak.pasahitzaKonprobatu("ABCD1234"));
	    assertFalse(metodoak.pasahitzaKonprobatu(""));
	    assertFalse(metodoak.pasahitzaKonprobatu("pass word"));
	}
	
	 @Test
	    public void testBaliokoNAN() {
	        assertTrue(metodoak.nanBalidatu("12345678Z"));
	    }
	    
	    @Test
	    public void testBaliogabekoFormatoa() {
	        assertFalse(metodoak.nanBalidatu("1234X678Z"));
	    }
	    
	    @Test
	    public void testBaliogabekoLetra() {
	        assertFalse(metodoak.nanBalidatu("12345678A"));
	    }
	    
	    @Test
	    public void testBaliogabekoFormatoa2() {
	        assertFalse(metodoak.nanBalidatu("1234567Z"));
	    }
	
}
