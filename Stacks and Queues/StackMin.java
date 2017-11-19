package stacks.and.queues;

import java.util.*;
/**
 *
 * @author liron
 * Stack Min: How would you design a stack which,
 * in addition to push and pop, 
 * has a function min which returns the minimum element? 
 * Push, pop and min should all operate in 0(1) time.
 */
public class StackMin extends Stack<Integer> {
    
    private Stack<Integer> min = new Stack<Integer>();
    
    public void push(int item)
    {  
        if(min.isEmpty() || item < min())
            min.push(item);
        super.push(item);
    }
    
    public Integer pop()
    {
        int item = super.pop();
        
        if(item == min())
            min.pop();
        
        return item;
    }
    
    public Integer min() 
    {
        return min.peek(); 
    }
      
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        StackMin stack2 = new StackMin();
        stack2.push(2);   System.out.println(stack2.min());
        stack2.push(-1);  System.out.println(stack2.min()); 
        stack2.push(3);   System.out.println(stack2.min()); 
        stack2.push(-10); System.out.println(stack2.min()); 
        stack2.pop();     System.out.println(stack2.min()); 
        stack2.pop();     System.out.println(stack2.min()); 
        stack2.push(-20); System.out.println(stack2.min()); 
        stack2.pop();     System.out.println(stack2.min()); 
        System.out.println(System.lineSeparator());
    }
    */
}
