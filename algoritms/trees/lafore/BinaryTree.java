package algoritms.trees.lafore;


/**
 * Let x is a node of binary tree, if y is a node of the left subtree of x, then
 * key[y] < key[x], if y is a node of the right subtree of x then key[y] >  key[x]
 * efficiency O(logN)
 */
public class BinaryTree {
    private Node root;

    static public Node getMax(Node r) {
        Node x = r;
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    static public Node getMin(Node r) {
        Node x = r;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * return array[successor, parentSuccessor]
     */
    static public Node[] getSuccessor(Node delNode) {
        Node parentSuccessor = delNode;
        Node successor = delNode;
        Node x = delNode.right;
        while (x != null) {
            parentSuccessor = successor;
            successor = x;
            x = x.left;
        }
        System.out.println(parentSuccessor);
        return new Node[]{successor, parentSuccessor};
    }

    static public void print(Node r) {
        if (r == null)
            return;
        print(r.left);
        System.out.println(r);
        print(r.right);
    }

    public Node find(int key) {
        Node x = root;

        while (x != null && key != x.idata) {
            if (key < x.idata) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    /*
     * working as find method but while you finding node if you encounter
     * null you know the node you are looking for doesn't existn so you
     * return immediatly. When you are trying to insert node you insert it
     * before returning
     */
    public void insert(Node node) {
        int key = node.idata;
        if (root == null) {
            root = node;
            return;
        }
        Node cur = root;
        Node parent;
        while (true) {
            parent = cur;
            if (key < cur.idata) {
                cur = cur.left;
                if (cur == null) {
                    parent.left = node;
                    return;
                }
            } else {
                cur = cur.right;
                if (cur == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    /*
     * the most defficult operation has three ways
     * 1. when hode hasn't children(just remove)
     * 2. when node has only one children(replace current his children)
     * 3. when node has two children
     *
     */
    public boolean delete(int key) {
        Node parent = root;
        Node cur = root;
        boolean isLeftChild = true;
        // find
        while (key != cur.idata) {
            parent = cur;
            if (key < cur.idata) {
                isLeftChild = true;
                cur = cur.left;
            } else {
                isLeftChild = false;
                cur = cur.right;
            }
            if (cur == null)
                return false;

        }
        // if node hasn't children
        if (cur.left == null && cur.right == null) {
            if (cur == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (cur.left != null && cur.right == null) {// has one//
            // children
            if (cur == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else if (cur.right != null && cur.left == null) {
            if (isLeftChild) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else {// has two children
            //successor is the smallest of the set of nodes
            //that are larger then the original(cur) nodes

            Node[] tmpNodes = getSuccessor(cur);//get succesor and his parent
            Node successor = tmpNodes[0];
            Node parentSuccessor = tmpNodes[1];
            if (cur == root)
                root = successor;
            if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = cur.left;//successor can't have left children

            //This isn't much of the problem when successor is right children of cur
            //When we move successor it's right subtree simply follows along with it
            //but when successor is the left descendant of the right children of cur,
            //two steps are required to perform the deletion
            //1. successorParent.leftChild = successor.rightChild;
            //2. successor.rightChild = delNode.rightChild;

            if (successor != cur.right) {
                parentSuccessor.left = successor.right;
                successor.right = cur.right;
            }
        }

        return true;
    }

    /**
     * search parent of n, if you know from search must start set from
     * if no, set null
     */
    public Node getParent(Node from, Node n) {
        if (from == null)
            from = root;
        Node parent = from;
        while (from != null && n.idata != from.idata) {
            parent = from;
            if (n.idata < from.idata)
                from = from.left;
            else
                from = from.right;
        }

        return parent;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        printToString(root, s);
        return s.toString();
    }

    private void printToString(Node r, StringBuilder s) {
        if (r == null)
            return;
        printToString(r.left, s);
        s.append(r);
        printToString(r.right, s);
    }

    public Node getRoot() {
        return root;
    }

}
