package Testak;
import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Maila;

public class TestMaila {

	@Test
	public void testConstructorWithArguments() {
		Maila maila = new Maila("Maila 1", 100.0, 1);
		assertEquals("Maila 1", maila.getMaila_izena());
		assertEquals(100.0, maila.getApostu_max(), 0);
		assertEquals(1, maila.getId_maila());
	}

	@Test
	public void testConstructorWithId() {
		Maila maila = new Maila(2);
		assertEquals(2, maila.getId_maila());
	}

	@Test
	public void testSetAndGetMailaIzena() {
		Maila maila = new Maila();
		maila.setMaila_izena("Maila 2");
		assertEquals("Maila 2", maila.getMaila_izena());
	}

	@Test
	public void testSetAndGetApostuMax() {
		Maila maila = new Maila();
		maila.setApostu_max(200.0);
		assertEquals(200.0, maila.getApostu_max(), 0);
	}

	@Test
	public void testSetAndGetIdMaila() {
		Maila maila = new Maila();
		maila.setId_maila(3);
		assertEquals(3, maila.getId_maila());
	}

	@Test
	public void testEqualsAndHashCode() {
		Maila maila1 = new Maila("Maila 1", 100.0, 1);
		Maila maila2 = new Maila("Maila 2", 200.0, 2);
		Maila maila3 = new Maila("Maila 1", 100.0, 1);
		
		// Test equals method
		assertTrue(maila1.equals(maila3));
		assertFalse(maila1.equals(maila2));
		assertFalse(maila1.equals(null));
		assertFalse(maila1.equals(new Object()));
		
		// Test hashCode method
		assertEquals(maila1.hashCode(), maila3.hashCode());
		assertNotEquals(maila1.hashCode(), maila2.hashCode());
	}

	@Test
	public void testToString() {
		Maila maila = new Maila("Maila 1", 100.0, 1);
		String expected = "Maila [maila_izena=Maila 1, apostu_max=100.0, id_maila=1]";
		assertEquals(expected, maila.toString());
	}
}