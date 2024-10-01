package algoLessonA59BinaryIntro;

/*
							BINARY TREES IN JAVA: INTRODUCTION
 */

public class Binariez {

	private class BinaryTree {
		private Node root;

		public BinaryTree() {
			this.root = null;
		}

		private class Node {
			private int data;
			private Node left;
			private Node right;

			public Node(int dataIn) {
				this.data = dataIn;
				this.left = null;
				this.right = null;
			}
		}

		public void createBinaryTree() {
			Node a = new Node(1);
			Node b = new Node(2);
			Node c = new Node(3);
			Node d = new Node(4);
			Node e = new Node(5);
			Node f = new Node(6);
			Node g = new Node(7);

			root = a;

			a.left = b;
			a.right = c;

			b.left = d;
			b.right = e;

			c.left = f;
			c.right = g;
		}
	}


	public static void main(String[] args) {


	}

}
