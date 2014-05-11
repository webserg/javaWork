package collections.lists;

/**
 * Created by webserg on 11.05.2014.
 *
 *
 * klkl
 *
 */
public class SinglyLinkedList<K> {
    private Node<K> head;
    private Node<K> tail;

    public SinglyLinkedList() {
        head = tail = null;
    }

    public void insert(K k) {
        Node<K> node = new Node<>(k);
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            tail.link = node;
            tail = node;
        }

    }

    public void search(K k) {

    }

    public void delete(K k) {

    }

    public String toString() {
        Node<K> n = head;
        StringBuffer s = new StringBuffer();
        while (n != null) {
            s.append(n.toString());
            n = n.link;
        }
        return s.toString();
    }

}

class Node<K> {
    K k;
    Node<K> link;

    Node(K k, Node<K> link) {
        this.k = k;
        this.link = link;
    }

    Node(K k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return k + " ";
    }
}
