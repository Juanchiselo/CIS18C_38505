/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * October 25 , 2014
 * Description:
 */

import java.util.Vector;
import java.util.Collections;

public class VectorStack <T extends Comparable<T>> implements StackInterface <T>
{
    private Vector<T> stack;

    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public VectorStack ()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    }

    public VectorStack (int initialCapacity)
    {
        stack = new Vector <T> (initialCapacity);
    }

    public void push (T element)
    {
        stack.add(element);
    }

    public T pop ()
    {
        T top = null;

        if(!isEmpty())
            top = stack.remove(stack.size() - 1);

        return top;
    }

    public T peek ()
    {
        T top = null;

        if(!isEmpty())
            top = stack.lastElement();

        return top;
    }

    public boolean isEmpty ()
    {
        return stack.isEmpty();
    }

    public void clear ()
    {
        stack.clear();
    }

    public int size()
    {
        return stack.size();
    }

    public void nonRecursiveBubbleSort(String order)
    {
        for(int i = 0; i < stack.size(); i++)
        {
            for(int j = 1; j < stack.size() - i; j++)
            {
                T elementA = stack.get(j - 1);
                T elementB = stack.get(j);

                if(elementA.compareTo(elementB) > 0 && order.equals("Ascending"))
                {
                    stack.set(j - 1, elementB);
                    stack.set(j, elementA);
                }

                if(elementA.compareTo(elementB) < 0 && order.equals("Descending"))
                {
                    stack.add(j - 1, stack.get(j));
                    stack.remove(j + 1);
                }
            }
        }

        // Reverses the order of the vector elements so that
        // it conforms to stack constraints.
        // FIFO (First In, First Out).
        Collections.reverse(stack);
    }

    public void recursiveBubbleSort()
    {
        recursiveBubbleSort(stack, 0, stack.size() - 1);

        // Reverses the order of the vector elements so that
        // it conforms to stack constraints.
        // FIFO (First In, First Out).
        Collections.reverse(stack);
    }

    public void recursiveBubbleSort(Vector<T> vector, int firstIndex, int lastIndex)
    {
        if(firstIndex < lastIndex && lastIndex > 0)
        {
            T elementA = vector.get(firstIndex);
            T elementB = vector.get(firstIndex + 1);

            if(elementA.compareTo(elementB) > 0)
            {
                vector.set(firstIndex, elementB);
                vector.set(firstIndex + 1, elementA);
            }

            if(firstIndex == lastIndex - 1)
                recursiveBubbleSort(vector, 0, lastIndex - 1);

            recursiveBubbleSort(vector, firstIndex + 1, lastIndex);
        }
    }

    public void nonRecursiveSelectionSort(String order)
    {
        int index;
        int j;

        for(int i = 0; i < stack.size() - 1; i++)
        {
            index = i;

            for(j = i + 1; j < stack.size(); j++)
            {
                T elementB = (T) stack.get(j);

                if(elementB.compareTo((T) stack.get(index)) < 0 && order.equals("Ascending"))
                    index = j;

                if(elementB.compareTo((T) stack.get(index)) > 0 && order.equals("Descending"))
                    index = j;
            }

            stack.add(i, stack.get(index));
            stack.set(index + 1, stack.get(i + 1));
            stack.remove(i + 1);
        }

        // Reverses the order of the vector elements so that
        // it conforms to stack constraints.
        // FIFO (First In, First Out).
        Collections.reverse(stack);
    }

    public void recursiveSelectionSort()
    {
        recursiveSelectionSort(stack, 0, stack.size() - 1);

        // Reverses the order of the vector elements so that
        // it conforms to stack constraints.
        // FIFO (First In, First Out).
        Collections.reverse(stack);
    }

    public void recursiveSelectionSort(Vector<T> vector, int firstIndex, int lastIndex)
    {
        if(firstIndex < lastIndex && lastIndex > 0)
        {
            int index = firstIndex;
            T smallest = vector.get(firstIndex);

            for(int i = firstIndex + 1; i < vector.size(); i++)
            {
                if(vector.get(i).compareTo(smallest) < 0)
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