/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 2, 2014
 * Description:
 */

public class Main
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>( );

        final int NUMS = 4000;
        final int GAP  =   37;

//        tree.insert(15);
//        tree.insert(9);
//        tree.insert(7);
//        tree.insert(23);
//        tree.insert(25);
//        tree.insert(2);
//        tree.insert(6);
//        tree.insert(17);
//        tree.insert(24);
//        tree.insert(27);
//        tree.insert(300);
//        tree.insert(5000);
//
//        tree.traverseInOrder();
//        System.out.println();
//
//        tree.traversePreOrder();
//
//        if(tree.isEmpty())
//            System.out.println("Tree is empty");
//        else
//            System.out.println("Tree is not empty");


        for(int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            tree.insert(i);

        for( int i = 1; i < NUMS; i += 2 )
            tree.remove(i);


        if( tree.findMin( ) != 2 || tree.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i += 2 )
            if( tree.find( i ) != i )
                System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i += 2 )
            if( tree.find( i ) != null )
                System.out.println( "Find error2!" );

        tree.traversePreOrder();
    }
}