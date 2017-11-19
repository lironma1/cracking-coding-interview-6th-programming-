
package stacks.and.queues;

import java.util.*;

/**
 *
 * @author liron
 * Write a program to sort a stack such that the smallest items are on the top. 
 * You can use an additional temporary stack,
 * but you may not copy the elements into any other 
 * data structure (such as an array). 
 * The stack supports the following operations: push, pop, peek, and is Empty.
 * run time O(n^2), space O(n)
 */
public class SortStack {
    
    public static Stack<Integer> sortStack (Stack<Integer> stack)
    {
        Stack<Integer> result = new Stack<Integer>();
        
        while(!stack.isEmpty())
        {
            int item = stack.pop();
            while(!result.isEmpty() && item > result.peek())
                stack.push(result.pop());
            result.push(item);
        }
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
      
        SortStack temp = new SortStack();
        Integer[] a = {2,6,5,4,1,3,8,7};
        Stack<Integer> stack3 = new Stack<Integer>();
        stack3.addAll(Arrays.asList(a));
        Stack<Integer> stack4 = temp.sortStack(stack3);
        System.out.println(stack4.peek());
    
    }
    */
}
