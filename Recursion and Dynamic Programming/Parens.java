package recursion.and.dynamic.programming;

import java.util.*;
/**
 *
 * @author liron
 * 
 * Implement an algorithm to print all valid (i.e., properly opened and closed) 
 * combinations of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 * 
 */
public class Parens {
    
    public static HashSet<String> getParens(int n)
    {
        if (n < 0) return null;
        HashSet<String> result = new HashSet<String>();
        if (n == 0) {
            result.add("");
            return result;
        }
        HashSet<String> lastParens = getParens(n - 1);
        for (String parens : lastParens) 
            for (int i = 0; i <= parens.length(); ++i) 
                result.add(parens.substring(0, i) +
                           "()" +
                           parens.substring(i));      
        return result;
    }
    
    public static ArrayList<String> generateParens(int n)
    {
        char[] str = new char[n*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, n, n, str, 0);
        return list;
    }
    
    private static void addParen(ArrayList<String> list, int leftRem, 
            int righRem, char[] str, int index)
    {
        if(leftRem < 0 || righRem < 0) return;
        if(leftRem == 0 && righRem == 0) list.add(String.copyValueOf(str));
        if(leftRem > 0)
        {
            // add left and recurse
            str[index] = '(';
            addParen(list, leftRem - 1, righRem, str, index + 1);
        }
        if(righRem > leftRem)
        {
            // add righ and recurse
            str[index] = ')';
            addParen(list, leftRem, righRem - 1, str, index + 1);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        System.out.println(getParens(3));
        System.out.println(generateParens(3));
    }
    */
}
