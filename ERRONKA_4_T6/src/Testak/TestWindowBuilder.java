package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.junit.Test;

import Ikuspegia.ruletaApostua;
import Kontrolatzailea.windowBuilder;

public class TestWindowBuilder {
	
	@Test
	public void testBtn3secDelayTest() {
		
		JPanel erakutsi = new JPanel();
		JPanel jokoak = new JPanel();
		JPanel ruleta = new JPanel();
		ruletaApostua ruleta1 = new ruletaApostua();
		int segundu = 3; 
	
		windowBuilder.btn3secDelay(erakutsi, segundu, jokoak);
		windowBuilder.btn3secDelay(ruleta1, segundu, jokoak);
		windowBuilder.btn3secDelay(ruleta, segundu);
	}
		
	@Test 
	public void testHurrengoBtn() {
		JPanel erakutsi = new JPanel();
		JPanel ruleta = new JPanel();
		ruletaApostua ruleta1 = new ruletaApostua();

		windowBuilder.hurrengoaBtn(erakutsi, ruleta);
		windowBuilder.hurrengoaBtn(erakutsi);
		windowBuilder.hurrengoaBtn(ruleta1, ruleta);
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
		JTextField jTextField = windowBuilder.createTextFieldTestua(text, x, y, width, height, font, erregistratu);
		
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
		JTextArea jTextArea = windowBuilder.createTextArea(x, y, width, height, font, erregistratu);
		 
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
		JPasswordField jPasswordField = windowBuilder.createPasswordFieldBete(x, y, width, height, font, erregistratu);
		
		assertEquals(x, jPasswordField.getBounds().x);
		assertEquals(y, jPasswordField.getBounds().y);
		assertEquals(width, jPasswordField.getBounds().width);
		assertEquals(height, jPasswordField.getBounds().height);
		assertEquals(font, jPasswordField.getFont());
		assertTrue(erregistratu.getComponents().length > 0);
		assertTrue(erregistratu.isAncestorOf(jPasswordField));
		assertEquals(10, jPasswordField.getColumns());
	}
	
}