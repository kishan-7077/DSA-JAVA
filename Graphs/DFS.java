package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class DFS extends BFS{


    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        // visit
        System.out.print(curr+ " ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];
        dfs(graph,0,vis);

    }


}
