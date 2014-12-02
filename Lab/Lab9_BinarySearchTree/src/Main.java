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

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            tree.insert( i );

//        for( int i = 1; i < NUMS; i += 2 )
//            tree.remove( i );

//        if( tree.findMin( ) != 2 || tree.findMax( ) != NUMS - 2 )
//            System.out.println( "FindMin or FindMax error!" );
//
//        for( int i = 2; i < NUMS; i += 2 )
//            if( tree.find( i ) != i )
//                System.out.println( "Find error1!" );
//
//        for( int i = 1; i < NUMS; i += 2 )
//            if( tree.find( i ) != null )
//                System.out.println( "Find error2!" );
    }
}