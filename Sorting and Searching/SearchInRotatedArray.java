package sorting.and.searching;
import java.util.*;
/**
 *
 * @author liron
 * Given a sorted array of n integers that has been rotated an unknown number 
 * of times, write code to find an element in the array. 
 * You may assume that the array was originally sorted in increasing order.
 */
public class SearchInRotatedArray {
    /**
     * This code will run in O(log n) if all the elements are unique. 
     * However, with many duplicates, the algorithm is actually O( n)
     * @param a
     * @param left
     * @param right
     * @param x
     * @return 
     */
    public static int search(int[] a, int left, int right, int x)
    {
        if(right < left) 
            return -1;
        int mid = (left + right)/2;
        if(a[mid] == x) 
            return mid;
        /**
         * Either the left or right half must be normally ordered. 
         * Find out which side is normally ordered, and then use the normally 
         * ordered half to figure out which side to search to find x.
        */
        if(a[left] < a[mid])// left is normally ordered
        {
            if(a[left] <= x && x < a[mid])
                return search(a, left, mid - 1, x);
            else
                return search(a, mid + 1 , right, x);
        }
        else if(a[left] > a[mid]) // right is normally ordered
        {
            if(a[mid] < x && x <= a[right])
                return search(a, mid + 1 , right, x);
            else
                return search(a, left, mid - 1, x);
        }
        else if(a[left] == a[mid]) // left or right half is all repeats
        {
            if(a[mid] != a[right])
                return search(a, mid + 1 , right, x);
            else // we have to search both halves
            {
                int result = search(a, left, mid - 1, x);
                if(result == -1)
                    return search(a, mid + 1 , right, x);
                else
                    return result;
            }
        }
        return -1;
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
