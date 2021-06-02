import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Game implements ActionListener {
	JFrame frame = new JFrame("Tic Tac Toe");

	JLabel gamelabel = new JLabel();
	JLabel winlose = new JLabel();

	JPanel headpanel = new JPanel();
	JPanel mainpanel = new JPanel();
	JPanel bottompanel = new JPanel();
	JPanel middlepanel = new JPanel();

	JButton settings = new JButton();
	JButton exit = new JButton();
	JButton back = new JButton();
	JButton restart = new JButton();

	ImageIcon exiticon = new ImageIcon("res/images/exit.png");
	ImageIcon exit1 = new ImageIcon("res/images/exitbutton.png");
	ImageIcon back1 = new ImageIcon("res/images/back.png");
	ImageIcon backbutton = new ImageIcon("res/images/backbutton.png");
	ImageIcon sett = new ImageIcon("res/images/settings.png");
	ImageIcon settings1 = new ImageIcon("res/images/settings1.png");
	ImageIcon frameicon = new ImageIcon("res/images/xo.png");
	ImageIcon gameicon = new ImageIcon("res/images/xo1.jpeg");
	ImageIcon repeat = new ImageIcon("res/images/repeat.png");
	ImageIcon repeat1 = new ImageIcon("res/images/repeat1.jpeg");
	ImageIcon X = new ImageIcon("res/images/X.jpeg");
	ImageIcon Y = new ImageIcon("res/images/O.jpeg");

	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	JButton b7 = new JButton();
	JButton b8 = new JButton();
	JButton b9 = new JButton();

	int counter = 0;
	int[] arr = new int[9];
	int[] test = new int[9];
	int[][] check = new int[3][3];
	int[] meow = new int[10];

	Game() {
		exit.setBounds(450, 0, 50, 50);
		exit.setFocusable(false);
		exit.setIcon(changedimension(exiticon, 50, 50));
		exit.addActionListener(e -> frame.dispose());
		exit.setBackground(Color.gray);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exit.setIcon(changedimension(exit1, 40, 40));
			}

			public void mouseExited(MouseEvent e) {
				exit.setIcon(changedimension(exiticon, 50, 50));
			}
		});

		back.setBounds(0, 0, 50, 50);
		back.setFocusable(false);
		back.setIcon(changedimension(backbutton, 50, 50));
		back.addActionListener(e -> frame.dispose());
		back.setBackground(Color.gray);
		back.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				back.setIcon(changedimension(back1, 40, 40));
			}

			public void mouseExited(MouseEvent e) {
				back.setIcon(changedimension(backbutton, 50, 50));
			}
		});

		restart.setBounds(400, 0, 50, 50);
		restart.setFocusable(false);
		restart.setIcon(changedimension(repeat, 60, 50));
		restart.addActionListener(this);
		restart.setBackground(Color.gray);
		restart.setText("Restart");
		restart.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				restart.setIcon(changedimension(repeat1, 60, 50));
			}

			public void mouseExited(MouseEvent e) {
				restart.setIcon(changedimension(repeat, 60, 50));
			}
		});

		settings.setBounds(0, 0, 50, 50);
		settings.setFocusable(false);
		settings.setIcon(changedimension(sett, 50, 50));
		settings.addActionListener(e -> frame.dispose());
		settings.setBackground(Color.gray);
		settings.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				settings.setIcon(changedimension(settings1, 50, 50));
			}

			public void mouseExited(MouseEvent e) {
				settings.setIcon(changedimension(sett, 50, 50));
			}
		});

		gamelabel.setBounds(225, 0, 50, 50);
		gamelabel.setBackground(Color.gray);
		gamelabel.setIcon(changedimension(gameicon, 50, 50));

		headpanel.setBounds(0, 0, 500, 50);
		headpanel.setBackground(Color.gray);
		headpanel.setLayout(null);
		headpanel.add(exit);
		// headpanel.add(settings);
		headpanel.add(restart);
		headpanel.add(back);
		headpanel.add(gamelabel);

		b1.setBounds(0, 0, 100, 100);
		b1.setFocusable(false);
		b1.addActionListener(this);

		b2.setBounds(100, 0, 100, 100);
		b2.setFocusable(false);
		b2.addActionListener(this);

		b3.setBounds(200, 0, 100, 100);
		b3.setFocusable(false);
		b3.addActionListener(this);

		b4.setBounds(0, 100, 100, 100);
		b4.setFocusable(false);
		b4.addActionListener(this);

		b5.setBounds(100, 100, 100, 100);
		b5.setFocusable(false);
		b5.addActionListener(this);

		b6.setBounds(200, 100, 100, 100);
		b6.setFocusable(false);
		b6.addActionListener(this);

		b7.setBounds(0, 200, 100, 100);
		b7.setFocusable(false);
		b7.addActionListener(this);

		b8.setBounds(100, 200, 100, 100);
		b8.setFocusable(false);
		b8.addActionListener(this);

		b9.setBounds(200, 200, 100, 100);
		b9.setFocusable(false);
		b9.addActionListener(this);

		middlepanel.setBounds(100, 100, 300, 300);
		middlepanel.setBackground(Color.gray);
		middlepanel.add(settings);
		middlepanel.setLayout(null);
		middlepanel.add(b1);
		middlepanel.add(b2);
		middlepanel.add(b3);
		middlepanel.add(b4);
		middlepanel.add(b5);
		middlepanel.add(b6);
		middlepanel.add(b7);
		middlepanel.add(b8);
		middlepanel.add(b9);

		winlose.setBounds(200, 0, 200, 50);
		winlose.setText("You win!!");
		winlose.setBackground(Color.gray);
		winlose.setForeground(Color.red);
		winlose.setFont(new Font("MV Boli", Font.BOLD, 25));
		winlose.setLayout(null);
		winlose.setVisible(false);

		bottompanel.setBounds(0, 450, 500, 50);
		bottompanel.setBackground(Color.gray);
		bottompanel.add(settings);
		bottompanel.add(winlose);
		bottompanel.setLayout(null);

		mainpanel.setBounds(0, 0, 500, 500);
		mainpanel.setLayout(null);
		mainpanel.add(headpanel);
		mainpanel.add(bottompanel);
		mainpanel.add(middlepanel);

		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.add(mainpanel);
		frame.setIconImage(changedimension(frameicon, 50, 50).getImage());
	}

	public ImageIcon changedimension(ImageIcon icon, int x, int y) {
		Image image = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon newicon = new ImageIcon(image);
		return newicon;
	}

	public int check() {
		if (meowchecker(1) == true) {
			counter++;
			arr[counter - 1] = 1;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(2) == true) {
			counter++;
			arr[counter - 1] = 2;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(3) == true) {
			counter++;
			arr[counter - 1] = 3;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(4) == true) {
			counter++;
			arr[counter - 1] = 4;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(5) == true) {
			counter++;
			arr[counter - 1] = 5;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(6) == true) {
			counter++;
			arr[counter - 1] = 6;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(7) == true) {
			counter++;
			arr[counter - 1] = 7;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(8) == true) {
			counter++;
			arr[counter - 1] = 8;
			System.out.println(arr[counter - 1]);
		}
		if (meowchecker(9) == true) {
			counter++;
			arr[counter - 1] = 9;
			System.out.println(arr[counter - 1]);
		}
		System.out.println("Total number of empty spaces encountered are : " + counter);
		return counter++;
	}

	public int getfreeSpaces() {
		int res = (int) (Math.random() * check());
		System.out.println("res = " + res);
		int temp = test[res];
		System.out.println("test[res] = " + test[res]);
		res = arr[temp];
		System.out.println("arr[temp] = " + arr[temp]);
		counter = 0;
		System.out.println("The Free Space Choosed is : " + res);
		return res;
	}

	public void computer() {
		int b = getfreeSpaces();
		if (b == 1 && meowchecker(1) == true) {
			b1.setIcon(changedimension(Y, 100, 100));
			meow[1] = 1;
			check[0][0] = 2;
		} else if (b == 2 && meowchecker(2) == true) {
			b2.setIcon(changedimension(Y, 100, 100));
			meow[2] = 1;
			check[0][1] = 2;
		} else if (b == 3 && meowchecker(3) == true) {
			b3.setIcon(changedimension(Y, 100, 100));
			meow[3] = 1;
			check[0][2] = 2;
		} else if (b == 4 && meowchecker(4) == true) {
			b4.setIcon(changedimension(Y, 100, 100));
			meow[4] = 1;
			check[1][0] = 2;
		} else if (b == 5 && meowchecker(5) == true) {
			b5.setIcon(changedimension(Y, 100, 100));
			meow[5] = 1;
			check[1][1] = 2;
		} else if (b == 6 && meowchecker(6) == true) {
			b6.setIcon(changedimension(Y, 100, 100));
			meow[6] = 1;
			check[1][2] = 2;
		} else if (b == 7 && meowchecker(7) == true) {
			b7.setIcon(changedimension(Y, 100, 100));
			meow[7] = 1;
			check[2][0] = 2;
		} else if (b == 8 && meowchecker(8) == true) {
			b8.setIcon(changedimension(Y, 100, 100));
			meow[8] = 1;
			check[2][1] = 2;
		} else if (b == 9 && meowchecker(9) == true) {
			b9.setIcon(changedimension(Y, 100, 100));
			meow[9] = 1;
			check[2][2] = 2;
		}
	}

	public static void main(String[] args) {
		new Game();
	}

	public void meowmeow(int n) {
		meow[n] = 1;
	}

	public boolean meowchecker(int n) {
		if (meow[n] == 0)
			return true;
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkwin();
		if (e.getSource() == restart) {
			enableall();
			for (int i = 0; i < check.length; i++) {
				for (int j = 0; j < check.length; j++) {
					check[i][j] = 0;
				}
			}
			for (int i = 0; i < meow.length; i++) {
				meow[i] = 0;
			}
			winlose.setVisible(false);
		}
		if (e.getSource() == b1 && meowchecker(1) == true) {
			b1.setIcon(changedimension(X, 100, 100));
			meow[1] = 1;
			check[0][0] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b2 && meowchecker(2) == true) {
			b2.setIcon(changedimension(X, 100, 100));
			meow[2] = 1;
			check[0][1] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b3 && meowchecker(3) == true) {
			b3.setIcon(changedimension(X, 100, 100));
			meow[3] = 1;
			check[0][2] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b4 && meowchecker(4) == true) {
			b4.setIcon(changedimension(X, 100, 100));
			meow[4] = 1;
			check[1][0] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b5 && meowchecker(5) == true) {
			b5.setIcon(changedimension(X, 100, 100));
			meow[5] = 1;
			check[1][1] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b6 && meowchecker(6) == true) {
			b6.setIcon(changedimension(X, 100, 100));
			meow[6] = 1;
			check[1][2] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b7 && meowchecker(7) == true) {
			b7.setIcon(changedimension(X, 100, 100));
			meow[7] = 1;
			check[2][0] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b8 && meowchecker(8) == true) {
			b8.setIcon(changedimension(X, 100, 100));
			meow[8] = 1;
			check[2][1] = 1;
			checkwin();
			computer();
			checkwin();
		}
		if (e.getSource() == b9 && meowchecker(9) == true) {
			b9.setIcon(changedimension(X, 100, 100));
			meow[9] = 1;
			check[2][2] = 1;
			checkwin();
			computer();
			checkwin();
		}
	}

	public void setwin(int i) {
		if (i == 0) {
			winlose.setVisible(true);
			disableRest();
		} else {
			winlose.setText("You Lose !!");
			winlose.setVisible(true);
			disableRest();
		}
	}

	public void disableRest() {
		if (meowchecker(1) == true) {
			b1.setEnabled(false);
			b1.setIcon(null);
		}
		if (meowchecker(2) == true) {
			b2.setEnabled(false);
			b2.setIcon(null);
		}
		if (meowchecker(3) == true) {
			b3.setEnabled(false);
			b3.setIcon(null);
		}
		if (meowchecker(4) == true) {
			b4.setEnabled(false);
			b4.setIcon(null);
		}
		if (meowchecker(5) == true) {
			b5.setEnabled(false);
			b5.setIcon(null);
		}
		if (meowchecker(6) == true) {
			b6.setEnabled(false);
			b6.setIcon(null);
		}
		if (meowchecker(7) == true) {
			b7.setEnabled(false);
			b7.setIcon(null);
		}
		if (meowchecker(8) == true) {
			b8.setEnabled(false);
			b8.setIcon(null);
		}
		if (meowchecker(9) == true) {
			b9.setEnabled(false);
			b9.setIcon(null);
		}
	}

	public void enableall() {
		b1.setEnabled(true);
		b1.setIcon(null);
		b2.setEnabled(true);
		b2.setIcon(null);
		b3.setEnabled(true);
		b3.setIcon(null);
		b4.setEnabled(true);
		b4.setIcon(null);
		b5.setEnabled(true);
		b5.setIcon(null);
		b6.setEnabled(true);
		b6.setIcon(null);
		b7.setEnabled(true);
		b7.setIcon(null);
		b8.setEnabled(true);
		b8.setIcon(null);
		b9.setEnabled(true);
		b9.setIcon(null);
	}

	public void checkwin() {
		// 1row
		if (check[0][0] == 1 && check[0][1] == 1 && check[0][2] == 1)
			setwin(0);
		if (check[0][0] == 2 && check[0][1] == 2 && check[0][2] == 2)
			setwin(1);

		// 2row
		if (check[1][0] == 1 && check[1][1] == 1 && check[1][2] == 1)
			setwin(0);
		if (check[1][0] == 2 && check[1][1] == 2 && check[1][2] == 2)
			setwin(1);

		// 3row
		if (check[2][0] == 1 && check[2][1] == 1 && check[2][2] == 1)
			setwin(0);
		if (check[2][0] == 2 && check[2][1] == 2 && check[2][2] == 2)
			setwin(1);

		// 1column
		if (check[0][0] == 1 && check[1][0] == 1 && check[2][0] == 1)
			setwin(0);
		if (check[0][0] == 2 && check[1][0] == 2 && check[2][0] == 2)
			setwin(1);

		// 2column
		if (check[0][1] == 1 && check[1][1] == 1 && check[2][1] == 1)
			setwin(0);
		if (check[0][1] == 2 && check[1][1] == 2 && check[2][1] == 2)
			setwin(1);

		// 3column
		if (check[0][2] == 1 && check[1][2] == 1 && check[2][2] == 1)
			setwin(0);
		if (check[0][2] == 2 && check[1][2] == 2 && check[2][2] == 2)
			setwin(1);

		// diagnol
		if (check[0][0] == 1 && check[1][1] == 1 && check[2][2] == 1)
			setwin(0);
		if (check[0][0] == 2 && check[1][1] == 2 && check[2][2] == 2)
			setwin(1);

		if (check[0][2] == 1 && check[1][1] == 1 && check[2][0] == 1)
			setwin(0);
		if (check[0][2] == 2 && check[1][1] == 2 && check[2][0] == 2)
			setwin(1);
	}
}
