package trees.and.graphs;
import java.util.*;
/**
 *
 * @author liron
 * You are given a binary tree in which each node contains an integer value
 * (which might be positive or negative). 
 * Design an algorithm to count the number of paths that sum to a given value. 
 * The path does not need to start or end at the root or a leaf, 
 * but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class PathsWithSum {
    
    public static LinkedList<LinkedList<TreeNode>> findSumPaths(TreeNode root, int target)
    {
         LinkedList<LinkedList<TreeNode>>  result = 
                 new LinkedList<LinkedList<TreeNode>>();
         findSumPaths(root,target, new LinkedList<TreeNode>(), result);
         return result;
    }
    
    public static void findSumPaths(TreeNode node, 
            int target, LinkedList<TreeNode> path, 
            LinkedList<LinkedList<TreeNode>> result )
    {
        if(node == null) return;
        path.add(node);
        int sum = 0;
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        for(int i = path.size() - 1; i >= 0; i--)
        {
            TreeNode tempNode = path.get(i);
            nodes.add(tempNode);
            sum += tempNode.value;
            if(sum == target)
                result.add((LinkedList<TreeNode>) nodes.clone());
        }   
        findSumPaths(node.left,  target, path, result);
        findSumPaths(node.right, target, path, result);
        path.removeLast();
    }
    
    public static void printResult(LinkedList<LinkedList<TreeNode>> result) 
    {
        for (LinkedList<TreeNode> path : result) 
        {
            for (TreeNode n : path)
                  System.out.print(n + " ");
            System.out.println();
        }
        System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {

        //     4
        //    / \
        //   5   2
        //  / \   \
        // 1   3   7
        // \   /  /
        //  8 6  9

        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), 
                 n3 = new TreeNode(3), n4 = new TreeNode(4), 
                 n5 = new TreeNode(5), n6 = new TreeNode(6),
                 n7 = new TreeNode(7), n8 = new TreeNode(8), 
                 n9 = new TreeNode(9);
    
        n4.left = n5; n4.right = n2; n5.left = n1; n5.right = n3; n1.right = n8;
        n3.left = n6; n2.right = n7; n7.left = n9;
        
        TreeNode.printTree(n4);
        System.out.println();
        LinkedList<LinkedList<TreeNode>> result = findSumPaths(n4, 9);
        printResult(result);
        result = findSumPaths(n4, 6);
        printResult(result);
    
    }
    */
}
