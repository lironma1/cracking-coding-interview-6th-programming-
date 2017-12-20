package sorting.and.searching;

/**
 *
 * @author liron
 * You have an array with all the numbers from 1 to N, 
 * where N is at most 32,000. The array may have duplicate entries 
 * and you do not know what N is. With only 4 kilobytes of memory available,
 * how would you print all duplicate elements in the array?
 */
public class FindDuplicates {
    
    class Bitset
    {
        int[] bitset;
        public Bitset(int size)
        {
            bitset = new int[(size >> 5) + 1]; // divide by 32
        }
        
        boolean get(int pos)
        {
            int wordNumber = (pos >> 5); // divide by 32
            int bitNumber = (pos & 0X1F); // mod 32
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;        
        }
        
        public void set(int pos)
        {
            int wordNumber = (pos >> 5); // divide by 32
            int bitNumber = (pos & 0X1F); // mod 32
            bitset[wordNumber] |= 1<< bitNumber;
        }
    }
    
    public void checkDuplicates(int[] array)
    {
        Bitset bs = new Bitset(32000);
        for(int i = 0; i < array.length; i++)
        {
            int num = array[i];
            int num0 = num - 1; // bitset starts at 0, numbers start at 1
            if(bs.get(num0))
                System.out.println(num);
            else
                bs.set(num0);
        }
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        // TODO code application logic here
    }
    */
}
