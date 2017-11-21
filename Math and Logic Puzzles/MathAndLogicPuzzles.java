package math.and.logic.puzzles;

import java.util.*;
/**
 *
 * @author liron
 */
public class MathAndLogicPuzzles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random rand = new Random();
        int Heavybottle = rand.nextInt(20);
        double[] bottles = new double[20];
        Arrays.fill(bottles, 1);
        for(int i =0; i < 20; i++)
            if(i == Heavybottle)
                bottles[i] = 1.1;
        
        System.out.println("Heavier pills are in bottle " + (int)TheHeavyPill.findPill(bottles));
   
    }
    
}
