package Ikuspegia;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontrolatzailea.balidazioak;
import Kontrolatzailea.datuBaseEraldaketak;
import Kontrolatzailea.datuBaseKarga;
import Kontrolatzailea.metodoak;
import Kontrolatzailea.windowBuilder;
import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.KasinoErabiltzaile;
import Modelo.Kasinoa;
import Modelo.Maila;
import Modelo.Pertsona;
import Salbuespenak.Salbuespena;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;

import com.toedter.calendar.JDateChooser;

import Ikuspegia.ruletaApostua.btnJokoetaraBueltatuListener;

import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.Insets;

public class lehenLehioa extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtErabiltzailea;
	private JTextField txtPasahitza;
	private JTextField textErregistratu;
	private JPasswordField passwordLogin;
	private JTextField txtNAN;
	private JTextField txtIzena;
	private JTextField txtAbizena;
	private JTextField txtPasahitzaErregistratu;
	private JTextField txtJaiotzeData;
	private JTextField txtHerrialdea;
	private JTextField txtProbintzia;
	private JTextField txtHerria;
	private JTextField txtPostaKodea;
	private JTextField txtTelefonoa;
	private JTextArea textNAN;
	private JTextArea textIzena;
	private JTextArea textAbizena;
	private JPasswordField textPasahitzaErregistratu;
	private JDatePicker dateJaiotzaData;
	private JTextArea textHerrialdea;
	private JTextArea textProbintzia;
	private JTextArea textHerria;
	private JTextArea textPostaKodea;
	private JTextArea textTelefonoa;
	private JTextField textJokoak;
	private JTextArea textNAN2;
	private JTextArea textIzena2;
	private JTextArea textAbizena2;
	private JPasswordField textPasahitza2;
	private JDatePicker dateJaiotzaData2;
	private JTextArea textHerrialdea2;
	private JTextArea textProbintzia2;
	private JTextArea textHerria2;
	private JTextArea textPostaKodea2;
	private JTextArea textTelefonoa2;
	private JTextField textJokoak2;
	
    private ImageIcon irtenImg = new ImageIcon("img/bukatu.png");
    private ImageIcon atzeraGezia = new ImageIcon("img/atzeraGezia.png");
	
	// Pantailaren dimentsioak lortu
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = (int) (screenSize.height * 0.75);
	int screenWidth = (int) (screenSize.width * 0.75);
	
	protected static String momentukoErabiltzaileNAN = "";

    public static String getMomentukoErabiltzaileNAN() {
		return momentukoErabiltzaileNAN;
	}

	private static lehenLehioa lehenLehioaframe = new lehenLehioa();
    
    ruletaApostua ruletaFrame = new ruletaApostua();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//lehenLehioa frame = new lehenLehioa();
//					lehenLehioaframe.setUndecorated(true);

					lehenLehioaframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lehenLehioa() {
		
		lehenLehioaframe = this;
	    //Pantaila handian agertu ahal izateko
	    setResizable(false);
	    
	    setTitle("Elorrieta Kasinoa �");
	    
	 // Lehen lehioaren dimentsioak aldatu
		setBounds((screenSize.width - screenWidth) / 2, (screenSize.height - screenHeight) / 2, screenWidth, screenHeight);

	    Image img = new ImageIcon(this.getClass().getResource("/elorrieta_kasinoa.png")).getImage();
	    Image nuevaImg = img.getScaledInstance(screenWidth/2, (screenHeight*3)/4, Image.SCALE_SMOOTH);
	    ImageIcon icono = new ImageIcon(nuevaImg);


	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(new CardLayout(0, 0));

	    //SARRERA
	    JPanel sarrera = new JPanel();
	    sarrera.setLayout(new GridBagLayout());
	    sarrera.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(sarrera);

	    // Logo restrikzioak
	    GridBagConstraints gbcLogo = new GridBagConstraints();
	    gbcLogo.gridx = 0;
	    gbcLogo.gridy = 0;
	    gbcLogo.weighty = 0.3;
	    gbcLogo.anchor = GridBagConstraints.CENTER;

	    // JLabel  logo
	    JLabel logoa = new JLabel();
	    logoa.setIcon(icono);
	    
	    sarrera.add(logoa, gbcLogo);

	    // Testu restrikzioak
	    GridBagConstraints gbcTxt1 = new GridBagConstraints();
	    gbcTxt1.gridx = 0;
	    gbcTxt1.gridy = 1;
	    gbcTxt1.anchor = GridBagConstraints.CENTER;

	    // JLabel del testua
	    JLabel txt1 = new JLabel("Zure zortea hemen dago! Elorrieta Kasinoan sartu eta irabazi!");
	    txt1.setFont(new Font("Tahoma", Font.BOLD, 30));
	    sarrera.add(txt1, gbcTxt1);

	    // Restricciones para el bot�n
	    GridBagConstraints gbcBtn = new GridBagConstraints();
	    gbcBtn.gridx = 0;
	    gbcBtn.gridy = 0;
	    gbcBtn.weightx = 1.0;
	    gbcBtn.weighty = 1.0;
	    gbcBtn.fill = GridBagConstraints.BOTH;

	    JButton btnSarrera = new JButton("");
	    btnSarrera.setOpaque(false);
	    btnSarrera.setContentAreaFilled(false);
	    btnSarrera.setBorderPainted(false);	   
	    sarrera.add(btnSarrera, gbcBtn);
	    sarrera.setComponentZOrder(btnSarrera, 0);
	    
	    JPanel login = new JPanel();
	    login.setBorder(null);
	    login.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(login);
	    login.setLayout(null);
	    
	    txtErabiltzailea = new JTextField();
	    txtErabiltzailea.setEditable(false);
	    txtErabiltzailea.setBorder(null);
	    txtErabiltzailea.setBounds((int) (screenWidth*0.10), (int) (screenHeight*0.25), (int) (screenWidth*0.25), 69);
	    txtErabiltzailea.setText("NAN:");
	    txtErabiltzailea.setFont(new Font("Tahoma", Font.BOLD, 30));
	    
	    txtPasahitza = new JTextField();
	    txtPasahitza.setEditable(false);
	    txtPasahitza.setBorder(null);
	    txtPasahitza.setBounds((int) (screenWidth*0.10), (int) (screenHeight*0.40), (int) (screenWidth*0.25), 69);
	    txtPasahitza.setText("PASAHITZA:");
	    txtPasahitza.setFont(new Font("Tahoma", Font.BOLD, 30));

	    login.add(txtErabiltzailea);
	    login.add(txtPasahitza);
	    
	    JButton itxiLogin = new JButton("");
	    itxiLogin.setIcon(irtenImg);
	    itxiLogin.setBounds(10, 10, 110, 100);
	    itxiLogin.setOpaque(false);
	    itxiLogin.setContentAreaFilled(false);
	    itxiLogin.setBorderPainted(false);
	    itxiLogin.setFocusPainted(false);
	    login.add(itxiLogin);
	    
	    JLabel imgBannerLogin = new JLabel(new ImageIcon("img/banner.jpg"));
	    imgBannerLogin.setBounds(0, 0, screenWidth, (int) (screenHeight*0.20));
	    login.add(imgBannerLogin);


	    textErregistratu = new JTextField();
	    textErregistratu.setEditable(false);
	    textErregistratu.setBorder(null);
	    textErregistratu.setBounds ((int) (screenWidth*0.24), (int) (screenHeight*0.51), (int) (screenWidth*0.23), 75);
	    textErregistratu.setText("Ez daukazu kontua? ");
	    textErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    textErregistratu.setColumns(10);
	    
	    JButton btnEzErregistratua = new JButton("Erregistratu hemen klik eginez");
	    btnEzErregistratua.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnEzErregistratua.setForeground(new Color(0, 0, 255));
	    btnEzErregistratua.setBorder(null);
	    btnEzErregistratua.setBackground(new Color(255, 255, 255));
	    btnEzErregistratua.setOpaque(false); // transparente
	    btnEzErregistratua.setBounds((int) (screenWidth*0.45), (int) (screenHeight*0.51), (int) (screenWidth*0.35), 75);
	    login.add(btnEzErregistratua);
	    login.add(textErregistratu);
	    
	    JButton btnLogin = new JButton("Sartu");
	    btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnLogin.setOpaque(false); // transparente
	    btnLogin.setBounds((int) (screenWidth*0.70), (int) (screenHeight*0.80), (int) (screenWidth*0.12), 50);
	    login.add(btnLogin);
	    
	    passwordLogin = new JPasswordField();
	    passwordLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    passwordLogin.setBorder(new LineBorder(new Color(171, 173, 179)));
	    passwordLogin.setBounds((int) (screenWidth*0.36), (int) (screenHeight*0.42), (int) (screenWidth*0.35), 40);
	    login.add(passwordLogin);
	    
	    JTextArea textErabiltzailea = new JTextArea();
	    textErabiltzailea.setFont(new Font("Monospaced", Font.PLAIN, 30));
	    textErabiltzailea.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textErabiltzailea.setBounds((int) (screenWidth*0.36), (int) (screenHeight*0.27), (int) (screenWidth*0.35), 40);
	    login.add(textErabiltzailea);
	    
	    
	    //EREGISTRATU
	    JPanel erregistratu = new JPanel();
	    erregistratu.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(erregistratu);
	    erregistratu.setLayout(null);
	    
	    JButton itxiErregistratu = new JButton("");
	    itxiErregistratu.setIcon(irtenImg);
	    itxiErregistratu.setBounds(10, 10, 110, 100);
	    itxiErregistratu.setOpaque(false);
	    itxiErregistratu.setContentAreaFilled(false);
	    itxiErregistratu.setBorderPainted(false);
	    itxiErregistratu.setFocusPainted(false);
	    erregistratu.add(itxiErregistratu);
	    
	    JLabel imgBannerErregistratu = new JLabel(new ImageIcon("img/banner.jpg"));
	    imgBannerErregistratu.setBounds(0, 0, screenWidth, (int) (screenHeight*0.20));
	    erregistratu.add(imgBannerErregistratu);
	    
	    //erregistroa testuak
	    txtNAN = windowBuilder.createTextFieldTestua("NAN:", (int) (screenWidth*0.07), (int) (screenHeight*0.22), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtIzena = windowBuilder.createTextFieldTestua("Nickname:", (int) (screenWidth*0.07), (int) (screenHeight*0.32), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtIzena.setToolTipText("Gutxienez 4 karaktereko luzeera eduki behar du erabiltzaile izenak");
	    txtAbizena = windowBuilder.createTextFieldTestua("Abizena:", (int) (screenWidth*0.07), (int) (screenHeight*0.42), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtPasahitzaErregistratu = windowBuilder.createTextFieldTestua("Pasahitza:", (int) (screenWidth*0.07), (int) (screenHeight*0.52), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtPasahitzaErregistratu.setToolTipText("Gutxienes 6 karaktereko luzeera eta gehienez 32 karaktere. Maiuskula 1, minuskula 1 eta zenbaki 1");
	    txtJaiotzeData = windowBuilder.createTextFieldTestua("Jaiotze data:", (int) (screenWidth*0.07), (int) (screenHeight*0.62), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtHerrialdea = windowBuilder.createTextFieldTestua("Herrialdea:", (int) (screenWidth*0.52), (int) (screenHeight*0.22), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtProbintzia = windowBuilder.createTextFieldTestua("Probintzia:", (int) (screenWidth*0.52), (int) (screenHeight*0.32), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtHerria = windowBuilder.createTextFieldTestua("Herria:", (int) (screenWidth*0.52), (int) (screenHeight*0.42), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtPostaKodea = windowBuilder.createTextFieldTestua("Posta kodea:", (int) (screenWidth*0.52), (int) (screenHeight*0.52), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtPostaKodea.setToolTipText("5 zenbaki eduki behar ditu");
	    txtTelefonoa = windowBuilder.createTextFieldTestua("Telefonoa:", (int) (screenWidth*0.52), (int) (screenHeight*0.62), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);	
	    txtTelefonoa.setToolTipText("9 zenbaki eduki behar ditu");
	    
	    //erregistroa betetzeko textField
	    textNAN = windowBuilder.createTextArea((int) (screenWidth*0.25), (int) (screenHeight*0.215), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textIzena = windowBuilder.createTextArea((int) (screenWidth*0.25), (int) (screenHeight*0.315), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textIzena.setToolTipText("Gutxienez 4 karaktereko luzeera eduki behar du erabiltzaile izenak");
	    textAbizena = windowBuilder.createTextArea((int) (screenWidth*0.25), (int) (screenHeight*0.415), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textPasahitzaErregistratu = windowBuilder.createPasswordFieldBete((int) (screenWidth*0.25), (int) (screenHeight*0.515), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textPasahitzaErregistratu.setToolTipText("Gutxienes 6 karaktereko luzeera eta gehienez 32 karaktere. Maiuskula 1, minuskula 1 eta zenbaki 1");
	    JDateChooser dateJaiotzaData = new JDateChooser();
        dateJaiotzaData.setBounds((int) (screenWidth*0.25), (int) (screenHeight*0.615), (int) (screenWidth*0.20), 30);
        Font font = new Font("Arial", Font.PLAIN, 12);
        dateJaiotzaData.setFont(font);
        // Momentuko data artzeko
        LocalDate momentukoData = LocalDate.now();
        // Data minimoa. 18 urte,
        LocalDate dataMin = momentukoData.minusYears(18);
        // LocalDate aldatzeko Date-ra.
        Date dataMinJDateChooser = Date.from(dataMin.atStartOfDay(ZoneId.systemDefault()).toInstant());
        dateJaiotzaData.setMaxSelectableDate(dataMinJDateChooser);
        erregistratu.add(dateJaiotzaData);
	    
	    textHerrialdea = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.215), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textProbintzia = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.315), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textHerria = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.415), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textPostaKodea = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.515), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textPostaKodea.setToolTipText("5 zenbaki eduki behar ditu");
	    textTelefonoa = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.615), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);	
	    textTelefonoa.setToolTipText("9 zenbaki eduki behar ditu");
	    
	    //erregistroko textFieldak borde beltzarekin
	    textNAN.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textIzena.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textAbizena.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textPasahitzaErregistratu.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textHerrialdea.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textProbintzia.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textHerria.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textPostaKodea.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textTelefonoa.setBorder(new LineBorder(new Color(0, 0, 0)));
	    
		// Login buelatzeko botoia
	    JButton btnLoginBuelta = new JButton("");
	    btnLoginBuelta.setIcon(atzeraGezia);
	    btnLoginBuelta.setContentAreaFilled(false);
	    btnLoginBuelta.setBorderPainted(false);
	    btnLoginBuelta.setFocusPainted(false);
	    btnLoginBuelta.setBounds((int) (screenWidth*0.05), (int) (screenHeight*0.80), (int) (screenWidth*0.20), 70);
	    erregistratu.add(btnLoginBuelta);
	    
	    //Erregistratu botoia
	    JButton btnErregistratu = new JButton("Erregistratu");
	    btnErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnErregistratu.setOpaque(false); // transparente
	    btnErregistratu.setBounds((int) (screenWidth*0.525), (int) (screenHeight*0.80), (int) (screenWidth*0.40), 40);
	    erregistratu.add(btnErregistratu);
	    
	    windowBuilder.createTextFieldTestua("(Bete itzazu aurreko eremuak guztiak erregistratu ahal izateko)", (int) (screenWidth*0.54), (int) (screenHeight*0.75), (int) (screenWidth*0.40), 40, new Font("Tahoma", Font.PLAIN, 15), erregistratu);
	   
	    //Jokoak panela
	    JPanel jokoak = new JPanel();
	    jokoak.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(jokoak);
	    jokoak.setLayout(null);
	    
	    JButton itxiJokoak = new JButton("");
	    itxiJokoak.setIcon(irtenImg);
	    itxiJokoak.setBounds(10, 10, 110, 100);
	    itxiJokoak.setOpaque(false);
	    itxiJokoak.setContentAreaFilled(false);
	    itxiJokoak.setBorderPainted(false);
	    itxiJokoak.setFocusPainted(false);
	    jokoak.add(itxiJokoak);
	    
	    JLabel imgBannerJokoak = new JLabel(new ImageIcon("img/banner.jpg"));
	    imgBannerJokoak.setBounds(0, 0, screenWidth, (int) (screenHeight*0.20));
	    jokoak.add(imgBannerJokoak);
	        
	    //Tituloa jokoa panelean
	    JLabel jokoakTituloa = new JLabel("Aukeratu joku bat mesedez");
	    jokoakTituloa.setFont(new Font("Tahoma", Font.BOLD, 30));
	    jokoakTituloa.setBounds((int) (screenWidth*0.36), (int) (screenHeight*0.20), 420, 40);
	    jokoak.add(jokoakTituloa);
	    
	    //Ruletara joateko botoia
	    JButton btnRuletaJokoa = new JButton("");
	    btnRuletaJokoa.setMargin(new Insets(25, 25, 25, 25));
	    btnRuletaJokoa.setBounds((int) (screenWidth*0.25), (int) (screenHeight*0.30), 350, 350);
	    btnRuletaJokoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnRuletaJokoa.setIcon(new ImageIcon("img/ruleta_boton.png"));
	    btnRuletaJokoa.setOpaque(false); // make the button background transparent
	    btnRuletaJokoa.setContentAreaFilled(false); // make the content area of the button transparent
	    btnRuletaJokoa.setBorderPainted(false); // remove the border of the button
	    jokoak.add(btnRuletaJokoa);
	    
	  //Ruletara joateko botoia
	    JButton btnJokotikLogin = new JButton("Login");
	    btnJokotikLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnJokotikLogin.setBounds((int) (screenWidth*0.05), (int) (screenHeight*0.80), (int) (screenWidth*0.12), 50);
	    btnJokotikLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    jokoak.add(btnJokotikLogin);
	    
	    //BlackJackera joateko botoia
	    JButton btnBlackJackJokoa = new JButton("");
	    btnBlackJackJokoa.setMargin(new Insets(25, 25, 25, 25));
	    btnBlackJackJokoa.setBounds((int) (screenWidth*0.492), (int) (screenHeight*0.30), 350, 350);
	    btnBlackJackJokoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnBlackJackJokoa.setIcon(new ImageIcon("img/blackJack_boton.png"));
	    btnBlackJackJokoa.setOpaque(false); // make the button background transparent
	    btnBlackJackJokoa.setContentAreaFilled(false); // make the content area of the button transparent
	    btnBlackJackJokoa.setBorderPainted(false); // remove the border of the button
	    jokoak.add(btnBlackJackJokoa);
	    
	    //erabiltzaileDatuak panelera joateko botoia
	    JButton btnJokotikErabiltzaileDatu = new JButton("Nire datuak aldatu");
	    btnJokotikErabiltzaileDatu.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnJokotikErabiltzaileDatu.setBounds((int) (screenWidth*0.80), (int) (screenHeight*0.80), (int) (screenWidth*0.17), 50);
	    btnJokotikErabiltzaileDatu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    jokoak.add(btnJokotikErabiltzaileDatu);
	    
	    JPanel erabiltzaileDatuak = new JPanel();
	    erabiltzaileDatuak.setBorder(null);
	    erabiltzaileDatuak.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(erabiltzaileDatuak);
	    erabiltzaileDatuak.setLayout(null);    
	    
	    JButton itxiAldatuDatuak = new JButton("");
	    itxiAldatuDatuak.setIcon(irtenImg);
	    itxiAldatuDatuak.setBounds(10, 10, 110, 100);
	    itxiAldatuDatuak.setOpaque(false);
	    itxiAldatuDatuak.setContentAreaFilled(false);
	    itxiAldatuDatuak.setBorderPainted(false);
	    itxiAldatuDatuak.setFocusPainted(false);
	    erabiltzaileDatuak.add(itxiAldatuDatuak);
	    
	    JLabel imgBannerErabiltzaileDatuak = new JLabel(new ImageIcon("img/banner.jpg"));
	    imgBannerErabiltzaileDatuak.setBounds(0, 0, screenWidth, (int) (screenHeight*0.20));
	    erabiltzaileDatuak.add(imgBannerErabiltzaileDatuak);
	    
	  //erabiltzaileDatuak testuak
	    txtNAN = windowBuilder.createTextFieldTestua("NAN:", (int) (screenWidth*0.07), (int) (screenHeight*0.22), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtIzena = windowBuilder.createTextFieldTestua("Nickname:", (int) (screenWidth*0.07), (int) (screenHeight*0.32), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtIzena.setToolTipText("Gutxienez 4 karaktereko luzeera eduki behar du erabiltzaile izenak");
	    txtAbizena = windowBuilder.createTextFieldTestua("Abizena:", (int) (screenWidth*0.07), (int) (screenHeight*0.42), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtPasahitzaErregistratu = windowBuilder.createTextFieldTestua("Pasahitza:", (int) (screenWidth*0.07), (int) (screenHeight*0.52), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtPasahitzaErregistratu.setToolTipText("Gutxienes 6 karaktereko luzeera eta gehienez 32 karaktere. Maiuskula 1, minuskula 1 eta zenbaki 1");
	    txtJaiotzeData = windowBuilder.createTextFieldTestua("Jaiotze data:", (int) (screenWidth*0.07), (int) (screenHeight*0.62), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtHerrialdea = windowBuilder.createTextFieldTestua("Herrialdea:", (int) (screenWidth*0.52), (int) (screenHeight*0.22), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtProbintzia = windowBuilder.createTextFieldTestua("Probintzia:", (int) (screenWidth*0.52), (int) (screenHeight*0.32), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtHerria = windowBuilder.createTextFieldTestua("Herria:", (int) (screenWidth*0.52), (int) (screenHeight*0.42), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtPostaKodea = windowBuilder.createTextFieldTestua("Posta kodea:", (int) (screenWidth*0.52), (int) (screenHeight*0.52), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);
	    txtPostaKodea.setToolTipText("5 zenbaki eduki behar ditu");
	    txtTelefonoa = windowBuilder.createTextFieldTestua("Telefonoa:", (int) (screenWidth*0.52), (int) (screenHeight*0.62), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erabiltzaileDatuak);	
	    txtTelefonoa.setToolTipText("9 zenbaki eduki behar ditu");
	    
	    //erregistroa betetzeko textField
	    textNAN2 = windowBuilder.createTextArea((int) (screenWidth*0.25), (int) (screenHeight*0.215), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textIzena2 = windowBuilder.createTextArea((int) (screenWidth*0.25), (int) (screenHeight*0.315), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textIzena2.setToolTipText("Gutxienez 4 karaktereko luzeera eduki behar du erabiltzaile izenak");
	    textAbizena2 = windowBuilder.createTextArea((int) (screenWidth*0.25), (int) (screenHeight*0.415), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textPasahitza2 = windowBuilder.createPasswordFieldBete((int) (screenWidth*0.25), (int) (screenHeight*0.515), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textPasahitza2.setToolTipText("Gutxienes 6 karaktereko luzeera eta gehienez 32 karaktere. Maiuskula 1, minuskula 1 eta zenbaki 1");
	    JDateChooser dateJaiotzaData2 = new JDateChooser();
	    dateJaiotzaData2.setBounds((int) (screenWidth*0.25), (int) (screenHeight*0.615), (int) (screenWidth*0.20), 30);
        font = new Font("Arial", Font.PLAIN, 12);
        dateJaiotzaData2.setFont(font);
        // Momentuko data artzeko
        momentukoData = LocalDate.now();
        // Data minimoa. 18 urte,
        dataMin = momentukoData.minusYears(18);
        // LocalDate aldatzeko Date-ra.
        dataMinJDateChooser = Date.from(dataMin.atStartOfDay(ZoneId.systemDefault()).toInstant());
        dateJaiotzaData.setMaxSelectableDate(dataMinJDateChooser);
        erabiltzaileDatuak.add(dateJaiotzaData2);
        dateJaiotzaData2.setEnabled(false);
	    textHerrialdea2 = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.215), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textProbintzia2 = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.315), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textHerria2 = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.415), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textPostaKodea2 = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.515), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);
	    textPostaKodea2.setToolTipText("5 zenbaki eduki behar ditu");
	    textTelefonoa2 = windowBuilder.createTextArea((int) (screenWidth*0.72), (int) (screenHeight*0.615), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erabiltzaileDatuak);	
	    textTelefonoa2.setToolTipText("9 zenbaki eduki behar ditu");
	    
	    textNAN2.setEnabled(false);
	    textAbizena2.setEnabled(false);
        dateJaiotzaData2.setEnabled(false);

	    // erabiltzaileDatuak textFieldak borde beltzarekin
	    textNAN.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textIzena.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textAbizena.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textPasahitzaErregistratu.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textHerrialdea.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textProbintzia.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textHerria.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textPostaKodea.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textTelefonoa.setBorder(new LineBorder(new Color(0, 0, 0)));
	    
	    // erabiltzaileDatuak aldatzeko botoia
	    JButton btnAldatuErabiltzaileDatu = new JButton("Aldaketak aplikatu");
	    btnAldatuErabiltzaileDatu.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnAldatuErabiltzaileDatu.setOpaque(false); // transparente
	    btnAldatuErabiltzaileDatu.setBounds((int) (screenWidth*0.65), (int) (screenHeight*0.80), (int) (screenWidth*0.30), 40);
	    erabiltzaileDatuak.add(btnAldatuErabiltzaileDatu);
	    
	    // erabiltzaileDatuak aldatzeko botoia
	    JButton btnBlokeatuKontua = new JButton("Blokeatu kontua");
	    btnBlokeatuKontua.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnBlokeatuKontua.setOpaque(false); // transparente
	    btnBlokeatuKontua.setBounds((int) (screenWidth*0.325), (int) (screenHeight*0.80), (int) (screenWidth*0.25), 40);
	    erabiltzaileDatuak.add(btnBlokeatuKontua);
	    
		// Jokoak buelatzeko botoia
	    JButton btnJokoraBuelta = new JButton("");
	    btnJokoraBuelta.setIcon(atzeraGezia);
	    btnJokoraBuelta.setContentAreaFilled(false);
	    btnJokoraBuelta.setBorderPainted(false);
	    btnJokoraBuelta.setFocusPainted(false);
	    btnJokoraBuelta.setBounds((int) (screenWidth*0.05), (int) (screenHeight*0.80), (int) (screenWidth*0.20), 70);
	    erabiltzaileDatuak.add(btnJokoraBuelta);
	    
	    // Langile panela
	    JPanel langilePanela = new JPanel();
	    langilePanela.setBorder(null);
	    langilePanela.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(langilePanela);
	    langilePanela.setLayout(null);
	    
	    JButton itxiLangilePanela = new JButton("");
	    itxiLangilePanela.setIcon(irtenImg);
	    itxiLangilePanela.setBounds(10, 10, 110, 100);
	    itxiLangilePanela.setOpaque(false);
	    itxiLangilePanela.setContentAreaFilled(false);
	    itxiLangilePanela.setBorderPainted(false);
	    itxiLangilePanela.setFocusPainted(false);
	    langilePanela.add(itxiLangilePanela);
	    
	    //Administratzailetik Login
	    JButton btnAdminLogin = new JButton("Login");
	    btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnAdminLogin.setBounds((int) (screenWidth*0.05), (int) (screenHeight*0.80), (int) (screenWidth*0.12), 50);
	    btnAdminLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    langilePanela.add(btnAdminLogin);
	    
	    JButton btnAdminBlokeatu = new JButton("Blokeatu kontua");
	    btnAdminBlokeatu.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    btnAdminBlokeatu.setOpaque(false); // transparente
	    btnAdminBlokeatu.setBounds((int) (screenWidth*0.75), (int) (screenHeight*0.775), (int) (screenWidth*0.20), 30);
	    langilePanela.add(btnAdminBlokeatu);
	    
	    JButton btnAdminDesblokeatu = new JButton("Desblokeatu kontua");
	    btnAdminDesblokeatu.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    btnAdminDesblokeatu.setOpaque(false); // transparente
	    btnAdminDesblokeatu.setBounds((int) (screenWidth*0.75), (int) (screenHeight*0.875), (int) (screenWidth*0.20), 30);
	    langilePanela.add(btnAdminDesblokeatu);
	    
	    JLabel imgBannerLangilePanela = new JLabel(new ImageIcon("img/banner.jpg"));
	    imgBannerLangilePanela.setBounds(0, 0, screenWidth, (int) (screenHeight*0.20));
	    langilePanela.add(imgBannerLangilePanela);
	    
	    // Datu base karga
	    datuBaseKarga.karga();
	    
	 	// Kasino lista
	    ArrayList<Kasinoa> kasinoak = datuBaseKarga.getKasino();

	    // Kasinoen izenak gordetzeko Arraya
	    String[] kasinoDenak = new String[kasinoak.size() + 1];

	    // "Kasino denak" aukera
	    kasinoDenak[0] = "Kasino denak";

	    // Kasino lista bete izen guztiekin
	    for (int i = 0; i < kasinoak.size(); i++) {
	    	kasinoDenak[i+1] = kasinoak.get(i).getIzena();
	    }
	    
	    JComboBox<String> comboBoxKasino = new JComboBox<>(kasinoDenak);
	    comboBoxKasino.setBounds((int) (screenWidth*0.02), (int) (screenHeight*0.25), 175, 30);
	    comboBoxKasino.setSelectedIndex(-1);
	    langilePanela.add(comboBoxKasino);
	    
	    JComboBox<String> comboBoxMaila = new JComboBox<>();
	    comboBoxMaila.setBounds((int) (screenWidth*0.02), (int) (screenHeight*0.5), 175, 30);
	    comboBoxMaila.setEnabled(false);
	    langilePanela.add(comboBoxMaila);

	    // Mailen listak
	    ArrayList<Maila> mailak = datuBaseKarga.getMailak();

	    // Maila lista bete maila guztiekin
	    String[] mailaDenak = new String[mailak.size()];

	    // Maila lista bete maila izenekin
	    for (int i = 0; i < mailaDenak.length; i++) {
	        mailaDenak[i] = mailak.get(i).getMaila_izena();
	    }
	    
	    // comboBox-era gehitu aukerak
	    comboBoxMaila.setModel(new DefaultComboBoxModel<>(mailaDenak));
	    comboBoxMaila.setSelectedIndex(-1);
	    
	    // Taula
        JTable erabiltzaileTaula = new JTable();
        JScrollPane scrollPane = new JScrollPane(erabiltzaileTaula);
        scrollPane.setBounds((int) (screenWidth*0.2), (int) (screenHeight*0.25), (int) (screenWidth*0.65), (int) (screenHeight*0.5));
        langilePanela.add(scrollPane);
        langilePanela.setLayout(null);

        // Zutabe izenak
        String[] zutabeIzenak = {"Izena", "Abizena", "NAN", "Maila", "Momentuko Dirua", "Diru Historikoa"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(zutabeIzenak);
        erabiltzaileTaula.setModel(model);
        

    	// comboBoxKasino actionListener
    	comboBoxKasino.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Aukeratutako kasinoaren izena
    	        String kasinoIzena = (String) comboBoxKasino.getSelectedItem();

    	        // Bilatu hautatutako izenari dagokion Kasinoa objektua
    	        Kasinoa aukeratutakoKasinoa = null;
    	        if (!kasinoIzena.equals("Kasino denak")) {
    	        	comboBoxMaila.setSelectedIndex(-1);
    	        	comboBoxMaila.setEnabled(true);
    	            for (Kasinoa kasinoa : kasinoak) {
    	                if (kasinoa.getIzena().equals(kasinoIzena)) {
    	                	aukeratutakoKasinoa = kasinoa;
    	                    break;
    	                }
    	            }
    	        }

    	        // Taula garbitu
    	        model.setRowCount(0);

    	        // Gehitu erabiltzaileei dagozkien errenkadak
    	        if (kasinoIzena.equals("Kasino denak")) {
    	        	comboBoxMaila.setEnabled(false);
    	            // Erabiltzaile guztiak erakutsi
    	            for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
    	                String[] errenkada = {erabiltzaile.getIzena(), erabiltzaile.getAbizena(), erabiltzaile.getNAN(), Integer.toString(erabiltzaile.getId_maila()), Double.toString(erabiltzaile.getDiru_kopuru_momentukoa()) + " €", Double.toString(erabiltzaile.getDiru_kopuru_historikoa()) + " €"};
    	                model.addRow(errenkada);
    	            }
    	        } else {
    	        	comboBoxMaila.setSelectedIndex(-1);
    	        	comboBoxMaila.setEnabled(true);
    	            // Aukeratutako kasinoko erabiltzaileak erakutsi
    	            if (aukeratutakoKasinoa != null) {
    	                for (KasinoErabiltzaile ke : datuBaseKarga.getKasinoErabiltzaile()) {
    	                    if (ke.getId_Kasino() == aukeratutakoKasinoa.getId_kasinoa()) {
    	                        for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
    	                            if (erabiltzaile.getNAN().equals(ke.getNAN())) {
    	                            	String[] errenkada = {erabiltzaile.getIzena(), erabiltzaile.getAbizena(), erabiltzaile.getNAN(), Integer.toString(erabiltzaile.getId_maila()), Double.toString(erabiltzaile.getDiru_kopuru_momentukoa()) + " €", Double.toString(erabiltzaile.getDiru_kopuru_historikoa()) + " €"};
    	                                boolean erabiltzaileErantsia = false;
    	                                for (int i = 0; i < model.getRowCount(); i++) {
    	                                    if (model.getValueAt(i, 2).equals(erabiltzaile.getNAN())) {
    	                                    	erabiltzaileErantsia = true;
    	                                        break;
    	                                    }
    	                                }
    	                                if (!erabiltzaileErantsia) {
    	                                	model.addRow(errenkada);
    	                                }
    	                                break;
    	                            }
    	                        }
    	                    }
    	                }
    	            }
    	        }
    	    }
    	});
    	
    	// JComboBox2 actionListener
    	comboBoxMaila.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Aukeratutako mailaren izena berreskuratu
    	        String mailaIzena = (String) comboBoxMaila.getSelectedItem();

    	        // Bilatu hautatutako izenari dagokion Maila objektua
    	        Maila aukeratutakoMaila = null;
    	        for (Maila maila : mailak) {
    	            if (maila.getMaila_izena().equals(mailaIzena)) {
    	            	aukeratutakoMaila = maila;
    	                break;
    	            }
    	        }

    	        // JComboBox1-en aukeratutako kasinoaren izena berreskuratu
    	        String kasinoIzena = (String) comboBoxKasino.getSelectedItem();

    	        // Bilatu hautatutako izenari dagokion Kasinoa
    	        Kasinoa aukeratutakoKasinoa = null;
    	        if (!kasinoIzena.equals("Kasino denak")) {
    	            for (Kasinoa kasinoa : kasinoak) {
    	                if (kasinoa.getIzena().equals(kasinoIzena)) {
    	                	aukeratutakoKasinoa = kasinoa;
    	                    break;
    	                }
    	            }
    	        }

    	        // Taula garbitu
    	        model.setRowCount(0);

    	        // Gehitu erabiltzaileei dagozkien errenkadak
    	        if (aukeratutakoMaila != null) {
    	            if (aukeratutakoKasinoa != null) {
    	            	// Aukeratutako Kasino eta mailari dagokion erabiltzaileak erakutsi
    	                for (KasinoErabiltzaile kasinoErabiltzaile : datuBaseKarga.getKasinoErabiltzaile()) {
    	                    if (kasinoErabiltzaile.getId_Kasino() == aukeratutakoKasinoa.getId_kasinoa()) {
    	                        for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
    	                            if (erabiltzaile.getNAN().equals(kasinoErabiltzaile.getNAN()) && erabiltzaile.getId_maila() == aukeratutakoMaila.getId_maila()) {
    	                            	String[] errenkada = {erabiltzaile.getIzena(), erabiltzaile.getAbizena(), erabiltzaile.getNAN(), Integer.toString(erabiltzaile.getId_maila()), Double.toString(erabiltzaile.getDiru_kopuru_momentukoa()) + " €", Double.toString(erabiltzaile.getDiru_kopuru_historikoa()) + " €"};
    	                                boolean erabiltzaileErantsia = false;
    	                                for (int i = 0; i < model.getRowCount(); i++) {
    	                                    if (model.getValueAt(i, 2).equals(erabiltzaile.getNAN())) {
    	                                    	erabiltzaileErantsia = true;
    	                                        break;
    	                                    }
    	                                }
    	                                if (!erabiltzaileErantsia) {
    	                                    model.addRow(errenkada);
    	                                }
    	                                break;
    	                            }
    	                        }
    	                    }
    	                }
    	            } else {
    	                // Erakutsi kasino guztien erabiltzaileak aukeratutako mailan
    	                for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
    	                    if (erabiltzaile.getId_maila() == aukeratutakoMaila.getId_maila()) {
    	                    	String[] errenkada = {erabiltzaile.getIzena(), erabiltzaile.getAbizena(), erabiltzaile.getNAN(), Integer.toString(erabiltzaile.getId_maila()), Double.toString(erabiltzaile.getDiru_kopuru_momentukoa()) + " €", Double.toString(erabiltzaile.getDiru_kopuru_historikoa()) + " €"};
    	                        boolean erabiltzaileErantsia = false;
    	                        for (int i = 0; i < model.getRowCount(); i++) {
    	                            if (model.getValueAt(i, 2).equals(erabiltzaile.getNAN())) {
    	                            	erabiltzaileErantsia = true;
    	                                break;
    	                            }
    	                        }
                                if (!erabiltzaileErantsia) {
                                    model.addRow(errenkada);
                                }
                                break;
    	                    }
    	                }
    	            }
    	        }
    	    }
    	    
    	});
    	
    	btnAdminBlokeatu.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        int aukeratutakoErrenkada = erabiltzaileTaula.getSelectedRow();
    	        boolean blokeatuta = false;
    	        if (aukeratutakoErrenkada != -1) { // errenkada bat badago aukeratuta
    	            String nan = (String) erabiltzaileTaula.getValueAt(aukeratutakoErrenkada, 2);
    	            System.out.println(nan);
    	            
    	            for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
    	                if (erabiltzaile.getNAN().equals(nan) && erabiltzaile.getId_maila() == 1) {
    	                	JOptionPane.showMessageDialog(jokoak,"Une honetarako, kontu hau blokeatuta dago: " + nan, "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
    	                	blokeatuta = true;
    	                	break;
    	                	}  
    	                }
    	                
        	        if (!blokeatuta) {
        	        	datuBaseEraldaketak.erabiltzaileMailaUpdate(nan, 1);
			        	JOptionPane.showMessageDialog(jokoak, nan + " zuzen blokeatu da kontua", "Elorrieta Kasinoa �", JOptionPane.INFORMATION_MESSAGE);
		    	        datuBaseKarga.karga();
        	        }
        	        comboBoxKasino.setSelectedIndex(0);
        	        comboBoxMaila.setSelectedIndex(-1);
    	        }
    	    }
    	});
    	
    	btnAdminDesblokeatu.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        int aukeratutakoErrenkada = erabiltzaileTaula.getSelectedRow();
    	        boolean desblokeatuta = false;
    	        if (aukeratutakoErrenkada != -1) { // errekada bat badago aukeratuta
    	            String nan = (String) erabiltzaileTaula.getValueAt(aukeratutakoErrenkada, 2);
    	            System.out.println(nan);
    	            
    	            for (Erabiltzaile erabiltzaile : datuBaseKarga.getErabiltzaileak()) {
    	                if (erabiltzaile.getNAN().equals(nan) && erabiltzaile.getId_maila() == 1) {
    	                	datuBaseEraldaketak.erabiltzaileMailaUpdate(nan, 3);
    			        	JOptionPane.showMessageDialog(jokoak, nan + " zuzen desblokeatu da kontua", "Elorrieta Kasinoa �", JOptionPane.INFORMATION_MESSAGE);
    			        	datuBaseKarga.karga();
    	                	desblokeatuta = true;
    	                	break;
    	                	}  
    	                }
    	                
        	        if (!desblokeatuta) {
			        	JOptionPane.showMessageDialog(jokoak, nan + " ezin izan da desblokeatu kontua", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
        	        }
        	        comboBoxKasino.setSelectedIndex(0);
        	        comboBoxMaila.setSelectedIndex(-1);
    	        }
    	    }
    	});



		btnSarrera.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	windowBuilder.btn3secDelay(login, 2, sarrera);
	            setTitle("Hasi saioa | Elorrieta Kasinoa �");
	        }
		});	

		//'bukatu img' botoia 'login' panelean dagoena. Aplikazioa bukatzen du.
	    itxiLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	    
		btnEzErregistratua.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	windowBuilder.btn3secDelay(erregistratu, 0, login);
	            setTitle("Erregistroa | Elorrieta Kasinoa �");
	            }
	        });
		
		//Login botoia akzioak
		btnLogin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String NAN = textErabiltzailea.getText().toUpperCase();
	    		momentukoErabiltzaileNAN = NAN;
	    		char[] pasahitza = passwordLogin.getPassword();
	    		int loginOndoErabiltzaile = balidazioak.loginBalidazioaErabiltzaile(NAN, pasahitza);
	    		boolean loginOndoAdmin = false;
	    		if (loginOndoErabiltzaile == 0) {
	    			loginOndoAdmin = balidazioak.loginBalidazioaAdmin(NAN, pasahitza);
	    		}
			    
	    		if (loginOndoErabiltzaile == 1) {
	    			datuBaseEraldaketak.kasinoErabiltzaileInsert(NAN, 1);
	    			momentukoErabiltzaileNAN = NAN;
	    			textErabiltzailea.setText("");
	    			passwordLogin.setText("");
	    			windowBuilder.btn3secDelay(jokoak, 0, login);
	    			
	    		    double apostuMax = metodoak.ApostuMax(datuBaseKarga.getErabiltzaileak(), momentukoErabiltzaileNAN);
	    		    ruletaApostua.setPertsonaApostuMax(apostuMax);
	    		    ruletaApostua.setLblApostuMax((int) apostuMax);
	    			
	    			
	    			setTitle("Jokoak | Elorrieta Kasinoa �");
	    		} 
	    		else if(loginOndoAdmin){
	    			momentukoErabiltzaileNAN = NAN;
	    			textErabiltzailea.setText("");
	    			passwordLogin.setText("");
	    			windowBuilder.btn3secDelay(langilePanela, 0, login);
	    		} else {
	    			textErabiltzailea.setText("");
	    			passwordLogin.setText("");
	    			}
	    	    }	
	    	});
		
		btnLoginBuelta.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		windowBuilder.btn3secDelay(login, 0, jokoak);
	    	    	setTitle("Hasi saioa | Elorrieta Kasinoa �");
	    		    textNAN.setText("");
	    		    textIzena.setText("");
	    		    textAbizena.setText("");
	    		    textPasahitzaErregistratu.setText("");
	    		    dateJaiotzaData.setDate(null);
	    		    textHerrialdea.setText("");
	    		    textProbintzia.setText("");
	    		    textHerria.setText("");
	    		    textPostaKodea.setText("");
	    		    textTelefonoa.setText("");
	    	    	}
	    	});
		
		 
		//'bukatu img' botoia 'erregistrati' panelean dagoena. Aplikazioa bukatzen du.
	    itxiErregistratu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	    
	    //Erregistratu botoiaren akzioak
	    btnErregistratu.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    		
	    		String NAN = textNAN.getText().toUpperCase();
	    		String izena = textIzena.getText();
	    		String abizena = textAbizena.getText();
	    		String pasahitza = textPasahitzaErregistratu.getText();
	    		Date jaiotzeData;
	    		String jaiotzeDataString = "";
	    		try {
	    		    jaiotzeData = dateJaiotzaData.getDate();
	    		    if (jaiotzeData == null) {
	    		        throw new Salbuespena("Ez da datarik aukeratu");
	    		    }
	    		    jaiotzeDataString = sdf.format(jaiotzeData);
	    		} catch (Salbuespena ex) {
	    		    System.err.println(ex.getMessage());
	    		}
	    		String herrialdea = textHerrialdea.getText();
	    		String probintzia = textProbintzia.getText();
	    		String herria = textHerria.getText();
	    		String postaKodea = textPostaKodea.getText();
	    		String telefonoZbk = textTelefonoa.getText();
	
	    		if(balidazioak.baliozkoEremuak(NAN, izena, abizena, pasahitza, jaiotzeDataString, herrialdea, probintzia, herria, postaKodea, telefonoZbk)) {
	    			if(datuBaseEraldaketak.erregistroaInsert(NAN, izena, abizena, pasahitza, jaiotzeDataString, herrialdea, probintzia, herria, postaKodea, telefonoZbk)) {
	    				momentukoErabiltzaileNAN = NAN;
	    				datuBaseEraldaketak.kasinoErabiltzaileInsert(momentukoErabiltzaileNAN, 1);
	    				JOptionPane.showMessageDialog(erregistratu, textIzena.getText()+ ", zure kontua zuzen sortu da", "Elorrieta Kasinoa �"	, JOptionPane.INFORMATION_MESSAGE);
		    			windowBuilder.btn3secDelay(jokoak, 0, erregistratu);
		    			
		    	    	setTitle("Jokoak | Elorrieta Kasinoa �");
		    	    	momentukoErabiltzaileNAN = NAN;
		    		    textNAN.setText("");
		    		    textIzena.setText("");
		    		    textAbizena.setText("");
		    		    textPasahitzaErregistratu.setText("");
		    		    dateJaiotzaData.setDate(null);
		    		    textHerrialdea.setText("");
		    		    textProbintzia.setText("");
		    		    textHerria.setText("");
		    		    textPostaKodea.setText("");
		    		    textTelefonoa.setText("");
		    		    
		    		    double apostuMax = metodoak.ApostuMax(datuBaseKarga.getErabiltzaileak(), momentukoErabiltzaileNAN);
		    		    ruletaApostua.setPertsonaApostuMax(apostuMax);
		    		    ruletaApostua.setLblApostuMax((int) apostuMax);
	    			} else {
		    	    	JOptionPane.showMessageDialog(erregistratu, "Badirudi dagoeneko badagoela kontu bat sortuta " + NAN + " NANarekin.\r\nDagoeneko erregistratuta bazaude hasi saioa, eta bestela erregistraru gabeko NAN bat erabili.", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
		    	    }
	    		}
	    	}
	    });
	    
		//'bukatu img' botoia 'jokoak' panelean dagoena. Aplikazioa bukatzen du.
	    itxiJokoak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	    
	    // 'Login'era 'jokoak'etik
	    btnJokotikLogin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		windowBuilder.btn3secDelay(login, 0, jokoak);
	    		setTitle("Hasi saioa | Elorrieta Kasinoa �");
	    	}
	    });
	    
	    //Ruleta botoiaren akzioak
	    btnRuletaJokoa.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Oculta la ventana actual
	            setVisible(false);
	            
	            EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					
	    					ruletaFrame.setVisible(true);
	    					ruletaFrame.setResizable(false);
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}
	    			}
	    		});
	    	}
	    });

	    
	    //BlackJack botoiaren akzioak
	    btnBlackJackJokoa.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    	    	JOptionPane.showMessageDialog(jokoak, "Laster egongo da prest, barkatu eragozpenak.\r\n", "Elorrieta Kasinoa �", JOptionPane.WARNING_MESSAGE);
	    	}	
	    });
	    
	    // 'Login'era 'jokoak'etik
	    btnJokotikErabiltzaileDatu.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		windowBuilder.btn3secDelay(erabiltzaileDatuak, 0, jokoak);
	    		setTitle("Erabiltzaile Datuak | Elorrieta Kasinoa �");
	    		
	    		datuBaseKarga.karga();
	 	 	    ArrayList<Erabiltzaile> erabiltzaileak = datuBaseKarga.getErabiltzaileak();
	 	 	    ArrayList<Admin> aminn = datuBaseKarga.getLangileak();
		 	 	Erabiltzaile erabiltzailea = null;
	
		 	 	for (Erabiltzaile erabiltzaile : erabiltzaileak) {
		 	 	    if (erabiltzaile.getNAN().equals(momentukoErabiltzaileNAN)) {
		 	 	    	erabiltzailea = erabiltzaile;
		 	 	        break;
		 	 	    }
		 	 	}
	 	 	    
	 	 	    for (Erabiltzaile erabiltzaile : erabiltzaileak) {
	 	 	        if (erabiltzaile.getNAN().equals(momentukoErabiltzaileNAN)) {
	 	 	            break;
	 	 	        }
	 	 	    }
	    		
	    		textNAN2.setText(momentukoErabiltzaileNAN);
	    		textIzena2.setText(erabiltzailea.getIzena());
	    		textAbizena2.setText(erabiltzailea.getAbizena());
	    		textPasahitza2.setText(erabiltzailea.getPasahitza());
	    		dateJaiotzaData2.setDate(erabiltzailea.getJaioteguna());
	    		textHerrialdea2.setText(erabiltzailea.getHerrialdea());
	    		textProbintzia2.setText(erabiltzailea.getProbintzia());
	    		textHerria2.setText(erabiltzailea.getHerria());
	    		textPostaKodea2.setText(erabiltzailea.getPostaKodea());
	    		textTelefonoa2.setText(erabiltzailea.getTlf_zenabkia());
	    	}
	    });
	    
	    ruletaApostua.setBtnJokoetaraBueltatuListener(new btnJokoetaraBueltatuListener() {
			
			@Override
			public void onJokoetaraBueltatu() {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							lehenLehioaframe.setVisible(true);
							ruletaFrame.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				windowBuilder.btn3secDelay(jokoak, 0, null);
			}
		});	
	    
	    btnJokoraBuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowBuilder.btn3secDelay(jokoak, 0, erabiltzaileDatuak);
    	    	setTitle("Hasi saioa | Elorrieta Kasinoa �");
			}
		});
	    
	    //Erregistratu botoiaren akzioak
	    btnAldatuErabiltzaileDatu.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    		
	    		String NAN = textNAN2.getText().toUpperCase();
	    		String izena = textIzena2.getText();
	    		String abizena = textAbizena2.getText();
	    		String pasahitza = textPasahitza2.getText();
	    		Date jaiotzeData;
	    		String jaiotzeDataString = "";
	    		try {
	    			jaiotzeData = dateJaiotzaData2.getDate();
	    			jaiotzeDataString = sdf.format(jaiotzeData);
	    		} catch (NullPointerException ex) {
	    		    System.err.println("Ez da datarik aukeratu");
	    		}
	    		String herrialdea = textHerrialdea2.getText();
	    		String probintzia = textProbintzia2.getText();
	    		String herria = textHerria2.getText();
	    		String postaKodea = textPostaKodea2.getText();
	    		String telefonoZbk = textTelefonoa2.getText();

	    		if(balidazioak.baliozkoEremuak(NAN, izena, abizena, pasahitza, jaiotzeDataString, herrialdea, probintzia, herria, postaKodea, telefonoZbk)) {
	    			if(datuBaseEraldaketak.erabiltzaileUpdate(NAN, izena, pasahitza, herrialdea, probintzia, herria, postaKodea, telefonoZbk)) {
		    			JOptionPane.showMessageDialog(erregistratu, textIzena2.getText()+ ", aldaketak zuzen gorde dira.", "Elorrieta Kasinoa �"	, JOptionPane.INFORMATION_MESSAGE);
		    			windowBuilder.btn3secDelay(jokoak, 0, erabiltzaileDatuak);
		    	    	setTitle("Jokoak | Elorrieta Kasinoa �");
		    	    	momentukoErabiltzaileNAN = NAN;
	    			} else {
		    	    	JOptionPane.showMessageDialog(erregistratu, NAN + ", ezin izan dira aldaketak egin", "Elorrieta Kasinoa �", JOptionPane.ERROR_MESSAGE);
		    	    }
	    		}
	    	}
	    });
	    
	    btnBlokeatuKontua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   String[] botoiak = {"Bai", "Ez"};
			        
			        int baja = JOptionPane.showOptionDialog(null, "Ziur zaude zure kontua blokeatu nahi duzula?", "Konfirmazio mezua", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoiak, botoiak[0]);
			        
			        if (baja == JOptionPane.YES_OPTION) {
			        	datuBaseEraldaketak.erabiltzaileMailaUpdate(momentukoErabiltzaileNAN, 2);
			            windowBuilder.btn3secDelay(login, 0, erabiltzaileDatuak);
			        } else {
			            System.out.println("Ados");
			        }
			}
		});
	    
		//'bukatu img' botoia 'langilePanela' panelean dagoena. Aplikazioa bukatzen du.
	    itxiLangilePanela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	    
	    btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowBuilder.btn3secDelay(login, 0, langilePanela);
			}
		});
	}
}