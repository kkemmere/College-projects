
public class Circle
{
	// data
	
	    private double radius;
	
	// methods
	    // public double getA()
	    // public double getC()
	    // public double getD()
	    // public void setR(double R)
	    // public void setD(double D)
	    // public void setC(double R)
	    // public void setA(double A)
	    
	    
	    public double getA()
	    {
	    	return (Math.PI * radius * radius);
	    }
	    
	    public double getC()
	    {
	    	return (2.0 *Math.PI * radius );
	    }
	    
	    public double getD()
	    {
	    	return (2.0 * radius );
	    }
	    
	    public double getR()
	    {
	    	return (radius );
	    }
	    
	    public void setR(double R)
	    {
	    	radius = R;
	    }

	    public void setD(double D)
	    {
	    	radius = D/2.0;
	    }
	    
	    public void setC(double C)
	    {
	    	radius = C/(2.0 * Math.PI);
	    }
	    
	    public void setA(double A)
	    {
	    	radius = Math.sqrt(A/(Math.PI));
	    }
	// constructor(s)
	    
	   public Circle ()
	   {
		   radius = 1.0;
	   }
	    
	   public Circle (double R)
	   {
		   radius = R;
	   }
	    
	    
	   
		}	
