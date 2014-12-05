/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 2, 2014
 * Description:
 */

// Basic node stored in unbalanced binary search trees.
class BinaryNode<T>
{
    // element variable store the data in the node.
    private T element;

    // leftChild node is the leftChild child of the node.
    private BinaryNode<T> leftChild;

    // rightChild node is the rightChild child of the node.
    private BinaryNode<T> rightChild;    // Right child

    // Constructor
    public BinaryNode(T element)
    {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public void setElement(T element)
    {
        this.element = element;
    }

    public void setLeftChild(BinaryNode<T> leftChild)
    {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryNode<T> rightChild)
    {
        this.rightChild = rightChild;
    }

    public T getElement()
    {
        return element;
    }

    public BinaryNode<T> getLeftChild()
    {
        return leftChild;
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    }
}