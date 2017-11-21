
package math.and.logic.puzzles;

import java.util.*;

/**
 *
 * @author liron
 * You have 20 bottles of pills. 19 bottles have 1.0 gram pills, 
 * but one has pills of weight 1.1 grams. 
 * Given a scale that provides an exact measurement, 
 * how would you find the heavy bottle?
 * You can only use the scale once.
 */
public class TheHeavyPill {
    
    public static double findPill(double[] bottles)
    {
        double sum = 0;
        for(int i = 0; i < bottles.length; i++)
            sum += bottles[i]*(i +1);
        return (sum - 210)/0.1;
    }

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
        Random rand = new Random();
        int Heavybottle = rand.nextInt(20);
        double[] bottles = new double[20];
        Arrays.fill(bottles, 1);
        for(int i =0; i < 20; i++)
            if(i == Heavybottle)
                bottles[i] = 1.1;    
        System.out.println("Heavier pills are in bottle " + (int)findPill(bottles));
   
    
    }
    */
}
