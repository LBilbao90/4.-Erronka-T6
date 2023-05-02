package Ikuspegia;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontrolatzailea.metodoak;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

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
//	private JTextField txtErrepikatuPasahitza;
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
	private JTextArea textErrepikatuPasahitza;
	private JTextArea textJaiotzeData;
	private JTextArea textHerrialdea;
	private JTextArea textProbintzia;
	private JTextArea textHerria;
	private JTextArea textPostaKodea;
	private JTextArea textTelefonoa;
	private JTextField textJokoak;
	
    private ImageIcon irtenImg = new ImageIcon("img/bukatu.png");
    private ImageIcon atzeraGezia = new ImageIcon("img/atzeraGezia.png");
    private ImageIcon begiaBai = new ImageIcon("img/begiaBai.png");
    private ImageIcon begiaEz = new ImageIcon("img/begiaEz.png");
	
	// Pantailaren dimentsioak lortu
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = (int) (screenSize.height * 0.75);
	int screenWidth = (int) (screenSize.width * 0.75);

//    ruletaApostua ruleta = new ruletaApostua();

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
					lehenLehioaframe.setUndecorated(true);

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
	    
	    setTitle("Elorrieta Kasinoa ©");
	    
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

	    // Restricciones para el botón
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
	    txtErabiltzailea.setText("ERABILTZAILEA:");
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
	    txtNAN = metodoak.createTextFieldTestua("NAN:", (int) (screenWidth*0.07), (int) (screenHeight*0.22), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtIzena = metodoak.createTextFieldTestua("Izena:", (int) (screenWidth*0.07), (int) (screenHeight*0.32), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtAbizena = metodoak.createTextFieldTestua("Abizena:", (int) (screenWidth*0.07), (int) (screenHeight*0.42), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtPasahitzaErregistratu = metodoak.createTextFieldTestua("Pasahitza:", (int) (screenWidth*0.07), (int) (screenHeight*0.52), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtJaiotzeData = metodoak.createTextFieldTestua("Jaiotze data:", (int) (screenWidth*0.07), (int) (screenHeight*0.62), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtHerrialdea = metodoak.createTextFieldTestua("Herrialdea:", (int) (screenWidth*0.52), (int) (screenHeight*0.22), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtProbintzia = metodoak.createTextFieldTestua("Probintzia:", (int) (screenWidth*0.52), (int) (screenHeight*0.32), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtHerria = metodoak.createTextFieldTestua("Herria:", (int) (screenWidth*0.52), (int) (screenHeight*0.42), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtPostaKodea = metodoak.createTextFieldTestua("Posta kodea:", (int) (screenWidth*0.52), (int) (screenHeight*0.52), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);
	    txtTelefonoa = metodoak.createTextFieldTestua("Telefonoa:", (int) (screenWidth*0.52), (int) (screenHeight*0.62), (int) (screenWidth*0.17), 25, new Font("Tahoma", Font.PLAIN, 30), erregistratu);	
	    
	    //erregistroa betetzeko textField
	    textNAN = metodoak.createTextFieldBete((int) (screenWidth*0.25), (int) (screenHeight*0.215), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textIzena = metodoak.createTextFieldBete((int) (screenWidth*0.25), (int) (screenHeight*0.315), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textAbizena = metodoak.createTextFieldBete((int) (screenWidth*0.25), (int) (screenHeight*0.415), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textPasahitzaErregistratu = metodoak.createPasswordFieldBete((int) (screenWidth*0.25), (int) (screenHeight*0.515), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
//	    textErrepikatuPasahitza = metodoak.createTextFieldBete(73, 437, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textJaiotzeData = metodoak.createTextFieldBete((int) (screenWidth*0.25), (int) (screenHeight*0.615), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textHerrialdea = metodoak.createTextFieldBete((int) (screenWidth*0.72), (int) (screenHeight*0.215), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textProbintzia = metodoak.createTextFieldBete((int) (screenWidth*0.72), (int) (screenHeight*0.315), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textHerria = metodoak.createTextFieldBete((int) (screenWidth*0.72), (int) (screenHeight*0.415), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textPostaKodea = metodoak.createTextFieldBete((int) (screenWidth*0.72), (int) (screenHeight*0.515), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);
	    textTelefonoa = metodoak.createTextFieldBete((int) (screenWidth*0.72), (int) (screenHeight*0.615), (int) (screenWidth*0.20), 30, new Font("Tahoma", Font.PLAIN, 25), erregistratu);	
	    
	    //erregistroko textFieldak borde beltzarekin
	    textNAN.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textIzena.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textAbizena.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textPasahitzaErregistratu.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textJaiotzeData.setBorder(new LineBorder(new Color(0, 0, 0)));
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
	    
	    metodoak.createTextFieldTestua("(Bete itzazu aurreko eremuak guztiak erregistratu ahal izateko)", (int) (screenWidth*0.54), (int) (screenHeight*0.75), (int) (screenWidth*0.40), 40, new Font("Tahoma", Font.PLAIN, 15), erregistratu);
	   
	    //Jokoak panela
	    JPanel jokoak = new JPanel();
	    jokoak.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(jokoak);
	    jokoak.setLayout(null);
	    
	    JButton itxiJokoak = new JButton("");
	    ImageIcon irtenImg = new ImageIcon("img/bukatu.png");
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

		btnSarrera.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            metodoak.btn3secDelay(login, 2, sarrera, login, erregistratu, jokoak, e);
	            setTitle("Hasi saioa | Elorrieta Kasinoa ©");
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
	            metodoak.btn3secDelay(erregistratu, 0, sarrera, login, erregistratu, jokoak, e);
	            setTitle("Erregistroa | Elorrieta Kasinoa ©");
	            }
	        });
		
		//Login botoia akzioak
		btnLogin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    if (textErabiltzailea.getText().equals("") || passwordLogin.getText().equals("")) {
	    	    	JOptionPane.showMessageDialog(erregistratu, "Erabiltzaile edo pasahitz okerra", "Elorrieta Kasinoa ©", JOptionPane.ERROR_MESSAGE);
	    	    	} else {
	    	    		metodoak.btn3secDelay(jokoak, 0, sarrera, login, erregistratu, jokoak, e);
	    	    		setTitle("Jokoak | Elorrieta Kasinoa ©");
	    	    		}
	    	    }
	    	});
		
		btnLoginBuelta.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    	metodoak.btn3secDelay(login, 0, sarrera, login, erregistratu, jokoak, e);
	    	    	setTitle("Hasi saioa | Elorrieta Kasinoa ©");
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
	    	    if (textNAN.getText().equals("") || textIzena.getText().equals("") || textAbizena.getText().equals("") || textPasahitzaErregistratu.getText().equals("") || textJaiotzeData.getText().equals("") || textHerria.getText().equals("") || textProbintzia.getText().equals("") || textHerria.getText().equals("") || textPostaKodea.getText().equals("") || textTelefonoa.getText().equals("")) {
	    	    	JOptionPane.showMessageDialog(erregistratu, "Mesedez, bete aurreko eremu guztiak", "Elorrieta Kasinoa ©", JOptionPane.ERROR_MESSAGE);
	    	    } else {
	    	    	JOptionPane.showMessageDialog(erregistratu, textIzena.getText()+ ", zure kontua zuzen sortu da", "Elorrieta Kasinoa ©", JOptionPane.INFORMATION_MESSAGE);
	    	    	metodoak.btn3secDelay(jokoak, 0, sarrera, login, erregistratu, jokoak, e);
	    	    	setTitle("Jokoak | Elorrieta Kasinoa ©");
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
	    		metodoak.btn3secDelay(login, 0, sarrera, login, erregistratu, jokoak, e);
	    		setTitle("Hasi saioa | Elorrieta Kasinoa ©");
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
    	    	JOptionPane.showMessageDialog(jokoak, "Laster egongo da prest, barkatu eragozpenak.\r\n", "Elorrieta Kasinoa ©", JOptionPane.WARNING_MESSAGE);
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
				metodoak.btn3secDelay(jokoak, 0, sarrera, login, erregistratu, jokoak, null);
			}
		});	
	}
}