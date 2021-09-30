package bankingApplication;

public class BankingApplication {
	
	public static void main(String[] args) {
		
		
		Customer fateh = new Customer("Fateh Sandhu", "FS007");
		BankAccount account = new BankAccount(fateh);
		account.getMenu();
		
	}

}