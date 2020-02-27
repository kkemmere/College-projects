/*
 * 
 * 
 * 
 * 
 */
package BankAccount;

public class SavingsAccount extends BankAccount {
	
	// create the same structure for savings account as checking account - so it has an account ID
	
	private static int Acct = 0;
	
	public SavingsAccount()
	{
		setAcctID();
	}
	
	public void setAcctID() {
	
		AccountID = createAccountID();
	}

	private String createAccountID() {
		
		// TODO Auto-generated method stub
		return super.createAcctString() + "SAV" + Acct++;
	}

	public String toString()
	{
		return "The account ID is " + AccountID;
	
	}

} 
