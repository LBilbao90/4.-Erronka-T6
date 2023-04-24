package Ikuspegia;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class lehenLehioa extends JFrame {

	private JPanel contentPane;
	private JTextField txtErabiltzailea;

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
	    
	    sarrera.setVisible(true);
	    
	    
	    JPanel login = new JPanel();
	    contentPane.add(login);
	    login.setLayout(null);
	    
	    txtErabiltzailea = new JTextField();
	    txtErabiltzailea.setBounds(133, 255, 583, 69);
	    txtErabiltzailea.setText("ERABILTZAILEA:");
	    txt1.setFont(new Font("Tahoma", Font.BOLD, 50));

	    login.add(txtErabiltzailea);
	    txtErabiltzailea.setColumns(10);

	}
}

