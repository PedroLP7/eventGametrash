import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private JPanel Panelmain;
    private JPanel paneltitulo;
    private JPanel panelcenter;

    private JLabel labeltime;
    private JLabel labelTrash;
    private JButton buttonpause;
    private JLabel vidasj1l;
    private JLabel vidasj2l;
    private int seconds = 0;
    private int x = 0;
    private int x2 = 0;
    private boolean gameStarted = false;
    private JButton buttonreset;
    private JLabel labelscore;
    private static int score = 0;
    private static int score2 = 0;
    private JLabel labelpaper;
    private double randomnum;
    private int randomInt;
    private double randomnum2;
    private int randomInt2;
    private int ypaper = 0;
    private int xpaper = 0;
    private int ypaper2 = 0;
    private int xpaper2 = 0;
    private JLabel labelpaper2;
    String[] opciones = {"Dificultad2", "Dificultad3"};
    private JComboBox<String> dificultad2 = new JComboBox<String>();
    private JLabel labelscore2;
    private JLabel labelTrash2;
    private JButton multi;
private static int vidasj1=3;
private static int vidasj2=3;
private boolean gameFinished;

    public Main() {
        Panelmain.setPreferredSize(new Dimension(800, 600));
        Panelmain.setSize(new Dimension(800, 600));
        Panelmain.setLayout(null);
        Panelmain.setFocusable(true);

        showPaneltitulo();
        showPanelcenter();
        Panelmain.addKeyListener(new panelMainListener());
       // Panelmain.addKeyListener(new panelMainListener2());
        Timer t = new Timer(500, new TimerActionListener(dificultad2));
// crear nuevo timer para gestionar el nuevo papel y que vvaya a velocidades distintas
        Timer t2 = new Timer(1000, new TimerActionListener2());
        buttonpause.addMouseListener(new buttonpauselistener(t, t2));
        buttonreset.addMouseListener(new buttonresetlistener(t, t2));
        dificultad2.addActionListener(new actionDificultad(t));
        multi.addMouseListener(new multibuttonlister());
        Panelmain.setFocusable(true);
        // AÑADIR PAPELERA NUEVA PARA JUGAR COOPERATIVO





    }
    public void paper1dif1() {
        ypaper = labelpaper.getY();
        xpaper = labelpaper.getX();
        ypaper += 20;
        labelpaper.setLocation(xpaper, ypaper);
        Panelmain.requestFocusInWindow();
        Rectangle rpaper = labelpaper.getBounds();
        Rectangle rtrash = labelTrash.getBounds();
        Rectangle rtrash2 = labelTrash2.getBounds();


//SEGUIR AQUI


        if (rpaper.intersects(rtrash)) {
            score++;
            vidasj2--;
            vidasj2l.setText("J2 VIDAS "+vidasj2);
            labelscore.setText("J1 :" + score + " puntos");
            randomInt = (int) (Math.random() * (panelcenter.getWidth()/2 - labelpaper.getWidth()));
            labelpaper.setLocation(randomInt, 10);
            if(score==5){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA GANADO");
                System.exit(0);
            }


        } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
            randomInt = (int) (Math.random() * (panelcenter.getWidth()/2 - labelpaper.getWidth()));
            labelpaper.setLocation(randomInt, 10);
            vidasj1--;

           if (vidasj1<=0){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA SIDO ELIMINADO");
                System.exit(0);
            }
           vidasj1l.setText("J1 VIDAS "+vidasj1);


        }
//papelera2
if (multi.getText().equalsIgnoreCase("1 player")) {
    if (rpaper.intersects(rtrash2)) {
        score2++;
        vidasj1--;
        vidasj1l.setText("J1 VIDAS "+vidasj1);
        labelscore2.setText("J2 :" + score2 + " puntos");
        randomInt = (int) (Math.random() * (panelcenter.getWidth()/2 - labelpaper.getWidth()));
        labelpaper.setLocation(randomInt, 10);

        if(score2==5){
            JOptionPane.showMessageDialog(panelcenter,"EL J2 HA GANADO");
            System.exit(0);
        }



    } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
        randomInt = (int) (Math.random() * (panelcenter.getWidth()/2 - labelpaper.getWidth()));
        labelpaper.setLocation(randomInt, 10);
        vidasj2--;

         if (vidasj2<=0){
            JOptionPane.showMessageDialog(panelcenter,"EL J2 HA SIDO ELIMINADO");
            System.exit(0);
        }
        vidasj2l.setText("J2 VIDAS "+vidasj2);








    }



}

    }

    public void paper2dif1() {

        ypaper2 = labelpaper2.getY();
        xpaper2 = labelpaper2.getX();
        ypaper2 += 30;
        labelpaper2.setLocation(xpaper2, ypaper2);
        Panelmain.requestFocusInWindow();
        Rectangle rpaper2 = labelpaper2.getBounds();
        Rectangle rtrash = labelTrash.getBounds();
        Rectangle rtrash2 = labelTrash2.getBounds();

        if (rpaper2.intersects(rtrash)) {
            score++;
            vidasj2--;
            vidasj2l.setText("J2 VIDAS "+vidasj2);
            labelscore.setText("J1 :" + score + "  puntos");
            randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
            labelpaper2.setLocation(randomInt2, 10);
            if(score==5){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA GANADO");
                System.exit(0);
            }

        } else if (ypaper2 + labelpaper2.getHeight() >= Panelmain.getHeight() - labelpaper2.getHeight()) {
            randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
            labelpaper2.setLocation(randomInt2, 10);
            vidasj1--;
            if (vidasj1<=0){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA SIDO ELIMINADO");
                System.exit(0);
            }
            vidasj1l.setText("J1 VIDAS "+vidasj1);


        }

        //papelera 2
        if (multi.getText().equalsIgnoreCase("1 player")) {
            if (rpaper2.intersects(rtrash2)) {
                score2++;
                vidasj1--;
                vidasj1l.setText("J1 VIDAS "+vidasj1);
                labelscore2.setText("J2 :" + score2 + "  puntos");
                randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
                labelpaper2.setLocation(randomInt, 10);
                if(score2==5){
                    JOptionPane.showMessageDialog(panelcenter,"EL J2 HA GANADO");
                    System.exit(0);
                }

            } else if (ypaper2 + labelpaper2.getHeight() >= Panelmain.getHeight() - labelpaper2.getHeight()) {
                randomInt2 = (int) (Math.random() * (panelcenter.getWidth() - labelpaper2.getWidth()));
                labelpaper2.setLocation(randomInt2, 10);
                vidasj2--;
                if (vidasj2<=0){
                    JOptionPane.showMessageDialog(panelcenter,"EL J2 HA SIDO ELIMINADO");
                    System.exit(0);
                }
                vidasj2l.setText("J2 VIDAS "+vidasj2);

            }

        }

    }

    public void paper1dif2() { //50 velocidad
        ypaper = labelpaper.getY();
        xpaper = labelpaper.getX();
        ypaper += 50;
        labelpaper.setLocation(xpaper, ypaper);
        Panelmain.requestFocusInWindow();
        Rectangle rpaper = labelpaper.getBounds();
        Rectangle rtrash = labelTrash.getBounds();
        Rectangle rtrash2 = labelTrash2.getBounds();


//SEGUIR AQUI


        if (rpaper.intersects(rtrash)) {
            score++;
            vidasj2--;
            vidasj2l.setText("J2 VIDAS " + vidasj2);
            labelscore.setText("J1 :" + score + " puntos");
            randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
            labelpaper.setLocation(randomInt, 10);
            if (score == 5) {
                JOptionPane.showMessageDialog(panelcenter, "EL J1 HA GANADO");
                System.exit(0);
            }


        } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
            randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
            labelpaper.setLocation(randomInt, 10);
            vidasj1--;

            if (vidasj1 <= 0) {
                JOptionPane.showMessageDialog(panelcenter, "EL J1 HA SIDO ELIMINADO");
                System.exit(0);
            }
            vidasj1l.setText("J1 VIDAS " + vidasj1);


        }
//papelera2
        if (multi.getText().equalsIgnoreCase("1 player")) {
            if (rpaper.intersects(rtrash2)) {
                score2++;
                vidasj1--;
                vidasj1l.setText("J1 VIDAS " + vidasj1);
                labelscore2.setText("J2 :" + score2 + " puntos");
                randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
                labelpaper.setLocation(randomInt, 10);

                if (score2 == 5) {
                    JOptionPane.showMessageDialog(panelcenter, "EL J2 HA GANADO");
                    System.exit(0);
                }


            } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
                randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
                labelpaper.setLocation(randomInt, 10);
                vidasj2--;

                if (vidasj2 <= 0) {
                    JOptionPane.showMessageDialog(panelcenter, "EL J2 HA SIDO ELIMINADO");
                    System.exit(0);
                }
                vidasj2l.setText("J2 VIDAS " + vidasj2);


            }
        }
    }

    public void paper2dif2() { //60
        ypaper2 = labelpaper2.getY();
        xpaper2 = labelpaper2.getX();
        ypaper2 += 60;
        labelpaper2.setLocation(xpaper2, ypaper2);
        Panelmain.requestFocusInWindow();
        Rectangle rpaper2 = labelpaper2.getBounds();
        Rectangle rtrash = labelTrash.getBounds();
        Rectangle rtrash2 = labelTrash2.getBounds();

        if (rpaper2.intersects(rtrash)) {
            score++;
            vidasj2--;
            vidasj2l.setText("J2 VIDAS "+vidasj2);
            labelscore.setText("J1 :" + score + "  puntos");
            randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
            labelpaper2.setLocation(randomInt2, 10);
            if(score==5){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA GANADO");
                System.exit(0);
            }

        } else if (ypaper2 + labelpaper2.getHeight() >= Panelmain.getHeight() - labelpaper2.getHeight()) {
            randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
            labelpaper2.setLocation(randomInt2, 10);
            vidasj1--;
            if (vidasj1<=0){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA SIDO ELIMINADO");
                System.exit(0);
            }
            vidasj1l.setText("J1 VIDAS "+vidasj1);


        }

        //papelera 2
        if (multi.getText().equalsIgnoreCase("1 player")) {
            if (rpaper2.intersects(rtrash2)) {
                score2++;
                vidasj1--;
                vidasj1l.setText("J1 VIDAS "+vidasj1);
                labelscore2.setText("J2 :" + score2 + "  puntos");
                randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
                labelpaper2.setLocation(randomInt, 10);
                if(score2==5){
                    JOptionPane.showMessageDialog(panelcenter,"EL J2 HA GANADO");
                    System.exit(0);
                }

            } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
                randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));
                labelpaper.setLocation(randomInt, 10);
                vidasj2--;
                if (vidasj2<=0){
                    JOptionPane.showMessageDialog(panelcenter,"EL J2 HA SIDO ELIMINADO");
                    System.exit(0);
                }
                vidasj2l.setText("J2 VIDAS "+vidasj2);

            }

        }



    }

    public void paper1dif3() { //100
        ypaper = labelpaper.getY();
        xpaper = labelpaper.getX();
        ypaper += 100;
        labelpaper.setLocation(xpaper, ypaper);
        Panelmain.requestFocusInWindow();
        Rectangle rpaper = labelpaper.getBounds();
        Rectangle rtrash = labelTrash.getBounds();
        Rectangle rtrash2 = labelTrash2.getBounds();


//SEGUIR AQUI


        if (rpaper.intersects(rtrash)) {
            score++;
            vidasj2--;
            vidasj2l.setText("J2 VIDAS " + vidasj2);
            labelscore.setText("J1 :" + score + " puntos");
            randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
            labelpaper.setLocation(randomInt, 10);
            if (score == 5) {
                JOptionPane.showMessageDialog(panelcenter, "EL J1 HA GANADO");
                System.exit(0);
            }


        } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
            randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
            labelpaper.setLocation(randomInt, 10);
            vidasj1--;

            if (vidasj1 <= 0) {
                JOptionPane.showMessageDialog(panelcenter, "EL J1 HA SIDO ELIMINADO");
                System.exit(0);
            }
            vidasj1l.setText("J1 VIDAS " + vidasj1);


        }
//papelera2
        if (multi.getText().equalsIgnoreCase("1 player")) {
            if (rpaper.intersects(rtrash2)) {
                score2++;
                vidasj1--;
                vidasj1l.setText("J1 VIDAS " + vidasj1);
                labelscore2.setText("J2 :" + score2 + " puntos");
                randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
                labelpaper.setLocation(randomInt, 10);

                if (score2 == 5) {
                    JOptionPane.showMessageDialog(panelcenter, "EL J2 HA GANADO");
                    System.exit(0);
                }


            } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
                randomInt = (int) (Math.random() * (panelcenter.getWidth() / 2 - labelpaper.getWidth()));
                labelpaper.setLocation(randomInt, 10);
                vidasj2--;

                if (vidasj2 <= 0) {
                    JOptionPane.showMessageDialog(panelcenter, "EL J2 HA SIDO ELIMINADO");
                    System.exit(0);
                }
                vidasj2l.setText("J2 VIDAS " + vidasj2);


            }
        }
    }

    public void paper2dif3() { //110
        ypaper2 = labelpaper2.getY();
        xpaper2 = labelpaper2.getX();
        ypaper2 += 110;
        labelpaper2.setLocation(xpaper2, ypaper2);
        Panelmain.requestFocusInWindow();
        Rectangle rpaper2 = labelpaper2.getBounds();
        Rectangle rtrash = labelTrash.getBounds();
        Rectangle rtrash2 = labelTrash2.getBounds();

        if (rpaper2.intersects(rtrash)) {
            score++;
            vidasj2--;
            vidasj2l.setText("J2 VIDAS "+vidasj2);
            labelscore.setText("J1 :" + score + "  puntos");
            randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
            labelpaper2.setLocation(randomInt2, 10);
            if(score==5){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA GANADO");
                System.exit(0);
            }

        } else if (ypaper2 + labelpaper2.getHeight() >= Panelmain.getHeight() - labelpaper2.getHeight()) {
            randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
            labelpaper2.setLocation(randomInt2, 10);
            vidasj1--;
            if (vidasj1<=0){
                JOptionPane.showMessageDialog(panelcenter,"EL J1 HA SIDO ELIMINADO");
                System.exit(0);
            }
            vidasj1l.setText("J1 VIDAS "+vidasj1);


        }

        //papelera 2
        if (multi.getText().equalsIgnoreCase("1 player")) {
            if (rpaper2.intersects(rtrash2)) {
                score2++;
                vidasj1--;
                vidasj1l.setText("J1 VIDAS "+vidasj1);
                labelscore2.setText("J2 :" + score2 + "  puntos");
                randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
                labelpaper2.setLocation(randomInt, 10);
                if(score2==5){
                    JOptionPane.showMessageDialog(panelcenter,"EL J2 HA GANADO");
                    System.exit(0);
                }

            } else if (ypaper + labelpaper.getHeight() >= Panelmain.getHeight() - labelpaper.getHeight()) {
                randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));
                labelpaper.setLocation(randomInt, 10);
                vidasj2--;
                if (vidasj2<=0){
                    JOptionPane.showMessageDialog(panelcenter,"EL J2 HA SIDO ELIMINADO");
                    System.exit(0);
                }
                vidasj2l.setText("J2 VIDAS "+vidasj2);

            }

        }


    }


    private class actionDificultad implements ActionListener {
        Timer t;

        public actionDificultad(Timer t) {
            this.t = t;

        }


        @Override
        public void actionPerformed(ActionEvent e) {
            dificultad2 = (JComboBox<String>) e.getSource();
            String opcion = (String) dificultad2.getSelectedItem();

            switch (opcion) {
                case "Dificultad 1":
                    //seguir aqui

                    System.out.println("d1");
                    break;
                case "Dificultad 2":

                    System.out.println("d2");
                    break;
                case "Dificultad 3":
                    System.out.println("d3");
                    break;

            }

        }
    }

    private class panelMainListener extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {

            super.keyPressed(e);
            x = labelTrash.getX();
            x2 = labelTrash2.getX();

            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> x += 15;

                case KeyEvent.VK_LEFT -> x -= 15;
                // case KeyEvent.VK_A -> JOptionPane.showMessageDialog(panelcenter, "Adios");
                case KeyEvent.VK_A -> x2 -= 15;
                case KeyEvent.VK_D -> x2 += 15;

            }
            if (x >= 0 && x <= Panelmain.getWidth() - labelTrash.getWidth()) {
                labelTrash.setLocation(x, labelTrash.getY());
            }
            if (x2 >= 0 && x2 <= Panelmain.getWidth() - labelTrash2.getWidth()) {
                labelTrash2.setLocation(x2, labelTrash2.getY());
            }

        }
    }


    public class buttonresetlistener extends MouseAdapter {
        Timer t;
        Timer t2;

        public buttonresetlistener(Timer t, Timer t2) {
            this.t = t;
            this.t2 = t2;
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            //super.mouseClicked(e);
            score = 0;
            score2 = 0;
            labelscore.setText("J1 : " + score + "  puntos");
            labelscore2.setText("J2 : " + score2 + " puntos");
            if (buttonreset.getText().equalsIgnoreCase("Reiniciar") && buttonpause.getText().equalsIgnoreCase("Pausar")) {
                t.stop();
                t.restart();
                t2.stop();
                t2.restart();
                randomInt = (int) (Math.random() * (panelcenter.getWidth()/2 - labelpaper.getWidth()));
                randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2-labelpaper2.getWidth()+1))+panelcenter.getWidth()/2;


                labelpaper.setLocation(randomInt, 10);
                labelpaper2.setLocation(randomInt2, 10);


                gameStarted = true;
                Panelmain.requestFocusInWindow();
                seconds = 0;


            }


        }
    }

    public class multibuttonlister extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (multi.getText().equalsIgnoreCase("Multiplayer")) {
                panelcenter.add(labelTrash2);
                multi.setText("1 player");
                labelTrash.setLocation(200-labelTrash.getWidth()/2, panelcenter.getHeight() - labelTrash.getHeight());
                labelTrash2.setLocation(600-labelTrash2.getWidth()/2, panelcenter.getHeight() - labelTrash.getHeight());
               // labelTrash.setLocation(panelcenter.getWidth() / 4 - labelTrash.getWidth() / 2, panelcenter.getHeight() - labelTrash.getHeight());
             //  labelTrash2.setLocation(panelcenter.getWidth() / 2 + labelTrash.getWidth() ,panelcenter.getHeight() - labelTrash.getHeight());
            } else if (multi.getText().equalsIgnoreCase("1 player")) {
                multi.setText("Multiplayer");
                panelcenter.remove(labelTrash2);
                panelcenter.repaint();
            }


        }
    }

    public class buttonpauselistener extends MouseAdapter {
        Timer t;
        Timer t2;

        public buttonpauselistener(Timer t, Timer t2) {
            this.t = t;
            this.t2 = t2;

        }


        @Override
        public void mouseClicked(MouseEvent e) {
            // super.mouseClicked(e);
            if (buttonpause.getText().equalsIgnoreCase("Iniciar juego")) {
                buttonpause.setText("Pausar");
                t.start();
                t2.start();


                gameStarted = true;
                Panelmain.requestFocusInWindow();
            } else if (buttonpause.getText().equalsIgnoreCase("Pausar")) {

                t.stop();
                t2.stop();
                gameStarted = false;
                buttonpause.setText("Iniciar juego");

            }


        }
    }


    private class TimerActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds++;
            labeltime.setText(seconds + " segundos");


        }
    }


    private class TimerActionListener implements ActionListener {
        JComboBox dif;


        public TimerActionListener(JComboBox dif) {
            this.dif = dif;


        }

        @Override
        public void actionPerformed(ActionEvent e) {
//SEGUIR AQUI , FALTA PROGRAMAR QUE SI TOCA EL FRAME POR LA PARTE DE ABAJO VUELVA A PONERSE EL PAPEL ARRIBA

            if (dif.getSelectedItem().equals("Dificultad 1")) {
                //  seconds++;
                // labeltime.setText(seconds + " segundos");

                paper1dif1();

// movimiento del papel2

                paper2dif1();


            } else if (dif.getSelectedItem().equals("Dificultad 2")) {
                // seconds++;
                //   labeltime.setText(seconds + " segundos");
                paper1dif2();


                // AQUI EL ELSE SI NO ENCUENTRA LA PAPELERA


                paper2dif2();


            } else if (dif.getSelectedItem().equals("Dificultad 3")) {
                // seconds++;
                // labeltime.setText(seconds + " segundos");

                paper1dif3();
                paper2dif3();
            }


        }

    }


    private static class wellcome extends WindowAdapter {
        @Override
        public void windowOpened(WindowEvent e) {
            super.windowOpened(e);
            JOptionPane.showMessageDialog(null, "bienvenido");
        }
    }


    private static class exitwindows extends WindowAdapter {

        JFrame frame;

        public exitwindows(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            int confirmado = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar la ventana?", "Alerta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmado == JOptionPane.YES_OPTION) {
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            } else {
                frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

            }

        }
    }


    public static void main(String[] args) {


        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().Panelmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(350, 100);
        frame.setLayout(null);
        // frame.addWindowListener(new wellcome());
        frame.addWindowListener(new exitwindows(frame));


        //cambia el icono
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("src/av.png");
        frame.setIconImage(icono);





    }

    private void showPaper() {
        labelpaper = new JLabel();
        labelpaper.setSize(50, 50);
        ImageIcon imageicon = new ImageIcon("src/images/paper.png");
        Icon icon = new ImageIcon(imageicon.getImage().getScaledInstance(labelTrash.getWidth(), labelTrash.getHeight(), Image.SCALE_DEFAULT));
        randomnum = Math.random() * panelcenter.getWidth();

        randomInt = (int) (Math.random() * (panelcenter.getWidth()/2 - labelpaper.getWidth()));
        labelpaper.setIcon(icon);
        //intento de que no se repita

             randomInt = (int) (Math.random() * (panelcenter.getWidth()/2 - labelpaper.getWidth()));
        System.out.println(randomInt);


         //   randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));





        labelpaper.setLocation(randomInt, 10);


        panelcenter.add(labelpaper);
    }

    private void showPaper2() {
        labelpaper2 = new JLabel();
        labelpaper2.setSize(50, 50);
        ImageIcon imageicon = new ImageIcon("src/images/paper.png");
        Icon icon = new ImageIcon(imageicon.getImage().getScaledInstance(labelTrash.getWidth(), labelTrash.getHeight(), Image.SCALE_DEFAULT));
        randomnum2 = Math.random() * panelcenter.getWidth();
        //800 ancho total
        randomInt2 = (int) (Math.random() * (panelcenter.getWidth()-panelcenter.getWidth()/2+1))+panelcenter.getWidth()/2;
        System.out.println(randomInt2);
      // luego restaurar  randomInt2 = (int) (Math.random() * (panelcenter.getWidth() - labelpaper2.getWidth()));
        labelpaper2.setIcon(icon);

        labelpaper2.setLocation(randomInt2, 10);

        panelcenter.add(labelpaper2);

    }


    private void showTrash() {
        labelTrash = new JLabel();
        labelTrash.setSize(90, 100);
        ImageIcon imageicon = new ImageIcon("src/images/trash.png");
        Icon icon = new ImageIcon(imageicon.getImage().getScaledInstance(labelTrash.getWidth(), labelTrash.getHeight(), Image.SCALE_DEFAULT));

        labelTrash.setIcon(icon);

        labelTrash.setLocation(panelcenter.getWidth() / 2 - labelTrash.getWidth() / 2, panelcenter.getHeight() - labelTrash.getHeight());


        panelcenter.add(labelTrash);


    }

    private void showTrash2() {
        labelTrash2 = new JLabel();
        labelTrash2.setSize(90, 100);
        ImageIcon imageicon = new ImageIcon("src/images/t.png");
        Icon icon2 = new ImageIcon(imageicon.getImage().getScaledInstance(labelTrash2.getWidth(), labelTrash2.getHeight(), Image.SCALE_DEFAULT));

        labelTrash2.setIcon(icon2);

        labelTrash2.setLocation(panelcenter.getWidth() / 2 - labelTrash2.getWidth() / 2, panelcenter.getHeight() - labelTrash2.getHeight());


    }

    private void showPaneltitulo() {
        paneltitulo = new JPanel();
        paneltitulo.setLocation(0, 0);
        paneltitulo.setSize(Panelmain.getWidth(), 50);
        paneltitulo.setBackground(Color.RED);
        Panelmain.add(paneltitulo);
//label de los segundos
        labeltime = new JLabel();
        labeltime.setText("0 segundos");
        paneltitulo.add(labeltime);


        //label de los puntos
        labelscore = new JLabel();
        labelscore.setText("J1 :" + score + "puntos");

        paneltitulo.add(labelscore);
        labelscore2 = new JLabel();
        labelscore2.setText("J2 :" + score2 + " puntos");
        paneltitulo.add(labelscore2);


        //label vidas
        vidasj1l= new JLabel();
        vidasj1l.setText("J1 VIDAS "+vidasj1);
        paneltitulo.add(vidasj1l);


        vidasj2l= new JLabel();
        vidasj2l.setText("J2 VIDAS : "+ vidasj2);
        paneltitulo.add(vidasj2l);




        //boton pausa

        buttonpause = new JButton();
        buttonpause.setFocusPainted(false);

        buttonpause.setBackground(new Color(25, 18, 50));
        buttonpause.setText("Iniciar juego");
        buttonpause.setForeground(Color.white);
        paneltitulo.add(buttonpause);


//boton reset
        buttonreset = new JButton();
        buttonreset.setFocusPainted(false);
        buttonreset.setBackground(new Color(25, 18, 50));
        buttonreset.setForeground(Color.white);
        buttonreset.setText("Reiniciar");
        paneltitulo.add(buttonreset);


        //boton desplegable
        String[] opciones = {"Dificultad 1", "Dificultad 2", "Dificultad 3"};
        dificultad2 = new JComboBox<String>(opciones);
        dificultad2.setPreferredSize(new Dimension(100, 20));

        paneltitulo.add(dificultad2);


        multi = new JButton();
        multi.setFocusPainted(false);
        multi.setText("Multiplayer");
        multi.setBackground(new Color(25, 18, 50));
        multi.setForeground(Color.white);
        paneltitulo.add(multi);


    }

    private void showPanelcenter() {
        panelcenter = new JPanel();
        panelcenter.setLayout(null);
        panelcenter.setLocation(0, paneltitulo.getHeight());
        panelcenter.setSize(Panelmain.getWidth(), Panelmain.getHeight() - paneltitulo.getHeight());
        panelcenter.setBackground(Color.LIGHT_GRAY);
        Panelmain.add(panelcenter);
        showTrash();
        showTrash2();
        showPaper();
        showPaper2();

    }


}

