/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * October 25 , 2014
 * Description:
 */

import java.util.Vector;

public class VectorStack < T > implements StackInterface < T >
{
    private Vector < T > stack; // last element is the top entry in stack

    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public VectorStack ()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public VectorStack (int initialCapacity)
    {
        stack = new Vector < T > (initialCapacity); // size doubles as needed
    } // end constructor

    public void push (T newEntry)
    {
        stack.add(newEntry);
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

    public <T extends Comparable<T>> void nonRecursiveBubbleSort()
    {
        System.out.println("Stack size: " + stack.size());

        for(int i = 0; i < stack.size(); i++)
        {
            System.out.println("Hello");
            for(int j = 1; j < stack.size() - i; j++)
            {
                T elementA = (T) stack.elementAt(j);
                T elementB = (T) stack.elementAt(j - 1);

                System.out.println("ElementA: " + elementA);
                System.out.println("ElementB: " + elementB);

                if(elementA.compareTo(elementB) < 0)
                {
                    //stack.setElementAt(elementB, j);
                    //stack.setElementAt(elementA, j - 1);
                }
            }
        }
    }

//    public <T extends Comparable<T>>void recursiveBubbleSort()
//    {
//        recursiveBubbleSort(stack, 0);
//    }
//
//    public <T extends Comparable<T>>
//    void recursiveBubbleSort(Vector < T > a, int firstIndex)
//    {
//        T smallest = stack.elementAt(0);
//        int smallestIndex = firstIndex;
//        for(int i=firstIndex; i<stack.size(); i++)
//        {
//            if(element at i < element smallest)
//            // new smallest found
//        }
//        // swap smallest
//        if(firstIndex<a.size())
//            recursiveBubbleSort(a,  firstIndex+1)
//    }

    public void nonRecursiveSelectionSort()
    {

    }

    public void recursiveSelectionSort()
    {

    }

} // end VectorStack