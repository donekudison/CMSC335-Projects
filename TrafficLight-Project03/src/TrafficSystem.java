import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public  class TrafficSystem {
    private static ExecutorService exec;
    private static boolean doSim = false;

    private static WindowListener windowListener = new WindowListener() {
        @Override
        public void windowClosing(WindowEvent event) {
            doSim = false;
            exec.shutdownNow();
            System.exit(0);
        }

       
        public void windowOpened(WindowEvent event) {
        }

       
        public void windowClosed(WindowEvent event) {
        }

        
        public void windowIconified(WindowEvent event) {
        }

        
        public void windowDeiconified(WindowEvent event) {
        }

        
        public void windowActivated(WindowEvent event) {
        }

        
        public void windowDeactivated(WindowEvent event) {
        }
    };

    private static List<Light> lights = new ArrayList<>(Arrays.asList(new Light(), new Light(), new Light()));
     //added
   // private static List<Cars> cars = new ArrayList<>(Arrays.asList(new Cars(), new Cars(), new Cars()));
   static ArrayList<Cars> cars = new ArrayList<Cars>();

	public void addCar(Cars v) {
		cars.add(v);
		
	}
	
    private static JButton startButton;
    private static JButton pauseButton;
    private static JButton continueButton;
    private static JButton stopButton;
    private static JPanel simPanel;
    
    //Added
    private static Container south;
    //Container west =new Container();
    private static JButton semiButton;
    private static JButton suvButton;
    private static JButton sportCarsButton;
    

    @SuppressWarnings("serial")
	private static void init() {
        JFrame frame = new JFrame("Traffic Light Simulation");
       // Road road = new Road();//Added
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        continueButton = new JButton("Continue");
        stopButton = new JButton("Stop");
        //Added
        south =new Container();
        semiButton = new JButton("Add Semi");
        suvButton = new JButton("Add SUV");
        sportCarsButton = new JButton("Add SportCar");

        frame.add(startButton);
        frame.add(pauseButton);
        frame.add(continueButton);
        frame.add(stopButton);

        //Added
        frame.add(semiButton);
        frame.add(suvButton);
        frame.add(sportCarsButton);
        
        
        startButton.setBounds(200, 25, 100, 30);
        pauseButton.setBounds(350, 25, 100, 30);
        continueButton.setBounds(500, 25, 100, 30);
        stopButton.setBounds(650, 25, 100, 30);
        
        //Added Containers
       // south.setLayout(new GridLayout(3,1));
       // south.add(semiButton);
      //  south.addActionListener(e);
       // south.setLayout(new GridLayout(3,1));
       // south.add(suvButton);
      //  south.addActionListener(e);
       // south.setLayout(new GridLayout(3,1));
       // south.add(sportCarsButton);
      //  south.addActionListener(e);

        // button event handling
        startButton.addActionListener(event -> {
            simStart(event);
        });
        pauseButton.addActionListener(event -> {
            simPause(event);
        });
        continueButton.addActionListener(event -> {
            simContinue(event);
        });
        stopButton.addActionListener(event -> {
            simStop(event);
        });

        simPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSimPanel(g);
            }
        };
        simPanel.setBounds(50, 100, 700, 400);
        simPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(simPanel);

        frame.setLayout(null);
        frame.setSize(800, 600);
        frame.setLocation(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(windowListener);
        frame.setVisible(true);
      //Added
       /* frame.add(road); 
        Semi testSemi = new Semi(10,20);
        road.addCar(testSemi);
        SUV testSUV = new SUV(10,170);
        road.addCar(testSUV);
        SportCars testSportCars = new SportCars(10,320);
        road.addCar(testSportCars);
        frame.repaint();*/
    }

    private static void drawSimPanel(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(20));
       // g2.fillRect(0, 0, getWidth(), getHeight());
		//g2.setColor(Color.WHITE);
        g2.setColor(Color.LIGHT_GRAY);
       

        // roads
        g.drawLine(30, 200, 530, 200);
        
        g.setColor(Color.WHITE);
        g.drawLine(130, 100, 130, 300);
        g.drawLine(280, 100, 280, 300);
        g.drawLine(430, 100, 430, 300);
        //g.drawLine(580, 100, 580, 300);

        // lights
        for (int i = 0; i < lights.size(); i++) {
            g2.setStroke(new BasicStroke(20));
            g2.setColor(Color.BLACK);

            g2.drawRect(90 + 150 * i, 120, 11, 50);
            g2.setStroke(new BasicStroke(11));
            switch (lights.get(i).getColor()) {
            case "red":
                g2.setColor(Color.RED);
                g2.drawOval(90 + 150 * i, 119, 11, 11);
                break;
            case "yellow":
                g2.setColor(Color.YELLOW);
                g2.drawOval(90 + 150 * i, 140, 11, 11);
                break;
            case "green":
                g2.setColor(Color.GREEN);
                g2.drawOval(90 + 150 * i, 161, 11, 11);
                break;
            }
        }

        // Draw cars
        
        for(int a = 0; a < cars.size(); a++) {
            g2.setStroke(new BasicStroke(20));
            g2.setColor(Color.BLACK);
			cars.get(a).paintMe(g);
            Cars v =  cars.get(a);
            v.setX(v.getX() + v.getSpeed());
            //if (v.getX() > Road_WIDTH) {
            if (v.getX() > a) {
            	v.setX(0);
            }
            g2.drawRect(10 + 150 * a, 120, 11, 50);
            g2.setStroke(new BasicStroke(11));
            /*switch (lights.get(a).getColor()) {
            case "red":
                g2.setColor(Color.RED);
                g2.drawOval(10 + 150 * a, 119, 11, 11);
                break;
            case "yellow":
                g2.setColor(Color.YELLOW);
                g2.drawOval(10 + 150 * a, 140, 11, 11);
                break;
            case "green":
                g2.setColor(Color.GREEN);
                g2.drawOval(10 + 150 * a, 161, 11, 11);
                break;
            }  */  
            
            
		}

    }

    private static void simStart(ActionEvent e) {
        System.out.println("You clicked Start!");
        exec = Executors.newFixedThreadPool(10);
        doSim = true;

        // start light tasks
        for (int i = 0; i < lights.size(); i++) {
            final int idx = i;
            Light light = lights.get(i);
            exec.submit(() -> {
                try {
                    Thread.sleep(1000 * idx);
                } catch (InterruptedException ex) {
                }
                do {
                    try {
                        Thread.sleep(2000);
                        light.changeColor();
                        simPanel.repaint();
                        Thread.sleep(3000);
                        light.changeColor();
                        simPanel.repaint();
                        Thread.sleep(1000);
                        light.changeColor();
                        simPanel.repaint();
                    } catch (InterruptedException ex) {
                    }
                } while(doSim);
            });
        }
        
     // start cars tasks
        for (int a = 0; a < cars.size(); a++) {
            final int idx = a;
            Cars car = cars.get(a);
            exec.submit(() -> {
                try {
                    Thread.sleep(1000 * idx);
                } catch (InterruptedException ex) {
                }
                do {
                    try {
                        Thread.sleep(2000);
                       // car.getCars();
                        car.getSpeed();
                        simPanel.repaint();
                        Thread.sleep(3000);
                        //car.getCars();
                        car.getSpeed();
                        simPanel.repaint();
                        Thread.sleep(1000);
                       // car.getCars();
                        car.getSpeed();
                        simPanel.repaint();
                    } catch (InterruptedException ex) {
                    }
                } while(doSim);
            });
        }  
    }

    private static void simPause(ActionEvent e) {
        System.out.println("You clicked Pause!");
       
       // Pause light tasks
        doSim = false;
        exec.isShutdown();
       
    }
    
    private static void simContinue(ActionEvent e) {
        System.out.println("You clicked Continue!");
        exec = Executors.newFixedThreadPool(10);
        doSim = true;

        // Continue light tasks
        for (int i = 0; i < lights.size(); i++) {
            final int idx = i;
            Light light = lights.get(i);
            exec.submit(() -> {
                try {
                    Thread.sleep(1000 * idx);
                } catch (InterruptedException ex) {
                }
                do {
                    try {
                        Thread.sleep(2000);
                        light.changeColor();
                        simPanel.repaint();
                        Thread.sleep(3000);
                        light.changeColor();
                        simPanel.repaint();
                        Thread.sleep(1000);
                        light.changeColor();
                        simPanel.repaint();
                    } catch (InterruptedException ex) {
                    }
                } while(doSim);
            });
        }
    }
    
     
    private static void simStop(ActionEvent e) {
        System.out.println("You clicked Stop!");
        
     // Stop light tasks
        doSim = false;
        exec.shutdownNow();
    }

    public static void main(String[] args) {
        TrafficSystem.init();
    }

}



