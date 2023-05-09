package Testak;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Kontrolatzailea.datuBaseKarga;
import Kontrolatzailea.metodoak;
import Kontrolatzailea.datuBaseEraldaketak;

public class TestDatuBaseEraldaketak {
    @Test
    public void testErregistroaInsert() {
    	datuBaseKarga.karga();
    	String NAN = "45983123Y";
    	String izena = "Unax";
    	String abizena = "Zulaika";
    	String pasahitza = "elorrieta00";
    	String jaiotzeData = "2004-03-09";
    	String herria = "Elgoibar";
    	String probintzia = "Gipuzkoa";
    	String herrialdea = "Euskla Herria";
    	String postaKodea = "20870";
    	String telefonoZbk = "666999666";
    	
    	assertTrue(datuBaseEraldaketak.erregistroaInsert(NAN, izena, abizena, pasahitza, jaiotzeData, herrialdea, probintzia, herria, postaKodea, telefonoZbk));
    	assertFalse(datuBaseEraldaketak.erregistroaInsert("12345678Z", "ProbaKontua1", "ProbaKontua1", "Elorrieta00", "2000-01-01", "Euskal Herria", "Gipuzkoa", "Elgoibar", "20870", "666999666"));

    	Connection conn;
    	 try {
    		 String url = "jdbc:mysql://localhost:3306/kasinoa";
             conn = (Connection) DriverManager.getConnection (url, "root","");
             Statement stmt = (Statement) conn.createStatement();                     
             stmt.executeUpdate("DELETE FROM erabiltzaile_kontua WHERE NAN='" + NAN + "';");
             conn.close();
         }catch(SQLException ex) {
        	 System.out.println("SQLException: "+ ex.getMessage());
        	 System.out.println("SQLState: "+ ex.getSQLState());
        	 System.out.println("ErrorCode: "+ ex.getErrorCode());
         }	
    	 
    }
    
    @Test
    public void testErabiltzaileUpdate() {
        String NAN = "87654321X";
        String erabiltzaileIzena = "ProbaTest1";
        String pasahitza = "Elorrieta00";
        String herrialdea = "Euskadi";
        String probintzia = "Gipuzkoa";
        String herria = "Elgoibar";
        String postaKodea = "20870";
        String telefonoZbk = "333444333";

        // Testeatzeko erabiltzailea sortu
    	Connection conn;
        try {
        	String url = "jdbc:mysql://localhost:3306/kasinoa";
        	conn = (Connection) DriverManager.getConnection (url, "root","");
            Statement stmt = (Statement) conn.createStatement();  
            stmt.executeUpdate("INSERT INTO erabiltzaile_kontua (NAN, "
            		+ "diru_kopuru_historikoa, diru_kopuru_momentukoa, abizena, erabiltzaile_izena, pasahitza, herrialdea, probintzia, herria, posta_Kodea, tlf_zenbakia) VALUES ('" + NAN + "', '" + 30 +  "', '" + 30 + "', '" + "ProbaAbizen" + "', '" + erabiltzaileIzena + "', '" + pasahitza + "', '" + herrialdea + "', '" + probintzia + "', '" + herria + "', '" + postaKodea + "', '" + telefonoZbk + "')");
        } catch (SQLException e) {
       	 System.out.println("SQLException: "+ e.getMessage());
       	 System.out.println("SQLState: "+ e.getSQLState());
       	 System.out.println("ErrorCode: "+ e.getErrorCode());
        }

        // Izena aldatzen den konprobatu
        String erabiltzaileIzena2 = "ProbaTest2";
        assertTrue(datuBaseEraldaketak.erabiltzaileUpdate(NAN, erabiltzaileIzena2, pasahitza, herrialdea, probintzia, herria, postaKodea, telefonoZbk));

        // Datu basetik probaKasua borratu
    	Connection conn2;
        try {
        	String url = "jdbc:mysql://localhost:3306/kasinoa";
        	conn2 = (Connection) DriverManager.getConnection (url, "root","");
            Statement stmt = (Statement) conn2.createStatement(); 
            stmt.executeUpdate("DELETE FROM erabiltzaile_kontua WHERE NAN = '" + NAN + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testKasinoErabiltzaileInsert() {
    	datuBaseKarga.karga();
    	int id_kasino = 1;
    	String NAN = "45983123Y";
    	assertTrue(datuBaseEraldaketak.kasinoErabiltzaileInsert(NAN, id_kasino));
    	assertFalse(datuBaseEraldaketak.kasinoErabiltzaileInsert("12345678Z",1));
    	Connection conn;
    	 try {
    		 String url = "jdbc:mysql://localhost:3306/kasinoa";
             conn = (Connection) DriverManager.getConnection (url, "root","");
             Statement stmt = (Statement) conn.createStatement();                     
             stmt.executeUpdate("DELETE FROM kasinoErabiltzaile WHERE NAN='" + NAN + "';");
             conn.close();
         }catch(SQLException ex) {
        	 System.out.println("SQLException: "+ ex.getMessage());
        	 System.out.println("SQLState: "+ ex.getSQLState());
        	 System.out.println("ErrorCode: "+ ex.getErrorCode());
         }	
    	 
    }
    
    
    @Test
    public void testApostuaInsert() {
    	datuBaseKarga.karga();
    	String NAN="12345678Z";
    	int id_joko= 1;
    	int apostuKantitate= 100;
    	String apostuEmaitza= "Irabazi";
    	
    	assertTrue(datuBaseEraldaketak.apostuaInsert(NAN, id_joko, apostuKantitate, apostuEmaitza));
    	assertFalse(datuBaseEraldaketak.apostuaInsert("73264894A",2, 500, "Berdin"));
    	
    	Connection conn;
    	 try {
    		 String url = "jdbc:mysql://localhost:3306/kasinoa";
             conn = (Connection) DriverManager.getConnection (url, "root","");
             Statement stmt = (Statement) conn.createStatement();
             ResultSet rs;
             rs= stmt.executeQuery("SELECT id_apostu from apostua WHERE NAN='" + NAN + "'order by id_apostu desc limit 1;");
             Statement stmt2 = (Statement) conn.createStatement();
             rs.next();
             stmt2.executeUpdate("DELETE FROM apostua WHERE id_apostu='"+  rs.getInt("id_apostu") + "';");
             conn.close();
         }catch(SQLException ex) {
        	 System.out.println("SQLException: "+ ex.getMessage());
        	 System.out.println("SQLState: "+ ex.getSQLState());
        	 System.out.println("ErrorCode: "+ ex.getErrorCode());
         }	
    	 
   }
    
    
}