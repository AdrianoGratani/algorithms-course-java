/*
			INTRODUCTION TO BINARY SEARCH TREE IN JAVA

	a binary search tree is a way to better organize data in a binary tree;
	a binary search tree follows these simple rules:
		- left subtree of a parent can only store data (integer) which is SMALLER than the parent data;
		- right subtree of a parent can only store data (integer) which is GREATER than the parent data;
		- in their turn, both left and right subtrees must be binary search tree as well; 

	this is correct:

		10
	4	|	20

    2      5    |    15     40


	while this is wrong:     25 is bigger than 10 BUT is bigger than the root data;  18 is smaller than the parent BUT is smaller than the root data;

		20
	10	|	40
   5        25	|   18      50    




	- depending on what you're looking for, you'll discard half of the binary tree according to it. This'll make easier and faster to search data. 


	- the basic structure of a BinarySearch Tree is the same as the common Binary Tree:

		- there is a root node; so you need a Node class with its constructor
		- there are left and right subtree nodes;   by default, they both point to null, so no need to mention them in the Node constructor;
		- a private variable is required to store data (for the sake of this example, data is integer data type);
		- the CONSTRUCTOR has to initialize the Node.data only, with the input you give (i.e. Node a = new Node(68);  ==   (constructor)  this.data = dataInput;

	public class BinarySearchTreeNode {
		private int data;
		private Node left;
		private Node right;

		public BinarySearchTreeNode(int dataIn) {
			this.data = dataIn;
		}
	}
    
*/


package algoLessonA66BinarySearchTreeIntro;

public class introduction {

}
