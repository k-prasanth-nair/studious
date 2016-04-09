package com.ds.graph;

import com.ds.qs.Stack;

import java.util.ArrayList;

/**
 * Created by prasanth on 10/3/16.
 */
public class DepthFirstSearch {

    // mark the visited node
    private boolean[] marked;

    //to keep track the edge from sourceVertex to Vertex
    private int[] edgeTo;

    private int s;

    public DepthFirstSearch(Graph G, int sourceVertex){

        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        s = sourceVertex;

        dfs(G,sourceVertex);

    }


    private void dfs(Graph G,int v){

        marked[v] = true;
        ArrayList<Integer> oVertices = G.getVertices()[v];
        for(int vertice:oVertices){
            if( !marked[vertice]){
                dfs(G,vertice);
                edgeTo[vertice] = v;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }


    public String pathTo(int v){

        if(!hasPathTo(v)) return null;

        StringBuilder path = new StringBuilder();

        for(int x=v;x!=s;x=edgeTo[x])
            path.append(x).append("-->");
        path.append(s);

        return path.toString();
    }



}
