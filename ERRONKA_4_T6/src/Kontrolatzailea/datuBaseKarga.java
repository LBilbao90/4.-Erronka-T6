package Kontrolatzailea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.Maila;

public class datuBaseKarga {
    static ArrayList<Erabiltzaile> erabiltzaileak = new ArrayList<Erabiltzaile>();
    static ArrayList<Admin> langileak = new ArrayList<Admin>();
    static ArrayList<Maila> mailak = new ArrayList<Maila>();
    
    public static ArrayList<Erabiltzaile> getErabiltzaileak() {
		return erabiltzaileak;
	}

	public static ArrayList<Admin> getLangileak() {
		return langileak;
	}

	public static ArrayList<Maila> getMailak() {
		return mailak;
	}

	public static void karga() {
        final String url = "jdbc:mysql://localhost:3306/kasinoa"; //url de la base de datos de phpmyadmin
        final String erabiltzaileKontsulta = "*";
        final String langileKontsulta = "*";
        final String mailaKontsulta = "*";
        
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, "root", ""); //usuario y contrase�a user: root password: 
            Statement stmt = (Statement) connection.createStatement();
            ResultSet rs;
            
            // Mailak
            rs = stmt.executeQuery("SELECT " + mailaKontsulta + " FROM maila;"); //kontsulta
            
            while (rs.next()) { //kontsultaren informazio linea bakoitzeko (rs.next)
            	Maila maila = new Maila();
                maila.setId_maila (rs.getInt(1)); //lehenengo datua(izatenda primary key edo id)
                maila.setMaila_izena (rs.getString(2));//bigarren datua
                maila.setApostu_max (rs.getDouble(3));//hirugarren datua
                
                mailak.add(maila);
            }
            
            // Erabiltzaileak
            rs = stmt.executeQuery("SELECT " + erabiltzaileKontsulta + " FROM erabiltzaile_kontua;");
            while (rs.next()) {
            	Erabiltzaile erabiltzaile = new Erabiltzaile();
                erabiltzaile.setNAN (rs.getString(1));
                erabiltzaile.setId_maila(rs.getInt(2));
                erabiltzaile.setDiru_kopuru_historikoa(rs.getDouble(3));
                erabiltzaile.setDiru_kopuru_momentukoa(rs.getDouble(4));
                erabiltzaile.setTlf_zenabkia(rs.getString(5));
                erabiltzaile.setPostaKodea(rs.getString(6));
                erabiltzaile.setHerrialdea(rs.getString(7));
                erabiltzaile.setProbintzia(rs.getString(8));
                erabiltzaile.setHerria(rs.getString(9));
                erabiltzaile.setJaioteguna(rs.getString(10));
                erabiltzaile.setAbizena(rs.getString(11));
                erabiltzaile.setIzena(rs.getString(12));
                erabiltzaile.setPasahitza(rs.getString(13));

                erabiltzaileak.add(erabiltzaile);
            }
            
            // Langileak
            rs = stmt.executeQuery("SELECT " + langileKontsulta + " FROM langile_kontua;");
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId_langile(rs.getInt(1));
                admin.setId_kasino(rs.getInt(2));
                admin.setNAN (rs.getString(3));
                admin.setIzena(rs.getString(4));
                admin.setAbizena(rs.getString(5));
                admin.setJaioteguna(rs.getString(6));
                admin.setHerrialdea(rs.getString(7));
                admin.setProbintzia(rs.getString(8));
                admin.setHerria(rs.getString(9));
                admin.setPostaKodea(rs.getString(10));
                admin.setTlf_zenabkia(rs.getString(11));
                admin.setKargua(rs.getString(12));
               // admin.setSoldata(rs.getDouble(13));
                admin.setPasahitza(rs.getString(14));
                
                langileak.add(admin); 

                }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
//        //LOGS
//        System.out.println("MAILAK:");
//        for (Maila maila : mailak) {
//            System.out.println(maila.toString());
//        }
//        
//        System.out.println("\nERABILTZAILEAK:");
//        for (Erabiltzaile erabiltzaile : erabiltzaileak) {
//            System.out.println(erabiltzaile.toString());
//        }
//        
//        System.out.println("\nLANGILEAK:");
//        for (Admin admin : langileak) {
//            System.out.println(admin.toString());
//        }
//        
        
    }
}