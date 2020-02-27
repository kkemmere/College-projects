
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try 
		{
			for (int i = 0; i < 10000; i++)
			{

				if (i % 100 == 0)
				{
					Thread.sleep(100);
				}
				else 
				{
					System.out.println(name + ", " + counter +  ", Total: " + AtCounter.getAndIncrement() * 4);
					counter++;
				}
			}
			
		}
		catch (InterruptedException e) 
		{
			System.out.println(name + "Interruption Occured");
		}
			System.out.println(name + " Exited");
	}

}
