/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * October 20, 2014
 * Description:
 */

public class ExpressionEvaluator
{
    // Character stack for operators.
    private StackInterface<Character> operators = new VectorStack<Character>();

    // Integer stack for operands (numbers).
    private StackInterface<Integer> operands = new VectorStack<Integer>();

    // Default constructor.
    public ExpressionEvaluator()
    {
    }


    public int evaluate(String expression)
    {
        // char variable for holding the
        // next character in the expression.
        char nextCharacter;

        // boolean variable for checking whether
        // the previous character was a number.
        // This is used to concatenate multiple
        // digit numbers.
        boolean isPreviousCharANumber = false;

        // for loop for processing each character
        // in the expression.
        for (int i = 0; i < expression.length(); i++)
        {
            // Extracting a character from the string expression.
            nextCharacter = expression.charAt(i);

            switch (nextCharacter)
            {
                // If nextCharacter is an empty space
                // just ignore it and do nothing.
                case ' ':
                    break;

                // Operator cases
                case '+':
                case '-':
                case '/':
                case '*':
                    if(!operators.isEmpty() && !hasPrecedence(nextCharacter, operators.peek()))
                        solve(nextCharacter, operands.pop(), operands.pop());



                    operators.push(nextCharacter);

                    // Set the boolean variable to false
                    // because we are in the operators cases.
                    isPreviousCharANumber = false;
                    break;

                // Operand case
                default:
                    // If the previous character was a number
                    // pop it and concatenate it with the current
                    // character. This makes the program work
                    // with multiple digit numbers.
                    if(isPreviousCharANumber)
                    {
                        String number = operands.pop().toString() + nextCharacter;

                        // Convert the string to an integer and
                        // push it to the operands stack.
                        operands.push(Integer.parseInt(number));
                    }
                    else
                        operands.push(Character.getNumericValue(nextCharacter));

                    // Set the boolean variable to true
                    // because we are in the numbers case.
                    isPreviousCharANumber = true;
                    break;
            }

            System.out.println("Operator: " + operators.peek());
            System.out.println("Operands: " + operands.peek() + "\n");
        }

        while(!operators.isEmpty())
        {
            System.out.println("Operator in while: " + operators.peek());
            System.out.println("Operands in while: " + operands.peek() + "\n");
            solve(operators.pop(), operands.pop(), operands.pop());

            System.out.println("Still in while");
        }

        //solve(operators.pop(), operands.pop(), operands.pop());

        System.out.println("Almost out");

        return operands.pop();
    }

    public boolean hasPrecedence(char operatorA, char operatorB)
    {
        int precedenceOfA = getPrecedence(operatorA);
        int precedenceOfB = getPrecedence(operatorB);

        if (precedenceOfA < precedenceOfB)
            return true;
        else if (precedenceOfA == precedenceOfB)
        {
            solve(operators.pop(), operands.pop(), operands.pop());
            return true;
        }
        else
            return false;
    }

    public int getPrecedence(char operator)
    {
        switch(operator)
        {
            case ')':
                return 1;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 3;
            case '(':
                return 4;
        }

        return 0;
    }

    public void solve(char operator, int b, int a)
    {
        System.out.println("A: " + a);
        System.out.println("Operator: " + operator);
        System.out.println("B: " + b);


        // int variable to hold the result
        // of the operation.
        int result = 0;

        // switch for deciding what operation
        // must be performed.
        switch(operator)
        {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '/':
                // Error checking for division by zero.
                if(b == 0)
                {
                    System.out.println("ERROR: Cannot divide by zero!");
                    b = 1;
                }
                result = a / b;
                break;
            case '*':
                result = a * b;
                break;
            default:
                System.out.println("ERROR: Not a valid operator!");
        }

        System.out.println("Yes");
        // Pushing the result to the operands stack.
        operands.push(result);
    }
}