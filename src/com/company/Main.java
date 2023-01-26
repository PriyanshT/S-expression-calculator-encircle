package com.company;

public class Main {
    public static void main(String[] args) {
        String firstExpression = "", subExpression = "", thirdExpression = "";

        try {
            // storing total sub expressions
            int count = Utility.findNoOfExpressions(args[0]);

            // looping till each parenthesis is evaluated
            while (count != 0) {
                int closeIndex = 0, flag = 1;
                // getting the index of first closing )
                while (flag != 0) {
                    char currentChar = args[0].charAt(closeIndex);
                    if (currentChar != ')') {
                        closeIndex++;
                    } else {
                        flag = 0;
                    }
                }

                // getting the index of corresponding (
                int openIndex = closeIndex;

                for (int i = closeIndex; i > 0; i--) {
                    char currentChar = args[0].charAt(i);
                    if (currentChar != '(') {
                        openIndex--;
                    } else {
                        break;
                    }
                }

                // dividing the expressions to evaluate top-down based on different start-end
                firstExpression = Utility.getExpression(args[0], 0, openIndex);
                subExpression = Utility.getExpression(args[0], openIndex + 1, closeIndex);
                thirdExpression = Utility.getExpression(args[0], closeIndex + 1, args[0].length());

                // updating the string based on the evaluated inner part
                args[0] = firstExpression + Utility.evaluateExpression(subExpression) + thirdExpression;

                count--;
            }

            System.out.println("Final Answer: " + args[0]);
        }
        catch (Exception e){
            System.out.println("Exception in user input: " + e);
            System.out.println("Try changing input expression or check brackets ().");
        }
    }
}
