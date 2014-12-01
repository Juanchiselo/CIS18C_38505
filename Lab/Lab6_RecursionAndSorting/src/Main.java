/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 26, 2014
 * Description:
 */

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random randomGenerator = new Random();

        VectorStack<Integer> stack = new VectorStack<Integer>();

        for(int i = 0; i < 100; i++)
        {
            stack.push(randomGenerator.nextInt(100));
        }

        for(int i = 0; i < 100; i++)
        {
            System.out.println(i + ") " + stack.peek());
            stack.pop();
        }

        stack.nonRecursiveBubbleSort();
    }
}
