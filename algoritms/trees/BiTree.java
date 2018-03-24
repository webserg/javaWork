package algoritms.trees;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by webserg on 22.05.2014.
 */
public class BiTree {

    Node root;

    public BiTree(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {
        final BiTree tree = new BiTree(new Node(null, null, null, 10, 10));
        treeInsert(tree, new Node(5));
        treeInsert(tree, new Node(6));
        treeInsert(tree, new Node(7));
        inOrderTreeWalk(tree.root);
        System.out.println("++++++++++++");
        inOrderTreeWalkHeap(tree.root);
        System.out.println("++++++++++++");
        preOrderTreeWalkHeap(tree.root);
        Node n = treeSearch(tree.root, 7);
        printNode(n);
        n = iterativeTreeSearch(tree.root, 7);
        printNode(n);
        Assert.assertEquals(7, n.key);
        Assert.assertEquals(5, treeMin(tree.root).key);

        BiTree tree2 = new BiTree(new Node(null, null, null, 20, 20));
        treeInsert(tree2, new Node(10));
        treeInsert(tree2, new Node(30));
        treeInsert(tree2, new Node(40));
        treeInsert(tree2, new Node(38));
        treeInsert(tree2, new Node(37));
        treeInsert(tree2, new Node(39));
        treeInsert(tree2, new Node(50));
        treeInsert(tree2, new Node(48));
        treeInsert(tree2, new Node(60));

        treeDelete(tree2, treeSearch(tree2.root, 40));
        Assert.assertNull(treeSearch(tree2.root, 40));
        inOrderTreeWalk(tree2.root);


    }

    private static void printNode(Node n) {
        if (n != null)
            System.out.println(n);
        else System.out.println("null");
    }

    public static void treeInsert(BiTree tree, Node z) {
        if (tree.root == null) {
            tree.root = z;
            return;
        }
        Node x = tree.root;
        Node y = null;
        while (x != null) {
            y = x;
            if (z.key < y.key) {
                x = y.left;
            } else {
                x = y.right;
            }
        }
        if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.p = y;
    }

    public static Node treeMin(final Node node) {
        Node x = node;
        while (x != null) {
            if (x.left != null) {
                x = x.left;
            }
            return x;
        }
        return null;
    }

    public static void transplant(BiTree tree, Node u, Node v) {
        if (u.p == null) {
            tree.root = v;
        }
        if (u == u.p.left) {
            u.p.left = v;
        } else {
            u.p.right = v;
        }
        if (v != null) v.p = u.p;
    }

    public static void treeDelete(BiTree tree, Node z) {
        if (z.left == null) {
            transplant(tree, z, z.right);
        } else if (z.right == null) {
            transplant(tree, z, z.left);
        } else {
            Node y = treeMin(z.right);
            if (y.p != z) {
                transplant(tree, y, null);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(tree, z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }

    public static void inOrderTreeWalk(Node x) {
        if (x != null) {
            inOrderTreeWalk(x.left);
            System.out.println(x.value);
            inOrderTreeWalk(x.right);
        }
    }

    public static void preOrderTreeWalkHeap(Node x) {
        Queue<Node> queue = new LinkedList<>();
        while (x != null) {
            queue.offer(x);
            x = x.left;
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.key);
            Node rightCur = cur.right;
            while (rightCur != null) {
                queue.offer(rightCur);
                rightCur = rightCur.left;
            }
        }
    }

    public static void inOrderTreeWalkHeap(Node x) {
        Deque<Node> queue = new LinkedList<>();
        while (x != null) {
            queue.addFirst(x);
            x = x.left;
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.key);
            Node rightCur = cur.right;
            while (rightCur != null) {
                queue.addFirst(rightCur);
                rightCur = rightCur.left;
            }
        }
    }

    public static Node treeSearch(Node x, int v) {
        if (x == null || x.key == v) {
            return x;
        } else if (v < x.key) {
            return treeSearch(x.left, v);
        } else {
            return treeSearch(x.right, v);
        }
    }

    public static Node iterativeTreeSearch(Node x, int v) {
        while (x != null && x.key != v) {
            if (v < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }


    static class Node {
        Node left;
        Node right;
        Node p;
        int key;
        int value;

        Node(int key) {
            this.left = null;
            this.right = null;
            this.p = null;
            this.key = key;
            this.value = key;
        }

        Node(Node left, Node right, Node p, int key, int value) {
            this.left = left;
            this.right = right;
            this.p = p;
            this.key = key;
            this.value = value;
        }

//        Node(Node left, Node right, int key, int value) {
//            this.left = left;
//            this.right = right;
//            this.key = key;
//            this.value = value;
//        }


        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }
}
