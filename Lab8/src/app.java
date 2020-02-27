
public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("The binary of 2954 is : " + Util.decToBin(2954));
		
		System.out.println(Util.decToBin(2954/2));
		
		System.out.println(Util.power(5, 440));
		
		System.out.println(Math.pow(5, 440));
		
		int[] data = {3, 8, 12, 18, 21, 32, 33, 38, 40, 45, 50};
		
		System.out.println("3 is searched and found at " + Util.recbinarysearch(data, 3, 0, 9));
		
		System.out.println("45 is searched and found at " + Util.binarysearch(data, 45));
		
		System.out.println("5 is searched and found at " + Util.binarysearch(data, 5));
		
		System.out.println("45 is searched and found at " + Util.recbinarysearch(data, 45, 0, 9));
		
	}

}
