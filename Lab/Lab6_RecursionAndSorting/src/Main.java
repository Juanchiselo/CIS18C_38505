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

        for(int i = 0; i < 10; i++)
            stack.push(randomGenerator.nextInt(10));

        stack.nonRecursiveBubbleSort("Descending");

        System.out.println("Sorted stack using Non Recursive Bubble Sort:");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(i + ") " + stack.peek());
            stack.pop();
        }

        for(int i = 0; i < 10; i++)
            stack.push(randomGenerator.nextInt(10));

        stack.nonRecursiveSelectionSort("Descending");

        System.out.println("Sorted stack using Non Recursive Selection Sort:");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(i + ") " + stack.peek());
            stack.pop();
        }



    }
}
