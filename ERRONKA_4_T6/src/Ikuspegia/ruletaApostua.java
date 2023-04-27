package Ikuspegia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ikuspegia.ruletaJokoa;
import Ikuspegia.ruletaJokoa.OKButtonListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ruletaApostua extends JFrame {

    private JPanel contentPane;
    ruletaJokoa ruleta = new ruletaJokoa();
    private int pertsonaApostuMax = 100;
    private boolean blokeatu = false;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ruletaApostua frame = new ruletaApostua();
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
	public ruletaApostua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnApostuaEzabatu = new JButton("Apostua ezabatu");
		btnApostuaEzabatu.setBounds(647, 341, 130, 50);
		contentPane.add(btnApostuaEzabatu);
		
			       JButton btnJokoetaraBueltatu = new JButton("Jokoetara Bueltatu");
			       btnJokoetaraBueltatu.addActionListener(new ActionListener() {
			           public void actionPerformed(ActionEvent e) {
			               if (btnJokoetaraBueltatuListener != null) {
			                   btnJokoetaraBueltatuListener.onJokoetaraBueltatu();
			               }
			           }
			       });
			       btnJokoetaraBueltatu.setBounds(622, 59, 155, 50);
			       contentPane.add(btnJokoetaraBueltatu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/ruletaTablero.jpg"));
		lblNewLabel.setBounds(10, 137, 627, 313);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apostu Max: " + pertsonaApostuMax);
		lblNewLabel_1.setBounds(656, 11, 121, 37);
		contentPane.add(lblNewLabel_1);
		
		JButton btnApostuaEginEta = new JButton("Apostua bukatu");
		btnApostuaEginEta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    	    blokeatu = true;
	            // Crea y muestra la ventana de ruleta
	         //   metodoak.btn3secDelay(ruleta, 0, sarrera, login, erregistratu, jokoak, ruleta, e);
	            JFrame ruletaLehioa = new JFrame("Ruleta | Elorrieta Kasinoa ©");
	            
	            ruletaLehioa.getContentPane().add(ruleta);
	            ruletaLehioa.pack();
	            ruletaLehioa.setVisible(true);
	            
	            if (blokeatu == true) {
	    			btnApostuaEginEta.setEnabled(false);
	    			btnApostuaEzabatu.setEnabled(false);
	    			btn_1_18.setEnabled(false);
	    			btn_19_36.setEnabled(false);
	    			btn_even.setEnabled(false);
	    			btn_odd.setEnabled(false);
	    			btn_odd.setEnabled(false);
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
//	    			kont = 1;
	    			ruletaJokoa.getBtnBiratu().doClick();
	    		}
	            
	            ruletaJokoa.setOKButtonListener(new OKButtonListener() {

					@Override
					public void onOKButtonPressed() {
						ruletaLehioa.dispose();
		            	btnApostuaEginEta.setEnabled(true);
		    			btnApostuaEzabatu.setEnabled(true);
		    			btn_1_18.setEnabled(true);
		    			btn_19_36.setEnabled(true);
		    			btn_even.setEnabled(true);
		    			btn_odd.setEnabled(true);
		    			btn_odd.setEnabled(true);
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
					}
	            	
	            });
			}
		});
		btnApostuaEginEta.setBounds(647, 400, 130, 50);
		contentPane.add(btnApostuaEginEta);
	    }
}