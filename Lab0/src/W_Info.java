/* Kevin Kemmerer, Iyengar 250 sec 02, 8/21
 * 
*  Lab0 - Files, Arrays, Loops
*  
*  Weather info class for Part2 of Lab0
*   
*/


public class W_Info {
	
	private double Htemp, Ltemp; // The high and low temperatures 
	
	public W_Info(double Htemp, double Ltemp)
	{
		this.Htemp = Htemp;
		this.Ltemp = Ltemp;
	}
	
	public double get_Htemp()
	{
		return Htemp;
	}
	
	public double get_Ltemp()
	{
		return Ltemp;
	}

	
}
