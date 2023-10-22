import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main2 {
    private JPanel panelmain;

    private JPanel paneltitulo;
    private JPanel panelcenter;
    private JPanel panelcenter2;

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


    private JLabel labelscore2;
    private JLabel labelTrash2;
    private JButton multi;
    private static int vidasj1=3;
    private static int vidasj2=3;
    private boolean gameFinished;
    private final int dificultad1 =40;
    private final int dificultad2 =80;
    private final int dificultad3 =120;
    private JButton dificultad;


    public Main2(){ // tamaño original es 800 ancho 600 alto
        panelmain.setPreferredSize(new Dimension(800, 600));
        panelmain.setSize(new Dimension(800, 600));
        panelmain.setLayout(null);
        panelmain.setFocusable(true);

        Timer t2 = new Timer(250, new TimerActionListener2());
        Timer t = new Timer(1000, new TimerActionListener());

        showPaneltitulo();
        showpanelcenter1();
        showpanelcenter2();

        panelmain.addKeyListener(new panelcenter1listener());
        panelmain.addKeyListener(new panelcenter2listener());
        buttonpause.addMouseListener(new buttonpauselistener( t,t2));
        buttonreset.addMouseListener(new buttonresetlistener(t,t2));
        dificultad.addMouseListener(new buttondiflistener(t2) );






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
//AQUI
                randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));
                randomInt2 = (int) (Math.random() * (panelcenter2.getWidth()-labelpaper2.getWidth()));



                labelpaper.setLocation(randomInt, 60);
                labelpaper2.setLocation(randomInt2, 60);


                gameStarted = true;
                panelmain.requestFocusInWindow();
                seconds = 0;


            }


        }
    }













    private void showPaneltitulo() {


        paneltitulo = new JPanel();
        paneltitulo.setLocation(0, 0);
        paneltitulo.setSize(panelmain.getWidth(), 50);
        paneltitulo.setBackground(Color.RED);
        panelmain.add(paneltitulo);
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

dificultad = new JButton();
dificultad.setFocusPainted(false);
        dificultad.setBackground(new Color(25, 18, 50));
       dificultad.setForeground(Color.white);
        dificultad.setText("Dificultad 2");
        paneltitulo.add(dificultad);






    }
  private void showpanelcenter1(){
        panelcenter = new JPanel();
        panelcenter.setLayout(null);
      panelcenter.setSize(panelmain.getWidth()/2, panelmain.getHeight() );
      panelcenter.setBackground(Color.white);
      panelmain.add(panelcenter);
      panelcenter.setFocusable(true);

      showTrash();
      showPaper();


  }

private class panelcenter2listener extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);


        x2 = labelTrash2.getX();
        switch (e.getKeyCode()) {

            // case KeyEvent.VK_A -> JOptionPane.showMessageDialog(panelcenter, "Adios");

            case KeyEvent.VK_RIGHT -> x2 += 15;

            case KeyEvent.VK_LEFT -> x2 -= 15;
        }

        if (x2 >= 0 && x2 <= panelcenter2.getWidth() - labelTrash2.getWidth()) {
            labelTrash2.setLocation(x2, labelTrash2.getY());
        }

    }
}
    private class panelcenter1listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            super.keyPressed(e);
            x = labelTrash.getX();
            x2 = labelTrash2.getX();

            switch (e.getKeyCode()) {
                case KeyEvent.VK_A -> x -= 15;
                case KeyEvent.VK_D -> x += 15;
                // case KeyEvent.VK_A -> JOptionPane.showMessageDialog(panelcenter, "Adios");

            }
            if (x >= 0 && x <= panelcenter.getWidth() - labelTrash.getWidth()) {
                labelTrash.setLocation(x, labelTrash.getY());
            }


        }

    }

    private void showpanelcenter2(){
        panelcenter2 = new JPanel();

        panelcenter2.setLayout(null);
        panelcenter2.setSize(panelmain.getWidth()/2, panelmain.getHeight() );
        panelcenter2.setLocation(400,0);
        panelcenter2.setBackground(Color.black);
        panelmain.add(panelcenter2);
        showTrash2();
        showPaper2();
        panelcenter2.setFocusable(true);

    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("Main2");
        frame.setContentPane(new Main2().panelmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(350, 100);
        frame.setLayout(null);
       //  frame.addWindowListener(new wellcome());
       // frame.addWindowListener(new Main.exitwindows(frame));


        //cambia el icono
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("src/av.png");
        frame.setIconImage(icono);





    }

public void paper1mov(int dif){
    ypaper = labelpaper.getY();
    xpaper = labelpaper.getX();
    ypaper += dif;
    labelpaper.setLocation(xpaper, ypaper);
    panelmain.requestFocusInWindow();

    Rectangle rpaper = labelpaper.getBounds();
    Rectangle rtrash = labelTrash.getBounds();
   // Rectangle rtrash2 = labelTrash2.getBounds();
    if (rpaper.intersects(rtrash)) {
        score++;


        labelscore.setText("J1 :" + score + " puntos");
        randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));
        labelpaper.setLocation(randomInt, 60);
        if(score==5){
            JOptionPane.showMessageDialog(panelcenter,"EL J1 HA GANADO");
            System.exit(0);
        }


    } else if (ypaper + labelpaper.getHeight() >= panelmain.getHeight() - labelpaper.getHeight()) {
        randomInt = (int) (Math.random() * (panelcenter2.getWidth() - labelpaper.getWidth()));
        labelpaper.setLocation(randomInt, 60);
vidasj1--;
        vidasj1l.setText("J1 VIDAS "+vidasj1);
        if (vidasj1<=0){
            JOptionPane.showMessageDialog(panelcenter,"EL J1 HA SIDO ELIMINADO");
            System.exit(0);
        }



    }


}


public void paper2mov(int dif){
    ypaper2 = labelpaper2.getY();
    xpaper2 = labelpaper2.getX();
    ypaper2 += dif;
    labelpaper2.setLocation(xpaper2, ypaper2);
    panelmain.requestFocusInWindow();
    Rectangle rpaper2 = labelpaper2.getBounds();
  //  Rectangle rtrash = labelTrash.getBounds();
    Rectangle rtrash2 = labelTrash2.getBounds();
    if (rpaper2.intersects(rtrash2)) {
        score2++;


        labelscore2.setText("J2 :" + score2 + " puntos");
        randomInt2 = (int) (Math.random() * (panelcenter2.getWidth() - labelpaper2.getWidth()));
        labelpaper2.setLocation(randomInt2, 60);
        if(score2==5){
            JOptionPane.showMessageDialog(panelcenter2,"EL J2 HA GANADO");
            System.exit(0);
        }


    } else if (ypaper2 + labelpaper2.getHeight() >= panelmain.getHeight() - labelpaper2.getHeight()) {
        randomInt2 = (int) (Math.random() * (panelcenter2.getWidth() - labelpaper2.getWidth()));
        labelpaper2.setLocation(randomInt2, 60);
        vidasj2--;
        vidasj2l.setText("J2 VIDAS "+vidasj2);

        if (vidasj2<=0){
            JOptionPane.showMessageDialog(panelcenter,"EL J2 HA SIDO ELIMINADO");
            System.exit(0);
        }



    }

}






    private class buttondiflistener extends MouseAdapter{
        Timer t2;
        public buttondiflistener(Timer t2){
            this.t2=t2;

        }
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(dificultad.getText().equalsIgnoreCase("Dificultad 2")){

                paper1mov(dificultad2);
                paper2mov(dificultad2);
                dificultad.setText("Dificultad 3");


            }
            else if (dificultad.getText().equalsIgnoreCase("Dificultad 3")){

                paper1mov(dificultad3);
                paper2mov(dificultad3);
                dificultad.setText("Dificultad 1");
            }
  else if(dificultad.getText().equalsIgnoreCase("Dificultad 1")){
      paper1mov(dificultad1);
      paper2mov(dificultad1);
      dificultad.setText("Dificultad 2");
            }





            }








        }



    public class buttonpauselistener extends MouseAdapter {
        Timer t;
        Timer t2;

        public buttonpauselistener(Timer t,Timer t2) {
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
                panelmain.requestFocusInWindow();
            } else if (buttonpause.getText().equalsIgnoreCase("Pausar")) {

                t.stop();
                t2.stop();
                gameStarted = false;
                buttonpause.setText("Iniciar juego");

            }


        }
    }
    private void showPaper() {
        labelpaper = new JLabel();
        labelpaper.setSize(50, 50);
        ImageIcon imageicon = new ImageIcon("src/images/paper.png");
        Icon icon = new ImageIcon(imageicon.getImage().getScaledInstance(labelTrash.getWidth(), labelTrash.getHeight(), Image.SCALE_DEFAULT));
        randomnum = Math.random() * panelcenter.getWidth();

        randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));
        labelpaper.setIcon(icon);
        //intento de que no se repita

        randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));
        System.out.println(randomInt);


        //   randomInt = (int) (Math.random() * (panelcenter.getWidth() - labelpaper.getWidth()));





        labelpaper.setLocation(randomInt, 60);


        panelcenter.add(labelpaper);
    }

    private void showPaper2() {
        labelpaper2 = new JLabel();
        labelpaper2.setSize(50, 50);
        ImageIcon imageicon = new ImageIcon("src/images/paper.png");
        Icon icon = new ImageIcon(imageicon.getImage().getScaledInstance(labelTrash.getWidth(), labelTrash.getHeight(), Image.SCALE_DEFAULT));
      //  randomnum2 = Math.random() * panelcenter2.getWidth();
        //800 ancho total
        randomInt2 = (int) (Math.random() * (panelcenter2.getWidth() - labelpaper2.getWidth()));
        System.out.println(randomInt2);
        // luego restaurar  randomInt2 = (int) (Math.random() * (panelcenter.getWidth() - labelpaper2.getWidth()));
        labelpaper2.setIcon(icon);

        labelpaper2.setLocation(randomInt2, 60);

        panelcenter2.add(labelpaper2);

    }





private class TimerActionListener2 implements ActionListener {



    @Override

        public void actionPerformed(ActionEvent e) {
//SEGUIR AQUI , FALTA PROGRAMAR QUE SI TOCA EL FRAME POR LA PARTE DE ABAJO VUELVA A PONERSE EL PAPEL ARRIBA


            if (dificultad.getText().equals("Dificultad 1")) {
                //  seconds++;
                // labeltime.setText(seconds + " segundos");
                paper1mov(dificultad1);
                paper2mov(dificultad1);



// movimiento del papel2




            } else if (dificultad.getText().equals("Dificultad 2")) {
                // seconds++;
                //   labeltime.setText(seconds + " segundos");
                paper1mov(dificultad2);
                paper2mov(dificultad2);



                // AQUI EL ELSE SI NO ENCUENTRA LA PAPELERA




            } else if (dificultad.getText().equals("Dificultad 3")) {
                // seconds++;
                // labeltime.setText(seconds + " segundos");
                paper1mov(dificultad3);
                paper2mov(dificultad3);


            }


        }







    }



    private class TimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds++;
            labeltime.setText(seconds + " segundos");


        }
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

        labelTrash2.setLocation(panelcenter2.getWidth() / 2 - labelTrash2.getWidth() / 2, panelcenter2.getHeight() - labelTrash2.getHeight());
panelcenter2.add(labelTrash2);

    }









}
