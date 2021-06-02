package Screens;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class HomeScreen {
    JFrame frame = new JFrame();

    JPanel headpanel = new JPanel();
    JPanel mainpanel = new JPanel();

    JButton exit = new JButton("X");

    // --------------------- varibles --------------------------
    private final int X = 700;
    private final int Y = 600;

    private final Color primaryColor = new Color(28, 27, 27);

    HomeScreen() {
        exit.setBounds(620, 0, 80, 50);
        exit.setFocusable(false);
        exit.setFont(new Font("San Serif", Font.BOLD, 25));
        exit.setBorderPainted(false);
        exit.setForeground(Color.red);
        exit.setBackground(new Color(33, 32, 32));
        exit.setLayout(null);
        exit.addActionListener(e -> frame.dispose());

        headpanel.setBounds(0, 0, X, 50);
        headpanel.setBackground(new Color(33, 32, 32));
        headpanel.add(exit);
        headpanel.setLayout(null);

        mainpanel.setBounds(0, 0, X, Y);
        mainpanel.setBackground(primaryColor);
        mainpanel.add(headpanel);
        mainpanel.setLayout(null);

        frame.setSize(X, Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.add(mainpanel);
    }

    public static void main(String[] args) {
        new HomeScreen();
    }
}
