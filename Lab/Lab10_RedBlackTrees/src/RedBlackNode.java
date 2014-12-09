/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 15, 2014
 * Lab 10 - Red-Black Trees
 * Description: Generic RedBlackNode class.
 *              Nodes of a Red-Black tree.
 */

class RedBlackNode<T>
{
    // The data in the node.
    private T element;

    // The color of the node.
    private String color;

    // The parent of the node.
    private RedBlackNode<T> parent;

    // The left child of the node.
    private RedBlackNode<T> leftChild;

    // The right child of the node.
    private RedBlackNode<T> rightChild;


    /**
     * The constructor.
     * Sets the node's element to the element passed to it
     * when the node was instantiated.
     * @param element - The element to be stored inside the node.
     */
    public RedBlackNode(T element, String color, RedBlackNode<T> parent)
    {
        this.element = element;
        this.color = color;
        this.parent = parent;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Element setter method.
     * Sets the node's element to the element passed to it.
     * @param element - The element to be stored inside the node.
     */
    public void setElement(T element)
    {
        this.element = element;
    }

    /**
     * Color setter method.
     * Sets the node's color to the color passed to it.
     * @param color - The color the node will be recolored to.
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * Parent setter method.
     * Sets the node's parent to the node passed to it.
     * @param parent - The node that will be the parent of
     *                 this node.
     */
    public void setParent(RedBlackNode<T> parent)
    {
        this.parent = parent;
    }

    /**
     * Left child setter method.
     * Sets the node's left child to the node passed to it.
     * @param leftChild - The node that will be the left child
     *                    of this node.
     */
    public void setLeftChild(RedBlackNode<T> leftChild)
    {
        this.leftChild = leftChild;
    }

    /**
     * Right child setter method.
     * Sets the node's right child to the node passed to it.
     * @param rightChild - The node that will be the right child
     *                     of this node.
     */
    public void setRightChild(RedBlackNode<T> rightChild)
    {
        this.rightChild = rightChild;
    }

    /**
     * Element getter method.
     * Gets the node's element.
     * @return - Returns the element stored inside the node.
     */
    public T getElement()
    {
        return element;
    }

    /**
     * Color getter method.
     * Gets the node's color.
     * @return - Returns the color of the node.
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Parent getter method.
     * Gets the node's parent.
     * @return - Returns the parent of the node.
     */
    public RedBlackNode<T> getParent()
    {
        return parent;
    }

    /**
     * GrandParent getter method.
     * Gets the node's grandparent.
     * @return - Returns the grandparent of the node.
     */
    public RedBlackNode<T> getGrandParent()
    {
        return parent.getParent();
    }

    /**
     * Uncle getter method.
     * Gets the node's uncle.
     * @return - Returns the uncle of the node.
     */
    public RedBlackNode<T> getUncle()
    {
        if(getGrandParent().getLeftChild() == parent)
            return getGrandParent().getRightChild();
        else
            return getGrandParent().getLeftChild();
    }

    /**
     * Left child getter method.
     * Gets the node's left child.
     * @return - Returns the left child of the node.
     */
    public RedBlackNode<T> getLeftChild()
    {
        return leftChild;
    }

    /**
     * Right child getter method.
     * Gets the node's right child.
     * @return - Returns the right child of the node.
     */
    public RedBlackNode<T> getRightChild()
    {
        return rightChild;
    }
}