import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Generic Tree class, Kevin Kemmerer, Iyengar 341
 * 
 * This class creates and adds values to a generic tree such that
 * you're able to find the height and use pre order, level order, 
 * or post order traversal methods to traverse the tree.
 */

public class gtree {
	
	// Data
	static Node root;
	
	private int height;

	// gtree constructor
	public gtree()
	{
		root = null;
		height = 0;
	}

	// insert a node into tree
	public Node insertNode(Node curr, String val)
	{
		if (curr == null)
		{
			return new Node(val);
		}
		else if (curr.left == null)
		{
			curr.left = insertNode(curr.left, val);
		}
		else if (curr.middle == null)
		{
			curr.middle = insertNode(curr.middle, val);
		}
		else if (curr.right == null)
		{
			curr.right = insertNode(curr.right, val);
		}
	
		
		return curr;
	}
	
	
	public void insert(String val)
	{
		root = insertNode(root, val);
	}
	
	// Search for a string s in tree
	public boolean contains(String s, Node n)
    {
        if( n == null )
            return false;
            
        int compareResult = s.compareTo( n.data );
        
        if( compareResult < 0)
            return contains( s, n.left );
        else if( compareResult > 0 )
            return contains( s, n.right );
        else
            return true;    // Match
    }
	
	 public boolean contains(String s )
	    {
	        return contains( s, root );
	    }

	// post order tree traversal
	public void PstOrder(Node n)
	{
		if (n == null)
		{
			return;
		}
			PstOrder(n.left);
			PstOrder(n.middle);
			PstOrder(n.right);
			System.out.print(" " + n.data);
		
	}
	
	public void postOrder()
	{
		PstOrder(root);
	}
	
	// level order tree traversal
	public void LevelOrder()
	{
		if (root == null)
		{
			return;
		}
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		while (!nodes.isEmpty())
		{
			Node node = nodes.remove();
			
			System.out.print(" " + node.data);
			
			if (node.left != null)
			{
				nodes.add(node.left);
			}
			
			if (node.middle != null)
			{
				nodes.add(node.middle);
			}
			
			if (node.right != null)
			{
				nodes.add(node.right);
			}
		}
	}
	
	// height of tree method
	public int height(Node n) {
		
		if (n == null)
			return -1;
		else 
			return 1+ Math.max(height(n.middle), Math.max(height(n.left), height(n.right)));
	}
	
	public Node getroot()
	{
		return root;
	}
	
	// pre order traversal tree method
	public static void PreOrder(Node n)
	{
		if (n == null)
			return;
		System.out.print(" " + n.data);
			if (n.left != null)
				{
				PreOrder(n.left);
				}
			if (n.middle != null)
			{
				PreOrder(n.middle);
			}
			if (n.right != null)
				{
					PreOrder(n.right);
				}
		
		
	}
	
	public static void preOrder() {
	    PreOrder(root);
	  }
	
	
	public static void main(String args[]) throws FileNotFoundException
	{
		
		// Testing out gtree with small values without reading from file
		 gtree testtree = new gtree();
		 
		 testtree.root = new Node("1");
		 testtree.root.left = new Node("2");
		 testtree.root.middle = new Node("2.5");
		 testtree.root.left.right = new Node("4");
		 testtree.root.right = new Node("5");
		 testtree.root.left.left = new Node("3");
		 
		 System.out.println("Preorder traversal of the generic TEST tree is " );
		 testtree.preOrder();
		 System.out.println();
		 System.out.println("The Height of the TEST tree is " + testtree.height(root));
		 System.out.println("Postorder traversal of the generic TEST tree is ");
		 testtree.postOrder();
		 System.out.println();
		 System.out.println("Levelorder traversal of the generic TEST tree is ");
		 testtree.LevelOrder();
		 System.out.println();
		 System.out.println();

		 
		// Creating new generic tree using values from file
		gtree tree = new gtree();
		 
		Scanner infile = new Scanner(new File("tree.dat"));
			
		String numChildren = infile.nextLine();
	
			
		StringTokenizer stkr1 = new StringTokenizer(numChildren);
		int r1size = stkr1.countTokens();
		String[] children = new String[r1size];
		
		tree.root = new Node(infile.nextLine());
		
		String rootChildren = infile.nextLine();
		
		StringTokenizer stkRtChld = new StringTokenizer(rootChildren);
		int nChildren = stkRtChld.countTokens();
		String rt = stkRtChld.nextToken();
		
	// Setting the values to the correct spot on the tree
	if (stkRtChld.hasMoreElements())
	{
		tree.root.left = new Node(stkRtChld.nextToken());
	}
	
	if (stkRtChld.hasMoreElements())
	{
		tree.root.middle = new Node(stkRtChld.nextToken());
	}
	
	if (stkRtChld.hasMoreElements())
	{
		tree.root.right = new Node(stkRtChld.nextToken());
	}
		String leftChildren = infile.nextLine();
		
		StringTokenizer stkLftChld = new StringTokenizer(leftChildren);
		int lChildren = stkLftChld.countTokens();
		String lt = stkLftChld.nextToken();
		
	if (stkLftChld.hasMoreElements())
	{
		tree.root.left.left = new Node(stkLftChld.nextToken());
	}
	if (stkLftChld.hasMoreElements())
	{
		tree.root.left.middle = new Node(stkLftChld.nextToken());
	}
	
	if (stkLftChld.hasMoreElements())
	{
		tree.root.left.right = new Node(stkLftChld.nextToken());
	}
	
		String lftlftchildren = infile.nextLine();
		
		StringTokenizer stklftLftChld = new StringTokenizer(lftlftchildren);
		int leftleftchildren = stklftLftChld.countTokens();
		String lftlft = stklftLftChld.nextToken();
	
	if (stklftLftChld.hasMoreElements())
	{
		tree.root.left.left.left = new Node(stklftLftChld.nextToken());
	}
	
	if (stklftLftChld.hasMoreElements())
	{
		tree.root.left.left.middle = new Node(stklftLftChld.nextToken());
	}
	
	if (stklftLftChld.hasMoreElements())
	{
		tree.root.left.left.right = new Node(stklftLftChld.nextToken());
	}
	
		String midchildren = infile.nextLine();
		
		StringTokenizer stkmidChld = new StringTokenizer(midchildren);
		int middlechildren = stkmidChld.countTokens();
		String middle = stkmidChld.nextToken();
		
	if (stkmidChld.hasMoreElements())
	{
		tree.root.middle.left= new Node(stkmidChld.nextToken());
	}	
	
	if (stkmidChld.hasMoreElements())
	{
		tree.root.middle.middle = new Node(stkmidChld.nextToken());
	}
	
	if (stkmidChld.hasMoreElements())
	{
		tree.root.middle.right = new Node(stkmidChld.nextToken());
	}
			
	String lftLftmidchildren = infile.nextLine();
	
	StringTokenizer stklftLftMidChld = new StringTokenizer(lftLftmidchildren);
	int lftLftMidchildren = stklftLftMidChld.countTokens();
	String lftlftmiddle =  stklftLftMidChld.nextToken();
	
	if ( stklftLftMidChld.hasMoreElements())
	{
		tree.root.left.left.middle.left = new Node(stklftLftMidChld.nextToken());
	}	
	
	if ( stklftLftMidChld.hasMoreElements())
	{
		tree.root.left.left.middle.middle = new Node( stklftLftMidChld.nextToken());
	}
	
	if ( stklftLftMidChld.hasMoreElements())
	{
		tree.root.left.left.middle.right = new Node( stklftLftMidChld.nextToken());
	}
	
	String midlftchildren = infile.nextLine();
	
	StringTokenizer stkmidlftChld = new StringTokenizer(midlftchildren);
	int midleftchildren = stkmidlftChld.countTokens();
	String midlft = stkmidlftChld.nextToken();
	
	if (stkmidlftChld.hasMoreElements())
	{
		tree.root.middle.left.left = new Node(stkmidlftChld.nextToken());
	}	
	
	if ( stkmidlftChld.hasMoreElements())
	{
		tree.root.middle.left.middle = new Node( stkmidlftChld.nextToken());
	}
	
	if ( stkmidlftChld.hasMoreElements())
	{
		tree.root.middle.left.right = new Node( stkmidlftChld.nextToken());
	}
	
	
	String rightchildren = infile.nextLine();
	
	StringTokenizer stkrtChld = new StringTokenizer(rightchildren);
	int rtchildren = stkrtChld.countTokens();
	String right = stkrtChld.nextToken();
	
	if (stkrtChld.hasMoreElements())
	{
		tree.root.right.left = new Node(stkrtChld.nextToken());
	}	
	
	if (stkrtChld.hasMoreElements())
	{
		tree.root.right.middle = new Node(stkrtChld.nextToken());
	}
	
	if (stkrtChld.hasMoreElements())
	{
		tree.root.right.right = new Node(stkrtChld.nextToken());
	}
	
	 
			
	
		// Pre Order traversal of the generic tree using recursive preorder method
		System.out.println("Pre order traversal of the generic tree is " );
		tree.preOrder();
		System.out.println();
		System.out.println();
		
		// Height of generic tree using height method
		System.out.println("The height of the generic tree is " + tree.height(root));
		System.out.println();
		
		// Post Order traversal of the generic tree using recursive postorder method
		System.out.println("Post order traversal of the generic tree is ");
		tree.postOrder();
		System.out.println();
		System.out.println();
		
		String s = "33";
		tree.root.left.left.middle.right = new Node(s);
		System.out.println(s + " was inserted into the tree");
		
		// Level Order traversal of the generic tree using recursive levelorder method
		System.out.println("Level order traversal of the generic tree is ");
		testtree.LevelOrder();
		System.out.println();
		System.out.println();
		
		System.out.println("Does the generic tree contain 29? " + tree.contains("29"));
		System.out.println("Does the generic tree contain 1? " + tree.contains("1"));
		System.out.println("Does the generic tree contain 100? " + tree.contains("100"));
		System.out.println();
		
		// Height of generic tree using height method
		System.out.println("The height of the generic tree is " + tree.height(root));
		System.out.println();
		
	}


	
}
