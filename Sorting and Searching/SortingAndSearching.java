package sorting.and.searching;

import java.util.*;
/**
 *
 * @author liron
 */
public class SortingAndSearching {
    
    
    public static void printArray(int[] a) 
    {
        if (a == null) 
            System.out.print("error");
        else 
            for(int n : a) 
                System.out.print(n + " ");       
        System.out.println();
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
    
     public static void printArray(int[][] a) 
     {
        for (int[] row : a) 
        {
            for (int col : row)
                 System.out.print(col + " ");
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int[] a = {1,3,4,5,6,0,0,0,0,0,0,0,0,0,0};
        int[] b = {2,3,3,7};
        SortedMerge.merge(a, b, 4);
        printArray(a);
        System.out.println("-------------------------------------");
        
        String[] array = {"acb", "ijh", "abc", "iop", "cab", "pio", "hij"};
        GroupAnagrams.sort(array);
        printArray(array); 
        System.out.println("-------------------------------------");
        System.out.println(SearchInRotatedArray.search(
              new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 0, 11, 5));
        System.out.println("-------------------------------------");
        String[] strings = 
        {"at", "", "", "", "ball","", "", "car", "", "", "dad", "", ""};
        System.out.println(SparseSearch.search(strings, "ball"));
        System.out.println("-------------------------------------");
        int[][] m = {{15, 20, 40, 85},
                     {20, 35, 80, 95},
                     {30, 55, 95, 105},
                     {40, 80, 100, 120}};
        
        printArray(SortedMatrixSearch.findElement(m, 55));
        printArray(SortedMatrixSearch.findElement(m, 121));
        System.out.println("-------------------------------------");
        RankFromStream obj = new RankFromStream();
        obj.track(5); obj.track(1); obj.track(4); obj.track(4); obj.track(4);
        obj.track(5); obj.track(9); obj.track(7); obj.track(13); obj.track(3);
        System.out.println(obj.getRankOfNumber(1));
        System.out.println(obj.getRankOfNumber(3));
        System.out.println(obj.getRankOfNumber(4));
        System.out.println("-------------------------------------");
    }
    
}
