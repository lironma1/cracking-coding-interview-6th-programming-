/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistssolutions;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data)
    {
        this.data = data;
        next = null;
    }
}



/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 */
class LinkedListQuestion1
{
    //Function to remove duplicates from unsorted linked list 
    public void removeDuplicate(Node head)
    {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();
       
        //Pick elements one by one
        Node current = head, prev = null;
        int currentData;
        
        while(current != null)
        {
            currentData = current.data;
            
            // If current value is seen before
            if(hs.contains(currentData))
                prev.next = current.next;
            else
            {
                hs.add(currentData);
                prev = current;
            }
            current = current.next;
        }
    }
    
    
    /**
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     * This code runs in O(1) space, but O(N^2) time.
     */
    public void followup(Node head)
    {
        Node current = head;
        
        while(current != null)
        {
            Node runner = current;
            while(runner.next != null)
            {
                if(runner.next.data == current.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
                
            }
              current = current.next;
        }
    } 
        
} 

/**
 * Implement an algorithm to find the kth to last element
 * of a singly linked list
 *
 */
 class LinkedListQuestion2
 {
     static int i =0;
     /*
     Method 1 (Use length of linked list)
     1) Calculate the length of Linked List. Let the length be len.
     2) Print the (len – k + 1)th node from the begining of the Linked List.
     Time Complexity: O(n) where n is the length of linked list.
     */
     public void printKthFromLast(Node head, int k)
     {
         int len = 0;
         Node temp = head;
         
         //count the number of nodes in Linked List
         while(temp != null)
         {
             temp = temp.next;
             len++;
         }
         
         //check if value of k is not more than length of the linked list
         if(len < k)
             return;
         
         temp = head;
         
         //get the (k-len+1)th node from the begining
         for(int j = 1; j < len - k + 1; j++)
             temp = temp.next;
         
         System.out.println("Node no. " + k + " from last is " + temp.data);
     }
     
     /*
     Method 2
     recursive code for the Method 1 
     Time Complexity: O(n) where n is the length of linked list.
     */
     public void printKthFromLastRecursive(Node head, int k)
     {
         i = 0 ;
         if(head == null)
             return;
        printKthFromLastRecursive(head.next, k);
        if(++i == k )
        {
            System.out.println("Node no. " + k + " from last is " + head.data);
        }
     }
     
     /*
     Method 3 (Use two pointers)
     Maintain two pointers – reference pointer and main pointer. 
     Initialize both reference and main pointers to head. 
     First move reference pointer to n nodes from head. 
     Now move both pointers one by one until reference pointer reaches end. 
     Now main pointer will point to nth node from the end. Return main pointer.
     */
     public void printKthFromLast2(Node head, int k)
     {
         Node main_ptr = head, ref_ptr = head;
         int count = 0;
         if(head != null)
         {
             while(count < k)
             {
                 if(ref_ptr == null)
                 {
                     System.out.println(k + " is greater than the number of nodes in the list");
                     return;
                 }
                 ref_ptr = ref_ptr.next;
                 count++;
             }
             while(ref_ptr != null)
             {
                 main_ptr = main_ptr.next;
                 ref_ptr = ref_ptr.next;
             }
             System.out.println("Node no. " + k + " from last is " + main_ptr.data);
         }
     }
     
 }

/**
* Implement an algorithm to delete a node in the middle 
* (i.e., any node but the first and last node,
* not necessarily the exact middle) 
* of a singly linked list, given only access to that node.
*/
class LinkedListQuestion3
{
    public boolean deleteMiddle(Node mid)
    {
        if(mid == null || mid.next == null)
            return false;
        Node next = mid.next;
        mid.data = next.data;
        mid.next = next.next;
        return true;
    }
}

/**
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before 
 * all nodes greater than or equal to x. 
 * If x is contained within the list the values of x only need to be after
 * the elements less than x (see below). 
 * The partition element x can appear anywhere in the
 * "right partition";
 * it does not need to appear between the left and right partitions.
 * 
 */
class LinkedListQuestion4 
{
    public Node partition(Node node, int x)
    {
        Node head = node;
        Node tail = node;
        
        while(node != null)
        {
           Node next=node.next;
           if(node.data < x)
           {
               /*Insert the node in the head*/
               node.next=head;
               head=node;
           }
           else{
              /*Append the node in the tail*/
              tail.next=node;
              tail=node;
           }
           tail.next = null;
           node=next;
        }
        return head;
    }
    
    public Node Partition2(Node node,int x)
    {
        Node beforeStart=null;
        Node beforeEnd=null;
        Node afterStart=null;
        Node afterEnd=null;
        while(node!=null)
        {
            Node next=node.next;
            node.next=null;
            if(node.data < x )
            {
                if(beforeStart==null)
                {
                    beforeStart=node;
                    beforeEnd=beforeStart;
                }
                else
                {
                    beforeEnd.next=node;
                    beforeEnd=node;
                }
            }
            else{
                if(afterStart==null)
                {
                    afterStart=node;
                    afterEnd=afterStart;
                }
                else{
                    afterEnd.next=node;
                    afterEnd=node;
                }
            }
            
            node=next;
        }
        
        if(beforeEnd==null)
        {
            return afterStart;
        }
        
        beforeEnd.next=afterStart;
        return beforeStart;
    }

}


/**
 * You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit 
 * is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 */
class LinkedListQuestion5
{
    //Recurse
    public Node addList(Node l1, Node l2 , int carry)
    {
        if(l1 == null && l2 == null)
            return null;
            
        Node result = new Node(0);
        int value = carry;
        
        if(l1 != null)
            value += l1.data;
        if(l2 != null)
            value += l2.data;
        
        result.data = value % 10;
        
        Node more = new Node(0);
        if(l1 != null || l2 != null)
            more = addList(l1 == null ? null : l1.next, l2 == null ? null : l2.next,value >= 10 ? 1 : 0);
        
        result.next = more;
        
        return result;
    }
}

/**
 * Implement a function to check if a linked list is a palindrome
 */
class LinkedListQuestion6 
{
    //Reverse and Compare
    private Node reverseAndClone(Node node)
    {
        Node head = null;
        while(node != null)
        {
            Node tmp = new Node (node.data); // clone
            tmp.next = head;
            head = tmp;
            node = node.next;
        }
        return head;
    }
    private boolean isEqual(Node one, Node two)
    {
        for(;one != null && two != null; one = one.next, two =  two.next)
            if(one.data != two.data)
                return false;
        
        return one == null && two == null;
    }
    
    public boolean isPalindrome(Node node)
    {
        Node reverse = reverseAndClone(node);
        return isEqual(node,reverse);
    }
}

/**
 * Intersection: Given two (singly) linked lists,
 * determine if the two lists intersect. 
 * Return the intersecting node.
 * Note that the intersection is defined based on reference,
 * not value. That is, 
 * if the kth node of the first linked list is the exact same node 
 * (by reference) as the jth node of the second linked list,
 * then they are intersecting.
 */
class LinkedListQuestion7 
{
    public boolean intersectingLists(Node head1, Node head2)
    {
        if(head1 == null || head2 == null) return false;
        
        Node tmp1 = head1, tmp2 = head2;
        
        while( tmp1 != null)
        {
            while(tmp2 != null)
            {
                if(tmp1 ==  tmp2) return true;
                tmp2 = tmp2.next;
            }
            tmp2 = head2;
            tmp1 = tmp1.next;
        }
        
        return false;
    }
}

/**
 * Given a circular linked list,
 * implement an algorithm that returns 
 * the node at the beginning of the loop.
 * 
 */
class LinkedListQuestion8
{
    // using hashing
    //Time Complexity: O(n) where n is the length of linked list
    public Node detectLoop(Node head)
    {
        Node loopNode = head;
        HashSet<Node> nodesList = new HashSet<>();
        
        while(loopNode != null)
        {
            //If we have already has this node
            //in hashmap it means their is a cycle
            //(Because you we encountering the
            //node second time).
            if(nodesList.contains(loopNode))
                return loopNode;
            
            //If we are seeing the node for
            //the first time, insert it in hash
            nodesList.add(loopNode);
            
            loopNode = loopNode.next;
        }
        
        return null;
    }
}
/**
 *
 * @author liron
 */
public class LinkedListsSolutions {

    
    static void printList(Node head)
    {
        while (head != null) 
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedListQuestion1 obj = new LinkedListQuestion1();
        LinkedListQuestion2 obj2 = new LinkedListQuestion2();
        LinkedListQuestion3 obj3 = new LinkedListQuestion3();
        LinkedListQuestion4 obj4 = new LinkedListQuestion4();
        LinkedListQuestion5 obj5 = new LinkedListQuestion5();
        LinkedListQuestion6 obj6 = new LinkedListQuestion6();
        LinkedListQuestion7 obj7 = new LinkedListQuestion7();
        LinkedListQuestion8 obj8 = new LinkedListQuestion8();
        
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);
        
        System.out.println("Linked list before removing duplicates :");
        printList(start);
        obj.followup(start);
        System.out.println("Linked list after removing duplicates ");
        printList(start);
        System.out.println("-------------------------------------");
        Node start2 = new Node(10);
        start2.next = new Node(12);
        start2.next.next = new Node(11);
        start2.next.next.next = new Node(13);
        start2.next.next.next.next = new Node(12);
        start2.next.next.next.next.next = new Node(11);
        start2.next.next.next.next.next.next = new Node(10);
        obj2.printKthFromLast(start2, 4);
        obj2.printKthFromLastRecursive(start2,3);
        obj2.printKthFromLast2(start2, 2);
        System.out.println("-------------------------------------");
        Node start3 = new Node(3);
        start3.next = new Node(5);
        start3.next.next = new Node(8);
        start3.next.next.next = new Node(5);
        start3.next.next.next.next = new Node(10);
        start3.next.next.next.next.next = new Node(2);
        start3.next.next.next.next.next.next = new Node(1);
        printList(start3);
        obj3.deleteMiddle(start3.next.next.next.next.next.next);
        printList(start3);
        System.out.println("-------------------------------------");
        Node start4 = new Node(1);
        start4.next = new Node(4);
        start4.next.next = new Node(3);
        start4.next.next.next = new Node(2);
        start4.next.next.next.next = new Node(5);
        start4.next.next.next.next.next = new Node(2);
        //start4.next.next.next.next.next.next = new Node(1);
        printList(start4);
        Node Partition = obj4.Partition2(start4, 3);
        printList(Partition);
        System.out.println("-------------------------------------");
        Node start5 = new Node(7);
        start5.next = new Node(1);
        start5.next.next = new Node(6);
        Node start6 = new Node(5);
        start6.next = new Node(9);
        start6.next.next = new Node(2);
        Node start7 = obj5.addList(start5, start6, 0);
        printList(start7);
        System.out.println("-------------------------------------");
        Node start8 = new Node(0);
        start8.next = new Node(1);
        start8.next.next = new Node(2);
        start8.next.next.next = new Node(3);
        start8.next.next.next.next = new Node(2);
        start8.next.next.next.next.next = new Node(1);
        start8.next.next.next.next.next.next = new Node(0);
        printList(start8);
        if(obj6.isPalindrome(start8))
             System.out.println("Is Palindrome");
        else
            System.out.println("Not Palindrome");
        System.out.println("-------------------------------------");
        
         // add nodes to list 1
        Node h1 = new Node(3);
        h1.next = new Node(6);
        h1.next.next = new Node(15);
        h1.next.next.next = new Node(15);
        h1.next.next.next.next = new Node(30);
       
        // add nodes to list 2
        Node h2 = new Node(10);
        h2.next =  h1.next.next.next;
        System.out.println(obj7.intersectingLists(h1, h2));
        
        System.out.println("-------------------------------------");
        Node start9 = new Node(1);
        start9.next = new Node(2);
        start9.next.next = new Node(3);
        start9.next.next.next = new Node(4);
        start9.next.next.next.next = new Node(5);
        start9.next.next.next.next.next = start9.next;
        
        if(obj8.detectLoop(start9) != null)
           System.out.println("Loop found " + obj8.detectLoop(start9).data); 
        else
            System.out.println("No Loop");

    }
    
}
