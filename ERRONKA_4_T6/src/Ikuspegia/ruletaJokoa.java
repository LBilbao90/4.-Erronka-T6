package Ikuspegia;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Kontrolatzailea.metodoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ruletaJokoa extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image irudi;
    private double angelu = 0;
    private Timer timer1, timer2, timer3, timer4, timer5, timer6, timer7, timer8, timer9, timer10, timer11, timer12, timer13;
    private long hasieraDenbora = System.currentTimeMillis();
    private int kont = 0;
    protected static int unekoZenbakia;

    private Random random = new Random();
    private static JButton btnBiratu;

    public static int getUnekoZenbakia() {
		return unekoZenbakia;
	}

	public void setUnekoZenbakia(int unekoZenbakia) {
		this.unekoZenbakia = unekoZenbakia;
	}
	
	// Biratu botoia getter
    public static JButton getBtnBiratu() {
        return btnBiratu;
    }

    // OK botoia sakatzean metodoa exekutatuko den klasea ezartzeko metodoa
    private static OKButtonListener okButtonListener;
    public interface OKButtonListener {
        void onOKButtonPressed();
    }

    public static void setOKButtonListener(OKButtonListener listener) {
        okButtonListener = listener;
    }

    // Eraikitzailea
    public ruletaJokoa() {
        // Ruleta irudia kargatu
        try {
        	irudi = ImageIO.read(new File("img/ruletaJokoa.png")).getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Tamaina definitu
        setPreferredSize(new Dimension(400, 400));

        // BorderLayout-a konfiguratu marrazkiaren panelarentzat
        setLayout(new BorderLayout());

        // Biratu botoia sortu
        btnBiratu = new JButton("");
        String geziaHelbidea = "img/ruletaGezia.png";
        ImageIcon gezia = new ImageIcon(geziaHelbidea);
        btnBiratu.setIcon(gezia);
        btnBiratu.setOpaque(false);
        btnBiratu.setContentAreaFilled(false);
        btnBiratu.setBorderPainted(false);
        btnBiratu.setFocusPainted(false);
        add(btnBiratu, BorderLayout.NORTH);


        
        //ArrayList onen barruan temporizadoreentzako zenbateko delaya esartzen zaien gordetzen da.
        ArrayList<Integer> timerDelay = new ArrayList<>(Arrays.asList(5, 8, 11, 15, 18, 21, 24, 27, 30, 33, 35, 37, 39, 41, 45));
        // Aldagai guztien temporizadoreak sortu
        timer1 = sortuTimer(random.nextInt(6) + timerDelay.get(0), 4);
        timer2 = sortuTimer(random.nextInt(4) + timerDelay.get(1), 3.75);
        timer3 = sortuTimer(random.nextInt(6) + timerDelay.get(2), 3.5);
        timer4 = sortuTimer(random.nextInt(3) + timerDelay.get(3), 3.25);
        timer5 = sortuTimer(random.nextInt(5) + timerDelay.get(4), 3);
        timer6 = sortuTimer(random.nextInt(3) + timerDelay.get(5), 2.75);
        timer7 = sortuTimer(random.nextInt(3) + timerDelay.get(6), 2.5);
        timer8 = sortuTimer(random.nextInt(3) + timerDelay.get(7), 2.25);
        timer9 = sortuTimer(random.nextInt(5) + timerDelay.get(8), 2);
        timer10 = sortuTimer(random.nextInt(2) + timerDelay.get(9), 1.60);
        timer11 = sortuTimer(random.nextInt(2) + timerDelay.get(10), 1.3);
        timer12 = sortuTimer(random.nextInt(2) + timerDelay.get(11), 1);
        timer13 = sortuTimer(random.nextInt(1) + timerDelay.get(12), 0.75);

        // Botoia sakatzean lehen temporizatailea hasten da.
        // Botoi hau ruletaApostua klaseko 'btnApostuaEgin' botoia sakatzean bakarrk aktibatzen da.
        btnBiratu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (kont == 0) {
            		kont++;
                    timer1.start();
                    hasieraDenbora = System.currentTimeMillis();
            	}
            }
        });

        // Pasa den denboraren arabera 'timer' desberdinak aktibatu eta desaktibatuko dira.
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pasatakoDenbora = (int) (System.currentTimeMillis() - hasieraDenbora) / 1000;
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(0), timerDelay.get(1), kont, timer1, timer2);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(1), timerDelay.get(2), kont, timer1, timer2);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(2), timerDelay.get(3), kont, timer2, timer3);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(3), timerDelay.get(4), kont, timer3, timer4);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(4), timerDelay.get(5), kont, timer4, timer5);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(5), timerDelay.get(6), kont, timer5, timer6);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(6), timerDelay.get(7), kont, timer6, timer7);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(7), timerDelay.get(8), kont, timer7, timer8);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(8), timerDelay.get(9), kont, timer8, timer9);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(9), timerDelay.get(10), kont, timer9, timer10);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(10), timerDelay.get(11), kont, timer10, timer11);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(11), timerDelay.get(12), kont, timer11, timer12);
                metodoak.denboraAraberaTimer(pasatakoDenbora, timerDelay.get(12), timerDelay.get(13), kont, timer12, timer13);
                if (pasatakoDenbora >= timerDelay.get(13) && pasatakoDenbora < timerDelay.get(14) && kont == 1) {
                	kont--;
                	timer13.stop();
                    unekoZenbakia = metodoak.ruletakoZbkKalkulatu(angelu);
                    System.out.println("Ruleta emaitza: " + unekoZenbakia);
//                    unekoZenbakia = 0;
                    erakutsiMezua(unekoZenbakia);
//                    unekoZenbakia = 0;
                }
            }
        }).start();
    }

    //Ruletaren emaitza earkusten duen mezu bat erakusten du
    private void erakutsiMezua(int unekoZenbakia) {
        JOptionPane.showMessageDialog(this, "Zenbakia: " + unekoZenbakia, "Ruleta Emaitza | Elorrieta Kasinoa ©", JOptionPane.INFORMATION_MESSAGE);
        if (okButtonListener != null) {
            okButtonListener.onOKButtonPressed();
        }
    }
    
	// Metodo honek osagaiaren marrazkia pertsonalizatzen du, 'irudi' irudia errotatuz.
	// zentroaren inguruko angelu 'angeluaren' arabera, eta gero panelean marrazten du.
	// Eraldaketa-interpolazioa errotatutako irudia leuntzeko erabiltzen da.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform at = new AffineTransform();
        at.rotate(angelu, irudi.getWidth(null) / 2, irudi.getHeight(null) / 2);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(irudi, at, null);
        }
    
	// Timer' objektu bat sortzen du.
    private Timer sortuTimer(int delay, double angeluHanditzea) {
        return new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(angeluHanditzea);
                repaint();
            }
        });
    }
    
//    public static void main(String[] args) {
//        // Crear la ventana de la aplicación y agregar el panel de la imagen rotada
//        JFrame frame = new JFrame("Rotar Imagen con Animación");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new ruletaJokoa());
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
    
}