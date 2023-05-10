package Kontrolatzailea;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modelo.Erabiltzaile;
import Modelo.KasinoErabiltzaile;

public class datuBaseEraldaketak {
	
	/**
	 * Erabiltzailea ez dagoela erregistratuta konprobatzen du eta horrela bada datu basean erabiltzailearen 'insert'-a egingo du.
	 * @param NAN | Erabiltzailearen NAN-a. (String)
	 * @param izena | Erabiltzailearen Nickname / izena. (String)
	 * @param abizena | Erabiltzailearen abizena. (String)
	 * @param pasahitza | Erabiltzailearen kontuko pasahitza. (String)
	 * @param jaiotzeData | Erabiltzailearen jaiotze data. (String)
	 * @param herrialdea | Erabiltzailearen herrialde. (String)
	 * @param probintzia | Erabiltzailearen probintzia. (String)
	 * @param herria | Erabiltzailearen herria. (String)
	 * @param postaKodea | Erabiltzailearen herriaren posta kodea. (String)
	 * @param telefonoZbk | Erabiltzailearen telefono zenbakia. (String)
	 * @return 'false' bueltatuko du erabiltzailea erregistratuta badago. 'true' bueltatuko du erabiltzailea erregistratzen badu.
	 */
	public static boolean erregistroaInsert(String NAN, String izena, String abizena, String pasahitza, String jaiotzeData, String herrialdea, String probintzia, String herria, String postaKodea, String telefonoZbk) {
	    boolean erregistratuta = false;
	    boolean existitu = false;

	    datuBaseKarga.karga();
	    ArrayList<Erabiltzaile> erabiltzaileak = datuBaseKarga.getErabiltzaileak();
	    
	    // Datu basean ez dela pasatutako NAN a konprobatzen du.
	    for (Erabiltzaile erabiltzaile : erabiltzaileak) {
	        if (erabiltzaile.getNAN().equals(NAN)) {
	            existitu = true;
	            break;
	        }
	    }
	    
	    // NAN-a ez bada datu basean existitzen, 'if'-ean sartuko da.
	    if(!existitu) {
	        Connection conn;                    
	        try {
	            String url = "jdbc:mysql://localhost:3306/kasinoa";
	            conn = (Connection) DriverManager.getConnection (url, "root","");
	            Statement stmt = (Statement) conn.createStatement();                     
	            stmt.executeUpdate( "INSERT INTO erabiltzaile_kontua VALUES ('"+NAN+"','"+3+"','"+30+"',"+30+",'"+telefonoZbk+"','"+postaKodea+"','"+herrialdea+"','"+probintzia+"','"+herria+"','"+jaiotzeData+"','"+abizena+"','"+izena+"','"+pasahitza+"');");
	            erregistratuta=true;
	            conn.close();
	        }catch(SQLException ex) {
	                System.out.println("SQLException: "+ ex.getMessage());
	                System.out.println("SQLState: "+ ex.getSQLState());
	                System.out.println("ErrorCode: "+ ex.getErrorCode());
	        }
	    }
	    return erregistratuta;
	 }
	
	/**
	 * Datu baseko 'erabiltzaile_kontua' taulan 'update' bat egiten du pasatako datu guztiena.
	 * @param NAN | Erabiltzailearen NAN-a. (String)
	 * @param erabiltzaileIzena | Erabiltzailearen Nickname / izena. (String)
	 * @param pasahitza | Erabiltzailearen kontuko pasahitza. (String)
	 * @param herrialdea | Erabiltzailearen herrialde. (String)
	 * @param probintzia | Erabiltzailearen probintzia. (String)
	 * @param herria | Erabiltzailearen herria. (String)
	 * @param postaKodea | Erabiltzailearen herriaren posta kodea. (String)
	 * @param telefonoZbk | Erabiltzailearen telefono zenbakia. (String)
	 * @return Zuzen egin bada datu baseko aldaketa 'true' buletatuko du, bestel 'false.
	 */
	public static boolean erabiltzaileUpdate(String NAN, String erabiltzaileIzena, String pasahitza, String herrialdea, String probintzia, String herria, String postaKodea, String telefonoZbk) {
	    boolean aldatuta = false;
	    Connection conn;
	    // Datu basean 'updatea'-a egiten sailatzen da.
	    try {
	    	String url = "jdbc:mysql://localhost:3306/kasinoa";
        conn = (Connection) DriverManager.getConnection (url, "root","");
        Statement stmt = (Statement) conn.createStatement();      
        
        stmt.executeUpdate("UPDATE erabiltzaile_kontua SET erabiltzaile_izena = '" + erabiltzaileIzena + "', pasahitza = '" + pasahitza + "', herrialdea = '" + herrialdea + "', probintzia = '" + probintzia + "', herria = '" + herria + "', posta_Kodea = '" + postaKodea + "', tlf_zenbakia = '" + telefonoZbk + "' WHERE NAN = '" + NAN + "'");

        // Errenkadaren bat aldatu den konprobatzen du
        int aldatutakoErrenkada = stmt.getUpdateCount();
        if (aldatutakoErrenkada > 0) {
        	aldatuta = true;
        }
	        conn.close();
	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("ErrorCode: " + ex.getErrorCode());
	    }
	    return aldatuta;
	}
	
	/**
	 * Datu baseetan egindako apostuen erregistroa insertatzen du.
	 * @param NAN | Erabiltzailearen NAN-a. (String)
	 * @param id_joko | Jokoaren id-a. (int)
	 * @param apostuKantitate | Apostu kantitatea. (int)
	 * @param apostuEmaitza | Apostuaren emaitza. (String)
	 * @return Datu baseko insertatzea zuzen egin bada 'true' bueltatuko da, bestela 'false'.
	 */
	public static boolean apostuaInsert(String NAN, int id_joko, int apostuKantitate, String apostuEmaitza) {
	    boolean erregistratuta = false;
	    boolean existitu = false;

	    datuBaseKarga.karga();
	    Connection conn;
	    
	    // Inserta egiten sailatzen da. Ondo egiten badu 'erregistroa' 'true' bezala ezartzen da.
	    try {
	        String url = "jdbc:mysql://localhost:3306/kasinoa";
	        conn = (Connection) DriverManager.getConnection(url, "root", "");
	        Statement stmt = (Statement) conn.createStatement();                     
	        stmt.executeUpdate("INSERT INTO apostua(NAN, id_joko, apostu_kantitatea, apostu_emaitza) VALUES ('" + NAN + "', '" + id_joko + "', '" + apostuKantitate + "', '" + apostuEmaitza + "');");
	        erregistratuta = true;
	        conn.close();
	    } catch(SQLException ex) {
	        System.out.println("SQLException: "+ ex.getMessage());
	        System.out.println("SQLState: "+ ex.getSQLState());
	        System.out.println("ErrorCode: "+ ex.getErrorCode());
	    }
	    return erregistratuta;
	}
	
	/**
	 * Datu baseko erabiltzaileen maila aldatzeko metodoa.
	 * @param NAN | Maila aldatu behar zaion erabiltzailearen NAN-a. (String)
	 * @param Maila | Aldatu behar den 'id_maila'-ra. (int)
	 * @return Datu baseko insertatzea zuzen burutu bada 'true' bueltatuko da, bestela 'false'.
	 */
	public static boolean erabiltzaileMailaUpdate(String NAN, int Maila) {
	    boolean aldatuta = false;
	    Connection conn;
	    // Datu basean 'updatea'-a egiten sailatzen da.
	    try {
	    	String url = "jdbc:mysql://localhost:3306/kasinoa";
        conn = (Connection) DriverManager.getConnection (url, "root","");
        Statement stmt = (Statement) conn.createStatement();      
        stmt.executeUpdate("UPDATE erabiltzaile_kontua SET id_maila = '" + Maila + "' WHERE NAN = '" + NAN + "'");

        // Errenkadaren bat aldatu den konprobatzen du
        int aldatutakoErrenkada = stmt.getUpdateCount();
        if (aldatutakoErrenkada > 0) {
        	aldatuta = true;
        } 
	        conn.close();
	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("ErrorCode: " + ex.getErrorCode());
	    }
	    return aldatuta;
	}
	
	/**
	 * Datu baseko 'kasino_erabiltzaile' taulara insert bat egingo du bertan ez bada existitzen pasatutako NAN eta pasatutako id_kasino-aren arteko erlazioa.
	 * @param NAN | Erabiltzailearen NAN-a. (String)
	 * @param id_kasino | Insertatu behar den id_kasinoa. (int)
	 * @return Datu basean insert-a betetzen bada 'true' bueltatuko du, bestela 'false'
	 */
	public static boolean kasinoErabiltzaileInsert(String NAN, int id_kasino) {
	    boolean insert = false;
	    boolean existitu = false;

	    datuBaseKarga.karga();
	    ArrayList<KasinoErabiltzaile> kasinoErabiltzaile = datuBaseKarga.getKasinoErabiltzaile();
	    
	    // Datu basean dauden NAN-en batek eta pasatutako NAN-ak koinziditzen badute eta id_kasinoak ere bai,'existitu' true bezala ezarriko da. 
	    for (KasinoErabiltzaile kasEr : kasinoErabiltzaile) {
	    	if (kasEr.getNAN().equals(NAN) && Integer.valueOf(kasEr.getId_Kasino()).equals(id_kasino)) {
	    	    existitu = true;
	    	    break;
	    	}
	    }
	    
	    // 'existitu' true bezala badago ezarrita 'if' barruan sartuko da eta datu basera insert-a egiten sailatuko da. Insert-a zuzen egiten badu 'insert' true bezala ipiniko da.
	    if(!existitu) {
	        Connection conn;                    
	        try {
	            String url = "jdbc:mysql://localhost:3306/kasinoa";
	            conn = (Connection) DriverManager.getConnection (url, "root","");
	            Statement stmt = (Statement) conn.createStatement();                     
	            stmt.executeUpdate("INSERT INTO kasino_erabiltzaile VALUES ('"+NAN+"','"+id_kasino+"');");
		        insert = true;
	            conn.close();
	        }catch(SQLException ex) {
	                System.out.println("SQLException: "+ ex.getMessage());
	                System.out.println("SQLState: "+ ex.getSQLState());
	                System.out.println("ErrorCode: "+ ex.getErrorCode());
	        }
	    }
	    return insert;
	}
}