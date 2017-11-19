package stacks.and.queues;

import java.util.*;
/**
 *
 * @author liron
 */
public class StacksAndQueues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ThreeInOne stack = new ThreeInOne();
        stack.printStacks();
        System.out.println(System.lineSeparator());
        stack.push(0, -1); stack.push(0, -2); stack.push(0, -3);
        stack.push(1, 1); stack.push(1, 2); stack.push(1, 3);
        stack.push(2, 10); stack.push(2, 20); stack.push(2, 30); stack.push(2, 40);
        stack.printStacks();
        System.out.println(System.lineSeparator());
        System.out.println("Pop Stack 0: " + stack.pop(0));
        System.out.println("Pop Stack 1: " + stack.pop(1));
        System.out.println("Pop Stack 1: " + stack.pop(1));
        System.out.println("Pop Stack 2: " + stack.pop(2));
        System.out.println(System.lineSeparator());
        stack.printStacks();
        System.out.println(System.lineSeparator());
       
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
        
      
        Stack_of_Plates setOfStacks = new Stack_of_Plates();
        setOfStacks.push(1); setOfStacks.push(2); setOfStacks.push(3);
        setOfStacks.push(4); setOfStacks.push(5); setOfStacks.push(6);
        setOfStacks.push(7); setOfStacks.push(8); setOfStacks.push(9);
        setOfStacks.printStacks();
        System.out.println(System.lineSeparator());
        setOfStacks.popAt(1);
        setOfStacks.popAt(0);
        setOfStacks.printStacks();
                
        Queue_via_Stacks myQueue = new Queue_via_Stacks();
        myQueue.printQueue();

        for (int i = 1; i <= 6; ++i) 
        {
            System.out.println("Enqueue " + i);
            myQueue.enqueue(i);
        }

        myQueue.printQueue();

        for (int i = 1; i <= 3; ++i) 
        {
            int item = myQueue.dequeue();
            System.out.println("Dequeue " + item);
        }

        myQueue.printQueue();

        for (int i = 1; i <= 3; ++i) 
        {
            System.out.println("Enqueue " + i);
            myQueue.enqueue(i);
        }

        myQueue.printQueue();    
        
        SortStack temp = new SortStack();
        Integer[] a = {2,6,5,4,1,3,8,7};
        Stack<Integer> stack3 = new Stack<Integer>();
        stack3.addAll(Arrays.asList(a));
        Stack<Integer> stack4 = temp.sortStack(stack3);
        System.out.println(stack4.peek());
 
    } 
}
