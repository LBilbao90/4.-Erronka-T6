package Testak;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Admin;

class TestAdmin {

	@Test
	public void testGettersAndSetters() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date jaioteguna = null;
		try {
			jaioteguna = dateFormat.parse("2000-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin a = new Admin("12345678A", "Jon", "Aguirre", jaioteguna, "Espainia", "Gipuzkoa", "Donostia", "20001", "1234", "123456789", 0, "Admin", 2000.0, 1, 1, "admin@gmail.com");
		
		assertEquals("12345678A", a.getNAN());
		assertEquals("Jon", a.getIzena());
		assertEquals("Aguirre", a.getAbizena());
		assertEquals(jaioteguna, a.getJaioteguna());
		assertEquals("Espainia", a.getHerrialdea());
		assertEquals("Donostia", a.getHerria());
		assertEquals("20001", a.getPostaKodea());
		assertEquals("1234", a.getPasahitza());
		assertEquals("123456789", a.getTlf_zenabkia());
		assertEquals(0,a.getId_maila());
		assertEquals("Admin", a.getKargua());
		assertEquals(2000.0, a.getSoldata());
		assertEquals(1, a.getId_langile());
		assertEquals(1, a.getId_kasino());
		assertEquals("admin@gmail.com", a.getPostaElektronikoa());
		
		a.setNAN("87654321Z");
		a.setIzena("Aimar");
		a.setAbizena("Pelea");
		a.setJaioteguna(jaioteguna);
		a.setHerrialdea("Espainia");
		a.setProbintzia("Bizkaia");
		a.setHerria("Basauri");
		a.setPostaKodea("48970");
		a.setPasahitza("badBunny100pre");
		a.setTlf_zenabkia("634411850");
		a.setId_maila(0);
		a.setKargua("Administratzaile");
		a.setSoldata(5000.0);
		a.setId_langile(2);
		a.setId_kasino(2);
		a.setPostaElektronikoa("pepe@gmail.com");
		
		assertEquals("87654321Z", a.getNAN());
		assertEquals("Aimar", a.getIzena());
		assertEquals("Pelea", a.getAbizena());
		assertEquals(jaioteguna, a.getJaioteguna());
		assertEquals("Espainia", a.getHerrialdea());
		assertEquals("Bizkaia", a.getProbintzia());
		assertEquals("Basauri", a.getHerria());
		assertEquals("48970", a.getPostaKodea());
		assertEquals("badBunny100pre", a.getPasahitza());
		assertEquals("634411850", a.getTlf_zenabkia());
		assertEquals(0,a.getId_maila());
		assertEquals("Administratzaile", a.getKargua());
		assertEquals(5000.0, a.getSoldata());
		assertEquals(2, a.getId_langile());
		assertEquals(2, a.getId_kasino());
		assertEquals("pepe@gmail.com", a.getPostaElektronikoa());
	}
	
	@Test
	public void testEqualsTrue() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date jaioteguna = null;
		try {
			jaioteguna = dateFormat.parse("2000-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin admin1 = new Admin("12345678A", "Jon", "Aguirre", jaioteguna, "Espainia", "Gipuzkoa", "Donostia", "20001", "1234", "123456789", 0, "Admin", 2000.0, 1, 1, "admin@gmail.com");
		Admin admin2 = new Admin("12345678A", "Jon", "Aguirre", jaioteguna, "Espainia", "Gipuzkoa", "Donostia", "20001", "1234", "123456789", 0, "Admin", 2000.0, 1, 1, "admin@gmail.com");

	    assertTrue(admin1.equals(admin2));
	}

	@Test
	public void testEqualsFalse() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date jaioteguna = null;
		try {
			jaioteguna = dateFormat.parse("2000-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin admin1 = new Admin("12345678A", "Jon", "Aguirre", jaioteguna, "Espainia", "Gipuzkoa", "Donostia", "20001", "1234", "123456789", 0, "Admin", 2000.0, 1, 1,"admin@gmail.com");
		Admin admin2 = new Admin("79144847D", "Jon", "Aguirre", jaioteguna, "Espainia", "Gipuzkoa", "Donostia", "20001", "1234", "123456789", 0, "Admin", 2000.0, 1, 1,"admin@gmail.com");

	    assertFalse(admin1.equals(admin2));
	}

	@Test
	public void testHashCode() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date jaioteguna = null;
		try {
			jaioteguna = dateFormat.parse("2000-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin admin1= new Admin("12345678A", "Jon", "Aguirre", jaioteguna, "Espainia", "Gipuzkoa", "Donostia", "20001", "1234", "123456789", 0, "Admin", 2000.0, 1, 1, "admin@gmail.com");
		Admin admin2 = new Admin("12345678A", "Jon", "Aguirre",jaioteguna, "Espainia", "Gipuzkoa", "Donostia", "20001", "1234", "123456789", 0, "Admin", 2000.0, 1, 1, "admin@gmail.com");

	    assertEquals(admin1.hashCode(), admin2.hashCode());
	}

    @Test
    public void testToString() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date jaioteguna = null;
		try {
			jaioteguna = dateFormat.parse("2000-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        Admin admin = new Admin("12345678A", "John", "Doe", jaioteguna, "Spain", "Madrid", "Madrid", "28001","password", "555555555", 1, "Administrator", 1500.0, 1, 1, "admin@gmail.com");
        String expected = "Admin [kargua=Administrator, soldata=1500.0, id_langile=1, id_kasino=1, NAN=12345678A, izena=John, abizena=Doe, jaioteguna="+jaioteguna+", herrialdea=Spain, probintzia=Madrid, herria=Madrid, postaKodea=28001, pasahitza=password, tlf_zenabkia=555555555, postaElektronikoa=admin@gmail.com]";
        assertEquals(expected, admin.toString());
    }
}

