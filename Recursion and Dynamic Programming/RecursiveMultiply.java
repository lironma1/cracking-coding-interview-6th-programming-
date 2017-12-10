package recursion.and.dynamic.programming;

import java.util.*;
/**
 *
 * @author liron
 * Write a recursive function to multiply two positive integers without using
 * the * operator (or / operator). You can use addition, subtraction,
 * and bit shifting, but you should minimize the number of those operations.
 */
public class RecursiveMultiply {
    
    // using recursion, we can multiply two integers with the given constraints.
    // To multiply x and y, recursively add x y times.
    // Time Complexity of O(y) where y is the second argument 
    // to function multiply().
    public static int multiply(int x, int y)
    {
        if(y == 0) return 0;
        else if(y > 0) return (x + multiply(x, y -1));
        else return -multiply(x, -y);
    }
    // multiply two integers by count the number of squares in this grid a*b
    public static int minProduct(int a, int b)
    {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }
    private static int minProductHelper(int smaller, int bigger)
    {
        if(smaller == 0) return 0; // 0* bigger = 0
        else if(smaller == 1) return bigger; // 1* bigger = bigger
        
        // Compute half. If uneven, compute other half. If even, double it.
        int s = smaller >> 1; // Divide by 2
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if (smaller% 2 == 1)
            side2 = minProductHelper(smaller - s, bigger);
        return side1 + side2;
    }
    
    

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
    
        System.out.println(multiply(6, 7));
        System.out.println(minProduct(5, 11));
    }
    */
}
