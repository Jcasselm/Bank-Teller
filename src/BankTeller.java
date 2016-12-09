import java.util.Scanner;

public class BankTeller {
	private static Bank money = new Bank(5);
	
	  public static void main(String[] args) {
		  char command;
		  Scanner input = new Scanner(System.in);
		  printMenu();
		  do {
		      System.out.println("\nPlease enter a command or type ?");
		      command = input.nextLine().toLowerCase().charAt(0);
		      
		      switch(command){
		      case 'a':
		    	  int checkOrSave = -1;
		    	  while(checkOrSave < 1 || checkOrSave > 2){
		    		  System.out.println("\nEnter 1 for Savings Account or 2 for Checking Account: ");
		    		  checkOrSave = Integer.parseInt(input.nextLine());
		    	  }
		    	  
		    	  System.out.print("Enter account holder name: ");
		          String name = input.nextLine();
		          
		    	  BankAccount b;
		    	  if (checkOrSave == 1) {
		    		  System.out.print("\nEnter starting interest rate: ");
		    		  double r = Double.parseDouble(input.nextLine());
		    		  b = new SavingsAccount(name, r);
		    	  }
		    	  else{
		    		  System.out.print("Enter starting check number: ");
		    	  	  int r = Integer.parseInt(input.nextLine());
		    	  	  b = new CheckingAccount(name, r);
		      }
		      	if (money.add(b)) System.out.print("\nBank account successfully added.\n");
		      	else System.out.print("Bank account not added. No duplicates please.\n");
		      	break;
		      	
		      case 'b':
		          System.out.print("\nEnter account number: ");
		          int acctNum = Integer.parseInt(input.nextLine());
		          if (money.remove(money.find(acctNum))) System.out.print("\nBank account successfully removed.\n");
		          else System.out.print("Bank account not found. Cannot remove.\n");
		          break;
		      case 'c':
		          System.out.println(money.toString());
		          break;
		      case 'd':
		          System.out.println("\nThere are " + money.getCount() + " BankAccounts in the bank");
		          break;
		      case 'e':
		    	  money.sort();
		    	  break;
		    	  
		      case 'f':
		    	  BankAccount c;
		    	  System.out.print("\nEnter account number: ");
		          acctNum = Integer.parseInt(input.nextLine());
		          c = money.find(acctNum);
		    	  int depOrWith = -1;
		    	  while(depOrWith < 1 || depOrWith > 2){
		    		  System.out.println("\nEnter 1 for deposit or 2 for withdraw: ");
		    		  depOrWith = Integer.parseInt(input.nextLine());
		    	  }
		    	  System.out.print("Enter amount: ");
	    		  double d = Double.parseDouble(input.nextLine());
		    	  if (depOrWith == 1) {
		    		  c.deposit(d);
		    		  System.out.print("Transaction successful");
		    		  
		    	  }
		    	  else if (depOrWith == 2){
		    		 c.withdraw(d);
		    		 System.out.print("Transaction successful");
		    		 }
		    	  else
		    		  System.out.print("Transaction failed");
		    		 
		    	  
		    	  break;
		        case '?':
		          printMenu();
		          break;
		        case 'q':
		          System.out.println("GOOD BYE!");
		          break;
		        default:
		          System.out.println("Invalid Input");
		      }
		    } while (command != 'q');
		    input.close();
		  }
	  public static void printMenu() {
		    System.out.print("\nBank Teller Options\n" + "-----------------------------------\n"
		        + "a: add an account to the bank\n" + "b: remove an account from the lot\n"
		        + "c: display the accounts in the bank\n" + "d: count the accounts in the bank\n"
		        + "e: sort the accounts in the bank\n" + "f: update an account in the bank\n"
		        + "?: display the menu again\n" + "q: quit this program\n\n");
	  }

}