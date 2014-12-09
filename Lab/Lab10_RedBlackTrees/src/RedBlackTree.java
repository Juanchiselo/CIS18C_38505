/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 15, 2014
 * Lab 10 - Red-Black Trees
 * Description: A generic Red-Black Tree class.
 *              Implements a balanced Red-Black Tree.
 */

public class RedBlackTree<T extends Comparable<? super T>>
{
    // The root of the tree.
    protected RedBlackNode<T> root;

    /**
     * The constructor.
     * Sets the root to null.
     */
    public RedBlackTree()
    {
        root = null;
    }

    /**
     * Public insert method.
     * Inserts the passed element into the tree.
     * @param element - The element to be inserted.
     */
    public void insert(T element)
    {
        if(isEmpty())
            root = new RedBlackNode<T>(element, "Black", null);
        else
            root = insert(root, element);

        reColor1(find(root, element));
    }

    /**
     * Public remove method.
     * Removes the passed element from the tree.
     * @param element - The item to be removed.
     */
    public void remove(T element)
    {
        root = remove(root, element);
    }

    /**
     * Public removeMin method.
     * Removes the minimum element from the tree.
     */
    public void removeMin()
    {
        root = removeMin(root);
    }

    /**
     * Public findMin method.
     * Finds the minimum element in the tree.
     * @return - Returns the minimum element
     *           or null if the tree is empty.
     */
    public T findMin()
    {
        return elementAt(findMin(root));
    }

    /**
     * Public findMax method.
     * Finds the maximum element in the tree.
     * @return - Returns the maximum element
     *           or null if the tree is emtpy.
     */
    public T findMax()
    {
        return elementAt(findMax(root));
    }

    /**
     * Public find method.
     * Finds the passed element in the tree.
     * @param element - The element to search for.
     * @return - Returns the matching element or
     *           null if the element was not found.
     */
    public T find(T element)
    {
        return elementAt(find(root, element));
    }

    /**
     * Public makeEmpty method.
     * Makes the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }

    /**
     * Public isEmpty method.
     * Checks if the tree is logically empty.
     * @return - Returns true if the tree is empty,
     *           false if the tree is not empty.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Public contains method.
     * Checks if the tree contains the passed element.
     * @param element - The element to search for.
     * @return - Returns true if the element is in the
     *           tree, false if it is not in the tree.
     */
    public boolean contains(T element)
    {
        return (find(element) != null);
    }

    /**
     * Public search method.
     * Searches the tree for the passed element.
     * @param element - The element to search for.
     * @return - Returns true if the element is in the
     *           tree, false if it is not in the tree.
     */
    public boolean search(T element)
    {
        return search(root, element);
    }

    /**
     * Public traverseInOrder method.
     * Traverses the tree in order and prints out
     * a list of the elements in the tree.
     */
    public void traverseInOrder()
    {
        traverseInOrder(root);
    }

    /**
     * Public traversePreOrder method.
     * Traverses the tree in PreOrder and prints
     * out a list of the elements in the tree.
     */
    public void traversePreOrder()
    {
        traversePreOrder(root);
    }

    /**
     * Public traversePostOrder method.
     * Traverses the tree in PostOrder and prints
     * out a list of the elements in the tree.
     */
    public void traversePostOrder()
    {
        traversePostOrder(root);
    }

    /**
     * Public print method.
     * Prints out a formatted display of the tree.
     * Indentation is used to show nodes that are
     * at the same level.
     */
    public void print()
    {
        print(root, 0);
    }

    /**
     * Public list method.
     * Prints out an alphabetical list of the items
     * in the tree.
     */
    public void list()
    {
        traverseInOrder();
    }


    //====================================================//
    //                  INTERNAL METHODS                  //
    //====================================================//

    /**
     * Internal elementAt method.
     * Gets the element from the passed node.
     * @param node - The node to get the element from.
     * @return - Returns the node's element
     *           or null if the node is null.
     */
    private T elementAt(RedBlackNode<T> node)
    {
        return (node == null) ? null : node.getElement();
    }

    /**
     * Internal insert method.
     * Inserts the passed element into a subtree.
     * @param element - The element to be inserted.
     * @param root - The node that roots the tree.
     * @return - Returns the new root.
     */
    protected RedBlackNode<T> insert(RedBlackNode<T> root, T element)
    {
        int comparison = element.compareTo(root.getElement());

        // Left child case.
        if(comparison < 0)
        {
            if(root.getLeftChild() != null)
                insert(root.getLeftChild(), element);
            else
                root.setLeftChild(new RedBlackNode<T>(element, "Red", root));
        }

        // Right child case.
        else if(comparison > 0)
        {
            if(root.getRightChild() != null)
                insert(root.getRightChild(), element);
            else
                root.setRightChild(new RedBlackNode<T>(element, "Red", root));
        }

        // Duplicate case.
        else
            System.out.println("ERROR: Element already exists.");

        return root;
    }

    protected void reColor1(RedBlackNode<T> root)
    {
        if(root.getParent() == null)
            root.setColor("Black");
        else
            reColor2(root);
    }

    protected void reColor2(RedBlackNode<T> root)
    {
        if(root.getParent().getColor().equals("Black"))
            return;
        else
            reColor3(root);
    }

    protected void reColor3(RedBlackNode<T> root)
    {
        RedBlackNode<T> uncle = root.getUncle();
        System.out.println("RC3 - Root is " + root.getElement());



        if(uncle != null)
        {
            System.out.println("Uncle: " + root.getUncle().getElement());

            if(uncle.getColor().equals("Red"))
            {
                root.getParent().setColor("Black");
                uncle.setColor("Black");
                RedBlackNode grandParent = root.getGrandParent();
                grandParent.setColor("Red");
                System.out.println("Recoloring " + grandParent.getElement()
                        + " because of " + root.getElement());
                System.out.println("Debug before:");
                debug();
                System.out.println();
                reColor1(grandParent);
                System.out.println("Debug after reColor1 is done:");
                debug();
                System.out.println();
            }
            else
            {
                rotateRight(root.getParent());
                reColor1(root.getRightChild());

            }
        }
        else
            reColor4(root);
    }

    protected void reColor4(RedBlackNode<T> root)
    {
        RedBlackNode<T> grandParent = root.getGrandParent();
        System.out.println("RC4 - Root is " + root.getElement());

        if(root == root.getParent().getRightChild()
                && root.getParent() == grandParent.getLeftChild())
        {
            rotateLeft(root.getParent());
            root = root.getLeftChild();
        }
        else if(root == root.getParent().getLeftChild()
                && root.getParent() == grandParent.getRightChild())
        {
            System.out.println(root.getElement() + " BROUGHT ME HERE.");
            rotateRight(root.getParent());
            root = root.getRightChild();
        }

        reColor5(root);
    }

    protected void reColor5(RedBlackNode<T> root)
    {
        RedBlackNode<T> grandParent = root.getGrandParent();

        root.getParent().setColor("Black");
        grandParent.setColor("Red");

        if(root == root.getParent().getLeftChild())
            rotateRight(grandParent);
        else
            rotateLeft(grandParent);
    }


    protected void rotateRight(RedBlackNode<T> root)
    {
        if(root != null)
        {
            RedBlackNode<T> leftChild = root.getLeftChild();
            leftChild.setParent(root.getParent());
            root.setLeftChild(leftChild.getRightChild());
            leftChild.setRightChild(root);
            leftChild.getParent().setRightChild(leftChild);
            root.setParent(leftChild);

            if(root == this.root)
                this.root = leftChild;
        }
    }

    protected void rotateLeft(RedBlackNode<T> root)
    {
        if(root != null)
        {
            RedBlackNode<T> rightChild = root.getRightChild();
            rightChild.setParent(root.getParent());
            root.setRightChild(rightChild.getLeftChild());
            rightChild.setLeftChild(root);
            root.setParent(rightChild);

            if(root == this.root)
                this.root = rightChild;
        }
    }

    /**
     * Internal remove method.
     * Removes the passed element from a subtree.
     * @param element - The element to be removed.
     * @param root - The node that roots the tree.
     * @return - Returns the root.
     */
    protected RedBlackNode<T> remove(RedBlackNode<T> root, T element)
    {
        if(root != null)
        {
            int comparison = element.compareTo(root.getElement());

            // Left child case.
            if(comparison < 0)
                root.setLeftChild(remove(root.getLeftChild(), element));

                // Right child case.
            else if(comparison > 0)
                root.setRightChild(remove(root.getRightChild(), element));

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
        }
        else
            System.out.println("ERROR: Element was not found.");

        return root;
    }

    /**
     * Internal removeMin method.
     * Removes the minimum element from a subtree.
     * @param root - The node that roots the tree.
     * @return - Returns the new root.
     */
    protected RedBlackNode<T> removeMin(RedBlackNode<T> root)
    {
        if(root == null)
        {
            System.out.println("ItemNotFound Exception: ");
            return null;
        }
        else if(root.getLeftChild() != null)
        {
            root.setLeftChild(removeMin(root.getLeftChild()));
            return root;
        }

        return root.getRightChild();
    }

    /**
     * Internal findMin method.
     * Finds the minimum element in a subtree.
     * @param root - The node that roots the tree.
     * @return - Returns the node containing the
     *           minimum element.
     */
    protected RedBlackNode<T> findMin(RedBlackNode<T> root)
    {
        if(root != null)
            while(root.getLeftChild() != null)
                root = root.getLeftChild();

        return root;
    }

    /**
     * Internal findMax method.
     * Finds the maximum element in a subtree.
     * @param root - The node that roots the tree.
     * @return - Returns the node containing
     *           the maximum element.
     */
    private RedBlackNode<T> findMax(RedBlackNode<T> root)
    {
        if(root != null)
            while(root.getRightChild() != null)
                root = root.getRightChild();

        return root;
    }

    /**
     * Internal find method.
     * Finds the passed element in a subtree.
     * @param element - The element to search for.
     * @param root - The node that roots the tree.
     * @return - Returns the node containing
     *           the element.
     */
    private RedBlackNode<T> find(RedBlackNode<T> root, T element)
    {
        while(root != null)
        {
            int comparison = element.compareTo(root.getElement());

            if(comparison < 0)
                root = root.getLeftChild();
            else if(comparison > 0)
                root = root.getRightChild();
            else
                return root;
        }

        return null;
    }

    /**
     * Internal search method.
     * Recursively searches the tree for the
     * passed element.
     * @param root - The node that roots the tree.
     * @param element - The element to search for.
     * @return - Returns true if the item is in
     *           the tree, false if it is not in
     *           the tree.
     */
    private boolean search(RedBlackNode<T> root, T element)
    {
        if(root != null)
        {
            int comparison = element.compareTo(root.getElement());

            if (comparison < 0)
                return search(root.getLeftChild(), element);
            else if (comparison > 0)
                return search(root.getRightChild(), element);
            else
                // Item was found.
                return true;
        }

        // Item was not found.
        return false;
    }

    /**
     * Internal traverseInOrder method.
     * Recursively traverses the tree in order and
     * prints out a list of the elements.
     * @param root - The node that roots the tree.
     */
    private void traverseInOrder(RedBlackNode<T> root)
    {
        if(root != null)
        {
            traverseInOrder(root.getLeftChild());
            System.out.println(root.getElement().toString());
            traverseInOrder(root.getRightChild());
        }
    }

    /**
     * Internal traversePreOrder method.
     * Recursively traverses the tree in PreOrder
     * and prints out a list of the elements.
     * @param root - The node that roots the tree.
     */
    private void traversePreOrder(RedBlackNode<T> root)
    {
        if(root != null)
        {
            System.out.println(root.getElement().toString());
            traversePreOrder(root.getLeftChild());
            traversePreOrder(root.getRightChild());
        }
    }

    /**
     * Internal traversePostOrder method.
     * Recursively traverses the tree in PostOrder
     * and prints out a list of the elements.
     * @param root - The node that roots the tree.
     */
    private void traversePostOrder(RedBlackNode<T> root)
    {
        if(root != null)
        {
            traversePostOrder(root.getLeftChild());
            traversePostOrder(root.getRightChild());
            System.out.println(root.getElement().toString());
        }
    }

    /**
     * Internal print method.
     * Prints out a formatted display of the tree.
     * Indentation is used to show nodes that are
     * at the same level.
     * @param root - The node that roots the tree.
     * @param indent
     */
    private void print(RedBlackNode<T> root, int indent)
    {
        if(root != null)
        {
            String indentation = "";

            for(int i = 0; i < indent; i++)
                indentation += " ";

            System.out.println(indentation
                    + root.getElement().toString());

            indent += 5;

            print(root.getLeftChild(), indent);
            print(root.getRightChild(), indent);
        }
    }

    public void debug()
    {
        debug(root);
    }

    private void debug(RedBlackNode<T> root)
    {
        if(root != null)
        {
            System.out.println();
            System.out.print(root.getElement()
                    + " Color: " + root.getColor());
//            if(root.getParent() != null)
//                System.out.print(" Parent: " + root.getParent().getElement());
            debug(root.getLeftChild());
            debug(root.getRightChild());
        }
    }
}