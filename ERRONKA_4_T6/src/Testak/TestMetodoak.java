package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

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
		JTextArea jTextArea = metodoak.createTextArea(x, y, width, height, font, erregistratu);
		 
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
    	String NAN = "45983123Y";
    	String izena = "Unax";
    	String abizena = "Zulaika";
    	String pasahitza = "elorrieta00";
    	String jaiotzeData = "2004-03-09";
    	String herria = "Elgoibar";
    	String probintzia = "Gipuzkoa";
    	String herrialdea = "Euskla Herria";
    	String postaKodea = "20870";
    	String telefonoZbk = "666999666";
    	
    	assertTrue(metodoak.erregistroaInsert(NAN, izena, abizena, pasahitza, jaiotzeData, herrialdea, probintzia, herria, postaKodea, telefonoZbk));
    	assertFalse(metodoak.erregistroaInsert("12345678Z", "ProbaKontua1", "ProbaKontua1", "Elorrieta00", "2000-01-01", "Euskal Herria", "Gipuzkoa", "Elgoibar", "20870", "666999666"));

    	Connection conn;
    	 try {
    		 String url = "jdbc:mysql://localhost:3306/kasinoa";
             conn = (Connection) DriverManager.getConnection (url, "root","");
             Statement stmt = (Statement) conn.createStatement();                     
             stmt.executeUpdate("DELETE FROM erabiltzaile_kontua WHERE NAN='" + NAN + "';");
             conn.close();
         }catch(SQLException ex) {
        	 System.out.println("SQLException: "+ ex.getMessage());
        	 System.out.println("SQLState: "+ ex.getSQLState());
        	 System.out.println("ErrorCode: "+ ex.getErrorCode());
         }	
    	 
    }
    
    @Test
    public void testErabiltzaileUpdate() {
        String NAN = "87654321X";
        String erabiltzaileIzena = "ProbaTest1";
        String pasahitza = "Elorrieta00";
        String herrialdea = "Euskadi";
        String probintzia = "Gipuzkoa";
        String herria = "Elgoibar";
        String postaKodea = "20870";
        String telefonoZbk = "333444333";

        // Testeatzeko erabiltzailea sortu
    	Connection conn;
        try {
        	String url = "jdbc:mysql://localhost:3306/kasinoa";
        	conn = (Connection) DriverManager.getConnection (url, "root","");
            Statement stmt = (Statement) conn.createStatement();  
            stmt.executeUpdate("INSERT INTO erabiltzaile_kontua (NAN, "
            		+ "diru_kopuru_historikoa, diru_kopuru_momentukoa, abizena, erabiltzaile_izena, pasahitza, herrialdea, probintzia, herria, posta_Kodea, tlf_zenbakia) VALUES ('" + NAN + "', '" + 30 +  "', '" + 30 + "', '" + "ProbaAbizen" + "', '" + erabiltzaileIzena + "', '" + pasahitza + "', '" + herrialdea + "', '" + probintzia + "', '" + herria + "', '" + postaKodea + "', '" + telefonoZbk + "')");
        } catch (SQLException e) {
       	 System.out.println("SQLException: "+ e.getMessage());
       	 System.out.println("SQLState: "+ e.getSQLState());
       	 System.out.println("ErrorCode: "+ e.getErrorCode());
        }

        // Izena aldatzen den konprobatu
        String erabiltzaileIzena2 = "ProbaTest2";
        assertTrue(metodoak.erabiltzaileUpdate(NAN, erabiltzaileIzena2, pasahitza, herrialdea, probintzia, herria, postaKodea, telefonoZbk));

        // Datu basetik probaKasua borratu
    	Connection conn2;
        try {
        	String url = "jdbc:mysql://localhost:3306/kasinoa";
        	conn2 = (Connection) DriverManager.getConnection (url, "root","");
            Statement stmt = (Statement) conn2.createStatement(); 
            stmt.executeUpdate("DELETE FROM erabiltzaile_kontua WHERE NAN = '" + NAN + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testTlfZuzena() {
        assertTrue(metodoak.tlfZenbakia("123456789"));
    }

    @Test
    public void testTlfLuzeeraOkerra() {
        assertFalse(metodoak.tlfZenbakia("12345678"));
    }

    @Test
    public void testTlfLetrekin() {
        assertFalse(metodoak.tlfZenbakia("12a456789"));
    }
    
    @Test
    public void testGehituApostuak() {
    	int[] apostua1 = {};
        int[] apostua2 = {5};
        int[] apostua3 = {2, 4, 6, 8, 10};
        
        int emaiza1 = metodoak.gehituApostuak(apostua1);
        int emaitza2 = metodoak.gehituApostuak(apostua2);
        int emaitza3 = metodoak.gehituApostuak(apostua3);
        
        assertEquals(0, emaiza1);
        assertEquals(5, emaitza2);
        assertEquals(30, emaitza3);
    }
    
    @Test
    public void testTxtIdatzi() {
    	String testTestua = "Test";
    	File testTxt = new File("src/LOG.txt");
    	
    	metodoak.txtIdatzi(testTestua);
    	
    	assertTrue(testTxt.exists());
    	
    	List<String> lerroak = new ArrayList<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(testTxt))) {
    		String line;
    		while ((line = br.readLine()) != null) {
    			lerroak.add(line);
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

//        // Azken lerroa testTestua alderatu.
//        assertEquals(testTestua, lerroak.get(lerroak.size() - 1));
//
//        // LOG.txt-ko azen lerroa ezabatau
//        lerroak.remove(lerroak.size() - 1);
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testTxt))) {
//            for (String line : lerroak) {
//                bw.write(line);
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
    @Test
    public void testBaliozkoEremuak() {
    	JPanel erregistratu = new JPanel();
    	String NAN = "12345678Z";
    	String Izena = "Proba";
    	String Abizena = "Kontua";
    	String Pasahitza = "Elorrieta00";
    	String JaiotzeDataString = "2000-01-01";
    	String Herrialdea = "Euskadi";
    	String Probintzia = "Gipuzkoa";
    	String Herria = "Elgoibar";
    	String PostaKodea = "20870";
    	String TelefonoZbk = "666999666";
    	
    	// Dena ondo
    	assertTrue(metodoak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk, erregistratu));
    	// NAN hutsik
    	assertFalse(metodoak.baliozkoEremuak("", Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk, erregistratu));
    	// Izena hutsik
    	assertFalse(metodoak.baliozkoEremuak(NAN, "", Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk, erregistratu));
    	// Izena 4 karaktera baino gutxiago
    	assertFalse(metodoak.baliozkoEremuak(NAN, "Pr", Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk, erregistratu));
    	// Pasahitzak ez du kondizio guztiak betetzen
    	assertFalse(metodoak.baliozkoEremuak(NAN, Izena, Abizena, "Elorrieta", JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk, erregistratu));
    	// Telefono gaizki
    	assertFalse(metodoak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, "12345678", erregistratu));
    	// Posta kode luzeera gutxi
    	assertFalse(metodoak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, "1234", TelefonoZbk, erregistratu));
    	// Posta kode gaizki, letra bat duelako.
    	assertFalse(metodoak.baliozkoEremuak(NAN, Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, "12A45", TelefonoZbk, erregistratu));
    	// NAN gaizki
    	assertFalse(metodoak.baliozkoEremuak("12345678A", Izena, Abizena, Pasahitza, JaiotzeDataString, Herrialdea, Probintzia, Herria, PostaKodea, TelefonoZbk, erregistratu));
    }
    
    @Test
    public void testKasinoErabiltzaileInsert() {
    	datuBaseKarga.karga();
    	int id_kasino = 1;
    	String NAN = "45983123Y";
    	
    	assertTrue(metodoak.kasinoErabiltzaileInsert(NAN, id_kasino));
    	assertFalse(metodoak.kasinoErabiltzaileInsert("12345678Z",1));
    	Connection conn;
    	 try {
    		 String url = "jdbc:mysql://localhost:3306/kasinoa";
             conn = (Connection) DriverManager.getConnection (url, "root","");
             Statement stmt = (Statement) conn.createStatement();                     
             stmt.executeUpdate("DELETE FROM kasinoErabiltzaile WHERE NAN='" + NAN + "';");
             conn.close();
         }catch(SQLException ex) {
        	 System.out.println("SQLException: "+ ex.getMessage());
        	 System.out.println("SQLState: "+ ex.getSQLState());
        	 System.out.println("ErrorCode: "+ ex.getErrorCode());
         }	
    	 
    }
    
    
    @Test
    public void testApostuaInsert() {
    	datuBaseKarga.karga();
    	String NAN="12345678Z";
    	int id_joko= 1;
    	int apostuKantitate= 100;
    	String apostuEmaitza= "Irabazi";
    	
    	assertTrue(metodoak.apostuaInsert(NAN, id_joko, apostuKantitate, apostuEmaitza));
    	assertFalse(metodoak.apostuaInsert("73264894A",2, 500, "Berdin"));
    	
    	Connection conn;
    	 try {
    		 String url = "jdbc:mysql://localhost:3306/kasinoa";
             conn = (Connection) DriverManager.getConnection (url, "root","");
             Statement stmt = (Statement) conn.createStatement();
             ResultSet rs;
             rs= stmt.executeQuery("SELECT id_apostu from apostua WHERE NAN='" + NAN + "'order by id_apostu desc limit 1;");
             Statement stmt2 = (Statement) conn.createStatement();
             rs.next();
             stmt2.executeUpdate("DELETE FROM apostua WHERE id_apostu='"+  rs.getInt("id_apostu") + "';");
             conn.close();
         }catch(SQLException ex) {
        	 System.out.println("SQLException: "+ ex.getMessage());
        	 System.out.println("SQLState: "+ ex.getSQLState());
        	 System.out.println("ErrorCode: "+ ex.getErrorCode());
         }	
    	 
   }
    
    
    
    
}