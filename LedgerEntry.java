
public class LedgerEntry {

	private double amount; //The amount in the account
	private double depositAmount; //The amount to deposit
	private double withdrawAmount; //The amount to withdraw
	private String entryType; // Entry type is either Checking or Savings
	private String zipcode;
	
	public LedgerEntry() {
		entryType = " ";
		amount = 0.0;
		depositAmount = 0.0;
		withdrawAmount = 0.0;
		zipcode = " ";
		
	}
	
	public void addEntry(String accountType, double accountDepositAmount, double accountWithdrawAmount, double accountAmount, String zip) {
		entryType = accountType;
		depositAmount = accountDepositAmount;
		withdrawAmount = accountWithdrawAmount;
		amount = accountAmount;
		zipcode = zip;
	}
	
	public void displayEntry() {
		System.out.println("------------------------------------------------------");
		System.out.println("Entry Type: " + entryType);
		System.out.println("Zipcode: " + zipcode);
		if(depositAmount != 0) {
			System.out.printf("Deposited Amount: $%.2f " + depositAmount);
		}
		if(withdrawAmount != 0) {
			System.out.printf("Withdrawn Amount: $%.2f " + withdrawAmount);
		}
		System.out.printf("Current amount: $%.2f", amount);
		
		System.out.println("------------------------------------------------------");
	}
	
	
	
}
