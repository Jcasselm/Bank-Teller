
public class CheckingAccount extends BankAccount {
	
	protected int checkNumber;
	
public CheckingAccount(String n, int c){
	super(n);
	
	if(c > 0)
		checkNumber = c;
	else
		checkNumber = 1000;
}

public int getCheckNumber(){
	return checkNumber;
}

public void writeCheck(){
	checkNumber++;
}

@Override
public String toString(){
	return "Checking Account\n" + super.toString() + "\n" + "Next Check Number:\t#" +checkNumber;
}

}

