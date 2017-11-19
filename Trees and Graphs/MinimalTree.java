
package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class MinimalTree {
    
    public static TreeNode createBST(int[] array)
    {
        if(array == null) return null;
        return createBST(array, 0, array.length - 1);
    }
    
    private static TreeNode createBST(int[] array, int start, int end) 
    {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
       
        TreeNode node = new TreeNode(array[mid]);
        
        node.left = createBST(array, start, mid - 1);
        node.right = createBST(array, mid + 1, end);
        
        return node;
    }
    
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        TreeNode.printTree(createBST(new int[] {}));
        System.out.println();

        TreeNode.printTree(createBST(new int[] {0}));
        System.out.println();

        TreeNode.printTree(createBST(new int[] {0,1}));
        System.out.println();

        TreeNode.printTree(createBST(new int[] {0,1,2,3,4}));
        System.out.println();
        
        TreeNode.printTree(createBST(new int[] {-1,0,1,3,4,7,9}));
        System.out.println();
        
    }
    */
}
