package BankAccount;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		CheckingAccount[] myCAs = new CheckingAccount[5]; // creating 5 checking accounts
		
		for (int i = 0; i < 5; i++)
		{
			myCAs[i] = new CheckingAccount();
		}
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println(myCAs[i]);
		}
		
		System.out.println("Next are the savings accounts");
		
		SavingsAccount[] mySAs = new SavingsAccount[5]; // creating 5 savings accounts
		
		for (int i = 0; i < 5; i++)
		{
			mySAs[i] = new SavingsAccount();
		}
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println(mySAs[i]);
		}

	    */
		
		BankAccount[] accts = new BankAccount[5]; // create 5 bank accounts
		
		accts[0] = new CheckingAccount();
		accts[1] = new SavingsAccount();
		accts[2] = new SavingsAccount();
		accts[3] = new SavingsAccount();
		accts[4] = new CheckingAccount();
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println(accts[i]);
		}
	
	}
}
