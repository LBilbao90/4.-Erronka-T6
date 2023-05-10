package Kontrolatzailea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Ikuspegia.ruletaApostua;

public class windowBuilder {
	
	/**
	 * Panela zehatz batzuk erakutsi eta eskutatuko dute pasatako segundu kopurua itxaron ondore.
	 * @param erakutsi | Erakutsiko den JPanel-a. (Jpanel)
	 * @param segundu | Itxarongo den segundo kopurua. (int)
	 * @param eskutatu | Eskutatuko den JPanel-a. (JPanel)
	 */
	public static void btn3secDelay (JPanel erakutsi, int segundu, JPanel eskutatu) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
	
        windowBuilder.hurrengoaBtn(erakutsi, eskutatu);
		
	}

	/**
	 * Panela zehatz batzuk erakutsi eta eskutatuko dute pasatako segundu kopurua itxaron ondore.
	 * @param ruletaApostuaErakutsi | ruleta apostu panela erakutsiko da. (JPanel)
	 * @param segundu | Itxarongo den segundo kopurua. (int)
	 * @param eskutatu | Eskutatuko den JPanel-a. (JPanel)
	 */
	public static void btn3secDelay (ruletaApostua ruletaApostuaErakutsi, int segundu, JPanel eskutatu) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
		
        windowBuilder.hurrengoaBtn(ruletaApostuaErakutsi, eskutatu);
		
	}
	
	public static void btn3secDelay (JPanel erakutsi, int segundu) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
	
        windowBuilder.hurrengoaBtn(erakutsi);
		
	}
	
	public static void hurrengoaBtn (JPanel erakutsi,JPanel eskutatu) {
		
		eskutatu.setVisible(false);
		erakutsi.setVisible(true);
	
	}
	
	public static void hurrengoaBtn (JPanel erakutsi) {
		
		erakutsi.setVisible(true);
	
	}	
	
	public static void hurrengoaBtn (ruletaApostua erakutsi, JPanel ruleta) {
		
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
	    textField.setOpaque(false);
	    erregistratu.add(textField);
	    textField.setColumns(10);
	    return textField;
	}
	
	public static JTextArea createTextArea(int x, int y, int width, int height, Font font,JPanel erregistratu) {
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
