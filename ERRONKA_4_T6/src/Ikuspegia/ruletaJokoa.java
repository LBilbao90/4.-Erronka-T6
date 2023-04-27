package Ikuspegia;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ruletaJokoa extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image irudi;
    private double angelu = 0;
    private Timer timer1, timer2, timer3, timer4, timer5, timer6, timer7, timer8, timer9, timer10, timer11, timer12, timer13, timer14, timer15;
    private long hasieraDenbora = System.currentTimeMillis();
    private int kont = 0;

    private Random random = new Random();
    private static JButton btnBiratu;
    
    public boolean lehioaItxi = false;

    public static JButton getBtnBiratu() {
        return btnBiratu;
    }

    private static OKButtonListener okButtonListener;

    public interface OKButtonListener {
        void onOKButtonPressed();
    }

    public static void setOKButtonListener(OKButtonListener listener) {
        okButtonListener = listener;
    }


    public ruletaJokoa() {
        // Cargar la imagen
        try {
        	irudi = ImageIO.read(new File("img/ruletaJokoa.png")).getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        // Establecer el tamaño del panel
        setPreferredSize(new Dimension(470, 400));

        // Configurar el BorderLayout para el panel de dibujo
        setLayout(new BorderLayout());

        // Crear boton girar
        btnBiratu = new JButton("Biratu");
        add(btnBiratu, BorderLayout.EAST);

        // Crear temporizadores con diferentes velocidades de rotación
        timer1 = new Timer(random.nextInt(6) + 5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(4);
                repaint();
                System.out.println(angelu);
            }
        });
        
        timer2 = new Timer(random.nextInt(4) + 7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(3.75);
                repaint();
            }
        });

        timer3 = new Timer(random.nextInt(6) + 10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(3.5);
                repaint();
            }
        });

        timer4 = new Timer(random.nextInt(3) + 12, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(3.25);
                repaint();
            }
        });

        timer5 = new Timer(random.nextInt(5) + 15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(3);
                repaint();
            }
        });

        timer6 = new Timer(random.nextInt(3) + 17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(2.75);
                repaint();
            }
        });

        timer7 = new Timer(random.nextInt(3) + 20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(2.5);
                repaint();
            }
        });

        timer8 = new Timer(random.nextInt(3) + 22, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(2.25);
                repaint();
            }
        });

        timer9 = new Timer(random.nextInt(5) + 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(2);
                repaint();
            }
        });

        timer10 = new Timer(random.nextInt(2) + 26, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(1.75);
                repaint();
            }
        });

        timer11 = new Timer(random.nextInt(2) + 28, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(1.5);
                repaint();
            }
        });

        timer12 = new Timer(random.nextInt(2) + 30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(1.25);
                repaint();
            }
        });

        timer13 = new Timer(random.nextInt(1) + 31, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(1);
                repaint();
            }
        });

        timer14 = new Timer(random.nextInt(1) + 32, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(0.75);
                repaint();
            }
        });

        timer15 = new Timer(random.nextInt(1) + 33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angelu += Math.toRadians(0.5);
                repaint();
            }
        });


     // Iniciar el primer temporizador cuando se pulsa el boton
        btnBiratu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (kont == 0) {
            		kont++;
                    timer1.start();
                    hasieraDenbora = System.currentTimeMillis();
            	} else {
            		System.out.println("No le des mas al puto boton por que no va bobo, MIRA EL KONT bobi ");
            	}
            }
        });

        // Cambiar de temporizador en función del tiempo transcurrido
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pasatakoDenbora = (int) (System.currentTimeMillis() - hasieraDenbora) / 1000;
                if (pasatakoDenbora >= 5 && pasatakoDenbora < 7 ) {
                    timer1.stop();
                    timer2.start();
                } else if (pasatakoDenbora >= 7 && pasatakoDenbora < 10) {
                    timer2.stop();
                    timer3.start();
                } else if (pasatakoDenbora >= 10 && pasatakoDenbora < 12) {
                    timer3.stop();
                    timer4.start();
                } else if (pasatakoDenbora >= 12 && pasatakoDenbora < 15) {
                	timer4.stop();
                	timer5.start();
                } else if (pasatakoDenbora >= 15 && pasatakoDenbora < 17) {
                	timer5.stop();
                	timer6.start();
                } else if (pasatakoDenbora >= 17 && pasatakoDenbora < 20) {
                	timer6.stop();
                	timer7.start();
                } else if (pasatakoDenbora >= 20 && pasatakoDenbora < 22) {
                	timer7.stop();
                	timer8.start();
                } else if (pasatakoDenbora >= 22 && pasatakoDenbora < 25) {
                	timer8.stop();
                	timer9.start();
                } else if (pasatakoDenbora >= 25 && pasatakoDenbora < 26) {
                	timer9.stop();
                	timer10.start();
                } else if (pasatakoDenbora >= 26 && pasatakoDenbora < 28) {
                	timer10.stop();
                	timer11.start();
                } else if (pasatakoDenbora >= 28 && pasatakoDenbora < 30) {
                	timer11.stop();
                	timer12.start();
                } else if (pasatakoDenbora >= 30 && pasatakoDenbora < 31) {
                	timer12.stop();
                	timer13.start();
                } else if (pasatakoDenbora >= 31 && pasatakoDenbora < 32) {
                	timer13.stop();
                	timer14.start();
                } else if (pasatakoDenbora >= 32 && pasatakoDenbora < 33) {
                	timer14.stop();
                	timer15.start();
                } else if (pasatakoDenbora >= 33 && pasatakoDenbora < 34) {
                    timer15.stop();
                    double unekoAngeluGraduak = Math.toDegrees(angelu);
                    do {
                        unekoAngeluGraduak = unekoAngeluGraduak -360;
                    } while (unekoAngeluGraduak > 360);
                    System.out.println("Ángulo actual de la ruleta: " + unekoAngeluGraduak);
                    double sektoreTamaina = 360.0 / 37.0;
                    int unekoZenbakia = (int)(unekoAngeluGraduak / sektoreTamaina);
                    System.out.println("Número actual en la ruleta: " + unekoZenbakia);
                    timer15.stop();
                    kont--;
                    
                    erakutsiMezua(unekoZenbakia);
                    
                }
            }
        }).start();
    }

 // Método para mostrar el diálogo con el número actual
    private void erakutsiMezua(int unekoZenbakia) {
        JOptionPane.showMessageDialog(this, "Zenbakia: " + unekoZenbakia, "Ruleta Emaitza | Elorrieta Kasinoa ©", JOptionPane.INFORMATION_MESSAGE);
        if (okButtonListener != null) {
            okButtonListener.onOKButtonPressed();
        }
    }


    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

     // Aplicar la interpolación de transformación para dibujar la imagen rotada gradualmente
        AffineTransform at = new AffineTransform();
        at.rotate(angelu, irudi.getWidth(null) / 2, irudi.getHeight(null) / 2);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(irudi, at, null);
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