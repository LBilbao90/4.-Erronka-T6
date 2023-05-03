package Kontrolatzailea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import Ikuspegia.ruletaApostua;
import Ikuspegia.ruletaJokoa;
import Ikuspegia.ruletaJokoa.OKButtonListener;


public class metodoak {
	
	public static void btn3secDelay (JPanel erakutsi, int segundu, JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak, JPanel ruleta, ActionEvent e) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(e);
            }
		
        metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu, jokoak, ruleta);
		
	}
	
	public static void btn3secDelay (ruletaApostua ruletaApostua, int segundu, JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak, ruletaApostua ruleta, ActionEvent e) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(e);
            }
		
        metodoak.hurrengoaBtn(ruletaApostua, sarrera, login, erregistratu, jokoak, ruleta);
		
	}
	
	public static void btn3secDelay (JPanel erakutsi, int segundu, JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak,  ActionEvent e) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(e);
            }
		
        metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu, jokoak);
		
	}
	
	public static void hurrengoaBtn (JPanel erakutsi,JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak, JPanel ruleta) {
		
		sarrera.setVisible(false);
		login.setVisible(false);
		erregistratu.setVisible(false);
		jokoak.setVisible(false);
		ruleta.setVisible(false);
		erakutsi.setVisible(true);
	
	}
//	public static void btn3secDelay (JPanel erakutsi, int segundu, JPanel sarrera, JPanel login, JPanel erregistratu, JPanel jokoak, ruletaApostua ruleta) {
//        try {
//            Thread.sleep(segundu * 1000);
//            } catch (InterruptedException ex) {
//                System.out.println(e);
//            }
//		
//        metodoak.hurrengoaBtn(erakutsi, sarrera, login, erregistratu, jokoak, ruleta);
//		
//	}
	
	public static void hurrengoaBtn (JPanel erakutsi,JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak, ruletaApostua ruleta) {
		
		sarrera.setVisible(false);
		login.setVisible(false);
		erregistratu.setVisible(false);
		jokoak.setVisible(false);
		ruleta.setVisible(false);
		erakutsi.setVisible(true);
	}
	
	
	public static void hurrengoaBtn (ruletaApostua erakutsi,JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak, ruletaApostua ruleta) {
		
		sarrera.setVisible(false);
		login.setVisible(false);
		erregistratu.setVisible(false);
		jokoak.setVisible(false);
		ruleta.setVisible(false);
		erakutsi.setVisible(true);
	
	}
	
	public static void hurrengoaBtn (ruletaApostua erakutsi) {
		
		erakutsi.setVisible(true);
	
	}
	
	public static void hurrengoaBtn (JPanel erakutsi,JPanel sarrera,JPanel login, JPanel erregistratu, JPanel jokoak) {
		
		sarrera.setVisible(false);
		login.setVisible(false);
		erregistratu.setVisible(false);
		jokoak.setVisible(false);
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
	
	
	// RULETA APOSTUA
	
	public static int apostuaZBK(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, int pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] zbk) {
	    if (rdbtnApostu10.isSelected() && pertsonaApostuMax >= (apostuOrain + 10)) {
	        zbk[zbkApostua] = zbk[zbkApostua] + 10;
	        apostuOrain = apostuOrain + 10;
	    } else if (rdbtnApostu20.isSelected() && pertsonaApostuMax >= (apostuOrain + 20)) {
	        zbk[zbkApostua] = zbk[zbkApostua] + 20;
	        apostuOrain = apostuOrain + 20;
	    } else if (rdbtnApostu50.isSelected() && pertsonaApostuMax >= (apostuOrain + 50)) {
	        zbk[zbkApostua] = zbk[zbkApostua] + 50;
	        apostuOrain = apostuOrain + 50;
	    } else if (rdbtnApostu100.isSelected() && pertsonaApostuMax >= (apostuOrain + 100)) {
	        zbk[zbkApostua] = zbk[zbkApostua] + 100;
	        apostuOrain = apostuOrain + 100;
	    } else if (rdbtnApostu500.isSelected() && pertsonaApostuMax >= (apostuOrain + 500)) {
	        zbk[zbkApostua] = zbk[zbkApostua] + 500;
	        apostuOrain = apostuOrain + 500;
	    } else if (rdbtnApostu1000.isSelected() && pertsonaApostuMax >= (apostuOrain + 1000)) {
	        zbk[zbkApostua] = zbk[zbkApostua] + 1000;
	        apostuOrain = apostuOrain + 1000;;
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Aukeratu apostu kantitate bat.");
	    } else {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu");
	    }
	    return apostuOrain;
	}
	
	public static int apostuaEskerEskuin(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, int pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] dozenakEskerrEskuin) {
	    if (rdbtnApostu10.isSelected() && pertsonaApostuMax >= (apostuOrain + 10)) {
	        dozenakEskerrEskuin[zbkApostua] = dozenakEskerrEskuin[zbkApostua] + 10;
	        apostuOrain = apostuOrain + 10;
	    } else if (rdbtnApostu20.isSelected() && pertsonaApostuMax >= (apostuOrain + 20)) {
	        dozenakEskerrEskuin[zbkApostua] = dozenakEskerrEskuin[zbkApostua] + 20;
	        apostuOrain = apostuOrain + 20;
	    } else if (rdbtnApostu50.isSelected() && pertsonaApostuMax >= (apostuOrain + 50)) {
	        dozenakEskerrEskuin[zbkApostua] = dozenakEskerrEskuin[zbkApostua] + 50;
	        apostuOrain = apostuOrain + 50;
	    } else if (rdbtnApostu100.isSelected() && pertsonaApostuMax >= (apostuOrain + 100)) {
	        dozenakEskerrEskuin[zbkApostua] = dozenakEskerrEskuin[zbkApostua] + 100;
	        apostuOrain = apostuOrain + 100;
	    } else if (rdbtnApostu500.isSelected() && pertsonaApostuMax >= (apostuOrain + 500)) {
	        dozenakEskerrEskuin[zbkApostua] = dozenakEskerrEskuin[zbkApostua] + 500;
	        apostuOrain = apostuOrain + 500;
	    } else if (rdbtnApostu1000.isSelected() && pertsonaApostuMax >= (apostuOrain + 1000)) {
	        dozenakEskerrEskuin[zbkApostua] = dozenakEskerrEskuin[zbkApostua] + 1000;
	        apostuOrain = apostuOrain + 1000;
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Aukeratu apostu kantitate bat.");
	    } else {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu");
	    }
	    return apostuOrain;
	}
	
	public static int apostuaDozena(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, int pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] dozenak) {
	    if (rdbtnApostu10.isSelected() && pertsonaApostuMax >= (apostuOrain + 10)) {
	        dozenak[zbkApostua] = dozenak[zbkApostua] + 10;
	        apostuOrain = apostuOrain + 10;
	    } else if (rdbtnApostu20.isSelected() && pertsonaApostuMax >= (apostuOrain + 20)) {
	        dozenak[zbkApostua] = dozenak[zbkApostua] + 20;
	        apostuOrain = apostuOrain + 20;
	    } else if (rdbtnApostu50.isSelected() && pertsonaApostuMax >= (apostuOrain + 50)) {
	        dozenak[zbkApostua] = dozenak[zbkApostua] + 50;
	        apostuOrain = apostuOrain + 50;
	    } else if (rdbtnApostu100.isSelected() && pertsonaApostuMax >= (apostuOrain + 100)) {
	        dozenak[zbkApostua] = dozenak[zbkApostua] + 100;
	        apostuOrain = apostuOrain + 100;
	    } else if (rdbtnApostu500.isSelected() && pertsonaApostuMax >= (apostuOrain + 500)) {
	        dozenak[zbkApostua] = dozenak[zbkApostua] + 500;
	        apostuOrain = apostuOrain + 500;
	    } else if (rdbtnApostu1000.isSelected() && pertsonaApostuMax >= (apostuOrain + 1000)) {
	        dozenak[zbkApostua] = dozenak[zbkApostua] + 1000;
	        apostuOrain = apostuOrain + 1000;
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Aukeratu apostu kantitate bat.");
	    } else {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu");
	    }
	    return apostuOrain;
	}
	
	public static int apostuErdia(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, int pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] taulaErdia) {
	    if (rdbtnApostu10.isSelected() && pertsonaApostuMax >= (apostuOrain + 10)) {
	        taulaErdia[zbkApostua] = taulaErdia[zbkApostua] + 10;
	        apostuOrain = apostuOrain + 10;
	    } else if (rdbtnApostu20.isSelected() && pertsonaApostuMax >= (apostuOrain + 20)) {
	        taulaErdia[zbkApostua] = taulaErdia[zbkApostua] + 20;
	        apostuOrain = apostuOrain + 20;
	    } else if (rdbtnApostu50.isSelected() && pertsonaApostuMax >= (apostuOrain + 50)) {
	        taulaErdia[zbkApostua] = taulaErdia[zbkApostua] + 50;
	        apostuOrain = apostuOrain + 50;
	    } else if (rdbtnApostu100.isSelected() && pertsonaApostuMax >= (apostuOrain + 100)) {
	        taulaErdia[zbkApostua] = taulaErdia[zbkApostua] + 100;
	        apostuOrain = apostuOrain + 100;
	    } else if (rdbtnApostu500.isSelected() && pertsonaApostuMax >= (apostuOrain + 500)) {
	        taulaErdia[zbkApostua] = taulaErdia[zbkApostua] + 500;
	        apostuOrain = apostuOrain + 500;
	    } else if (rdbtnApostu1000.isSelected() && pertsonaApostuMax >= (apostuOrain + 1000)) {
	        taulaErdia[zbkApostua] = taulaErdia[zbkApostua] + 1000;
	        apostuOrain = apostuOrain + 1000;
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Aukeratu apostu kantitate bat.");
	    } else {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu");
	    }
	    return apostuOrain;
	}
	
	public static int apostuBakoitiBikoiti(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, int pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] bakoitiBikoiti) {
	    if (rdbtnApostu10.isSelected() && pertsonaApostuMax >= (apostuOrain + 10)) {
	        bakoitiBikoiti[zbkApostua] = bakoitiBikoiti[zbkApostua] + 10;
	        apostuOrain = apostuOrain + 10;
	    } else if (rdbtnApostu20.isSelected() && pertsonaApostuMax >= (apostuOrain + 20)) {
	        bakoitiBikoiti[zbkApostua] = bakoitiBikoiti[zbkApostua] + 20;
	        apostuOrain = apostuOrain + 20;
	    } else if (rdbtnApostu50.isSelected() && pertsonaApostuMax >= (apostuOrain + 50)) {
	        bakoitiBikoiti[zbkApostua] = bakoitiBikoiti[zbkApostua] + 50;
	        apostuOrain = apostuOrain + 50;
	    } else if (rdbtnApostu100.isSelected() && pertsonaApostuMax >= (apostuOrain + 100)) {
	        bakoitiBikoiti[zbkApostua] = bakoitiBikoiti[zbkApostua] + 100;
	        apostuOrain = apostuOrain + 100;
	    } else if (rdbtnApostu500.isSelected() && pertsonaApostuMax >= (apostuOrain + 500)) {
	        bakoitiBikoiti[zbkApostua] = bakoitiBikoiti[zbkApostua] + 500;
	        apostuOrain = apostuOrain + 500;
	    } else if (rdbtnApostu1000.isSelected() && pertsonaApostuMax >= (apostuOrain + 1000)) {
	        bakoitiBikoiti[zbkApostua] = bakoitiBikoiti[zbkApostua] + 1000;
	        apostuOrain = apostuOrain + 1000;
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Aukeratu apostu kantitate bat.");
	    } else {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu");
	    }
	    return apostuOrain;
	}
	
	public static int apostuKolorea(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, int pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] kolorea) {
	    if (rdbtnApostu10.isSelected() && pertsonaApostuMax >= (apostuOrain + 10)) {
	        kolorea[zbkApostua] = kolorea[zbkApostua] + 10;
	        apostuOrain = apostuOrain + 10;
	    } else if (rdbtnApostu20.isSelected() && pertsonaApostuMax >= (apostuOrain + 20)) {
	        kolorea[zbkApostua] = kolorea[zbkApostua] + 20;
	        apostuOrain = apostuOrain + 20;
	    } else if (rdbtnApostu50.isSelected() && pertsonaApostuMax >= (apostuOrain + 50)) {
	        kolorea[zbkApostua] = kolorea[zbkApostua] + 50;
	        apostuOrain = apostuOrain + 50;
	    } else if (rdbtnApostu100.isSelected() && pertsonaApostuMax >= (apostuOrain + 100)) {
	        kolorea[zbkApostua] = kolorea[zbkApostua] + 100;
	        apostuOrain = apostuOrain + 100;
	    } else if (rdbtnApostu500.isSelected() && pertsonaApostuMax >= (apostuOrain + 500)) {
	        kolorea[zbkApostua] = kolorea[zbkApostua] + 500;
	        apostuOrain = apostuOrain + 500;
	    } else if (rdbtnApostu1000.isSelected() && pertsonaApostuMax >= (apostuOrain + 1000)) {
	        kolorea[zbkApostua] = kolorea[zbkApostua] + 1000;
	        apostuOrain = apostuOrain + 1000;
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Aukeratu apostu kantitate bat.");
	    } else {
	        JOptionPane.showMessageDialog(rdbtnApostu10, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu");
	    }
	    return apostuOrain;
	}
	
	// RULETA JOKOA
	

    
    // Ruletan irten den zenbakia kalkulatzen du, ruletaren angeluaren eta zenbakien ordenen arabera.
    public static int ruletakoZbkKalkulatu(double angelu) {
    	int[] ruletakoZbk = {26, 3, 35, 12, 28, 7, 29, 18, 22, 9, 31, 14, 20, 1, 33, 16, 24, 5, 10, 23, 8, 30, 11, 36, 13, 27, 6, 34, 17, 25, 2, 21, 4, 19, 15, 32, 0};

        int zenbakiGuztiak = ruletakoZbk.length;
        
        double unekoAngeluGraduak = Math.toDegrees(angelu);
        
        // Angelua ajustatzen du 0 eta 360 tartean.
        while (unekoAngeluGraduak < 0) {
        	unekoAngeluGraduak += 360;
        }
        while (unekoAngeluGraduak >= 360) {
        	unekoAngeluGraduak -= 360;
        }
        // Erruletako zenbakiak konpontzean angeluari dagokion indizea kalkulatzea
        int i = (int) Math.floor(unekoAngeluGraduak / (360.0 / zenbakiGuztiak));
        
        // Kalkulatutako indizeari dagokion zenbakia lortzea
        int zbk = ruletakoZbk[i];
        
        return zbk;
    }

    // 'if'aren barruan sartzen bada, Timer bat gelditzeko eta beste bat asiko da.
    public static void denboraAraberaTimer(int pasatakoDenbora, int denborHasiera, int denboraBukaera, int kont, Timer timerStop, Timer timerStart) {
    	if (pasatakoDenbora >= denborHasiera && pasatakoDenbora < denboraBukaera && kont == 1) {
            timerStop.stop();
            timerStart.start();
        }
    }
    
    
    /**
	 * String bat pasatuko diogu metodoari, pasahitza izango dela. Metodoa egingo duena izango da 
	 * konprobatu eta betetzen baditu baldintza batzuk gure pasahitza segurua izateko.
	 * @param pasahitza (String)
	 * @return True bueltatuko digu, pasahitza zuzena bada. Pasahitza ez bada zuzen false bueltatuko digu.
	 */
	public static boolean pasahitzaKonprobatu(String pasahitza) {
	    int minLuzera = 6;
	    int maxLuzera = 16;
	    boolean pasahitzaZuzena= false;
	    boolean mayuskulaDauka = false;
	    boolean minuskulaDauka = false;
	    boolean zenbakiakDauka = false;
	    
	    if (pasahitza.length() >= minLuzera && pasahitza.length() <= maxLuzera) {
	        for (char c : pasahitza.toCharArray()) {
	            if (Character.isLowerCase(c)) {
	            	minuskulaDauka = true;
	            } else if (Character.isUpperCase(c)) {
	            	mayuskulaDauka = true;
	            } else if (Character.isDigit(c)) {
	            	zenbakiakDauka = true;
	            }
	        }
	    }
	    if(mayuskulaDauka==true & minuskulaDauka==true & zenbakiakDauka==true) {
	    	pasahitzaZuzena=true;
	    }else {
	    	pasahitzaZuzena=false;
	    }
	    return pasahitzaZuzena;
	}
	
	 public static boolean nanBalidatu(String nan) {
	        // Comprobazten du ea NAN-ren luzeera 9 den
	        if (nan.length() != 9) {
	            return false;
	        }
	        
	        //Atera NAN zenbakia eta letra
	        String zenbakia = nan.substring(0, 8);
	        String letra = nan.substring(8);
	        
	        // Egiaztatu NAN zenbakia baliozkoa den
	        try {
	            Integer.parseInt(zenbakia);
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        
	        // NAN zenbakiari dagokion letra kalkulatzea
	        String letrak = "TRWAGMYFPDXBNJZSQVHLCKE";
	        int indizea = Integer.parseInt(zenbakia) % 23;
	        char kalkulatutakoLetra = letrak.charAt(indizea);
	        
	        // Egiaztatu NANaren letra baliozkoa den
	        if (letra.charAt(0) != kalkulatutakoLetra) {
	            return false;
	        }
	        
	        // Hona iritsiz gero, NANa baliozkoa da
	        return true;
	    }
}