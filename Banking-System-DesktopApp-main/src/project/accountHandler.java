package project;

public class accountHandler {

	private String name;
	private Double balance;
	private int ID;

	public accountHandler() {
		name = "";
		balance = 0.0;
		ID = 0;
	}

	public accountHandler(String name, Double balance, int ID) {

		this.name = name;
		this.balance = balance;
		this.ID = ID;

	}

	public String showGift(int i) {

		// a srting of arrays containing the prizes
		// the program sends a random number here and then it chooses the reward .

		String prize;
		String[] stringArray = new String[10];
		stringArray[0] = "A Hyundai car but without seats.";
		stringArray[1] = "ping pong table.";
		stringArray[2] = "pool table.";
		stringArray[3] = "10% discount (koshari abo tarek).";
		stringArray[4] = "free trip to dahab.";
		stringArray[5] = "A pair of Nike shoes.";
		stringArray[6] = "A PS5.";
		stringArray[7] = "XBOX SERIES X device.";
		stringArray[8] = "iPhone 12 SX + pro";
		stringArray[9] = "tickets to the NBA playoffs.";

		prize = stringArray[i];
		return prize;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
		} else
			System.out.print("you can't make a negative deposit" + "\n");
	}

	public void withdraw(double amount) {
		if (amount > 0) {
			balance = balance - amount;
		} else
			System.out.print("you can't make a negative withdraw" + "\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
