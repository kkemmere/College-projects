 /*
 * 
 * 
 * 
 * 
 */
package BankAccount;

public class CheckingAccount extends BankAccount {
	
// I don't have to write a data member here which is AccountID
	
	private static int Acct = 0;
	
	public CheckingAccount()
	{
		setAcctID();
	}
	
	public void setAcctID() {
	
		AccountID = createAccountID();
	}

	private String createAccountID() {
		
		// TODO Auto-generated method stub
		return super.createAcctString() + "CHK" + Acct++;
	}

	public String toString()
	{
		return "The account ID is " + AccountID;
	
	}
}
