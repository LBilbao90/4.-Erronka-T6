package Testak;

import org.junit.jupiter.api.Test;

import Objetuak.Ruleta;

import static org.junit.jupiter.api.Assertions.*;

public class TestRuleta {

    @Test
    public void testGetApustu_kopuru_max() {
        Ruleta ruleta = new Ruleta(10, 5);
        assertEquals(10, ruleta.getApustu_kopuru_max());
    }

    @Test
    public void testSetApustu_kopuru_max() {
        Ruleta ruleta = new Ruleta(10, 5);
        ruleta.setApustu_kopuru_max(15);
        assertEquals(15, ruleta.getApustu_kopuru_max());
    }

    @Test
    public void testGetApustua() {
        Ruleta ruleta = new Ruleta(10, 5);
        assertEquals(5, ruleta.getApustua());
    }

    @Test
    public void testSetApustua() {
        Ruleta ruleta = new Ruleta(10, 5);
        ruleta.setApustua(7);
        assertEquals(7, ruleta.getApustua());
    }

    @Test
    public void testEqualsTrue() {
        Ruleta ruleta1 = new Ruleta(10, 5);
        Ruleta ruleta2 = new Ruleta(10, 5);

        assertTrue(ruleta1.equals(ruleta2));
    }
    
    @Test
    public void testEqualsFalse() {
        Ruleta ruleta1 = new Ruleta(10, 5);
        Ruleta ruleta2 = new Ruleta(15, 7);

        assertFalse(ruleta1.equals(ruleta2));
    }

    @Test
    public void testHashCode() {
        Ruleta ruleta1 = new Ruleta(10, 5);
        Ruleta ruleta2 = new Ruleta(10, 5);

        assertEquals(ruleta1.hashCode(), ruleta2.hashCode());
    }

    @Test
    public void testToString() {
        Ruleta ruleta = new Ruleta(10, 5);
        String expected = "Ruleta apustu_kopuru_max=10/n apustua=5";
        assertEquals(expected, ruleta.toString());
    }
}
