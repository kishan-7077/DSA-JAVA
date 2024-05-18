package Graphs;

import java.util.AbstractList;
import java.util.ArrayList;

public class CycleInGraph {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(AbstractList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
//        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

//        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static boolean detectCycle(AbstractList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if (detectCycleUtil(graph,vis,i,-1)){
                    return true;
                    // cycle exists in one of the part
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(AbstractList<Edge>[] graph,boolean[] vis,int curr,int parent){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // case 3
            if(!vis[e.dest]){
                if (detectCycleUtil(graph,vis,e.dest,curr))
                    return true;
            }
            // case 1
            else if (vis[e.dest] && e.dest!=parent) {
                return true;
            }
            // case 2 -> do nothing -> continue
        }

        return false;
    }

    public static void main(String[] args) {
        /*
                 0----------3
                /|	        |
               / |          |
              /  |          |
             1   |          4
	         \   |
   	          \  |
   	           \ |
                 2
        */

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(detectCycle(graph));
    }

}
