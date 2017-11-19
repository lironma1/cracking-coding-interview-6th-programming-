
package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 * Route Between Nodes: Given a directed graph,
 * design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes {
    
    //Route Between Nodes Recursive DFS search method.
    public static boolean DFSRecursive(GraphNode Snode, GraphNode Tnode)
    {
       if(Snode == null || Tnode == null) return false;  
       Snode.isVisited = true;
       if(Snode == Tnode) return true;
       for(GraphNode child : Snode.adjacent)
           if(!child.isVisited)
               if(DFSRecursive(child,Tnode)) return true;
       return false;
    }
    
    //Route Between Nodes Iterative DFS search method.
    public static boolean DFSIterative(GraphNode Snode, GraphNode Tnode)
    {
        if(Snode == null || Tnode == null) return false;
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.push(Snode);
        while(!stack.isEmpty())
        {
            GraphNode node = stack.pop();
            if(!node.isVisited)
            {
                node.isVisited = true;
                if(node  == Tnode) return true;
                stack.addAll(node.adjacent);
            }
        }
        return false;
    }
    
    
    
    public static boolean BFS(GraphNode Snode, GraphNode Tnode) 
    {
        if (Snode == null || Tnode == null) return false;
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(Snode);
        while (!queue.isEmpty()) {
            GraphNode node = queue.remove();
            if (!node.isVisited) {
                node.isVisited = true;
                if (node == Tnode) return true;
                queue.addAll(node.adjacent);
            }
        }
        return false;
    }
    
    public static void resetVisited(GraphNode... nodes) 
    {
        for (GraphNode n : nodes) n.isVisited = false;
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        // 1->2
        // | /|
        // v/ |
        // v  v
        // 3->4
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        
        n1.adjacent.add(n2);n1.adjacent.add(n3);
        n2.adjacent.add(n3);n2.adjacent.add(n4);
        n3.adjacent.add(n4);
             
        System.out.println(DFSRecursive(n2, n4)); resetVisited(n1, n2, n3, n4);
        System.out.println(DFSIterative(n2, n4)); resetVisited(n1, n2, n3, n4);
        System.out.println(BFS(n2, n4));          resetVisited(n1, n2, n3, n4);
        System.out.println(DFSRecursive(n4, n1)); resetVisited(n1, n2, n3, n4);
        System.out.println(DFSIterative(n4, n1)); resetVisited(n1, n2, n3, n4);
        System.out.println(BFS(n4, n1));          resetVisited(n1, n2, n3, n4);    
    
    }
    */
}
