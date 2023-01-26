package com.company;

public class Utility {

    // Looping through the chars to get specified substring
    // from particular start and end points
    public static String getExpression(String expression, int start, int end) {
        String requiredExpression = "";
        for (int i = start; i < end; i++) {
            char currentChar = expression.charAt(i);
            requiredExpression += currentChar;
        }
        return requiredExpression;
    }

    // to evaluate each sub expression
    public static String evaluateExpression(String subExpression) {
        int solution = 0;
        String[] expressionSets = subExpression.split(" "); // divide the string in 3 parts: i.e. add+1+2

        // for add sub-expression
        if(expressionSets[0].equals("add")){
            solution = Integer.parseInt(expressionSets[1]) + Integer.parseInt(expressionSets[2]);
        }
        // for multiply
        else if(expressionSets[0].equals("multiply")){
            solution = Integer.parseInt(expressionSets[1]) * Integer.parseInt(expressionSets[2]);
        }
        // for exponent
        else if(expressionSets[0].equals("exponent")){
            solution = (int)Math.pow(Integer.parseInt(expressionSets[1]), Integer.parseInt(expressionSets[2]));
        }
        else{
            solution = Integer.parseInt(subExpression);
        }

        return String.valueOf(solution);
    }

    // to get the total count of sub expressions
    public static int findNoOfExpressions(String completeExpression) {
        int count = 0;
        for (int i = 0; i < completeExpression.length(); i++) {
            char currentChar = completeExpression.charAt(i);
            // checking for closing parenthesis
            if(currentChar == ')'){
                count++;
            }
        }

        return count;
    }
}
