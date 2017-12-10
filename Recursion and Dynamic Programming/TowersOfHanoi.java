package recursion.and.dynamic.programming;

import java.util.*;

/**
 *
 * @author liron
 * In the classic problem of the Towers of Hanoi, 
 * you have 3 towers and N disks of different sizes which can 
 * slide onto any tower. 
 * The puzzle starts with disks sorted in ascending order of size from 
 * top to bottom (i.e., each disk sits on top of an even larger one). 
 * You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks 
 * from the first tower to the last using Stacks.
 */
public class TowersOfHanoi {
    
    private Stack<Integer> disks;
    private int index;
    
    public TowersOfHanoi(int index)
    {
        disks = new Stack<Integer>();
        this.index = index;
    }
    
    public int index()
    {
        return index;
    }
    
    public void add(int disk)
    {
        if(!disks.isEmpty() && disks.peek() <= disk)
            System.out.println("Error placing disk" + disk);
        else
            disks.push(disk);
    }
    
    public void moveTopTo(TowersOfHanoi tower)
    {
        int top = disks.pop();
        tower.add(top);
    }
    
    public void moveDisks(int n, TowersOfHanoi destination,TowersOfHanoi buffer)
    {
        if(n > 0)
        {
            moveDisks(n - 1, buffer, destination);
            moveTopTo( destination);
            buffer.moveDisks(n -1, destination, this);
        }
    }

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        int n = 3;
        TowersOfHanoi[] towers = new TowersOfHanoi[n];
        for(int i = 0; i < 3; i++)
            towers[i] = new TowersOfHanoi(i);
        
        for(int i = n - 1; i >= 0; i--)
            towers[0].add(i);
        
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
    */
}
