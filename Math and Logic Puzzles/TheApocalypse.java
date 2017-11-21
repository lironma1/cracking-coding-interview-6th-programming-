package math.and.logic.puzzles;

import java.util.*;

/**
 *
 * @author liron
 * In the new post-apocalyptic world, the world queen is desperately concerned 
 * about the birth rate. Therefore, she decrees that all families 
 * should ensure that they have one girl or else they face massive fines. 
 * If all families abide by this policy-that is, 
 * they have continue to have children until they have one girl, 
 * at which point they immediately stop-what will the gender ratio 
 * of the new generation be? 
 * (Assume that the odds of someone having a boy or a girl 
 * on any given pregnancy is equal.) 
 * Solve this out logically and then write a computer simulation of it.
 */
public class TheApocalypse {
    
    public static double runNFamiles(int n)
    {
        int boys = 0, girls = 0;
        for(int i = 0; i < n; i++)
        {
            int[] genders = runOneFamily();
            girls += genders[0];
            boys += genders[1];
        }
        return girls/ (double) (boys + girls);
    }
    
    private static int[] runOneFamily()
    {
        Random random = new Random();
        int boys = 0, girls = 0;
        while(girls == 0)
        {
            if(random.nextBoolean())
                girls++;
            else
                boys++;
        }
        int[] genders = {girls,boys};
        return genders;
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
