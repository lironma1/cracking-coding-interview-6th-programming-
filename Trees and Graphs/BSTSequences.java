package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 * A binary search tree was created by traversing 
 * through an array from left to right and inserting each element. 
 * Given a binary search tree with distinct elements, 
 * print all possible arrays that could have led to this tree.
 */
public class BSTSequences {

    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node)
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        
        if(node == null)
        {
            result.add(new LinkedList<Integer>());
            return result;
        }
        
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.value);
        
       // Recurse on left and right subtrees
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
        
        for(LinkedList<Integer> left : leftSeq )
            for(LinkedList<Integer> right : rightSeq )
            {
                ArrayList<LinkedList<Integer>>  weaved = 
                        new  ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        return result;
    }
    /**
     * Weave lists together in all possible ways.
     * This algorithm works by removing the head from one list, recursing,
     * and then doing the same thing with the other list.
     *  
     */
     private static void weaveLists(LinkedList<Integer> first, 
             LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results,
             LinkedList<Integer> prefix){
         
         // One list is empty. Add remainder to [a cloned] prefix and store result.
         if(first.isEmpty() || second.isEmpty())
         {
            LinkedList<Integer> result  = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
         }
         
         // Recurse with head of first added to the prefix. 
         // Removing the head will damage first,
         // so we'll need to put it back where we found it afterwards.
         int headFirst= first.removeFirst();
         prefix.addLast(headFirst);
         weaveLists(first, second, results, prefix); 
         prefix.removeLast();
         first.addFirst(headFirst);
         
         //Do the same thing with second, damaging and then restoring the list.
         int headSecond = second.removeFirst();
         prefix.addLast(headSecond);
         weaveLists(first, second, results, prefix);
         prefix.removeLast();
         second.addFirst(headSecond);
        
     }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);    
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        
        ArrayList<LinkedList<Integer>> allSequencesList = 
                new ArrayList<LinkedList<Integer>>();
        
        allSequencesList = allSequences(root);
     
        for(LinkedList<Integer> sequences : allSequencesList )
            System.out.println(Arrays.deepToString(sequences.toArray()));    
    }
    */
}
