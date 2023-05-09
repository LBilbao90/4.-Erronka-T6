package Kontrolatzailea;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class apostuak {
	// RULETA APOSTUA
	
	/**
	 * Apostu kantitate bat ezartzen zaio zenbaki zehatz bateri metodo hau erabiliz.
	 * @param rdbtnApostu10 | Botoi taldean 10-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu20 | Botoi taldean 20-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu50 | Botoi taldean 50-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu100 | Botoi taldean 100-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu500 | Botoi taldean 500-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu1000 | Botoi taldean 1000-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param pertsonaApostuMax | Erabiltzaileak egin ahal duen apostu maximoa. (double)
	 * @param apostuOrain | Egindako apostu kantitatea bertan gordetzen da. (int)
	 * @param zbkApostua | Ze zenbakitan egin den apostua zehazten du. (int)
	 * @param zbk | Zenbaki bakoitzaren apostu kantitatea gordetzen duen Array-a. (int[])
	 * @return momentuan zenbateko apostu kantitatea dagoen bueltatzen du.
	 * @author 6.Taldea
	 */
	public static int apostuaZBK(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, double pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] zbk) {
		/* 
		 * if else zekuentzia radio Botoiak aukeratuta dauden begiratzen dute eta horrela baldi bada apostua egin ahal den, momentuko apostua eta pertsonaren apostu maximoaren arabera ikusten du,
		 * Apostua egin ahal bada, 'zbk' Array-eko zenbakiaren gelaxkan gordeko da apostu kantitatea ('zbkApostua'), eta azkenik 'apostuaOrain' eguneratuko da.
		 */
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
	} else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) { // Ez badago botoirik aukeratuta
	    JOptionPane.showMessageDialog(null, "Aukeratu apostu kantitate bat.");
	} else {
	    JOptionPane.showMessageDialog(null, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + (int) pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu"); // Ezin izan bada apostua bete (apostu kantitateak pertsonak ahal duen apostu maximoa pasatzen du)
	    }
	    return apostuOrain;
	}
		
	/**
	 * Apostu kantitate bat ezartzen zaio Eskerretik Eskuinera doazen dozeneri metodo hau erabiliz.
	 * @param rdbtnApostu10 | Botoi taldean 10-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu20 | Botoi taldean 20-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu50 | Botoi taldean 50-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu100 | Botoi taldean 100-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu500 | Botoi taldean 500-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu1000 | Botoi taldean 1000-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param pertsonaApostuMax | Erabiltzaileak egin ahal duen apostu maximoa. (double)
	 * @param apostuOrain | Egindako apostu kantitatea bertan gordetzen da. (int)
	 * @param zbkApostua | Ze dozenatan egin den apostua zehazten du. (int)
	 * @param dozenakEskerrEskuin | Eskerretik eskuinera doazen dozena bakoitzaren apostu kantitatea gordetzen duen Array-a. (int[])
	 * @return momentuan zenbateko apostu kantitatea dagoen bueltatzen du.
	 * @author 6.Taldea
	 */
	public static int apostuaEskerEskuin(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, double pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] dozenakEskerrEskuin) {
		/* 
		 * if else zekuentzia radio Botoiak aukeratuta dauden begiratzen dute eta horrela baldi bada apostua egin ahal den, momentuko apostua eta pertsonaren apostu maximoaren arabera ikusten du,
		 * Apostua egin ahal bada, 'dozenakEskerrEskuin' Array-eko dozenaren gelaxkan gordeko da apostu kantitatea ('zbkApostua'), eta azkenik 'apostuaOrain' eguneratuko da.
		 */
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
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) { // Ez badago botoirik aukeratuta
	        JOptionPane.showMessageDialog(null, "Aukeratu apostu kantitate bat.");
	} else {
	    JOptionPane.showMessageDialog(null, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + (int) pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu"); // Ezin izan bada apostua bete (apostu kantitateak pertsonak ahal duen apostu maximoa pasatzen du)
	    }
	    return apostuOrain;
	}

	/**
	 * Apostu kantitate bat ezartzen zaio Dozeneri metodo hau erabiliz.
	 * @param rdbtnApostu10 | Botoi taldean 10-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu20 | Botoi taldean 20-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu50 | Botoi taldean 50-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu100 | Botoi taldean 100-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu500 | Botoi taldean 500-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu1000 | Botoi taldean 1000-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param pertsonaApostuMax | Erabiltzaileak egin ahal duen apostu maximoa. (double)
	 * @param apostuOrain | Egindako apostu kantitatea bertan gordetzen da. (int)
	 * @param zbkApostua | Ze dozenatan egin den apostua zehazten du. (int)
	 * @param dozenak | Dozena bakoitzaren apostu kantitatea gordetzen duen Array-a. (int[])
	 * @return momentuan zenbateko apostu kantitatea dagoen bueltatzen du.
	 * @author 6.Taldea
	 */
	public static int apostuaDozena(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, double pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] dozenak) {
		/* 
		 * if else zekuentzia radio Botoiak aukeratuta dauden begiratzen dute eta horrela baldi bada apostua egin ahal den, momentuko apostua eta pertsonaren apostu maximoaren arabera ikusten du,
		 * Apostua egin ahal bada, 'dozenak' Array-eko dozenaren gelaxkan gordeko da apostu kantitatea ('zbkApostua'), eta azkenik 'apostuaOrain' eguneratuko da.
		 */
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
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) { // Ez badago botoirik aukeratuta
	        JOptionPane.showMessageDialog(null, "Aukeratu apostu kantitate bat.");
	} else {
	    JOptionPane.showMessageDialog(null, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + (int) pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu"); // Ezin izan bada apostua bete (apostu kantitateak pertsonak ahal duen apostu maximoa pasatzen du)
	    }
	    return apostuOrain;
	}
	
	/**
	 * Apostu kantitate bat ezartzen zaio taularen erdiari metodo hau erabiliz.
	 * @param rdbtnApostu10 | Botoi taldean 10-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu20 | Botoi taldean 20-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu50 | Botoi taldean 50-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu100 | Botoi taldean 100-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu500 | Botoi taldean 500-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu1000 | Botoi taldean 1000-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param pertsonaApostuMax | Erabiltzaileak egin ahal duen apostu maximoa. (double)
	 * @param apostuOrain | Egindako apostu kantitatea bertan gordetzen da. (int)
	 * @param zbkApostua | Taularen ze aldean egin den apostua zehazten du. (int)
	 * @param taulaErdia | Taularen alde bakoitzaren apostu kantitatea gordetzen duen Array-a. (int[])
	 * @return momentuan zenbateko apostu kantitatea dagoen bueltatzen du.
	 * @author 6.Taldea
	 */
	public static int apostuErdia(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, double pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] taulaErdia) {
		/* 
		 * if else zekuentzia radio Botoiak aukeratuta dauden begiratzen dute eta horrela baldi bada apostua egin ahal den, momentuko apostua eta pertsonaren apostu maximoaren arabera ikusten du,
		 * Apostua egin ahal bada, 'taulaErdia' Array-eko gelaxkan gordeko da apostu kantitatea ('zbkApostua'), eta azkenik 'apostuaOrain' eguneratuko da.
		 */
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
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) { // Ez badago botoirik aukeratuta
	        JOptionPane.showMessageDialog(null, "Aukeratu apostu kantitate bat.");
	} else {
	    JOptionPane.showMessageDialog(null, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + (int) pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu"); // Ezin izan bada apostua bete (apostu kantitateak pertsonak ahal duen apostu maximoa pasatzen du)
	    }
	    return apostuOrain;
	}
	
	/**
	 * Apostu kantitate bat ezartzen zaio zenbaki bakoiti edo bikoitieri metodo hau erabiliz.
	 * @param rdbtnApostu10 | Botoi taldean 10-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu20 | Botoi taldean 20-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu50 | Botoi taldean 50-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu100 | Botoi taldean 100-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu500 | Botoi taldean 500-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu1000 | Botoi taldean 1000-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param pertsonaApostuMax | Erabiltzaileak egin ahal duen apostu maximoa. (double)
	 * @param apostuOrain | Egindako apostu kantitatea bertan gordetzen da. (int)
	 * @param zbkApostua | Bakoiti edo bikoiti zenbakietan egin den apostua zehazten du. (int)
	 * @param bakoitiBikoiti | Bakoiti eta bikoiti zenbakietan apostu kantitatea gordetzen duen Array-a. (int[])
	 * @return momentuan zenbateko apostu kantitatea dagoen bueltatzen du.
	 * @author 6.Taldea
	 */
	public static int apostuBakoitiBikoiti(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, double pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] bakoitiBikoiti) {
		/* 
		 * if else zekuentzia radio Botoiak aukeratuta dauden begiratzen dute eta horrela baldi bada apostua egin ahal den, momentuko apostua eta pertsonaren apostu maximoaren arabera ikusten du,
		 * Apostua egin ahal bada, 'bakoitiBikoiti' Array-eko gelaxkan gordeko da apostu kantitatea ('zbkApostua'), eta azkenik 'apostuaOrain' eguneratuko da.
		 */
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
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) { // Ez badago botoirik aukeratuta
	        JOptionPane.showMessageDialog(null, "Aukeratu apostu kantitate bat.");
	} else {
	    JOptionPane.showMessageDialog(null, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + (int) pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu"); // Ezin izan bada apostua bete (apostu kantitateak pertsonak ahal duen apostu maximoa pasatzen du)
	    }
	    return apostuOrain;
	}

	/**
	 * Apostu kantitate bat ezartzen zaio koloreeri (gorri edo beltz) metodo hau erabiliz.
	 * @param rdbtnApostu10 | Botoi taldean 10-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu20 | Botoi taldean 20-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu50 | Botoi taldean 50-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu100 | Botoi taldean 100-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu500 | Botoi taldean 500-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu1000 | Botoi taldean 1000-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param pertsonaApostuMax | Erabiltzaileak egin ahal duen apostu maximoa. (double)
	 * @param apostuOrain | Egindako apostu kantitatea bertan gordetzen da. (int)
	 * @param zbkApostua | Gorri edo beltzetan egin den apostua zehazten du. (int)
	 * @param kolorea | Bakoiti eta bikoiti zenbakietan apostu kantitatea gordetzen duen Array-a. (int[])
	 * @return momentuan zenbateko apostu kantitatea dagoen bueltatzen du.
	 * @author 6.Taldea
	 */
	public static int apostuKolorea(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, double pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] kolorea) {
		/* 
		 * if else zekuentzia radio Botoiak aukeratuta dauden begiratzen dute eta horrela baldi bada apostua egin ahal den, momentuko apostua eta pertsonaren apostu maximoaren arabera ikusten du,
		 * Apostua egin ahal bada, 'kolorea' Array-eko gelaxkan gordeko da apostu kantitatea ('zbkApostua'), eta azkenik 'apostuaOrain' eguneratuko da.
		 */
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
	    } else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected()) { // Ez badago botoirik aukeratuta
	        JOptionPane.showMessageDialog(null, "Aukeratu apostu kantitate bat.");
	} else {
	    JOptionPane.showMessageDialog(null, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + (int) pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu"); // Ezin izan bada apostua bete (apostu kantitateak pertsonak ahal duen apostu maximoa pasatzen du)
		}
	    return apostuOrain;
	}
}