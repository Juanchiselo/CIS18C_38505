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

        int size = 5000;

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

//        for(int i = 0; i < size; i++)
//            stack.push(randomGenerator.nextInt(1000));
//
//        startTime = System.nanoTime();
//        stack.recursiveBubbleSort();
//        elapsedTime = System.nanoTime() - startTime;
//
//        System.out.println("\nRecursive Bubble Sort took "
//                + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
//                + " seconds.");
//
//        stack.clear();
//
//        for(int i = 0; i < size; i++)
//            stack.push(randomGenerator.nextInt(1000));
//
//        startTime = System.nanoTime();
//        stack.recursiveSelectionSort();
//        elapsedTime = System.nanoTime() - startTime;
//
//        System.out.println("\nRecursive Bubble Sort took "
//                + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
//                + " seconds.");
//
//        stack.clear();

        Vector<Integer> vector = new Vector<Integer>();

        for(int i = 0; i < size; i++)
            vector.add(randomGenerator.nextInt(10));

        startTime = System.nanoTime();
        recursiveBubbleSort(vector, 0, vector.size() - 1);
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("\nRecursive Bubble Sort took "
                + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
                + " seconds.");

//        for(int i = 0; i < size; i++)
//            System.out.print(vector.get(i) + "  ");

        vector.clear();

        for(int i = 0; i < size; i++)
            vector.add(randomGenerator.nextInt(1000));


        startTime = System.nanoTime();
        recursiveSelectionSort(vector, 0, vector.size() - 1);
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("\nRecursive Selection Sort took "
                + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)
                + " seconds.");
    }

    public static void recursiveBubbleSort(Vector<Integer> vector, int firstIndex, int lastIndex)
    {
//        for(int i = 0; i < vector.size(); i++)
//            System.out.print(vector.get(i) + "  ");

//        System.out.println();

        while(firstIndex < lastIndex)
        {
            int elementA = vector.get(firstIndex);
            int elementB = vector.get(firstIndex + 1);

            if(elementA > elementB)
            {
                vector.set(firstIndex, elementB);
                vector.set(firstIndex + 1, elementA);
            }
            firstIndex++;
        }

        if(lastIndex > 1)
        {
            recursiveBubbleSort(vector, 0, lastIndex - 1);
        }
    }

    public static void recursiveSelectionSort(Vector<Integer> vector, int firstIndex, int lastIndex)
    {
        if(firstIndex < lastIndex && lastIndex > 0)
        {
            int index = firstIndex;
            int smallest = vector.get(firstIndex);

            for(int i = firstIndex + 1; i < vector.size(); i++)
            {
                if(vector.get(i) < smallest)
                {
                    smallest = vector.get(i);
                    index = i;
                }
            }

            vector.set(index, vector.get(firstIndex));
            vector.set(firstIndex, smallest);

            recursiveSelectionSort(vector, firstIndex + 1, lastIndex);
        }
    }
}
