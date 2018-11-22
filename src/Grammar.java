/*
    Kenia Rioja-Naranjo
    CSC 471 Project 2
 */

import javafx.util.Pair;

public class Grammar {
    // G = (V, T, S, P)
    private ArrayList<String> variables;
    private ArrayList<String> terminals;
    private String start; //Start Symbol
    private ArrayList<Pair<String, ArrayList<String>>> productions;

    public Grammar(ArrayList<String> v, ArrayList<String> t, String s, ArrayList<Pair<String, ArrayList<String>>> p) {
        this.variables = v;
        this.terminals = t;
        this.start = s;
        this.productions = p;
    }

    public ArrayList<String> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }

    public ArrayList<String> getTerminals() {
        return terminals;
    }

    public void setTerminals(ArrayList<String> terminals) {
        this.terminals = terminals;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public ArrayList<Pair<String, ArrayList<String>>> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Pair<String, ArrayList<String>>> productions) {
        this.productions = productions;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        if (this.productions.getSize() == 0) {
            result.append("No productions.");
        }
        else {
            for (int i = 0; i < this.productions.getSize(); i++) {
                result.append(this.productions.get(i).getKey());
                result.append(" -> ");
                result.append(this.productions.get(i).getValue());
                result.append("\n");
            }
        }

        return result.toString();
    }
}
