package Screens;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen implements ActionListener {
    JFrame frame = new JFrame();

    JLabel mainlabel = new JLabel();

    JPanel headpanel = new JPanel();
    JPanel mainpanel = new JPanel();

    JButton exit = new JButton("X");
    JButton start = new JButton("Play");

    // --------------------- varibles --------------------------
    private final int X = 700;
    private final int Y = 600;

    private final Color primaryColor = new Color(28, 27, 27);

    ImageIcon icon = new ImageIcon("res/images/m.jpg");
    Image im = icon.getImage().getScaledInstance(700, 600, Image.SCALE_FAST);

    public HomeScreen() {
        exit.setBounds(640, 0, 60, 50);
        exit.setFocusable(false);
        exit.setOpaque(false);
        exit.setFont(new Font("San Serif", Font.BOLD, 25));
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setForeground(Color.white);
        exit.setLayout(null);
        exit.addActionListener(e -> frame.dispose());

        headpanel.setBounds(0, 0, X, 50);
        headpanel.setOpaque(false);
        headpanel.add(exit);
        headpanel.setLayout(null);

        start.setBounds(320, 320, 120, 65);
        start.setFocusable(false);
        start.setOpaque(false);
        start.setFont(new Font("San Serif", Font.BOLD, 35));
        // start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        start.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(0, 214, 203)));

        start.setForeground(Color.white);
        start.setLayout(null);
        start.addActionListener(this);

        mainlabel.setBounds(0, 0, X, Y);
        mainlabel.setIcon(new ImageIcon(im));
        mainlabel.add(headpanel);
        mainlabel.add(start);
        mainlabel.setLayout(null);

        mainpanel.setBounds(0, 0, X, Y);
        mainpanel.setBackground(primaryColor);
        mainpanel.add(mainlabel);
        mainpanel.setLayout(null);

        frame.setSize(X, Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.add(mainpanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            frame.dispose();
            new Game();
        }

    }
}
