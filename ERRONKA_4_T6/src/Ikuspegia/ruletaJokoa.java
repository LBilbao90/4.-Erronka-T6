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
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ruletaJokoa extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image image;
    private double angle = 0;
    private Timer timer1, timer2, timer3, timer4, timer5, timer6, timer7, timer8, timer9, timer10, timer11, timer12, timer13, timer14, timer15;
    private long startTime = System.currentTimeMillis();
    private int kont = 0;

    private Random random = new Random();



    public ruletaJokoa() {
    	
    	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int screenWidth = (int) (screenSize.width * 0.75);
    	int screenHeight = (int) (screenSize.height * 0.75);
    	
    	setBounds(screenWidth, screenHeight, screenHeight, screenHeight);
        
        // Cargar la imagen
        try {
        	image = ImageIO.read(new File("img/ruletaJokoa.png")).getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Establecer el tamaño del panel
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        // Configurar el BorderLayout para el panel de dibujo
        setLayout(new BorderLayout());
        

        // Crear boton girar
        JButton btnGirar = new JButton("Girar");
        btnGirar.setBounds(100, 100, 50, 50);
        add(btnGirar, BorderLayout.EAST);

        // Crear temporizadores con diferentes velocidades de rotación
        timer1 = new Timer(random.nextInt(6) + 5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(4);
                repaint();
//                System.out.println(timer1 + " timer1");
            }
        });
        
        timer2 = new Timer(random.nextInt(4) + 7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(3.75);
                repaint();
//                System.out.println(timer2 + "timer 2");
            }
        });

        timer3 = new Timer(random.nextInt(6) + 10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(3.5);
                repaint();
            }
        });

        timer4 = new Timer(random.nextInt(3) + 12, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(3.25);
                repaint();
            }
        });

        timer5 = new Timer(random.nextInt(5) + 15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(3);
                repaint();
            }
        });

        timer6 = new Timer(random.nextInt(3) + 17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(2.75);
                repaint();
            }
        });

        timer7 = new Timer(random.nextInt(3) + 20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(2.5);
                repaint();
            }
        });

        timer8 = new Timer(random.nextInt(3) + 22, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(2.25);
                repaint();
            }
        });

        timer9 = new Timer(random.nextInt(5) + 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(2);
                repaint();
            }
        });

        timer10 = new Timer(random.nextInt(2) + 26, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(1.75);
                repaint();
            }
        });

        timer11 = new Timer(random.nextInt(2) + 28, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(1.5);
                repaint();
            }
        });

        timer12 = new Timer(random.nextInt(2) + 30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(1.25);
                repaint();
            }
        });

        timer13 = new Timer(random.nextInt(1) + 31, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(1);
                repaint();
            }
        });

        timer14 = new Timer(random.nextInt(1) + 32, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(0.75);
                repaint();
            }
        });

        timer15 = new Timer(random.nextInt(1) + 33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(0.5);
                repaint();
            }
        });


     // Iniciar el primer temporizador cuando se pulsa el boton
        btnGirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (kont == 0) {
            		kont++;
                    timer1.start();
                    startTime = System.currentTimeMillis();
            	} else {
            		System.err.println("Itxaron");
            	}
            }
        });

        // Cambiar de temporizador en función del tiempo transcurrido
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int elapsedSeconds = (int) (System.currentTimeMillis() - startTime) / 1000;
                System.out.println(elapsedSeconds);
                if (elapsedSeconds >= 5 && elapsedSeconds < 7) {
                    timer1.stop();
                    timer2.start();
                } else if (elapsedSeconds >= 7 && elapsedSeconds < 10) {
                    timer2.stop();
                    timer3.start();
                } else if (elapsedSeconds >= 10 && elapsedSeconds < 12) {
                    timer3.stop();
                    timer4.start();
                } else if (elapsedSeconds >= 12 && elapsedSeconds < 15) {
                	timer4.stop();
                	timer5.start();
                } else if (elapsedSeconds >= 15 && elapsedSeconds < 17) {
                	timer5.stop();
                	timer6.start();
                } else if (elapsedSeconds >= 17 && elapsedSeconds < 20) {
                	timer6.stop();
                	timer7.start();
                } else if (elapsedSeconds >= 20 && elapsedSeconds < 22) {
                	timer7.stop();
                	timer8.start();
                } else if (elapsedSeconds >= 22 && elapsedSeconds < 25) {
                	timer8.stop();
                	timer9.start();
                } else if (elapsedSeconds >= 25 && elapsedSeconds < 26) {
                	timer9.stop();
                	timer10.start();
                } else if (elapsedSeconds >= 26 && elapsedSeconds < 28) {
                	timer10.stop();
                	timer11.start();
                } else if (elapsedSeconds >= 28 && elapsedSeconds < 30) {
                	timer11.stop();
                	timer12.start();
                } else if (elapsedSeconds >= 30 && elapsedSeconds < 31) {
                	timer12.stop();
                	timer13.start();
                } else if (elapsedSeconds >= 31 && elapsedSeconds < 32) {
                	timer13.stop();
                	timer14.start();
                } else if (elapsedSeconds >= 32 && elapsedSeconds < 33) {
                	timer14.stop();
                	timer15.start();
                } else if (elapsedSeconds >= 33 && elapsedSeconds < 34) {
                    timer15.stop();
                    double currentAngleDegrees = Math.toDegrees(angle);
                    do {
                        currentAngleDegrees = currentAngleDegrees -360;
                    } while (currentAngleDegrees > 360);
                    System.out.println("Ángulo actual de la ruleta: " + currentAngleDegrees);
                    double sectorSize = currentAngleDegrees / 37.0;
                    int[] ArrayZenbakiak = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8 ,32, 10, 5, 24, 16, 33, 1, 20, 14, 33, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
                    
                    System.out.println("Número actual en la ruleta: " + ArrayZenbakiak[(int) sectorSize]);
   
                    kont--;
                    timer15.stop();
                    System.out.println(elapsedSeconds);
                    
//                    ((Timer)e.getSource()).stop();
                    
                    System.out.println(elapsedSeconds);
                    elapsedSeconds = 0;
                    
                    
//                    try {
//                    	
//                        Thread.sleep(5000); // Pausa de 5 segundos (5000 milisegundos)
//                        timer1.start();
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace(); // Manejo de la excepción en caso de interrupción
//                    }

                }
            }
        }).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

     // Aplicar la interpolación de transformación para dibujar la imagen rotada gradualmente
        AffineTransform at = new AffineTransform();
        at.rotate(angle, image.getWidth(null) / 2, image.getHeight(null) / 2);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, at, null);
        }
    
}