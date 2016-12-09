
public class SavingsAccount extends BankAccount {

	protected double interestRate;
	
public SavingsAccount(String n, double r) {
	super(n);
	if(r > 0 && r < 0.10)
		interestRate = r;
	else
		interestRate =  0.01;
	}
	
public double getRate(){
	return interestRate;
}


public void addInterest(){
	balance += interestRate;
}


@Override
public String toString(){
	return "Savings Account\n" + super.toString() + "\nInterest Rate:\t\t%" + String.format("%.3f", interestRate*100);
}
}

