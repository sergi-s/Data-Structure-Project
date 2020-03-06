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
public class Stack {

    private Node Top = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    private Node CreatNode(int data, int pr) {
        Node node = new Node();
        node.data = data;
        node.pr = pr;
        node.next = node.prev = null;
        return node;
    }

    public void pushBack(Pair<Integer, Integer> in) {
        Node node = CreatNode(in.getKey(), in.getValue());
        if (Top == null) {
            Top = node;
        } else {
            node.prev = Top;
            Top = node;
        }
        size++;
    }

    public Pair<Integer, Integer> popBack() {
        if (Top == null) {
            return null;
        } else {
            Pair<Integer, Integer> ret = new Pair<Integer, Integer>((Integer) Top.data, Top.pr);
            Top = Top.prev;
            size--;
            return ret;
        }
    }

    public boolean IsEmpty() {
        return (Top == null) ? true : false;
    }

    public void printLinked() {
        System.out.println("Print stack");
        Node temp = Top;
        if (Top == null) {
            System.out.println("Empty");
        } else {
            System.out.println("{" + temp.data + "," + temp.pr + "}");
            temp = temp.prev;
            for (; temp != Top && temp != null; temp = temp.prev) {
                System.out.println("{" + temp.data + "," + temp.pr + "} ");
            }
            System.out.println();
        }
        System.out.println("End Print stack");
    }
}
