package Ikuspegia;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ikuspegia.ruletaJokoa.OKButtonListener;
import Kontrolatzailea.metodoak;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;

public class ruletaApostua extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    ruletaJokoa ruleta = new ruletaJokoa();
    private int apostuOrain;
    private int pertsonaApostuMax = 1000;
    private boolean blokeatu = false;

    // 37 sortzen ditugu, taulan 0 tik 36 zenbaki daudelako.
    private int[] zbk = new int[37];
    private int[] dozenak = new int [3];
    private int[] dozenakEskerrEskuin = new int [3];	
    private int[] taulaErdia = new int [2];
    private int[] bakoitiBikoiti = new int [2];
    private int[] kolorea = new int [2];
    
    Set<Integer> gorriak = new HashSet<>(List.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
    Set<Integer> beltzak = new HashSet<>(List.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35));
    
    Set<Integer> eskerrEskuin1 = new HashSet<>(List.of(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34));
    Set<Integer> eskerrEskuin2 = new HashSet<>(List.of(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35));
    Set<Integer> eskerrEskuin3 = new HashSet<>(List.of(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36));
    private int ruletaEmaitza;
    
    Date momentukoData = new Date();

    SimpleDateFormat formaData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String denboraOrduaMomentukoa = formaData.format(momentukoData);
    
    String emaitzaApostu;
    Timer timer = new Timer();

    private static btnJokoetaraBueltatuListener btnJokoetaraBueltatuListener;

    public interface btnJokoetaraBueltatuListener {
        void onJokoetaraBueltatu();
    }

    public static void setBtnJokoetaraBueltatuListener(btnJokoetaraBueltatuListener listener) {
        btnJokoetaraBueltatuListener = listener;
    }
    
    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ruletaApostua frame = new ruletaApostua();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public ruletaApostua() {
		
		setTitle("Apostua | Ruleta | Elorrieta Kasinoa ©");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Talde bat sortu 'rdbtnApostuXX' guztiak batera funtzionatzeko.
		ButtonGroup apostuKantitatea = new ButtonGroup();
		
		JRadioButton rdbtnApostu10 = new JRadioButton("10");
		rdbtnApostu10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnApostu10.setBounds(10, 48, 67, 21);
		apostuKantitatea.add(rdbtnApostu10);
		contentPane.add(rdbtnApostu10);
		
		JRadioButton rdbtnApostu20 = new JRadioButton("20");
		rdbtnApostu20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnApostu20.setBounds(88, 48, 67, 21);
		apostuKantitatea.add(rdbtnApostu20);
		contentPane.add(rdbtnApostu20);
		
		JRadioButton rdbtnApostu50 = new JRadioButton("50");
		rdbtnApostu50.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnApostu50.setBounds(157, 48, 67, 21);
		apostuKantitatea.add(rdbtnApostu50);
		contentPane.add(rdbtnApostu50);
		
		JRadioButton rdbtnApostu100 = new JRadioButton("100");
		rdbtnApostu100.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnApostu100.setBounds(232, 48, 67, 21);
		apostuKantitatea.add(rdbtnApostu100);
		contentPane.add(rdbtnApostu100);
		
		JRadioButton rdbtnApostu500 = new JRadioButton("500");
		rdbtnApostu500.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnApostu500.setBounds(322, 48, 67, 21);
		apostuKantitatea.add(rdbtnApostu500);
		contentPane.add(rdbtnApostu500);
		
		JRadioButton rdbtnApostu1000 = new JRadioButton("1000");
		rdbtnApostu1000.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnApostu1000.setBounds(415, 48, 78, 21);
		apostuKantitatea.add(rdbtnApostu1000);
		contentPane.add(rdbtnApostu1000);
		
		JButton btn_zbk_36 = new JButton("");
		btn_zbk_36.setOpaque(false);
		btn_zbk_36.setBorder(null);
		btn_zbk_36.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_36.setBounds(495, 185, 32, 47);
		contentPane.add(btn_zbk_36);
		
		JButton btn_zbk_35 = new JButton("");
		btn_zbk_35.setOpaque(false);
		btn_zbk_35.setBorder(null);
		btn_zbk_35.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_35.setBounds(495, 233, 32, 47);
		contentPane.add(btn_zbk_35);
		
		JButton btn_zbk_34 = new JButton("");
		btn_zbk_34.setOpaque(false);
		btn_zbk_34.setBorder(null);
		btn_zbk_34.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_34.setBounds(495, 281, 32, 47);
		contentPane.add(btn_zbk_34);
		
		JButton btn_zbk_33 = new JButton("");
		btn_zbk_33.setOpaque(false);
		btn_zbk_33.setBorder(null);
		btn_zbk_33.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_33.setBounds(461, 186, 32, 47);
		contentPane.add(btn_zbk_33);
		
		JButton btn_zbk_32 = new JButton("");
		btn_zbk_32.setOpaque(false);
		btn_zbk_32.setBorder(null);
		btn_zbk_32.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_32.setBounds(461, 234, 32, 47);
		contentPane.add(btn_zbk_32);
		
		JButton btn_zbk_31 = new JButton("");
		btn_zbk_31.setOpaque(false);
		btn_zbk_31.setBorder(null);
		btn_zbk_31.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_31.setBounds(461, 282, 32, 47);
		contentPane.add(btn_zbk_31);
		
		JButton btn_zbk_30 = new JButton("");
		btn_zbk_30.setOpaque(false);
		btn_zbk_30.setBorder(null);
		btn_zbk_30.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_30.setBounds(426, 185, 32, 47);
		contentPane.add(btn_zbk_30);
		
		JButton btn_zbk_29 = new JButton("");
		btn_zbk_29.setOpaque(false);
		btn_zbk_29.setBorder(null);
		btn_zbk_29.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_29.setBounds(426, 233, 32, 47);
		contentPane.add(btn_zbk_29);
		
		JButton btn_zbk_28 = new JButton("");
		btn_zbk_28.setOpaque(false);
		btn_zbk_28.setBorder(null);
		btn_zbk_28.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_28.setBounds(426, 281, 32, 47);
		contentPane.add(btn_zbk_28);
		
		JButton btn_zbk_27 = new JButton("");
		btn_zbk_27.setOpaque(false);
		btn_zbk_27.setBorder(null);
		btn_zbk_27.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_27.setBounds(392, 186, 32, 47);
		contentPane.add(btn_zbk_27);
		
		JButton btn_zbk_26 = new JButton("");
		btn_zbk_26.setOpaque(false);
		btn_zbk_26.setBorder(null);
		btn_zbk_26.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_26.setBounds(392, 234, 32, 47);
		contentPane.add(btn_zbk_26);
		
		JButton btn_zbk_25 = new JButton("");
		btn_zbk_25.setOpaque(false);
		btn_zbk_25.setBorder(null);
		btn_zbk_25.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_25.setBounds(392, 282, 32, 47);
		contentPane.add(btn_zbk_25);
		
		JButton btn_zbk_24 = new JButton("");
		btn_zbk_24.setOpaque(false);
		btn_zbk_24.setBorder(null);
		btn_zbk_24.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_24.setBounds(357, 185, 32, 47);
		contentPane.add(btn_zbk_24);
		
		JButton btn_zbk_23 = new JButton("");
		btn_zbk_23.setOpaque(false);
		btn_zbk_23.setBorder(null);
		btn_zbk_23.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_23.setBounds(357, 233, 32, 47);
		contentPane.add(btn_zbk_23);
		
		JButton btn_zbk_22 = new JButton("");
		btn_zbk_22.setOpaque(false);
		btn_zbk_22.setBorder(null);
		btn_zbk_22.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_22.setBounds(357, 281, 32, 47);
		contentPane.add(btn_zbk_22);
		
		JButton btn_zbk_21 = new JButton("");
		btn_zbk_21.setOpaque(false);
		btn_zbk_21.setBorder(null);
		btn_zbk_21.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_21.setBounds(323, 186, 32, 47);
		contentPane.add(btn_zbk_21);
		
		JButton btn_zbk_20 = new JButton("");
		btn_zbk_20.setOpaque(false);
		btn_zbk_20.setBorder(null);
		btn_zbk_20.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_20.setBounds(323, 234, 32, 47);
		contentPane.add(btn_zbk_20);
		
		JButton btn_zbk_19 = new JButton("");
		btn_zbk_19.setOpaque(false);
		btn_zbk_19.setBorder(null);
		btn_zbk_19.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_19.setBounds(323, 282, 32, 47);
		contentPane.add(btn_zbk_19);
		
		JButton btn_zbk_18 = new JButton("");
		btn_zbk_18.setOpaque(false);
		btn_zbk_18.setBorder(null);
		btn_zbk_18.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_18.setBounds(288, 185, 32, 47);
		contentPane.add(btn_zbk_18);
		
		JButton btn_zbk_17 = new JButton("");
		btn_zbk_17.setOpaque(false);
		btn_zbk_17.setBorder(null);
		btn_zbk_17.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_17.setBounds(288, 233, 32, 47);
		contentPane.add(btn_zbk_17);
		
		JButton btn_zbk_16 = new JButton("");
		btn_zbk_16.setOpaque(false);
		btn_zbk_16.setBorder(null);
		btn_zbk_16.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_16.setBounds(288, 281, 32, 47);
		contentPane.add(btn_zbk_16);
		
		JButton btn_zbk_15 = new JButton("");
		btn_zbk_15.setOpaque(false);
		btn_zbk_15.setBorder(null);
		btn_zbk_15.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_15.setBounds(254, 186, 32, 47);
		contentPane.add(btn_zbk_15);
		
		JButton btn_zbk_14 = new JButton("");
		btn_zbk_14.setOpaque(false);
		btn_zbk_14.setBorder(null);
		btn_zbk_14.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_14.setBounds(254, 234, 32, 47);
		contentPane.add(btn_zbk_14);
		
		JButton btn_zbk_13 = new JButton("");
		btn_zbk_13.setOpaque(false);
		btn_zbk_13.setBorder(null);
		btn_zbk_13.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_13.setBounds(254, 282, 32, 47);
		contentPane.add(btn_zbk_13);
		
		JButton btn_zbk_12 = new JButton("");
		btn_zbk_12.setOpaque(false);
		btn_zbk_12.setBorder(null);
		btn_zbk_12.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_12.setBounds(220, 185, 32, 47);
		contentPane.add(btn_zbk_12);
		
		JButton btn_zbk_11 = new JButton("");
		btn_zbk_11.setOpaque(false);
		btn_zbk_11.setBorder(null);
		btn_zbk_11.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_11.setBounds(220, 233, 32, 47);
		contentPane.add(btn_zbk_11);
		
		JButton btn_zbk_10 = new JButton("");
		btn_zbk_10.setOpaque(false);
		btn_zbk_10.setBorder(null);
		btn_zbk_10.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_10.setBounds(220, 281, 32, 47);
		contentPane.add(btn_zbk_10);
		
		JButton btn_zbk_9 = new JButton("");
		btn_zbk_9.setOpaque(false);
		btn_zbk_9.setBorder(null);
		btn_zbk_9.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_9.setBounds(186, 186, 32, 47);
		contentPane.add(btn_zbk_9);
		
		JButton btn_zbk_8 = new JButton("");
		btn_zbk_8.setOpaque(false);
		btn_zbk_8.setBorder(null);
		btn_zbk_8.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_8.setBounds(186, 234, 32, 47);
		contentPane.add(btn_zbk_8);
		
		JButton btn_zbk_7 = new JButton("");
		btn_zbk_7.setOpaque(false);
		btn_zbk_7.setBorder(null);
		btn_zbk_7.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_7.setBounds(186, 282, 32, 47);
		contentPane.add(btn_zbk_7);
		
		JButton btn_zbk_6 = new JButton("");
		btn_zbk_6.setOpaque(false);
		btn_zbk_6.setBorder(null);
		btn_zbk_6.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_6.setBounds(151, 185, 32, 47);
		contentPane.add(btn_zbk_6);
		
		JButton btn_zbk_5 = new JButton("");
		btn_zbk_5.setOpaque(false);
		btn_zbk_5.setBorder(null);
		btn_zbk_5.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_5.setBounds(151, 233, 32, 47);
		contentPane.add(btn_zbk_5);
		
		JButton btn_zbk_4 = new JButton("");
		btn_zbk_4.setOpaque(false);
		btn_zbk_4.setBorder(null);
		btn_zbk_4.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_4.setBounds(151, 281, 32, 47);
		contentPane.add(btn_zbk_4);
		
		JButton btn_zbk_3 = new JButton("");
		btn_zbk_3.setOpaque(false);
		btn_zbk_3.setBorder(null);
		btn_zbk_3.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_3.setBounds(117, 186, 32, 47);
		contentPane.add(btn_zbk_3);
		
		JButton btn_zbk_2 = new JButton("");
		btn_zbk_2.setOpaque(false);
		btn_zbk_2.setBorder(null);
		btn_zbk_2.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_2.setBounds(117, 234, 32, 47);
		contentPane.add(btn_zbk_2);

		JButton btn_zbk_1 = new JButton("");
		btn_zbk_1.setOpaque(false);
		btn_zbk_1.setBorder(null);
		btn_zbk_1.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_1.setBounds(117, 282, 32, 47);
		contentPane.add(btn_zbk_1);
		
		JButton btn_zbk_0 = new JButton("");
		btn_zbk_0.setOpaque(false);
		btn_zbk_0.setBackground(new Color(0, 0, 0, 0));
		btn_zbk_0.setBounds(66, 185, 49, 144);
		btn_zbk_0.setBorder(null);
		contentPane.add(btn_zbk_0);
		
		JButton btn_3_36 = new JButton("");
		btn_3_36.setOpaque(false);
		btn_3_36.setBackground(new Color(0, 0, 0, 0));
		btn_3_36.setBounds(529, 185, 33, 47);
		btn_3_36.setBorder(null);
		contentPane.add(btn_3_36);
		
		JButton btn_2_35 = new JButton("");
		btn_2_35.setOpaque(false);
		btn_2_35.setBackground(new Color(0, 0, 0, 0));
		btn_2_35.setBounds(529, 233, 33, 47);
		btn_2_35.setBorder(null);
		contentPane.add(btn_2_35);
		
		JButton btn_1_34 = new JButton("");
		btn_1_34.setOpaque(false);
		btn_1_34.setBackground(new Color(0, 0, 0, 0));
		btn_1_34.setBounds(529, 282, 33, 47);
		btn_1_34.setBorder(null);
		contentPane.add(btn_1_34);
		
		JButton btn_25_36 = new JButton("");
		btn_25_36.setOpaque(false);
		btn_25_36.setBackground(new Color(0, 0, 0, 0));
		btn_25_36.setBounds(392, 329, 136, 37);
		btn_25_36.setBorder(null);
		contentPane.add(btn_25_36);

		JButton btn_13_24 = new JButton("");
		btn_13_24.setOpaque(false);
		btn_13_24.setBackground(new Color(0, 0, 0, 0));
		btn_13_24.setBounds(254, 329, 136, 37);
		btn_13_24.setBorder(null);
		contentPane.add(btn_13_24);

		JButton btn_1_12 = new JButton("");
		btn_1_12.setOpaque(false);
		btn_1_12.setBackground(new Color(0, 0, 0, 0));
		btn_1_12.setBounds(117, 329, 136, 37);
		btn_1_12.setBorder(null);
		contentPane.add(btn_1_12);
		
		JButton btn_beltzak = new JButton("");
		btn_beltzak.setOpaque(false);
		btn_beltzak.setBackground(new Color(0, 0, 0, 0));
		btn_beltzak.setBounds(323, 365, 67, 37);
		btn_beltzak.setBorder(null);
		contentPane.add(btn_beltzak);

		JButton btn_gorriak = new JButton("");
		btn_gorriak.setOpaque(false);
		btn_gorriak.setBackground(new Color(0, 0, 0, 0));
		btn_gorriak.setBounds(254, 365, 67, 37);
		btn_gorriak.setBorder(null);
		contentPane.add(btn_gorriak);

		JButton btn_odd = new JButton("");
		btn_odd.setOpaque(false);
		btn_odd.setBackground(new Color(0, 0, 0, 0));
		btn_odd.setBounds(392, 365, 67, 37);
		btn_odd.setBorder(null);
		contentPane.add(btn_odd);

		JButton btn_even = new JButton("");
		btn_even.setOpaque(false);
		btn_even.setBackground(new Color(0, 0, 0, 0));
		btn_even.setBounds(186, 365, 67, 37);
		btn_even.setBorder(null);
		contentPane.add(btn_even);
		
		JButton btn_19_36 = new JButton("");
		btn_19_36.setOpaque(false);
		btn_19_36.setBackground(new Color(0, 0, 0, 0));
		btn_19_36.setBounds(461, 365, 67, 37);
		btn_19_36.setBorder(null);
		contentPane.add(btn_19_36);

		JButton btn_1_18 = new JButton("");
		btn_1_18.setOpaque(false);
		btn_1_18.setBackground(new Color(0, 0, 0, 0));
		btn_1_18.setBounds(117, 365, 67, 37);
		btn_1_18.setBorder(null);
		contentPane.add(btn_1_18);
		
		JButton btnApostuaEzabatu = new JButton("Apostuak ezabatu");
		btnApostuaEzabatu.setBounds(641, 341, 136, 50);
		btnApostuaEzabatu.setEnabled(false);
		contentPane.add(btnApostuaEzabatu);
		
		// 'lehenLehioa' klaseko 'jokuak' lehiora bueltatzen da botoia exekutatzean.
		JButton btnJokoetaraBueltatu = new JButton("Jokoetara Buelta");
		btnJokoetaraBueltatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnJokoetaraBueltatuListener != null) {
					btnJokoetaraBueltatuListener.onJokoetaraBueltatu();
					apostuOrain = 0;
					Arrays.fill(zbk, 0);
					Arrays.fill(dozenak, 0);
					Arrays.fill(dozenakEskerrEskuin, 0);
					Arrays.fill(taulaErdia, 0);
					Arrays.fill(bakoitiBikoiti, 0);
					Arrays.fill(kolorea, 0);
					apostuKantitatea.clearSelection();
					}
				}
			});
		
		btnJokoetaraBueltatu.setBounds(641, 137, 136, 50);
		contentPane.add(btnJokoetaraBueltatu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/ruletaTablero.jpg"));
		lblNewLabel.setBounds(10, 137, 627, 313);
		contentPane.add(lblNewLabel);
		   
		JLabel lblNewLabel_1 = new JLabel("Apostu Max: " + pertsonaApostuMax);
		lblNewLabel_1.setBounds(656, 11, 121, 37);
		contentPane.add(lblNewLabel_1);
       
		JButton btnApostuaEgin = new JButton("Apostua bukatu");
		btnApostuaEgin.setEnabled(false);
		btnApostuaEgin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blokeatu = true;
	            // 'ruletaLehioa'aren lehioa sortzen da
	            JFrame ruletaLehioa = new JFrame("Ruleta | Elorrieta Kasinoa ©");
	            
	            ruletaLehioa.getContentPane().add(ruleta);
	            ruletaLehioa.setLocation(900, 150);
	            ruletaLehioa.pack();
	            ruletaLehioa.setVisible(true);
	            ruletaLehioa.setResizable(false);
	            
	            // 'ruletaApostua' klaseko botoi guztiak kblokeatzen ditu. (momentu onetan 'ruletaJokoa' egongo da martxan)
	            if (blokeatu == true) {
					apostuKantitatea.clearSelection();
					rdbtnApostu10.setEnabled(false);
					rdbtnApostu20.setEnabled(false);
					rdbtnApostu50.setEnabled(false);
					rdbtnApostu100.setEnabled(false);
					rdbtnApostu500.setEnabled(false);
					rdbtnApostu1000.setEnabled(false);
	            	btnJokoetaraBueltatu.setEnabled(false);
	    			btnApostuaEgin.setEnabled(false);
	    			btnApostuaEzabatu.setEnabled(false);
	    			btn_1_18.setEnabled(false);
	    			btn_19_36.setEnabled(false);
	    			btn_even.setEnabled(false);
	    			btn_odd.setEnabled(false);
	    			btn_odd.setEnabled(false);
	    			btn_gorriak.setEnabled(false);
	    			btn_beltzak.setEnabled(false);
	    			btn_1_12.setEnabled(false);
	    			btn_13_24.setEnabled(false);
	    			btn_25_36.setEnabled(false);
	    			btn_1_34.setEnabled(false);
	    			btn_2_35.setEnabled(false);
	    			btn_3_36.setEnabled(false);
	    			btn_zbk_0.setEnabled(false);
	    			btn_zbk_1.setEnabled(false);
	    			btn_zbk_2.setEnabled(false);
	    			btn_zbk_3.setEnabled(false);
	    			btn_zbk_4.setEnabled(false);
	    			btn_zbk_5.setEnabled(false);
	    			btn_zbk_6.setEnabled(false);
	    			btn_zbk_7.setEnabled(false);
	    			btn_zbk_8.setEnabled(false);
	    			btn_zbk_9.setEnabled(false);
	    			btn_zbk_10.setEnabled(false);
	    			btn_zbk_11.setEnabled(false);
	    			btn_zbk_12.setEnabled(false);
	    			btn_zbk_13.setEnabled(false);
	    			btn_zbk_14.setEnabled(false);
	    			btn_zbk_15.setEnabled(false);
	    			btn_zbk_16.setEnabled(false);
	    			btn_zbk_17.setEnabled(false);
	    			btn_zbk_18.setEnabled(false);
	    			btn_zbk_19.setEnabled(false);
	    			btn_zbk_20.setEnabled(false);
	    			btn_zbk_21.setEnabled(false);
	    			btn_zbk_22.setEnabled(false);
	    			btn_zbk_23.setEnabled(false);
	    			btn_zbk_24.setEnabled(false);
	    			btn_zbk_25.setEnabled(false);
	    			btn_zbk_26.setEnabled(false);
	    			btn_zbk_27.setEnabled(false);
	    			btn_zbk_28.setEnabled(false);
	    			btn_zbk_29.setEnabled(false);
	    			btn_zbk_30.setEnabled(false);
	    			btn_zbk_31.setEnabled(false);
	    			btn_zbk_32.setEnabled(false);
	    			btn_zbk_33.setEnabled(false);
	    			btn_zbk_34.setEnabled(false);
	    			btn_zbk_35.setEnabled(false);
	    			btn_zbk_36.setEnabled(false);
	    			ruletaJokoa.getBtnBiratu().doClick();
	    		}
	            
	            ruletaJokoa.setOKButtonListener(new OKButtonListener() {
	            	
	            	//ruletaJokoa klasean 'erakutsiMezua' metodoko mezuko 'OK' botoia sakatzean egingo duena.
	            	@Override
					public void onOKButtonPressed() {
						ruletaLehioa.dispose();
						rdbtnApostu10.setEnabled(true);
						rdbtnApostu20.setEnabled(true);
						rdbtnApostu50.setEnabled(true);
						rdbtnApostu100.setEnabled(true);
						rdbtnApostu500.setEnabled(true);
						rdbtnApostu1000.setEnabled(true);
						btnJokoetaraBueltatu.setEnabled(true);
		    			btn_1_18.setEnabled(true);
		    			btn_19_36.setEnabled(true);
		    			btn_even.setEnabled(true);
		    			btn_odd.setEnabled(true);
		    			btn_odd.setEnabled(true);
		    			btn_gorriak.setEnabled(true);
		    			btn_beltzak.setEnabled(true);
		    			btn_1_12.setEnabled(true);
		    			btn_13_24.setEnabled(true);
		    			btn_25_36.setEnabled(true);
		    			btn_1_34.setEnabled(true);
		    			btn_2_35.setEnabled(true);
		    			btn_3_36.setEnabled(true);
		    			btn_zbk_0.setEnabled(true);
		    			btn_zbk_1.setEnabled(true);
		    			btn_zbk_2.setEnabled(true);
		    			btn_zbk_3.setEnabled(true);
		    			btn_zbk_4.setEnabled(true);
		    			btn_zbk_5.setEnabled(true);
		    			btn_zbk_6.setEnabled(true);
		    			btn_zbk_7.setEnabled(true);
		    			btn_zbk_8.setEnabled(true);
		    			btn_zbk_9.setEnabled(true);
		    			btn_zbk_10.setEnabled(true);
		    			btn_zbk_11.setEnabled(true);
		    			btn_zbk_12.setEnabled(true);
		    			btn_zbk_13.setEnabled(true);
		    			btn_zbk_14.setEnabled(true);
		    			btn_zbk_15.setEnabled(true);
		    			btn_zbk_16.setEnabled(true);
		    			btn_zbk_17.setEnabled(true);
		    			btn_zbk_18.setEnabled(true);
		    			btn_zbk_19.setEnabled(true);
		    			btn_zbk_20.setEnabled(true);
		    			btn_zbk_21.setEnabled(true);
		    			btn_zbk_22.setEnabled(true);
		    			btn_zbk_23.setEnabled(true);
		    			btn_zbk_24.setEnabled(true);
		    			btn_zbk_25.setEnabled(true);
		    			btn_zbk_26.setEnabled(true);
		    			btn_zbk_27.setEnabled(true);
		    			btn_zbk_28.setEnabled(true);
		    			btn_zbk_29.setEnabled(true);
		    			btn_zbk_30.setEnabled(true);
		    			btn_zbk_31.setEnabled(true);
		    			btn_zbk_32.setEnabled(true);
		    			btn_zbk_33.setEnabled(true);
		    			btn_zbk_34.setEnabled(true);
		    			btn_zbk_35.setEnabled(true);
		    			btn_zbk_36.setEnabled(true);
		    			
		    			ruletaEmaitza = ruletaJokoa.getUnekoZenbakia();
		    			int guztiraIrabaziak = 0;
		    			int guztiraApostua = 0;
		    			String azkenEmaitza = "";
		    			// Kolorea konprobatu
		    			System.out.println(ruletaEmaitza);
		    			System.out.println(kolorea[0]);
		    			System.out.println(kolorea[1]);
		    			if (gorriak.contains(ruletaEmaitza) && kolorea[0] >= 1) {
		    			    guztiraIrabaziak += kolorea[0] * 2;
		    			} else if (beltzak.contains(ruletaEmaitza) && kolorea[1] >= 1) {
		    			    guztiraIrabaziak += kolorea[1] * 2;
		    			}
		    			// Zenbakia konprobatu
		    			if (ruletaEmaitza != 0 && zbk[ruletaEmaitza] != 0) {
		    			    guztiraIrabaziak += zbk[ruletaEmaitza] * 36;  // 36 * apostua
		    			}

		    			// Dozenetan konprobatu apostuak
		    			int dozena = (ruletaEmaitza - 1) / 12;  // Ze dozenatan irten den zenbakia kalkulatzen du
		    			System.out.println("Dozena: " + dozena);
		    			if (dozenak[dozena] != 0) {
		    			    guztiraIrabaziak += dozenak[dozena] * 3;  // 3 * apostua
		    			}

		    			System.out.println(dozenakEskerrEskuin[0]);
		    			if (eskerrEskuin1.contains(ruletaEmaitza) && dozenakEskerrEskuin[0] >= 1) {
		    			    guztiraIrabaziak = dozenakEskerrEskuin[0] * 3; // 3 * apostua
		    			} else if (eskerrEskuin2.contains(ruletaEmaitza) && dozenakEskerrEskuin[1] >= 1) {
		    			    guztiraIrabaziak += dozenakEskerrEskuin[1] * 3; // 3 * apostua
		    			} else if (eskerrEskuin3.contains(ruletaEmaitza) && dozenakEskerrEskuin[2] >= 1) {
		    			    guztiraIrabaziak += dozenakEskerrEskuin[2] * 3; // 3 * apostua
		    			}

		    			// Taulen erdikaldea apostua konprobatu
		    			int erdia = (ruletaEmaitza > 18) ? 1 : 0;  // Zenbakia 18 baino handiagoa den konprobatzen du.
		    			if (taulaErdia[erdia] != 0) {
		    			    guztiraIrabaziak += taulaErdia[erdia] * 2;  // 2 * apostua
		    			}

		    			// Bakoitia edo bikoitia den konprobatzen du
		    			int paridad = ruletaEmaitza % 2;  // Zenbakia bakoiti (0) edo bikoiti (1) den konprobatzen du
		    			if (bakoitiBikoiti[paridad] != 0) {
		    			    guztiraIrabaziak += bakoitiBikoiti[paridad] * 2;  // 2 * apostua
		    			}
		    			System.out.println(guztiraIrabaziak);
		    			if (guztiraIrabaziak > 0 && guztiraIrabaziak > apostuOrain) {
		    				emaitzaApostu = "Zorionak! Irabazitakoa: " + guztiraIrabaziak;
		    				JOptionPane.showMessageDialog(btnApostuaEgin, emaitzaApostu);
		    				
		    			} else if (guztiraIrabaziak == apostuOrain){
		    				emaitzaApostu = "Berdin gelditzen zara";
		    				JOptionPane.showMessageDialog(btnApostuaEgin, emaitzaApostu);
		    			} else {
		    				emaitzaApostu = "Ez duzu ezer irabazi";
		    				 JOptionPane.showMessageDialog(btnApostuaEgin, emaitzaApostu + " :(");
		    			}
		    			
		    			guztiraApostua += metodoak.gehituApostuak(zbk);
		    			guztiraApostua += metodoak.gehituApostuak(dozenak);
		    			guztiraApostua += metodoak.gehituApostuak(dozenakEskerrEskuin);
		    			guztiraApostua += metodoak.gehituApostuak(taulaErdia);
		    			guztiraApostua += metodoak.gehituApostuak(bakoitiBikoiti);
		    			guztiraApostua += metodoak.gehituApostuak(kolorea);
		    			
		    			if ((guztiraIrabaziak - guztiraApostua) >= 0) {
		    				azkenEmaitza = "+" + (guztiraIrabaziak - guztiraApostua);
		    			} else {
		    				azkenEmaitza = Integer.toString(guztiraIrabaziak - guztiraApostua);
		    			}
		    			metodoak.txtIdatzi(denboraOrduaMomentukoa + " | Erabiltzaile NAN: " + lehenLehioa.getMomentukoErabiltzaileNAN() + " | Ruleta emaitza: " + ruletaEmaitza + " | Guztira apostatutako kantitatea: " + guztiraApostua + " | Apostua emaitza: " + emaitzaApostu + " | Azken balantzea: " + azkenEmaitza );
						apostuOrain = 0;
						Arrays.fill(zbk, 0);
						Arrays.fill(dozenak, 0);
						Arrays.fill(dozenakEskerrEskuin, 0);
						Arrays.fill(taulaErdia, 0);
						Arrays.fill(bakoitiBikoiti, 0);
						Arrays.fill(kolorea, 0);
		    			
		    			}
					});
	            }
			});
		btnApostuaEgin.setBounds(641, 400, 136, 50);
		btnApostuaEgin.setEnabled(false);
		contentPane.add(btnApostuaEgin);
		
		btnApostuaEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				apostuKantitatea.clearSelection();
				apostuOrain = 0;
				Arrays.fill(zbk, 0);
				Arrays.fill(dozenak, 0);	
				Arrays.fill(dozenakEskerrEskuin, 0);
				Arrays.fill(taulaErdia, 0);
				Arrays.fill(bakoitiBikoiti, 0);
				Arrays.fill(kolorea, 0);
				btnApostuaEgin.setEnabled(false);
				JOptionPane.showMessageDialog(btnApostuaEzabatu, "Apostua zuzen ezabatu da");
			}
		});
		
		btn_zbk_0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 0, zbk);
			
				System.out.println("zbk[0] = " + zbk[0]);
				System.out.println("zbk[1] = " + zbk[1]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
			}
		});
		
		btn_zbk_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 1, zbk);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
			}
		});

		btn_zbk_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 2, zbk);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
			}
		});
		
		btn_zbk_3.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 3, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 4, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_5.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 5, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_6.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 6, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_7.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 7, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_8.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 8, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_9.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 9, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_10.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 10, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_11.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 11, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_12.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 12, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_13.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 13, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_14.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 14, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_15.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 15, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_16.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 16, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_17.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 17, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_18.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 18, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_19.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 19, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_20.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 20, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_21.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 21, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_22.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 22, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_23.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 23, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_24.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 24, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_25.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 25, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_26.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 26, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_27.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 27, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_28.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 28, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_29.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 29, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});

		btn_zbk_30.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 30, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_31.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 31, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_32.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 32, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_33.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 33, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_34.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 34, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_35.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 35, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_zbk_36.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        apostuOrain = metodoak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 36, zbk);
		        System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
		    }
		});
		
		btn_1_34.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 0, dozenakEskerrEskuin);
				
				System.out.println("dozenakEskerrEskuin[0] = " + dozenakEskerrEskuin[0]);
				System.out.println("dozenakEskerrEskuin[1] = " + dozenakEskerrEskuin[1]);
				System.out.println("dozenakEskerrEskuin[2] = " + dozenakEskerrEskuin[2]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
			}
		});
		
		btn_2_35.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 1, dozenakEskerrEskuin);
				
				System.out.println("dozenakEskerrEskuin[0] = " + dozenakEskerrEskuin[0]);
				System.out.println("dozenakEskerrEskuin[1] = " + dozenakEskerrEskuin[1]);
				System.out.println("dozenakEskerrEskuin[2] = " + dozenakEskerrEskuin[2]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");	
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
			}
		});
		
		btn_3_36.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 2, dozenakEskerrEskuin);
				
				System.out.println("dozenakEskerrEskuin[0] = " + dozenakEskerrEskuin[0]);
				System.out.println("dozenakEskerrEskuin[1] = " + dozenakEskerrEskuin[1]);
				System.out.println("dozenakEskerrEskuin[2] = " + dozenakEskerrEskuin[2]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});
		
		btn_1_12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 0, dozenak);
				
				System.out.println("dozenak[0] = " + dozenak[0]);
				System.out.println("dozenak[1] = " + dozenak[1]);
				System.out.println("dozenak[2] = " + dozenak[2]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
			}
		});
		
		btn_13_24.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 1, dozenak);
				
				System.out.println("dozenak[0] = " + dozenak[0]);
				System.out.println("dozenak[1] = " + dozenak[1]);
				System.out.println("dozenak[2] = " + dozenak[2]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});
		
		btn_25_36.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 2, dozenak);
				
				System.out.println("dozenak[0] = " + dozenak[0]);
				System.out.println("dozenak[1] = " + dozenak[1]);
				System.out.println("dozenak[2] = " + dozenak[2]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});
		
		btn_1_18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 0, taulaErdia);
				
				System.out.println("taulaErdia[0] = " + taulaErdia[0]);
				System.out.println("taulaErdia[1] = " + taulaErdia[1]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});
		
		btn_19_36.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 1, taulaErdia);
				
				System.out.println("taulaErdia[0] = " + taulaErdia[0]);
				System.out.println("taulaErdia[1] = " + taulaErdia[1]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});
		
		btn_even.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 0, bakoitiBikoiti);
				
				System.out.println("bakoitiBikoiti[0] = " + bakoitiBikoiti[0]);
				System.out.println("bakoitiBikoiti[1] = " + bakoitiBikoiti[1]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});
		
		btn_odd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 1, bakoitiBikoiti);
				
				System.out.println("bakoitiBikoiti[0] = " + bakoitiBikoiti[0]);
				System.out.println("bakoitiBikoiti[1] = " + bakoitiBikoiti[1]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});
		
		btn_gorriak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 0, kolorea);
				
				System.out.println("kolorea[0] = " + kolorea[0]);
				System.out.println("kolorea[1] = " + kolorea[1]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
			}
		});
		
		btn_beltzak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				apostuOrain = metodoak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, pertsonaApostuMax, apostuOrain, 1, kolorea);
				
				System.out.println("kolorea[0] = " + kolorea[0]);
				System.out.println("kolorea[1] = " + kolorea[1]);
				System.out.println("Momentu onetan " + apostuOrain + " apostatu duzu guztira");
				
				if(rdbtnApostu10.isSelected() || rdbtnApostu20.isSelected() || rdbtnApostu50.isSelected() || rdbtnApostu100.isSelected() || rdbtnApostu500.isSelected() || rdbtnApostu1000.isSelected()){
					btnApostuaEgin.setEnabled(true);
					btnApostuaEzabatu.setEnabled(true);
				}
				
			}
		});	

	}

}