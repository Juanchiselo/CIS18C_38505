/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 2, 2014
 * Description:
 */

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove minimum item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 */

public class BinarySearchTree<T extends Comparable<? super T>>
{
    // The tree root.
    protected BinaryNode<T> root;

    // Default constructor.
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Inserts an item into the tree.
     * @param item - the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void insert(T item)
    {
        root = insert(item, root);
    }

    /**
     * Remove from the tree..
     * @param x the item to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove( T x )
    {
        root = remove( x, root );
    }

    /**
     * Remove minimum item from the tree.
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin( )
    {
        root = removeMin( root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public T findMin( )
    {
        return elementAt( findMin( root ) );
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public T findMax( )
    {
        return elementAt( findMax( root ) );
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public T find( T x )
    {
        return elementAt( find( x, root ) );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Internal method to get element field.
     * @param t the node.
     * @return the element field or null if t is null.
     */
    private T elementAt( BinaryNode<T> t )
    {
        return t == null ? null : t.element;
    }

    /**
     * Internal method to insert into a subtree.
     * @param item the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if x is already present.
     */
    protected BinaryNode<T> insert( T item, BinaryNode<T> t)
    {


        return null;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    protected BinaryNode<T> remove( T x, BinaryNode<T> t )
    {
        if( t == null )
            System.out.println("ItemNot Found Exception: "+ x.toString( ) );  // Not found
        if( x.compareTo( t.element ) < 0 )
            t.left = remove( x, t.left );
        else if( x.compareTo( t.element ) > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = removeMin( t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if t is empty.
     */
    protected BinaryNode<T> removeMin( BinaryNode<T> t )
    {
        if( t == null )
        {
            System.out.println("ItemNot Found Exception: ");
            return null;
        }
        else if( t.left != null )
        {
            t.left = removeMin( t.left );
            return t;
        }

        return t.right;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode<T> findMin( BinaryNode<T> t )
    {
        if( t != null )
            while( t.left != null )
                t = t.left;

        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax( BinaryNode<T> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<T> find( T x, BinaryNode<T> t )
    {
        while( t != null )
        {
            if( x.compareTo( t.element ) < 0 )
                t = t.left;
            else if( x.compareTo( t.element ) > 0 )
                t = t.right;
            else
                return t;    // Match
        }

        return null;         // Not found
    }

    /** See if the tree contains a given item.
     * @param target the item to search for
     * @return true if the item is in the tree
     */
    public boolean contains(T target)
    {
        if(find(target) != null)
            return true;
        else
            return false;
    }

    /** Recursively search the tree for the target */
    private boolean search(BinaryNode<T> curr, T target)
    {
        return false;
    }

    /** Show an alphabetical list of the items in the tree,
     * one item per line.     */
    public void list()
    {

    }

    /** Recursive in-order traversal of the tree, printing each node */
    private void traverseInOrder(BinaryNode<T> curr)
    {

    }

    /** Print a formatted display of the tree.  */
    public void print()
    {

    }

    /** Recursive pre-order traversal of the tree, printing each node
     * indented an amount corresponding to its level in the tree.
     */
    private void traversePreOrder(BinaryNode<T> curr, int indent)
    {
    }
}