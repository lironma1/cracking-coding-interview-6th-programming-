package sorting.and.searching;
import java.util.*;
/**
 *
 * @author liron
 * Write a method to sort an array of strings so that 
 * all that anagrams are next to each other.
 */
public class GroupAnagrams {

    public static void sort(String[] array)
    {
        HashMap<String, ArrayList<String>> map = 
                new HashMap<String, ArrayList<String>>();
        for(String s : array)
        {
            char[] chars;
            chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        
        int i = 0;
        for(String key : map.keySet())
            for(String s : map.get(key))
                array[i++] = s;
    }
          
    public static void printArray(String[] a)
    {
        if (a == null)
            System.out.print("error");
        else
            for(String n : a) 
                 System.out.print(n + " ");
         System.out.println();
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
    
        String[] array = {"acb", "ijh", "abc", "iop", "cab", "pio", "hij"};
        sort(array);
        printArray(array);
    }
    */
}
