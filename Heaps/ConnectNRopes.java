package Heaps;

import java.util.PriorityQueue;

public class ConnectNRopes {

    public static void main(String[] args) {

        // min length -> ropes add

        int[] ropes = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) {
            pq.add(rope);
        }

        int cost = 0;
        while(pq.size() > 1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }
        System.out.println("Cost of connecting N ropes : "+cost);
    }

}
