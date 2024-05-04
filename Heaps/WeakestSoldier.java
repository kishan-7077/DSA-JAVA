package Heaps;

import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Rows implements Comparable<Rows>{
        int idx;
        int soldierCount;

        public Rows(int idx, int soldierCount) {
            this.idx = idx;
            this.soldierCount = soldierCount;
        }

        @Override
        public int compareTo(Rows o) {
            if (this.soldierCount == o.soldierCount){
                return this.idx - o.idx;
            }
            return this.soldierCount - o.soldierCount;
        }
    }

    public static int countSoldiers(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] soldiers = {"1000","1111","1000","1000"};
        int size = soldiers.length;
        PriorityQueue<Rows> ans = new PriorityQueue<>();
        for(int i=0; i<size; i++){
            ans.add(new Rows(i, countSoldiers(soldiers[i])));
        }

        int k=2;
        System.out.print("Row Containing weakest soldiers : ");
        for(int i=0; i < k; i++){
            System.out.print("R"+ans.remove().idx+" ");
        }
    }

}
