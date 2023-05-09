package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Ikuspegia.ruletaApostua;
import Kontrolatzailea.balidazioak;
import Kontrolatzailea.datuBaseKarga;
import Kontrolatzailea.metodoak;

public class TestMetodoak {
	
	  	 	
  	@Test
  	public void testRuletakoZbkKalkulatu() {
  		int ZbkKalkulatu = metodoak.ruletakoZbkKalkulatu(Math.toRadians(-45));
		assertEquals(4, ZbkKalkulatu);
	}
  
    @Test
    public void testGehituApostuak() {
    	int[] apostua1 = {};
        int[] apostua2 = {5};
        int[] apostua3 = {2, 4, 6, 8, 10};
        
        int emaiza1 = metodoak.gehituApostuak(apostua1);
        int emaitza2 = metodoak.gehituApostuak(apostua2);
        int emaitza3 = metodoak.gehituApostuak(apostua3);
        
        assertEquals(0, emaiza1);
        assertEquals(5, emaitza2);
        assertEquals(30, emaitza3);
    }
}