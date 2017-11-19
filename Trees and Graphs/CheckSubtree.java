package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. 
 * Create an algorithm to determine ifT2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 
 * such that the subtree of n is identical to T2. That is, 
 * if you cut off the tree at node n, the two trees would be identical.
 */
public class CheckSubtree {
    
    public static boolean isSubtree(TreeNode t1, TreeNode t2)
    {
        if(t1== null) return false;
        if(t2 == null) return true;
        if(isIdentical(t1, t2)) return true;
        return isSubtree(t1.left, t2) || 
                isSubtree(t1.right, t2);
    }
    
    private static boolean isIdentical(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.value != node2.value) return false;
        return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
       
        //     4
        //    / \
        //   2   5
        //  / \   \
        // 1   3   7
        //    /
        //   6
        
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), 
                 n3 = new TreeNode(3), n4 = new TreeNode(4), 
                 n5 = new TreeNode(5), n6 = new TreeNode(6),
                 n7 = new TreeNode(7);                
        n2.left = n1; n2.right = n3; n4.left = n2; n4.right = n5; n3.left = n6;
        n5.right = n7;
        
        TreeNode.printTree(n4);
        System.out.println();
        System.out.println(isSubtree(n4, n2));
        System.out.println(isSubtree(n2, n5));
    }
    */
}
