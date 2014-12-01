/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 2, 2014
 * Description:
 */

// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of this package.
class BinaryNode<T>
{
    // Data; accessible by other package routines
    T element;  // The data in the node
    BinaryNode<T> left;     // Left child
    BinaryNode<T> right;    // Right child

    // Constructor
    BinaryNode(T element)
    {
        this.element = element;
        left = right = null;
    }
}