package sorting.and.searching;

/**
 *
 * @author liron
 * Given an M x N matrix in which each row and each column is sorted in
 * ascending order, write a method to find an element.
 */
public class SortedMatrixSearch {
    
    /**
     * Naive Solution
     * do binary search on every row to find the element
     * time complexity O(log n)
     * @param matrix
     * @param elem
     * @return 
     */
    public static int[] findElement(int[][] matrix, int elem)
    {
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0)
        {
            if(matrix[row][col] == elem)
                return new int[] {row, col};
            else if(matrix[row][col] > elem)
                col--;
            else
               row++;
        }
        return new int[] {-1, -1};
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
