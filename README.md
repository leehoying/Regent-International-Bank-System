# Regent-International-Bank-System
Java Program by Ivy Lee on April, 2016

This Java program provides a series of methods for user and account validations before proceeding the function requested.
There are a list of different functions to be operated in the system (i.e open, select & close account, deposit & withdraw money, list account balances). 
   
1. Each user will be given an unique userID from the bank after finishing the registration (e.g. A001 to A011...). The user can only login when their userID is existing in the system.(i.e. new users A012 & A013 can login to open their bank account) 
2. Each user has to input the password to validate the account. This strengthens the system's security.
3. In each command function, the system will list all users accounts and decide next step for users. 
 For example, 
 - display only 'open account' or 'quit' functions and suggest new users to open the account.
 - the account will be automatically selected as if users have only one account.
 - ask multiple accounts users to select one account to proceed the selection function.  
4. To minimize the error, user will be requested to input account listed number instead of entering full account no. 
5. When user would like to close account, the system will ask user yes-no question to re-confirm the operation.
