/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees.and.graphs;

/**
 *
 * @author liron
 */
public class TreeNode {
    
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    
    public TreeNode(int value)
    {
        this.value = value;
    }
    
    public String toString()
    {
        return String.valueOf(value);
    }
    
    public static void printTree(TreeNode node)
    {
        if(node == null) return;
        System.out.println(node.value);
        printTree(node.left, 0, true);
        printTree(node.right, 0, false);
    }
    
    public static void printTree(TreeNode node, int level, boolean isLeft)
    {
        if(node == null) return;
        for(int i = 0; i < level; ++i) System.out.print(" ");
        if(isLeft) 
            System.out.println("/- " + node.value);
        else
            System.out.println("\\- " + node.value);
        printTree(node.left, level + 1, true);
        printTree(node.right, level + 1, false);
    }  
}