package algoritms.trees.lafore;

public class Node {
    Node left;
    Node right;
    Node p;
    int idata;
    double fdata;

    public Node(int idata, double fdata) {
        super();
        this.idata = idata;
        this.fdata = fdata;
    }

    @Override
    public String toString() {
        return idata + " " + fdata + "; ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Node) {
            Node node = (Node) obj;
            return (node.idata == this.idata && node.fdata == this.fdata) ? true : false;

        }
        return false;
    }
}
