package Screens;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class GameOver implements ActionListener {
    JFrame frame = new JFrame();

    JLabel mainlabel = new JLabel();
    JLabel resultlabel = new JLabel();

    JButton restart = new JButton();

    // ---------------------variables-------------
    private final int X = 700;
    private final int Y = 600;

    private String meow = "";

    ImageIcon icon = new ImageIcon("res/images/dead.jpg");
    Image im = icon.getImage().getScaledInstance(X, Y, Image.SCALE_SMOOTH);

    public void start() {

        restart.setBounds(250, 370, 200, 100);
        restart.setBorderPainted(false);
        restart.setContentAreaFilled(false);
        restart.setOpaque(false);
        restart.setFocusable(false);
        restart.setText("Restart");
        restart.setFont(new Font("Aerial", Font.BOLD, 35));
        restart.setForeground(Color.white);
        restart.addActionListener(this);

        resultlabel.setText(meow);
        resultlabel.setBounds(310, 460, 200, 100);
        resultlabel.setFont(new Font("Aerial", Font.BOLD, 30));
        resultlabel.setForeground(Color.white);
        resultlabel.setOpaque(false);

        mainlabel.setBounds(0, 0, X, Y);
        mainlabel.setIcon(new ImageIcon(im));
        mainlabel.add(restart);
        mainlabel.add(resultlabel);
        mainlabel.setLayout(null);

        frame.setSize(X, Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.black);
        frame.add(mainlabel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GameOver();
    }

    public void checkResult(int i) {
        if (i == 1) {
            System.out.println("You win");
            meow = "You Win";
            resultlabel.setText(meow);
        }
        if (i == 0) {
            System.out.println("You Lose");
            meow = "You Lose";
            resultlabel.setText(meow);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restart) {
            try {
                frame.dispose();
            } catch (Exception a) {
                System.out.println("System is Fucke*");
                a.printStackTrace();
            } finally {
                Game g = new Game();
            }
        }

    }
}
