/*
    Kenia Rioja-Naranjo
    CSC 471 Project 2
 */

import javafx.util.Pair;

public class Driver {
    public static void testCase1() {
        ArrayList<String> v = new ArrayList<>();
        v.add("A");
        v.add("B");
        v.add("C");
        v.add("D");
        v.add("S");

        ArrayList<String> t = new ArrayList<>();
        t.add("a");
        t.add("c");
        t.add("d");
        t.add("L"); //lambda

        ArrayList<Pair<String, ArrayList<String>>> p = new ArrayList<>();
        ArrayList<String> Stransitions = new ArrayList<>();
        Stransitions.add("a");
        Stransitions.add("aA");
        Stransitions.add("B");
        Stransitions.add("C");
        p.add(new Pair<>("S", Stransitions));
        



        Grammar grammar = new Grammar(v, t, "S", p);

    }
    public static void main(String[] args) {

    }
}
