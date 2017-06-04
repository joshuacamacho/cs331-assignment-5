/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs331.assignment.pkg5;

import java.util.ArrayList;

/**
 *
 * @author Josh
 */
public class Cs331Assignment5 {
    
    public static class Node{
        String name="";
        int time=0;
        int ES=0;
        int EF=0;
        int LS=0;
        ArrayList<Node> successors;
        ArrayList<Node> predecessors;
        
        Node(String n, int t){
            name = n;
            time = t;
            successors = new ArrayList<Node>();
            predecessors = new ArrayList<Node>();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node T[]={
            new Node("n1",100),
            new Node("n2",102),
            new Node("n3",52),
            new Node("n4",200),
            new Node("n5",87),
            new Node("n6",500)
        };
        
        int G[][]={
            {0,1,1,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,1,0},
            {0,0,0,0,0,1},
            {0,0,0,0,0,1},
            {0,0,0,0,0,0},
        };
        
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(G[i][j]==1){
                    T[i].successors.add(T[j]);
                    T[j].predecessors.add(T[i]);
                }
            }
        }
    }
    
}
