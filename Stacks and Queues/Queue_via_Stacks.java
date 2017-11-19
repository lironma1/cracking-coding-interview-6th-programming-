package stacks.and.queues;

import java.util.*;

/**
 *
 * @author liron
 * Implement a MyQueue class which implements a queue using two stacks
 */
public class Queue_via_Stacks {
    
    private static final int LOAD_FACTOR = 10;
    private Stack<Integer> head = new Stack<Integer>();
    private Stack<Integer> tail = new Stack<Integer>();
    
    public void enqueue(int item)
    {
        rebalance();
        tail.push(item);
    }
    
     public int dequeue() 
     {
        rebalance();
        if (head.isEmpty())
            throw new IllegalStateException("Queue is empty!");
        
        return head.pop();
    }
    
     public void rebalance() 
     {
        if (tail.size() >= LOAD_FACTOR && tail.size() >= 2 * head.size()
                || head.isEmpty())
            while (!tail.isEmpty() )
                head.push(tail.pop());
    }
     
    public int peekHead() 
    {
        if (head.isEmpty())
            throw new IllegalStateException("Queue is empty!");

        return head.peek();
    }

    public int peekTail() 
    {
        if (head.isEmpty())
            throw new IllegalStateException("Queue is empty!");

        return tail.peek();
    }

    public int size()
    {
        return head.size() + tail.size();
    }
    
    public void printQueue(boolean showBoundary) 
    {
        System.out.print("[HEAD] ");
        
        for (int i = head.size() - 1; i >= 0; --i)
            System.out.print(head.get(i) + " ");
        
        if (showBoundary)
            System.out.print("| ");
        
        for (int item : tail)
            System.out.print(item + " ");
            
        System.out.println("[TAIL]");
        System.out.println();
    }
    
    public void printQueue() 
    {
        printQueue(true);
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
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
    }
    */
}
