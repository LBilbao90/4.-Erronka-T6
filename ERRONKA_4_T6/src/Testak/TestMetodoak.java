package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.junit.Test;

import Ikuspegia.ruletaApostua;
import Kontrolatzailea.datuBaseKarga;
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
	
	@Test
	public void testBtn3secDelayTest() {
		JPanel erakutsi = new JPanel();
		JPanel sarrera = new JPanel();
		JPanel login = new JPanel();
		JPanel erregistratu = new JPanel();
		JPanel jokoak = new JPanel();
		JPanel ruleta = new JPanel();
		ruletaApostua ruleta1 = new ruletaApostua();
		ActionEvent e = new ActionEvent(this, 0, "test");
		int segundu = 3; 
	
		long hasiera = System.currentTimeMillis();
		metodoak.btn3secDelay(erakutsi, segundu, sarrera, login, erregistratu, jokoak, ruleta, e);
		metodoak.btn3secDelay(ruleta1, segundu, sarrera, login, erregistratu, jokoak, ruleta1, e);
		metodoak.btn3secDelay(erakutsi, segundu, sarrera, login, erregistratu, jokoak, e);
		long amaiera = System.currentTimeMillis();
	}
		
	@Test 
	public void testHurrengoBtn() {
		JPanel erakutsi = new JPanel();
		JPanel sarrera = new JPanel();
		JPanel login = new JPanel();
		JPanel erregistratu = new JPanel();
		JPanel jokoak = new JPanel();
		JPanel ruleta = new JPanel();
		ruletaApostua ruleta1 = new ruletaApostua();
		ActionEvent e = new ActionEvent(this, 0, "test");
		int segundu = 3; 

	    metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu, jokoak, ruleta);
	    metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu, jokoak, ruleta1);
	    metodoak.hurrengoaBtn(ruleta1, sarrera, login, erregistratu, jokoak, ruleta1);
	    metodoak.hurrengoaBtn(ruleta1);
	    metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu, jokoak);
	}
	
	@Test
    public void testCreateTextFieldTestua() {
		String text = "Prueba";
		int x = 10;
		int y = 20;
		int width = 200;
		int height = 30;
		Font font = new Font("Arial", Font.PLAIN, 12);
		JPanel erregistratu = new JPanel();
		JTextField jTextField = metodoak.createTextFieldTestua(text, x, y, width, height, font, erregistratu);
		
		assertEquals(text, jTextField.getText());
		assertEquals(x, jTextField.getBounds().x);
		assertEquals(y, jTextField.getBounds().y);
		assertEquals(width, jTextField.getBounds().width);
		assertEquals(height, jTextField.getBounds().height);
		assertEquals(font, jTextField.getFont());
		assertFalse(jTextField.isEditable());
		assertNull(jTextField.getBorder());
		assertFalse(jTextField.isOpaque());
		assertTrue(erregistratu.getComponents().length > 0);
		assertTrue(erregistratu.isAncestorOf(jTextField));
		assertEquals(10, jTextField.getColumns());
	}
	
	@Test
	public void testCreateTextFieldBete() {
		int x = 10;
		int y = 20;
		int width = 200;
		int height = 30;
		Font font = new Font("Arial", Font.PLAIN, 12);
		JPanel erregistratu = new JPanel();
		JTextArea jTextArea = metodoak.createTextFieldBete(x, y, width, height, font, erregistratu);
		 
		assertEquals(x, jTextArea.getBounds().x);
		assertEquals(y, jTextArea.getBounds().y);
		assertEquals(width, jTextArea.getBounds().width);
		assertEquals(height, jTextArea.getBounds().height);
		assertEquals(font, jTextArea.getFont());
		assertTrue(erregistratu.getBorder() instanceof LineBorder);
		assertEquals(new Color(171, 173, 179), ((LineBorder) erregistratu.getBorder()).getLineColor());
		assertTrue(erregistratu.getComponents().length > 0);
		assertTrue(erregistratu.isAncestorOf(jTextArea));
		assertEquals(10, jTextArea.getColumns());
	}
	
	@Test
	public void testCreatePasswordFieldBete() {
		int x = 10;
		int y = 20;
		int width = 200;
		int height = 30;
		Font font = new Font("Arial", Font.PLAIN, 12);
		JPanel erregistratu = new JPanel();
		JPasswordField jPasswordField = metodoak.createPasswordFieldBete(x, y, width, height, font, erregistratu);
		
		assertEquals(x, jPasswordField.getBounds().x);
		assertEquals(y, jPasswordField.getBounds().y);
		assertEquals(width, jPasswordField.getBounds().width);
		assertEquals(height, jPasswordField.getBounds().height);
		assertEquals(font, jPasswordField.getFont());
		assertTrue(erregistratu.getComponents().length > 0);
		assertTrue(erregistratu.isAncestorOf(jPasswordField));
		assertEquals(10, jPasswordField.getColumns());
	}
	
	
	@Test
	public void testApostuaZBK() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] zbk = {0};

		rdbtnApostu10.setSelected(true);
		int apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 50, 0, 0, zbk);
		assertEquals(10, apostuOrain);
		assertEquals(10, zbk[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 50, 10, 0, zbk);
		assertEquals(30, apostuOrain);
		assertEquals(30, zbk[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		zbk[0] = 0;
		apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, zbk);
		assertEquals(50, apostuOrain);
		assertEquals(50, zbk[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		zbk[0] = 0;
		apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 150, 0, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(100, zbk[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		zbk[0] = 0;
		apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 600, 0, 0, zbk);
		assertEquals(500, apostuOrain);
		assertEquals(500, zbk[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		zbk[0] = 0;
		apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, zbk);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu1000.setSelected(false);
		apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, zbk);
		assertEquals(0, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu500.setSelected(true);
		apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 400, 100, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(1000, zbk[0]);
	}


	
	@Test
	public void testApostuaEskerEskuin() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] dozenakEskerrEskuin = new int[10];

		rdbtnApostu10.setSelected(true);
		int apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenakEskerrEskuin);
		assertEquals(10, apostuOrain);
		assertEquals(10, dozenakEskerrEskuin[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenakEskerrEskuin);
		assertEquals(20, apostuOrain);
		assertEquals(20, dozenakEskerrEskuin[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenakEskerrEskuin);
		assertEquals(50, apostuOrain);
		assertEquals(50, dozenakEskerrEskuin[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 200, 0, 0, dozenakEskerrEskuin);
		assertEquals(100, apostuOrain);
		assertEquals(100, dozenakEskerrEskuin[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, dozenakEskerrEskuin);
		assertEquals(500, apostuOrain);
		assertEquals(500, dozenakEskerrEskuin[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, dozenakEskerrEskuin);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, dozenakEskerrEskuin[0]);

		rdbtnApostu1000.setSelected(false);
		apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, dozenakEskerrEskuin);
		assertEquals(0, apostuOrain);
		assertEquals(1000, dozenakEskerrEskuin[0]);

		rdbtnApostu1000.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 500, 0, 0, dozenakEskerrEskuin);
		assertEquals(0, apostuOrain);
		assertEquals(0, dozenakEskerrEskuin[0]);

	}
		
	@Test
	public void testApostuaDozena() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] dozenak = new int[3];

		rdbtnApostu10.setSelected(true);
		int apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenak);
		assertEquals(10, apostuOrain);
		assertEquals(10, dozenak[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenak);
		assertEquals(20, apostuOrain);
		assertEquals(20, dozenak[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenak);
		assertEquals(50, apostuOrain);
		assertEquals(50, dozenak[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 200, 0, 0, dozenak);
		assertEquals(100, apostuOrain);
		assertEquals(100, dozenak[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, dozenak);
		assertEquals(500, apostuOrain);
		assertEquals(500, dozenak[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, dozenak);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, dozenak[0]);

		rdbtnApostu1000.setSelected(false);
		int apostuOrainAntes = apostuOrain;
		apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, apostuOrain, 0, dozenak);
		assertEquals(apostuOrainAntes, apostuOrain);

		rdbtnApostu1000.setSelected(true);
		apostuOrainAntes = apostuOrain;
		apostuOrain = metodoak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 500, apostuOrain, 0, dozenak);
		assertEquals(apostuOrainAntes, apostuOrain);

	}

	  @Test
	  public void testApostuErdia() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] taulaErdia = new int[1];
	
		rdbtnApostu10.setSelected(true);
		int apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, taulaErdia);
		assertEquals(10, apostuOrain);
		assertEquals(10, taulaErdia[0]);
	
		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, taulaErdia);
		assertEquals(20, apostuOrain);
		assertEquals(20, taulaErdia[0]);
	
		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, taulaErdia);
		assertEquals(50, apostuOrain);
		assertEquals(50, taulaErdia[0]);
	
		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(100, apostuOrain);
		assertEquals(100, taulaErdia[0]);
		
		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(500, apostuOrain);
		assertEquals(500, taulaErdia[0]);
		
		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, taulaErdia[0]);
		
		rdbtnApostu1000.setSelected(false);
		taulaErdia[0] = 0;
		apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(0, apostuOrain);
		assertEquals(0, taulaErdia[0]);
		
		rdbtnApostu1000.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 500, 0, 0, taulaErdia);
		assertEquals(0, apostuOrain);
		assertEquals(0, taulaErdia[0]);
	}
	  
	  @Test
	  public void testApostuBakoitiBikoiti() {
		  JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] bakoitiBikoiti = new int[2];
		
		rdbtnApostu10.setSelected(true);
		int apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(10, apostuOrain);
		assertEquals(10, bakoitiBikoiti[0]);
		
		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(20, apostuOrain);
		assertEquals(20, bakoitiBikoiti[0]);
		
		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(50, apostuOrain);
		assertEquals(50, bakoitiBikoiti[0]);
		
		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(100, apostuOrain);
		assertEquals(100, bakoitiBikoiti[0]);
		
		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(500, apostuOrain);
		assertEquals(500, bakoitiBikoiti[0]);
			
		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, bakoitiBikoiti[0]);
			
		rdbtnApostu1000.setSelected(false);
		apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(0, apostuOrain);
		
		rdbtnApostu10.setSelected(true);
		apostuOrain = metodoak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 5, 0, 0, bakoitiBikoiti);
		assertEquals(0, apostuOrain);
	}
  	
	  @Test
	  public void testApostuKolorea() {
		  JRadioButton rdbtnApostu10 = new JRadioButton();
		  JRadioButton rdbtnApostu20 = new JRadioButton();
		  JRadioButton rdbtnApostu50 = new JRadioButton();
		  JRadioButton rdbtnApostu100 = new JRadioButton();
		  JRadioButton rdbtnApostu500 = new JRadioButton();
		  JRadioButton rdbtnApostu1000 = new JRadioButton();
		  int[] kolorea = new int[1];
		
		  rdbtnApostu10.setSelected(true);
		  int apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
		  assertEquals(10, apostuOrain);
		  assertEquals(10, kolorea[0]);
		
		  rdbtnApostu10.setSelected(false);
		  rdbtnApostu20.setSelected(true);
		  apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
		  assertEquals(20, apostuOrain);
		  assertEquals(30, kolorea[0]);
		
		  rdbtnApostu20.setSelected(false);
		  rdbtnApostu50.setSelected(true);
		  apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
		  assertEquals(50, apostuOrain);
		  assertEquals(80, kolorea[0]);
		
		  rdbtnApostu50.setSelected(false);
	      rdbtnApostu100.setSelected(true);
	      apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
	      assertEquals(100, apostuOrain);
	      assertEquals(180, kolorea[0]);
	
	      rdbtnApostu100.setSelected(false);
	      rdbtnApostu500.setSelected(true);
	      apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
	      assertEquals(500, apostuOrain);
	      assertEquals(680, kolorea[0]);
	
	      rdbtnApostu500.setSelected(false);
	      rdbtnApostu1000.setSelected(true);
	      apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, kolorea);
	      assertEquals(1000, apostuOrain);
	      assertEquals(1680, kolorea[0]);
	
	      rdbtnApostu1000.setSelected(false);
	      apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 300, 0, kolorea);
	      assertEquals(300, apostuOrain);
	
	      rdbtnApostu1000.setSelected(true);
	      apostuOrain = metodoak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 900, 0, kolorea);
	      assertEquals(900, apostuOrain);
	
	  	}
	  	 	
  	@Test
  	public void testRuletakoZbkKalkulatu() {
  		int ZbkKalkulatu = metodoak.ruletakoZbkKalkulatu(Math.toRadians(-45));
		assertEquals(4, ZbkKalkulatu);
	}
  	
    @Test
    public void testZbkDa() {
    	assertTrue(metodoak.zbkDa("12"));
    	assertTrue(metodoak.zbkDa("-12"));
    	assertTrue(metodoak.zbkDa("0"));
    	assertFalse(metodoak.zbkDa("A"));
    	assertFalse(metodoak.zbkDa("a"));
    	assertFalse(metodoak.zbkDa("@"));
    	assertFalse(metodoak.zbkDa(" "));
    	assertFalse(metodoak.zbkDa(""));
    	assertFalse(metodoak.zbkDa("12.34"));
    	assertFalse(metodoak.zbkDa("12a"));
    	assertFalse(metodoak.zbkDa(null));
    }
    
    @Test
    public void testJaiotzeData() {
    	assertTrue(metodoak.jaiotzeDataOndo("2023-05-04"));
    	assertFalse(metodoak.jaiotzeDataOndo("2023/13/04"));
    	assertFalse(metodoak.jaiotzeDataOndo("23-05-04"));
    	assertFalse(metodoak.jaiotzeDataOndo("2023\05\04"));
    	assertFalse(metodoak.jaiotzeDataOndo("2023-0a-04"));
    	assertFalse(metodoak.jaiotzeDataOndo("2023-05- 04"));
    	assertFalse(metodoak.jaiotzeDataOndo("04-05-2023"));
    	assertFalse(metodoak.jaiotzeDataOndo("04-05-23"));
    	assertFalse(metodoak.jaiotzeDataOndo(""));
    }
    
    @Test
    public void testLoginBalidazioa() {
    	datuBaseKarga.karga();
    	
    	assertTrue(metodoak.loginBalidazioa("12345678A", "elorrieta00".toCharArray()));
    	assertFalse(metodoak.loginBalidazioa("12345678B", "123".toCharArray()));
    	assertFalse(metodoak.loginBalidazioa("12345678A", "123".toCharArray()));
    	assertFalse(metodoak.loginBalidazioa("12345678M", "elorrieta00".toCharArray()));
    }
    
    @Test
    public void testErregistroaInsert() {
    	datuBaseKarga.karga();
    	
    	// assertTrue-eko lehen bariablea aldatu behar da proba kasu bakoitza egitarakoan,
    	// metodoaren erabiltzen duelako eta NAN horrekin erabiltzaile berri bat egiten du,
    	// NAN bera uzten bada, hurrengo proban errorea emango du.
    	assertTrue(metodoak.erregistroaInsert("45983123Y", "Unax", "Zulaika", "elorrieta00", "2004-03-09", "Euskal Herria", "Gipuzkoa", "Elgoibar", "20870", "666999666"));
    	assertFalse(metodoak.erregistroaInsert("12345678A", "jgarcia", "Garcia", "elorrieta00", "1990-01-01", "Gipuzkoa", "Gipuzkoa", "Donostia", "12345", "666999666"));

    	
    }
    
}