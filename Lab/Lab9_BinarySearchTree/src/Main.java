/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 2, 2014
 * Description: Test program for an unbalanced
 *              Binary Search Tree.
 */

public class Main
{
    public static void main(String[] args)
    {
        // Instantiate a binary search tree of strings.
        BinarySearchTree<String> stringTree = new BinarySearchTree<String>();

        // Insert elements into the tree.
        System.out.println("Inserting elements: \n" +
                "E, D, N, K, S, F, L, W, H, A, J");
        stringTree.insert("E");
        stringTree.insert("D");
        stringTree.insert("N");
        stringTree.insert("K");
        stringTree.insert("S");
        stringTree.insert("F");
        stringTree.insert("L");
        stringTree.insert("W");
        stringTree.insert("H");
        stringTree.insert("A");
        stringTree.insert("J");

        // Find minimum element in the tree.
        System.out.println("\nMinimum Element: " + stringTree.findMin());

        // Find maximum element in the tree.
        System.out.println("Maximum Element: " + stringTree.findMax());

        // List elements in the tree.
        System.out.println("\nElements in the tree:");
        stringTree.list();

        // Remove minimum element from the tree.
        System.out.println("\nRemoving minimum element from the tree.");
        stringTree.removeMin();

        // Find element in the tree.
        System.out.println("\nChecking if A was removed.");
        if(stringTree.contains("A"))
            System.out.println(stringTree.find("A") + " is in the tree.");
        else
            System.out.println("Element A not found.");

        // Remove an element.
        System.out.println("\nRemoving J");
        stringTree.remove("J");

        // Search for an element.
        System.out.println("\nChecking if J was removed.");
        if(stringTree.search("J"))
            System.out.println("Element J is in the tree.");
        else
            System.out.println("Element J is not in the tree.");

        // Traverse the tree InOrder.
        System.out.println("\nTraversing the tree InOrder:");
        stringTree.traverseInOrder();

        // Traverse the tree PreOrder.
        System.out.println("\nTraversing the tree PreOrder:");
        stringTree.traversePreOrder();

        // Traverse the tree PostOrder.
        System.out.printf("\nTraversing the tree PostOrder:");
        stringTree.traversePostOrder();

        // Print the tree in a formatted display.
        System.out.println("\nPrinting the tree in a formatted display:");
        stringTree.print();

        // Empty the tree.
        System.out.println("\nEmptying the tree.");
        stringTree.makeEmpty();

        // Check if the tree is empty.
        System.out.println("\nChecking if the tree is empty.");
        if(stringTree.isEmpty())
            System.out.println("Tree is empty.");
        else
            System.out.println("Tree is not empty.");
    }
}