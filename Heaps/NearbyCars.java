package Heaps;

import java.util.PriorityQueue;

public class NearbyCars {

    static class Cars implements Comparable<Cars>{
        int x;
        int y;
        int distance;
        int idx;
        Cars(int x, int y, int distance, int idx){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.idx = idx;
        }

        public int  distance(){
            distance = (int) (Math.pow(x,2) + Math.pow(y,2));
            return distance;
        }

        @Override
        public int compareTo(Cars o) {
            return this.distance - o.distance;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Cars> ans = new PriorityQueue<>();

        int[][] pts = {{3,3} , {5,-1} , {-2,4}};
        int k =2;

        for(int i=0; i<pts.length; i++){
            int distSq = (int) (Math.pow(pts[i][0],2) + Math.pow(pts[i][1],2));
            ans.add(new Cars(pts[1][0], pts[i][1], distSq, i));
        }

        // nearest k cars
        for(int i=0; i<k; i++){
            System.out.println("C" + ans.remove().idx);
        }

    }

}
