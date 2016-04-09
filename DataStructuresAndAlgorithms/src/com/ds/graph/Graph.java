package com.ds.graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by prasanth on 10/3/16.
 */
public class Graph {


    private static final String NEWLINE = System.getProperty("line.separator");

    //no of vertices
    private final int V;

    private int totalEdges;

    //adjacency list
    private ArrayList<Integer>[] adj;


    public Graph(int V){
        this.V = V;
        adj = new  ArrayList[V];
        for(int v=0;v<V;v++){
            adj[v] = new ArrayList<Integer>();
        }
    }


    public int getV(){return this.V;}



    //vertex and edge
    public void addEdge(int v, int w){

        validateVertex(v);
        validateVertex(w);
        totalEdges++;
        adj[v].add(w);
        adj[w].add(v);

    }


    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }


    public ArrayList<Integer>[] getVertices(){
        return adj;
    }

    public Iterator<Integer> edges(int v){
        validateVertex(v);
        return adj[v].iterator();
    }


    public int degree(int v){
        validateVertex(v);
        int degree=0;

        for(int n:adj[v]){
            degree++;
        }

        return degree;

    }

    public int maxDegree(){

        int max = 0;
        for(int i=0;i<V;i++){
            int degree = degree(i);
            if( degree > max)
                max = degree;
        }
        return max;
    }


    public int numberOfSelfLoops(){
        int loop = 0;
        for(int i=0;i<V;i++){
            for(int n:adj[i]){
                if(n == i) loop++;
            }
        }
        return loop/2; //each edge counted twice
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + totalEdges + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }



    public static void main(String[] args)throws InterruptedException{

        Graph oGraph = new Graph(13);
        oGraph.addEdge(0,1);
        oGraph.addEdge(0,6);
        oGraph.addEdge(0,2);
        oGraph.addEdge(0,5);

        oGraph.addEdge(6,4);

        oGraph.addEdge(4,3);
        oGraph.addEdge(4,5);


        oGraph.addEdge(7,8);


        oGraph.addEdge(9,10);
        oGraph.addEdge(9,12);
        oGraph.addEdge(9,11);

        oGraph.addEdge(11,12);


        System.out.println( oGraph );

        DepthFirstSearch odfs=new DepthFirstSearch(oGraph,0);

        System.out.println(  odfs.pathTo(4) );



        Graph oNewGraph = new Graph(6);

        oNewGraph.addEdge(0,1);
        oNewGraph.addEdge(0,2);
        oNewGraph.addEdge(0,5);
        oNewGraph.addEdge(1,2);

        oNewGraph.addEdge(2,4);
        oNewGraph.addEdge(2,3);

        oNewGraph.addEdge(3,5);

        System.out.println( oNewGraph );

        DepthFirstSearch odfs1=new DepthFirstSearch(oNewGraph,0);

        System.out.println(  odfs1.pathTo(4) );

        BreadthFirstSearch bfs= new BreadthFirstSearch(oNewGraph,0);

        System.out.println(  bfs.pathTo(4) );


    }


}
