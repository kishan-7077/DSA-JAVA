package Hashing;

import java.util.HashSet;

public class CountDistinctElements {

    public static void main(String[] args) {
        int[] num = {4,3,2,5,6,7,4,2,1};
        HashSet<Integer> set = new HashSet<>();

        for(Integer i : num){
            set.add(i);
        }
        System.out.println(set);

        System.out.println(set.size());
    }
}
