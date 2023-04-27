package Testak;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Admin;
import Modelo.Baimena;
import Modelo.Erabiltzaile;
import Modelo.Pertsona;

class TestAdmin {

	
	//GETTERS & SETTERS
	@Test
	public void testGettersAndSetters() {
		
		//	KONSTRUKTOREA
		Date date = new Date();
		Admin a = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Kargua", 2000.0, 1, 1);
		
		//getters
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
		
		
		//setters
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
		
		
		//assertions
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
	
	
	//EQUALS
	
	//true
	@Test 
	void test_admin_True() { 
		Date data = new Date();
		Pertsona p1 = new Erabiltzaile("12345678L", "pedro", "pascal", data, "bilbo", "San Sebastian", "aragon", "bilbao la vieja", "4444", "si@gmail.com", "123macarron", "123456789", "macarroncito", 44,55);
		Baimena baimena_test_equals1 = new Baimena("pedro", 1, data, data, p1);
		Baimena baimena_test_equals2 = new Baimena("pedro", 1, data, data, p1);
		assertTrue(baimena_test_equals1.equals(baimena_test_equals2));
	}

	//false
	@Test 
	void test_admin_EqualsFalse() {
		Date data = new Date();
		Pertsona p1 = new Erabiltzaile("12345678L", "pedro", "pascal", data, "bilbo", "San Sebastian", "aragon", "bilbao la vieja", "4444", "si@gmail.com", "123macarron", "123456789", "macarroncito", 44,55);
		Baimena baimena_test_hascode1 = new Baimena("pedro", 1, data, data, p1);
		Baimena baimena_test_hascode2 = new Baimena("unax", 1, data, data, p1);
		assertFalse(baimena_test_hascode1.equals(baimena_test_hascode2));
	}

	
	//HASCODE
	@Test
	public void testHashCode() {
	    Date date = new Date();
	    Admin admin1 = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Admin", 50000.0, 1, 1);
	    Admin admin2 = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Admin", 50000.0, 1, 1);

	    assertEquals(admin1.hashCode(), admin2.hashCode());
	}
	
	
	//TOSTRING
	@Test
	public void testToString() {
	    Date date = new Date();
	    Admin a = new Admin("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789", "Administratzailea", 2000.0, 1, 2);
	    String expected = "Admin [kargua=Administratzailea\nsoldata=2000.0\nid_langile=1\nid_kasino=2\nNAN=12345678A\nizena=Jon\nabizena=Aguirre\njaioteguna=" + date + "\nherrialdea=Espainia\nautonomia_erkidegoa=Euskadi\nprobintzia=Gipuzkoa\nherria=Donostia\npostaKodea=20001\nposta_elektronikoa=jaguirre@gmail.com\npasahitza=1234\ntlf_zenabkia=123456789]";
	    assertEquals(expected, a.toString());
	}
}
