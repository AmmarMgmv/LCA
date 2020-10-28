//The code below was found online at Geeksforgeeks.org
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node{
	int data;
	Node left, right;
	
	Node(int data){
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {
	Node root;
	static boolean node1 = false, node2 = false;
	
	Node checkNodes(Node node, int n1, int n2) {
		if(node == null)
			return null;
		
		Node temp = null;
		
		if(node.data == n1) {
			node1 = true;
			temp = node;
		}
		if(node.data == n2) {
			node2 = true;
			temp = node;
		}
		
		Node left_lca = checkNodes(node.left, n1, n2);
		Node right_lca = checkNodes(node.right, n1, n2);
		
		if(temp !=null)
			return temp;
		
		if (left_lca != null && right_lca != null) 
            return node;
		
		return (left_lca != null) ? left_lca : right_lca; 	
	}
	
	Node findLCA(int n1, int n2) 
    { 
        node1 = false; 
        node2 = false; 
        Node lca = checkNodes(root, n1, n2); 
  
        if (node1 && node2) 
            return lca; 
  
        return null; 
    } 
	
	public static void main(String args[]) 
    { 
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        
        //VERSION 1
        // Scanner input = new Scanner(System.in);
        
        // System.out.println("Please enter a number between 1-10");
        // int firstNode = input.nextInt();
        // System.out.println("Please enter another number between 1-10");
        // int secondNode = input.nextInt();
        // input.close();
      
        // Node lca = tree.findLCA(firstNode, secondNode); 
        // if (lca != null) 
        //     System.out.println("LCA(" + firstNode + "," + secondNode + ") = " + lca.data); 
        // else
        //     System.out.println("Keys are not present"); 
    } 
}
