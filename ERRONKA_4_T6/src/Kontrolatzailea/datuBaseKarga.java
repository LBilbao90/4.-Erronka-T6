package Kontrolatzailea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.Jokoak;
import Modelo.KasinoErabiltzaile;
import Modelo.Kasinoa;
import Modelo.Maila;

public class datuBaseKarga {
    static ArrayList<Erabiltzaile> erabiltzaileak = new ArrayList<Erabiltzaile>();
    static ArrayList<Admin> langileak = new ArrayList<Admin>();
    static ArrayList<Maila> mailak = new ArrayList<Maila>();
    static ArrayList<Jokoak> joko = new ArrayList<Jokoak>();
    static ArrayList<Kasinoa> Kasinoa = new ArrayList<Kasinoa>();
    static ArrayList<KasinoErabiltzaile> KasinoErabiltzaile = new ArrayList<KasinoErabiltzaile>();
    
    public static ArrayList<Erabiltzaile> getErabiltzaileak() {
		return erabiltzaileak;
	}
    
	public static ArrayList<Admin> getLangileak() {
		return langileak;
	}
	
	public static ArrayList<Maila> getMailak() {
		return mailak;
	}

	public static ArrayList<Jokoak> getJoko() {
		return joko;
	}

	public static ArrayList<Kasinoa> getKasino() {
		return Kasinoa;
	}

	public static ArrayList<KasinoErabiltzaile> getKasinoErabiltzaile() {
		return KasinoErabiltzaile;
	}

	
	/*
	 * Datu baseko informazioa ArrayList desberdinetan gordetzen dira. (Maila, erabiltzaile_kontua, langile_kontua, jokoak, kasinoak, kasino_erabiltzaile.)
	 */
	public static void karga() {
        final String url = "jdbc:mysql://localhost:3306/kasinoa"; //datu basearen url-a
        final String erabiltzaileKontsulta = "*";
        final String langileKontsulta = "*";
        final String jokoak = "*";
        final String mailaKontsulta = "*";
        final String kasinoa = "*";
        final String kasino_erabiltzaile = "*";
        
        mailak.clear();
        erabiltzaileak.clear();
        langileak.clear();
        joko.clear();
        
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, "root", ""); //erabiltzailea eta pasahitza datu basera konektatu ahal izateko
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
                erabiltzaile.setJaioteguna(rs.getDate(10));
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
                admin.setJaioteguna(rs.getDate(6));
                admin.setHerrialdea(rs.getString(7));
                admin.setProbintzia(rs.getString(8));
                admin.setHerria(rs.getString(9));
                admin.setPostaKodea(rs.getString(10));
                admin.setPostaElektronikoa(rs.getString(11));
                admin.setTlf_zenabkia(rs.getString(12));
                admin.setKargua(rs.getString(13));
                admin.setSoldata(rs.getDouble(14));
                admin.setPasahitza(rs.getString(15));
                
                langileak.add(admin); 

                }
            
            // Jokoak
            rs = stmt.executeQuery("SELECT " + jokoak + " FROM jokoak;");
            while (rs.next()) {
                Jokoak jokoa = new Jokoak(1);
                jokoa.setId_jokoak(rs.getInt(1));
                jokoa.setJokoIzena(rs.getString(3));
                jokoa.setMaxApostu(rs.getDouble(4));
                jokoa.setIzena(rs.getString(4));
                
                joko.add(jokoa);
                }
            
            // Kasinoa
            rs = stmt.executeQuery("SELECT " + kasinoa + " FROM kasino;");
            while (rs.next()) {
                Kasinoa kasino = new Kasinoa();
                kasino.setId_kasinoa(rs.getInt(1));
                kasino.setIzena(rs.getString(2));
                kasino.setHelbidea(rs.getString(3));
                kasino.setTelefonoa(rs.getInt(4));
                
                Kasinoa.add(kasino);
                }
            
            // Kasinoa Erabiltzaile
            rs = stmt.executeQuery("SELECT " + kasino_erabiltzaile + " FROM kasino_erabiltzaile;");
            while (rs.next()) {
            	KasinoErabiltzaile kasinoErabiltzaile = new KasinoErabiltzaile();
            	kasinoErabiltzaile.setId_Kasino(rs.getInt(1));
            	kasinoErabiltzaile.setNAN(rs.getString(2));
                
            	KasinoErabiltzaile.add(kasinoErabiltzaile);
                }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
}