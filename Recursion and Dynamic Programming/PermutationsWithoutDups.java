package recursion.and.dynamic.programming;

import java.util.*;
/**
 *
 * @author liron
 * Write a method to compute all permutations of a string of unique characters.
 */
public class PermutationsWithoutDups {
    
    /*
     * Naive recursion:
     * Solve for f(n - 1), and then push a(n) into every spot
     * in each of these strings.
     * Time Complexity of O(n!)
     */
    public static ArrayList<String> getPerms(String str)
    {
        if(str == null) return null;
        
        ArrayList<String> permutations = new ArrayList<String>();
        // base case
        if(str.isEmpty())
        {
            permutations.add("");
            return permutations;
        }
        ArrayList<String> words = getPerms(str.substring(1));
        for(String word : words)
            for(int i = 0; i <= word.length(); i++)
            {
                permutations.add(word.substring(0,i) +
                        str.charAt(0) +
                        word.substring(i));
            }
        return permutations;
    }
    
    //Better recursion, backtracking
    public static ArrayList<String> getPermutations(String str)
    {
        if(str == null) return null;
        ArrayList<String> permutations = new ArrayList<String>();
        Permutations(permutations, "", str.toCharArray());
        return permutations;
    }
    
    private static void Permutations(ArrayList<String> permutations, String curr, char[] s)
    {
        if(curr.length() == s.length) permutations.add(curr);
        else
            for(int i = 0;i < s.length; i++)
            {
                if(s[i] == '\0') continue;
                char ch = s[i];
                Permutations(permutations, curr + ch, s);
                s[i] = ch;
            }
    }

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
    
        System.out.println(getPerms("ab12"));
    }
    */
}
