import java.util.ArrayList;
/**
 * This class creates and initiates all users with Account objects.
 * It also creates and initiates bank account details such as account number and balance. 
 *   
 * @author  Ivy Lee
 * @version 3 on 2016.04.17
 */

public class Password {
	private ArrayList<String> pwd;
	/* 
	* Initiate password in the ArrayList<String>; 
  */
	public Password() {
    	pwd = new ArrayList<String>();
		pwd.add("IN162ivy"); //index 0
		pwd.add("Shoe1@aces");//index 1
		pwd.add("p@55Word");//index 2
		pwd.add("Speci@1");//index 3
		pwd.add("HONEYbunny");//index 4
		pwd.add("a610922");//index 5
		pwd.add("ilee0888");//index 6
		pwd.add("20ONEsix");//index 7
		pwd.add("ChLoe");//index 8
		pwd.add("JeFF16");//index 9
		pwd.add("batmanV");//index 10
		pwd.add("Bletchley");//index 11
		pwd.add("ButcherMAD");//index 12
		pwd.add("3+3=2");//index 13
	}
    /*
    * Check the input is same as password in the arrayList.
    * @param index as integer, pWord as String.
    */
	public void validPassword(int index, String pWord){;
		if (pwd.get(index).equals(pWord)){
			Banking.startCommand(); 
		} else {
			System.out.println("Your password is incorrect. Please try again.");
			Banking.validation();	
		}
	}
}
