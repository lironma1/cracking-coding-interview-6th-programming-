package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 * You are given a list of projects and a list of dependencies 
 * (which is a list of pairs of projects, 
 * where the second project is dependent on the first project). 
 * All of a project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built. 
 * If there is no valid build order, return an error.
 */
public class BuildOrder {
    
    public static String isBuildOrder(ArrayList<Projects> projects)
    {
        if(projects == null || projects.isEmpty()) 
            throw new IllegalArgumentException();
        
        ArrayList<Character> output = new ArrayList<>();
        int invalidCount = 0;
        
        // add the project names without dependencies to the output
        
        for(int i = 0; i < projects.size(); ++i) 
            if(projects.get(i).dependencies.isEmpty() && projects.get(i).inValidate == false) 
            {
                output.add(projects.get(i).name);
                projects.get(i).inValidate = true;
                invalidCount++;
            }
        
        
        // keep track of the project dependencies
        boolean flag = false;
        
               // sort out the dependencies

        while(true) {
            for(Projects p : projects) 
                if(p.inValidate == false && !p.dependencies.isEmpty()) {
                    flag = false;
                    for (int i = 0; i < p.dependencies.size(); ++i) 
                        if (output.contains(p.dependencies.get(i).name)) 
                            flag = true;
                    if(flag) {
                        output.add(p.name);
                        p.inValidate = true;
                        invalidCount++;
                    }
                }         
            if(invalidCount == projects.size()) 
                break;
        }
        
        return output.toString();  
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        
    
        ArrayList<Projects> projects = new ArrayList<>();
   
        Projects a = new Projects('a'), b = new Projects('b'),
                c = new Projects('c'), d = new Projects('d'),
                e = new Projects('e'), f = new Projects('f');
        
        projects.add(a); projects.add(b); projects.add(c); projects.add(d);
        projects.add(e); projects.add(f);
          
        a.addDependency(f); b.addDependency(f); c.addDependency(d);
        d.addDependency(a); d.addDependency(b);
        
        System.out.println(isBuildOrder(projects));
    }
    */
}
