package recursion.and.dynamic.programming;

import java.util.*;
/**
 *
 * @author liron
 * You have a stack of n boxes, with widths w1 , heights h i, and depths di.
 * The boxes cannot be rotated and can only be stacked on top of one another 
 * if each box in the stack is strictly larger than the box above it in width,
 * height, and depth. Implement a method to compute the height of the tallest 
 * possible stack. The height of a stack is the sum of the heights of each box.
 */
public class StackOfBoxes {
    
    public static class Box
    {
        private int width, depth, height;
        
        public Box(int w, int d, int h)
        {
           width = w; depth = d; height = h; 
        }
        
        public boolean canPlaceAbove(Box b)
        {
            return b == null ||
                    (this.width < b.width &&
                    this.depth < b.depth &&
                    this.height < b.height);
        }
        
        @Override
        public String toString()
        {
            return "(" + width + ", " + depth + ", " + height + ")";
        }
    }
    
    public static ArrayList<Box> buildTallestStack(Box[] boxes)
    {
        if(boxes == null) return null;
        return buildTallestStack(boxes, null);
    }
    
    private static ArrayList<Box> buildTallestStack(Box[] boxes, Box bottom)
    {
        int maxHeight = 0;
        ArrayList<Box> maxStack = null;
        for(Box box : boxes)
            if(box.canPlaceAbove(bottom))
            {
                ArrayList<Box> boxStack = buildTallestStack(boxes, box);
                int height = getStackHeight(boxStack);
                if(height > maxHeight)
                {
                    maxHeight = height;
                    maxStack = boxStack;
                }
            }
        if(maxStack == null) maxStack = new ArrayList<Box>();
        if(bottom != null) maxStack.add(0, bottom);
        return maxStack;
    }
    
    private static int getStackHeight(List<Box> boxes)
    {
        int height = 0;
        for(Box b : boxes) height += b.height;
        return height;
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        Box[] boxes = {
            new Box(1, 7, 4),
            new Box(2, 6, 9),
            new Box(4, 9, 6),
            new Box(10, 12, 8),
            new Box(6, 2, 5),
            new Box(3, 8, 5),
            new Box(5, 7, 7),
            new Box(2, 10, 16),
            new Box(12, 15, 9),
        };
        System.out.println(StackOfBoxes.buildTallestStack(boxes));
    
    }
    */
}
