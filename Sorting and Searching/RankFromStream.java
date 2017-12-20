package sorting.and.searching;

import java.util.*;
/**
 *
 * @author liron
 * Imagine you are reading in a stream of integers. 
 * Periodically, you wish to be able to look up the rank of a number x 
 * (the number of values less than or equal to x). 
 * Implement the data structures and algorithms to support these operations. 
 * That is, implement the method track(int x),
 * which is called when each number is generated, 
 * and the method getRankOfNumber(int x), 
 * which returns the number of values less than or equal to x 
 * (not including x itself).
 * EXAMPLE
 * Stream(in order of appearance):5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(l) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 * 
 */
public class RankFromStream {
    
    RankNode root = null;
    
     public void track(int number)
    {
        if(root == null)
            root = new RankNode(number);
        else
            root.insert(number);
    }
    
    public int getRankOfNumber(int number)
    {
        return root.getRank(number);
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
