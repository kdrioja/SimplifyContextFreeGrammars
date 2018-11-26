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

    /*
    Theorem 6.5
    1. Remove L-productions
    2. Remove unit-productions
    3. Remove useless productions
     */

    public void removeLambdaProductions() {
        System.out.println("Removing lambda productions...");
        for (int i = 0; i < this.productions.getSize(); i++) {
            if (containsL(this.productions.get(i))) {
                String keyContainsLambda = this.productions.get(i).getKey();
                int lambdaIndex = this.productions.get(i).getValue().indexOf("L");
                //System.out.println(lambdaIndex);
                this.productions.get(i).getValue().remove(lambdaIndex);

                for (int j = 0; j < this.productions.getSize(); j++) {
                    ArrayList<String> transitions = this.productions.get(j).getValue();

                    for (int k = 0; k < transitions.getSize(); k++) {
                        if (transitions.get(k).contains(keyContainsLambda)) {
                            //System.out.println(transitions.get(k));
                            StringBuilder newTransition = new StringBuilder();
                            char[] temp = transitions.get(k).toCharArray();

                            for (int c = 0; c < transitions.get(k).length(); c++) {
                                if (temp[c] != keyContainsLambda.charAt(0)) {
                                    newTransition.append(temp[c]);
                                }
                            }

                            if (this.productions.get(j).getValue().indexOf(newTransition.toString()) == -1) {
                                this.productions.get(j).getValue().add(newTransition.toString());
                            }
                        }
                    }
                }
            }
        }
    }

    public void removeUnitProductions() {
        System.out.println("Removing unit productions...");
        for (int i = 0; i < this.productions.getSize(); i++) {
            for (int j = 0; j < this.productions.get(i).getValue().getSize(); j++) {
                if (this.productions.get(i).getValue().get(j).length() == 1) {
                    if (isUnitProduction(this.productions.get(i).getValue().get(j))) {
                        ArrayList<String> tempProductions = getUnitsProductions(this.productions.get(i).getValue().get(j));

                        for (int p = 0; p < tempProductions.getSize(); p++) {
                            addProduction(this.productions.get(i).getValue(), tempProductions.get(p));
                        }
                        this.productions.get(i).getValue().remove(j);
                        j--;
                    }
                }
            }
        }
    }

    public void removeUselessProductions() {
        /*
        A variable is useless either because it cannot be reached
        or it does not produce a terminal string
         */
        System.out.println("Removing useless productions...");

    }

    private void addProduction(ArrayList<String> productions, String newP) {
        boolean flag = false;

        for (int i = 0; i < productions.getSize(); i++) {
            if (productions.get(i).equals(newP)) {
                flag = true;
            }
        }

        if (!flag) {
            productions.add(newP);
        }
    }

    private ArrayList<String> getUnitsProductions(String V) {
        for (int i = 0; i < this.productions.getSize(); i++) {
            if (this.productions.get(i).getKey() == V) {
                return this.productions.get(i).getValue();
            }
        }
        return null;
    }

    private boolean isUnitProduction(String production) {
        for (int i = 0; i < this.variables.getSize(); i++) {
            if (production.equals(this.variables.get(i)))
                return true;
        }
        return false;
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