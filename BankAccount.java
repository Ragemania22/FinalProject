
/*
 * 
 * Code changed the only issue I do have is using the zipcode to validate transactions
 * Should I use a boolean methods that the input is the zipcode string then run if the string starts "11" (area of where he lives)
 * then it return true and continues the looping process if it does not start with "11" then it prompts the user a scanner method that says
 * Do you authorize this transaction 
 *  
 */


public class BankAccount{

	private String owner; //Account Owner
	private String zipcode; //Zipcode of the owner (also used to check the transactions in the ledger)
	private double currentBalance; //Initial amount of money to open or is in the account
	private LedgerEntry[] accountLedger;  //Collections of all transactions (as objects)
	
	private int ledgerEntryCount; // Number of entries in the ledger
	private final int MAX_ENTRIES = 100; //Max number of entries in the ledger
	
	//Default Constructor
	public BankAccount() {
		owner = " "; //Set account User to an empty string
		
		zipcode = " "; //Set User zipcode to an empty string
		
		currentBalance = 0.0; //Set the initialBalance to to zero
		
		ledgerEntryCount = 0; // set the number of entries in ledger to zero
		
		initLedger(); //Initialize the ledger
	}
	
	
	
	BankAccount(String accountOwner, String ownersZipcode, double initialBalance){
		owner = accountOwner;
		zipcode = ownersZipcode;
		currentBalance = initialBalance;
		
		ledgerEntryCount = 0;
		initLedger();
	}
	
	
	//Initialize the Ledger -- called from Constructor
	void initLedger() {
		accountLedger = new LedgerEntry[MAX_ENTRIES];
		//Create an entry with the initial amount in the ledger
		accountLedger[ledgerEntryCount] = new LedgerEntry();
		accountLedger[ledgerEntryCount].addEntry("Deposit", currentBalance, 0, currentBalance, zipcode);
		ledgerEntryCount += 1;
		
	}
	//Deposit some money into the account
	public void deposit(double dAmount) {
		//Add the amount to deposit to the current amount in the account
		currentBalance = currentBalance + dAmount;
		accountLedger[ledgerEntryCount] = new LedgerEntry();
		//Add a deposit entry into the ledger for the account
		accountLedger[ledgerEntryCount].addEntry("Deposited amount of $", dAmount, 0, currentBalance, zipcode);
		ledgerEntryCount += 1;
	}
	
	public void withdraw(double wAmount) {
		currentBalance = currentBalance - wAmount;
		accountLedger[ledgerEntryCount] = new LedgerEntry();
		//Add an entry into the ledger for the account
		accountLedger[ledgerEntryCount].addEntry("Withdrawn amount of $", 0, wAmount, currentBalance, zipcode);
		ledgerEntryCount += 1;
	}
	
	public void displayLedgerEntries() {
		System.out.println("Account Owner: " + owner);
		System.out.println("*****************************************************");
		
		//Display all of the entries in the ledger with understanding that
		//the way the program was written we add one to the ledger AFTER the
		//entry has been made
		for(int i = 0; i<ledgerEntryCount; i++) {
			accountLedger[i].displayEntry();
		}
		System.out.println("*****************************************************");
	}
	
	
}
