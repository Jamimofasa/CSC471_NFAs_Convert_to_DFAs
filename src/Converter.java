import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author James Morand
 */
public class Converter {

    static ArrayList<ArrayList<Integer>> dataTable = new ArrayList <>();
    static Set<Integer> mainSet = new HashSet <>(); //put all data into a set which will automatically have no duplicates
    static List<ArrayList<Integer>> mylist = new ArrayList <>(dataTable);
    static Set<ArrayList <Integer>> g = new HashSet<>();

    public static void main(String[] args) {

        //read in the file
        readFile();

        for (ArrayList<Integer> p: dataTable) //testing to print out the arraylist
        {
            mainSet.addAll(p);
        }

        //make a dfa method
        convertToDFA(mainSet);

//        g.addAll(dataTable); //add the arraylist into a set
//
//        System.out.println("\nThis is a test for the dataTable");
//        System.out.println(g);//print out the set or dataTable
//
//        //dont need this for the project it was just to test the reading in of the arraylist for the dataTable
//        System.out.println("\nthis is the dataTable arraylist");
//        for (ArrayList<Integer> p: dataTable) //testing to print out the arraylist
//        {
//            System.out.println(p);
//        }
    }

public static void convertToDFA( Set<Integer> mainSet )
{
    Integer [] set = new Integer[mainSet.size()];
    mainSet.toArray(set);
    System.out.print("DFA: ");
    printSubsets(set);
}

    //read the file and save to an arraylist
public static void readFile ()
    {
        try {
            Scanner sc = new Scanner(new File("Test_2.txt")); // create a scanner to read in .txt file

            while (sc.hasNextLine()) {
                ArrayList<Integer> newSet = new ArrayList <>();//temp arraylist of Integers
                String temp = sc.nextLine();
                ArrayList<Character> chars = new ArrayList <>();//temp arrayList of characters

               for (Character c : temp.toCharArray())// make a character array and search for only numbers in ascii
               {
                   if(c >=48 && c <58) //Add only if a number 0-9
                   {
                       newSet.add(Character.getNumericValue(c));//Convert Character into Int
                   }
               }
                dataTable.add(newSet);
            }
            //close file
            sc.close();
        }
        //catch if IO error
        catch (IOException e)
        {
            System.out.println(e);
        }
    }


    // Print all subsets using a bit wise
    static void printSubsets(Integer set[])
    {
        int n = set.length;

        // Run a loop for printing all 2^n subsets one by one
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1 so when we 'and' them with the
                // subset number we get which numbers are present in the subset and which are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
                if (i==0) {
                    System.out.print("Empty");
            }
            System.out.print("}");
        }
    }
}
