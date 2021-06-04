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

    JButton restart = new JButton();

    // ---------------------variables-------------
    private final int X = 700;
    private final int Y = 600;

    ImageIcon icon = new ImageIcon("res/images/dead.jpg");
    Image im = icon.getImage().getScaledInstance(X, Y, Image.SCALE_SMOOTH);

    public GameOver() {

        restart.setBounds(250, 370, 200, 100);
        restart.setBorderPainted(false);
        restart.setContentAreaFilled(false);
        restart.setOpaque(false);
        restart.setFocusable(false);
        restart.setText("Restart");
        restart.setFont(new Font("Aerial", Font.BOLD, 35));
        restart.setForeground(Color.white);
        restart.addActionListener(this);

        mainlabel.setBounds(0, 0, X, Y);
        mainlabel.setIcon(new ImageIcon(im));
        mainlabel.add(restart);
        mainlabel.setLayout(null);

        frame.setSize(X, Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
        frame.add(mainlabel);
    }

    public static void main(String[] args) {
        new GameOver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restart) {
            frame.dispose();
            new Game();
        }

    }
}
