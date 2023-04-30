package Testak;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//
//import Objetuak.Erabiltzaile;
//import Objetuak.Pertsona;
//
//public class TestPertsona{
//
//	@Test
//	public void testGettersAndSetters() {
//		Date date = new Date();
//		Pertsona p = new Pertsona("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789");
//		
//		assertEquals("12345678A", p.getNAN());
//		assertEquals("Jon", p.getIzena());
//		assertEquals("Aguirre", p.getAbizena());
//		assertEquals(date, p.getJaioteguna());
//		assertEquals("Espainia", p.getHerrialdea());
//		assertEquals("Euskadi", p.getAutonomia_erkidegoa());
//		assertEquals("Gipuzkoa", p.getProbintzia());
//		assertEquals("Donostia", p.getHerria());
//		assertEquals("20001", p.getPostaKodea());
//		assertEquals("jaguirre@gmail.com", p.getPosta_elektronikoa());
//		assertEquals("1234", p.getPasahitza());
//		assertEquals("123456789", p.getTlf_zenabkia());
//		
//		p.setNAN("87654321Z");
//		p.setIzena("Aimar");
//		p.setAbizena("Pelea");
//		Date newDate = new Date();
//		p.setJaioteguna(newDate);
//		p.setHerrialdea("Espainia");
//		p.setAutonomia_erkidegoa("Euskadi");
//		p.setProbintzia("Bizkaia");
//		p.setHerria("Basauri");
//		p.setPostaKodea("48970");
//		p.setPosta_elektronikoa("aimar.peleaar@elorrieta-errekamari.com");
//		p.setPasahitza("badBunny100pre");
//		p.setTlf_zenabkia("634411850");
//		
//		assertEquals("87654321Z", p.getNAN());
//		assertEquals("Aimar", p.getIzena());
//		assertEquals("Pelea", p.getAbizena());
//		assertEquals(newDate, p.getJaioteguna());
//		assertEquals("Espainia", p.getHerrialdea());
//		assertEquals("Euskadi", p.getAutonomia_erkidegoa());
//		assertEquals("Bizkaia", p.getProbintzia());
//		assertEquals("Basauri", p.getHerria());
//		assertEquals("48970", p.getPostaKodea());
//		assertEquals("aimar.peleaar@elorrieta-errekamari.com", p.getPosta_elektronikoa());
//		assertEquals("badBunny100pre", p.getPasahitza());
//		assertEquals("634411850", p.getTlf_zenabkia());
//	}
//	
//	@Test
//	public void testEqualsTrue() {
//		Date date = new Date();
//		Pertsona p1 = new Pertsona("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789");
//		Pertsona p2 = new Pertsona("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789");
//		assertTrue(p1.equals(p2));
//	}
//
//	@Test
//	public void testEqualsFalse() {
//		Date date = new Date();
//		Pertsona p1 = new Pertsona("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789");
//		Pertsona p2 = new Pertsona("87654321Z", "Aimar", "Pelea", date, "Espainia", "Euskadi", "Bizkaia", "Basauri", "48970", "aimar.peleaar@elorrieta-errekamari.com", "badBunny100pre", "634411850");
//		
//		assertFalse(p1.equals(p2));
//	}
//
//	@Test
//	public void testHashCode() {
//		Date date = new Date();
//		Pertsona p1 = new Pertsona("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789");
//		Pertsona p2 = new Pertsona("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789");
//		
//		assertEquals(p1.hashCode(), p2.hashCode());
//	}
//
//	@Test
//	public void testToString() {
//		Date date = new Date();
//		Pertsona p = new Pertsona("12345678A", "Jon", "Aguirre", date, "Espainia", "Euskadi", "Gipuzkoa", "Donostia", "20001", "jaguirre@gmail.com", "1234", "123456789");
//		
//		String expected = "Pertsona [NAN=12345678A\nizena=Jon\nabizena=Aguirre\njaioteguna=" + date.toString()
//				+ "\nherrialdea=Espainia\nautonomia_erkidegoa=Euskadi\nprobintzia=Gipuzkoa\nherria=Donostia\npostaKodea=20001\nposta_elektronikoa=jaguirre@gmail.com\npasahitza=1234\ntlf_zenabkia=123456789]";
//		
//		assertEquals(expected, p.toString());
//	}
//}