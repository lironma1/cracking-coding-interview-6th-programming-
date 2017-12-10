package recursion.and.dynamic.programming;

import java.util.*;

/**
 *
 * @author liron
 * A magic index in an array A[ 1 .•. n-1] is defined to be an index 
 * such that A[i] = i. 
 * Given a sorted array of distinct integers, 
 * write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndex {
    
    //Time Complexity of O(log n)
    public static int getMagicIndex(int[] array )
    {
        return getMagicIndex(array, 0, array.length -1);
    }
    
    private static int getMagicIndex(int[] array, int start, int end)
    {
        if(end < start) return -1;
        int mid = (start + end)/2;
        if(array[mid] == mid) return mid;
        else if(array[mid] > mid)
            return getMagicIndex(array, start, mid - 1);
        else
            return getMagicIndex(array, mid + 1, end);
    }
    
    // Time Complexity of O(n), no better than a linear scan
    public static int getMagicIndexDup(int[] array)
    {
        return getMagicIndexDup(array, 0, array.length - 1);
    }
    
    private static int getMagicIndexDup(int[] array, int start, int end)
    {
        if(end < start) return -1;
        
        int midIndex = (start + end)/2;
       
        if(array[midIndex] == midIndex) return midIndex;
        
        // search left
        int result = getMagicIndexDup(array, start, 
                Math.min(midIndex - 1, array[midIndex]));
        
        // search right
        if(result == -1)
            result = getMagicIndexDup(array, 
                    Math.max(midIndex + 1, array[midIndex]) , end);
        
        return result;
        
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        System.out.println(getMagicIndex(
                new int[] {-1, 0, 1, 3, 5, 7, 9}));
        System.out.println(getMagicIndexDup(
                new int[] {-1,0,2,2,2,2,3,4,6,9,11,12,13}));
        System.out.println(getMagicIndexDup(
                 new int[] {-10,-5,2,2,2,3,4,7,9,12,13}));
    }
    */
}
