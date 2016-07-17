import java.util.HashMap;
/**
 * This class creates and initiates all commands.  
 *   
 * @author  Ivy Lee
 * @version 2016.04.13
 */
public class Command {

	private String letter;
    private String description;
    private HashMap<String, String> instruction; 
    
	public Command() {
	    /*
	    * initiate representative letters and commands in the HashMap.
		  */
        instruction = new HashMap<String, String>();
        instruction.put("o", "Open Account");
        instruction.put("c", "Close Account");
        instruction.put("d", "Deposit");
        instruction.put("w", "Withdraw");
        instruction.put("q", "Quit");
        instruction.put("l", "List & Select Account");
	}
      /*
      * get the key in the HashMap
      * @return command's letter as String.
      */
      public String getLetter()
       {
           return letter;
       }
	   /*
	   * get the information corresponding to the key 
	   * @return command's description as String.
	   */
       public String getDescription()
       {
           return description;
       }
	   /*
	   * List out all commands' keywords and descriptions.
	   */        
       public void listCommand(){
	       for (String key : instruction.keySet()) {
	       System.out.println("	"+key+" - "+instruction.get(key));
	       }
       }
	   /*
	   * List out specific commands' keywords and descriptions.
	   */
       public void listBasic(){
	       for (String key : instruction.keySet()) {
	    	   if (key=="o"||key=="q"){
				   System.out.println("	"+key+" - "+instruction.get(key));
	    	   }
	       }
       }
}
