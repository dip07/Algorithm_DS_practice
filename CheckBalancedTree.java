/**
 *	Checks if a binary tree is height balanced or not
 *
 *  Complexity O(n)
 *
 */
public class CheckBalancedTree {

	class Node {

		int data;
		Node left, right;

		Node(int d) 
		{
			data = d;
			left = right = null;
		}
	}

	// A wrapper class used to modify height across recursive calls.
	class Height
	{
		int branchHeight = 0;
	}
	class BinaryTree {

		Node root;

		boolean isBalanced(Node root, Height height)
		{
			/* If tree is empty then return true */
			if (root == null)
			{
				height.branchHeight = 0;
				return true;
			}

			/* Get heights of left and right sub trees */
			Height leftH = new Height(), rightH = new Height();
			boolean isLeftBalanced = isBalanced(root.left, leftH);
			boolean isRightBalanced = isBalanced(root.right, rightH);
			int lh = leftH.branchHeight, rh = rightH.branchHeight;

			/* Height of current node is max of heights of
			left and right subtrees plus 1*/
			height.branchHeight = (lh > rh ? lh: rh) + 1;

			/* If difference between heights of left and right
			subtrees is more than 1 then this node is not balanced
			so return 0 */
			if (Math.abs(lh - rh) > 1)
				return false;

			/* If this node is balanced and left and right subtrees
			are balanced then return true */
			return isLeftBalanced && isRightBalanced;
		}
	}
	public static void main(String args[])
	{
		Height height = new CheckBalancedTree().new Height();

		/* Constructed binary tree is
				1
				/ \
				2	 3
			/ \ /
			4	 5 6
			/
		7		 */
		BinaryTree tree = new CheckBalancedTree(). new BinaryTree();
		tree.root = new CheckBalancedTree().new Node(1);
		tree.root.left = new CheckBalancedTree().new Node(2);
		tree.root.right = new CheckBalancedTree().new Node(3);
		tree.root.left.left = new CheckBalancedTree().new Node(4);
		tree.root.left.right = new CheckBalancedTree().new Node(5);
		tree.root.right.right = new CheckBalancedTree().new Node(6);
		tree.root.left.left.left = new CheckBalancedTree().new Node(7);

		if (tree.isBalanced(tree.root, height))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
