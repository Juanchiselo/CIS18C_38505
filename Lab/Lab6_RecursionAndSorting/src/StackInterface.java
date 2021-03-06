/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * October 25, 2014
 * Description:
 */

public interface StackInterface < T >
{
    /** Adds a new entry to the top of this stack.
     @param element an object to be added to the stack */
    public void push (T element);

    /** Removes and returns this stacks top entry.
     @return either the object at the top of the stack or, if the
     stack is empty before the operation, null */
    public T pop ();

    /** Retrieves this stacks top entry.
     @return either the object at the top of the stack or null if
     the stack is empty */
    public T peek ();

    /** Detects whether this stack is empty.
     @return true if the stack is empty */
    public boolean isEmpty ();

    /** Removes all entries from this stack */
    public void clear ();

    // Returs the size of the stack.
    public int size();

} // end StackInterface