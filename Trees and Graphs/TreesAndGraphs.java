package trees.and.graphs;

import java.util.*;
/**
 *
 * @author liron
 */
public class TreesAndGraphs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * 1->2
         * | /|
         * v/ |
         * v  v
         * 3->4
         */
        
        GraphNode gn1 = new GraphNode(1);
        GraphNode gn2 = new GraphNode(2);
        GraphNode gn3 = new GraphNode(3);
        GraphNode gn4 = new GraphNode(4);
        
        gn1.adjacent.add(gn2);gn1.adjacent.add(gn3);
        gn2.adjacent.add(gn3);gn2.adjacent.add(gn4);
        gn3.adjacent.add(gn4);
        
        RouteBetweenNodes obj = new RouteBetweenNodes();
        
        System.out.println(obj.DFSRecursive(gn2, gn4)); obj.resetVisited(gn1, gn2, gn3, gn4);
        System.out.println(obj.DFSIterative(gn2, gn4)); obj.resetVisited(gn1, gn2, gn3, gn4);
        System.out.println(obj.BFS(gn2, gn4));          obj.resetVisited(gn1, gn2, gn3, gn4);
        System.out.println(obj.DFSRecursive(gn4, gn1)); obj.resetVisited(gn1, gn2, gn3, gn4);
        System.out.println(obj.DFSIterative(gn4, gn1)); obj.resetVisited(gn1, gn2, gn3, gn4);
        System.out.println(obj.BFS(gn4, gn1));          obj.resetVisited(gn1, gn2, gn3, gn4);

        
        TreeNode.printTree(MinimalTree.createBST(new int[] {}));
        System.out.println();

        TreeNode.printTree(MinimalTree.createBST(new int[] {0}));
        System.out.println();

        TreeNode.printTree(MinimalTree.createBST(new int[] {0,1}));
        System.out.println();

        TreeNode.printTree(MinimalTree.createBST(new int[] {0,1,2,3,4}));
        System.out.println();
        
        TreeNode.printTree(MinimalTree.createBST(new int[] {-1,0,1,3,4,7,9}));
        System.out.println("-----------------------------------------------");
        
        //
        //     4
        //    / \
        //   1   5
        //  / \   \
        // 2   3   7
        //      \
        //       6
       
        TreeNode node1 = new TreeNode(1), node2 = new TreeNode(3),
                node3 = new TreeNode(5), root = new TreeNode(4);
        node1.left = new TreeNode(2); node1.right = node2;
        node2.right = new TreeNode(6);
        root.left = node1; root.right = node3;
        node3.right = new TreeNode(7);
        TreeNode.printTree(root);
        System.out.println();
       
        System.out.println("createLevelLinkedList:");
        ArrayList<LinkedList<TreeNode>> levels = ListOfDepths.createLevelLinkedList(root);
       
        for (LinkedList<TreeNode> level : levels) {
           for (TreeNode node : level) 
                 System.out.print(node + " ");
           System.out.println();
        }
        
        System.out.println("createLevelLinkedList2:");
        levels = ListOfDepths.createLevelLinkedList2(root);
        for (LinkedList<TreeNode> level : levels) {
            for (TreeNode node : level)
                  System.out.print(node + " ");
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
        
        //     4
        //    / \
        //   1   5
        //  / \
        // 2   3
         
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(3), r = new TreeNode(4);
        n1.left = new TreeNode(2); n1.right = n2;
        r.left = n1; r.right = new TreeNode(5);
        TreeNode.printTree(r);
        System.out.println(CheckBalanced.isBalanced(r) + " ");
        System.out.println(CheckBalanced.isBalanced2(r));
         

        //     4
        //    / \
        //   1   5
        //  / \
        // 2   3
        //      \
        //       6

        n2.right = new TreeNode(6);
        TreeNode.printTree(r);
        System.out.println(CheckBalanced.isBalanced(r) + " ");
        System.out.println(CheckBalanced.isBalanced2(r));
        System.out.println("-----------------------------------------------");
         
        //     4
        //    / \
        //   2   5
        //  / \
        // 1   3
         
        TreeNode tn1 = new TreeNode(2), tn2 = new TreeNode(3), 
                troot = new TreeNode(4);
        tn1.left = new TreeNode(1); tn1.right = tn2;
        troot.left = tn1; troot.right = new TreeNode(5);
        TreeNode.printTree(troot);
        System.out.println(ValidateBST.isBST(troot)); 
        System.out.println("-----------------------------------------------");
        

        //     4
        //    / \
        //   2   5
        //  / \
        // 1   3


        n1 = new TreeNode(1); n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3), n4 = new TreeNode(4),
                n5 = new TreeNode(5);
        n2.left = n1; n2.right = n3; n1.parent = n2; n3.parent = n2;
        n4.left = n2; n4.right = n5; n2.parent = n4; n5.parent = n4;
        TreeNode.printTree(n4);
        TreeNode n = n4;
        
        System.out.print("pre-order:  ");

        while (n != null) 
        {
            System.out.print(n + " ");
            n = Successor.preorderSuccessor(n);
        }
        
        System.out.print("\nin-order:   ");
        n = n1;
        
        while (n != null)
        {
            System.out.print(n + " ");
            n = Successor.inorderSuccessor(n);
        }
        
        System.out.print("\npost-order: ");
        n = n1;
        
        while (n != null) 
        {
            System.out.print(n + " ");
            n = Successor.postorderSuccessor(n);
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
        
        ArrayList<Projects> projects = new ArrayList<>();
        
        Projects a = new Projects('a'), b = new Projects('b'),
                c = new Projects('c'), d = new Projects('d'),
                e = new Projects('e'), f = new Projects('f');
        
        projects.add(a); projects.add(b); projects.add(c); projects.add(d);
        projects.add(e); projects.add(f);
          
        a.addDependency(f); b.addDependency(f); c.addDependency(d);
        d.addDependency(a); d.addDependency(b);
        
        System.out.println(BuildOrder.isBuildOrder(projects));
        System.out.println("-----------------------------------------------");
        

        //     4
        //    / \
        //   2   5
        //  / \   \
        // 1   3   7
        //    /
        //   6

        n1 = new TreeNode(1); n2 = new TreeNode(2); n3 = new TreeNode(3);
        n4 = new TreeNode(4); n5 = new TreeNode(5);        
        TreeNode n6 = new TreeNode(6), n7 = new TreeNode(7);
        
        n2.left = n1; n2.right = n3; n4.left = n2; n4.right = n5; n3.left = n6;
        n5.right = n7;
         
        TreeNode.printTree(n4);
        System.out.println();
        
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s", 
                n1, n6, FirstCommonAncestor.firstCommonAncestor(n4, n1, n6)));
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s",
                n1, n7, FirstCommonAncestor.firstCommonAncestor(n4, n1, n7)));
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s",
                n4, n5, FirstCommonAncestor.firstCommonAncestor(n4, n4, n5)));
        System.out.println(String.format("FirstCommonAncestor of %s, %s: %s",
                n5, n5, FirstCommonAncestor.firstCommonAncestor(n4, n5, n5)));
        System.out.println("-----------------------------------------------");
        
        root = new TreeNode(10);
        root.left = new TreeNode(5);    
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        
        ArrayList<LinkedList<Integer>> allSequencesList = 
                new ArrayList<LinkedList<Integer>>();
        allSequencesList = BSTSequences.allSequences(root);
        for(LinkedList<Integer> sequences : allSequencesList )
            System.out.println(Arrays.deepToString(sequences.toArray())); 
        System.out.println("-----------------------------------------------");
        
        
        //     4
        //    / \
        //   2   5
        //  / \   \
        // 1   3   7
        //    /
        //   6
        
        n1 = new TreeNode(1); n2 = new TreeNode(2); n3 = new TreeNode(3);
                 n4 = new TreeNode(4); n5 = new TreeNode(5); 
                 n6 = new TreeNode(6);n7 = new TreeNode(7);
                      
        n2.left = n1; n2.right = n3; n4.left = n2; n4.right = n5; n3.left = n6;
        n5.right = n7;
        
        TreeNode.printTree(n4);
        System.out.println();
        System.out.println(CheckSubtree.isSubtree(n4, n2));
        System.out.println(CheckSubtree.isSubtree(n2, n5));
        System.out.println("-----------------------------------------------");
        

        //     4
        //    / \
        //   5   2
        //  / \   \
        // 1   3   7
        // \   /  /
        //  8 6  9

        n1 = new TreeNode(1); n2 = new TreeNode(2); n3 = new TreeNode(3);
        n4 = new TreeNode(4); n5 = new TreeNode(5); n6 = new TreeNode(6);
        n7 = new TreeNode(7); 
        TreeNode n8 = new TreeNode(8), n9 = new TreeNode(9);
        
        n4.left = n5; n4.right = n2; n5.left = n1; n5.right = n3; n1.right = n8;
        n3.left = n6; n2.right = n7; n7.left = n9;
        
        TreeNode.printTree(n4);
        System.out.println();
        LinkedList<LinkedList<TreeNode>> result = 
                PathsWithSum.findSumPaths(n4, 9);
        PathsWithSum.printResult(result);
        result = PathsWithSum.findSumPaths(n4, 6);
        PathsWithSum.printResult(result);


        
        

    }
}
