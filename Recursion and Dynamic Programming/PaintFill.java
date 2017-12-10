package recursion.and.dynamic.programming;
import java.util.*;
/**
 *
 * @author liron
 * Implement the "paint fill" function that one might  see on 
 * many image editing programs. That is, 
 * given a screen (represented by a two-dimensional array of colors), a point, 
 * and a new color, fill in the surrounding area until 
 * the color changes from the original color.
 */
public class PaintFill {
    
    enum Color {Black, White, Red, Yellow, Green}
    
    public static void paintFill(Color[][] screen, int r, int c, Color newColor)
    {
        if(r < 0 || c < 0 || r > screen.length - 1 || c > screen[0].length - 1)
            return;
        if(screen == null || newColor == null || screen[r][c] == newColor)
            return;
        paintFill(screen, r, c, screen[r][c], newColor);
    }
    
    private static void paintFill(Color[][] screen, int r, int c,
            Color oldColor, Color newColor)
    {
        if(r < 0 || c < 0 || r > screen.length - 1 || c > screen[0].length - 1)
            return;
        if(screen[r][c] == oldColor)
        {
           screen[r][c] = newColor;
           paintFill(screen, r + 1, c, oldColor, newColor);
           paintFill(screen, r - 1, c, oldColor, newColor);
           paintFill(screen, r, c + 1, oldColor, newColor);
           paintFill(screen, r, c - 1, oldColor, newColor);
        }
    }
    
    private static void printScreen(Color[][] screen) 
    {
        for (Color[] row : screen) {
            for (Color c : row)
                 System.out.print(c);
             System.out.println();
        }
         System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {        
        // ______c
        // |RRGBR
        // |RGGGR
        // |RRGBG
        // |RBGGG
        // |GRGBG
        // r
        Color[][] screen = 
        {{Color.Red, Color.Red, Color.Green, Color.Black, Color.Red},
         {Color.Red, Color.Green, Color.Green, Color.Green, Color.Red},
         {Color.Red, Color.Red, Color.Green, Color.Black, Color.Green},
         {Color.Red, Color.Black, Color.Green, Color.Green, Color.Green},
         {Color.Green, Color.Red, Color.Green, Color.Black, Color.Green}};
        
        printScreen(screen);
        paintFill(screen, 1, 1, Color.Green);
        printScreen(screen);
        paintFill(screen, 100, 100, Color.Green);
        printScreen(screen);
        paintFill(screen, 1, 1, Color.Black);
        printScreen(screen);
    }
    */
}
