package algoritms.collections;

/**
 * Created by sergiy.doroshenko
 * Date: 5/19/11
 */
public class MyLinkedList<K> {

    Node top;
    Node tail;

    void addNode(K data) {
        Node<K> node = new Node<>(data);
        if (top == null) {
            top = node;
            tail = node;
            return;
        }
        if (top.next == null) {
            top.next = node;
            tail = node;
        }

        tail.next = node;
        tail = node;
    }

    void print() {
        StringBuffer str = new StringBuffer("{");
        Node n = top;
        while (n != null) {
            str.append("[");
            str.append(n.data);
            str.append("]");
            n = n.next;
        }
        str.append("}");
        System.out.println(str);
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addNode("one");
        myLinkedList.addNode("two");
        myLinkedList.addNode("three");
        myLinkedList.addNode("four");
        myLinkedList.addNode("five");

        myLinkedList.print();
    }
}


class Node<K> {
    K data;
    Node next;

    Node(K data) {
        this.data = data;
    }

    Node(K data, Node next) {
        this.data = data;
        this.next = next;
    }
}