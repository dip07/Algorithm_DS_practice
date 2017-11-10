public class CheckIfNodesAreCousin {
	private static class Node {

		int data;
		Node left, right;

		Node(int d) 
		{
			this.data = d;
			left = right = null;
		}
	}
	public static void main(String[] args) {

		Node root = new Node(1);
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        
        Node node1 = root.left.left;
        Node node2 = root.right.right;
        System.out.println(isCousin(root, node1, node2));
        
	}
	private static boolean isCousin(Node root, Node node1, Node node2)
	{
		return isCousinHelper(root, node1, node2, 1, new int[1]);
	}
  // levelRef being array, will persist between recursive calls
	private static boolean isCousinHelper(Node root, Node node1, Node node2, int currLevel, int levelRef[]) 
	{
		if(root == null)
			return false;
		if( (root.left == node1 && root.right == node2) ||
				(root.left == node2 && root.right == node1) )
			return false;
		if(root == node1 || root == node2)
		{
			if(levelRef[0] == 0)
				levelRef[0] = currLevel;
			else if(levelRef[0] == currLevel)
				return true;
			else
				return false;
		}
		
		boolean checkRight = isCousinHelper(root.right, node1, node2, currLevel +1 , levelRef);
		boolean checkLeft = isCousinHelper(root.left, node1, node2, currLevel +1 , levelRef);
		return checkRight || checkLeft;
	}
}
