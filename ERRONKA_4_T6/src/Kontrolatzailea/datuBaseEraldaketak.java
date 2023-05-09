package Kontrolatzailea;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modelo.Erabiltzaile;
import Modelo.KasinoErabiltzaile;

public class datuBaseEraldaketak {
	
		
	public static boolean erregistroaInsert(String NAN, String izena, String abizena, String pasahitza, String jaiotzeData, String herrialdea, String probintzia, String herria, String postaKodea, String telefonoZbk) {
	    boolean erregistratuta = false;
	    boolean existitu = false;

	    datuBaseKarga.karga();
	    ArrayList<Erabiltzaile> erabiltzaileak = datuBaseKarga.getErabiltzaileak();
	    
	    for (Erabiltzaile erabiltzaile : erabiltzaileak) {
	        if (erabiltzaile.getNAN().equals(NAN)) {
	            existitu = true;
	            break;
	        }
	    }
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
	
	public static boolean erabiltzaileUpdate(String NAN, String erabiltzaileIzena, String pasahitza, String herrialdea, String probintzia, String herria, String postaKodea, String telefonoZbk) {
	    boolean modificado = false;
	    Connection conn;
	    try {
	    	String url = "jdbc:mysql://localhost:3306/kasinoa";
        conn = (Connection) DriverManager.getConnection (url, "root","");
        Statement stmt = (Statement) conn.createStatement();      
        
        stmt.executeUpdate("UPDATE erabiltzaile_kontua SET erabiltzaile_izena = '" + erabiltzaileIzena + "', pasahitza = '" + pasahitza + "', herrialdea = '" + herrialdea + "', probintzia = '" + probintzia + "', herria = '" + herria + "', posta_Kodea = '" + postaKodea + "', tlf_zenbakia = '" + telefonoZbk + "' WHERE NAN = '" + NAN + "'");


	        int rowsAffected = stmt.getUpdateCount();
	        if (rowsAffected > 0) {
	            modificado = true;
	        } else {
	        }

	        conn.close();
	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("ErrorCode: " + ex.getErrorCode());
	    }
	    return modificado;
	}
	
	public static boolean apostuaInsert(String NAN, int id_joko, int apostuKantitate, String apostuEmaitza) {
	    boolean erregistratuta = false;
	    boolean existitu = false;

	    datuBaseKarga.karga();

	    Connection conn;                    
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
	
	public static boolean erabiltzaileMailaUpdate(String NAN, int Maila) {
	    boolean modificado = false;
	    Connection conn;
	    try {
	    	String url = "jdbc:mysql://localhost:3306/kasinoa";
        conn = (Connection) DriverManager.getConnection (url, "root","");
        Statement stmt = (Statement) conn.createStatement();      
        
        stmt.executeUpdate("UPDATE erabiltzaile_kontua SET id_maila = '" + Maila + "' WHERE NAN = '" + NAN + "'");


	        int rowsAffected = stmt.getUpdateCount();
	        if (rowsAffected > 0) {
	            modificado = true;
	        } else {
	        }

	        conn.close();
	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("ErrorCode: " + ex.getErrorCode());
	    }
	    return modificado;
	}
	
	public static void kasinoErabiltzaileInsert(String NAN, int id_kasino) {
	    boolean existitu = false;

	    datuBaseKarga.karga();
	    ArrayList<KasinoErabiltzaile> kasinoErabiltzaile = datuBaseKarga.getKasinoErabiltzaile();
	    
	    for (KasinoErabiltzaile kasEr : kasinoErabiltzaile) {
	    	if (kasEr.getNAN().equals(NAN) && Integer.valueOf(kasEr.getId_Kasino()).equals(id_kasino)) {
	    	    existitu = true;
	    	    break;
	    	}

	    }
    if(!existitu) {
        Connection conn;                    
        try {
            String url = "jdbc:mysql://localhost:3306/kasinoa";
            conn = (Connection) DriverManager.getConnection (url, "root","");
            Statement stmt = (Statement) conn.createStatement();                     
            stmt.executeUpdate( "INSERT INTO kasino_erabiltzaile VALUES ('"+id_kasino+"','"+NAN+"');");
            conn.close();
        }catch(SQLException ex) {
                System.out.println("SQLException: "+ ex.getMessage());
                System.out.println("SQLState: "+ ex.getSQLState());
                System.out.println("ErrorCode: "+ ex.getErrorCode());
        }
    }
}


}
