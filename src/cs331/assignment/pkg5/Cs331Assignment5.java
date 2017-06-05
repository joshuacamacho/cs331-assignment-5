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
    public static Node head;
    public static Node tail;
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
        head = T[0];
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(G[i][j]==1){
                    T[i].successors.add(T[j]);
                    T[j].predecessors.add(T[i]);
                }
            }
        }
        
        evalEf(head);
        
        System.out.println("hi");
    }
    
    public static void evalEf(Node n){
        if(n.predecessors.size()>0){
            n.ES= findMaxPredecessors(n);
            n.EF= n.time + n.ES;
        }else{
            n.ES = 0;
            n.EF = n.time;
        }
        
        for(int i=0; i<n.successors.size(); i++){
            evalEf(n.successors.get(i));
        }
        
        if(n.successors.size()==0) tail = n;
    }
    
    public static void evalLf(Node n){
        if(n.successors.size()>0){
            //not end
        }else{
            //we're at the end
            //n.EF
        }
    }
    
    private static int findMaxPredecessors(Node n) {
        int max=0;
        for(int i=0; i<n.predecessors.size(); i++){
            if(max<n.predecessors.get(i).EF){
                max=n.predecessors.get(i).EF;
            }
        }
        return max;
    }
}
