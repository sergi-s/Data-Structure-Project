package dsproject;

import javafx.util.Pair;

/**
 * @author sergi
 */
public class MainClass {

    public static void main(String[] args) {
        //Main
        Queue Q1 = new Queue();
        Queue Q2 = new Queue();
        Queue Q3 = new Queue();
        Stack S2 = new Stack();
        Linked L2 = new Linked();
        int printed = 0;
        int Stage = 0, Pr = 0;
        for (int i = 0; printed <= 100;) {
            Stage = ran(4);
            switch (Stage) {
                case 1:
                    if (i <= 100) {
                        Pr = ran(5);
                        Q1.pushBack(new Pair<Integer, Integer>(i, Pr));
                        i++;
                    }
                    break;
                case 2:
                    if (!Q1.IsEmpty()) {
                        if (S2.getSize() == min(S2.getSize(), Q2.getSize(), L2.getSize())) {
                            S2.pushBack(Q1.popFront());
                        } else if (Q2.getSize() == min(S2.getSize(), Q2.getSize(), L2.getSize())) {
                            Q2.pushBack(Q1.popFront());
                        } else if (L2.getSize() == min(S2.getSize(), Q2.getSize(), L2.getSize())) {
                            L2.AddSorted(Q1.popFront());
                        } else {
                            switch (ran(3)) {
                                case 1:
                                    S2.pushBack(Q1.popFront());
                                    break;
                                case 2:
                                    Q2.pushBack(Q1.popFront());
                                    break;
                                case 3:
                                    L2.AddSorted(Q1.popFront());
                                    break;
                            }
                        }
                    }
                    break;
                case 3:
                    if (!S2.IsEmpty() || !Q2.IsEmpty() || !L2.IsEmpty()) {
                        if (S2.getSize() == max(S2.getSize(), Q2.getSize(), L2.getSize())) {
                            Q3.pushBack(S2.popBack());
                        } else if (Q2.getSize() == max(S2.getSize(), Q2.getSize(), L2.getSize())) {
                            Q3.pushBack(Q2.popFront());
                        } else if (L2.getSize() == max(S2.getSize(), Q2.getSize(), L2.getSize())) {
                            Q3.pushBack(L2.popBack());
                        } else {
                            switch (ran(3)) {
                                case 1:
                                    if (!S2.IsEmpty()) {
                                        Q3.pushBack(S2.popBack());
                                    }
                                    break;
                                case 2:
                                    if (!Q2.IsEmpty()) {
                                        Q3.pushBack(Q2.popFront());
                                    }
                                    break;
                                case 3:
                                    if (!L2.IsEmpty()) {
                                        Q3.pushBack(L2.popBack());
                                    }
                                    break;
                            }
                        }
                    }
                    break;
                case 4:
                    if (!Q3.IsEmpty()) {
                        printed++;
                        Pair print = Q3.popFront();
                        System.out.println(print.getKey() + "     " + print.getValue());
                    }
                    break;
            }
        }
        System.out.println("Q1\t" + Q1.IsEmpty() + "\nQ2\t" + Q3.IsEmpty() + "\nQ3\t" + Q3.IsEmpty() + "\nS2\t" + S2.IsEmpty() + "\nL2\t" + L2.IsEmpty());
    }

    static int ran(int a) {
        return (int) (Math.random() * a) + 1;
    }

    static int max(int... x) {
        int max = -1;
        for (int i = 0; i < x.length; i++) {
            max = Math.max(max, x[i]);
        }
        return max;
    }

    static int min(int... x) {
        int min = 101;
        for (int i = 0; i < x.length; i++) {
            min = Math.max(min, x[i]);
        }
        return min;
    }
}
