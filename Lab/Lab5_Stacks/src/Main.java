/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * October 20, 2014
 * Description:
 */

public class Main
{
    public static void main(String[] args)
    {
        // Create a string that holds the expression.
        String expression = "100+80/2*25/5";

        // Instantiate an object of the ExpressionEvaluator class.
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

        // Print out the expression and its result.
        System.out.println(expression + " = "
                + expressionEvaluator.evaluate(expression));
    }
}