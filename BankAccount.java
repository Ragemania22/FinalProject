
/*
 * Account Owner (String)
 * Owners zipcode (String) I set this a string because I will be using either the first two or three characters to run the checks in the LedgerEntry summary
 * initialBalance (double)
 * LedgerEntry[] accountLedger // the collection of all the transactions (as objects)
 * ledgerEntryCount (int) // number of entries thus far
 * MAX_ENTRIES (final int) // The max amount of entries I would like to store in the project (Will never go over 100 entries) 
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
