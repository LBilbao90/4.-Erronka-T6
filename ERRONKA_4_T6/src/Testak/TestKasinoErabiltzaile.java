package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Modelo.KasinoErabiltzaile;

public class TestKasinoErabiltzaile {
	
	 @Test
	    public void testGetId_Kasino() {
	        KasinoErabiltzaile user = new KasinoErabiltzaile(1, "12345678A");
	        int expected = 1;
	        assertEquals(expected, user.getId_Kasino());
	    }

    @Test
    public void testSetId_Kasino() {
        KasinoErabiltzaile user = new KasinoErabiltzaile(1, "12345678A");
        int expected = 2;
        user.setId_Kasino(2);
        assertEquals(expected, user.getId_Kasino());
    }

    @Test
    public void testGetNAN() {
        KasinoErabiltzaile user = new KasinoErabiltzaile(1, "12345678A");
        String expected = "12345678A";
        assertEquals(expected, user.getNAN());
    }

    @Test
    public void testSetNAN() {
        KasinoErabiltzaile user = new KasinoErabiltzaile(1, "12345678A");
        String expected = "23456789B";
        user.setNAN("23456789B");
        assertEquals(expected, user.getNAN());
    }

    @Test
    public void testEqualsAndHashCode() {
        KasinoErabiltzaile user1 = new KasinoErabiltzaile(3, "12345678A");
        KasinoErabiltzaile user2 = new KasinoErabiltzaile(3, "12345678A");
        KasinoErabiltzaile user3 = new KasinoErabiltzaile(5, "23456789B");

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());


        assertNotEquals(user1, user3);
        assertNotEquals(user1.hashCode(), user3.hashCode());
    }

    @Test
    public void testToString() {
        KasinoErabiltzaile user = new KasinoErabiltzaile(1, "12345678A");
        String expected = "KasinoErabiltzaile [Id_Kasino=1, NAN=12345678A]";
        assertEquals(expected, user.toString());
    }
    
}
