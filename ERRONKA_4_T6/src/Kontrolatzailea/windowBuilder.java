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
	 * @param segundu | Itxarongo behar den segundo kopurua. (int)
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
	 * Panel zehatz bat erakutsi eta eskutatuko dute pasatako segundu kopurua itxaron ondore.
	 * @param ruletaApostuaErakutsi | ruleta apostu panela erakutsiko da. (JPanel)
	 * @param segundu | Itxarongo behar den segundo kopurua. (int)
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
	
	/**
	 * Panel zehatz bat erakutsi dute pasatako segundu kopurua itxaron ondore.
	 * @param erakutsi | Erakutsiko den JPanel-a. (Jpanel)
	 * @param segundu | Itxarongo behar den segundo kopurua. (int)
	 */
	public static void btn3secDelay (JPanel erakutsi, int segundu) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
	
        windowBuilder.hurrengoaBtn(erakutsi);
		
	}
	
	/**
	 * JPanel bat erakutsiko du eta beste bat eskutatu
	 * @param erakutsi | Erakutsiko den JPanel-a. (JPanel)
	 * @param eskutatu | Eskutatuko den JPanel-a. (Jpanel)
	 */
	public static void hurrengoaBtn (JPanel erakutsi,JPanel eskutatu) {
		
		eskutatu.setVisible(false);
		erakutsi.setVisible(true);
	
	}
	
	/**
	 * JPanel bat erakutsiko du.
	 * @param erakutsi | Erakutsiko den JPanel-a. (JPanel)
	 */
	public static void hurrengoaBtn (JPanel erakutsi) {
		
		erakutsi.setVisible(true);
	
	}	
	
	/**
	 * ruletaApostu-a erakutsiko du eta beste panel bat eskutatu
	 * @param erakutsi | ruletaApostua erakutsiko da. (ruletaApostua)
	 * @param ruleta | Eskutatuko den JPanel-a. (JPanel)
	 */
	public static void hurrengoaBtn (ruletaApostua erakutsi, JPanel ruleta) {
		
		ruleta.setVisible(false);
		erakutsi.setVisible(true);
	
	}
	
	/**
	 * JTextField bat sortuko du
	 * @param text | Edukiko duen testua. (String)
	 * @param x | 'x' posizioa. (int)
	 * @param y | 'y' posizioa. (int)
	 * @param width | zabalera. (int)
	 * @param height | altuera. (int)
	 * @param font | letra mota. (Font)
	 * @param erregistratu | Implementatuko behar den JPanel-a. (JPanel)
	 * @return JTextField bat bueltatuko du pasatutako tesuarekin, letra mota, tamaina, eta bestelako ezaugarriekin. 
	 */
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
	
	/**
	 * JTextArea bat sortuko du ezaugarri desberinekin.
	 * @param x | 'x' posizioa. (int)
	 * @param y | 'y' posizioa. (int)
	 * @param width | zabalera. (int)
	 * @param height | altuera. (int)
	 * @param font | letra mota. (Font)
	 * @param erregistratu | Implementatuko behar den JPanel-a. (JPanel)
	 * @return JTextArea bat bueltatuko du pasatutako letra mota, tamaina, eta bestelako ezaugarriekin. 
	 */
	public static JTextArea createTextArea(int x, int y, int width, int height, Font font,JPanel erregistratu) {
		JTextArea JTextArea = new JTextArea();
		JTextArea.setBounds(x, y, width, height);
		JTextArea.setFont(font);
	    erregistratu.setBorder(new LineBorder(new Color(171, 173, 179)));
	    erregistratu.add(JTextArea);
	    JTextArea.setColumns(10);
	    return JTextArea;
	}
	
	/**
	 * JPasswordField bat sortuko du ezaugarri desberinekin.
	 * @param x | 'x' posizioa. (int)
	 * @param y | 'y' posizioa. (int)
	 * @param width | zabalera. (int)
	 * @param height | altuera. (int)
	 * @param font | letra mota. (Font)
	 * @param erregistratu | Implementatuko behar den JPanel-a. (JPanel)
	 * @return JPasswordField bat bueltatuko du pasatutako letra mota, tamaina, eta bestelako ezaugarriekin. 
	 */
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