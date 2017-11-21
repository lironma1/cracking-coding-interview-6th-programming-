package myhashtable;
/**
 *
 * @author liron
 */
// Java program to demonstrate implementation of our
// own hash table with chaining for collision detection
import java.util.ArrayList;

// a node of chains
class HashNode<K,V>
{
    K key;
    V value;
    
    // Reference to next node
    HashNode<K,V> next;
    
    // Constructor
    public HashNode(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}

// Class to represent entire hash table
class Map<K, V>
{
    //Array to store chains of array
    private ArrayList<HashNode<K, V>> bucketArray;
    
    //capacity of array list
    private int bucketCapacity;
    
    //// Current size of array list
    private int size;
    
    //Constructor (Initializes capacity, size and empty chains)
    public Map()
    {
        bucketArray = new ArrayList<>();
        bucketCapacity = 10;
        size = 0;
        
        // Create empty chains
        for(int i =0; i< bucketCapacity; i++)
            bucketArray.add(null);
    }

    public int getBucketCapacity() {
        return bucketCapacity;
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty()
    {
        return getSize() == 0;
    }
    
    //This implements hash function to find index
    // for a key
    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode % bucketCapacity;
        return index;
    }
    
    //Method to remove a given key
    public V remove(K key)
    {
        //Apply hash function to find index for given key
        int BucketIndex = getBucketIndex(key);
        
        //get head of chain
        HashNode<K, V> head = bucketArray.get(BucketIndex);
        
        // Search for key in its chain
        HashNode<K, V> prev = null;
        while(head != null)
        {
            //If Key found
            if(head.key.equals(key))
                break;
            
            //else keep moving in the chain
            prev = head;
            head = head.next;
        }
        
        // if key was not there
        if(head == null)
            return null;
        
        //reduce size
        size--;
        
        //remove key
        if(prev != null)
            prev.next = head.next;
        else
            bucketArray.set(BucketIndex, head.next);
        
        return head.value;
    }
    
    //returns value for a key
    public V get(K key)
    {
        //find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        
        //search key in chain
        while(head != null)
        {
            if(head.key.equals(key))
                return head.value;
            head = head.next;
        }
        // if key not found
        return null;
    }
    
    //adds a key value pair to hash
    public void add(K key, V value)
    {
        //find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        
        // Check if key is already present
        while(head != null)
        {
            if(head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        //insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        
        //if load factor goes beyond threshold, then double hash table size
        if((1.0 * size)/bucketCapacity >= 0.7)
        {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            bucketCapacity = 2 * bucketCapacity;
            size = 0;
            for(int i = 0; i < bucketCapacity; i++)
                bucketArray.add(null);
            for(HashNode<K, V> headNode : temp)
            {
                while(headNode != null)
                {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
public class MyHashTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Integer>map = new Map<>();
        map.add("this", 1);
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.getSize());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
    }
    
}
