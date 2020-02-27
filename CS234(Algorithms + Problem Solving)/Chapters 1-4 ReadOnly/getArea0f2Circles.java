/*  this calculates the difference of areas 
 * of two circles
 * by Paul  10/4/2016
 */
public class getArea0f2Circles 
{

	public static void main(String[] args) 
	{
		// Declare and create 2 circles
		//  with r1 = 1 and r2 = 2
		
		Circle c1 = new Circle(1.0);
		Circle c2 = new Circle(2.0);
		
		// the area difference
		
		double areaDiff;
		
		// Do calculation
		
		areaDiff =c2.getA() - c1.getA();
		
		// report
		
		System.out.println( "for r1 = " + 1.0 + " and for r1 = " + 2.0 +" the area is = " + areaDiff);
		
	}

}
