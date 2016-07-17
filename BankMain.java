import java.util.InputMismatchException;

/**
 * This is an online banking service system of Regent International Bank.
 * It provides its account holder to open new account, close account, deposit money, withdraw money and check all their account balances.
 *   
 * @author  Ivy Lee
 * @version 2 on 2016.04.17
 */
public class BankMain {

	public static void main(String[] args) {
	    /*
	    * Access directly and start Banking. 
	    * IndexOutOfBoundsException is used to handle error 
	    * when the value is not found in ArrayList's and HashMap's search. 
	    * InputMismatchException is used to handle error 
	    * when the input value cannot be recognised.
	    * @exception IndexOutOfBoundsException handles error when searching out of ArrayList bound
	    * @exception InputMismatchException handles incorrect type of user input 
		  */
		new Banking();
		try{
			Banking.BankService();
			}catch(IndexOutOfBoundsException e){ 
				System.out.println("UserID is not exist.");
				Banking.validation();
			}catch(InputMismatchException e){
				System.out.println("Your input cannot be recogised. Please start again");
				Banking.validation();
			}finally {
				System.out.print("");
			}
		}
}
