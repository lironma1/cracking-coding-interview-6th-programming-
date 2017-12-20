package sorting.and.searching;

import java.util.*;
/**
 *
 * @author liron
 * In an array of integers, a "peak" is an element which is greater than or 
 * equal to the adjacent integers and a "valley" is an element which is 
 * less than or equal to the adjacent integers. 
 * For example, 
 * in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. 
 * Given an array of integers,
 * sort the array into an alternating sequence of peaks and valleys.
 * EXAMPLE
 * Input: {5, 3, 1, 2, 3}
 * Output: {5, 1, 3, 2, 3}
 */
public class PeaksAndValleys {
    
    /**
     * Suboptimal Solution
     * 1. Sort the array in ascending order.
     * 2. Iterate through the elements, starting from index 1 (not 0) 
     * and jumping two elements at a time.
     * 3. At each element, swap it with the previous element.
     *  time complexity O(n log n)
     * @param array
     */
    public static void sortValleyPeak(int[] array)
    {
        Arrays.sort(array);
        for(int i = 1; i < array.length; i += 2 )
            swap(array,i - 1,i);
    }
    
    private static void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    /**
     * Optimal Solution
     * operate on an unsorted array.
     * @param array
     * time complexity O(n)
     */
    public static void sortValleyPeak2(int[] array)
    {
        for(int i = 1; i < array.length; i += 2)
        {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if(i != biggestIndex )
                swap(array, i, biggestIndex);
        }
    }
    
    private static int maxIndex(int[] array,int a, int b, int c)
    {
        int len = array.length;
        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;
        
        int max = Math.max(aValue, Math.max(bValue, cValue));
        if(aValue == max) return a;
        else if(bValue == max) return b;
        else return c;
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
