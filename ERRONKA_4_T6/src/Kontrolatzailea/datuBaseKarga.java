package Kontrolatzailea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class datuBaseKarga {
	final String url = "jdbc:mysql://localhost:3306/kasinoa";
	final String erabiltzaileKontsulta = "NAN, id_maila, diru_kopuru_momentutakoa, erabiltzaile_izena, pasahitza";
	final String langileKontsulta = "id_Langile, NAN, izena, kargu";
	final String mailaKontsulta = "id_maila, izena, apostua_max";
	Connection connection = null;

	public void karga() {
		try {
			connection = DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs;

			// Erabiltzaileak
			rs = stmt.executeQuery("SELECT " + erabiltzaileKontsulta + " FROM erabiltzaile;");
			while (rs.next()) {
				// Aquí procesas la información de cada erabiltzaile, puedes crear objetos o almacenar la información de alguna manera
			}

			// Langileak
			rs = stmt.executeQuery("SELECT " + langileKontsulta + " FROM langile;");
			while (rs.next()) {
				// Aquí procesas la información de cada langile, puedes crear objetos o almacenar la información de alguna manera
			}

			// Mailak
			rs = stmt.executeQuery("SELECT " + mailaKontsulta + " FROM maila;");
			while (rs.next()) {
				// Aquí procesas la información de cada maila, puedes crear objetos o almacenar la información de alguna manera
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
