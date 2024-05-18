package Graphs;

import java.util.ArrayList;

public class DFS extends BFS{


    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        // visit
        System.out.print(curr+ " ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,e.dest,vis);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i< graph.length; i++){
            dfsUtil(graph,i,vis);
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];
        dfs(graph);

    }


}
