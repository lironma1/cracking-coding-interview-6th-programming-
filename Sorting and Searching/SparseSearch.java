package sorting.and.searching;

/**
 *
 * @author liron
 * Given a sorted array of strings that is interspersed with empty strings, 
 * write a method to find the location of a given string.
 * EXAMPLE
 * Input: ball,{"at", "", "", "", "ball","", "", "car", "", "", "dad", "", ""}
 * Output: 4
 */
public class SparseSearch {
    
    public static int search(String[] strings, String str)
    {
        if(strings == null || str == null) return -1;
        return search(strings, str, 0, strings.length - 1);
    }
    
    private static int search(String[] strings, String str, int low, int high)
    {
        if(low > high) return -1;
        int mid = (low + high)/2;
        
        // if strings[mid] is empty, find closest non-empty string.
        if(strings[mid].isEmpty())
        {
            int left = mid - 1;
            int right = mid + 1;
            while(true)
            {
                if(left < low && right > high)
                    return -1;
                else if(right <= high && !strings[right].isEmpty())
                {
                    mid = right;
                    break;
                }
                else if(left >= low && !strings[left].isEmpty())
                {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }        
        }
        if(str.equals(strings[mid]))
            return mid;
        else if(strings[mid].compareTo(str) < 0)
            return search(strings, str, mid+ 1, high);
        else
            return search(strings, str, low, mid - 1);
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
