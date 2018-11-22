/*
    Kenia Rioja-Naranjo
    CSC 471 Project 2
 */

import javafx.util.Pair;

import java.lang.reflect.Array;

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

    /*
    Theorem 6.5
    1. Remove L-productions
    2. Remove unit-productions
    3. Remove useless productions
     */

    public void removeLproductions() {
        for (int i = 0; i < this.productions.getSize(); i++) {
            if (containsL(this.productions.get(i))) {
                String keyContainsLambda = this.productions.get(i).getKey();
                int lambdaIndex = this.productions.get(i).getValue().indexOf("L");
                System.out.println(lambdaIndex);
                this.productions.get(i).getValue().remove(lambdaIndex);

                for (int j = 0; j < this.productions.getSize(); j++) {
                    Pair currenPair = this.productions.get(j);
                    
                }
            }
        }
    }

    private boolean containsL(Pair<String, ArrayList<String>> pair) {
        for (int i = 0; i < pair.getValue().getSize(); i++) {
            if (pair.getValue().get(i) == "L")
                return true;
        }

        return false;
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