/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * October 25 , 2014
 * Description:
 */

import java.util.Vector;
import java.util.Collections;

public class VectorStack <T> implements StackInterface <T>
{
    private Vector <T> stack;

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

    public <T extends Comparable<T>> void nonRecursiveBubbleSort(String order)
    {
        for(int i = 0; i < stack.size(); i++)
        {
            for(int j = 1; j < stack.size() - i; j++)
            {
                // Why doesn't this work?
                // T elementA = stack.get(j);
                T elementA = (T) stack.get(j - 1);
                T elementB = (T) stack.get(j);

                if(elementA.compareTo(elementB) > 0 && order.equals("Ascending"))
                {
                    // Why doesn't this work?
                    //stack.set(j - 1, elementB);
                    //stack.set(j, elementA);

                    // Temporary fix.
                    stack.add(j - 1, stack.get(j));
                    stack.remove(j + 1);
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

//    public <T extends Comparable<T>> void recursiveBubbleSort()
//    {
//        recursiveBubbleSort(stack, 0);
//    }
//
//    public <T extends Comparable<T>> void recursiveBubbleSort(Vector<T> a, int firstIndex)
//    {
//        T smallest = (T) stack.elementAt(0);
//
//        int smallestIndex = firstIndex;
//
//        for(int i=firstIndex; i<stack.size(); i++)
//        {
//            if(elementAt(i) < element smallest)
//            {
//
//            }
//            // new smallest found
//        }
//
//        // swap smallest
//        if(firstIndex<a.size())
//            recursiveBubbleSort(a,  firstIndex+1);
//    }

    public <T extends Comparable<T>> void nonRecursiveSelectionSort(String order)
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
        recursiveSelectionSort(stack, 0);
    }

    public void recursiveSelectionSort(Vector<T> a, int firstIndex)
    {

    }
}