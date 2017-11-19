
package stacks.and.queues;

import java.util.*;
//import static helpers.Printer.*;
/**
 *
 * @author liron
 * Three in One: Describe how you could use a single array
 * to implement three stacks.
 */
public class ThreeInOne {
    
    private static final int STACK_SIZE = 50;
    private static final int STACK_NUM = 3;
    private static int[] stackPointers  = new int[STACK_NUM];;
    static {Arrays.fill(stackPointers, -1); }
    private int[]  buffer = new int[this.STACK_SIZE * STACK_NUM];

    
    public void push(int stackNum, int item)
    {
        if(isFull(stackNum))
            throw new IllegalArgumentException("Stack " + stackNum + " is full!");
        ++stackPointers[stackNum];
        buffer[getBufferIndex(stackNum)] = item;
    }
    
    public int pop(int stackNum) {

        int val = peek(stackNum);
        --stackPointers[stackNum];

        return val;
    }
    
    public int peek(int stackNum) {

        if (isEmpty(stackNum))
            throw new IllegalArgumentException("Stack " + stackNum + " is empty!");

        return buffer[getBufferIndex(stackNum)];
    }
    
    public boolean isEmpty(int stackNum) {

        if (stackNum < 0 || stackNum >= STACK_NUM)
            throw new IllegalArgumentException("Stack " + stackNum + " doen't exist!");

        return stackPointers[stackNum] <= -1;
    }
    
    
    public boolean isFull(int stackNum) {

        if (stackNum < 0 || stackNum >= STACK_NUM)
            throw new IllegalArgumentException("Stack " + stackNum + " doen't exist!");

        return stackPointers[stackNum] >= STACK_SIZE - 1;
    }
    
     private int getBufferIndex(int stackNum) {
         
        return stackPointers[stackNum] + stackNum * STACK_SIZE;
    }
    
     public void printStack(int stackNum) {

        if (stackNum < 0 || stackNum >= STACK_NUM)
            throw new IllegalArgumentException("Stack " + stackNum + " doen't exist!");

        int top = getBufferIndex(stackNum);
        int btm = stackNum * STACK_SIZE;

         System.out.print("Stack " + stackNum + ": ");

        for (int i = btm; i <= top; ++i)
            System.out.print(buffer[i] + " ");
        System.out.println("[TOP]");
    }
     
       public void printStacks() {

        for (int i = 0; i < STACK_NUM; ++i)
            printStack(i);   
    }
    
    /**
     * @param args the command line arguments
     */
       /*
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

    }
    */
}
