package Graphs;

import java.util.ArrayList;

public class HasPath extends BFS{

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest,boolean[] vis){
        if(src==dest){
            return true;
        }

        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph,e.dest,dest,vis)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(hasPath(graph,0,5,new boolean[V]));

    }
}
