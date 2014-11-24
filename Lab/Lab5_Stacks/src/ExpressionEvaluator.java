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
            // Extracting the current character
            // from the string expression.
            nextCharacter = expression.charAt(i);

            switch (nextCharacter)
            {
                // Operator cases
                case '+':
                case '-':
                case '/':
                case '*':
                    // If the operators stack is not empty and the current operator
                    // has no precedence over the previous operator, pop the
                    // operands from the operands stack and solve the operation.
                    if(!operators.isEmpty() && !hasPrecedence(nextCharacter, operators.peek()))
                        solve(nextCharacter, operands.pop(), operands.pop());

                    // Push the operator to the
                    // operators stack.
                    operators.push(nextCharacter);

                    // Set the boolean variable to false
                    // because we are in the operators cases.
                    isPreviousCharANumber = false;
                    break;

                // Operand case
                default:
                    // If the previous character was a number
                    // pop it and concatenate it with the current
                    // number. This makes the program work
                    // with multiple digit numbers.
                    if(isPreviousCharANumber)
                    {
                        // Pop the previous number and concatenate it
                        // with the current number.
                        String number = operands.pop().toString() + nextCharacter;

                        // Convert the string to an integer and
                        // push it to the operands stack.
                        operands.push(Integer.parseInt(number));
                    }
                    // Else just get the numeric value of the character
                    // and push it to the operands stack.
                    else
                        operands.push(Character.getNumericValue(nextCharacter));

                    // Set the boolean variable to true
                    // because we are in the numbers case.
                    isPreviousCharANumber = true;
                    break;
            }
        }

        // Solve the remaining operations by popping them
        // until the operators stack is empty.
        while(!operators.isEmpty())
            solve(operators.pop(), operands.pop(), operands.pop());

        // Return the last remaining item on the operands
        // stack, which is the result.
        return operands.pop();
    }

    public boolean hasPrecedence(char operatorA, char operatorB)
    {
        // Get the precedence value of each operator.
        int precedenceOfA = getPrecedence(operatorA);
        int precedenceOfB = getPrecedence(operatorB);

        // If operator A has a greater precedence than
        // operator B return true.
        if (precedenceOfA < precedenceOfB)
            return true;

        // If both operators have the same precedence
        // pop the previous operation and solve it,
        // then return true.
        else if (precedenceOfA == precedenceOfB)
        {
            solve(operators.pop(), operands.pop(), operands.pop());
            return true;
        }

        // If operator B has a greater precedence
        // than operator A then return false.
        else
            return false;
    }

    public int getPrecedence(char operator)
    {
        // switch for getting the precedence
        // value of the operator. Smaller number
        // has higher precedence.
        switch(operator)
        {
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 2;
            default:
                return 3;
        }
    }

    public void solve(char operator, int b, int a)
    {
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

        // Pushing the result to the operands stack.
        operands.push(result);
    }
}