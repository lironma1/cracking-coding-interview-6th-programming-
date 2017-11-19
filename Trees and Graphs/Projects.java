package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 */
public class Projects {
    
    char name;
    boolean inValidate = false;
    ArrayList<Projects> dependencies = new ArrayList<>();
    
    protected Projects(char name)
    {
        this.name = name;
    }
    
    protected void addDependency(Projects project)
    {
        this.dependencies.add(project);
    }
    
}
