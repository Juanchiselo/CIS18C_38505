/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 26, 2014
 * Description:
 */

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        Random randomGenerator = new Random();

        VectorStack<Integer> stack = new VectorStack<Integer>();

        int size = 10;

        for(int i = 0; i < size; i++)
            stack.push(randomGenerator.nextInt(1000));

        long startTime = System.nanoTime();
        stack.nonRecursiveBubbleSort("Ascending");
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("\nNon Recursive Bubble Sort took "
            + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
            + " seconds.");

        stack.clear();

        for(int i = 0; i < size; i++)
            stack.push(randomGenerator.nextInt(1000));

        startTime = System.nanoTime();
        stack.nonRecursiveSelectionSort("Ascending");
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("\nNon Recursive Selection Sort took "
                + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
                + " seconds.");

        stack.clear();

        for(int i = 0; i < size; i++)
            stack.push(randomGenerator.nextInt(1000));

        startTime = System.nanoTime();
        stack.recursiveBubbleSort();
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("\nRecursive Bubble Sort took "
                + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
                + " seconds.");

        stack.clear();

        for(int i = 0; i < size; i++)
            stack.push(randomGenerator.nextInt(1000));

        startTime = System.nanoTime();
        stack.recursiveSelectionSort();
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("\nRecursive Bubble Sort took "
                + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
                + " seconds.");

        stack.clear();
    }
}
