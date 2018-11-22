/*
    Kenia Rioja-Naranjo
    CSC 471 Project 2
 */

import javafx.util.Pair;

public class Grammar {
    // G = (V, T, S, P)
    private ArrayList<String> Variables;
    private ArrayList<String> Terminals;
    private String S; //Start Symbol
    private ArrayList<Pair<String, ArrayList<String>>> Productions;

    public Grammar() {

    }


    public ArrayList<String> getVariables() {
        return Variables;
    }

    public void setVariables(ArrayList<String> variables) {
        Variables = variables;
    }

    public ArrayList<String> getTerminals() {
        return Terminals;
    }

    public void setTerminals(ArrayList<String> terminals) {
        Terminals = terminals;
    }

    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public ArrayList<Pair<String, ArrayList<String>>> getProductions() {
        return Productions;
    }

    public void setProductions(ArrayList<Pair<String, ArrayList<String>>> productions) {
        Productions = productions;
    }
}
