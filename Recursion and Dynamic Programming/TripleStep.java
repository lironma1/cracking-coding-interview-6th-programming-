package recursion.and.dynamic.programming;

import java.util.*;

/**
 *
 * @author liron
 * A child is running up a staircase with n steps and can hop either 1 step,
 * 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible 
 * ways the child can run up the stairs.
 * 
 */
public class TripleStep {
    
    // naive solution with Time Complexity of O(n^3) and O(n) space.
    public static int countWays(int stairs)
    {
        if(stairs < 0) return 0;
        if(stairs == 0) return 1;
        return countWays(stairs - 1) + countWays(stairs - 2) + countWays(stairs - 3);
    }
    
    // memoization top-down solution with Time Complexity of O(n) and O(n) space
    public static int countWaysMemo(int stairs)
    {
        return countWaysMemo(stairs, new int[stairs + 1]);
    }
    
    private static int countWaysMemo( int stairs, int[] cache)
    {
        if(stairs < 0 ) return 0;
        if(stairs == 0) return 1;
        if(cache[stairs] == 0)
            cache[stairs] = countWays(stairs - 1) + countWays(stairs - 2) + 
                    countWays(stairs - 3);
        return  cache[stairs];
    }
    
    //Dynamic Programming with rolling array, bottom-up solution with 
    //Time Complexity of O(n) and O(1) space
    public static int countWaysDynamicProgramming(int stairs)
    {
        if(stairs < 0) return 0;
        if(stairs == 0) return 1;
        if(stairs == 1) return 2;
        if(stairs == 2) return 4;
        
        int[] DynamicArray = new int[3];
        DynamicArray[0] = 1; DynamicArray[1] = 2; DynamicArray[2] = 4;
        for(int i = 3; i< stairs; i++ )
            DynamicArray[i%3] = DynamicArray[(i - 1)%3] + 
                    DynamicArray[(i - 2)%3]+ 
                    DynamicArray[(i -3)%3];
        
        return DynamicArray[(stairs - 1)%3];
    }
    
    public static void PrinterForCountWays(int stairs)
    {
        System.out.println("all the possible ways the child can run up"
                + " the staircase with " + stairs +" stairs");
        if(stairs <= 0)
            System.out.println("None!");
        else 
        {
            System.out.println("countWays: " + countWays(stairs));
            System.out.println("countWaysMemo: " + countWaysMemo(stairs));
            System.out.println("countWaysDynamicProgramming: " + 
                    countWaysDynamicProgramming(stairs));
        }
        System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        PrinterForCountWays(1);
        PrinterForCountWays(10);
        PrinterForCountWays(25);
    
    }
    */
}
