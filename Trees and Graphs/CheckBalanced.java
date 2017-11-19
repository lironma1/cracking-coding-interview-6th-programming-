
package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question,
 * a balanced tree is defined to be a tree such that the heights 
 * of the two subtrees of any node never differ by more than one.
 */
public class CheckBalanced {

    private static int getHeight(TreeNode node)
    {
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    
    //top to bottom search : O(n^2)
    public static boolean isBalanced(TreeNode node)
    {
        if(node == null) return true;
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 &&
                isBalanced(node.left) &&
                 isBalanced(node.right);
    }
    
    public static boolean isBalanced2(TreeNode node)
    {
        return getHeightBalanced(node) != -1;
    }
    
    private static int getHeightBalanced(TreeNode node)
    {
        if(node == null) return 0;
        int leftHeigh = getHeightBalanced(node.left), 
                rightHeigh = getHeightBalanced(node.right);
        if(leftHeigh == -1 || rightHeigh == -1) return -1;
        if(Math.abs(leftHeigh - rightHeigh) > 1) return -1;
        return 1 + Math.max(leftHeigh, rightHeigh);
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
       
         //     4
         //    / \
         //   1   5
         //  / \
         // 2   3
         
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(3), r = new TreeNode(4);
        n1.left = new TreeNode(2); n1.right = n2;
        r.left = n1; r.right = new TreeNode(5);
        TreeNode.printTree(r);
        System.out.println(isBalanced(r) + " ");
        System.out.println(isBalanced2(r));
         

         //     4
         //    / \
         //   1   5
         //  / \
         // 2   3
         //      \
         //       6

        n2.right = new TreeNode(6);
        TreeNode.printTree(r);
         System.out.println(isBalanced(r) + " ");
         System.out.println(isBalanced2(r));
    }
    */
}
