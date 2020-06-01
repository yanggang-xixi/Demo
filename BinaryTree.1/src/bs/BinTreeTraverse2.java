package bs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinTreeTraverse2 {

	static int[] array1 = new int[15];
	static int[] array2 = new int[15];
	static int temp = 0;
	static int count = 0;

	private static List<Node> nodeList = null;

	static String output = new String("");
	
	

	public static void visit(Node node) {

		// myEditor.textArea.setText(node.getData()+" ");
		output += node.getData() + " ";
		array2[count++] = node.getData();
		
		// count++;
		System.out.print(node.getData() + " ");
		// output += node.getData()+" ";
	}

	// create binary tree from array.the data stored in level-order

	public void createBinTree() {

		nodeList = new LinkedList<Node>();

		//for (int i = 0, len = array1.length; i < len; i++) {
			for (int i = 0; i < array1.length; i++) {

			nodeList.add(new Node(array1[i]));
			
		}

		int len = array1.length;

		int lastRootIndex = (len >> 1) - 1;

		for (int i = lastRootIndex; i >= 0; i--) {

			Node root = nodeList.get(i);

			int leftIndex = i * 2 + 1;

			Node leftNode = nodeList.get(leftIndex);

			root.setLeft(leftNode);

			// 最后的那个根节点一定是有左孩子的。右孩子则不一定

			int rightIndex = leftIndex + 1;

			if (rightIndex <= len - 1) {

				Node rightNode = nodeList.get(rightIndex);

				root.setRight(rightNode);

			}

		}

	}

	public static String preOrder1() {
		BinTreeTraverse2 tree = new BinTreeTraverse2();
		tree.createBinTree();
		count = 0;
		preOrder(nodeList.get(0));
		System.out.println();
		return output;
	}

	public static String inOrder1() {
		BinTreeTraverse2 tree = new BinTreeTraverse2();
		tree.createBinTree();
		count = 0;
		inOrder(nodeList.get(0));
		// inOrderStack(nodeList.get(0));
		System.out.println();
		return null;
	}

	public static String cnOrder1() {
		BinTreeTraverse2 tree = new BinTreeTraverse2();
		tree.createBinTree();
		count = 0;
		cnOrder(nodeList.get(0));
		
		// inOrderStack(nodeList.get(0));
		System.out.println();
		return null;
	}
	
	
	
	
	public static String postOrder1() {
		BinTreeTraverse2 tree = new BinTreeTraverse2();
		tree.createBinTree();
		count = 0;
		// postOrderStack(nodeList.get(0));
		postOrder(nodeList.get(0));
		System.out.println();
		return null;
	}

	public static void preOrderStack(Node root) {

		Stack<Node> stack = new Stack<Node>();

		Node p = root;

		if (p != null) {

			stack.push(p);

			while (!stack.isEmpty()) {

				p = stack.pop();

				visit(p);

				if (p.getRight() != null)
					stack.push(p.getRight());

				if (p.getLeft() != null)
					stack.push(p.getLeft());

			}

		}

	}
	
	public static void cnOrderStack(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		if (p != null) {

			stack.push(p);

			p = stack.pop();

				visit(p);

				
			}

		}
	



	
	

	
	
	
	

	// nonRecursion inOrder Traverse

	public static void inOrderStack(Node p) {

		Stack<Node> stack = new Stack<Node>();

		while (p != null || !stack.isEmpty()) {

			// push all LeftChild,when p has no LeftChild,that means it's
			// root,it should be visited

			while (p != null) {

				stack.push(p);

				p = p.getLeft();

			}

			if (!stack.isEmpty()) {

				p = stack.pop();

				visit(p);

				p = p.getRight();

			}

		}

	}

	// nonRecursion postOrder Traverse

	public static void postOrderStack(Node p) {

		Stack<Node> stack = new Stack<Node>();

		Node q = p;// q,is the latest Node that has been visited

		while (p != null) {

			while (p.getLeft() != null) {

				stack.push(p);

				p = p.getLeft();

			}

			/*
			 * 
			 * while(p!=null){//wrong.when 'while' ends,p=null
			 * 
			 * stack.push(p);
			 * 
			 * p=p.getLeft();
			 * 
			 * }
			 */

			while (p != null && (p.getRight() == null || p.getRight() == q)) {

				visit(p);

				q = p;

				if (stack.isEmpty())
					return;

				p = stack.pop();

			}

			stack.push(p);

			p = p.getRight();

		}

	}

	// level order

	public static void preOrder(Node p) {

		if (p == null) {
			return;
		}

		array2[count] = p.getData();
	
		//p.setBiaoji(array3[count]);
		//array4[count]=p.getBiaoji(count);
		count++;
		
		preOrder(p.getLeft());

		preOrder(p.getRight());

	}
	
	public static void cnOrder(Node root4) {

		if (root4 == null) {
			return;
		}
		
		array2[count] = root4.getData();
		count++;
		

		
	}
	
	
	public static void inOrder(Node root) {

		if (root == null) {
			return;
		}

		inOrder(root.getLeft());

		// System.out.print(root.getData()+" ");
		array2[count++] = root.getData();

		inOrder(root.getRight());

	}

	public static void postOrder(Node root1) {

		if (root1 == null) {
			return;
		}

		postOrder(root1.getLeft());
		postOrder(root1.getRight());
		array2[count++] = root1.getData();

	}

	
	
	private static class Node {

		private Node left;

		private Node right;

		private int data;


		Node(int array1) {

			data = array1;

			left = null;

			right = null;

		}

		public void setLeft(Node leftNode) {

			this.left = leftNode;

		}

		public void setRight(Node rightNode) {

			this.right = rightNode;

		}

		public Node getLeft() {

			return left;

		}

		public Node getRight() {

			return right;

		}

		public int getData() {

			return data;

		}


	}

	public static void setArray(int a1, int a2, int a3, int a4, int a5, int a6,
			int a7, int a8, int a9, int a10, int a11, int a12, int a13,
			int a14, int a15) {
		array1[0] = a1;
		array1[1] = a2;
		array1[2] = a3;
		array1[3] = a4;
		array1[4] = a5;
		array1[5] = a6;
		array1[6] = a7;
		array1[7] = a8;
		array1[8] = a9;
		array1[9] = a10;
		array1[10] = a11;
		array1[11] = a12;
		array1[12] = a13;
		array1[13] = a14;
		array1[14] = a15;
		 int array3[] = new int[15];
		System.arraycopy(array1, 0, array3, 0, 15);
         
	}
	

}
