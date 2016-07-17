import java.util.Scanner;
/**
 * This is the main class of the Regent International Bank online service. 
 * It provides a series of methods for user and account validations before proceeding the function requested.
 * There are a list of different functions to be operated in the system (i.e open, select & close account, deposit & withdraw money, list account balances). 
 *   
 * @author  Ivy Lee
 * @version 3 on 2016.04.17
 */
public class Banking {
	private static Command command; 
	private static Scanner input;
	private static Account account;
	private static Password password;
	private static User user;
	private static String userID;
	private static String currentBankAc;
	private static double currentBankBal;
	private static int index; 
	private static int inputNo;
	private static double balance;
	private static double amount;
	private static String YesNo;
	private static String pWord;
	
	public Banking() {	}

	public static void BankService() {
	    /*
	    * display welcome message and start the service.
		  */
		System.out.println("Welcome to Regent International Bank online service.");
		validation();
	}
    /*
    * Ask user to input their userID and validate if it is existing in the system.
    * The command menu is displayed. 
  	*/
	public static void validation() {
    	System.out.println("Please enter you a digital user ID");
    	input = new Scanner(System.in);
    	userID = input.next().toUpperCase();
    	user = new User(); 
    	index = user.getUserindex(userID);
    	account = user.getUser(userID);
      System.out.println("Please enter your password");
    	input = new Scanner(System.in);
    	pWord = input.next();
    	password = new Password();
    	password.validPassword(index, pWord);
	}
    /*
    * Display full list of commands and ask users to input the commandWord.
  	*/
	public static void startCommand(){
		String commandWord;
		boolean stop = false;
	    while (!stop) 
	    {
	    	System.out.println("-------------------------------------------------------------------");
	    	System.out.println(" Please select below commands:");
	    	command = new Command();
	    	command.listCommand();
	    	System.out.println("-------------------------------------------------------------------");
	    	commandWord = input.next().toLowerCase();
	    	processCommand(commandWord);
	    }
	}
    /*
    * Display specific commands to users who are without bank account and ask them to input the commandWord.
	  */
	public static void basicCommand(){
		String commandWord;
	    	System.out.println("-------------------------------------------------------------------");
	    	System.out.println(" Please select below commands:");
	    	command = new Command();
	    	command.listBasic();
	    	System.out.println("-------------------------------------------------------------------");
	    	commandWord = input.next().toLowerCase();
	    	if (commandWord.equals("o") | commandWord.equals("q"))
	    		{
	    		processCommand(commandWord);
	    		}
	    	else {
	    		System.out.println("Your command is invalid. Please try again");
	    		basicCommand();
	    		}
	}
	 /*
    * process different functions according to commandWord received
    * @param commandWord as String.
    * @return false if the bank service continues.
    */
	private static boolean processCommand(String commandWord) 
    {
    	if (commandWord.equals("o")) {
            openAccount();
            return false; 
        }
        else if (commandWord.equals("c")) {
        	closeAccount();    		
            return false;
        }
        else if (commandWord.equals("d")) {
    		 deposit(); 
        	 return false;
        }
        else if  (commandWord.equals("w")) {
        	withdraw();
        	return false;
        }
        else if (commandWord.equals("q")) {
        	quit();
            return true;
        }
    	else if (commandWord.equals("l")) {
    		int num = account.refresh();
    	    if (num <= 1) {
    	    	System.out.println("We don't have your bank account record. Will you like to open the account now? Input 'o' to continue");
    	    	basicCommand();}
    	    else {
    	    	account.listAll();
    	    	startCommand();
    	    	}
       		return false;
    	}
        else {
        System.out.println("Your command is invalid. Please try again");
        return false;
        }
	}
   /*
   * Display ending message and exit the system. 
   */
	public static void quit(){
    	System.out.println("Thank you for using our service. See you.");
    	System.exit(0);
	}
	 /*
    * get user's all account number and balance.
    * decide next step for users 
    * e.g. To Suggest open account for new users and limiting their commands selection, 
    * and to advise multiple accounts users to select one account.
    */
	public static void list(Account account){
    int num = account.listAll();
	    if (num <= 1) {
	    	System.out.println("We don't have your bank account record. Will you like to open the account now? Input 'o' to continue");
	    	basicCommand();}
	    else if (num == 2){
		   	inputNo = 1;
	    	currentBankAc = account.getCurrentAc(inputNo);
	    	currentBankBal = account.getCurrentBal(inputNo);
	    } 
	   else {
	    	select();
		   }
	}
	/*
	* ask users to select their account number by choosing number instead of input .
	* double check the selection is valid or not.
	*/
	public static void select(){
    	System.out.println("Please select your account:");
    	input = new Scanner(System.in);
    	inputNo = input.nextInt(); 
    	if (account.isValid(inputNo)== true){
    	currentBankAc = account.getCurrentAc(inputNo);
    	currentBankBal = account.getCurrentBal(inputNo);
    	System.out.println("Current account: "+currentBankAc+"   Balance: "+currentBankBal);
    	} else {
        	System.out.println("Account number was not found.");
        	select();
    	}
    }
	/*
	* list accounts and ask users to select and input their deposit amount.
	* double check the amount is valid or not.
	*/
	private static void deposit(){
		list(account);
    	System.out.print("Enter deposit account: ");
    	amount = input.nextInt();
    	if (amount > 0){
    	currentBankBal = account.deposit(currentBankBal, amount);
    	account.createbankAc(currentBankAc, currentBankBal);
    	System.out.println("Current account: "+currentBankAc+"   Balance: "+currentBankBal);
    	} else {
    		System.out.println("Sorry. We cannot regconise the amount. Please try again");
    		deposit();
    	}
    }
	/*
	* list accounts and ask users to select and input withdraw amount.
	* double check the amount is valid or not.
	*/
	private static void withdraw(){
		list(account);
    	System.out.print("Enter withdraw account: ");
    	amount = input.nextInt();
    	if ((0 < amount) && (amount < currentBankBal)){	
    	currentBankBal = account.withdraw(currentBankBal, amount);
    	account.createbankAc(currentBankAc, currentBankBal);
    	System.out.println("Current account: "+currentBankAc+"   Balance: "+currentBankBal);
    	} else if (amount > currentBankBal) {
    		System.out.println("Sorry. You don't have enough amount. Please try again.");
    		withdraw();
    	}	else {
    			System.out.println("Sorry. We cannot regconise the amount. Please try again");
    			withdraw();
    		}
    }
	/*
	* The system will assign the account number to user instead of input.
	* Then, it will ask users to input their initial amount.
	* double check the amount is valid or not.
	*/
	public static void openAccount(){
		currentBankAc = account.newAccount();
		System.out.print("Enter initial balance: ");
    	balance = input.nextInt();
    		if (balance >= 0)
    			{
    			index = user.getUserindex(userID);
    			balance = (double) Math.round(balance);
    			currentBankBal = balance;
    			user.storeBankdetail(index,currentBankAc, currentBankBal);
    			System.out.println("New Account registered : "+currentBankAc+"   Balance: "+currentBankBal);
    			account.refresh();
    			startCommand();
    			} else {
    			System.out.println("Sorry. We cannot recognise the amount.");
    			openAccount();
    			}
	}
	/*
	*  list accounts and ask users to re-confirm whether they wish to close their account.
	*/
	private static void closeAccount(){
		list(account);
      	input = new Scanner(System.in);
    	System.out.println("Do you wish to close this account? Y or N");
    	YesNo = input.next().toUpperCase();
    	if (YesNo.equals("Y")){
    		System.out.println("Current account: "+currentBankAc+" is closed.");
    		account.deletebankAc(currentBankAc);
    		currentBankAc = "none";
    		currentBankBal = 0.00;
      	} 
		account.refresh();
    }
}
