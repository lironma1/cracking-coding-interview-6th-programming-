
package trees.and.graphs;
import java.util.*;
/**
 *
 * @author liron
 * You are implementing a binary search tree class from scratch, which, 
 * in addition to insert, find, and delete, has a method getRandomNode() 
 * which returns a random node from the tree. 
 * All nodes should be equally likely to be chosen. 
 * Design and implement an algorithm for getRandomNode, 
 * and explain how you would implement the rest of the methods.
 */
public class RandomTreeNode {
    
    public int value;
    public RandomTreeNode left;
    public RandomTreeNode right;
    private int size = 0;
    
    public RandomTreeNode(int value)
    {
        this.value = value;
        size = 1;
    }
    
    public RandomTreeNode getRandomNode()
    {
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        
        if(index < leftSize) 
            return left.getRandomNode();
        else if(index == leftSize) 
            return this;
        else 
            return right.getRandomNode();
    }
    
    public void insertInOrder(int value)
    {
        if(value < this.value)
        {
            if(left == null)
                left = new RandomTreeNode(value);
            else
                left.insertInOrder(value);
        }
        else
        {
            if(right == null)
                right = new RandomTreeNode(value);
            else
                right.insertInOrder(value);       
        }
        size++;
    }
    
    public RandomTreeNode find(int value)
    {
        if(value == this.value)
            return this;
        else if(value <= this.value)
            return left != null ? left.find(value) : null;
        else if(value > this.value)
            return right != null ? right.find(value) : null;
        
        return null;
    }
    
    public int size() { return size;}
    public int value() { return value;}
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        // TODO code application logic here
    }
    */
}
