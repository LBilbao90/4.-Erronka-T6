package Ikuspegia;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
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
	    this.setExtendedState(Frame.MAXIMIZED_BOTH);
	    setResizable(true);

	    Image img = new ImageIcon(this.getClass().getResource("/elorrieta_kasinoa.png")).getImage();

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 3000, 1100);
	    
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(new CardLayout(0, 0));

	    //SARRERA
	    JPanel sarrera = new JPanel();
	    sarrera.setBounds(5, 5, 484, 314);
	    contentPane.add(sarrera);

	    JLabel logoa = new JLabel("");
	    logoa.setBounds(750, 0, 500, 500);
	    logoa.setIcon(new ImageIcon(img));

	    JLabel txt1 = new JLabel("Ongi Etorri!");
	    txt1.setHorizontalAlignment(SwingConstants.CENTER);
	    txt1.setBounds(821, 604, 291, 61);
	    txt1.setFont(new Font("Tahoma", Font.BOLD, 50));
	    sarrera.setLayout(null);

	    sarrera.add(logoa);
	    sarrera.add(txt1);
	    
	    JButton btnSarrera = new JButton("");
	    btnSarrera.setOpaque(false);
	    btnSarrera.setContentAreaFilled(false);
	    btnSarrera.setBorderPainted(false);	   
	    btnSarrera.setBounds(0, 0, 1914, 1026);
	    sarrera.add(btnSarrera);
	    	    
	    
	    JPanel login = new JPanel();
	    login.setBorder(null);
	    contentPane.add(login);
	    login.setLayout(null);
	    
	    txtErabiltzailea = new JTextField();
	    txtErabiltzailea.setEditable(false);
	    txtErabiltzailea.setBorder(null);
	    txtErabiltzailea.setBounds(359, 247, 583, 69);
	    txtErabiltzailea.setText("ERABILTZAILEA:");
	    txtErabiltzailea.setFont(new Font("Tahoma", Font.BOLD, 65));
	    
	    txtPasahitza = new JTextField();
	    txtPasahitza.setEditable(false);
	    txtPasahitza.setBorder(null);
	    txtPasahitza.setBounds(359, 450, 583, 69);
	    txtPasahitza.setText("PASAHITZA:");
	    txtPasahitza.setFont(new Font("Tahoma", Font.BOLD, 65));


	    login.add(txtErabiltzailea);
	    login.add(txtPasahitza);
	    
	    textErregistratu = new JTextField();
	    textErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    textErregistratu.setEditable(false);
	    textErregistratu.setBorder(null);
	    textErregistratu.setText("Ez daukazu kontua? ");
	    textErregistratu.setBounds(594, 541, 288, 201);
	    login.add(textErregistratu);
	    textErregistratu.setColumns(10);
	    
	    JButton btnEzErregistratua = new JButton("Erregistratu hemen klik eginez");
	    btnEzErregistratua.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    btnEzErregistratua.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnEzErregistratua.setForeground(new Color(0, 0, 255));
	    btnEzErregistratua.setBorder(null);
	    btnEzErregistratua.setBackground(new Color(255, 255, 255));
	    btnEzErregistratua.setBounds(872, 607, 435, 69);
	    login.add(btnEzErregistratua);
	    
	    passwordLogin = new JPasswordField();
	    passwordLogin.setFont(new Font("Tahoma", Font.PLAIN, 60));
	    passwordLogin.setBorder(new LineBorder(new Color(171, 173, 179)));
	    passwordLogin.setBounds(952, 450, 813, 69);
	    login.add(passwordLogin);
	    
	    JTextArea textErabiltzailea = new JTextArea();
	    textErabiltzailea.setFont(new Font("Monospaced", Font.PLAIN, 60));
	    textErabiltzailea.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textErabiltzailea.setBounds(952, 247, 813, 69);
	    login.add(textErabiltzailea);
	    
	    JPanel erregistratu = new JPanel();
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

