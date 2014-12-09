import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Hashtable
{
    private LinkedList<String>[] hashtable;
    private int size;
    private int function;

    public Hashtable(int size, int function)
    {
        this.size = size;
        this.function = function;
        hashtable = new LinkedList[size];
        for(int i = 0; i < size; i++)
        {
            hashtable[i] = new LinkedList<String>();
        }
    }

    public void insert(String key)
    {
        int hash;

        if(function == 1)
            hash = h(key);
        else
            hash = myHashingFunction(key);

        hashtable[hash].push(key);
    }

    private int h(String key)
    {

        //System.out.println(key);
        int hv = 0;
        for(int i=0; i<key.length(); i++)
        {
            char c = key.charAt(i);
            int ascii = (int) c;
            hv += ascii;
           // System.out.print(ascii + " ");
        }
       // System.out.println();
        //System.out.println(hv);
        //return hv % size;
        return key.hashCode() % size;
    }

    private int myHashingFunction(String key)
    {
        int hashValue = 0;

        for(int i = 0; i < key.length(); i++)
        {
            char character = key.charAt(i);
            int ascii = (int) character;
            int multiplier = ascii % 3;

            if(ascii % 3 == 1)
                ascii *= multiplier;
            else if(ascii % 3 == 2)
                ascii += (multiplier * i);
            else
                ascii *= multiplier * multiplier;

            hashValue += ascii;
        }
        return hashValue % size;
    }

    public void print()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(i + ":\t");

            for(int j = 0; j < hashtable[i].size(); j++)
            {
                System.out.print(hashtable[i].get(j));

                if(j != hashtable[i].size() - 1)
                    System.out.print(", ");
            }

            System.out.println();
        }
    }

    public void printStats()
    {
        double avgCollisions = 0;
        int collisions = 0;
        double longestChain = 0;

        for(int i = 0; i < size; i++)
        {
            avgCollisions += hashtable[i].size();
            if(hashtable[i].size() > 1)
            {
                collisions+= hashtable[i].size()-1;
            }
            if(hashtable[i].size()>longestChain)
            {
                longestChain = hashtable[i].size();
            }
        }

        avgCollisions = avgCollisions/size;
        System.out.println();
        System.out.println("Total number of collisions: "+collisions);
        System.out.println("The length of the longest chain: "+longestChain);
        System.out.println("Average chain length: "+avgCollisions);
    }

    public void processFile(String filename)
    {
        try
        {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                insert(line);
            }

            fileReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
