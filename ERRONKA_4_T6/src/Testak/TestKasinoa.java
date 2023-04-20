package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import Objetuak.Kasinoa;

class TestKasinoa {
	
    @Test
    public void testGetId_kasinoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        assertEquals(1, kasinoa.getId_kasinoa());
    }
    
    @Test
    public void testSetId_kasinoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        kasinoa.setId_kasinoa(2);
        assertEquals(2, kasinoa.getId_kasinoa());
    }
    
    @Test
    public void testGetIzena() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        assertEquals("Kasino 1", kasinoa.getIzena());
    }
    
    @Test
    public void testSetIzena() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        kasinoa.setIzena("Kasino 2");
        assertEquals("Kasino 2", kasinoa.getIzena());
    }
    
    @Test
    public void testGetHelbidea() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        assertEquals("Kasino Kalea, 1", kasinoa.getHelbidea());
    }
    
    @Test
    public void testSetHelbidea() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        kasinoa.setHelbidea("Beste Kalea, 2");
        assertEquals("Beste Kalea, 2", kasinoa.getHelbidea());
    }
    
    @Test
    public void testGetTelefonoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        assertEquals(123456789, kasinoa.getTelefonoa());
    }
    
    @Test
    public void testSetTelefonoa() {
        Kasinoa kasinoa = new Kasinoa(1, "Kasino 1", "Kasino Kalea, 1", 123456789);
        kasinoa.setTelefonoa(987654321);
        assertEquals(987654321, kasinoa.getTelefonoa());
    }

    @Test
    void testEqualsTrue() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasino1", "Helbidea1", 123456789);
        Kasinoa kasinoa2 = new Kasinoa(1, "Kasino1", "Helbidea1", 123456789);
        boolean equals1 = kasinoa1.equals(kasinoa2);
        assertTrue(equals1);
    }
    
    @Test
    void testEqualsFalse() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasino1", "Helbidea1", 123456789);
        Kasinoa kasinoa2 = new Kasinoa(2, "Kasino2", "Helbidea2", 987654321);  
        boolean equals = kasinoa1.equals(kasinoa2);
        assertFalse(equals);
    }
    
    @Test
    public void testHashCodeEquals() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasinoa 1", "Ibilbidea 1", 123456789);
        Kasinoa kasinoa2 = new Kasinoa(1, "Kasinoa 1", "Ibilbidea 1", 123456789);
        assertEquals(kasinoa1.hashCode(), kasinoa2.hashCode());
    }
  
    @Test
    public void testHashCodeNotEquals() {
        Kasinoa kasinoa1 = new Kasinoa(1, "Kasinoa 1", "Ibilbidea 1", 123456789);
        Kasinoa kasinoa2 = new Kasinoa(2, "Kasinoa 2", "Ibilbidea 2", 987654321);
        assertNotEquals(kasinoa1.hashCode(), kasinoa2.hashCode());
    }
    
    @Test
    public void testToString() {
        Kasinoa k = new Kasinoa(1, "Kasino Berri", "Zazpi Kale 10", 123456789);
        String esperotakoa = "Kasinoa: id_kasinoa=1\nizena=Kasino Berri\nhelbidea=Calle Mayor 10\ntelefonoa=123456789";
        String emaitza = k.toString();
        assertEquals(esperotakoa, emaitza);
    }
}
