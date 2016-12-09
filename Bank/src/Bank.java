public class Bank {
	private BankAccount[] accounts;
	private int count;

	public Bank(int cap) {
		accounts = new BankAccount[cap];
		count = 0;
	}

	private int indexOf(BankAccount a) {
		 if (a == null) return -1;
		 for (int i = 0; i < count; i++)
		 if (accounts[i].equals(a)) return i;
		 return -1;
		 }

	public boolean contains(BankAccount a) {
		if (indexOf(a) != -1)
			return true;
		else
			return false;

	}

	public boolean add(BankAccount a) {

		if (contains(a))
			return false;

		if (full())
			doubleCapacity();

		accounts[count] = a;
		count++;
		return true;

	}

	public boolean remove(BankAccount a) {
		if (!contains(a))
			return false;
		int remove = indexOf(a);

		accounts[remove] = accounts[count - 1];
		accounts[count - 1] = null;
		count--;
		return true;
	}

	public int getCount() {
		return count;
	}

	 public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append("Bank Accounts\n");
		    for (int i = 0; i < count; i++)
		      sb.append(accounts[i] + "\n    **************    \n");
		    return sb.toString();
		  }

	public void sort() {
		for (int i = 0; i < count - 1; i++) {
			int minI = i;
			for (int j = i + 1; j < count; j++) {
				if (accounts[minI].getAccountNumber() > accounts[j].getAccountNumber()) {
					minI = j;
				}
				
			}
			BankAccount temp = accounts[i];
			accounts[i] = accounts[minI];
			accounts[minI] = temp;
		}
	}

	private void doubleCapacity() {
		BankAccount[] newArray = new BankAccount[accounts.length * 2];
		for (int i = 0; i < accounts.length; i++) {
			newArray[i] = accounts[i];
		}
		accounts = newArray;
	}

	private boolean full() {
		return count >= accounts.length;
	}
	
	public BankAccount find(long acctNum) {
		 for (int i = 0; i < count; i++)
		 if (accounts[i].getAccountNumber() == acctNum) return accounts[i];
		 return null;
		 }
}