package sorting.and.searching;

import java.util.*;
/**
 *
 * @author liron
 * You are given two sorted arrays, A and B, 
 * where A has a large enough buffer at the end to hold B. 
 * Write a method to merge B into A in sorted order.
 */
public class SortedMerge {
    
    public static void merge(int[] a, int[] b, int lastA)
    {
        int lastB = b.length - 1; // Index of last element in array b
        int indexMerged = lastA + b.length; // end of merge array
        
        while(lastB >= 0)
        {
            if(lastA >= 0 && a[lastA] > b[lastB])
            {
                a[indexMerged] = a[lastA];
                lastA--;
            }
            else
            {
                a[indexMerged] = b[lastB];
                lastB--;
            }
            indexMerged--;
        }   
    }
    
    public static void printArray(int[] a) 
    {
        if (a == null) 
            System.out.print("error");
        else 
            for(int n : a) 
                System.out.print(n + " ");       
        System.out.println();
    }
    

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        int[] a = {1,3,4,5,6,0,0,0,0,0,0,0,0,0,0};
        int[] b = {2,3,3,7};
        merge(a, b, 4);
        printArray(a);
    }
    */
}
