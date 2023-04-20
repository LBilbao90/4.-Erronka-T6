package Testak;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Objetuak.Admin;

class TestAdmin {

	@Test
	public void testGettersAndSetters() {
		Date date = new Date();
		Admin a = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Kargua", 2000.0, 1, 1);
		
		assertEquals("12345678A", a.getNAN());
		assertEquals("Jon", a.getIzena());
		assertEquals("Aguirre", a.getAbizena());
		assertEquals(date, a.getJaioteguna());
		assertEquals("Espainia", a.getHerrialdea());
		assertEquals("Euskadi", a.getAutonomia_erkidegoa());
		assertEquals("Gipuzkoa", a.getProbintzia());
		assertEquals("Donostia", a.getHerria());
		assertEquals("20001", a.getPostaKodea());
		assertEquals("jaguirre@gmail.com", a.getPosta_elektronikoa());
		assertEquals("1234", a.getPasahitza());
		assertEquals("123456789", a.getTlf_zenabkia());
		assertEquals("Kargua", a.getKargua());
		assertEquals(2000.0, a.getSoldata());
		assertEquals(1, a.getId_langile());
		assertEquals(1, a.getId_kasino());
		
		a.setNAN("87654321Z");
		a.setIzena("Aimar");
		a.setAbizena("Pelea");
		Date newDate = new Date();
		a.setJaioteguna(newDate);
		a.setHerrialdea("Espainia");
		a.setAutonomia_erkidegoa("Euskadi");
		a.setProbintzia("Bizkaia");
		a.setHerria("Basauri");
		a.setPostaKodea("48970");
		a.setPosta_elektronikoa("aimar.peleaar@elorrieta-errekamari.com");
		a.setPasahitza("badBunny100pre");
		a.setTlf_zenabkia("634411850");
		a.setKargua("Admin");
		a.setSoldata(5000.0);
		a.setId_langile(2);
		a.setId_kasino(2);
		
		assertEquals("87654321Z", a.getNAN());
		assertEquals("Aimar", a.getIzena());
		assertEquals("Pelea", a.getAbizena());
		assertEquals(newDate, a.getJaioteguna());
		assertEquals("Espainia", a.getHerrialdea());
		assertEquals("Euskadi", a.getAutonomia_erkidegoa());
		assertEquals("Bizkaia", a.getProbintzia());
		assertEquals("Basauri", a.getHerria());
		assertEquals("48970", a.getPostaKodea());
		assertEquals("aimar.peleaar@elorrieta-errekamari.com", a.getPosta_elektronikoa());
		assertEquals("badBunny100pre", a.getPasahitza());
		assertEquals("634411850", a.getTlf_zenabkia());
		assertEquals("Admin", a.getKargua());
		assertEquals(5000.0, a.getSoldata());
		assertEquals(2, a.getId_langile());
		assertEquals(2, a.getId_kasino());
	}
	
	@Test
	public void testEqualsTrue() {
	    Date date = new Date();
	    Admin admin1 = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Admin", 50000.0, 1, 1);
	    Admin admin2 = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Admin", 50000.0, 1, 1);

	    assertTrue(admin1.equals(admin2));
	}

	@Test
	public void testEqualsFalse() {
	    Date date = new Date();
	    Admin admin1 = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Admin", 50000.0, 1, 1);
	    Admin admin2 = new Admin("87654321Z", "Aimar", "Pelea", date, "Espainia", "Euskadi", "Bizkaia", "Basauri", "48970", "aimar.peleaar@elorrieta-errekamari.com", "badBunny100pre", "634411850", "Admin", 50000.0, 2, 2);

	    assertFalse(admin1.equals(admin2));
	}

	@Test
	public void testHashCode() {
	    Date date = new Date();
	    Admin admin1 = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Admin", 50000.0, 1, 1);
	    Admin admin2 = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Admin", 50000.0, 1, 1);

	    assertEquals(admin1.hashCode(), admin2.hashCode());
	}

	@Test
	public void testToString() {
	    Date date = new Date();
	    Admin a = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Administratzailea", 2000.0, 1, 2);
	    String expected = "Admin [kargua=Administratzailea\nsoldata=2000.0\nid_langile=1\nid_kasino=2\nNAN=12345678A\nizena=Jon\nabizena=Aguirre\njaioteguna=" + date + "\nherrialdea=Espainia\nautonomia_erkidegoa=Euskadi\nprobintzia=Gipuzkoa\nherria=Donostia\npostaKodea=20001\nposta_elektronikoa=jaguirre@gmail.com\npasahitza=1234\ntlf_zenabkia=123456789]";
	    assertEquals(expected, a.toString());
	}
}
