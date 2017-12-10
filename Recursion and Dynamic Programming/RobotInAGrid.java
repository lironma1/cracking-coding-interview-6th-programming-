package recursion.and.dynamic.programming;

import java.awt.Point;
import java.util.*;
/**
 *
 * @author liron
 */
public class RobotInAGrid {
    
    //Time Complexity of O(n^r+c), r = row, c = col. 
    public static ArrayList<Point> getPath(boolean[][] maze)
    {
        if(maze== null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        if(getPath(maze, maze.length - 1, maze[0].length - 1, path))
            return path;
        return null;
    }
    
    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path)
    {
        // If out of bounds or not available. return false.
        if(col < 0 || row < 0 || !maze[row][col]) return false;
        
        boolean isAtOrigin = (row == 0) && (col == 0);
        
        // if there's a path from the start to here, add my location.
        if(isAtOrigin || getPath(maze, row, col - 1, path) ||
                getPath(maze,row -1, col, path)){
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Point> getPathDP(boolean[][] maze)
    {
         if(maze== null || maze.length == 0) return null;
         ArrayList<Point> path = new ArrayList<Point>();
         HashSet<Point> failedPoints = new HashSet<Point>();
         if(getPathDP(maze, maze.length - 1, maze[0].length - 1, path, failedPoints))
             return path;
         return null;
    }
    
    private static boolean getPathDP(boolean[][] maze, int row, int col, 
            ArrayList<Point> path, HashSet<Point> failedPoints){
        
         // If out of bounds or not available. return false.
        if(col < 0 || row < 0 || !maze[row][col]) return false;
        
        Point p = new Point(row, col);
        
        // is we've already visited this cell, return false;
        if(failedPoints.contains(p)) return false;
        
        boolean isAtOrigin = (row == 0) && (col == 0);
        
         // if there's a path from the start to here, add my location.
        if(isAtOrigin || getPathDP(maze, row, col - 1, path, failedPoints) ||
                getPathDP(maze,row -1, col, path, failedPoints)){
            path.add(p);
            return true;
        }
        failedPoints.add(p); // Cache result
        return false;
    }
    

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        boolean[][] map = {{true, true, false, true},
            {true, true, true, true},
            {true, false, true, true},
            {true, true, false, true}};
        
        System.out.println(getPath(map));
        System.out.println(getPathDP(map));
    }
    */
}
