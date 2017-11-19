
package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBST {
    /**
     * 
     * @param node
     * @return true is tree is BST, false if not.
     *the Method traverses down the tree keeping track of the 
     * narrowing min and max allowed values as it goes,
     * looking at each node only once. 
     * The initial values for min and max should be INT_MIN and INT_MAX
     * Time Complexity: O(n)
     * Auxiliary Space O(n)
     */
    public static boolean isBST (TreeNode node)
    {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST (TreeNode node, int min, int max)
    {
        if(node == null) return true;   
        if(node.value < min || node.value > max) return false;
        return isBST(node.left, min, node.value) && isBST(node.right,node.value, max);
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
         
         //     4
         //    / \
         //   2   5
         //  / \
         // 1   3
         
         TreeNode tn1 = new TreeNode(2), tn2 = new TreeNode(3), 
                 troot = new TreeNode(4);
         tn1.left = new TreeNode(1); tn1.right = tn2;
         troot.left = tn1; troot.right = new TreeNode(5);
         TreeNode.printTree(troot);
         System.out.println(isBST(troot));
    }
    */
}
