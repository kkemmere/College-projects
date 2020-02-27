
public class CurrencyConvertor {
	
	//Data
	
	private double conRate;   // ratio of foreign currency to US currency

	// Methods
	// public double toUS (double amt)
	// public double romUS (double amt)
	// public void setconRate( double rate)
	// public double getconRate()
	public double toUS (double amt)
	{
		return (amt / conRate);
	}
	
	public double fromUS (double amt)
	{
		return (amt * conRate);
	}
	
	public void setconRate( double rate)
	{
		conRate = rate;
	}
	
	public double getconRate()
	{
		return conRate; 
	}
	
	// constructor(s)
	
	public CurrencyConvertor()   // no parameters, set conRate to 1.0, why not 0?
	{
		conRate = 1.0;
	}
	
	
	public CurrencyConvertor(double rate)   // no parameters, set conRate to 1.0, why not 0?
	{
		conRate = rate;
	}
	public static void main(String[] args) {
		// Test CurrencyConvertor here
		// remove this main when finished testing!
		
		// check constructors  (make as many instances as number 
		// of constructors
		
		CurrencyConvertor cC1 = new CurrencyConvertor();
		CurrencyConvertor cC2 = new CurrencyConvertor(10.0);
		System.out.println( "CC1's rate is " + cC1.getconRate());
		System.out.println( "CC2's rate is " + cC2.getconRate());	
		// we also checked the data and getconRate()
		
		// check methods
		// toUS  and fromUS
		
		System.out.println( "100 pesos is " + cC2.toUS(100.0));
		System.out.println( "50 dollars is " + cC2.fromUS(50.0));
		
	}

}
