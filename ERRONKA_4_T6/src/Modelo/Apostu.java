package Modelo;

import java.util.Objects;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Apostu {
	
	private int id_apustua;
	private int id_joko;
	private String NAN;
	private int apostu_kantitatea;
	private int apostu_emaitza;
	
	//KONSTRUKTOREA
	public Apostu(int id_apustua, int id_joko, String nAN, int apostu_kantitatea, int apostu_emaitza) {
		this.id_apustua = id_apustua;
		this.id_joko = id_joko;
		NAN = nAN;
		this.apostu_kantitatea = apostu_kantitatea;
		this.apostu_emaitza = apostu_emaitza;
	}
	
	//GETTERS & SETTERS
	public int getId_apustua() {
		return id_apustua;
	}
	
	public void setId_apustua(int id_apustua) {
		this.id_apustua = id_apustua;
	}
	public int getId_joko() {
		return id_joko;
	}
	public void setId_joko(int id_joko) {
		this.id_joko = id_joko;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}

	public int getApostu_kantitatea() {
		return apostu_kantitatea;
	}
	public void setApostu_kantitatea(int apostu_kantitatea) {
		this.apostu_kantitatea = apostu_kantitatea;
	}
	public int getApostu_emaitza() {
		return apostu_emaitza;
	}
	public void setApostu_emaitza(int apostu_emaitza) {
		this.apostu_emaitza = apostu_emaitza;
	}
	
	
	//METODOAK
	
	/**
	 * Apostu kantitate bat ezartzen zaio zenbaki (edo zenbaki talde) zehatz bateri metodo hau erabiliz.
	 * @param rdbtnApostu10 | Botoi taldean 10-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu20 | Botoi taldean 20-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu50 | Botoi taldean 50-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu100 | Botoi taldean 100-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu500 | Botoi taldean 500-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param rdbtnApostu1000 | Botoi taldean 1000-eko apostua kantitatea esartzen duen radioButton. (JRadioButton)
	 * @param pertsonaApostuMax | Erabiltzaileak egin ahal duen apostu maximoa. (double)
	 * @param apostuOrain | Egindako apostu kantitatea bertan gordetzen da. (int)
	 * @param zbkApostua | Ze zenbakitan (edo zenbaki talde) egin den apostua zehazten du. (int)
	 * @param zbk | Zenbaki (edo zenbaki talde) bakoitzaren apostu kantitatea gordetzen duen Array-a. (int[])
	 * @return momentuan zenbateko apostu kantitatea dagoen bueltatzen du.
	 * @author 6.Taldea
	 */
	public static int apustua_egin(JRadioButton rdbtnApostu10, JRadioButton rdbtnApostu20, JRadioButton rdbtnApostu50, JRadioButton rdbtnApostu100, JRadioButton rdbtnApostu500, JRadioButton rdbtnApostu1000, JRadioButton rdbtnAllIn,double pertsonaApostuMax, int apostuOrain, int zbkApostua, int[] zbk) {
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
	    apostuOrain = apostuOrain + 1000;
	}  else if (rdbtnAllIn.isSelected() && pertsonaApostuMax >= (apostuOrain + pertsonaApostuMax)) {
	    zbk[zbkApostua] = zbk[zbkApostua] + (int) pertsonaApostuMax;
	    apostuOrain = apostuOrain + (int) pertsonaApostuMax;
	} else if (!rdbtnApostu10.isSelected() && !rdbtnApostu20.isSelected() && !rdbtnApostu50.isSelected() && !rdbtnApostu100.isSelected() && !rdbtnApostu500.isSelected() && !rdbtnApostu1000.isSelected() && !rdbtnAllIn.isSelected()) { // Ez badago botoirik aukeratuta
	    JOptionPane.showMessageDialog(null, "Aukeratu apostu kantitate bat.");
	} else {
	    JOptionPane.showMessageDialog(null, "Ezin izan da apostua erregistratu. Zure gehieneko apostua " + (int) pertsonaApostuMax + " da eta " + apostuOrain + " apostatu duzu"); // Ezin izan bada apostua bete (apostu kantitateak pertsonak ahal duen apostu maximoa pasatzen du)
	    }
	    return apostuOrain;
	}

	//TO STRING
	
	@Override
	public String toString() {
		return "Apustuak [id_apustua=" + id_apustua + ", id_joko=" + id_joko + ", NAN=" + NAN + ", apostu_kantitatea="
				+ apostu_kantitatea + ", apostu_emaitza=" + apostu_emaitza + "]";
	}
	
	//HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(apostu_emaitza, apostu_emaitza, NAN, apostu_emaitza, apostu_emaitza);
	}

	//EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apostu other = (Apostu) obj;
		return Objects.equals(id_apustua, other.id_apustua);
	}

}
