import java.util.ArrayList;
/**
 * This class creates and initiates all users with Account objects.
 * It also creates and initiates bank account details such as account number and balance. 
 *   
 * @author  Ivy Lee
 * @version 2 on 2016.04.17
 */

public class User {
	
	private ArrayList<Account> user;
		
	public User() {
    	/* 
		  * Initiate userID in the ArrayList<Account>; 
      */
    	user = new ArrayList<Account>(); 
    	addUser("A000"); //index0
    	addUser("A001"); //index1
    	addUser("A002"); //index2
    	addUser("A003"); //index3
    	addUser("A004"); //index4
    	addUser("A005"); //index5
    	addUser("A006"); //index6
    	addUser("A007"); //index7
    	addUser("A008"); //index8
    	addUser("A009"); //index9
    	addUser("A010"); //index10
    	addUser("A011"); //index11
    	addUser("A012"); //index12
    	addUser("A013"); //index13
    	createBankdetail();
	}
	/* 
	* Initiate users' Account HashMap and stores more than 20 objects
  */
	public void createBankdetail(){
		user.get(0).createbankAc("000-001", 609.00);
		user.get(0).createbankAc("000-002", 9.00);
		
		user.get(1).createbankAc("001-001", 4578.00);
		user.get(1).createbankAc("001-002", 16.00);
		
		user.get(2).createbankAc("002-001", 589.00);
		user.get(2).createbankAc("002-002", 67.90);
		
		user.get(3).createbankAc("003-001", 28.62);
		user.get(3).createbankAc("003-002", 120.00);
		
		user.get(4).createbankAc("004-001", 203.50);
		user.get(4).createbankAc("004-002", 11.00);
		user.get(4).createbankAc("004-003", 69.99);
		
		user.get(5).createbankAc("005-001", 1280.00);
		
		user.get(6).createbankAc("006-001", 1000.00);
		user.get(6).createbankAc("006-002", 3.48);
		
		user.get(7).createbankAc("007-001", 319.00);
		
		user.get(8).createbankAc("008-001", 124.89);
		user.get(8).createbankAc("008-002", 128.60);
		
		user.get(9).createbankAc("009-001", 1045.00);
		
		user.get(10).createbankAc("010-001", 233.54);
		user.get(10).createbankAc("010-002", 511.00);
		
		user.get(11).createbankAc("011-001", 634.50);	
	}
    /*
    * Add userID to ArrayList.
    */
    public void addUser(String userID) 
    { 
    	userID = userID.toUpperCase();
    	user.add(new Account(userID));
    }
    /*
    * Get the account in the arrayList.
    * @param userID as String .
    * @return user's Account object if the userID is matched.
    */
    public Account getUser(String userID){
    	for (int j=0; j <= user.size(); j++)
    	{
    		if (userID.equals(user.get(j).getAc()))
    		{	
    			return user.get(j); 
    		}
    	}
	 	return user.get(-1);
    }
    /*
    * Get the user's index in the arrayList.
    * @param userID as String .
    * @return user's index as Integer if the userID is matched.
    */
    public int getUserindex(String userID){
        	for (int j=0; j <= user.size(); j++)
        	{
        		if (userID.equals(user.get(j).getAc()))
        		{	
        			return j; 
        		}
        	}
        	System.out.println("Sorry. Your user ID is not valid.");
        	return -1;
        }
    /*
    * Store account details to user's Account HashMap information .
    */
    public void storeBankdetail(int index, String accountNo, double balance){
    	user.get(index).createbankAc(accountNo, balance);
    }   
}
