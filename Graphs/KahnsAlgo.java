package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Topological sort Using BFS -> kahn's Algo
public class KahnsAlgo extends TopologicalSortUsingDFS{

    public static void calcInDeg(ArrayList<Edge>[] graph, int[] inDeg){
        for(int i=0; i<graph.length; i++){
            int v = i;
            for(int j=0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int[] inDeg = new int[graph.length];
        calcInDeg(graph,inDeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<inDeg.length; i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" "); // topSort print

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest] ==0){
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        topSort(graph);
    }

}
