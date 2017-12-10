package recursion.and.dynamic.programming;

import java.util.*;
/**
 *
 * @author liron
 * Write an algorithm to print all ways of arranging 
 * eight queens on an 8x8 chess board so that none of them share the same row, 
 * column, or diagonal. In this case, "diagonal" means all diagonals, 
 * not just the two that bisect the board.
 */
public class EightQueens {
    
    public static ArrayList<int[]> placeQueens(int gridSize)
    {
        ArrayList<int[]> result = new ArrayList<int[]>();
        placeQueens(0, new int[gridSize],result, gridSize);
        return result;
    }
    
    private static void placeQueens(int row, int[] solution, 
            ArrayList<int[]> solutions, int gridSize)
    {
        if(row == gridSize)
        {
            solutions.add(solution.clone());
            return;
        }
        for(int col = 0; col < gridSize; col++)
            if(checkValid(row, col,solution))
            {
                solution[row] = col;
                placeQueens(row + 1, solution, solutions, gridSize);
            }
    }
    
    private static boolean checkValid(int row, int col, int[] solution)
    {
        for(int prevRow = 0; prevRow < row; prevRow++)
        {
            if(col == solution[prevRow]) return false;
            if(row - prevRow == Math.abs(col - solution[prevRow])) return false;
        }
        return true;
    }
    
    public static void printSolution(ArrayList<int[]> solutions)
    {
        for(int[] solution : solutions)
        {
            for(int i : solution)
                 System.out.print(i + " ");
            System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        printSolution(placeQueens(8));
    }
    */
    
}
