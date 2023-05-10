package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import Modelo.Kasinoa;

class TestKasinoa {
	
    @Test
    public void testGetId_kasinoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        assertEquals(1, kasinoa.getId_kasinoa());
    }
    
    @Test
    public void testSetId_kasinoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        kasinoa.setId_kasinoa(2);
        assertEquals(2, kasinoa.getId_kasinoa());
    }
    
    @Test
    public void testGetIzena() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        assertEquals("Kasino 1", kasinoa.getIzena());
    }
    
    @Test
    public void testSetIzena() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        kasinoa.setIzena("Kasino 2");
        assertEquals("Kasino 2", kasinoa.getIzena());
    }
    
    @Test
    public void testGetHelbidea() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        assertEquals("Kasino Kalea, 1", kasinoa.getHelbidea());
    }
    
    @Test
    public void testSetHelbidea() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        kasinoa.setHelbidea("Beste Kalea, 2");
        assertEquals("Beste Kalea, 2", kasinoa.getHelbidea());
    }
    
    @Test
    public void testGetTelefonoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        assertEquals(123456789, kasinoa.getTelefonoa());
    }
    
    @Test
    public void testSetTelefonoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
        kasinoa.setTelefonoa(987654321);
        assertEquals(987654321, kasinoa.getTelefonoa());
    }
    @Test
    public void testGetJokuak() {
    	Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
    	assertEquals(null,kasinoa.getJokoak());
    }
    @Test
    public void testSetJokuak() {
    	Kasinoa kasinoa = new Kasinoa (1, "Kasino 1", "Kasino Kalea, 1", 123456789, null);
    	kasinoa.setJokoak(null);
    	assertEquals(null,kasinoa.getJokoak());
    }
    @Test
    void testEqualsTrue() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasino1", "Helbidea1", 123456789, null);
        Kasinoa kasinoa2 = new Kasinoa(1, "Kasino1", "Helbidea1", 123456789, null);
        boolean equals1 = kasinoa1.equals(kasinoa2);
        assertTrue(equals1);
    }
    
    @Test
    void testEqualsFalse() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasino1", "Helbidea1", 123456789, null);
        Kasinoa kasinoa2 = new Kasinoa(2, "Kasino2", "Helbidea2", 987654321, null);  
        boolean equals = kasinoa1.equals(kasinoa2);
        assertFalse(equals);
    }
    
    @Test
    public void testHashCodeEquals() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasinoa 1", "Ibilbidea 1", 123456789, null);
        Kasinoa kasinoa2 = new Kasinoa(1, "Kasinoa 1", "Ibilbidea 1", 123456789, null);
        assertEquals(kasinoa1.hashCode(), kasinoa2.hashCode());
    }
  
    @Test
    public void testHashCodeNotEquals() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasinoa 1", "Ibilbidea 1", 123456789, null);
        Kasinoa kasinoa2 = new Kasinoa(2, "Kasinoa 2", "Ibilbidea 2", 987654321, null);
        assertNotEquals(kasinoa1.hashCode(), kasinoa2.hashCode());
    }
    
    @Test
    public void testToString() {
        Kasinoa k = new Kasinoa(1, "Kasino Berri", "Zazpi Kale 10", 123456789, null);
        String esperotakoa = "Kasinoa: id_kasinoa=1\nizena=Kasino Berri\nhelbidea=Zazpi Kale 10\ntelefonoa=123456789";
        String emaitza = k.toString();
        assertEquals(esperotakoa, emaitza);
    }
}
