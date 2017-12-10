package recursion.and.dynamic.programming;

import java.util.*;
import recursion.and.dynamic.programming.StackOfBoxes.Box;
/**
 *
 * @author liron
 */
public class RecursionAndDynamicProgramming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TripleStep.PrinterForCountWays(1);
        TripleStep.PrinterForCountWays(10);
        TripleStep.PrinterForCountWays(25);
        System.out.println("-------------------------------------");
        
        boolean[][] map = {{true, true, false, true},
            {true, true, true, true},
            {true, false, true, true},
            {true, true,false, true}};
        
        System.out.println(RobotInAGrid.getPath(map));
        System.out.println(RobotInAGrid.getPathDP(map));
        System.out.println("-------------------------------------");
        
        System.out.println(MagicIndex.getMagicIndex(
                new int[] {-1, 0, 1, 3, 5, 7, 9}));
        System.out.println(MagicIndex.getMagicIndexDup(
                new int[] {-1,0,2,2,2,2,3,4,6,9,11,12,13}));
        System.out.println(MagicIndex.getMagicIndexDup(
                 new int[] {-10,-5,2,2,2,3,4,7,9,12,13}));
        System.out.println("-------------------------------------");
        Integer[] a = {1,3,5,7};
        System.out.println(PowerSet.getSubset(Arrays.asList(a)));
        System.out.println(PowerSet.getSubset2(Arrays.asList(a)));
        System.out.println("-------------------------------------");
        System.out.println(RecursiveMultiply.multiply(6, 7));
        System.out.println(RecursiveMultiply.minProduct(5, 11));
        System.out.println("-------------------------------------");
        
        int n = 3;
        TowersOfHanoi[] towers = new TowersOfHanoi[n];
        for(int i = 0; i < 3; i++)
            towers[i] = new TowersOfHanoi(i);
        
        for(int i = n - 1; i >= 0; i--)
            towers[0].add(i);
        
        towers[0].moveDisks(n, towers[2], towers[1]);
        
        System.out.println(PermutationsWithoutDups.getPerms("ab12"));
        System.out.println(PermutationsWithoutDups.getPermutations("ab12"));
        System.out.println("-------------------------------------");
        System.out.println(Parens.getParens(3));
        System.out.println(Parens.generateParens(3));
        System.out.println("-------------------------------------");
        System.out.println(Coins.makeChange(4));
        System.out.println("-------------------------------------");  
        Box[] boxes = {
            new Box(1, 7, 4),
            new Box(2, 6, 9),
            new Box(4, 9, 6),
            new Box(10, 12, 8),
            new Box(6, 2, 5),
            new Box(3, 8, 5),
            new Box(5, 7, 7),
            new Box(2, 10, 16),
            new Box(12, 15, 9),
        };
        System.out.println(StackOfBoxes.buildTallestStack(boxes));
        System.out.println("-------------------------------------");
        HashMap<String, Integer> memo = new HashMap<String, Integer>() ;
        System.out.println(BooleanEvaluation.countEval("1^0|0|1", true, memo));
    }
    
}
