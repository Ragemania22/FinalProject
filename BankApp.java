import java.util.Scanner;

public class BankApp {

	private final int EXITPROGRAM = 7;
	private BankAccount checkingAccount;
	private BankAccount savingsAccount;
	private Scanner console;
	
	public BankApp() {
		checkingAccount = new BankAccount("Tom Holmes Checking", "111111", 500.0);
		savingsAccount = new BankAccount("Tom Holmes Savings", "111112", 10000.0);
		console = new Scanner(System.in);
	}
	
	public void displayMenu() {
		int response = 0;
		while(response != EXITPROGRAM) {
			System.out.println("1: Deposit Into Checking");
			System.out.println("2: Withdraw From Checking");
			System.out.println("3: Deposit Into Savings");
			System.out.println("4: Withdraw From Savings");
			System.out.println("5: Display Checking Transactions");
			System.out.println("6: Display Savings Transactions");
			System.out.println("7: Exit");
			System.out.println("Enter a selection from the menu:");
			response = console.nextInt();
			menuSelection(response);
		}
	}
	
	private void menuSelection(int userResponse) {
		double depositAmount = 0.0;
		double withdrawAmount = 0.0;
		switch(userResponse) {
		case 1:
			System.out.print("How much to deposit into checking?");
			depositAmount = console.nextDouble();
			while(depositAmount<0.0) {
				System.out.print("Please enter an amount greater than zero");
				depositAmount = console.nextDouble();
			}
			checkingAccount.deposit(depositAmount);
			break;
			
		case 2:
			System.out.print("How much to withdraw from checking?");
			withdrawAmount = console.nextDouble();
			while(withdrawAmount<0.0) {
				System.out.print("Please enter an amount greater than zero");
				withdrawAmount = console.nextDouble();
			}
			checkingAccount.withdraw(withdrawAmount);
			break;
		
		case 3:
			System.out.print("How much to deposit into savings?");
			depositAmount = console.nextDouble();
			while(depositAmount<0.0) {
				System.out.print("Please enter an amount greater than zero");
				depositAmount = console.nextDouble();
			}
			savingsAccount.deposit(depositAmount);
			break;
			
		case 4:
			System.out.print("How much to withdraw from savings?");
			withdrawAmount = console.nextDouble();
			while(withdrawAmount<0.0) {
				System.out.print("Please enter an amount greater than zero");
				withdrawAmount = console.nextDouble();
			}
			savingsAccount.withdraw(withdrawAmount);
			break;
			
		case 5:
			checkingAccount.displayLedgerEntries();
			break;
			
		case 6:
			savingsAccount.displayLedgerEntries();
			break;
			
		case 7:
			break;
			
		default:
			System.out.println("Invalid Entry");
			break;
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		BankApp bank = new BankApp();
		bank.displayMenu();

	}

}
