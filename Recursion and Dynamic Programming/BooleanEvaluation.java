package recursion.and.dynamic.programming;

import java.util.*;
/**
 *
 * @author liron
 * Given a boolean expression consisting of the symbols 0 (false), 1 (true), & 
 * (AND), I (OR), and /\ (XOR), and a desired boolean result value result, 
 * implement a function to count the number of ways of parenthesizing 
 * the expression such that it evaluates to result. 
 * The expression should be fully parenthesized 
 * (e.g.,(0) ^(1)) but not extraneously (e.g.,(((0))^(1))).
 * EXAMPLE
 * countEval("l/\01011", false) -> 2
 * countEval("0&0&0&1All0", true)-> 10
 */
public class BooleanEvaluation {
    /**
     * SOLUTION
     * Iterate through all operators, dividing the expression into
     * left/right subexpressions. 
     * Evaluate left/right subexpressions recursively, 
     * according to &, |, ^ rules.1
     * and using hash table. 
     * to store the result of countEval (expression, result) 
     * for each expression and result. 
     * If we see an expression that we've 
     * calculated before, we just return it from the cache.
     * @param s
     * @param result
     * @param memo
     * @return 
     */
    public static int countEval(String s, boolean result, 
            HashMap<String,Integer> memo)
    {
        if(s.length() == 0) return  0;
        if(s.length() == 1) return stringToBool(s) == result? 1 : 0;
        if(memo.containsKey(result + s)) return memo.get(result + s);
        
        int ways = 0;
        
        for(int i = 1; i < s.length(); i += 2)
        {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());
            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            
            int totalTrue = 0;
            switch (c) {
                case '^':
                    totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
                    break;
                case '&':
                    totalTrue = leftTrue * rightTrue;
                    break;
                case '|':
                    totalTrue = leftTrue * rightTrue + leftFalse * rightTrue +
                            leftTrue * rightFalse;
                    break;
                default:
                    break;
            }
            
            int subWays  = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        memo.put(result + s, ways);
        return ways;
    }
    
    private static boolean stringToBool(String s)
    {
        return s.equals("1");
    }
    

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        HashMap<String, Integer> memo = new HashMap<String, Integer>() ;
        System.out.println(countEval("1^0|0|1", true, memo));
    }
    */
}
