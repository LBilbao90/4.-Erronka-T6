package Ikuspegia;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Kontrolatzailea.metodoak;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;

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
	private JTextField txtErrepikatuPasahitza;
	private JTextField txtJaiotzeData;
	private JTextField txtHerrialdea;
	private JTextField txtProbintzia;
	private JTextField txtHerria;
	private JTextField txtPostaKodea;
	private JTextField txtTelefonoa;
	private JTextArea textNAN;
	private JTextArea textIzena;
	private JTextArea textAbizena;
	private JTextArea textPasahitzaErregistratu;
	private JTextArea textErrepikatuPasahitza;
	private JTextArea textJaiotzeData;
	private JTextArea textHerrialdea;
	private JTextArea textProbintzia;
	private JTextArea textHerria;
	private JTextArea textPostaKodea;
	private JTextArea textTelefonoa;
	
	// Pantailaren dimentsioak lortu
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = (int) (screenSize.height * 0.75);
	int screenWidth = (int) (screenSize.width * 0.75);

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lehenLehioa frame = new lehenLehioa();
					frame.setVisible(true);
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
	    //Pantaila handian agertu ahal izateko
	    setResizable(false);
	    
	 // Lehen lehioaren dimentsioak aldatu
		setBounds((screenSize.width - screenWidth) / 2, (screenSize.height - screenHeight) / 2, screenWidth, screenHeight);

	    Image img = new ImageIcon(this.getClass().getResource("/elorrieta_kasinoa.png")).getImage();

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
	    JLabel logoa = new JLabel(new ImageIcon(img));
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
	    txtErabiltzailea.setBounds((int) (screenWidth*0.10), (int) (screenHeight*0.15), (int) (screenWidth*0.25), 69);
	    txtErabiltzailea.setText("ERABILTZAILEA:");
	    txtErabiltzailea.setFont(new Font("Tahoma", Font.BOLD, 30));
	    
	    txtPasahitza = new JTextField();
	    txtPasahitza.setEditable(false);
	    txtPasahitza.setBorder(null);
	    txtPasahitza.setBounds((int) (screenWidth*0.10), (int) (screenHeight*0.30), (int) (screenWidth*0.25), 69);
	    txtPasahitza.setText("PASAHITZA:");
	    txtPasahitza.setFont(new Font("Tahoma", Font.BOLD, 30));


	    login.add(txtErabiltzailea);
	    login.add(txtPasahitza);
	    
	    textErregistratu = new JTextField();
	    textErregistratu.setEditable(false);
	    textErregistratu.setBorder(null);
	    textErregistratu.setBounds ((int) (screenWidth*0.24), (int) (screenHeight*0.41), (int) (screenWidth*0.23), 75);
	    textErregistratu.setText("Ez daukazu kontua? ");
	    textErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    
	    textErregistratu.setColumns(10);
	    
	    JButton btnEzErregistratua = new JButton("Erregistratu hemen klik eginez");
	    btnEzErregistratua.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    btnEzErregistratua.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnEzErregistratua.setForeground(new Color(0, 0, 255));
	    btnEzErregistratua.setBorder(null);
	    btnEzErregistratua.setBackground(new Color(255, 255, 255));
	    btnEzErregistratua.setOpaque(false); // transparente
	    btnEzErregistratua.setBounds((int) (screenWidth*0.45), (int) (screenHeight*0.41), (int) (screenWidth*0.35), 75);
	    login.add(btnEzErregistratua);
	    login.add(textErregistratu);
	    
	    passwordLogin = new JPasswordField();
	    passwordLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    passwordLogin.setBorder(new LineBorder(new Color(171, 173, 179)));
	    passwordLogin.setBounds((int) (screenWidth*0.36), (int) (screenHeight*0.32), (int) (screenWidth*0.35), 40);
	    login.add(passwordLogin);
	    
	    JTextArea textErabiltzailea = new JTextArea();
	    textErabiltzailea.setFont(new Font("Monospaced", Font.PLAIN, 30));
	    textErabiltzailea.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textErabiltzailea.setBounds((int) (screenWidth*0.36), (int) (screenHeight*0.17), (int) (screenWidth*0.35), 40);
	    login.add(textErabiltzailea);
	    
	    JPanel erregistratu = new JPanel();
	    erregistratu.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(erregistratu);
	    erregistratu.setLayout(null);
	    
	    txtNAN = metodoak.createTextFieldTestua("NAN:", 73, 157, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtIzena = metodoak.createTextFieldTestua("Izena:", 73, 227, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtAbizena = metodoak.createTextFieldTestua("Abizena:", 73, 297, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtPasahitzaErregistratu = metodoak.createTextFieldTestua("Pasahitza:", 73, 367, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtErrepikatuPasahitza = metodoak.createTextFieldTestua("Errepikatu pasahitza:", 73, 437, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtJaiotzeData = metodoak.createTextFieldTestua("Jaiotze data:", 73, 507, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtHerrialdea = metodoak.createTextFieldTestua("Herrialdea:", 73, 577, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtProbintzia = metodoak.createTextFieldTestua("Probintzia:", 73, 647, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtHerria = metodoak.createTextFieldTestua("Herria:", 73, 717, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtPostaKodea = metodoak.createTextFieldTestua("Posta kodea:", 73, 786, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    txtTelefonoa = metodoak.createTextFieldTestua("Telefonoa:", 73, 855, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);	
	    
	    textNAN = metodoak.createTextFieldBete(73, 157, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textIzena = metodoak.createTextFieldBete(73, 227, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textAbizena = metodoak.createTextFieldBete(73, 297, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textPasahitzaErregistratu = metodoak.createTextFieldBete(73, 367, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textErrepikatuPasahitza = metodoak.createTextFieldBete(73, 437, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textJaiotzeData = metodoak.createTextFieldBete(73, 507, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textHerrialdea = metodoak.createTextFieldBete(73, 577, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textProbintzia = metodoak.createTextFieldBete(73, 647, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textHerria = metodoak.createTextFieldBete(73, 717, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textPostaKodea = metodoak.createTextFieldBete(73, 786, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);
	    textTelefonoa = metodoak.createTextFieldBete(73, 855, 382, 59, new Font("Tahoma", Font.PLAIN, 40), erregistratu);	
	    
	    JPanel ruleta = new JPanel();
	    ruleta.setBounds(0, 0, screenWidth, screenHeight);
	    contentPane.add(ruleta, "name_9328358650800");
	    

	
		btnSarrera.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            metodoak.btn3secDelay(login, 2, sarrera, login, erregistratu, e);
	        }
		});	
		
		btnEzErregistratua.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            metodoak.btn3secDelay(erregistratu, 0, sarrera, login, erregistratu, e);
	        }
		});	
	}
}