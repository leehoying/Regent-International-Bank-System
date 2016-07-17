import java.util.HashMap;
import java.util.ArrayList;
/**
 * This class creates, accesses and removes Account Object and bank details. 
 * It provides methods for incoming and outgoing money transactions.  
 *   
 * @author  Ivy Lee
 * @version 2 on 2016.04.17
 */
public class Account {
	 
	private String userID;
    private HashMap<String, Double> bankAc; 
    private ArrayList<String> listAc;
    private ArrayList<Double> listBal;
    
    public Account(String userID) {
    /* 
		* Initiate Account's userID and HashMap 
    */
    	this.userID = userID;
        bankAc = new HashMap<String, Double>();
        listAc = new ArrayList<String>();
        listBal = new ArrayList<Double>();
	}
	/* 
	* Get userID detail in Account object 
	* @return userID as String
  */
    public String getAc()
	    {
		return this.userID;
	    }
    /*
    * Create new user's account number and balance in the HashMap.
    */
    public void createbankAc(String accountNo, double balance)
       { 
    	  accountNo = accountNo.toLowerCase();
    	  bankAc.put(accountNo,balance);
       }
    /*
    * Delete new user's account number and balance in the HashMap.
    */
    public void deletebankAc(String accountNo){
       
    	  bankAc.remove(accountNo);
       }
	/* 
	* Get user's selected account as current account
	* @param inputNo as Integer
	* @return account number as String 
  */
    public String getCurrentAc(int inputNo){
    	inputNo = inputNo - 1;
    	return listAc.get(inputNo);
    }
	/* 
	* Get user's selected balance as current balance
	* @param inputNo as Integer
	* @return account balance as Double 
  */
    public Double getCurrentBal(int anotherNo){
      	anotherNo = anotherNo - 1;
    	return listBal.get(anotherNo);
    }
  /*
	* Show the amount after incoming money
	* @param current account balance as Double, incoming amount as Double
	* @return new account balance as Double
  */
	public double deposit (double total, double money){
		total = total + money; 
		return total;
	}
  /*
	* Show the amount after outgoing money
	* @param current account balance as Double, outgoing amount as Double
	* @return new account balance as Double
  */
	public double withdraw (double total, double money){
		total = total - money; 
		return total;
	}
    /*
    * Find out and display an user's all account number and balance.
    * Add those sorted account numbers and balances into two ArrayLists(listAc & listBal).
    * @return number of accounts as Integer.
    */
    public int listAll(){
    	listAc.clear(); 
    	listBal.clear();
      	int i = 1;
    	for (String key : bankAc.keySet()) {
	    	System.out.println("Account #"+i+": "+key+" Balance: "+bankAc.get(key));
	    	listAc.add(key); 
	    	listBal.add(bankAc.get(key));
	    	i++;
	    	}
     	return i;
    }
    /*
    * Find out an user's all account number and balance but without display.
    * Add those sorted account numbers and balances into two ArrayLists(listAc & listBal).
    * @return number of accounts as Integer.
    */
    public int refresh(){
    	listAc.clear(); 
    	listBal.clear();
      	int i = 1;
    	for (String key : bankAc.keySet()) {
	    	listAc.add(key); 
	    	listBal.add(bankAc.get(key));
	    	i++;
	    	}
     	return i;
    }
  /*
	* Check whether the input is within the ArrayList.
	* @param inputNo as Integer
	* @return true if within the ArrayList
  */
    public boolean isValid(int inputNo){
    	if (inputNo <= listAc.size())
    	{
    		return true;
    	}
    	return false;
    }
    /*
    * Check user's account numbers whether is exist.
    * Allow to open new account otherwise.
    * @param accountNo as Account object
    */
    public void validAccount(Account accountNo){  	
	    for(int i=0; i<=listAc.size(); i++)	{
		    if (listAc.get(i).equals(accountNo))	
		    {
		    System.out.println("Sorry. The account is registered.");
		    Banking.openAccount();	
		    }
    	}
    	newAccount();
    }
    /*
    * Assume that every user can hold max.of 6 accounts.
    * Create new account number by using 'userID-xxx', 
    * xxx is the last account numbers found in the last user's listAc arrayList plus 4.
    * @return currentAccount as String, that is new account number
    */
	public String newAccount(){
		int num = refresh();
		String currentAccount="";
    	String firstPart = userID.substring(1,4);
			if (num == 1) {
		    	String newNum = "001";
		    	currentAccount = (firstPart+"-"+newNum).toString();
		    	System.out.println("Your new account number is "+currentAccount); 
			}
			if (num > 1 && num <7){
				currentAccount = listAc.get(0);
		    	String secondPart = currentAccount.substring(4,7);
		    	int newNum = Integer.parseInt(secondPart);
		    	newNum = newNum + 4;     	
			    	if (newNum <10) {
			    	currentAccount = (firstPart+"-00"+newNum).toString();
			    	} else if (newNum < 100 && newNum >=10){
				    currentAccount = (firstPart+"-0"+newNum).toString();		    		
			    	}else {			    	
			    	currentAccount = (firstPart+"-"+newNum).toString();
			    	}
		    	System.out.println("Your new account number is "+currentAccount);
			} 
			if (num == 7) {
	    		System.out.println("Please contact our customer service if you would like to open new account");
	    		Banking.quit();
	    		}
			return currentAccount;
	}
}
