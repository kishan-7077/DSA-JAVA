package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCities {

    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph,int[][] arr){
        for(int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length;j++){
                if(arr[i][j] == 0){
                    continue;
                }
                int u = i;
                int v = j;
                int wt = arr[i][j];

                graph[i].add(new Edge(u,v,wt));
            }
        }
    }

    public static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost-o.cost;
        }
    }

    public static int connectingCities(int[][] arr,int n){
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph,arr);

        int finalCost = 0;
        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));

        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost+= curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }

        return finalCost;
    }


    public static void main(String[] args) {
        int[][] cities = {{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,3,0,0},{4,7,0,0,0}};
        System.out.println(connectingCities(cities,5));

    }
}
