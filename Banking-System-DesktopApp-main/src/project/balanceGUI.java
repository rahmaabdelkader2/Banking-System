package project;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class balanceGUI extends mainClas {

	private JFrame accB;
	private JPanel accP;
	private JLabel accL;
	private JLabel Ilabel;
	private JTextField inpID;
	private JButton confirmB;
	private JTextArea outputBox_b;

	public balanceGUI() {
		// this is the window that handles the transfer menu

		// defining frame attributes .

		accB = new JFrame("check balance");
		accB.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		accB.setSize(550, 300);
		accB.setResizable(false);
		accB.setLocation(200, 200);
		accB.setTitle("Enter your account here");
		accB.setVisible(true);

		// panel properties

		accP = new JPanel();
		accP.setBackground(Color.lightGray);

		// Titles
		accL = new JLabel("Enter account to check balance.");

		// Labels that go next to the text field

		Ilabel = new JLabel("Account ID :");

		// text fields that have inputs

		inpID = new JTextField(15);

		// text area which displays the output.

		outputBox_b = new JTextArea(4, 30);
		outputBox_b.setEditable(false);
		// outputBox_b.setSize(10,10);

		// button that confirms input and sends the message to check balance and status

		confirmB = new JButton("Check balance");
		confirmB.setToolTipText("Click to confirm the balance");
		confirmB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// this command clears the outputbox from previous messages
				outputBox_b.setText("");

				// code that takes the two or three inputs from the text fields and
				// puts those inputs into an element of the database .

				// code that takes the text in the ID text field and converts it into int number
				// dummyID is a dummy variable to transition between the two.
				String dummyID = inpID.getText();
				int nID = 0;
				if (dummyID.isEmpty()) {
					outputBox_b.append("Please enter valid ID number" + "\n");
				} else {
					try {
						nID = Integer.parseInt(inpID.getText());
						if (nID <= 1000 && nID >= 0) {
							nID = Integer.parseInt(dummyID);
						} else
							outputBox_b.append("You entered a wrong value" + "\n");
					}
					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException f) {
						// error message
						outputBox_b.append("Please enter an account -number- " + "\n");
					} catch (NullPointerException n) {
						outputBox_b.append("This account is not registered" + "\n");
					}
				}

				// code that looks at the element with the index nID in the array.
				accountHandler tempAccount = new accountHandler();
				Random random = new Random();
				int x = random.nextInt(9);
				// try catch statement for sending the element to the array to make sure the
				// inedx is right
				if (nID >= 0 && nID < 1001) {
					try {
						outputBox_b.append("Name :" + accountArray[nID].getName() + "\n");
						outputBox_b.append("Balance :" + accountArray[nID].getBalance().toString() + "\n");
						if (accountArray[nID].getBalance() > 0) {
							outputBox_b.append("You are not in debt. \n");
						} else
							outputBox_b.append("You are in debt. \n");
						/*
						 * this condition checks the balance of the user and if it's higher than VIP
						 * threshold then if he/she is a VIP client we choose a random gift from the
						 * array and show it.
						 */
						if (accountArray[nID].getBalance() >= 50000) {
							outputBox_b.append("You won : " + tempAccount.showGift(x) + "\n");
						} else
							outputBox_b.append("You're not a Vip client" + "\n");

					} catch (ArrayIndexOutOfBoundsException g) {
						outputBox_b.append("Please enter id value under 1000, our database is small" + "\n");
					} catch (NullPointerException n) {
						outputBox_b.append("This account is not registered" + "\n");
					}
				} else {
					outputBox_b.append("Please enter a valid ID value" + "\n");
				}

			}
		});

		// layout (under this is the arrangement of the components)

		accB.add(accP);
		accP.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// [ FIRST ROW ]

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 12, 0, 0);
		accP.add(accL, gc);

		// [ 3RD ROW ] this has the ID label and ID input field

		gc.weightx = 0.5;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 19);
		accP.add(Ilabel, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 19);
		accP.add(inpID, gc);

		// [ 4TH ROW ] this has the confirm button

		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(25, 0, 0, 12);
		accP.add(confirmB, gc);

		// [ 5TH ROW ] this has the text box which shows the messages

		gc.weightx = 1.9;
		gc.weighty = 1.5;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 25, 0, 0);
		accP.add(outputBox_b, gc);

	}

}