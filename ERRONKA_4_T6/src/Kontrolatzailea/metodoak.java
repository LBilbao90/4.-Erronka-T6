package Kontrolatzailea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import Ikuspegia.lehenLehioa;
import Ikuspegia.ruletaApostua;
import Ikuspegia.ruletaJokoa;
import Ikuspegia.ruletaJokoa.OKButtonListener;
import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.KasinoErabiltzaile;
import Modelo.Maila;


public class metodoak {
	
    // Ruletan irten den zenbakia kalkulatzen du, ruletaren angeluaren eta zenbakien ordenen arabera.
    public static int ruletakoZbkKalkulatu(double angelu) {
    	int[] ruletakoZbk = {26, 3, 35, 12, 28, 7, 29, 18, 22, 9, 31, 14, 20, 1, 33, 16, 24, 5, 10, 23, 8, 30, 11, 36, 13, 27, 6, 34, 17, 25, 2, 21, 4, 19, 15, 32, 0};

        int zenbakiGuztiak = ruletakoZbk.length;
        
        double unekoAngeluGraduak = Math.toDegrees(angelu);
        
        // Angelua ajustatzen du 0 eta 360 tartean.
        while (unekoAngeluGraduak < 0) {
        	unekoAngeluGraduak += 360;
        }
        while (unekoAngeluGraduak >= 360) {
        	unekoAngeluGraduak -= 360;
        }
        // Erruletako zenbakiak konpontzean angeluari dagokion indizea kalkulatzea
        int i = (int) Math.floor(unekoAngeluGraduak / (360.0 / zenbakiGuztiak));
        
        // Kalkulatutako indizeari dagokion zenbakia lortzea
        int zbk = ruletakoZbk[i];
        
        return zbk;
    }

    // 'if'aren barruan sartzen bada, Timer bat gelditzeko eta beste bat asiko da.
    public static void denboraAraberaTimer(int pasatakoDenbora, int denborHasiera, int denboraBukaera, int kont, Timer timerStop, Timer timerStart) {
    	if (pasatakoDenbora >= denborHasiera && pasatakoDenbora < denboraBukaera && kont == 1) {
            timerStop.stop();
            timerStart.start();
        }
    }

	 	
 	public static int gehituApostuak(int[] apostua) {
 		int guztira = 0;
 		//buklea 'apostua' guztietatik pasatzeko eta dena 'guztira' gordeko da.
 		for (int i = 0; i < apostua.length; i++) {
 			guztira += apostua[i];
 		}
 		return guztira;
 	}
 	
 	public static double ApostuMax(ArrayList<Erabiltzaile> erabiltzaileak, String NAN) {
 	    double apostuMax = 0.0;

 	    for (Erabiltzaile erabiltzaile : erabiltzaileak) {
 	        if (erabiltzaile.getNAN().equals(NAN)) {
 	            int idMaila = erabiltzaile.getId_maila();
 	            for (Maila maila : datuBaseKarga.getMailak()) {
 	                if (maila.getId_maila() == idMaila) {
 	                    apostuMax = maila.getApostu_max();
 	                    break;
 	                }
 	            }
 	            break;
 	        }
 	    }
 	    return apostuMax;
 	}
}