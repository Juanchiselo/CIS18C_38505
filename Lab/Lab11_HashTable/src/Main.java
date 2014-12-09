public class Main
{
    public static void main(String[] args)
    {
        final int HASH_TABLE_SIZE = 10;
        Hashtable hashtableF1 = new Hashtable(HASH_TABLE_SIZE, 1);
        hashtableF1.processFile("test1.txt");
        System.out.println("Part 1: Hash table functionality test.");
        System.out.println("Table size 10 using file test1.txt");
        hashtableF1.print();
        hashtableF1.printStats();

        Hashtable hashtableF2 = new Hashtable(20, 2);
        hashtableF2.processFile("test2.txt");
        System.out.println("\nPart 2: Hash function test.");
        System.out.println("Table size 20 using file test2.txt");
        hashtableF2.print();
        hashtableF2.printStats();
    }
}
