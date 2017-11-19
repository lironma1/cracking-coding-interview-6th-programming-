package trees.and.graphs;
import java.util.*;
/**
 *
 * @author liron
 * Design an algorithm and write code to find the first common ancestor 
 * of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. 
 * NOTE: This is not necessarily a binary search tree.
 */
public class FirstCommonAncestor {
    
    public static TreeNode firstCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2)
    {
        if(root == null) return null;
        if(root == node1 &&contains(root, node2)||
                root == node2 && contains(root,node1)) return root;
        boolean node1OnLeft = contains(root.left,node1),
                node2OnLeft = contains(root.left,node2);
        if(node1OnLeft && node2OnLeft)
           return firstCommonAncestor(root.left, node1, node2);
        else if(!node1OnLeft && !node2OnLeft)
           return firstCommonAncestor(root.right, node1, node2);
        else
            return root;
    }
  
    
    
    private static boolean contains(TreeNode root, TreeNode node)
    {
        if(root == null) return false;
        if(root == node) return true;
        return contains(root.left, node) || contains(root.right, node);
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
        n3 = new TreeNode(3), n4 = new TreeNode(4), n5 = new TreeNode(5),       
        n6 = new TreeNode(6), n7 = new TreeNode(7);
        
        n2.left = n1; n2.right = n3; n4.left = n2; n4.right = n5; n3.left = n6;
        n5.right = n7;
         
        TreeNode.printTree(n4);
        System.out.println();
        
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s",
                n1, n6, firstCommonAncestor(n4, n1, n6)));
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s", 
                n1, n7, firstCommonAncestor(n4, n1, n7)));
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s", 
                n4, n5, firstCommonAncestor(n4, n4, n5)));
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s", 
                n5, n5, firstCommonAncestor(n4, n5, n5)));

    }
    */
}
