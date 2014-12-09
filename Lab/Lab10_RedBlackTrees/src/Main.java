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
//        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();

//        tree.insert(41);
//        tree.insert(38);
//        tree.insert(31);
//        tree.insert(12);
//        tree.insert(19);
//
//        tree.debug();
//        System.out.println();
//        tree.print();
//
//
//
//




        // Movies
        String A = "Aliens";
        String B = "Clerks";
        String C = "Die Hard";
        String D = "Enemy of the State";
        String E = "Gladiator";
        String F = "Happy Gilmore";
        String G = "Kill Bill Volume 1";
        String H = "Kill Bill Volume 2";
        String I = "Matrix";
        String J = "Meet the Parents";
        String K = "Pirates of the Caribbean";
        String L = "Silence of the Lambs";
        String M = "Spaceballs";
        String N = "Star Wars";
        String O = "Terminator";
        String P = "The Lord of the Rings";
        String Q = "The Usual Suspects";
        String R = "Top Gun";

        //------------------------------------------------------------------------
        // Extra Credit Testing
        RedBlackTree<String> tree = new RedBlackTree<String>();


        tree.insert(C);
        tree.insert(O);
        tree.insert(G);
        tree.insert(K);
        tree.insert(P);
        tree.insert(N);
        tree.insert(E);
        tree.insert(I);
        tree.insert(B);
        tree.insert(Q);
        tree.insert(L);
//        tree.insert(D);
//        tree.insert(A);
//        tree.insert(M);
//        tree.insert(F);
//        tree.insert(R);
//        tree.insert(J);
//        tree.insert(H);

        tree.print();
        //tree.debug();



//        System.out.println("EC test 1");
//        tree.remove ( K );
//        tree.printOrders ( tree );
//        System.out.println("----------------------------------------------------");
//        System.out.println("EC test 2");
//        tree.remove ( D );
//        tree.printOrders ( tree );
//        System.out.println("----------------------------------------------------");
//        System.out.println("EC test 3");
//        tree.remove ( A );
//        tree.printOrders ( tree );
//        System.out.println("----------------------------------------------------");
//        System.out.println("EC test 4");
//        tree.remove ( G );
//        tree.printOrders ( tree );
//        System.out.println("----------------------------------------------------");
//        System.out.println("EC test 5");
//        tree.remove ( I );
//        tree.remove ( M );
//        tree.remove ( B );
//        tree.remove ( E );
//        tree.printOrders ( tree );
//        System.out.println("----------------------------------------------------");
    }
}