package Kontrolatzailea;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class metodoak {
	public static void btn3secDelay (JPanel erakutsi, int segundu, JPanel sarrera,JPanel login, JPanel erregistratu, ActionEvent e) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(e);
            }
		
        metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu);
		
	}
	
	public static void hurrengoaBtn (JPanel erakutsi,JPanel sarrera,JPanel login, JPanel erregistratu) {
		
		sarrera.setVisible(false);
		login.setVisible(false);
		erregistratu.setVisible(false);
		erakutsi.setVisible(true);
	
	}
	
	public static JTextField createTextField (String text, int x, int y, int width, int height, Font font,JPanel erregistratu) {
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
	


}
