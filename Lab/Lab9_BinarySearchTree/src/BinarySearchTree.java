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
    // The tree's root.
    private BinaryNode<T> root;

    // Default constructor.
    public BinarySearchTree()
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
        if(isEmpty())
            root = new BinaryNode<T>(item);
        else
            root = insert(item, root);
    }

    /**
     * Remove from the tree.
     * @param element the item to remove.
     * @throws ItemNotFoundException if element is not found.
     */
    public void remove(T element)
    {
        root = remove(element, root);
    }

    /**
     * Remove minimum item from the tree.
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin()
    {
        root = removeMin(root);
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public T findMin()
    {
        return elementAt(findMin(root));
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public T findMax()
    {
        return elementAt(findMax(root));
    }

    /**
     * Find an item in the tree.
     * @param element the item to search for.
     * @return the matching item or null if not found.
     */
    public T find(T element)
    {
        return elementAt(find(element, root));
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    public boolean search(T target)
    {
        return search(root, target);
    }



    //====================================================//
    //                  INTERNAL METHODS                  //
    //====================================================//

    /**
     * Internal method to get element field.
     * @param node the node.
     * @return the element field or null if node is null.
     */
    private T elementAt(BinaryNode<T> node)
    {
        return node == null ? null : node.getElement();
    }

    /**
     * Internal method to insert into a subtree.
     * @param element the element to insert.
     * @param root the root that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if element is already present.
     */
    protected BinaryNode<T> insert(T element, BinaryNode<T> root)
    {
        int comparison = element.compareTo(root.getElement());

        // Left child case.
        if(comparison < 0)
        {
            if(root.getLeftChild() != null)
                insert(element, root.getLeftChild());
            else
                root.setLeftChild(new BinaryNode<T>(element));
        }

        // Right child case.
        else if(comparison > 0)
        {
            if(root.getRightChild() != null)
                insert(element, root.getRightChild());
            else
                root.setRightChild(new BinaryNode<T>(element));
        }

        // Same case.
        else
            root.setElement(element);

        return root;
    }

    /**
     * Internal method to remove from a subtree.
     * @param element the item to remove.
     * @param root the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if element is not found.
     */
    protected BinaryNode<T> remove(T element, BinaryNode<T> root)
    {
        if(root == null)
            System.out.println("ItemNot Found Exception: "+ element.toString( ) );

        int comparison = element.compareTo(root.getElement());

        // Left child case.
        if(comparison < 0)
            root.setLeftChild(remove(element, root.getLeftChild()));

        // Right child case.
        else if(comparison > 0)
            root.setRightChild(remove(element, root.getRightChild()));

        // Two children case.
        else if(root.getLeftChild() != null && root.getRightChild() != null)
        {
            root.setElement(findMin(root.getRightChild()).getElement());
            root.setRightChild(removeMin(root.getRightChild()));
        }

        // Node found case.
        else
        {
            root = (root.getLeftChild() != null)
                    ? root.getLeftChild() : root.getRightChild();
        }

        return root;
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * @param node the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if node is empty.
     */
    protected BinaryNode<T> removeMin(BinaryNode<T> node)
    {
        if(node == null)
        {
            System.out.println("ItemNotFound Exception: ");
            return null;
        }
        else if(node.getLeftChild() != null)
        {
            node.setLeftChild(removeMin(node.getLeftChild()));
            return node;
        }

        return node.getRightChild();
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param node the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode<T> findMin(BinaryNode<T> node)
    {
        if(node != null)
            while(node.getLeftChild() != null)
                node = node.getLeftChild();

        return node;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param node the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> node)
    {
        if(node != null)
            while(node.getRightChild() != null)
                node = node.getRightChild();

        return node;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param element is item to search for.
     * @param node the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<T> find(T element, BinaryNode<T> node)
    {
        while(node != null)
        {
            int comparison = element.compareTo(node.getElement());

            if(comparison < 0)
                node = node.getLeftChild();
            else if(comparison > 0)
                node = node.getRightChild();
            else
                return node;    // Match
        }

        return null;         // Not found
    }

    /** See if the tree contains a given item.
     * @param target the item to search for
     * @return true if the item is in the tree
     */
    public boolean contains(T target)
    {
        return (find(target) != null);
    }

    /** Recursively search the tree for the target */
    private boolean search(BinaryNode<T> node, T target)
    {
        if(node != null)
        {
            int comparison = target.compareTo(node.getElement());

            if (comparison < 0)
                return search(node.getLeftChild(), target);
            else if (comparison > 0)
                return search(node.getRightChild(), target);
            else
            // Item was found.
                return true;
        }

        // Item was not found.
        return false;
    }

    /** Show an alphabetical list of the items in the tree,
     * one item per line.     */
    public void list()
    {
        if(root != null)
        {
            T element;

            do
            {
                element = findMin();
                System.out.println(element);
                removeMin();
            }while(element != findMax());
        }
    }

    public void traverseInOrder()
    {
        traverseInOrder(root);
    }

    /** Recursive in-order traversal of the tree, printing each node */
    private void traverseInOrder(BinaryNode<T> node)
    {
        if(node != null)
        {
            traverseInOrder(node.getLeftChild());
            System.out.println(node.getElement());
            traverseInOrder(node.getRightChild());
        }
    }

    /** Print a formatted display of the tree.  */
    public void print()
    {
        traverseInOrder();
    }

    public void traversePreOrder()
    {
        traversePreOrder(root, 0);
    }

    /** Recursive pre-order traversal of the tree, printing each node
     * indented an amount corresponding to its level in the tree.
     */
    private void traversePreOrder(BinaryNode<T> node, int indent)
    {
        if(node != null)
        {
            String indentation = "";

            for(int i = 0; i < indent; i++)
                indentation += " ";

            System.out.println(indentation + node.getElement());

            indent += 5;

            traversePreOrder(node.getLeftChild(), indent);
            traversePreOrder(node.getRightChild(), indent);
        }
    }
}