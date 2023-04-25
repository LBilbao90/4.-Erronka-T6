package Kontrolatzailea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class metodoak {
	public static void btn3secDelay (JPanel erakutsi, int segundu, JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak, JPanel ruleta, ActionEvent e) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(e);
            }
		
        metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu, jokoak, ruleta);
		
	}
	
	public static void hurrengoaBtn (JPanel erakutsi,JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak, JPanel ruleta) {
		
		sarrera.setVisible(false);
		login.setVisible(false);
		erregistratu.setVisible(false);
		jokoak.setVisible(false);
		ruleta.setVisible(false);
		erakutsi.setVisible(true);
	
	}
	
	public static JTextField createTextFieldTestua (String text, int x, int y, int width, int height, Font font,JPanel erregistratu) {
	    JTextField textField = new JTextField();
	    textField.setBounds(x, y, width, height);
	    textField.setFont(font);
	    textField.setText(text);
	    textField.setEditable(false);
	    textField.setBorder(null);
	    erregistratu.add(textField);
	    textField.setColumns(10);
	    return textField;
	}
	
	public static JTextArea createTextFieldBete (int x, int y, int width, int height, Font font,JPanel erregistratu) {
		JTextArea JTextArea = new JTextArea();
		JTextArea.setBounds(x, y, width, height);
		JTextArea.setFont(font);
	    erregistratu.setBorder(new LineBorder(new Color(171, 173, 179)));
	    erregistratu.add(JTextArea);
	    JTextArea.setColumns(10);
	    return JTextArea;
	}
	
	public static JPasswordField createPasswordFieldBete (int x, int y, int width, int height, Font font,JPanel erregistratu) {
		JPasswordField JPasswordField = new JPasswordField();
		JPasswordField.setBounds(x, y, width, height);
		JPasswordField.setFont(font);
	    erregistratu.setBorder(new LineBorder(new Color(171, 173, 179)));
	    erregistratu.add(JPasswordField);
	    JPasswordField.setColumns(10);
	    return JPasswordField;
	}
	


}
