package project;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends mainClas implements ActionListener {
	private JLabel intro;
	private JFrame mainF;
	private JPanel mainP;
	private JButton openAcc;
	private JButton openT;
	// private JButton explodeB;
	private JButton openB;
	private JButton openD;

	public GUI() {

		// creating the main frame

		mainF = new JFrame("Professinal Banking System");
		mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainF.setSize(700, 500);
		mainF.setResizable(false);
		mainF.setLocation(200, 200);
		mainF.setVisible(true);

		// panel properties
		mainP = new JPanel();
		mainP.setBackground(Color.black);
		mainP.setSize(300, 300);

		// button that opens up account window.
		openAcc = new JButton("Create an account");
		openAcc.setToolTipText("You can make an account by pressing this button");
		openAcc.setForeground(Color.white);
		openAcc.setBackground(Color.gray);
		openAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code that opens another similar frame .
				new accGUI();
			}
		});

		// button that opens up transfer window
		openT = new JButton("Make a transfer");
		openT.setToolTipText("You can open the transfer window by pressing this button");
		openT.setForeground(Color.white);
		openT.setBackground(Color.gray);
		openT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code that opens another similar frame .
				new tranGUI();
			}
		});

		// button that opens up check balance window .
		openB = new JButton("Check the balance");
		openB.setToolTipText("You can check the balance by pressing this button");
		openB.setForeground(Color.white);
		openB.setBackground(Color.gray);
		openB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code that opens another similar frame .
				new balanceGUI();
			}
		});
		// button that opens up the deposit and withdrawing menu.
		openD = new JButton("Deposit or Withdraw");
		openD.setToolTipText("You can open the deposit window by pressing this button");
		openD.setForeground(Color.white);
		openD.setBackground(Color.gray);
		openD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code that opens another similar frame .
				new depositGUI();
			}
		});

		// label properties

		intro = new JLabel("Admin Dashboard");
		intro.setForeground(Color.white);

		// layout and arrangement (under this is the arrangement of the components)

		mainF.add(mainP); // putting the panel to the frame then adding stuff to it.

		mainP.setLayout(new GridBagLayout()); // defining the grid bag stuff

		GridBagConstraints gc = new GridBagConstraints();

		// [ FIRST ROW ]

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.5;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 220, 0, 0);
		mainP.add(intro, gc);

		// [ SECOND ROW ]

		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.ipady = 20;
		gc.ipadx = 55;
		gc.insets = new Insets(0, 12, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		mainP.add(openT, gc);

		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.ipady = 20;
		gc.insets = new Insets(0, 0, 0, 12);
		gc.anchor = GridBagConstraints.LINE_START;
		mainP.add(openAcc, gc);

		// [ 3RD ROW ]

		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.ipady = 25;
		gc.ipadx = 55;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 12, 0, 0);
		mainP.add(openB, gc);

		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.ipady = 20;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 12);
		mainP.add(openD, gc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
