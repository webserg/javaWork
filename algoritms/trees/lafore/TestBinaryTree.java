package algoritms.trees.lafore;

import junit.framework.TestCase;

public class TestBinaryTree extends TestCase{
    BinaryTree tree;
    Node node1,node2,node3,node4,node5,node6,node7,node8;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        tree = new BinaryTree();
	tree.insert(node1 = new Node(50, 1.5)); // insert 3 nodes
	tree.insert(node2 = new Node(25, 1.7));
	tree.insert(node3 = new Node(75, 1.9));
	tree.insert(node4 = new Node(5, 1.8));

    }

    public void testToString() {
	StringBuilder s = new StringBuilder();
	s.append(node4).append(node2).append(node1).append(node3);
	System.out.println(s.toString().equals(tree.toString()));
	assertEquals(s.toString(),tree.toString());
    }
    
    public void testDeleteNodeWithOutChildren(){
	tree.delete(5);
	assertEquals("" +  node2 + node1 + node3,tree.toString());
	
    }
    
    public void testDeleteNodeWithTwoChildren(){
	tree.insert(node5 = new Node(35, 2.8));
	tree.insert(node6 = new Node(30, 2.4));
	tree.insert(node7 = new Node(40, 2.5));
	tree.insert(node8 = new Node(31, 2.6));
	System.out.println(tree);
	tree.delete(node2.idata);
	assertEquals(""+node4+node6+node8+node5+node7+node1+node3,tree.toString());
    }
    
    public void testGetParent(){
	tree.insert(node5 = new Node(35, 2.8));
	tree.insert(node6 = new Node(30, 2.4));
	tree.insert(node7 = new Node(40, 2.5));
	tree.insert(node8 = new Node(31, 2.6));
	Node parent = tree.getParent(null, node6);
	assertEquals(node5, parent);
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	BinaryTree tree = new BinaryTree();
	//tree.insert(50, 1.5); // insert 3 nodes
	//tree.insert(25, 1.7);
	//tree.insert(75, 1.9);
	BinaryTree.print(tree.getRoot());

    }

}
