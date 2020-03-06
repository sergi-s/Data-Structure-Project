/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import javafx.util.Pair;

/**
 *
 * @author sergi
 */
public class Linked {

    private Node Head = null;
    public int size = 0;

    private Node CreatNode(int data, int pr) {
        Node node = new Node();
        node.data = data;
        node.pr = pr;
        node.next = node.prev = null;
        return node;
    }

    public void AddSorted(Pair<Integer, Integer> in) {
        Node node = CreatNode(in.getKey(), in.getValue());

        if (node != null) {
            if (Head == null) {
                Head = node;
                Head.prev = Head.next = node;
            } else {

                if (Head.pr > in.getValue()) {
                    node.next = Head;
                    node.prev = Head.prev;
                    Head.prev.next = node;
                    Head.prev = node;
                    Head = node;
                } else if (Head.pr == in.getValue()) {
                    node.next = Head.next;
                    node.prev = Head;
                    Head.next.prev = Head.next = node;
                } else if (Head.prev.pr < in.getValue()) {
                    node.next = Head;
                    node.prev = Head.prev;
                    Head.prev = Head.prev.next = node;

                } else {
                    Node temp = Head.next;
                    for (; temp.next != Head; temp = temp.next) {
                        if (in.getValue() < temp.pr) {
                            break;
                        }
                    }
                    node.next = temp;
                    node.prev = temp.prev;
                    temp.prev.next = temp.prev = node;
                }
            }
            size++;
        }
    }

    public Pair<Integer, Integer> popBack() {
        if (Head != null) {
            Pair<Integer, Integer> ret = new Pair<Integer, Integer>(Head.prev.data, Head.prev.pr);
            if (Head == Head.prev) {
                Head = Head.prev = null;
            } else {
                Head.prev = Head.prev.prev;
                Head.prev.next = Head;
            }
            size--;
            return ret;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public void printLinked() {
        System.out.println("Print Linked");
        Node temp = Head;
        if (Head == null) {
            System.out.println("Empty");
        } else {
            System.out.println("{ " + temp.data + " " + temp.pr + "} ");
            temp = temp.next;
            for (; temp != Head && temp != null; temp = temp.next) {
                System.out.println("{ " + temp.data + " " + temp.pr + "} ");
            }
            System.out.println();
        }
        System.out.println("End Print Linked");
    }

    public boolean IsEmpty() {
        return (Head == null) ? true : false;
    }
}
