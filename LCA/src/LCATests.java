import static org.junit.Assert.*;

import org.junit.Test;

class LCATests {
	
	BinaryTree tree = new BinaryTree();

	@Test
	public void testTree() {
		createTree();

		assertEquals("LCA = 2",2 ,tree.findLCA(4,5));
		assertEquals("LCA = 1",1 ,tree.findLCA(6,2));
		assertEquals("LCA = 1",1 ,tree.findLCA(1, 5));
		assertEquals("LCA = 1",1 ,tree.findLCA(1, 1));
		assertEquals("LCA = 1",1 ,tree.findLCA(2, 3));
		assertEquals("LCA = 3",3 ,tree.findLCA(6, 7));
		assertEquals("LCA = None",null ,tree.findLCA(12, 12));
	}
	
	public void createTree(){
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
	}

}
