package Kontrolatzailea;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Ikuspegia.lehenLehioa;
import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.KasinoErabiltzaile;

public class balidazioak {

	/**
	 * Erregistroa egiteko bete behar diren eremuak baliozkoak direla ikusteko metodoa.
	 * @param NAN | Erabiltzailearen NAN-a. (String)
	 * @param izena | Erabiltzailearen izena. (String)
	 * @param abizena | Erabiltzailearen abizena. (String)
	 * @param pasahitza | Erabiltzailearen pasahitza.  (String)
	 * @param jaiotzeDataString | Erabiltzailearen jaiotze data. (String)
	 * @param herrialdea | Erabiltzailearen herrialdea. (String)
	 * @param probintzia | Erabiltzailearen probintzia. (String)
	 * @param herria | Erabiltzailearen herria. (String)
	 * @param postaKodea | Erabiltzailearen posta kodea. (String)
	 * @param telefonoZbk | Erabiltzailearen telefono zenbakia. (String)
	 * @return Eremu guztiak zuzen badaude 'true' bueltatuko da, bestela 'false'
	 * @author 6.Taldea
	 */
	public static boolean baliozkoEremuak(String NAN, String izena, String abizena, String pasahitza, String jaiotzeDataString, String herrialdea, String probintzia, String herria, String postaKodea, String telefonoZbk) {
 	    // Konprobatu ez dagoela hutsik
 		if (NAN.isEmpty() || izena.isEmpty() || abizena.isEmpty() || pasahitza.isEmpty() || jaiotzeDataString.isEmpty() || herrialdea.isEmpty() || probintzia.isEmpty() || herria.isEmpty() || postaKodea.isEmpty() || telefonoZbk.isEmpty()) {
 	        JOptionPane.showMessageDialog(null, "Mesedez, bete aurreko eremu guztiak", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE); // Errorea: ez dago dena beteta
 	        return false;
 	    } else if (balidazioak.nanBalidatu(NAN)) { // NAN-a zuzena dela (Tamaina eta Letra zuzena)
 	        if (izena.length() < 4) { // Nickname zuzena
 	            JOptionPane.showMessageDialog(null, "Erabiltzaile izenak gutxienez 4 karaktere eduki behar ditu.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
 	            return false;
 	        } else {
 	            if (balidazioak.pasahitzaKonprobatu(pasahitza)) { // Pasahitz zuena
 	                if (balidazioak.tlfZenbakia(telefonoZbk) == true) { // Telefono zenbaki zuzena
 	                    if (balidazioak.zbkDa(postaKodea) && postaKodea.length() == 5) { // Posta kode zuzena
 	                        return true;
 	                    } else {
 	                        JOptionPane.showMessageDialog(null, "Posta kode okerra.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE); // Errorea: posta kode okerra
 	                        return false;
 	                    }
 	                } else {
 	                    JOptionPane.showMessageDialog(null, "Telefono zenbaki okerra.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE); // Errorea: telefono zenbaki okerra
 	                    return false;
 	                }
 	            } else {
 	                JOptionPane.showMessageDialog(null, "Pasahitzak ez ditu baldintza denak betetzen.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE); // Errorea: pasahitz okerra
 	                return false;
 	            }
 	        }
 	    } else {
 	        JOptionPane.showMessageDialog(null, "NAN okerra.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE); // Errorea: NAN okerra
 	        return false;
 	    }
 	}
	
 	/**
 	 * Telefono zenbaki zuzena izate ikusten du metodoak. (luzeera 9 eta dena zenbakiak)
 	 * @param tlf | Erabiltzaileak sartutako telefono zenbakia. (String)
 	 * @return telefono zenbaki zuzena bada 'true' bueltatuko du, bestela 'false'
 	 * @author 6.Taldea
 	 */
 	public static boolean tlfZenbakia (String tlf) {
 		boolean tlf_zuzena= true;
 	    // Konprobatu 9ko luzeera daukala
 	    if (tlf.length() != 9) {
 	    	tlf_zuzena= false;
 	    }
 	    
 	    // Konprobatu ea guztia zenbakiak diren
 	    for (int i = 0; i < tlf.length(); i++) {
 	        if (!Character.isDigit(tlf.charAt(i))) {
 	        	tlf_zuzena= false;
 	        }
 	    }
 	    return tlf_zuzena;
 	}

 	/**
 	 * Saioa hastean administratzailea dela konprobatzeko metodoa.
 	 * @param admin | Administratzailearen NAN-a artuko du. (String)
 	 * @param pasahitza | Administratzailearen pasahitza artuko du. (char[])
 	 * @return NANa eta pasahitza bat badatoz datu-basekoekin 'true' bueltatuko du, bestela 'false'
 	 * @author 6.Taldea
 	 */
 	public static boolean loginBalidazioaAdmin(String admin, char[] pasahitza) {
 		datuBaseKarga.karga();
 		boolean adminZuzena = false;
 		 
	    for (Admin adminintratzailea : datuBaseKarga.getLangileak()) {
	    	// Erabiltzailea (NAN) eta pasahitza balidatu.
	        if (adminintratzailea.getNAN().equals(admin) && adminintratzailea.getPasahitza().equals(new String(pasahitza))) {
	        	adminZuzena = true;
	        	System.out.println(adminintratzailea.getNAN());
	            return adminZuzena;
	        }
	    }
	    // NAN eta pasahitzak ez badute administratzaile batenarekin bat etortzen, errore mezua erakusten du
	    if (!adminZuzena) {
	    	JOptionPane.showMessageDialog(null, "Erabiltzaile edo pasahitz okerra", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
	    }
	    return adminZuzena;
	}
 	
 	/**
 	 * Erabiltzailearen logina balidatzen du, eta kontua blokeatuta badago mezua erakusten du.
 	 * @param erabiltzailea | Erabiltzailearen NAN-a artuko du. (String)
 	 * @param pasahitza | Erabiltzailearen pasahitza artuko du. (char[])
 	 * @return '0' bueltatuko du ez badago 'id_kasino == 1'-en (Lehen kasinoan) edo ezin bada desblokeatu kontua. '1' bueltatuko du normal ahal dugunean hasi saioa edo kontua deblokeatu dugunean. '2' bueltatuko du kontua administratzaile batek blokeatu badu edo ez duelako nahi bere kontua desblokeatu.
 	 * @author 6.Taldea
 	 */
 	public static int loginBalidazioaErabiltzaile(String erabiltzailea, char[] pasahitza) {
        datuBaseKarga.karga();
        for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
        	// Erabiltzailea (NAN) eta pasahitza balidatu.
            if (erabiltzaile.getNAN().equals(erabiltzailea) && erabiltzaile.getPasahitza().equals(new String(pasahitza))) {
                boolean kasino1 = false;
                for (KasinoErabiltzaile ke : datuBaseKarga.getKasinoErabiltzaile()) {
                	// Erabiltzailea lehen kasinokoa den balidatu.
                    if (ke.getNAN().equals(erabiltzaile.getNAN()) && ke.getId_Kasino() == 1) {
                        kasino1 = true;
                        break;
                    }
                }
                if (kasino1) { // Lehen kasinokoa bada 'if'-ean sartuko da.
                    if (erabiltzaile.getId_maila() == 1) { // Erabiltzailearen maila berreskuratzen du. '1' bada bera maila, administratzaileak blokeatutako kontua delako da, hori dela eta errore mezua erakusten du.
                        JOptionPane.showMessageDialog(null, "Administratzaile batek zure kontua blokeatu du", "Elorrieta Kasinoa", JOptionPane.ERROR_MESSAGE);
                        return 2;
                    } else if (erabiltzaile.getId_maila() == 2) { // Erabiltzailearen maila berreskuratzen du. '2' bada bere maila, erabiltzaileak bere burua blokeatu zuela ezaten dion mezu bat erakusten du eta desbloakeatzeko aukera ematen dio.
                        String[] botoiak = {"Bai", "Ez"};
                        int baja = JOptionPane.showOptionDialog(null, "Zure kontua desblokeatu nahi duzu?", "Konfirmazio mezua", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoiak, botoiak[0]);
                        if (baja == JOptionPane.YES_OPTION) {
                            System.out.println(datuBaseEraldaketak.erabiltzaileMailaUpdate(lehenLehioa.getMomentukoErabiltzaileNAN(), 3));
                            return 1;
                        } else {
                            // Ez du nahi bere kontua desblokeatu
                            return 2;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    // Ez da lehen kasinokoa
                    return 0;
                }
            }
        }
       return 0;
    }
 	
 	/**
 	 * Erabiltzailearen pasahitza balidatzen du.
 	 * @param pasahitza | Erabiltzaileare pasahitza. (String)
 	 * @return Pasahitza zuzena den kasuan 'true' bueltatuko du, bestela 'false'.
 	 * @author 6.Taldea
 	 */
	public static boolean pasahitzaKonprobatu(String pasahitza) {
		// Baldintzak zehazten dira
	    int minLuzera = 6;
	    int maxLuzera = 32;
	    
	    boolean pasahitzaZuzena= false;
	    boolean mayuskulaDauka = false;
	    boolean minuskulaDauka = false;
	    boolean zenbakiakDauka = false;
	    
	    // pasahitzaren luzeera 'minLuzera' baino handiagoa eta 'maxLuzera' baino txikiagoa izatea konprobatzen du.
	    if (pasahitza.length() >= minLuzera && pasahitza.length() <= maxLuzera) {
	        // pasahitzeko karaktere bakoitzantzako for
	    	for (char c : pasahitza.toCharArray()) {
	    		// Minuskula izateko kasuan 'minuskulaDauka' 'true'-n ipiniko da.
	            if (Character.isLowerCase(c)) {
	            	minuskulaDauka = true;
	            } else if (Character.isUpperCase(c)) { // Mailuskulak izateko kasuan 'mayuskulaDauka' 'true'-n ipiniko da.
	            	mayuskulaDauka = true;
	            } else if (Character.isDigit(c)) { // Zenbakia izateko kasuan 'zenbakiakDauka' 'true'-n ipiniko da.
	            	zenbakiakDauka = true;
	            }
	        }
	    }
	    // Aurreko dena 'true' ('mayuskulaDauka', 'minuskulaDauka' eta 'zenbakiakDauka') bezala badago 'pasahitzaZuzena' true bezala ipiniko da eta bestela false.
	    if(mayuskulaDauka==true & minuskulaDauka==true & zenbakiakDauka==true) {
	    	pasahitzaZuzena=true;
	    }else {
	    	pasahitzaZuzena=false;
	    }
	    return pasahitzaZuzena;
	}
	
	/**
	 * Erabiltzailearen NAN-a balidatzen du.
	 * @param nan | Erabiltzailearen NAN-a. (String)
	 * @return NAN-a zuzena bada 'true' bueltatuko du, bestela 'false'
	 * @author 6.Taldea
	 */
	 public static boolean nanBalidatu(String nan) {
	        // NAN-aren luzeera 9 den egiaztatzen du.
	        if (nan.length() != 9) {
	            return false;
	        }
	        
	        //NAN-aren zenbakiak eta letrak banantzen ditu.
	        String zenbakia = nan.substring(0, 8);
	        String letra = nan.substring(8);
	        
	        // NAN-aren zenbakiak ('zenbakia') baliozkoa den egiaztatzen du. Ez bada baliozkoa 'false' bueltatzen du.
	        try {
	            Integer.parseInt(zenbakia);
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        
	        // NAN-aren zenbakiari dagokoion letra ('letra') kalkultatzeb du
	        String letrak = "TRWAGMYFPDXBNJZSQVHLCKE";
	        int indizea = Integer.parseInt(zenbakia) % 23;
	        char kalkulatutakoLetra = letrak.charAt(indizea);
	        
	        // NAN-aren letra baliozkoa dela egiaztatzen du. Ez bada baliozkoa 'false' bueltatzen du.
	        if (letra.charAt(0) != kalkulatutakoLetra) {
	            return false;
	        }
	        
	        // Deba zuzena izan bada 'true' bueltatuko du.
	        return true;
	    }
	  
	 	public static boolean zbkDa(String texto) {
		    try {
		        Integer.parseInt(texto);
		        return true;
		    } catch (NumberFormatException e) {
		        return false; 
		    }
		}
	 	
	 	/**
	 	 * Pasatutako jaiotze data formato egokian dagoen egiaztatzen du.
	 	 * @param jaiotzeData | Erabiltzailearen jaiotzeData. (String)
	 	 * @return jaiotze datak formato egokia badu 'true' bueltatuko du.
	 	 * @author 6.Taldea
	 	 */
	 	public static boolean jaiotzeDataOndo(String jaiotzeData) {
	 		// dataren formatoa. ('YYYY-MM-DD')
	 	    String dataForma = "\\d{4}-\\d{2}-\\d{2}";
	 	    
	 	    return jaiotzeData.matches(dataForma);
	 	}
}
