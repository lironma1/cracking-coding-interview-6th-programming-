package trees.and.graphs;

import java.util.*;

/**
 *
 * @author liron
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth 
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepths {
    
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        
        if(root != null) current.add(root);
        while(!current.isEmpty())
        {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents)
            {
                if(parent.left != null) current.add(parent.left);
                if(parent.right != null) current.add(parent.right);
            }
        }
        return result;
    }
    
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            LinkedList<TreeNode> level = new LinkedList<TreeNode>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.remove();
                level.add(node);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
    
    

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
    }
    */
}