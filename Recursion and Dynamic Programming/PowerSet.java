package recursion.and.dynamic.programming;
import java.util.*;
/**
 *
 * @author liron
 * Write a method to return all subsets of a set.
 */
public class PowerSet {
    
    /**
     * Naive recursion:
     * Compute P(n-1), clone the results, 
     * and then add a(n) to each of these cloned sets.
     * O(n2^n) time and space.
     * 
     * @param set
     * @return 
     */
    public static ArrayList<ArrayList<Integer>> getSubset(List<Integer> set)
    {
        if(set == null) return null;
        ArrayList<ArrayList<Integer>> result = 
                new ArrayList<ArrayList<Integer>>();
        // Base case - add empty set
        if(set.isEmpty())
        {  
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<ArrayList<Integer>> allSubsets = 
                getSubset(set.subList(1, set.size()));
        result.addAll(allSubsets);
        for(ArrayList<Integer> subsets : allSubsets)
        {
            ArrayList<Integer> newsubset = new ArrayList<Integer>(subsets);
            newsubset.add(set.get(0));
            result.add(newsubset);
        }
        return result;
    }
    
    /**
     * Bitmap:
     * Iterate through all numbers from 1 to 2^n 
     * and translate the binary representation 
     * of the numbers into a set.
     * O(2^n) time and space.
     */
    public static ArrayList<ArrayList<Integer>> getSubset2(List<Integer> set)
    {
        if (set == null) return null;
        ArrayList<ArrayList<Integer>> result = 
                new ArrayList<ArrayList<Integer>>();
        for(int bitmap = 0; bitmap < 1 << set.size(); bitmap++)
            result.add(getSubsetFromBitmap(set, bitmap));
        return result;
    }
    
    private static ArrayList<Integer> getSubsetFromBitmap(List<Integer> set, int bitmap)
    {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        while(bitmap > 0)
        {
            if((bitmap & 1) != 0)
                subset.add(set.get(index));
            bitmap >>= 1;
            index++;
        }
        return subset;
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        // TODO code application logic here
    }
    */
}
