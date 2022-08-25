package project;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class tranGUI extends mainClas {

	private JFrame accT;
	private JPanel accP;
	private JLabel accL;
	private JTextField inpA1;
	private JTextField inpA2;
	private JTextField inpTA;
	private JButton confirmB;
	private JLabel labelA1;
	private JLabel labelA2;
	private JLabel labelTA;
	private JTextArea outputBox_t;

	public tranGUI() {
		// this is the window that handles the transfer menu

		// defining frame attributes .
		outputBox_t = new JTextArea(4, 30);
		outputBox_t.setEditable(false);

		accT = new JFrame("transfer account");
		accT.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		accT.setSize(550, 300);
		accT.setResizable(false);
		accT.setLocation(200, 200);
		accT.setTitle("Insert accounts and tranfer amount");
		accT.setVisible(true);

		// panel properties

		accP = new JPanel();
		accP.setBackground(Color.lightGray);

		// Titles
		accL = new JLabel("Insert transfer information.");

		// text fields that take accounts and transfer amount.

		inpA1 = new JTextField(15); // input Account 1 / sender
		inpA2 = new JTextField(15); // input Account 2 / receiver
		inpTA = new JTextField(15); // input Transfer Amount.

		// labels that go next to the text fields .

		labelA1 = new JLabel("Sender account ID : "); // label of sender
		labelA2 = new JLabel("Receiver account ID :"); // label of receiver
		labelTA = new JLabel("transfer amount :"); // label of Transfer Amount .

		// button that confirms input

		confirmB = new JButton("confirm transfer");
		confirmB.setToolTipText("click to transfer balance.");
		confirmB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// outputBox_t.append("the confirm transfer button works");

				// this command clears the outputbox from previous messages
				outputBox_t.setText("");

				// code for receiver ID input
				// it takes the text in the ID text field and converts it into int
				// dummyIDr is a dummy variable to transition between the two.
				// nID2 is the ID of the receiver

				int nID2 = 0;
				String dummyIDr = inpA2.getText();
				if (dummyIDr.isEmpty()) {
					outputBox_t.append("please enter valid receiver ID" + "\n");
				} else {
					try {
						nID2 = Integer.parseInt(inpA2.getText());
						if (nID2 <= 1000 && nID2 >= 0) {
							nID2 = Integer.parseInt(dummyIDr);
						} else
							outputBox_t.append("please enter id value under 1000 , our database is small" + "\n");
					}

					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException f) {
						// error message
						outputBox_t.append("please enter a receiver ID -number-" + "\n");
					} catch (NullPointerException n) {
						outputBox_t.append("This account is not registered" + "\n");
					}
				}

				// code for sender ID input
				// it takes the text in the ID text field and converts it into int
				// dummyIDr is a dummy variable to transition between the two.
				// nID1 is the ID of the sender

				int nID1 = 0;
				String dummyIDs = inpA1.getText();
				if (dummyIDs.isEmpty()) {
					outputBox_t.append("please enter valid ID of sender" + "\n");
				} else {
					try {
						nID1 = Integer.parseInt(inpA1.getText());
						if (nID1 <= 1000 && nID1 >= 0) {
							nID1 = Integer.parseInt(dummyIDs);
						} else
							outputBox_t.append("please enter id value under 1000, our database is small" + "\n");
					}

					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException f) {
						// error message
						outputBox_t.append("please enter a sender ID -number- " + "\n");
					}

					catch (NullPointerException n) {
						outputBox_t.append("the account not registered" + "\n");
					}
				}

				// code that handles the transfer operation

				// first we put the the object of sender in temp objects .

				// we make sure the sender has enough money to make the transfer.

				// code for transfer amount , puts it into nTA if it's correct , if not it shows
				// error message on console
				// code that takes the text in the ID text field and converts it into int
				// nTA is the transfer amount

				Double nTA = 0.0;
				String dummyIDt = inpTA.getText();
				if (dummyIDt.isEmpty()) {
					outputBox_t.append("please enter amount to be transferred" + "\n");
				} else {
					try {
						nTA = Double.parseDouble(dummyIDt);
						if (nID1 != nID2) {
							if ((nID1 <= 1000 && nID1 >= 0) || (nID2 <= 1000 && nID2 >= 0)) {
								if ((accountArray[nID1].getBalance() - nTA >= 0)) {
									outputBox_t.append("Transaction Successed:" + "\n" + "	- Sender Name: "
											+ accountArray[nID1].getName() + "\n"
											+ "	- Receiver Name: " + accountArray[nID2].getName() + "\n"
											+ "	- Transferred amount: " + nTA + "\n");
									accountArray[nID1].withdraw(nTA);
									accountArray[nID2].deposit(nTA);
								} else
									outputBox_t
											.append("the sender doesn't have enough money to make the transfer" + "\n");
							} else
								outputBox_t.append("This account ID Does not exist" + "\n");
						} else
							outputBox_t.append("You can not transfer from account to the same account" + "\n");

					}

					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException f) {
						// error message
						outputBox_t.append("please enter the transfer amount in -numbers- " + "\n");
					} catch (NullPointerException n) {
						outputBox_t.append("This account is not registered" + "\n");
					}
				}

				inpA1.setText("");
				inpA2.setText("");
				inpTA.setText("");

			}
		});

		// layout (under this is the arrangement of the components)

		accT.add(accP);
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

		// [ SECOND ROW ]

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 1;
		// gc.insets = new Insets(0 , 12 , 0 , 0);
		gc.anchor = GridBagConstraints.LINE_END;
		accP.add(labelA1, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 1;
		// gc.insets = new Insets(0 , 0 , 0 , 12);
		gc.anchor = GridBagConstraints.LINE_START;
		accP.add(inpA1, gc);

		// [ 3RD ROW ]

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 12, 0, 0);
		accP.add(labelA2, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		// gc.insets = new Insets(0 , 0 , 0 , 12);
		accP.add(inpA2, gc);

		// [ 4TH ROW ]
		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		accP.add(labelTA, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		accP.add(inpTA, gc);

		// [ 5TH ROW ]

		gc.weightx = 1;
		gc.weighty = 1.5;
		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(35, 0, 0, 25);
		accP.add(confirmB, gc);

		// [ 6TH ROW ] this has the text box which shows the messages

		gc.weightx = 1.9;
		gc.weighty = 1.5;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 25, 0, 0);
		accP.add(outputBox_t, gc);
	}

}
