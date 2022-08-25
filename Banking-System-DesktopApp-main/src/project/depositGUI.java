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

public class depositGUI extends mainClas {
	private JFrame accD;
	private JPanel accP;
	private JLabel accL;
	private JLabel idLabel;
	private JLabel moneyLabel;
	private JButton confirmD;
	private JButton confirmW;
	private JTextField inpD;
	private JTextField inpID;
	private JTextArea outputBox_d;

	public depositGUI() {
		// this is the window that handles the deposit menu

		outputBox_d = new JTextArea(4, 30);
		outputBox_d.setEditable(false);

		// defining frame attributes .

		accD = new JFrame("you can make a deposit or withdraw money.");
		accD.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		accD.setSize(550, 350);
		accD.setResizable(false);
		accD.setLocation(200, 200);
		accD.setTitle("Enter your account here");
		accD.setVisible(true);

		// panel properties

		accP = new JPanel();
		accP.setBackground(Color.lightGray);

		// Titles
		accL = new JLabel("do you want to withdraw or deposit money.");

		// labels for the text fields .

		idLabel = new JLabel("Enter account ID : "); // label of ID text field
		moneyLabel = new JLabel("Enter amount of money :"); // label of Money text field.

		// text fields

		inpD = new JTextField(15);
		inpID = new JTextField(15);
		// button that confirms deposit amount

		// this command clears the outputbox from previous messages
		outputBox_d.setText("");

		confirmD = new JButton("confirm deposit");
		confirmD.setToolTipText("click to confirm a new deposit");
		confirmD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// this command clears the outputbox from previous messages
				outputBox_d.setText("");

				// code that takes the two inputs from the text fields and
				// adds the deposit amount into the balance next the index identified by the ID
				// panel.

				// code that takes the text in the ID text field and converts it into int number
				// dummyID is a dummy variable to transition between the two.
				// nID is the ID value
				String dummyID = inpID.getText();
				int nID = 0;
				if (dummyID.isEmpty()) {
					outputBox_d.append("Please enter valid ID" + "\n");
				} else {
					try {
						nID = Integer.parseInt(inpID.getText());

						if (nID <= 1000 && nID >= 0) {
							nID = Integer.parseInt(dummyID);
						} else
							outputBox_d.append("please enter id value from 1 to 1000 , our database is small" + "\n");
					}
					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException f) {
						// error message
						outputBox_d.append("please enter an account -number- " + "\n");
					}
				}

				String dummyID1 = inpD.getText();
				Double depositAmount = 0.0;
				if (dummyID1.isEmpty()) {
					outputBox_d.append("please enter deposit value" + "\n");
				} else {
					try {
						depositAmount = Double.parseDouble(dummyID1);
						outputBox_d.append("Name: " + accountArray[nID].getName() + "\n");
						outputBox_d.append("Amount Deposited: " + depositAmount + "\n");
						if (depositAmount <= 50000) {
							depositAmount = Double.parseDouble(dummyID1);
							try {
								if (depositAmount > 0) {
									accountArray[nID].deposit(depositAmount);
									outputBox_d.append("Successful Deposit." + "\n");
								} else
									outputBox_d.append("please enter a valid deposit amount." + "\n");
							} catch (NullPointerException n) {
								outputBox_d.append(" account is not registered." + "\n");
							}
						} else
							outputBox_d.append("you can't deposit more than 50k at once" + "\n");
					}
					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException g) {
						// error message
						outputBox_d.append("please enter a deposit -number- " + "\n");
					} catch (NullPointerException n) {
						outputBox_d.append("This account is not registered" + "\n");
					}
				}

				// code that sends the deposit amount to the balance of the account.

				inpD.setText("");
				inpID.setText("");
			}
		});

		// button that confirms withdrawal amount

		confirmW = new JButton("confirm withdrawal");
		confirmW.setToolTipText("click to confirm a new withdrawal");
		confirmW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code that takes the two or three inputs from the text fields and
				// removes the withdrawal amount from the account.

				// code that takes the text in the ID text field and converts it into int number
				// dummyID is a dummy variable to transition between the two.
				// nID is the ID value
				String dummyID = inpID.getText();
				int nID = 0;
				outputBox_d.setText("");
				if (dummyID.isEmpty()) {
					outputBox_d.append("please enter valid ID" + "\n");
				} else {
					try {

						nID = Integer.parseInt(inpID.getText());
						if (nID < 1000) {
							nID = Integer.parseInt(dummyID);

						} else
							outputBox_d.append("please enter id value under 1000 , our database is small" + "\n");
					}
					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException g) {
						// error message
						outputBox_d.append("please enter an account -number- " + "\n");
					} catch (NullPointerException n) {
						outputBox_d.append("This account is not registered" + "\n");
					}
				}

				// code that takes the text in the deposit amount text field and converts it
				// into a double
				// dummyID1 is a dummy variable to transition between the two.
				// withAmount is the withdrawal amount
				String dummyID2 = inpD.getText();
				Double withAmount = 0.0;
				if (dummyID2.isEmpty()) {
					outputBox_d.append("please enter withdrawal value" + "\n");
				} else {
					try {
						withAmount = Double.parseDouble(inpD.getText());
						outputBox_d.append("Name: " + accountArray[nID].getName() + "\n");
						outputBox_d.append("Amount Deposited: " + withAmount + "\n");
					}
					// catch error message for when the user puts text into the ID field
					catch (NumberFormatException h) {
						// error message
						outputBox_d.append("please enter a withdrawal -number- " + "\n");
					} catch (NullPointerException n) {
						outputBox_d.append("This account is not registered" + "\n");
					}
				}
				// code that takes the withdraw amount out of the balance of the account.
				try {
					if (withAmount > 0) {
						if (accountArray[nID].getBalance() - withAmount >= 0) {

							accountArray[nID].withdraw(withAmount);
							outputBox_d.append("Successful withdrawal" + "\n");
						} else
							outputBox_d.append("Can't withdraw, you don't have enough credit." + "\n");
					} else
						outputBox_d.append("please enter a valid deposit amount." + "\n");

					inpD.setText("");
					inpID.setText("");

				} catch (NullPointerException n) {
					outputBox_d.append("this account isn't registered, you can't withdraw" + "\n");
				}

			}
		});

		// layout (under this is the arrangement of the components)

		accD.add(accP);
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

		gc.weightx = 0.5;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 19);
		gc.anchor = GridBagConstraints.LINE_END;
		accP.add(idLabel, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 19);
		gc.anchor = GridBagConstraints.LINE_START;
		accP.add(inpID, gc);

		// [ 3RD ROW ]

		gc.weightx = 0.5;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 19);
		accP.add(moneyLabel, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 19);
		accP.add(inpD, gc);

		// [ 4TH ROW ]

		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(25, 0, 0, 12);
		accP.add(confirmD, gc);

		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.NORTH;
		// gc.insets = new Insets(25 , 0 , 0 , 12);
		accP.add(confirmW, gc);

		// [ 6TH ROW ] this has the text box which shows the messages

		gc.weightx = 1.9;
		gc.weighty = 1.5;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 25, 0, 0);
		accP.add(outputBox_d, gc);
	}

}
