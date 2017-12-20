/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.and.searching;

/**
 *
 * @author liron
 */
public class RankNode {
    
    public int left_size = 0;
    public RankNode left, right;
    public int data = 0;
    
    public RankNode(int data)
    {
        this.data = data;
    }
        
    public void insert(int data)
    {
        if(data <= this.data)
        {
            if(left != null) left.insert(data);
            else left = new RankNode(data);
            left_size++;
        }
        else
        {
            if(right != null) right.insert(data);
            else right = new RankNode(data);
        }
    }

    public int getRank(int data)
    {
        if(data == this.data) return left_size;
        else if(data < this.data)
        {
            if(left == null) return -1;
            else return left.getRank(data);
        }
        else
        {
            int right_rank = right == null ? -1 : right.getRank(data);
            if(right_rank == -1) return -1;
            else return left_size + 1 + right_rank;
        }
    }
}
