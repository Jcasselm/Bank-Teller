
/* Jonathan Casselman
 * 10612577
 * PA12
 * November 28, 2016
*/

import java.util.Date;
import java.util.Random;

public class BankAccount {
	protected String name;
	protected double balance;
	protected int acctNum;
	protected Date date = new Date();
	protected static int accountsCreated;

	public BankAccount( String n) {
		name = n;
		acctNum = generateAcctNum();
		accountsCreated++;
	}

	public double getBalance() {
		return balance;

	}

	public double getAccountNumber() {
		return acctNum;
	}

	public boolean deposit(double d) {
		if (d < 0)
			return false;
		else {
			balance += d;
			return true;
		}
	}

	public boolean withdraw(double y) {
		if (y > balance || y < 0)
			return false;
		else
			balance -= y;
		return true;
	}

	public boolean transfer(BankAccount f, double t) {
		if (this.balance >= t && t > 0) {
			this.withdraw(t);
			f.deposit(t);
			return true;
		}
		return false;

	}

	public String toString() {
		return name + " [" + acctNum + "]" + "\n" + date + "\n$" + String.format("%,.2f", balance);
	}

	public boolean equals(BankAccount that) {
		if (this.acctNum == that.acctNum)
			return true;
		else
			return false;
	}

	protected int generateAcctNum() {
		Random rand = new Random();
		int acctNum = rand.nextInt(900000000) + 100000000;
		return acctNum;
	}

	public static int getAccountsCreated() {
		return accountsCreated;

	}
}
