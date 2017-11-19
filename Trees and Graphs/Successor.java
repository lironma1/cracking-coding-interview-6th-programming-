
package trees.and.graphs;

import java.util.*;

/**
 *
 * @author liron
 * Write an algorithm to find the "next" node (i.e., in-order successor)
 * of a given node in a binary search tree. 
 * You may assume that each node has a link to its parent.
 */
public class Successor {
    
    public static TreeNode inorderSuccessor(TreeNode node) 
    {
        if(node == null) return null;  
        
        // case 1: node has right subtree ->
        //         return leftmost node of right subtree
        if(node.right != null) return leftmostChild(node.right);
        
        // case 2:   node has no right subtree
        // case 2.1: node is left child of its parent ->
        //           just return its parent
        // case 2.2: node is right child of its parent ->
        //           node goes up until n is left child of its parent,
        //           then return this parent
        // case 3:   node is the last node in traversal ->
        //           return root's parent, ie., null
        while (node.parent != null && node.parent.right == node)
            node = node.parent;
        return node.parent;
    }
    
    private static TreeNode leftmostChild(TreeNode node)
    {
        if(node.left == null) return node;
        return leftmostChild(node.left);
    }
    
    
    public static TreeNode preorderSuccessor(TreeNode node) {

        if (node == null) return null;

        // case 1: node has a child ->
        //         just return that child (left if exists, otherwise right)
        if (node.left != null) return node.left;

        else if (node.right != null) return node.right;

        // case 2: node has no child ->
        //         node climbs up until reaching a parent that has a right child
        //         (which is not n), then return this right child
        while (node.parent != null && (node.parent.right == null || node.parent.right == node)) {

            node = node.parent;

        }

        // case 3: n is the last node in traversal ->
        //         return root's parent, ie., null
        if (node.parent == null) return null;
        return node.parent.right;
    }
    
     public static TreeNode postorderSuccessor(TreeNode node) {

        // case 1: node is the last node in traversal ->
        //         return root's parent, ie., null
        if (node == null || node.parent == null) return null;
        
        // case 2:   node is left child of its parent ->
        //           just return parent
        // case 3:   node is right child of its parent
        // case 3.1: parent has no right child ->
        //           just return parent
        if (node.parent.right == node || node.parent.right == null) return node.parent;

        // case 3.2: parent has right child ->
        //           return leftmost bottom node of parent's right subtree
        return leftmostBottomChild(node.parent.right);
    }



    private static TreeNode leftmostBottomChild(TreeNode node) 
    {
        if (node.left == null && node.right == null) return node;
        if (node.left != null)
            return leftmostBottomChild(node.left);
        else 
            return leftmostBottomChild(node.right);    
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
    
       TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2),
         n3 = new TreeNode(3), n4 = new TreeNode(4),
                n5 = new TreeNode(5);
        n2.left = n1; n2.right = n3; n1.parent = n2; n3.parent = n2;
        n4.left = n2; n4.right = n5; n2.parent = n4; n5.parent = n4;
        TreeNode.printTree(n4);
        TreeNode n = n4;
        
        System.out.print("pre-order:  ");

        while (n != null) 
        {
            System.out.print(n + " ");
            n = preorderSuccessor(n);
        }
        
        System.out.print("\nin-order:   ");
        n = n1;
        
        while (n != null)
        {
            System.out.print(n + " ");
            n = inorderSuccessor(n);
        }
        
        System.out.print("\npost-order: ");
        n = n1;
        
        while (n != null) 
        {
            System.out.print(n + " ");
            n = postorderSuccessor(n);
        }
    }
    */
}
