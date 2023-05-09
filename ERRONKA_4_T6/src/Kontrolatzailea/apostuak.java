package Kontrolatzailea;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class apostuak {
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
}
