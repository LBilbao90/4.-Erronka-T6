package Kontrolatzailea;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Ikuspegia.lehenLehioa;
import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.KasinoErabiltzaile;

public class balidazioak {

	public static boolean baliozkoEremuak(String NAN, String izena, String abizena, String pasahitza, String jaiotzeDataString, String herrialdea, String probintzia, String herria, String postaKodea, String telefonoZbk, JPanel erregistratu) {
 	    // Konprobatu ez dagoela hutsik
 		if (NAN.isEmpty() || izena.isEmpty() || abizena.isEmpty() || pasahitza.isEmpty() || jaiotzeDataString.isEmpty() || herrialdea.isEmpty() || probintzia.isEmpty() || herria.isEmpty() || postaKodea.isEmpty() || telefonoZbk.isEmpty()) {
 	        JOptionPane.showMessageDialog(erregistratu, "Mesedez, bete aurreko eremu guztiak", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
 	        return false;
 	    } else if (balidazioak.nanBalidatu(NAN)) {
 	        if (izena.length() < 4) {
 	            JOptionPane.showMessageDialog(erregistratu, "Erabiltzaile izenak gutxienez 4 karaktere eduki behar ditu.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
 	            return false;
 	        } else {
 	            if (balidazioak.pasahitzaKonprobatu(pasahitza)) {
 	                if (balidazioak.tlfZenbakia(telefonoZbk) == true) {
 	                    if (balidazioak.zbkDa(postaKodea) && postaKodea.length() == 5) {
 	                        return true;
 	                    } else {
 	                        JOptionPane.showMessageDialog(erregistratu, "Posta kode okerra.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
 	                        return false;
 	                    }
 	                } else {
 	                    JOptionPane.showMessageDialog(erregistratu, "Telefono zenbaki okerra.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
 	                    return false;
 	                }
 	            } else {
 	                JOptionPane.showMessageDialog(erregistratu, "Pasahitzak ez ditu baldintza denak betetzen.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
 	                return false;
 	            }
 	        }
 	    } else {
 	        JOptionPane.showMessageDialog(erregistratu, "NAN okerra.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
 	        return false;
 	    }
 	}
	
 	
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

 	public static boolean loginBalidazioaAdmin(String admin, char[] pasahitza) {
 		datuBaseKarga.karga();
 		boolean adminZuzena = false;
 		
	    for (Admin adminintratzailea : datuBaseKarga.getLangileak()) {
	        if (adminintratzailea.getNAN().equals(admin) && adminintratzailea.getPasahitza().equals(new String(pasahitza))) {
	        	adminZuzena = true;
	        	System.out.println(adminintratzailea.getNAN());
	            return true;
	        }
	    }
	    if (!adminZuzena) {
	    	JOptionPane.showMessageDialog(null, "Erabiltzaile edo pasahitz okerra", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	}
 	
 	public static int loginBalidazioaErabiltzaile(String erabiltzailea, char[] pasahitza) {
        datuBaseKarga.karga();
        ArrayList<KasinoErabiltzaile> kasinoErabiltzaile = datuBaseKarga.getKasinoErabiltzaile();
        for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
            if (erabiltzaile.getNAN().equals(erabiltzailea) && erabiltzaile.getPasahitza().equals(new String(pasahitza))) {
                boolean kasino1 = false;
                for (KasinoErabiltzaile ke : datuBaseKarga.getKasinoErabiltzaile()) {
                    if (ke.getNAN().equals(erabiltzaile.getNAN()) && ke.getId_Kasino() == 1) {
                        kasino1 = true;
                        break;
                    }
                }
                if (kasino1) {
                    if (erabiltzaile.getId_maila() == 1) {
                        JOptionPane.showMessageDialog(null, "Administratzaile batek zure kontua blokeatu du", "Elorrieta Kasinoa", JOptionPane.ERROR_MESSAGE);
                        // ezer
                        return 2;
                    } else if (erabiltzaile.getId_maila() == 2) {
                        String[] botoiak = {"Bai", "Ez"};
                        int baja = JOptionPane.showOptionDialog(null, "Zure kontua desblokeatu nahi duzu?", "Konfirmazio mezua", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoiak, botoiak[0]);
                        if (baja == JOptionPane.YES_OPTION) {
                            System.out.println(datuBaseEraldaketak.erabiltzaileMailaUpdate(lehenLehioa.getMomentukoErabiltzaileNAN(), 3));
                            // true
                            return 1;
                        } else {
                            // ezer
                            return 2;
                        }
                    } else {
                        // true
                        return 1;
                    }
                } else {
                    // Ez dago lehen kasinoa
                    // ezer
                    return 0;
                }
            }
        }
       return 0;
    }
 	
	/**
	 * String bat pasatuko diogu metodoari, pasahitza izango dela. Metodoa egingo duena izango da 
	 * konprobatu eta betetzen baditu baldintza batzuk gure pasahitza segurua izateko.
	 * @param pasahitza (String)
	 * @return True bueltatuko digu, pasahitza zuzena bada. Pasahitza ez bada zuzen false bueltatuko digu.
	 */
	public static boolean pasahitzaKonprobatu(String pasahitza) {
	    int minLuzera = 6;
	    int maxLuzera = 32;
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
	  
	 	public static boolean zbkDa(String texto) {
		    try {
		        Integer.parseInt(texto);
		        return true;
		    } catch (NumberFormatException e) {
		        return false; 
		    }
		}
	 	
	 	public static boolean jaiotzeDataOndo(String jaiotzeData) {
	 	    String dataForma = "\\d{4}-\\d{2}-\\d{2}";
	 	    
	 	    return jaiotzeData.matches(dataForma);
	 	}
}
