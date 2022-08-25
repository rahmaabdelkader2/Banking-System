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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class accGUI extends mainClas {

	private JFrame accF;
	private JPanel accP;
	private JLabel accL;
	private JLabel Nlabel;
	private JLabel Blabel;
	private JLabel Ilabel;
	private JTextField inpName;
	private JTextField inpBalance;
	private JTextField inpID;
	private JButton confirmB;
	private JTextArea outputBox_m;

	public accGUI() {

		outputBox_m = new JTextArea(4, 30);
		outputBox_m.setEditable(false);

		// defining frame attributes .

		accF = new JFrame("account input");
		accF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		accF.setSize(550, 300);
		accF.setResizable(false);
		accF.setLocation(200, 200);
		accF.setTitle("Insert accounts here");
		accF.setVisible(true);

		// panel properties

		accP = new JPanel();
		accP.setBackground(Color.lightGray);

		// Titles
		accL = new JLabel("Insert accounts and balances");

		// Labels that go next to the text field

		Nlabel = new JLabel("Name :");
		Blabel = new JLabel("Balance :");
		Ilabel = new JLabel("Account ID :");

		// text fields that have inputs

		inpName = new JTextField(15);
		inpBalance = new JTextField(15);
		inpID = new JTextField(15);

		// button that confirms input

		confirmB = new JButton("Confirm info");
		confirmB.setToolTipText("Click to confirm a new account");
		confirmB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code that takes the two or three inputs from the text fields and
				// puts those inputs into an element of the database .

				// this command clears the outputbox from previous messages
				outputBox_m.setText("");

				// code that takes input and puts them in the array .

				// code that takes the text in the ID text field and converts it into it
				// dummyID is a dummy variable to transition between the two.
				String dummyID = inpID.getText();
				String dummyName = inpName.getText();
				String dummyBalance = inpBalance.getText();
				// this command clears the outputbox from previous messages
				outputBox_m.setText("");
				int nID = 0;
				if (dummyID.isEmpty()) {
					outputBox_m.append("Please enter valid ID field." + "\n");
				} else {
					try {
						nID = Integer.parseInt(dummyID);

						if (nID < 6 && nID >= 0)
							outputBox_m.append("Account already exists");
						else {
							if (nID < 1001 && nID >= 6) {
								nID = Integer.parseInt(dummyID);
								outputBox_m.append("Account is created sucessfully: " + "\n" + "	- Name: "
										+ dummyName + "\n" + "	- ID: " + nID + "\n"
										+ "	- Balance: " + dummyBalance + "\n");
							} else
								outputBox_m.append("Please enter a valid ID value" + "\n");
						}
					}

					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException f) {
						// error message
						outputBox_m.append("Please enter valid informations" + "\n");
					}
				}

				// code that takes the text in the balance text field and converts it into it
				// dummmyBalance is a dummy variable to transition between the two.

				double nBalance = 0;
				if (dummyBalance.isEmpty()) {
					outputBox_m.append("Please fill the Balance field." + "\n");
				} else {
					try {
						Double.parseDouble(dummyBalance);
						nBalance = Integer.parseInt(dummyBalance);
						if (nBalance < 0) {
							nBalance = 0;
							outputBox_m.append("Please enter a valid balance" + "\n");
						}

					}

					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException f) {
						// error message
						outputBox_m.append("Please enter valid informations" + "\n");
					}
				}

				// taking the string from the name into a name.
				String tempName = "";
				if (dummyName.isEmpty()) {
					outputBox_m.append("Please enter a valid name." + "\n");
				} else {
					tempName = inpName.getText();
				}

				// we store all these attributes in a temporary object (tempAccount)
				accountHandler tempAccount = new accountHandler(tempName, nBalance, nID);

				// code that handles storing the object in arrays .
				if (nID > 0 && nBalance > 0) {
					accountArray[nID] = tempAccount;
				} else
					outputBox_m.append("The balance or ID is incorrect." + "\n");

				// code that clears the text fields automatically after confirming
				// now the user can enter another account
				inpName.setText("");
				inpBalance.setText("");
				inpID.setText("");

			}
		});

		// layout (under this is the arrangement of the components , reused from GUI
		// class , lol).

		accF.add(accP);
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
		accP.add(Nlabel, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 1;
		// gc.insets = new Insets(0 , 0 , 0 , 12);
		gc.anchor = GridBagConstraints.LINE_START;
		accP.add(inpName, gc);

		// [ 3RD ROW ]

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 12, 0, 0);
		accP.add(Blabel, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		// gc.insets = new Insets(0 , 0 , 0 , 12);
		accP.add(inpBalance, gc);

		// [ 4TH ROW ]
		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		accP.add(Ilabel, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		accP.add(inpID, gc);

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
		accP.add(outputBox_m, gc);

	}

}