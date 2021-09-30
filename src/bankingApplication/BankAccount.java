package bankingApplication;
import java.util.Scanner;

class BankAccount {
	
	private int balance;
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setPreviousTransaction(int previousTransaction) {
		this.previousTransaction = previousTransaction;
	}


	private int previousTransaction;
	String customerName;
	String customerId;
	
	
	BankAccount(Customer customer){
		
		this.customerName = customer.getName();
		this.customerId = customer.getId();
		
	}
	
	void deposit(int amount) {
		
		if (amount > 0) {
			
			balance = balance + amount;
			this.previousTransaction = amount;
			
		}
		
	}
	
	
	void withdraw(int amount) {
		
		if (amount > 0) {
			
			balance = balance - amount;
			this.previousTransaction = -balance;
		}
		
	}
	
	
	void getPreviousTransaction() {
		
		if (this.previousTransaction > 0) {
			
			System.out.println("You deposited: " + this.previousTransaction);
			
		} else if (this.previousTransaction < 0) {
			
			System.out.println("You withdrew: " + Math.abs(this.previousTransaction));
			
		} else {
			
			System.out.println("No Transaction!");
			
		}
		
	}
	
	
	void getMenu() {
		
		char option = '\0';
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		System.out.println("Weclome " + this.customerName);
		System.out.println("Your customer ID is " + this.customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		
		do {
			
			System.out.print("Select an option: ");
			option = s.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
				
				case 'A':
					System.out.println("Balance: " + this.balance);
					break;
				
				case 'B':
					System.out.println("Enter deposit amount: ");
					int amount = s.nextInt();
					this.deposit(amount);
					break;
					
				case 'C':
					System.out.println("Enter withdraw amount: ");
					int amount2 = s.nextInt();
					this.withdraw(amount2);
					break;
					
				case 'D':
					this.getPreviousTransaction();
					break;
					
				case 'E':
					System.out.println("Bye, Thank you!");
					break;
					
				default:
					System.out.println("Please enter valid options only!");
					break;
			
			}
			
		} while (option != 'E');
		
	}
	
	
}