
package dsproject;

import javafx.util.Pair;

/**
 *
 * @author sergi
 */
public class Queue {

    private Node Head = null;
    private Node Tail = null;
    private int size = 0;

    private Node CreatNode(int data, int pr) {
        Node node = new Node();
        node.data = data;
        node.pr = pr;
        node.next = node.prev = null;
        return node;
    }

    public void pushBack(Pair<Integer, Integer> in) {
        Node node = CreatNode(in.getKey(), in.getValue());
        if (Head == null) {
            Head = Tail = node;
           
        } else {
            Tail.next = node;
            Tail = node;
            
        }
        size++;
    }

    public Pair<Integer, Integer> popFront() {
        Pair<Integer, Integer> ret;
        if (Head != null) {
            size--;
            ret = new Pair<Integer, Integer>(Head.data, Head.pr);
            if (Head == Tail) {
                Tail = null;
            } 
                Head = Head.next;
            
            return ret;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean IsEmpty() {
        return (Head == null);
    }

    public void printLinked() {
        System.out.println("Print Queue");
        Node temp = Head;
        if (Head == null) {
            System.out.println("Empty");
        } else {
            System.out.print("{" + temp.data + "," + temp.pr + "} ");
            temp = temp.next;
            for (; temp != Head && temp != null; temp = temp.next) {
                System.out.print("{" + temp.data + "," + temp.pr + "} ");
            }
            System.out.println();
        }
        System.out.println("End Print Queue");
    }
}
